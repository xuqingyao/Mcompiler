package com.echo.compiler.ast.TypeNode;

public class StringType extends Type{
    static private StringType instance = new StringType();

    public StringType() {
        this.type = TYPE.STRING;
        this.size = 8;
    }

    public static StringType getStringType() {
        return instance;
    }
}
