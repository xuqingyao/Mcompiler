package com.echo.compiler.ast.ExprNode;

import com.echo.compiler.ast.ASTVisitor;
import com.echo.compiler.ast.Location;

public class PrefixExprNode extends ExprNode{
    public enum PrefixOp{
        PLUS_PLUS, MINUS_MINUS,
        PLUS, MINUS,
        NOT, TILDE
    }
 
    private PrefixOp op;
    private ExprNode expr;

    public PrefixExprNode(PrefixOp op, ExprNode expr, Location location){
        this.op = op;
        this.expr = expr;
        this.location = location;
    }

    public PrefixOp getOp(){
        return op;
    }

    public ExprNode getExpr(){
        return expr;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}