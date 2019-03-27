package com.echo.compiler.ast;

abstract public class Node{
    protected Location location;
    protected boolean outOfInflu = false;

    public Node() {}

    public Location getLocation() {
        return location;
    }

    abstract public void accept(ASTVisitor visitor);
}