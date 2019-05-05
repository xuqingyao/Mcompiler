package com.echo.compiler.frontend;

import com.echo.compiler.IR.BasicBlock;
import com.echo.compiler.IR.Func;
import com.echo.compiler.IR.IRGlobalVar;
import com.echo.compiler.IR.IRRoot;
import com.echo.compiler.IR.Inst.*;
import com.echo.compiler.IR.Register.*;
import com.echo.compiler.Symbol.*;
import com.echo.compiler.ast.DeclNode.*;
import com.echo.compiler.ast.ExprNode.*;
import com.echo.compiler.ast.Node;
import com.echo.compiler.ast.ProgramNode;
import com.echo.compiler.ast.StatNode.*;
import com.echo.compiler.ast.TypeNode.*;

import java.util.ArrayList;
import java.util.List;

public class IRBuilder extends SymbolTableBuilder{
    public SymbolTable currentSymbolTable, globalSymbolTable;
    public BasicBlock currentBB = null;
    public BasicBlock currentLoopStepBB, currentLoopAfterBB;
    public Func currentFunction = null;
    public String currentClassName = null;
    public IRRoot ir = new IRRoot();
    public List<IRGlobalVar> globalVarInitList = new ArrayList<>();
    public boolean isFuncArgDecl = false, wantAddr = false, assignLhs = false, uselessStatic = false;

    public IRBuilder(SymbolTable globalSymbolTable){
        this.globalSymbolTable = globalSymbolTable;
    }

    private FuncDeclNode AddVarFunc(ProgramNode node){
        for (DeclNode declNode : node.getDecls()) {
            if (declNode instanceof FuncDeclNode) {
                FuncSymbol funcSymbol = (FuncSymbol) currentSymbolTable.get("$FUNC_" + declNode.getName());
                Func func = new Func(funcSymbol);
                ir.addFunc(func);
            }
            else if (declNode instanceof VarDeclNode){
                if(((VarDeclNode) declNode).getInit() != null){
                    IRGlobalVar var = new IRGlobalVar(declNode.getName(), ((VarDeclNode)declNode).getInit());
                    globalVarInitList.add(var);
                }
            }
            else {
                ClassSymbol classSymbol = (ClassSymbol) currentSymbolTable.get("$CLASS_" + declNode.getName());
                currentSymbolTable = classSymbol.getSymbolTable();
                for (FuncDeclNode funcmember : ((ClassDeclNode) declNode).getFuncMember()) {
                    FuncSymbol funcSymbol = (FuncSymbol) currentSymbolTable.get("$FUNC_" + funcmember.getName());
                    Func func = new Func(funcSymbol);
                    ir.addFunc(func);
                }
                currentSymbolTable = currentSymbolTable.getParent();
            }
        }
        List<Node> stats = new ArrayList<>();
        for(IRGlobalVar var : globalVarInitList){
            IdentifierExprNode lhs = new IdentifierExprNode(var.name, null);
            VarSymbol varSymbol = (VarSymbol)globalSymbolTable.get("$VAR_" + var.name);
            lhs.setVarSymbol(varSymbol);
            AssignExprNode assignExprNode = new AssignExprNode(lhs, var.initExpr, null);
            ExpressionStatNode expressionStatNode = new ExpressionStatNode(assignExprNode, null);
            stats.add(expressionStatNode);
        }
        BlockStatNode body = new BlockStatNode(stats, null);
        body.setSymbolTable(globalSymbolTable);
        TypeNode retuenType = new TypeNode(VoidType.getVoidType(), null);
        FuncDeclNode funcDeclNode = new FuncDeclNode(retuenType, "init_func", new ArrayList<>(), body, null);
        FuncSymbol funcSymbol = new FuncSymbol(funcDeclNode);
        globalSymbolTable.put("init_func","$FUNC_init_func", funcSymbol);
        Func func = new Func(funcSymbol);
        ir.addFunc(func);
        return funcDeclNode;
    }

    @Override
    public void visit(ProgramNode node) {
        currentSymbolTable = globalSymbolTable;
//        for (DeclNode declNode : node.getDecls()) {
//            if (declNode instanceof FuncDeclNode) {
//                FuncSymbol funcSymbol = (FuncSymbol) currentSymbolTable.get("$FUNC_" + declNode.getName());
//                Func func = new Func(funcSymbol);
//                ir.addFunc(func);
//            }
//            else if (declNode instanceof VarDeclNode)
//                declNode.accept(this);
//            else {
//                ClassSymbol classSymbol = (ClassSymbol) currentSymbolTable.get("$CLASS_" + declNode.getName());
//                currentSymbolTable = classSymbol.getSymbolTable();
//                for (FuncDeclNode funcmember : ((ClassDeclNode) declNode).getFuncMember()) {
//                    FuncSymbol funcSymbol = (FuncSymbol) currentSymbolTable.get("$FUNC_" + funcmember.getName());
//                    Func func = new Func(funcSymbol);
//                    ir.addFunc(func);
//                }
//                currentSymbolTable = currentSymbolTable.getParent();
//            }
//        }

        FuncDeclNode initFunc = AddVarFunc(node);
        initFunc.accept(this);

        for (DeclNode declNode : node.getDecls()){
            if(declNode instanceof ClassDeclNode || declNode instanceof VarDeclNode || declNode instanceof FuncDeclNode)
                declNode.accept(this);
        }
        for(Func func : ir.funcs.values())
            func.updateCalleeSet();
        ir.updateCalleeSet();
    }

