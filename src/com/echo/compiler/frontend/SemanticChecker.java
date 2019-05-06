package com.echo.compiler.frontend;

import com.echo.compiler.Symbol.*;
import com.echo.compiler.ast.DeclNode.*;
import com.echo.compiler.ast.ExprNode.*;
import com.echo.compiler.ast.Node;
import com.echo.compiler.ast.ProgramNode;
import com.echo.compiler.ast.StatNode.*;
import com.echo.compiler.ast.TypeNode.*;
import com.echo.compiler.error.CompilerError;
import com.echo.compiler.error.SemanticError;

public class SemanticChecker extends SymbolTableBuilder{
    private SymbolTable globalSymbolTable;
    private SymbolTable currentSymbolTable;
    private Type currentType;
    private ClassType currentClassType;
    private FuncSymbol currentFuncSymbol;
    private int Loop = 0;

    public SemanticChecker(SymbolTable globalSymbolTable){
        this.globalSymbolTable = globalSymbolTable;
    }

    public SymbolTable getGlobalSymbolTable(){
        return globalSymbolTable;
    }

    private void VarCheck(VarDeclNode node) {
        if (node.getInit() != null) {
            node.getInit().accept(this);
            boolean invalidInitType;
            if (node.getType().getType() instanceof VoidType || node.getInit().getType() instanceof VoidType)
                invalidInitType = true;
            else if (node.getType().getType().equals(node.getInit().getType()))
                invalidInitType = false;
            else if (node.getInit().getType() instanceof NullType)
                invalidInitType = !(node.getType().getType() instanceof ClassType || node.getType().getType() instanceof ArrayType);
            else
                invalidInitType = true;
            if (invalidInitType)
                throw new SemanticError(node.getLocation(), String.format("Invalid initialization value, expected \"%s\" but got \"%s\"", node.getType().getType().toString(), node.getInit().getType().toString()));
        }
    }

    @Override
    public void visit(ProgramNode node) {
        this.currentSymbolTable = globalSymbolTable;
        for(DeclNode declNode : node.getDecls()){
            if(declNode instanceof VarDeclNode || declNode instanceof FuncDeclNode || declNode instanceof ClassDeclNode)
                declNode.accept(this);
            else
                throw new CompilerError(declNode.getLocation(), "Invalid declaration");
        }
    }

    @Override
    public void visit(FuncDeclNode node) {
        String key = "$FUNC_" + node.getName();
        FuncSymbol funcSymbol = (FuncSymbol)currentSymbolTable.get(node.getLocation(), node.getName(), key);//find the symbol
        currentType = funcSymbol.getReturntype();
        if(currentType instanceof ClassType){
            String name = ((ClassType)currentType).getName();
            String classkey = "$CLASS_" + name;
            currentSymbolTable.get(node.getLocation(), name, classkey);
        }
        node.getBody().setSymbolTable(currentSymbolTable);//go into the block, create a new symbolTable
        currentSymbolTable = node.getBody().getSymbolTable();//renew the current symbolTable
        if (currentClassType != null) {
            String thiskey = "$VAR_this";
            currentSymbolTable.put(node.getLocation(), "this", thiskey, new VarSymbol("this", currentClassType));
            if (node.isConstruct() && !(node.getName().equals(currentClassType.getName())))
                throw new SemanticError(node.getLocation(), String.format("Function \"%s\" should have a return type", node.getName()));
        }
        for (VarDeclNode varDeclNode : node.getFormalParameters())
            varDeclNode.accept(this);
         node.getBody().accept(this);
    }

    @Override
    public void visit(ClassDeclNode node) {
        String classkey = "$CLASS_" + node.getName();
        ClassSymbol classSymbol = (ClassSymbol) currentSymbolTable.get(node.getLocation(), node.getName(), classkey);
        currentSymbolTable = classSymbol.getSymbolTable();
        currentClassType = (ClassType) classSymbol.getType();
        for (FuncDeclNode funcDeclNode : node.getFuncMember())
            funcDeclNode.accept(this);
        currentClassType = null;
        currentSymbolTable = currentSymbolTable.getParent(); // should be globalScope
    }

    @Override
    public void visit(VarDeclListNode node) {

    }

