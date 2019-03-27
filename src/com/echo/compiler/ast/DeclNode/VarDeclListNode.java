package com.echo.compiler.ast.DeclNode;

import com.echo.compiler.ast.ASTVisitor;

import java.util.List;

public class VarDeclListNode extends DeclNode{
    private List<VarDeclNode> decls;

    public VarDeclListNode(List<VarDeclNode> decls){
        this.decls = decls;
    }

    public List<VarDeclNode> getDecls(){
        return decls;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
