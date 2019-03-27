package com.echo.compiler.ast.ExprNode;

import com.echo.compiler.ast.ASTVisitor;
import com.echo.compiler.ast.Location;

public class SubscriptExprNode extends ExprNode{
    private ExprNode array;
    private ExprNode sub;

    public SubscriptExprNode(ExprNode array, ExprNode sub, Location location){
        this.array = array;
        this.sub = sub;
        this.location = location;
    }

    public ExprNode getArray() {
        return array;
    }

    public ExprNode getSub() {
        return sub;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}