    @Override
    public void visit(FuncDeclNode node){
        String name = node.getName();
        if(currentClassName != null)
            name = "_member_" + currentClassName + "_" + name;
        currentFunction = ir.getFunc(name);
        currentBB = currentFunction.genFirstBB();

        SymbolTable currentSymbolTableTemp = currentSymbolTable;
        currentSymbolTable = node.getBody().getSymbolTable();
        if(currentClassName != null){
            VarSymbol varSymbol = (VarSymbol)currentSymbolTable.get("$VAR_this");
            VirtualRegister virtualRegister = new VirtualRegister("this");
            varSymbol.register = virtualRegister;
            currentFunction.addArgVReg(virtualRegister);
        }
        isFuncArgDecl = true;
        for(VarDeclNode argDecl : node.getFormalParameters())
            argDecl.accept(this);
        isFuncArgDecl = false;
        currentSymbolTable = currentSymbolTableTemp;

        if(node.getName().equals("main")) {
            FuncCallInst funcCallInst = new FuncCallInst(currentBB, ir.getFunc("init_func"), new ArrayList<>(), null);
            currentBB.addInst(funcCallInst);
        }

        node.getBody().accept(this);
        if(!currentBB.hasJumpInit){
            if(node.getReturntype() == null || node.getReturntype().getType() instanceof VoidType)
                currentBB.setJumpInst(new ReturnJumpInst(currentBB, null));
            else
                currentBB.setJumpInst(new ReturnJumpInst(currentBB, new IntImmValue(0)));
        }

        //every return stat create a new endBB, merge those endBB to an endBB, all return inst jump to the same target mergeBB
        if(currentFunction.returnList.size() > 1){
            BasicBlock mergeEndBB = new BasicBlock(currentFunction, currentFunction.name + "_end");
            VirtualRegister returnReg;
            if(node.getReturntype() == null || node.getReturntype().getType() instanceof VoidType)
                returnReg = null;
            else
                returnReg = new VirtualRegister("return_value");
            List<ReturnJumpInst> returnList = new ArrayList<>(currentFunction.returnList);
            for(ReturnJumpInst returnJumpInst : returnList){
                BasicBlock BB = returnJumpInst.parentBB;
                if(returnJumpInst.returnvalue != null)
                    returnJumpInst.prependInst(new MoveInst(BB, returnReg, returnJumpInst.returnvalue));
                returnJumpInst.remove();
                BB.setJumpInst(new JumpJumpInst(BB, mergeEndBB));
            }
            mergeEndBB.setJumpInst(new ReturnJumpInst(mergeEndBB, returnReg));
        }
        else
            currentFunction.endBB = currentFunction.returnList.get(0).parentBB;

        currentFunction = null;
    }

    @Override
    public void visit(ClassDeclNode node){
        currentClassName = node.getName();
        currentSymbolTable = globalSymbolTable;
        for(FuncDeclNode funcDeclNode : node.getFuncMember())
            funcDeclNode.accept(this);
        currentClassName = null;
    }

    @Override
    public void visit(VarDeclNode node){
        VarSymbol varSymbol = (VarSymbol)currentSymbolTable.get("$VAR_" + node.getName());
        if(varSymbol.unused)
            return;
        if(currentSymbolTable.isTop()){
            StaticData data = new StaticVarData(node.getName(), 8);
            ir.addIRStaticData(data);
            varSymbol.register = data;
//            if(node.getInit() != null){
//                IRGlobalVar var = new IRGlobalVar(node.getName(), node.getInit());
//                globalVarInitList.add(var);
//            }
        }
        else{
            VirtualRegister reg = new VirtualRegister(node.getName());
            varSymbol.register = reg;
            if(isFuncArgDecl)
                currentFunction.addArgVReg(reg);
            if(node.getInit() != null) {
                if (node.getInit().getType() instanceof BoolType) {
                    node.getInit().trueBB = new BasicBlock(currentFunction, null);
                    node.getInit().falseBB = new BasicBlock(currentFunction, null);
                }
                node.getInit().accept(this);
                processAssign(reg, 0, node.getInit(), node.getInit().getType().getSize(), false);
            }
            else{
                if(!isFuncArgDecl)
                    currentBB.addInst(new MoveInst(currentBB, reg, new IntImmValue(0)));//set default value 0
            }
        }
    }

    private void processAssign(Value dest, int addrOffset, ExprNode rhs, int size, boolean needMemop){
        if(rhs.trueBB != null){
            // for short-circuit evaluation
            BasicBlock mergeBB = new BasicBlock(currentFunction, null);
            if(needMemop){
                rhs.trueBB.addInst(new StoreInst(rhs.trueBB, new IntImmValue(1), dest, size, addrOffset));
                rhs.falseBB.addInst(new StoreInst(rhs.falseBB, new IntImmValue(0), dest, size, addrOffset));
            }
            else{
                rhs.trueBB.addInst(new MoveInst(rhs.trueBB, (VirtualRegister)dest, new IntImmValue(1)));
                rhs.falseBB.addInst(new MoveInst(rhs.falseBB, (VirtualRegister)dest, new IntImmValue(0)));
            }
            rhs.trueBB.setJumpInst(new JumpJumpInst(rhs.trueBB, mergeBB));
            rhs.falseBB.setJumpInst(new JumpJumpInst(rhs.falseBB, mergeBB));
            currentBB = mergeBB;
        }
        else{
            if(needMemop)
                currentBB.addInst(new StoreInst(currentBB, rhs.regValue, dest, size, addrOffset));
            else
                currentBB.addInst(new MoveInst(currentBB, (Register)dest, rhs.regValue));
        }
    }

    @Override
    public void visit(BlockStatNode node){
        currentSymbolTable = node.getSymbolTable();
        for(Node body : node.getBlockbody()){
            if(body instanceof VarDeclNode || body instanceof StatNode)
                body.accept(this);
            //jump the inst after a jump inst that will never arrive
            if(currentBB.hasJumpInit)
                break;
        }
        currentSymbolTable = currentSymbolTable.getParent();
    }

