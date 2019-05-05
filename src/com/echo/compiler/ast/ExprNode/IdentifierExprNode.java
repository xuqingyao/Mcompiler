package com.echo.compiler.ast.ExprNode;

import com.echo.compiler.Symbol.VarSymbol;
import com.echo.compiler.ast.ASTVisitor;
import com.echo.compiler.ast.Location;

public class IdentifierExprNode extends ExprNode{
    private String identifier;
    private VarSymbol varSymbol = null;
    public boolean needMemOp = false;
    public boolean checked = false;

    public IdentifierExprNode(String identifier, Location location){
        this.identifier = identifier;
        this.location = location;
    }

    public String getIdentifier(){
        return identifier;
    }

    public VarSymbol getVarSymbol() {
        return varSymbol;
    }

    public void setVarSymbol(VarSymbol varSymbol) {
        this.varSymbol = varSymbol;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}