package com.echo.compiler.IR.Register;

import com.echo.compiler.IR.IRVisitor;

public class IntImmValue extends Value {
    public int value;

    public IntImmValue(int value){
        this.value = value;
    }

    @Override
    public IntImmValue copy() {
        return new IntImmValue(value);
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
