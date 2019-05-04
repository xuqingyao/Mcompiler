package com.echo.compiler.IR.Register;

import com.echo.compiler.IR.IRVisitor;

public abstract class PhysicalRegister extends Register {
    @Override
    public PhysicalRegister copy() {
        return null;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public abstract String getName();
    public abstract boolean isGeneral();
    public abstract boolean isCallerSave();
    public abstract boolean isCalleeSave();
    public abstract int getArgIdx();
    public abstract boolean isFuncArg();
}
