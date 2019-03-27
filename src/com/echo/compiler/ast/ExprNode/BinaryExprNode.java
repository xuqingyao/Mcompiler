package com.echo.compiler.ast.ExprNode;

import com.echo.compiler.ast.ASTVisitor;
import com.echo.compiler.ast.Location;

public class BinaryExprNode extends ExprNode{
    public enum BinaryOp{
        MUL, DIV, MOD,
        ADD, SUB, 
        LEFT_SHIFT, RIGHT_SHIFT,
        LESS, LESS_EQUAL, GREATER, GREATER_EQUAL,
        EQUAL, NOT_EQUAL,
        AND, CARET, OR, 
        AND_AND, OR_OR
    }

    private BinaryOp op;
    private ExprNode left, right;

    public BinaryExprNode(ExprNode left, BinaryOp op, ExprNode right, Location location){
        this.left = left;
        this.op = op;
        this.right = right;
        this.location = location;
    }

    public BinaryOp getOp(){
        return op;
    }

    public ExprNode getLeft(){
        return left;
    }

    public ExprNode getRight(){
        return right;
    }

    public void setLeft(ExprNode left){
        this.left = left;
    }

    public void setRight(ExprNode right){
        this.right = right;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}