package com.echo.compiler.IR.Register;

import com.echo.compiler.IR.IRVisitor;

public abstract class Register extends Value {
    public abstract void accept(IRVisitor visitor);
}