    @Override
    public void visit(VarDeclNode node) {
        Type type = node.getType().getType();
        if(type instanceof  ClassType){
            String classname = (((ClassType)type).getName());
            String key = "$CLASS_" + classname;
            currentSymbolTable.get(node.getLocation(), classname, key);
        }
        VarCheck(node);
        VarSymbol varSymbol = new VarSymbol(node);
        if(currentSymbolTable == globalSymbolTable)
            varSymbol.setGlobal(true);
        String key = "$VAR_" + node.getName();
        currentSymbolTable.put(node.getLocation(), node.getName(), key, varSymbol);
    }

    @Override
    public void visit(StatNode node) {

    }

    @Override
    public void visit(BlockStatNode node) {
        node.setSymbolTable(currentSymbolTable);
        currentSymbolTable = node.getSymbolTable();
        for(Node blockbody : node.getBlockbody()){
            if(blockbody instanceof StatNode) {
                if (blockbody instanceof BlockStatNode) {
                    ((BlockStatNode) blockbody).setSymbolTable(currentSymbolTable);
                    currentSymbolTable = ((BlockStatNode) blockbody).getSymbolTable();
                }
                blockbody.accept(this);
            }
            else if(blockbody instanceof VarDeclNode)
                blockbody.accept(this);
            else
                throw new CompilerError((blockbody).getLocation(), "Invalid node type in block statement node");
        }
        currentSymbolTable = currentSymbolTable.getParent();
    }

    @Override
    public void visit(ExpressionStatNode node) {
        if(node.getExpr() != null)
            node.getExpr().accept(this);
    }

    @Override
    public void visit(IfStatNode node) {
        node.getCond().accept(this);
        if (!(node.getCond().getType() instanceof BoolType))
            throw new SemanticError(node.getCond().getLocation(), "Condition expression of condition statement should have type \"bool\"");
        if (node.getThenbody() != null)
            node.getThenbody().accept(this);
        if (node.getElsebody() != null)
            node.getElsebody().accept(this);
    }

    @Override
    public void visit(IterationStatNode node) {

    }

    @Override
    public void visit(WhileStatNode node) {
        Loop++;
        node.getCond().accept(this);
        if(!(node.getCond().getType() instanceof BoolType))
            throw new SemanticError(node.getCond().getLocation(),  "Condition expression of condition statement should have type \"bool\"");
        if(node.getWhilebody() != null)
            node.getWhilebody().accept(this);
        Loop--;
    }

    @Override
    public void visit(ForStatNode node) {
        Loop++;
        if(node.getInit() != null)
            node.getInit().accept(this);
        if(node.getCond() != null) {
            node.getCond().accept(this);
            if (!(node.getCond().getType() instanceof BoolType))
                throw new SemanticError(node.getLocation(), "cond must be a boolean expression");
        }
        if(node.getStep() != null)
            node.getStep().accept(this);
        if(node.getStat() != null)
            node.getStat().accept(this);
        Loop--;
    }

    @Override
    public void visit(JumpStatNode node) {
    }

    @Override
    public void visit(ContinueStatNode node) {
        if (Loop <= 0)
            throw new SemanticError(node.getLocation(), "Continue statement cannot be used outside of loop statement");
    }

    @Override
    public void visit(BreakStatNode node) {
        if (Loop <= 0)
            throw new SemanticError(node.getLocation(), "Break statement cannot be used outside of loop statement");
    }

    @Override
    public void visit(ReturnStatNode node) {
        boolean invalidReturnType = false;
        if(node.getExpr() == null){//no return value
            if(!(currentType == null || currentType instanceof VoidType))
                invalidReturnType = true;
        }
        else{//have return value
            node.getExpr().accept(this);
            if(node.getExpr().getType() == null || node.getExpr().getType() instanceof VoidType)
                invalidReturnType = true;
            else if(node.getExpr().getType() instanceof NullType){
                if(!(currentType instanceof ClassType || currentType instanceof ArrayType))
                    invalidReturnType = true;
            }
            else if(!(node.getExpr().getType().equals(currentType)))
                invalidReturnType = true;
        }
        if(invalidReturnType){
            if(currentType == null || currentType instanceof VoidType)
                throw new SemanticError(node.getLocation(), "Return statement should have no return value");
            else
                throw new SemanticError(node.getLocation(), String.format("Return statement should have return value of type \"%s\"", currentType.toString()));
        }
    }