    @Override
    public void visit(ExpressionStatNode node){
        node.getExpr().accept(this);
    }

    @Override
    public void visit(IfStatNode node){
        BasicBlock thenBB = new BasicBlock(currentFunction, "if_then");
        BasicBlock afterBB = new BasicBlock(currentFunction, "if_after");
        BasicBlock elseBB = node.getElsebody() != null ? new BasicBlock(currentFunction, "if_else") : null;

        node.getCond().trueBB = thenBB;
        node.getCond().falseBB = node.getElsebody() != null ? elseBB : afterBB;
        node.getCond().accept(this);
        if(node.getCond() instanceof BoolConstExprNode)
            currentBB.setJumpInst((new BranchJumpInst(currentBB, ((BoolConstExprNode) node.getCond()).regValue, node.getCond().trueBB, node.getCond().falseBB)));

        currentBB = thenBB;
        node.getThenbody().accept(this);
        if(!currentBB.hasJumpInit)
            currentBB.setJumpInst(new JumpJumpInst(currentBB, afterBB));

        if(node.getElsebody() != null){
            currentBB = elseBB;
            node.getElsebody().accept(this);
            if(!currentBB.hasJumpInit)
                currentBB.setJumpInst(new JumpJumpInst(currentBB, afterBB));
        }

        currentBB = afterBB;
    }

    @Override
    public void visit(WhileStatNode node){
        BasicBlock condBB = new BasicBlock(currentFunction, "while_cond");
        BasicBlock bodyBB = new BasicBlock(currentFunction, "while_body");
        BasicBlock afterBB = new BasicBlock(currentFunction, "while_after");

        BasicBlock oldLoopCondBB = currentLoopStepBB;
        BasicBlock oldLoopAfterBB = currentLoopAfterBB;
        currentLoopStepBB = condBB;
        currentLoopAfterBB = afterBB;

        currentBB.setJumpInst(new JumpJumpInst(currentBB, condBB));

        currentBB = condBB;
        node.getCond().trueBB = bodyBB;
        node.getCond().falseBB = afterBB;
        node.getCond().accept(this);
        if(node.getCond() instanceof BoolConstExprNode)
            currentBB.setJumpInst(new BranchJumpInst(currentBB, ((BoolConstExprNode) node.getCond()).regValue, node.getCond().trueBB, node.getCond().falseBB));

        currentBB = bodyBB;
        node.getWhilebody().accept(this);
        if(!currentBB.hasJumpInit)
            currentBB.setJumpInst(new JumpJumpInst(currentBB, condBB));

        currentLoopStepBB = oldLoopCondBB;
        currentLoopAfterBB = oldLoopAfterBB;
        currentBB = afterBB;
    }

    @Override
    public void visit(ForStatNode node){
        BasicBlock condBB = node.getCond() != null ? new BasicBlock(currentFunction, "for_cond") : null;
        BasicBlock stepBB = node.getStep() != null ? new BasicBlock(currentFunction, "for_step") : null;
        BasicBlock bodyBB = new BasicBlock(currentFunction, "for_body");
        BasicBlock afterBB = new BasicBlock(currentFunction, "for_after");

        BasicBlock oldLoopStepBB = currentLoopStepBB;
        BasicBlock oldLoopAfterBB = currentLoopAfterBB;
        currentLoopStepBB = stepBB;
        currentLoopAfterBB = afterBB;

        if(node.getInit() != null)
            node.getInit().accept(this);

        currentBB.setJumpInst(new JumpJumpInst(currentBB, condBB));

        if(node.getCond() != null){
            currentBB = condBB;
            node.getCond().trueBB = bodyBB;
            node.getCond().falseBB = afterBB;
            node.getCond().accept(this);
            if(node.getCond() instanceof  BoolConstExprNode)
                currentBB.setJumpInst(new BranchJumpInst(currentBB, ((BoolConstExprNode) node.getCond()).regValue, node.getCond().trueBB, node.getCond().falseBB));
        }

        if(node.getStep() != null){
            currentBB = stepBB;
            node.getStep().accept(this);
            currentBB.setJumpInst(new JumpJumpInst(currentBB, condBB));
        }

        currentBB = bodyBB;
        if(node.getStat() != null)
            node.getStat().accept(this);
        if(!currentBB.hasJumpInit)
            currentBB.setJumpInst(new JumpJumpInst(currentBB, stepBB));

        currentLoopStepBB = oldLoopStepBB;
        currentLoopAfterBB = oldLoopAfterBB;
        currentBB = afterBB;
    }

    @Override
    public void visit(ContinueStatNode node){
        currentBB.setJumpInst(new JumpJumpInst(currentBB, currentLoopStepBB));
    }

    @Override
    public void visit(BreakStatNode node){
        currentBB.setJumpInst(new JumpJumpInst(currentBB, currentLoopAfterBB));
    }

    @Override
    public void visit(ReturnStatNode node){
        Type reutrnType = currentFunction.funcSymbol.getReturntype();
        if(reutrnType == null || reutrnType instanceof VoidType)
            currentBB.setJumpInst(new ReturnJumpInst(currentBB, null));
        else{
            if(reutrnType instanceof BoolType && !(node.getExpr() instanceof BoolConstExprNode)){
                node.getExpr().trueBB = new BasicBlock(currentFunction, null);
                node.getExpr().falseBB = new BasicBlock(currentFunction, null);
                node.getExpr().accept(this);
                VirtualRegister reg = new VirtualRegister("returnBoolValue");
                processAssign(reg, 0, node.getExpr(), 8, false);
                currentBB.setJumpInst(new ReturnJumpInst(currentBB, reg));
            }
            else{
                node.getExpr().accept(this);
                currentBB.setJumpInst(new ReturnJumpInst(currentBB, node.getExpr().regValue));
            }
        }
    }

