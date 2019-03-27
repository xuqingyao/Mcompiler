package com.echo.compiler.ast.TypeNode;

import com.echo.compiler.ast.ASTVisitor;
import com.echo.compiler.ast.Node;
import com.echo.compiler.ast.Location;

public class TypeNode extends Node {
    private Type type;

    public TypeNode(Type type, Location location) {
        this.type = type;
        this.location = location;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}