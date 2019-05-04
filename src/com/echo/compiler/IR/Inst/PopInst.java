package com.echo.compiler.IR.Inst;

import com.echo.compiler.IR.BasicBlock;
import com.echo.compiler.IR.Register.PhysicalRegister;
import com.echo.compiler.IR.Register.Register;
import com.echo.compiler.IR.IRVisitor;

import java.util.Map;

public class PopInst extends Inst {
    public PhysicalRegister preg;

    public PopInst(BasicBlock parnetBB, PhysicalRegister preg){
        super(parnetBB);
        this.preg = preg;
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
    public PopInst copyRename(Map<Object, Object> renameMap) {
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
