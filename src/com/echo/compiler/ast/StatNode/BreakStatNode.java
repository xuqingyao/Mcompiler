package com.echo.compiler.ast.StatNode;

import com.echo.compiler.ast.ASTVisitor;
import com.echo.compiler.ast.Location;

public class BreakStatNode extends JumpStatNode{
    public BreakStatNode(Location location){
        this.location = location;
    }
    
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}