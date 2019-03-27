package com.echo.compiler.ast.ExprNode;

import com.echo.compiler.ast.ASTVisitor;
import com.echo.compiler.ast.Location;

public class AssignExprNode extends ExprNode{
    private ExprNode left;
    private ExprNode right;

    public AssignExprNode(ExprNode left, ExprNode right, Location location){
        this.left = left;
        this.right = right;
        this.location = location;
    }

    public ExprNode getLeft(){
        return left;
    }

    public ExprNode getRight(){
        return right;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}