package com.echo.compiler.Symbol;

import com.echo.compiler.ast.DeclNode.FuncDeclNode;
import com.echo.compiler.ast.DeclNode.VarDeclNode;
import com.echo.compiler.ast.TypeNode.FuncType;
import com.echo.compiler.ast.TypeNode.Type;

import java.util.ArrayList;
import java.util.List;

public class FuncSymbol extends Symbol{
    private Type returntype;
    private List<VarSymbol> parameters;
    private String classname = null;
    private boolean isConstruct = false;
    private boolean isMember = false;
    private boolean isBuiltIn = false;

    public FuncSymbol(String name, Type type) {
        super(name, type);
    }

    public FuncSymbol(FuncDeclNode node){
        super(node.getName(), new FuncType(node.getName()));
        if(node.getReturntype() != null)
            this.returntype = node.getReturntype().getType();
        else
            this.returntype = null;
        this.parameters = new ArrayList<>();
        for(VarDeclNode paramater : node.getFormalParameters()){
            VarSymbol varSymbol = new VarSymbol(paramater);
            parameters.add(varSymbol);
        }
        this.isConstruct = node.isConstruct();
    }

    public void setBuiltIn(boolean builtIn) {
        isBuiltIn = builtIn;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public void setConstruct(boolean construct) {
        isConstruct = construct;
    }

    public void setMember(boolean member) {
        isMember = member;
    }

    public void setParameters(List<VarSymbol> parameters) {
        this.parameters = parameters;
    }

    public void setReturntype(Type type) {
        this.returntype = type;
    }

    public boolean isBuiltIn() {
        return isBuiltIn;
    }

    public boolean isConstruct() {
        return isConstruct;
    }

    public boolean isMember() {
        return isMember;
    }

    public List<VarSymbol> getParameters() {
        return parameters;
    }

    public String getClassname() {
        return classname;
    }

    public Type getReturntype(){
        return returntype;
    }
}
