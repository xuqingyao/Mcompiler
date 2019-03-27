package com.echo.compiler.ast.StatNode;

import com.echo.compiler.ast.ASTVisitor;
import com.echo.compiler.ast.ExprNode.ExprNode;
import com.echo.compiler.ast.Location;

public class ReturnStatNode extends JumpStatNode{
    private ExprNode expr;

    public ReturnStatNode(ExprNode expr, Location location){
        this.expr = expr;
        this.location = location;
    }

    public ExprNode getExpr(){
        return expr;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}