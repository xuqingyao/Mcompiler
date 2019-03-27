package com.echo.compiler.ast.StatNode;

import com.echo.compiler.ast.ASTVisitor;
import com.echo.compiler.ast.ExprNode.ExprNode;
import com.echo.compiler.ast.Location;

public class ForStatNode extends IterationStatNode{
    private ExprNode init, cond, step;
    private StatNode stat;

    public ForStatNode(ExprNode init, ExprNode cond, ExprNode step, StatNode stat, Location location){
        this.init = init;
        this.cond = cond;
        this.step = step;
        this.stat = stat;
        this.location = location;
    }

    public ExprNode getInit(){
        return init;
    }

    public ExprNode getCond(){
        return cond;
    }

    public ExprNode getStep(){
        return step;
    }

    public StatNode getStat(){
        return stat;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}