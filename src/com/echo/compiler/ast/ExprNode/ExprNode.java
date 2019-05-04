package com.echo.compiler.ast.ExprNode;

import com.echo.compiler.IR.BasicBlock;
import com.echo.compiler.IR.Register.Value;
import com.echo.compiler.ast.Node;
import com.echo.compiler.ast.TypeNode.Type;

abstract public class ExprNode extends Node{
    private Type type;
    private boolean isLeftValue;
    private int addrOffset;
    public BasicBlock trueBB, falseBB;
    public Value regValue, addrValue;

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

    public void setRegValue(Value regValue) {
        this.regValue = regValue;
    }

    public void setAddrValue(Value addrValue) {
        this.addrValue = addrValue;
    }
}