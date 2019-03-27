package com.echo.compiler.ast.TypeNode;

public class IntType extends Type{
    static private IntType instance = new IntType();

    public IntType() {
        this.type = TYPE.INT;
        this.size = 8;
    }

    public static IntType getIntType() {
        return instance;
    }
}
