package com.echo.compiler.IR.Inst;

import com.echo.compiler.IR.BasicBlock;
import com.echo.compiler.IR.Register.Register;
import com.echo.compiler.IR.IRVisitor;

import java.util.Map;

public class JumpJumpInst extends JumpInst{
    public BasicBlock targetBB;

    public JumpJumpInst(BasicBlock parentBB, BasicBlock targetBB){
        super(parentBB);
        this.targetBB = targetBB;
    }

    @Override
    public Register getDefinedRegister() {
        return null;
    }

    @Override
    public void setUsedRegisters(Map<Register, Register> renameMap) {

    }

    @Override
    public void setDefinedRegister(Register reg) {

    }

    @Override
    public JumpJumpInst copyRename(Map<Object, Object> renameMap) {
        BasicBlock ParentBB = (BasicBlock)renameMap.getOrDefault(parentBB, parentBB);
        BasicBlock TargetBB = (BasicBlock)renameMap.getOrDefault(targetBB, targetBB);
        JumpJumpInst jumpJumpInst = new JumpJumpInst(ParentBB, TargetBB);
        return jumpJumpInst;
    }

    @Override
    public void reloadUsedRegistersRegValues() {

    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