    @Override
    public void visit(SubscriptExprNode node){
        boolean wantAddrtemp = wantAddr;
        wantAddr = false;
        node.getArray().accept(this);
        if(uselessStatic)
            return;
        assignLhs = false;
        node.getSub().accept(this);
        wantAddr = wantAddrtemp;

        VirtualRegister reg = new VirtualRegister(null);
        IntImmValue elementSize = new IntImmValue(node.getType().getSize());
        currentBB.addInst(new BinaryOpInst(currentBB, reg, BinaryOpInst.BinaryOps.MUL, node.getSub().regValue, elementSize));
        currentBB.addInst(new BinaryOpInst(currentBB, reg, BinaryOpInst.BinaryOps.ADD, node.getArray().regValue, reg));

        if(wantAddr){
            node.setAddrValue(reg);
            node.setAddrOffset(8);
        }
        else{
            currentBB.addInst(new LoadInst(currentBB, reg, reg, node.getType().getSize(), 8));
            node.regValue = reg;
            if(node.trueBB != null)
                currentBB.setJumpInst(new BranchJumpInst(currentBB, node.regValue, node.trueBB, node.falseBB));
        }
    }

    @Override
    public void visit(FuncCallExprNode node){
        FuncSymbol funcSymbol = node.getFuncSymbol();
        String funcname = funcSymbol.getName();
        List<Value> args = new ArrayList<>();
        ExprNode thisExpr = null;
        if(funcSymbol.isMember()){
            if(node.getFunction() instanceof MemAccessExprNode)
                thisExpr = (((MemAccessExprNode) node.getFunction()).getExpr());
            else{
                thisExpr = new ThisExprNode(null);
                thisExpr.setType(new ClassType(currentClassName));
            }
            thisExpr.accept(this);
            String classname;
            if(thisExpr.getType() instanceof ClassType)
                classname = ((ClassType) thisExpr.getType()).getName();
            else if(thisExpr.getType() instanceof ArrayType)
                classname = "array";
            else
                classname = "string";
            funcname = "_member_" + classname + "_" + funcname;
            args.add(thisExpr.regValue);
        }
        if(funcSymbol.isBuiltIn()){
            processBuiltInFuncCall(node, thisExpr, funcname);
            return;
        }
        for(ExprNode arg : node.getArgs()){
            arg.accept(this);
            args.add(arg.regValue);
        }
        Func func = ir.getFunc(funcname);
        VirtualRegister reg = new VirtualRegister(null);
        currentBB.addInst(new FuncCallInst(currentBB, func, args, reg));
        node.regValue = reg;

        if(node.trueBB !=  null)
            currentBB.setJumpInst(new BranchJumpInst(currentBB, node.regValue, node.trueBB, node.falseBB));
    }

    private void processBuiltInFuncCall(FuncCallExprNode node, ExprNode thisExpr, String funcname) {
        boolean wantAddrtemp = wantAddr;
        wantAddr = false;
        VirtualRegister reg;
        Func calleeFunc;
        if (funcname == "print" || funcname == "println")
            processPrintFuncCall(node.getArgs().get(0), funcname);
        else if (funcname == "getString") {
            calleeFunc = ir.getBuiltInFunc(funcname);
            List<Value> args = new ArrayList<>();
            reg = new VirtualRegister("getString");
            currentBB.addInst(new FuncCallInst(currentBB, calleeFunc, args, reg));
            node.regValue = reg;
        }
        else if (funcname == "getInt") {
            calleeFunc = ir.getBuiltInFunc(funcname);
            List<Value> args = new ArrayList<>();
            reg = new VirtualRegister("getInt");
            currentBB.addInst(new FuncCallInst(currentBB, calleeFunc, args, reg));
            node.regValue = reg;
        }
        else if (funcname == "toString") {
            node.getArgs().get(0).accept(this);
            calleeFunc = ir.getBuiltInFunc(funcname);
            List<Value> args = new ArrayList<>();
            args.add(node.getArgs().get(0).regValue);
            reg = new VirtualRegister("toString");
            currentBB.addInst(new FuncCallInst(currentBB, calleeFunc, args, reg));
            node.regValue = reg;
        }
        else if (funcname == "_member_string_substring") {
            node.getArgs().get(0).accept(this);
            node.getArgs().get(1).accept(this);
            calleeFunc = ir.getBuiltInFunc(funcname);
            List<Value> args = new ArrayList<>();
            args.add(thisExpr.regValue);
            args.add(node.getArgs().get(0).regValue);
            args.add(node.getArgs().get(1).regValue);
            reg = new VirtualRegister("substring");
            currentBB.addInst(new FuncCallInst(currentBB, calleeFunc, args, reg));
            node.regValue = reg;
        }
        else if (funcname == "_member_string_parseInt") {
            calleeFunc = ir.getBuiltInFunc(funcname);
            List<Value> args = new ArrayList<>();
            args.add(thisExpr.regValue);
            reg = new VirtualRegister("parseInt");
            currentBB.addInst(new FuncCallInst(currentBB, calleeFunc, args, reg));
            node.regValue = reg;
        }
        else if (funcname == "_member_string_ord"){
            node.getArgs().get(0).accept(this);
            calleeFunc = ir.getBuiltInFunc(funcname);
            List<Value> args = new ArrayList<>();
            args.add(thisExpr.regValue);
            args.add(node.getArgs().get(0).regValue);
            reg = new VirtualRegister("ord");
            currentBB.addInst(new FuncCallInst(currentBB, calleeFunc, args, reg));
            node.regValue = reg;
        }
        else if(funcname == "_member_string_length" || funcname == "_member_array_size") {
            reg = new VirtualRegister("size");
            currentBB.addInst(new LoadInst(currentBB, reg, thisExpr.regValue, 8, 0));
            node.regValue = reg;
        }
        wantAddr = wantAddrtemp;
    }

