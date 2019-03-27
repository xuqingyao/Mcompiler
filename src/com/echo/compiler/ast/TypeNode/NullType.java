package com.echo.compiler.ast.TypeNode;

public class NullType extends Type{
    static private NullType instance = new NullType();

    public NullType(){
        this.type = TYPE.NULL;
    }

    public static NullType getNullType() {
        return instance;
    }
}
