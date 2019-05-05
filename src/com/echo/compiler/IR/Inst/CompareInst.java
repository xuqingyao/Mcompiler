package com.echo.compiler.IR.Inst;

import com.echo.compiler.IR.BasicBlock;
import com.echo.compiler.IR.Register.Value;
import com.echo.compiler.IR.Register.Register;
import com.echo.compiler.IR.IRVisitor;

import java.util.Map;

public class CompareInst extends Inst {
    public enum CompareOp{
        GREATER, LESS, GREATER_EQUAL, LESS_EQUAL, EQUAL, NOT_EQUAL
    }

    public Register dest;
    public CompareOp op;
    private Value lhs, rhs;

    public CompareInst(BasicBlock parentBB, Register dest, CompareOp op, Value lhs, Value rhs){
        super(parentBB);
        this.dest = dest;
        this.op = op;
        this.lhs = lhs;
        this.rhs = rhs;
        reloadUsedRegistersRegValues();
    }

    public Value getLhs() {
        return lhs;
    }

    public Value getRhs() {
        return rhs;
    }

    public void setLhs(Value lhs){
        this.lhs = lhs;
        reloadUsedRegistersRegValues();
    }

    @Override
    public Register getDefinedRegister() {
        return dest;
    }

    @Override
    public void setUsedRegisters(Map<Register, Register> renameMap) {
        if(lhs instanceof Register)
            lhs = renameMap.get(lhs);
        if(rhs instanceof Register)
            rhs = renameMap.get(rhs);
        reloadUsedRegistersRegValues();
    }

    @Override
    public void setDefinedRegister(Register reg) {
        dest = reg;
    }

    @Override
    public CompareInst copyRename(Map<Object, Object> renameMap) {
        BasicBlock ParentBB = (BasicBlock)renameMap.getOrDefault(parentBB, parentBB);
        Register Dest = (Register)renameMap.getOrDefault(dest, dest);
        Value Lhs = (Value)renameMap.getOrDefault(lhs, lhs);
        Value Rhs = (Value)renameMap.getOrDefault(rhs, rhs);
        CompareInst compareInst = new CompareInst(ParentBB, Dest, op, Lhs, Rhs);
        return compareInst;
    }

    @Override
    public void reloadUsedRegistersRegValues() {
        usedRegisters.clear();
        usedRegValues.clear();
        if(lhs instanceof Register)
            usedRegisters.add((Register)lhs);
        if(rhs instanceof Register)
            usedRegisters.add((Register)rhs);
        usedRegValues.add(lhs);
        usedRegValues.add(rhs);
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
