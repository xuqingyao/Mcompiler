package com.echo.compiler.IR.Register;

import com.echo.compiler.IR.Func;
import com.echo.compiler.IR.IRVisitor;

public class StackSlot extends Register {
    public Func parentFunc;
    public String name;

    public StackSlot(Func parentFunc, String name, boolean isArgSlot){
        this.parentFunc = parentFunc;
        this.name = name;
        if(!isArgSlot)
            parentFunc.stackSlots.add(this);
    }

    @Override
    public StackSlot copy() {
        return null;
    }

    @Override
    public void accept(IRVisitor visitor) {

    }
}
