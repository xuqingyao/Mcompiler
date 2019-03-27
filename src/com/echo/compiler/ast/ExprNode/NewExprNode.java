package com.echo.compiler.ast.ExprNode;

import com.echo.compiler.ast.ASTVisitor;
import com.echo.compiler.ast.Location;
import com.echo.compiler.ast.TypeNode.TypeNode;
import java.util.List;

public class NewExprNode extends ExprNode{
    private TypeNode newtype;
    private List<ExprNode> dims;
    private int dim;

    public NewExprNode(TypeNode newtype, List<ExprNode> dims, int numdim, Location location){
        this.newtype = newtype;
        this.dims = dims;
        this.dim = numdim;
        this.location = location;
    }
    
    public TypeNode getNewType() {
        return newtype;
    }

    public List<ExprNode> getDims() {
        return dims;
    }

    public int getDim() {
        return dim;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}