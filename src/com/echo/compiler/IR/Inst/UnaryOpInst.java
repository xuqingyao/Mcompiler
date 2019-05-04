package com.echo.compiler.IR.Inst;

import com.echo.compiler.IR.BasicBlock;
import com.echo.compiler.IR.Register.Value;
import com.echo.compiler.IR.Register.Register;
import com.echo.compiler.IR.IRVisitor;

import java.util.Map;

public class UnaryOpInst extends Inst {
    public enum UnaryOps{
        MIUNS, TILDE
    }

    public Register dest;
    public UnaryOps op;
    public Value rhs;

    public UnaryOpInst(BasicBlock parentBB, Register dest, UnaryOps op, Value rhs){
        super(parentBB);
        this.dest = dest;
        this.op = op;
        this.rhs = rhs;
        reloadUsedRegistersRegValues();
    }

    @Override
    public Register getDefinedRegister() {
        return dest;
    }

    @Override
    public void setUsedRegisters(Map<Register, Register> renameMap) {
        if (rhs instanceof Register)
            rhs = renameMap.get(rhs);
        reloadUsedRegistersRegValues();
    }

    @Override
    public void setDefinedRegister(Register reg) {
        dest = reg;
    }

    @Override
    public UnaryOpInst copyRename(Map<Object, Object> renameMap) {
        BasicBlock ParentBB = (BasicBlock)renameMap.getOrDefault(parentBB, parentBB);
        Register Dest = (Register)renameMap.getOrDefault(dest, dest);
        Value Rhs = (Value)renameMap.getOrDefault(rhs, rhs);
        UnaryOpInst unaryOpInst = new UnaryOpInst(ParentBB, Dest, op, Rhs);
        return unaryOpInst;
    }

    @Override
    public void reloadUsedRegistersRegValues() {
        usedRegisters.clear();
        usedRegValues.clear();
        if (rhs instanceof Register)
            usedRegisters.add((Register) rhs);
        usedRegValues.add(rhs);
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}