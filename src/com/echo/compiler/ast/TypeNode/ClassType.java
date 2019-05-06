package com.echo.compiler.ast.TypeNode;

public class ClassType extends Type{
    private String name;

    public ClassType(String name){
        this.type = TYPE.CLASS;
        this.name = name;
        this.size = 8;
    }

    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ClassType)) return false;
        return name.equals(((ClassType) obj).name);
    }
}