    private void processPrintFuncCall(ExprNode arg, String funcname){
        Func calleeFunc;
        List<Value> args = new ArrayList<>();
        // print(A + B)=>print(A) print(B)  println(A + B)=>print(A) println(B)
        if(arg instanceof BinaryExprNode){
            processPrintFuncCall(((BinaryExprNode)arg).getLeft(), "print");
            processPrintFuncCall(((BinaryExprNode)arg).getRight(), funcname);
        }
        // print(toString(intExpr))=>printInt(i)
        else if(arg instanceof FuncCallExprNode && ((FuncCallExprNode)arg).getFuncSymbol().getName() == "toString"){
            ExprNode initExpr = ((FuncCallExprNode)arg).getArgs().get(0);
            initExpr.accept(this);
            calleeFunc = ir.getBuiltInFunc(funcname + "Int");
            args.add(initExpr.regValue);
            currentBB.addInst(new FuncCallInst(currentBB, calleeFunc, args, null));
        }
        // print(stringExpr)
        else{
            arg.accept(this);
            calleeFunc = ir.getBuiltInFunc(funcname);
            args.add(arg.regValue);
            currentBB.addInst(new FuncCallInst(currentBB, calleeFunc, args, null));
        }
    }

    @Override
    public void visit(MemAccessExprNode node){
        boolean wantAddrtemp = wantAddr;
        wantAddr = false;
        node.getExpr().accept(this);
        assignLhs = false;
        wantAddr = wantAddrtemp;

        Value classAddr = node.getExpr().regValue;
        String classname = ((ClassType)(node.getExpr().getType())).getName();
        ClassSymbol classSymbol = (ClassSymbol)currentSymbolTable.get("$CLASS_" + classname);
        VarSymbol memberSymbol = (VarSymbol)classSymbol.getSymbolTable().selfGetVarOrFunc(null, "$VAR_" + node.getMember());

        if(wantAddr){
            node.setAddrValue(classAddr);
            node.setAddrOffset(memberSymbol.getAddrOffset());
        }
        else{
            VirtualRegister reg = new VirtualRegister(null);
            node.regValue = reg;
            currentBB.addInst(new LoadInst(currentBB, reg, classAddr, memberSymbol.getType().getSize(), memberSymbol.getAddrOffset()));
            if(node.trueBB != null)
                currentBB.setJumpInst(new BranchJumpInst(currentBB, node.regValue, node.trueBB, node.falseBB));
        }
    }

    @Override
    public void visit(SuffixExprNode node){
        if(node.getOp() == SuffixExprNode.SuffixOp.PLUS_PLUS)
            processSelfIncDec(node.getExpr(), node, true, true);
        else
            processSelfIncDec(node.getExpr(), node, true, false);
    }

    private void processSelfIncDec(ExprNode expr, ExprNode node, boolean isSuffix, boolean isInc){
        boolean needMemop = isMemAccess(expr);
        boolean wantAddrtemp = wantAddr;
        wantAddr = false;
        expr.accept(this);

        // if postfix, save old value
        if(isSuffix){
            VirtualRegister reg = new VirtualRegister(null);
            currentBB.addInst(new MoveInst(currentBB, reg, expr.regValue));
            node.regValue = reg;
        }
        else
            node.regValue = expr.regValue;

        // if need memory operation, introduce temporary register
        IntImmValue one = new IntImmValue(1);
        BinaryOpInst.BinaryOps op = isInc ? BinaryOpInst.BinaryOps.ADD : BinaryOpInst.BinaryOps.SUB;
        if(needMemop){
            wantAddr = true;
            VirtualRegister reg = new VirtualRegister(null);
            currentBB.addInst(new BinaryOpInst(currentBB, reg, op, expr.regValue, one));
            currentBB.addInst(new StoreInst(currentBB, reg, expr.addrValue, 8, expr.getAddrOffset()));
            if(!isSuffix)
                expr.regValue = reg;
        }
        else
            currentBB.addInst(new BinaryOpInst(currentBB, (Register)expr.regValue, op, expr.regValue, one));
        wantAddr = wantAddrtemp;
    }

    private boolean isMemAccess(ExprNode node) {
        return node instanceof SubscriptExprNode || node instanceof MemAccessExprNode || (node instanceof IdentifierExprNode && checkIdentiferThisMemberAccess((IdentifierExprNode) node));
    }

    private boolean checkIdentiferThisMemberAccess(IdentifierExprNode node) {
        if (!node.checked) {
            if (currentClassName != null) {
                VarSymbol varSymbol = (VarSymbol) currentSymbolTable.get("$VAR_" + node.getIdentifier());
                node.needMemOp = varSymbol.register == null;
            }
            else
                node.needMemOp = false;
            node.checked = true;
        }
        return node.needMemOp;
    }

