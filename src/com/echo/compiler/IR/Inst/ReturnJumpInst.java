package com.echo.compiler.IR.Inst;

import com.echo.compiler.IR.BasicBlock;
import com.echo.compiler.IR.Register.Value;
import com.echo.compiler.IR.Register.Register;
import com.echo.compiler.IR.IRVisitor;

import java.util.Map;

public class ReturnJumpInst extends JumpInst{
    public Value returnvalue;

    public ReturnJumpInst(BasicBlock parentBB, Value returnvalue){
        super(parentBB);
        this.returnvalue = returnvalue;
        reloadUsedRegistersRegValues();
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
    public ReturnJumpInst copyRename(Map<Object, Object> renameMap) {
        BasicBlock ParentBB = (BasicBlock)renameMap.getOrDefault(parentBB, parentBB);
        Value Returnvalue = (Value)renameMap.getOrDefault(returnvalue, returnvalue);
        ReturnJumpInst returnJumpInst = new ReturnJumpInst(ParentBB, Returnvalue);
        return returnJumpInst;
    }

    @Override
    public void reloadUsedRegistersRegValues() {
        usedRegisters.clear();
        usedRegValues.clear();
        if(returnvalue != null){
            if(returnvalue instanceof  Register)
                usedRegisters.add((Register)returnvalue);
            usedRegValues.add(returnvalue);
        }
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
