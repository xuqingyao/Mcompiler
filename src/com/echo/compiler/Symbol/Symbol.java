package com.echo.compiler.Symbol;

import com.echo.compiler.ast.TypeNode.Type;

abstract public class Symbol {
    private String name;
    private Type type;

    public Symbol(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }
}
