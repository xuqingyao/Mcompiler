package com.echo.compiler.ast.ExprNode;

import com.echo.compiler.ast.ASTVisitor;
import com.echo.compiler.ast.Location;

public class ThisExprNode extends ExprNode{
    public ThisExprNode(Location location)
    {
        this.location = location;
    }

    @Override
    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
