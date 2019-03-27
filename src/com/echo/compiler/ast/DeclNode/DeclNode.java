package com.echo.compiler.ast.DeclNode;

import com.echo.compiler.ast.Node;

abstract public class DeclNode extends Node{
    protected String name;

    public String getName(){
        return name;
    }
}