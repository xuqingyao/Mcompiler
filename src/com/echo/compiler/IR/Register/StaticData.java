package com.echo.compiler.IR.Register;

import com.echo.compiler.IR.IRVisitor;

public abstract class StaticData extends Register {
    public String name;
    public int size;

    public StaticData(String name, int size){
        this.name = name;
        this.size = size;
    }

    @Override
    public StaticData copy() {
        return this;
    }

    public abstract void accept(IRVisitor visitor);
}
