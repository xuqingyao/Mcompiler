package com.echo.compiler.ast.StatNode;

import com.echo.compiler.ast.ASTVisitor;
import com.echo.compiler.ast.ExprNode.ExprNode;
import com.echo.compiler.ast.Location;

public class WhileStatNode extends IterationStatNode{
    private ExprNode cond;
    private StatNode whilebody;

    public WhileStatNode(ExprNode cond, StatNode whilebody, Location location) {
        this.cond = cond;
        this.whilebody = whilebody;
        this.location = location;
    }

    public ExprNode getCond() {
        return cond;
    }

    public StatNode getWhilebody() {
        return whilebody;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}