package com.echo.compiler.ast.ExprNode;

import com.echo.compiler.ast.Node;
import com.echo.compiler.ast.TypeNode.Type;

abstract public class ExprNode extends Node{
    private Type type;
    private boolean isLeftValue;
    private int addrOffset;

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setLeftValue(boolean isLeftValue){
        this.isLeftValue = isLeftValue;
    }

    public boolean isLeftValue(){
        return isLeftValue;
    }

    public void setAddrOffset(int addrOffset) {
        this.addrOffset = addrOffset;
    }

    public int getAddrOffset() {
        return addrOffset;
    }
}