package com.echo.compiler.IR.Inst;

import com.echo.compiler.IR.BasicBlock;
import com.echo.compiler.IR.Register.Value;
import com.echo.compiler.IR.Register.Register;
import com.echo.compiler.IR.IRVisitor;

import java.util.Map;

public class BranchJumpInst extends JumpInst{
    public Value cond;
    public BasicBlock thenBB;
    public BasicBlock elseBB;

    public BranchJumpInst(BasicBlock parentBB, Value cond, BasicBlock thenBB, BasicBlock elseBB){
        super(parentBB);
        this.cond = cond;
        this.thenBB = thenBB;
        this.elseBB = elseBB;
        reloadUsedRegistersRegValues();
    }


    @Override
    public Register getDefinedRegister(){
        return null;
    }

    @Override
    public void setUsedRegisters(Map<Register, Register> renameMap) {
        if(cond instanceof Register)
            cond = renameMap.get(cond);
        reloadUsedRegistersRegValues();
    }

    @Override
    public void setDefinedRegister(Register register){

    }

    @Override
    public BranchJumpInst copyRename(Map<Object, Object> renameMap){
        BasicBlock ParentBB = (BasicBlock)renameMap.getOrDefault(parentBB, parentBB);
        Value Cond = (Value)renameMap.getOrDefault(cond, cond);
        BasicBlock ThenBB = (BasicBlock)renameMap.getOrDefault(thenBB, thenBB);
        BasicBlock ElseBB = (BasicBlock)renameMap.getOrDefault(elseBB, elseBB);
        BranchJumpInst branchJumpInst = new BranchJumpInst(ParentBB, Cond, ThenBB, ElseBB);
        return branchJumpInst;
    }

    @Override
    public void reloadUsedRegistersRegValues() {
        usedRegisters.clear();
        usedRegValues.clear();
        if(cond instanceof Register)
            usedRegisters.add((Register)cond);
        usedRegValues.add(cond);
    }

    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
}
