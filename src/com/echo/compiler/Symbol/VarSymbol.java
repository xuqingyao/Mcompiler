package com.echo.compiler.Symbol;

import com.echo.compiler.IR.Register.Register;
import com.echo.compiler.ast.DeclNode.VarDeclNode;
import com.echo.compiler.ast.TypeNode.Type;

public class VarSymbol extends Symbol{
    private int addrOffset;
    private boolean isMember = false;
    private String classname;
    private boolean isGlobal = false;
    public Register register;
    public boolean unused = false;

    public VarSymbol(String name, Type type){
        super(name, type);
    }

    public VarSymbol(String name, Type type, String classname){
        super(name, type);
        this.isMember = true;
        this.classname = classname;
    }

    public VarSymbol(VarDeclNode node){
        super(node.getName(), node.getType().getType());
    }

    public String getClassname() {
        return classname;
    }

    public boolean isMember() {
        return isMember;
    }

    public int getAddrOffset() {
        return addrOffset;
    }

    public void setAddrOffset(int addrOffset) {
        this.addrOffset = addrOffset;
    }

    public void setMember(boolean member) {
        isMember = member;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public boolean isGlobal(){
        return isGlobal;
    }

    public void setGlobal(boolean isGlobal){
        this.isGlobal = isGlobal;
    }
}
