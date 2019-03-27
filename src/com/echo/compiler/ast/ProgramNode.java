package com.echo.compiler.ast;

import com.echo.compiler.Symbol.SymbolTable;
import com.echo.compiler.ast.DeclNode.DeclNode;

import java.util.List;

public class ProgramNode extends Node{
    private List<DeclNode> decls;
    private SymbolTable scope;

    public ProgramNode(List<DeclNode> decls, Location location) {
        this.decls = decls;
        this.location = location;
    }

    public List<DeclNode> getDecls() {
        return decls;
    }

    public SymbolTable getScope() {
        return scope;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}