    @Override
    public void visit(ExprNode node) {

    }

    @Override
    public void visit(SubscriptExprNode node) {
        node.getArray().accept(this);
        if(!(node.getArray().getType() instanceof ArrayType))
            throw new SemanticError(node.getArray().getLocation(), String.format("Type \"%s\" is not subscriptable", node.getArray().getType().toString()));
        node.getSub().accept(this);
        if(!(node.getSub().getType() instanceof IntType))
            throw new SemanticError(node.getSub().getLocation(), String.format("Subscript expression in subscription expression should have type \"int\", but got %s", node.getSub().getType().toString()));
        node.setType(((ArrayType) node.getArray().getType()).getBaseType());
        node.setLeftValue(true);
    }

    @Override
    public void visit(FuncCallExprNode node) {
        node.getFunction().accept(this);
        if(!(node.getFunction().getType() instanceof FuncType))
            throw new SemanticError(node.getFunction().getLocation(), String.format("Type \"%s\" is not callable", node.getFunction().getType().toString()));
        FuncSymbol funcSymbol = currentFuncSymbol;
        node.setFuncSymbol(funcSymbol);
        int paranum = funcSymbol.getParameters().size();
        if (paranum != node.getArgs().size())
            throw new SemanticError(node.getLocation(), String.format("Function call has inconsistent number of arguments, expected %d but got %d", paranum, node.getArgs().size()));
        for (int i = 0; i < paranum; i++) {
            node.getArgs().get(i).accept(this);
            if (node.getArgs().get(i).getType() instanceof VoidType)
                throw new SemanticError(node.getArgs().get(i).getLocation(), String.format("Function call has inconsistent type of arguments, expected %s but got %s", funcSymbol.getParameters().get(i).getType().toString(), node.getArgs().get(i).getType().toString()));
            else if (node.getArgs().get(i).getType() instanceof NullType){
                if(!(funcSymbol.getParameters().get(i).getType() instanceof ClassType || funcSymbol.getParameters().get(i).getType() instanceof ArrayType))
                    throw new SemanticError(node.getArgs().get(i).getLocation(), String.format("Function call has inconsistent type of arguments, expected %s but got %s", funcSymbol.getParameters().get(i).getType().toString(), node.getArgs().get(i).getType().toString()));
            }
            else if(!(funcSymbol.getParameters().get(i).getType().equals(node.getArgs().get(i).getType())))
                    throw new SemanticError(node.getArgs().get(i).getLocation(), String.format("Function call has inconsistent type of arguments, expected %s but got %s", funcSymbol.getParameters().get(i).getType().toString(), node.getArgs().get(i).getType().toString()));
        }
        node.setType(funcSymbol.getReturntype());
        node.setLeftValue(false);
    }

    @Override
    public void visit(MemAccessExprNode node) {
        node.getExpr().accept(this);
        String className;
        Type type = node.getExpr().getType();
        if(type instanceof ClassType)
            className = ((ClassType)type).getName();
        else if(type instanceof StringType)
            className = "string";
        else if(type instanceof ArrayType)
            className = "array";
        else
            throw new SemanticError(node.getLocation(), String.format("Type \"%s\" cannot be used in member access expression", type.toString()));
        String classkey = "$CLASS_" + className;
        ClassSymbol classSymbol = (ClassSymbol)currentSymbolTable.get(node.getLocation(), className, classkey);
        Symbol symbol = classSymbol.getSymbolTable().selfGetVarOrFunc(node.getLocation(), node.getMember());
        if(symbol instanceof FuncSymbol)
            currentFuncSymbol = (FuncSymbol) symbol;
        node.setType(symbol.getType());
        node.setLeftValue(true);
    }

    @Override
    public void visit(SuffixExprNode node) {
        node.getExpr().accept(this);
        if(!(node.getExpr().getType() instanceof IntType))
            throw new SemanticError(node.getLocation(), String.format("Operator \"%s\" cannot be applied to type \"%s\"", node.getOp().toString(), node.getExpr().getType().toString()));
        if(!(node.getExpr().isLeftValue()))
            throw new SemanticError(node.getLocation(), String.format("Operator \"%s\" cannot be applied to right value", node.getOp().toString()));
        node.setType(IntType.getIntType());
        node.setLeftValue(false);
    }

