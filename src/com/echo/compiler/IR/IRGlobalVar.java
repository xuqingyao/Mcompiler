package com.echo.compiler.IR;

import com.echo.compiler.ast.ExprNode.ExprNode;

public class IRGlobalVar {
    public String name;
    public ExprNode initExpr;

    public IRGlobalVar(String name, ExprNode initExpr){
        this.name = name;
        this.initExpr = initExpr;
    }
}
