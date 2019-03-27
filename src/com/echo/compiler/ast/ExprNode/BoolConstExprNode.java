package com.echo.compiler.ast.ExprNode;

import com.echo.compiler.ast.ASTVisitor;
import com.echo.compiler.ast.Location;

public class BoolConstExprNode extends ConstantExprNode{
    private boolean value;

    public BoolConstExprNode(boolean value, Location location){
        this.value = value;
        this.location = location;
    }
    
    public boolean getValue(){
        return value;
    }
    
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}