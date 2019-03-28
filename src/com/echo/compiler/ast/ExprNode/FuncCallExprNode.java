package com.echo.compiler.ast.ExprNode;

import com.echo.compiler.Symbol.FuncSymbol;
import com.echo.compiler.ast.ASTVisitor;
import com.echo.compiler.ast.Location;

import java.util.List;

public class FuncCallExprNode extends ExprNode{
    private ExprNode function;
    private List<ExprNode> args;
    private FuncSymbol funcSymbol;

    public FuncCallExprNode(ExprNode function, List<ExprNode> args, Location location){
        this.function = function;
        this.args = args;
        this.location = location;
    }

    public ExprNode getFunction(){
        return function;
    }

    public List<ExprNode> getArgs(){
        return args;
    }

    public FuncSymbol getFuncSymbol() {
        return funcSymbol;
    }

    public void setFuncSymbol(FuncSymbol funcSymbol) {
        this.funcSymbol = funcSymbol;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}