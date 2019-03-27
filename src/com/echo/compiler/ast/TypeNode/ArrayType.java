package com.echo.compiler.ast.TypeNode;

public class ArrayType extends Type{
    private Type baseType;

    public ArrayType(Type baseType) {
        this.type = TYPE.ARRAY;
        this.baseType = baseType;
        this.size = 8;
    }

    public Type getBaseType(){
        return baseType;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ArrayType)) return false;
        return baseType.equals(((ArrayType) obj).baseType);
    }
}
