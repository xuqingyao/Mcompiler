package com.echo.compiler.ast.TypeNode;

public class BoolType extends Type {
    private static BoolType instance = new BoolType();

    public BoolType() {
        this.type = TYPE.BOOL;
        this.size = 8;
    }

    public static BoolType getBoolType() {
        return instance;
    }
}
