package com.echo.compiler.IR.Register;

import com.echo.compiler.IR.IRVisitor;

public class StaticVarData extends StaticData {
    public StaticVarData(String name, int size){
        super(name, size);
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
