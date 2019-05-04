package com.echo.compiler.IR.Register;

import com.echo.compiler.IR.IRVisitor;

public class StaticStringData extends StaticData {
    public String value;

    public StaticStringData(String value){
        super("static_str",  8);
        this.value = value;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
