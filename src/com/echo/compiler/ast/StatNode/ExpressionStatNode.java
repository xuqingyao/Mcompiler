package com.echo.compiler.ast.StatNode;

import com.echo.compiler.ast.ASTVisitor;
import com.echo.compiler.ast.ExprNode.ExprNode;
import com.echo.compiler.ast.Location;

public class ExpressionStatNode extends StatNode{
    private ExprNode expr;

    public ExpressionStatNode(ExprNode expr, Location location){
        this.expr = expr;
        this.location = location;
    }

    public ExpressionStatNode(ExprNode expr){
        this.expr = expr;
        this.location = expr.getLocation();
    }

    public ExprNode getExpr(){
        return expr;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}