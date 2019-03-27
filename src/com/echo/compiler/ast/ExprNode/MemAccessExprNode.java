package com.echo.compiler.ast.ExprNode;

import com.echo.compiler.ast.ASTVisitor;
import com.echo.compiler.ast.Location;

public class MemAccessExprNode extends ExprNode{
    private ExprNode expr;
    private String member;

    public MemAccessExprNode(ExprNode expr, String member, Location location){
        this.expr = expr;
        this.member = member;
        this.location = location;
    }

    public ExprNode getExpr(){
        return expr;
    }

    public String getMember(){
        return member;
    }
    
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}