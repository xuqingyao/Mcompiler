package com.echo.compiler.IR.Inst;

import com.echo.compiler.IR.BasicBlock;
import com.echo.compiler.IR.Register.Value;
import com.echo.compiler.IR.Register.Register;
import com.echo.compiler.IR.IRVisitor;

import java.util.Map;

public class BinaryOpInst extends Inst {
    public enum BinaryOps{
        ADD, SUB, MUL, DIV, MOD,
        LEFT_SHIFT, RIGHT_SHIFT,
        AND, OR, CARET
    }

    public Register dest;
    public BinaryOps op;
    private Value lhs, rhs;

    public BinaryOpInst(BasicBlock parentBB, Register dest, BinaryOps op, Value lhs, Value rhs){
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

    public void setLhs(Value lhs) {
        this.lhs = lhs;
        reloadUsedRegistersRegValues();
    }

    public void setRhs(Value rhs) {
        this.rhs = rhs;
        reloadUsedRegistersRegValues();
    }

    public boolean isCommutativeOp(){
        return op == BinaryOpInst.BinaryOps.ADD || op == BinaryOpInst.BinaryOps.MUL || op == BinaryOpInst.BinaryOps.AND || op == BinaryOpInst.BinaryOps.OR || op == BinaryOpInst.BinaryOps.CARET;
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
    public BinaryOpInst copyRename(Map<Object, Object> renameMap) {
        BasicBlock ParentBB = (BasicBlock)renameMap.getOrDefault(parentBB, parentBB);
        Register Dest = (Register)renameMap.getOrDefault(dest, dest);
        Value Lhs = (Value)renameMap.getOrDefault(lhs, lhs);
        Value Rhs = (Value)renameMap.getOrDefault(rhs, rhs);
        BinaryOpInst binaryOpInst = new BinaryOpInst(ParentBB, Dest, op, Lhs, Rhs);
        return binaryOpInst;
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
