package com.echo.compiler.IR.Register;

import com.echo.compiler.IR.IRVisitor;

public class VirtualRegister extends Register {
    public String name;
    public PhysicalRegister forcedPhysicalRegister = null;

    public VirtualRegister(String name){
        this.name = name;
    }

    @Override
    public VirtualRegister copy() {
        return new VirtualRegister(name);
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
