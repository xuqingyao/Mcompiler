package com.echo.compiler.IR.Register;

import com.echo.compiler.IR.IRVisitor;

public abstract class Value {
    public abstract Value copy();
    public abstract void accept(IRVisitor visitor);
}
