package com.echo.compiler.ast.StatNode;

import com.echo.compiler.Symbol.SymbolTable;
import com.echo.compiler.ast.ASTVisitor;
import com.echo.compiler.ast.Location;
import com.echo.compiler.ast.Node;

import java.util.List;

public class BlockStatNode extends StatNode{
    private List<Node> blockbody;
    private SymbolTable symbolTable;
    private boolean isInit = false;

    public BlockStatNode(List<Node> blockbody, Location location){
        this.blockbody = blockbody;
        this.location = location;
    }

    public List<Node> getBlockbody(){
        return blockbody;
    }

    public SymbolTable getSymbolTable(){
        return symbolTable;
    }

    public void setSymbolTable(SymbolTable parent){
        if(!isInit) {
            this.symbolTable = new SymbolTable(parent, false);
            this.isInit = true;
        }
    }

    @Override
    public void accept(ASTVisitor visitor){
        visitor.visit(this);
    }
}