    @Override
    public void visit(PrefixExprNode node){
        VirtualRegister reg;
        switch(node.getOp()){
            case PLUS_PLUS:
                processSelfIncDec(node.getExpr(), node, false, true);
                break;
            case MINUS_MINUS:
                processSelfIncDec(node.getExpr(), node, false, false);
                break;
            case PLUS:
                node.regValue = node.getExpr().regValue;
                break;
            case MINUS:
                reg = new VirtualRegister(null);
                node.regValue = reg;
                node.getExpr().accept(this);
                currentBB.addInst(new UnaryOpInst(currentBB, reg, UnaryOpInst.UnaryOps.MIUNS, node.getExpr().regValue));
                break;
            case TILDE:
                reg = new VirtualRegister(null);
                node.regValue = reg;
                node.getExpr().accept(this);
                currentBB.addInst(new UnaryOpInst(currentBB, reg, UnaryOpInst.UnaryOps.TILDE, node.getExpr().regValue));
                break;
            case NOT:
                reg = new VirtualRegister(null);
                node.regValue = reg;
                node.getExpr().trueBB = node.falseBB;
                node.getExpr().falseBB = node.trueBB;
                node.getExpr().accept(this);
                break;
        }
    }

    @Override
    public void visit(NewExprNode node){
        VirtualRegister reg = new VirtualRegister(null);
        Type newType = node.getNewType().getType();
        //class construct, find the construct function
        if(newType instanceof ClassType) {
            String classname = ((ClassType) newType).getName();
            ClassSymbol classSymbol = (ClassSymbol) globalSymbolTable.get("$CLASS_" + classname);
            currentBB.addInst(new HeapAllocInst(currentBB, reg, new IntImmValue(classSymbol.getMemorySize())));
            String funcname = "_member_" + classname + "_" + classname;
            Func func = ir.getFunc(funcname);
            if (func != null) {
                List<Value> args = new ArrayList<>();
                args.add(reg);
                currentBB.addInst(new FuncCallInst(currentBB, func, args, null));
            }
        }
        else if(newType instanceof ArrayType)
            processArrayNew(node, reg, null, 0);
        node.regValue = reg;
    }

    private void processArrayNew(NewExprNode node, VirtualRegister reg, Value addr, int idx){
        VirtualRegister virtualRegister = new VirtualRegister(null);
        ExprNode dim = node.getDims().get(idx);
        boolean wantAddrtemp = wantAddr;
        wantAddr = false;
        dim.accept(this);
        wantAddr = wantAddrtemp;
        currentBB.addInst(new BinaryOpInst(currentBB, virtualRegister, BinaryOpInst.BinaryOps.MUL, dim.regValue, new IntImmValue(8)));
        currentBB.addInst(new BinaryOpInst(currentBB, virtualRegister, BinaryOpInst.BinaryOps.ADD, virtualRegister, new IntImmValue(8)));
        currentBB.addInst(new HeapAllocInst(currentBB, virtualRegister, virtualRegister));
        currentBB.addInst(new StoreInst(currentBB, dim.regValue, virtualRegister, 8, 0));
        if(idx < node.getDims().size() - 1){
            VirtualRegister loopidx = new VirtualRegister(null);
            VirtualRegister addrnow = new VirtualRegister(null);
            currentBB.addInst(new MoveInst(currentBB, loopidx, new IntImmValue(0)));
            currentBB.addInst(new MoveInst(currentBB, addrnow, virtualRegister));
            BasicBlock condBB = new BasicBlock(currentFunction, "while_cond");
            BasicBlock bodyBB = new BasicBlock(currentFunction, "while_body");
            BasicBlock afterBB = new BasicBlock(currentFunction, "while_after");
            currentBB.setJumpInst(new JumpJumpInst(currentBB, condBB));

            currentBB = condBB;
            VirtualRegister cmpreg = new VirtualRegister(null);
            currentBB.addInst(new CompareInst(currentBB, cmpreg, CompareInst.CompareOp.LESS, loopidx, dim.regValue));
            currentBB.setJumpInst(new BranchJumpInst(currentBB, cmpreg, bodyBB, afterBB));

            currentBB = bodyBB;
            currentBB.addInst(new BinaryOpInst(currentBB, addrnow, BinaryOpInst.BinaryOps.ADD, addrnow, new IntImmValue(8)));
            processArrayNew(node, null, addr, idx + 1);
            currentBB.addInst(new BinaryOpInst(currentBB, loopidx, BinaryOpInst.BinaryOps.ADD, loopidx, new IntImmValue(1)));
            currentBB.setJumpInst(new JumpJumpInst(currentBB, condBB));

            currentBB = afterBB;
        }
        if(idx == 0)
            currentBB.addInst(new MoveInst(currentBB, reg, virtualRegister));
        else
            currentBB.addInst(new StoreInst(currentBB, virtualRegister, addr, 8, 0));
    }

    @Override
    public void visit(BinaryExprNode node){
        switch (node.getOp()){
            case AND_AND: case OR_OR:
                processLogicalBinaryOp(node);
                break;
            case MUL: case DIV: case ADD: case SUB: case MOD: case AND: case OR: case CARET: case LEFT_SHIFT: case RIGHT_SHIFT:
                if(node.getLeft().getType() instanceof StringType)
                    processStringBinaryOp(node);
                else
                    processArithBinaryOp(node);
                break;
            case GREATER: case LESS: case GREATER_EQUAL: case LESS_EQUAL: case EQUAL: case NOT_EQUAL:
                if(node.getLeft().getType() instanceof StringType)
                    processStringBinaryOp(node);
                else
                    processCmpBinaryOp(node);
                break;
        }
    }

    private void processLogicalBinaryOp(BinaryExprNode node){
        //process the short circuit
        if(node.getOp() == BinaryExprNode.BinaryOp.AND_AND){
            node.getLeft().trueBB = new BasicBlock(currentFunction, "and_lhs_true");
            node.getLeft().falseBB = node.falseBB;
            node.getLeft().accept(this);
            currentBB = node.getLeft().trueBB;
        }
        else{
            node.getLeft().trueBB = node.trueBB;
            node.getLeft().falseBB = new BasicBlock(currentFunction, "or_lhs_false");
            node.getLeft().accept(this);
            currentBB = node.getLeft().falseBB;
        }
        node.getRight().trueBB = node.trueBB;
        node.getRight().falseBB = node.falseBB;
        node.getRight().accept(this);
    }

