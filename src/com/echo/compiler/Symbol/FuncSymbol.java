package com.echo.compiler.Symbol;

import com.echo.compiler.ast.DeclNode.FuncDeclNode;
import com.echo.compiler.ast.DeclNode.VarDeclNode;
import com.echo.compiler.ast.TypeNode.FuncType;
import com.echo.compiler.ast.TypeNode.Type;

import java.util.ArrayList;
import java.util.List;

public class FuncSymbol extends Symbol{
    private Type type;
    private List<VarSymbol> parameters;
    private String classname;
    private boolean isConstruct;
    private boolean isMember;
    private boolean isBuiltIn;

    public FuncSymbol(String name, Type type) {
        super(name, type);
        this.isConstruct = false;
        this.isMember = false;
        this.isBuiltIn = false;
    }

    public FuncSymbol(FuncDeclNode node){
        super(node.getName(), new FuncType(node.getName()));
        if(node.getType() != null)
            this.type = node.getType().getType();
        else
            this.type = null;
        this.parameters = new ArrayList<>();
        for(VarDeclNode paramater : node.getFormalParameters()){
            VarSymbol varSymbol = new VarSymbol(paramater);
            parameters.add(varSymbol);
        }
        this.classname = null;
        this.isConstruct = node.isConstruct();
        this.isMember = false;
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

    public void setType(Type type) {
        this.type = type;
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

    public Type getType(){
        return type;
    }
}
