package com.echo.compiler.ast.ExprNode;

import com.echo.compiler.ast.ASTVisitor;
import com.echo.compiler.ast.Location;

public class IntConstExprNode extends ConstantExprNode{
    private int value;

    public IntConstExprNode(int value, Location location){
        this.value = value;
        this.location = location;
    }

    public int getValue(){
        return value;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}