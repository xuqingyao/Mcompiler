package com.echo.compiler.ast.StatNode;

import com.echo.compiler.ast.ASTVisitor;
import com.echo.compiler.ast.ExprNode.ExprNode;
import com.echo.compiler.ast.Location;

public class IfStatNode extends StatNode{
    private ExprNode cond;
    private StatNode thenbody;
    private StatNode elsebody;

    public IfStatNode(ExprNode cond, StatNode thenbody, StatNode elsebody, Location location){
        this.cond = cond;
        this.thenbody = thenbody;
        this.elsebody = elsebody;
        this.location = location;
    }

    public ExprNode getCond(){
        return cond;
    }

    public StatNode getThenbody(){
        return thenbody;
    }

    public StatNode getElsebody(){
        return elsebody;
    }
    
    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}