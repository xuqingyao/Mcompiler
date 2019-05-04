package com.echo.compiler.IR.Inst;

import com.echo.compiler.IR.BasicBlock;
import com.echo.compiler.IR.Register.Value;
import com.echo.compiler.IR.Register.Register;
import com.echo.compiler.IR.IRVisitor;

import java.util.Map;

public class HeapAllocInst extends Inst {
    public Register dest;
    public Value allocSize;

    public HeapAllocInst(BasicBlock parentBB, Register dest, Value allocSize){
        super(parentBB);
        this.dest = dest;
        this.allocSize = allocSize;
        reloadUsedRegistersRegValues();
    }

    @Override
    public Register getDefinedRegister() {
        return dest;
    }

    @Override
    public void setUsedRegisters(Map<Register, Register> renameMap) {
        if(allocSize instanceof Register)
            allocSize = renameMap.get(allocSize);
        reloadUsedRegistersRegValues();
    }

    @Override
    public void setDefinedRegister(Register reg) {
        dest = reg;
    }

    @Override
    public HeapAllocInst copyRename(Map<Object, Object> renameMap) {
        BasicBlock ParentBB = (BasicBlock)renameMap.getOrDefault(parentBB, parentBB);
        Register Dest = (Register)renameMap.getOrDefault(dest, dest);
        Value AllocSize = (Value)renameMap.getOrDefault(allocSize, allocSize);
        HeapAllocInst heapAllocInst = new HeapAllocInst(ParentBB, Dest, AllocSize);
        return heapAllocInst;
    }

    @Override
    public void reloadUsedRegistersRegValues() {
        usedRegisters.clear();
        usedRegValues.clear();
        if(allocSize instanceof Register)
            usedRegisters.add((Register)allocSize);
        usedRegValues.add(allocSize);
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