    private void processArithBinaryOp(BinaryExprNode node){
        node.getLeft().accept(this);
        node.getRight().accept(this);

        Value lhs = node.getLeft().regValue;
        Value rhs = node.getRight().regValue;

        //for optimize
        boolean bothconst = lhs instanceof IntImmValue && rhs instanceof IntImmValue;
        int lhsImm = lhs instanceof IntImmValue ? ((IntImmValue)lhs).value : 0;
        int rhsImm = rhs instanceof IntImmValue ? ((IntImmValue)rhs).value : 0;

        BinaryOpInst.BinaryOps op = null;
        switch (node.getOp()) {
            case MUL:
                op = BinaryOpInst.BinaryOps.MUL;
                if (bothconst) {
                    node.regValue = new IntImmValue(lhsImm * rhsImm);
                    return;
                }
                break;
            case DIV:
                op = BinaryOpInst.BinaryOps.DIV;
                if (bothconst && rhsImm != 0) {
                    node.regValue = new IntImmValue(lhsImm / rhsImm);
                    return;
                }
                ir.hasDivShiftInst = true;
                break;
            case MOD:
                op = BinaryOpInst.BinaryOps.MOD;
                if (bothconst && rhsImm != 0) {
                    node.regValue = new IntImmValue(lhsImm % rhsImm);
                    return;
                }
                ir.hasDivShiftInst = true;
                break;
            case ADD:
                op = BinaryOpInst.BinaryOps.ADD;
                if (bothconst) {
                    node.regValue = new IntImmValue(lhsImm + rhsImm);
                    return;
                }
                break;
            case SUB:
                op = BinaryOpInst.BinaryOps.SUB;
                if (bothconst) {
                    node.regValue = new IntImmValue(lhsImm - rhsImm);
                    return;
                }
                break;
            case LEFT_SHIFT:
                op = BinaryOpInst.BinaryOps.LEFT_SHIFT;
                if (bothconst) {
                    node.regValue = new IntImmValue(lhsImm << rhsImm);
                    return;
                }
                ir.hasDivShiftInst = true;
                break;
            case RIGHT_SHIFT:
                op = BinaryOpInst.BinaryOps.RIGHT_SHIFT;
                if (bothconst) {
                    node.regValue = new IntImmValue(lhsImm >> rhsImm);
                    return;
                }
                ir.hasDivShiftInst = true;
                break;
            case AND:
                op = BinaryOpInst.BinaryOps.AND;
                if (bothconst) {
                    node.regValue = new IntImmValue(lhsImm & rhsImm);
                    return;
                }
                break;
            case OR:
                op = BinaryOpInst.BinaryOps.OR;
                if (bothconst) {
                    node.regValue = new IntImmValue(lhsImm | rhsImm);
                    return;
                }
                break;
            case CARET:
                op = BinaryOpInst.BinaryOps.CARET;
                if (bothconst) {
                    node.regValue = new IntImmValue(lhsImm ^ rhsImm);
                    return;
                }
                break;
        }

        VirtualRegister reg = new VirtualRegister(null);
        node.regValue = reg;
        currentBB.addInst(new BinaryOpInst(currentBB, reg, op, lhs, rhs));
    }

    private void processStringBinaryOp(BinaryExprNode node) {
        node.getLeft().accept(this);
        node.getRight().accept(this);
        Func calleeFunc = null;
        ExprNode tmp;
        switch (node.getOp()) {
            case ADD:
                calleeFunc = ir.getBuiltInFunc("_builtin_string_concat");
                break;
            case EQUAL:
                calleeFunc = ir.getBuiltInFunc("_builtin_string_equal");
                break;
            case NOT_EQUAL:
                calleeFunc = ir.getBuiltInFunc("_builtin_string_not_equal");
                break;
            case LESS:
                calleeFunc = ir.getBuiltInFunc("_builtin_string_less");
                break;
            case LESS_EQUAL:
                calleeFunc = ir.getBuiltInFunc("_builtin_string_less_equal");
                break;
            case GREATER:
                tmp = node.getLeft();
                node.setLeft(node.getRight());
                node.setRight(tmp);
                calleeFunc = ir.getBuiltInFunc("_builtin_string_less");
                break;
            case GREATER_EQUAL:
                tmp = node.getLeft();
                node.setLeft(node.getRight());
                node.setRight(tmp);
                calleeFunc = ir.getBuiltInFunc("_builtin_string_less_equal");
                break;
        }
        List<Value> args = new ArrayList<>();
        args.add(node.getLeft().regValue);
        args.add(node.getRight().regValue);
        VirtualRegister reg = new VirtualRegister(null);
        currentBB.addInst(new FuncCallInst(currentBB, calleeFunc, args, reg));

        if (node.trueBB != null)//in a condition
            currentBB.setJumpInst(new BranchJumpInst(currentBB, reg, node.trueBB, node.falseBB));
        else//in an assignment
            node.regValue = reg;
    }

