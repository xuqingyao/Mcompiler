package com.echo.compiler.ast.TypeNode;

abstract public class Type {
    public enum TYPE{
        VOID, INT, STRING, BOOL, CLASS, FUNCTION, ARRAY, NULL
    }

    protected int size;
    protected TYPE type;

    public TYPE getType(){
        return type;
    }

    public int getSize() {
        return size;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
