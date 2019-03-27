package com.echo.compiler.ast.ExprNode;

import com.echo.compiler.ast.ASTVisitor;
import com.echo.compiler.ast.Location;

public class SuffixExprNode extends ExprNode{
    public enum SuffixOp {
        MINUS_MINUS, PLUS_PLUS
    }

    private SuffixOp op;
    private ExprNode expr;

    public SuffixExprNode(ExprNode expr, SuffixOp op, Location location) {
        this.expr = expr;
        this.op = op;
        this.location = location;
    }

    public SuffixOp getOp() {
        return op;
    }

    public ExprNode getExpr() {
        return expr;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}