    @Override
    public void visit(PrefixExprNode node) {
        node.getExpr().accept(this);
        switch(node.getOp()){
            case PLUS_PLUS: case MINUS_MINUS:
                if(!(node.getExpr().getType() instanceof IntType))
                    throw new SemanticError(node.getLocation(), String.format("Operator \"%s\" cannot be applied to type \"%s\"", node.getOp().toString(), node.getExpr().getType().toString()));
                if(!(node.getExpr().isLeftValue()))
                    throw new SemanticError(node.getLocation(), String.format("Operator \"%s\" cannot be applied to right value", node.getOp().toString()));
                node.setType(IntType.getIntType());
                node.setLeftValue(true);
                break;
            case PLUS: case MINUS: case TILDE:
                if(!(node.getExpr().getType() instanceof IntType))
                    throw new SemanticError(node.getLocation(), String.format("Operator \"%s\" cannot be applied to type \"%s\"", node.getOp().toString(), node.getExpr().getType().toString()));
                node.setType(IntType.getIntType());
                node.setLeftValue(true);
                break;
            case NOT:
                if(!(node.getExpr().getType() instanceof BoolType))
                    throw new SemanticError(node.getLocation(), String.format("Operator \"%s\" cannot be applied to type \"%s\"", node.getOp().toString(), node.getExpr().getType().toString()));
                node.setType(BoolType.getBoolType());
                node.setLeftValue(false);
                break;
            default:
                throw new CompilerError(node.getLocation(), "Invalid prefix operator");
        }
    }

    @Override
    public void visit(NewExprNode node) {
        if(node.getDims() != null){
            for(ExprNode dim : node.getDims()){
                dim.accept(this);
                if(!(dim.getType() instanceof IntType))
                    throw new SemanticError(dim.getLocation(), "dimension size of array should be integer type");
            }
        }
        node.setType(node.getNewType().getType());
        node.setLeftValue(false);
    }

    @Override
    public void visit(BinaryExprNode node) {
        node.getRight().accept(this);
        node.getLeft().accept(this);
        Type leftType = node.getLeft().getType();
        Type rightType = node.getRight().getType();
        switch(node.getOp()){
            case MUL: case DIV: case MOD: case ADD:
                if(leftType instanceof StringType && rightType instanceof StringType){
                    node.setType(StringType.getStringType());
                    node.setLeftValue(false);
                    break;
                }
            case SUB: case LEFT_SHIFT: case RIGHT_SHIFT: case OR: case AND: case CARET:
                if(!(leftType instanceof IntType))
                    throw new SemanticError(node.getLocation(), String.format("Operator \"%s\" cannot be applied to type \"%s\"", node.getOp().toString(), leftType.toString()));
                if(!(rightType instanceof IntType))
                    throw new SemanticError(node.getLocation(), String.format("Operator \"%s\" cannot be applied to type \"%s\"", node.getOp().toString(), rightType.toString()));
                node.setType(IntType.getIntType());
                node.setLeftValue(false);
                break;
            case LESS: case GREATER: case LESS_EQUAL: case GREATER_EQUAL:
                if(!(leftType instanceof IntType || leftType instanceof StringType))
                    throw new SemanticError(node.getLocation(), String.format("Operator \"%s\" cannot be applied to type \"%s\"", node.getOp().toString(), leftType.toString()));
                if(!(rightType instanceof IntType || rightType instanceof StringType))
                    throw new SemanticError(node.getLocation(), String.format("Operator \"%s\" cannot be applied to type \"%s\"", node.getOp().toString(), rightType.toString()));
                if(!(leftType.equals(rightType)))
                    throw new SemanticError(node.getLocation(), String.format("Operator \"%s\" cannot be applied to different types \"%s\" and \"%s\"", node.getOp().toString(), leftType.toString(), rightType.toString()));
                node.setType(BoolType.getBoolType());
                node.setLeftValue(false);
                break;
            case EQUAL: case NOT_EQUAL:
                boolean invalidCompareType;
                if (leftType instanceof VoidType ||rightType instanceof VoidType)
                    invalidCompareType = true;
                else if (leftType.equals(rightType))
                    invalidCompareType = false;
                else if (leftType instanceof NullType)
                    invalidCompareType = !(rightType instanceof ClassType || rightType instanceof ArrayType);
                else if (rightType instanceof NullType)
                    invalidCompareType = !(leftType instanceof ClassType || leftType instanceof ArrayType);
                else
                    invalidCompareType = true;
                if (invalidCompareType)
                    throw new SemanticError(node.getLocation(), String.format("Operator \"%s\" cannot be applied to different types \"%s\" and \"%s\"", node.getOp().toString(), leftType.toString(), rightType.toString()));
                node.setType(BoolType.getBoolType());
                node.setLeftValue(false);
                break;
            case OR_OR: case AND_AND:
                if(!(leftType instanceof BoolType))
                    throw new SemanticError(node.getLocation(), String.format("Operator \"%s\" cannot be applied to type \"%s\"", node.getOp().toString(), leftType.toString()));
                if(!(rightType instanceof BoolType))
                    throw new SemanticError(node.getLocation(), String.format("Operator \"%s\" cannot be applied to type \"%s\"", node.getOp().toString(), rightType.toString()));
                node.setType(BoolType.getBoolType());
                node.setLeftValue(false);
                break;
            default:
                throw new CompilerError(node.getLocation(), "Invalid binary operator");
        }
    }