    private void processCmpBinaryOp(BinaryExprNode node){
        node.getLeft().accept(this);
        node.getRight().accept(this);

        Value lhs = node.getLeft().regValue;
        Value rhs = node.getRight().regValue;

        //for optimize
        boolean bothConst = lhs instanceof IntImmValue && rhs instanceof IntImmValue;
        int lhsImm = lhs instanceof IntImmValue ? ((IntImmValue)lhs).value : 0;
        int rhsImm = rhs instanceof IntImmValue ? ((IntImmValue)rhs).value : 0;
        if(lhs instanceof IntImmValue){
            Value tmp = rhs;
            rhs = lhs;
            lhs = tmp;
        }

        CompareInst.CompareOp op = null;
        switch (node.getOp()) {
            case GREATER:
                op = CompareInst.CompareOp.GREATER;
                if (bothConst) {
                    node.regValue = lhsImm > rhsImm ? new IntImmValue(1) : new IntImmValue(0);
                    return;
                }
                if (lhs instanceof IntImmValue)
                    op = CompareInst.CompareOp.LESS;
                break;
            case LESS:
                op = CompareInst.CompareOp.LESS;
                if (bothConst) {
                    node.regValue = lhsImm < rhsImm ? new IntImmValue(1) : new IntImmValue(0);
                    return;
                }
                if (lhs instanceof IntImmValue)
                    op = CompareInst.CompareOp.GREATER;
                break;
            case GREATER_EQUAL:
                op = CompareInst.CompareOp.GREATER_EQUAL;
                if (bothConst) {
                    node.regValue = lhsImm >= rhsImm ? new IntImmValue(1) : new IntImmValue(0);
                    return;
                }
                if (lhs instanceof IntImmValue)
                    op = CompareInst.CompareOp.LESS_EQUAL;
                break;
            case LESS_EQUAL:
                op = CompareInst.CompareOp.LESS_EQUAL;
                if (bothConst) {
                    node.regValue = lhsImm <= rhsImm ? new IntImmValue(1) : new IntImmValue(0);
                    return;
                }
                if (lhs instanceof IntImmValue)
                    op = CompareInst.CompareOp.GREATER_EQUAL;
                break;
            case EQUAL:
                op = CompareInst.CompareOp.EQUAL;
                if (bothConst) {
                    node.regValue = lhsImm == rhsImm ? new IntImmValue(1) : new IntImmValue(0);
                    return;
                }
                break;
            case NOT_EQUAL:
                op = CompareInst.CompareOp.NOT_EQUAL;
                if (bothConst) {
                    node.regValue = lhsImm != rhsImm ? new IntImmValue(1) : new IntImmValue(0);
                    return;
                }
                break;
        }

        VirtualRegister reg = new VirtualRegister(null);
        currentBB.addInst(new CompareInst(currentBB, reg, op, lhs, rhs));

        if (node.trueBB != null)
            currentBB.setJumpInst(new BranchJumpInst(currentBB, reg, node.trueBB, node.falseBB));
        else
            node.regValue = reg;
    }

    @Override
    public void visit(AssignExprNode node){
        boolean needMemOp = isMemAccess(node.getLeft());
        wantAddr = needMemOp;
        assignLhs = true;
        uselessStatic = false;
        node.getLeft().accept(this);
        assignLhs = false;
        wantAddr = false;

        if(uselessStatic){
            uselessStatic = false;
            return;
        }

        if(node.getRight().getType() instanceof BoolType && !(node.getRight() instanceof BoolConstExprNode)){
            node.getRight().trueBB = new BasicBlock(currentFunction, null);
            node.getRight().falseBB = new BasicBlock(currentFunction, null);
        }
        node.getRight().accept(this);

        Value dest;
        int addeOffset;
        if(needMemOp){
            dest = node.getLeft().addrValue;
            addeOffset = node.getLeft().getAddrOffset();
        }
        else{
            dest = node.getLeft().regValue;
            addeOffset = 0;
        }
        processAssign(dest, addeOffset, node.getRight(), 8, needMemOp);
        node.regValue = node.getRight().regValue;
    }

    @Override
    public void visit(IdentifierExprNode node){
        VarSymbol varSymbol = node.getVarSymbol();
        if((varSymbol.getType() instanceof ArrayType || varSymbol.isGlobal()) && varSymbol.unused){
            uselessStatic = true;
            return;
        }
        if(varSymbol.register == null){
            ThisExprNode thisExprNode = new ThisExprNode(null);
            thisExprNode.setType(new ClassType(currentClassName));
            MemAccessExprNode memAccessExprNode = new MemAccessExprNode(thisExprNode, node.getIdentifier(), null);
            memAccessExprNode.accept(this);
            if(wantAddr){
                node.setAddrValue(memAccessExprNode.addrValue);
                node.setAddrOffset(memAccessExprNode.getAddrOffset());
            }
            else{
                node.regValue = memAccessExprNode.regValue;
                if(node.trueBB != null)
                    currentBB.setJumpInst(new BranchJumpInst(currentBB, node.regValue, node.trueBB, node.falseBB));
            }
            node.needMemOp = true;
        }
        else{
            node.regValue = varSymbol.register;
            if(node.trueBB != null)
                currentBB.setJumpInst(new BranchJumpInst(currentBB, node.regValue, node.trueBB, node.falseBB));
        }
    }

    @Override
    public void visit(ThisExprNode node){
        VarSymbol thisSymbol = (VarSymbol)currentSymbolTable.get("$VAR_this");
        node.regValue = thisSymbol.register;
        if(node.trueBB != null)
            currentBB.setJumpInst(new BranchJumpInst(currentBB, node.regValue, node.trueBB, node.falseBB));
    }

    @Override
    public void visit(IntConstExprNode node){
        node.regValue = new IntImmValue(node.getValue());
    }

    @Override
    public void visit(StringConstExprNode node){
        StaticStringData staticStringData = ir.getStaticStr(node.getValue());
        if(staticStringData == null){
            staticStringData = new StaticStringData(node.getValue());
            ir.addStaticStr(staticStringData);
        }
        node.regValue = staticStringData;
    }

    @Override
    public void visit(BoolConstExprNode node) {
        node.regValue = new IntImmValue(node.getValue() ? 1 : 0);
    }

    @Override
    public void visit(NullExprNode node) {
        node.regValue = new IntImmValue(0);
    }
}