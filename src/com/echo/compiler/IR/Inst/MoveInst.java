package com.echo.compiler.IR.Inst;

import com.echo.compiler.IR.BasicBlock;
import com.echo.compiler.IR.Register.Value;
import com.echo.compiler.IR.Register.Register;
import com.echo.compiler.IR.IRVisitor;

import java.util.Map;

public class MoveInst extends Inst {
    public Register dest;
    public Value source;

    public MoveInst(BasicBlock parentBB, Register dest, Value source){
        super(parentBB);
        this.dest = dest;
        this.source = source;
        reloadUsedRegistersRegValues();
    }

    @Override
    public Register getDefinedRegister() {
        return dest;
    }

    @Override
    public void setUsedRegisters(Map<Register, Register> renameMap) {
        if(source instanceof Register)
            source = renameMap.get(source);
        reloadUsedRegistersRegValues();
    }

    @Override
    public void setDefinedRegister(Register reg) {
        dest = reg;
    }

    @Override
    public MoveInst copyRename(Map<Object, Object> renameMap) {
        BasicBlock ParentBB = (BasicBlock)renameMap.getOrDefault(parentBB, parentBB);
        Register Dest = (Register)renameMap.getOrDefault(dest, dest);
        Value Source = (Value)renameMap.getOrDefault(source, source);
        MoveInst moveInst = new MoveInst(ParentBB, Dest, Source);
        return moveInst;
    }

    @Override
    public void reloadUsedRegistersRegValues() {
        usedRegisters.clear();
        usedRegValues.clear();
        if(source instanceof Register)
            usedRegisters.add((Register)source);
        usedRegValues.add(source);
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
