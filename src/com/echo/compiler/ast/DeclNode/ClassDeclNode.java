package com.echo.compiler.ast.DeclNode;

import com.echo.compiler.ast.ASTVisitor;
import com.echo.compiler.ast.Location;

import java.util.List;


public class ClassDeclNode extends DeclNode{
    private List<VarDeclNode> varmember;
    private List<FuncDeclNode> funcmember;

    public ClassDeclNode(String name, List<VarDeclNode> varmember, List<FuncDeclNode> funcmember, Location location){
        this.name = name;
        this.varmember = varmember;
        this.funcmember = funcmember;
        this.location = location;
    }

    public List<VarDeclNode> getVarMember(){
        return varmember;
    }

    public List<FuncDeclNode> getFuncMember(){
        return funcmember;
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}