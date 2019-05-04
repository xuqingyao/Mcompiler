package com.echo.compiler.IR.Inst;

import com.echo.compiler.IR.BasicBlock;
import com.echo.compiler.IR.Register.Value;
import com.echo.compiler.IR.Register.Register;
import com.echo.compiler.IR.Register.StackSlot;
import com.echo.compiler.IR.Register.StaticData;
import com.echo.compiler.IR.IRVisitor;

import java.util.Map;

public class LoadInst extends Inst {
    public Register dest;
    public Value addr;
    public int size;
    public int addrOffset;
    public boolean isStatic;
    public boolean isLoadAddr;

    public LoadInst(BasicBlock parentBB, Register dest, Value addr, int size, int addrOffset){
        super(parentBB);
        this.dest = dest;
        this.addr = addr;
        if(size == 0)
            System.err.println("size is 0");
        this.size = size;
        this.addrOffset = addrOffset;
        this.isStatic = false;
        reloadUsedRegistersRegValues();
    }

    public LoadInst(BasicBlock parentBB, Register dest, StaticData addr, int size, boolean isLoadAddr){
        this(parentBB, dest, addr, size, 0);
        this.isStatic = true;
        this.isLoadAddr = isLoadAddr;
    }

    @Override
    public Register getDefinedRegister() {
        return dest;
    }

    @Override
    public void setUsedRegisters(Map<Register, Register> renameMap) {
        if(addr instanceof Register && !(addr instanceof StackSlot))
            addr = renameMap.get(addr);
        reloadUsedRegistersRegValues();
    }

    @Override
    public void setDefinedRegister(Register reg) {
        dest = reg;
    }

    @Override
    public LoadInst copyRename(Map<Object, Object> renameMap) {
        BasicBlock ParentBB = (BasicBlock)renameMap.getOrDefault(parentBB, parentBB);
        Register Dest = (Register) renameMap.getOrDefault(dest, dest);
        if(isStatic){
            StaticData Addr = (StaticData)renameMap.getOrDefault(addr, addr);
            LoadInst loadInst = new LoadInst(ParentBB, Dest, Addr, size, isLoadAddr);
            return loadInst;
        }
        else{
            Value Addr = (Value)renameMap.getOrDefault(addr, addr);
            LoadInst loadInst = new LoadInst(ParentBB, Dest, Addr, size, addrOffset);
            return loadInst;
        }
    }

    @Override
    public void reloadUsedRegistersRegValues() {
        usedRegisters.clear();
        usedRegValues.clear();
        if(addr instanceof Register && !(addr instanceof StackSlot))
            usedRegisters.add((Register)addr);
        usedRegValues.add(addr);
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
