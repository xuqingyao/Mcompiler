package com.echo.compiler.ast.StatNode;

import com.echo.compiler.ast.ASTVisitor;
import com.echo.compiler.ast.Location;

public class ContinueStatNode extends JumpStatNode{
    public ContinueStatNode(Location location){
        this.location = location;
    }
    
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}