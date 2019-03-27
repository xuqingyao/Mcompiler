package com.echo.compiler.ast.DeclNode;

import com.echo.compiler.ast.ASTVisitor;
import com.echo.compiler.ast.ExprNode.ExprNode;
import com.echo.compiler.ast.Location;
import com.echo.compiler.ast.TypeNode.TypeNode;


public class VarDeclNode extends DeclNode{
    private TypeNode type;
    private ExprNode init;

    public VarDeclNode(TypeNode type, String name, ExprNode init, Location location) {
        this.type = type;
        this.name = name;
        this.init = init;
        this.location = location;
    }

    public TypeNode getType(){
        return type;
    }
    
    public ExprNode getInit(){
        return init;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}