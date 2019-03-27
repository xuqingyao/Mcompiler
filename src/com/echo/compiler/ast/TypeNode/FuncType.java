package com.echo.compiler.ast.TypeNode;

public class FuncType extends Type{
    private String name;

    public FuncType(String name){
        this.type = TYPE.FUNCTION;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof FuncType))
            return false;
        return name.equals(((FuncType) obj).name);
    }
}
