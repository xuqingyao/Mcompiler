package com.echo.compiler.ast.TypeNode;

public class VoidType extends Type{
    static private VoidType instance = new VoidType();

    public VoidType(){
        this.type = TYPE.VOID;
    }

    public static VoidType getVoidType() {
        return instance;
    }
}