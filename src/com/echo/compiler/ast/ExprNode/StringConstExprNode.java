package com.echo.compiler.ast.ExprNode;

import com.echo.compiler.ast.ASTVisitor;
import com.echo.compiler.ast.Location;

public class StringConstExprNode extends ConstantExprNode{
    private String value;

    public StringConstExprNode(String value, Location location){
        this.value = value;
        this.location = location;
    }

    public String getValue(){
        return value;
    }
    
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}