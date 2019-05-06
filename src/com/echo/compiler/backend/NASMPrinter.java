package com.echo.compiler.backend;

import com.echo.compiler.IR.BasicBlock;
import com.echo.compiler.IR.Func;
import com.echo.compiler.IR.IRRoot;
import com.echo.compiler.IR.IRVisitor;
import com.echo.compiler.IR.Inst.*;
import com.echo.compiler.IR.Register.*;
import com.echo.compiler.error.CompilerError;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class NASMPrinter implements IRVisitor{
    public PrintStream out;
    public Map<String, Integer> IDCounter = new HashMap<>();
    public Map<Object, Object> IDMap = new HashMap<>();
    public PhysicalRegister reg0;
    private boolean isBssSection, isDataSection;

    public NASMPrinter(PrintStream out){
        this.out = out;
    }

    private String newID(String id){
        int cnt = IDCounter.getOrDefault(id, 0) + 1;
        IDCounter.put(id, cnt);
        return id + "_" + cnt;
    }

    private String dataID(StaticData data){
        String id = (String)IDMap.get(data);
        if(id == null){
            id = "Static_Data_" + newID(data.name);
            IDMap.put(data, id);
        }
        return id;
    }

    private String BlockID(BasicBlock BB){
        String id = (String)IDMap.get(BB);
        if(id == null){
            id = "Block_" + newID(BB.name);
            IDMap.put(BB, id);
        }
        return id;
    }

    @Override
    public void visit(IRRoot node) {
        //some pre job
        reg0 = node.reg0;
        IDMap.put(node.funcs.get("main").startBB, "main");
        out.println("\t\tglobal\tmain\n");
        out.println("\t\textern\tmalloc\n");

        //process the data
        if(node.staticDataList.size() > 0){
            isBssSection = true;
            out.println("\t\tsection\t.bss");
            for(StaticData staticData : node.staticDataList)
                staticData.accept(this);
            out.println();
            isBssSection = false;
        }

        if (node.staticStrs.size() > 0) {
            isDataSection = true;
            out.println("\t\tsection\t.data");
            for (StaticStringData staticString : node.staticStrs.values())
                staticString.accept(this);
            out.println();
            isDataSection = false;
        }

        //process function
        out.println("\t\tsection\t.text\n");
        for(Func func : node.funcs.values())
            func.accept(this);
        out.println();

        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader("lib/builtin_functions.asm"));
            String line;
            while((line = bufferedReader.readLine()) != null)
                out.println(line);
        }
        catch (IOException exception) {
            throw new CompilerError("IO exception when reading builtin function from file");
        }
    }

    @Override
    public void visit(Func node) {
        out.println("# function " + node.name + "\n");
        for(BasicBlock BB : node.getReversePostOrder())
            BB.accept(this);
    }

    @Override
    public void visit(BasicBlock node) {
        out.println(BlockID(node) + ":");
        for(Inst inst = node.firstInst; inst != null; inst = inst.nextInst)
            inst.accept(this);
        out.println();
    }

    @Override
    public void visit(BranchJumpInst node) {
        if(node.cond instanceof IntImmValue){//bool constant
            int boolValue = ((IntImmValue)node.cond).value;
            String next = boolValue == 1 ? BlockID(node.thenBB) : BlockID(node.elseBB);
            out.println("\t\tjmp\t\t" + next);
        }
        else {//bool expr
            out.print("\t\tcmp\t\t");
            node.cond.accept(this);
            out.println(", 1");
            out.println("\t\tje\t\t" + BlockID(node.thenBB));
            if (node.elseBB.postOrderIdx + 1 != node.parentBB.postOrderIdx)
                out.println("\t\tjmp\t\t" + BlockID(node.elseBB));
        }
    }

    @Override
    public void visit(JumpJumpInst node) {
        if(node.targetBB.postOrderIdx + 1 != node.parentBB.postOrderIdx)
            out.println("\t\tjmp\t\t" + BlockID(node.targetBB));
    }

    @Override
    public void visit(ReturnJumpInst node) {
        out.println("\t\tret");
    }

    @Override
    public void visit(UnaryOpInst node) {
        String op = null;
        switch (node.op){
            case MIUNS:
                op = "neg";
                break;
            case TILDE:
                op = "not";
                break;
        }
        out.print("\t\tmov\t\t");
        node.dest.accept(this);
        out.print(", ");
        node.rhs.accept(this);
        out.print("\n\t\t" + op + "\t\t");
        node.dest.accept(this);
        out.println();
    }

    @Override
    public void visit(BinaryOpInst node) {
        if(node.op == BinaryOpInst.BinaryOps.DIV || node.op == BinaryOpInst.BinaryOps.MOD){
            out.print("\t\tmov\t\trbx, ");
            node.getRhs().accept(this);
            out.print("\n\t\tmov\t\trax, ");
            node.getLhs().accept(this);
            out.println("\n\t\tmov\t\t" + reg0.getName() + ", rdx");//restore the value of rdx
            out.println("\t\tcdq");//Convert Double to Quad
            out.println("\t\tidiv\trbx");
            out.print("\t\tmov\t\t");
            node.dest.accept(this);
            if(node.op == BinaryOpInst.BinaryOps.DIV)
                out.println(", rax");//rax restore the quotient
            else
                out.println(", rdx");//rdx restore the remainder
            out.println("\t\tmov\t\trdx, " + reg0.getName());//recover the rbx
        }
        else if(node.op == BinaryOpInst.BinaryOps.LEFT_SHIFT || node.op == BinaryOpInst.BinaryOps.RIGHT_SHIFT){
            out.println("\t\tmov\t\trbx, rcx");
            out.print("\t\tmov\t\trcx, ");
            node.getRhs().accept(this);
            if(node.op == BinaryOpInst.BinaryOps.LEFT_SHIFT)
                out.print("\n\t\tsal\t\t");
            else
                out.print("\n\t\tsar\t\t");
            node.getLhs().accept(this);
            out.println(", cl");
            out.println("\t\tmov\t\trcx, rbx");
            out.print("\t\tand\t\t");
            node.getLhs().accept(this);
            out.println(", -1");
        }
        else{
            if(node.dest != node.getLhs())
                throw new CompilerError("binary operation should have same dest and lhs");
            String op = null;
            switch (node.op){
                case ADD:
                    if(node.getRhs() instanceof IntImmValue && ((IntImmValue) node.getRhs()).value == 1){//some optimization
                        out.print("\t\tinc\t\t");
                        node.getLhs().accept(this);
                        out.println();
                        return;
                    }
                    op = "add";
                    break;
                case SUB:
                    if(node.getRhs() instanceof IntImmValue && ((IntImmValue) node.getRhs()).value == 1){
                        out.print("\t\tdec\t\t");
                        node.getLhs().accept(this);
                        out.println();
                        return;
                    }
                    op = "sub";
                    break;
                case MUL:
                    if (node.getRhs() instanceof IntImmValue && ((IntImmValue) node.getRhs()).value == 1)
                        return;
                    op = "imul";
                    break;
                case OR:
                    op = "or";
                    break;
                case CARET:
                    op = "xor";
                    break;
                case AND:
                    op = "and";
                    break;
            }
            out.print("\t\t" + op + "\t\t");
            node.getLhs().accept(this);
            out.print(", ");
            node.getRhs().accept(this);
            out.println();
        }
    }

    @Override
    public void visit(CompareInst node) {
        if(node.getLhs() instanceof PhysicalRegister){
            out.print("\t\tand\t\t");
            node.getLhs().accept(this);
            out.println(", -1");
        }
        if(node.getRhs() instanceof PhysicalRegister){
            out.print("\t\tand\t\t");
            node.getRhs().accept(this);
            out.println(", -1");
        }
        out.println("\t\txor\t\trax, rax");
        out.print("\t\tcmp\t\t");
        node.getLhs().accept(this);
        out.print(", ");
        node.getRhs().accept(this);
        out.println();
        String op = null;
        switch (node.op){
            case EQUAL:
                op = "sete";
                break;
            case NOT_EQUAL:
                op = "setne";
                break;
            case LESS:
                op = "setl";
                break;
            case LESS_EQUAL:
                op = "setle";
                break;
            case GREATER:
                op = "setg";
                break;
            case GREATER_EQUAL:
                op = "setge";
                break;
        }
        out.println("\t\t" + op + "\tal");
        out.print("\t\tmov\t\t");
        node.dest.accept(this);
        out.println(", rax");
    }

    @Override
    public void visit(MoveInst node) {
        out.print("\t\tmov\t\t");
        node.dest.accept(this);
        out.print(", ");
        node.source.accept(this);
        out.println();
    }

    private String StringSize(int size){
        String string = null;
        switch (size){
            case 1:
                string = "byte";
                break;
            case 2:
                string = "word";
                break;
            case 4:
                string = "dword";
                break;
            case 8:
                string = "qword";
                break;
        }
        return string;
    }

    @Override
    public void visit(LoadInst node) {
        if(node.addr instanceof StaticStringData){
            out.print("\t\tmov\t\t");
            node.dest.accept(this);
            out.print(", " + StringSize(node.size) + " ");
            node.addr.accept(this);
            out.println();
            return;
        }
        out.print("\t\tmov\t\t");
        node.dest.accept(this);
        out.print(", " + StringSize(node.size) + " [");
        node.addr.accept(this);
        if(node.addrOffset < 0)
            out.print(node.addrOffset);
        else if(node.addrOffset > 0)
            out.print("+" + node.addrOffset);
        out.println("]");
    }

    @Override
    public void visit(StoreInst node) {
        if(node.addr instanceof StaticStringData){
            out.print("\t\tmov\t\t" + StringSize(node.size) + " ");
            node.addr.accept(this);
            out.print(", ");
            node.value.accept(this);
            out.println();
            return;
        }
        out.print("\t\tmov\t\t" + StringSize(node.size) + " [");
        node.addr.accept(this);
        if(node.addrOffset < 0)
            out.print(node.addrOffset);
        else if(node.addrOffset > 0)
            out.print("+" + node.addrOffset);
        out.print("], ");
        node.value.accept(this);
        out.println();
    }

    @Override
    public void visit(FuncCallInst node) {
        if(node.func.isBuildIn)
            out.println("\t\tcall\t" + node.func.buildInCallLabel);
        else
            out.println("\t\tcall\t" + BlockID(node.func.startBB));
    }

    @Override
    public void visit(HeapAllocInst node) {
        out.println("\t\tcall\tmalloc");
    }

    @Override
    public void visit(PopInst node) {
        out.print("\t\tpop\t\t");
        node.preg.accept(this);
        out.println();
    }

    @Override
    public void visit(PushInst node) {
        out.print("\t\tpush\t");
        node.value.accept(this);
        out.println();
    }

    @Override
    public void visit(VirtualRegister node) {
    }

    @Override
    public void visit(PhysicalRegister node) {
        out.print(node.getName());
    }

    @Override
    public void visit(IntImmValue node) {
        out.print(node.value);
    }

//    resb, resw, resd, resq are designed to be used in the BSS section of a module: they declare uninitialized storage space.
    @Override
    public void visit(StaticVarData node) {
        if(isBssSection){
            String op = null;
            switch (node.size){
                case 1:
                    op = "resb";
                    break;
                case 2:
                    op = "resw";
                    break;
                case 4:
                    op = "resd";
                    break;
                case 8:
                    op = "resq";
                    break;
            }
            out.println(dataID(node) + ":\t" + op + "\t1");
        }
        else
            out.print(dataID(node));
    }

    private String staticStringDataSection(String string){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 1; i < string.length() - 1; ++ i){
            char c = string.charAt(i);
            stringBuilder.append((int)c);
            stringBuilder.append(", ");
        }
        stringBuilder.append(0);
        return stringBuilder.toString();
    }

//    db, dw, dd, dq are used, much as in MASM, to declare initialized data in the output file.
    @Override
    public void visit(StaticStringData node) {
        if(isDataSection){
            out.println(dataID(node) + ":");
            out.println("\t\tdq\t\t" + node.value.length());
            out.println("\t\tdb\t\t" + staticStringDataSection(node.value));
        }
        else
            out.print(dataID(node));
    }
}