    @Override
    public void visit(AssignExprNode node) {
        node.getLeft().accept(this);
        node.getRight().accept(this);
        Type leftType = node.getLeft().getType();
        Type rightType = node.getRight().getType();
        if(!(node.getLeft().isLeftValue()))
            throw new SemanticError(node.getLocation(), "Lhs of assignment statement should be left value");
        if (AssignCheck(leftType, rightType))
            throw new SemanticError(node.getLocation(), String.format("Assignment operator cannot be applied to different types \"%s\" and \"%s\"", node.getLeft().getType().toString(), node.getRight().getType().toString()));
        node.setType(leftType);
        node.setLeftValue(false);
    }

    private boolean AssignCheck(Type leftType, Type rightType){
        boolean assignCheck;
        if (leftType instanceof VoidType || rightType instanceof VoidType)
            assignCheck = true;
        else if (leftType.equals(rightType))
            assignCheck = false;
        else if (rightType instanceof NullType)
            assignCheck = !(leftType instanceof ClassType || leftType instanceof ArrayType);
        else
            assignCheck = true;
        return assignCheck;
    }

    @Override
    public void visit(IdentifierExprNode node) {
        String name = node.getIdentifier();
        Symbol symbol = currentSymbolTable.getVarOrFunc(node.getLocation(), name);
        if(symbol instanceof VarSymbol){
            node.setVarSymbol((VarSymbol)symbol);
            node.setLeftValue(true);
        }
        else if(symbol instanceof FuncSymbol){
            currentFuncSymbol = (FuncSymbol)symbol;
            node.setLeftValue(false);
        }
        else
            throw new CompilerError(node.getLocation(), "Invalid symbol type for identifier");
        node.setType(symbol.getType());
    }

    @Override
    public void visit(ThisExprNode node) {
        Symbol symbol = currentSymbolTable.getVarOrFunc(node.getLocation(), "this");
        if (!(symbol instanceof VarSymbol))
            throw new SemanticError(node.getLocation(), "Invalid symbol type");
        node.setType(symbol.getType());
        node.setLeftValue(false);
    }

    @Override
    public void visit(ConstantExprNode node) {

    }

    @Override
    public void visit(BoolConstExprNode node) {
        node.setType(BoolType.getBoolType());
        node.setLeftValue(false);
    }

    @Override
    public void visit(IntConstExprNode node) {
        node.setType(IntType.getIntType());
        node.setLeftValue(false);
    }

    @Override
    public void visit(StringConstExprNode node) {
        node.setType(StringType.getStringType());
        node.setLeftValue(false);
    }

    @Override
    public void visit(NullExprNode node) {
        node.setType(NullType.getNullType());
        node.setLeftValue(false);
    }

    @Override
    public void visit(TypeNode node) {

    }
}
