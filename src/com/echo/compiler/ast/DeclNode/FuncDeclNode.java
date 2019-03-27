package com.echo.compiler.ast.DeclNode;

import com.echo.compiler.ast.ASTVisitor;
import com.echo.compiler.ast.Location;
import com.echo.compiler.ast.StatNode.BlockStatNode;
import com.echo.compiler.ast.TypeNode.TypeNode;

import java.util.List;

public class FuncDeclNode extends DeclNode{
    private TypeNode type;
    private List<VarDeclNode> formalParameters;
    private BlockStatNode body;
    private boolean isConstruct;

    public FuncDeclNode(TypeNode type, String name, List<VarDeclNode> formalParameters, BlockStatNode body, Location location){
        if(type == null){
            this.type = null;
            this.isConstruct = true;
        }
        else{
            this.type = type;
            this.isConstruct = false;
        }
        this.name = name;
        this.formalParameters = formalParameters;
        this.body = body;
        this.location = location;
    }

    public TypeNode getType(){
        return type;
    }

    public List<VarDeclNode> getFormalParameters(){
        return formalParameters;
    }

    public BlockStatNode getBody(){
        return body;
    }

    public boolean isConstruct(){
        return isConstruct;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}