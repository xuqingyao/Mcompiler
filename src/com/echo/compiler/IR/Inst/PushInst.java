package com.echo.compiler.IR.Inst;

import com.echo.compiler.IR.BasicBlock;
import com.echo.compiler.IR.Register.Value;
import com.echo.compiler.IR.Register.Register;
import com.echo.compiler.IR.IRVisitor;

import java.util.Map;

public class PushInst extends Inst {
    public Value value;

    public PushInst(BasicBlock parentBB, Value value){
        super(parentBB);
        this.value = value;
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
    public PushInst copyRename(Map<Object, Object> renameMap) {
        return null;
    }

    @Override
    public void reloadUsedRegistersRegValues() {

    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
