package com.echo.compiler.Symbol;

import com.echo.compiler.ast.DeclNode.ClassDeclNode;
import com.echo.compiler.ast.DeclNode.FuncDeclNode;
import com.echo.compiler.ast.TypeNode.ClassType;
import com.echo.compiler.ast.TypeNode.Type;

public class ClassSymbol extends Symbol{
    private SymbolTable symbolTable;
    private int memorySize;

    public ClassSymbol(String name, Type type, SymbolTable parent){
        super(name, type);
        this.symbolTable = new SymbolTable(parent, true);
    }

    public ClassSymbol(ClassDeclNode node, SymbolTable parent){
        super(node.getName(), new ClassType(node.getName()));
        this.symbolTable = new SymbolTable(parent, true);
        for(FuncDeclNode funcDeclNode : node.getFuncMember()){
            String name = funcDeclNode.getName();
            FuncSymbol symbol = new FuncSymbol(funcDeclNode);
            symbol.setClassname(node.getName());
            symbol.setMember(true);
            symbolTable.put(funcDeclNode.getLocation(), name, "$FUNC_" + name, symbol);
        }
    }

    public SymbolTable getSymbolTable(){
        return symbolTable;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }
}
