package com.echo.compiler.ast.TypeNode;

public class StringType extends Type{
    static private StringType instance = new StringType();

    public StringType() {
        type = TYPE.STRING;
        size = 8;
    }

    public static StringType getStringType() {
        return instance;
    }
}
