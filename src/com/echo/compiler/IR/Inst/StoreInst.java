package com.echo.compiler.IR.Inst;

import com.echo.compiler.IR.BasicBlock;
import com.echo.compiler.IR.Register.Value;
import com.echo.compiler.IR.Register.Register;
import com.echo.compiler.IR.Register.StackSlot;
import com.echo.compiler.IR.Register.StaticData;
import com.echo.compiler.IR.IRVisitor;

import java.util.Map;

public class StoreInst extends Inst {
    public Value value;
    public Value addr;
    public int size;
    public int addrOffset;
    public boolean isStatic;

    public StoreInst(BasicBlock parentBB, Value value, Value addr, int size, int addrOffset){
        super(parentBB);
        this.value = value;
        this.addr = addr;
        if(size == 0)
            System.err.println("size is 0");
        this.size = size;
        this.addrOffset = addrOffset;
        this.isStatic = false;
        reloadUsedRegistersRegValues();
    }

    public StoreInst(BasicBlock parentBB, Value value, StaticData addr, int size){
        this(parentBB, value, addr, size, 0);
        if(size == 0)
            System.err.println("size is 0");
        this.isStatic = true;
    }

    @Override
    public Register getDefinedRegister() {
        return null;
    }

    @Override
    public void setUsedRegisters(Map<Register, Register> renameMap) {
        if(addr instanceof Register && !(addr instanceof StackSlot))
            addr = renameMap.get(addr);
        if(value instanceof Register)
            value = renameMap.get(value);
        reloadUsedRegistersRegValues();
    }

    @Override
    public void setDefinedRegister(Register reg) {

    }

    @Override
    public StoreInst copyRename(Map<Object, Object> renameMap) {
        BasicBlock ParentBB = (BasicBlock)renameMap.getOrDefault(parentBB, parentBB);
        Value Value = (Value)renameMap.getOrDefault(value, value);
        if(isStatic){
            StaticData Addr = (StaticData)renameMap.getOrDefault(addr, addr);
            StoreInst storeInst = new StoreInst(ParentBB, Value, Addr, size);
            return storeInst;
        }
        else{
            Value Addr = (Value)renameMap.getOrDefault(addr, addr);
            StoreInst storeInst = new StoreInst(ParentBB, Value, Addr, size, addrOffset);
            return storeInst;
        }
    }

    @Override
    public void reloadUsedRegistersRegValues() {
        usedRegValues.clear();
        usedRegisters.clear();
        if(addr instanceof Register && !(addr instanceof StackSlot))
            usedRegisters.add((Register)addr);
        if(value instanceof Register)
            usedRegisters.add((Register)value);
        usedRegValues.add(addr);
        usedRegValues.add(value);
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
