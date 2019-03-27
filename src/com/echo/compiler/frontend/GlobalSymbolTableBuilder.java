package com.echo.compiler.frontend;

import com.echo.compiler.Symbol.*;
import com.echo.compiler.ast.DeclNode.ClassDeclNode;
import com.echo.compiler.ast.DeclNode.DeclNode;
import com.echo.compiler.ast.DeclNode.FuncDeclNode;
import com.echo.compiler.ast.DeclNode.VarDeclNode;
import com.echo.compiler.ast.ProgramNode;
import com.echo.compiler.ast.TypeNode.*;
import com.echo.compiler.error.SemanticError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GlobalSymbolTableBuilder extends SymbolTableBuilder{
    private SymbolTable symbolTable = new SymbolTable();

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    private void addDefaultFunc(SymbolTable symbolTable, String name, List<VarSymbol> parameters, Type returnType) {
        String key = "$FUNC_" + name;
        FuncSymbol funcSymbol = new FuncSymbol(name, new FuncType(name));
        funcSymbol.setParameters(parameters);
        funcSymbol.setType(returnType);
        funcSymbol.setBuiltIn(true);
        if (!symbolTable.isTop())
            funcSymbol.setMember(true);
        symbolTable.put(name, key, funcSymbol);
    }

    private void addDefaultFuncs() {
        addDefaultFunc(symbolTable,"print", Collections.singletonList(new VarSymbol("str", StringType.getStringType())), VoidType.getVoidType());
        addDefaultFunc(symbolTable,"println", Collections.singletonList(new VarSymbol("str", StringType.getStringType())), VoidType.getVoidType());
        addDefaultFunc(symbolTable,"getString", new ArrayList<>(), StringType.getStringType());
        addDefaultFunc(symbolTable,"getInt", new ArrayList<>(), IntType.getIntType());
        addDefaultFunc(symbolTable,"toString", Collections.singletonList(new VarSymbol("i", IntType.getIntType())), StringType.getStringType());
    }

    public void addDefaultStringFuncs(){
        String stringKey = "$CLASS_string";
        ClassSymbol stringSymbol = new ClassSymbol("string", new ClassType("string"), symbolTable);
        SymbolTable stringSymbolTable = stringSymbol.getSymbolTable();
        addDefaultFunc(stringSymbolTable, "length", Arrays.asList(new VarSymbol("this", StringType.getStringType())), IntType.getIntType());
        addDefaultFunc(stringSymbolTable, "substring", Arrays.asList(new VarSymbol("this", StringType.getStringType()), new VarSymbol("left", IntType.getIntType()), new VarSymbol("right", IntType.getIntType())), StringType.getStringType());
        addDefaultFunc(stringSymbolTable, "parseInt", Arrays.asList(new VarSymbol("this", StringType.getStringType())), IntType.getIntType());
        addDefaultFunc(stringSymbolTable, "ord", Arrays.asList(new VarSymbol("this", StringType.getStringType()), new VarSymbol("pos", IntType.getIntType())), IntType.getIntType());
        symbolTable.put("string", stringKey, stringSymbol);
    }

    public void addDefaultArrayFuncs(){
        String arrayKey = "$CLASS_array";
        ClassSymbol arraySymbol = new ClassSymbol("array", new ClassType("array"), symbolTable);
        SymbolTable arraySymbolTable = arraySymbol.getSymbolTable();
        addDefaultFunc(arraySymbolTable, "size", Arrays.asList(new VarSymbol("this", new ArrayType(null))), IntType.getIntType());
        symbolTable.put("array", arrayKey, arraySymbol);
    }

    private void checkMainFunc() {
        FuncSymbol mainFunc = (FuncSymbol)symbolTable.get("$FUNC_main");
        if (mainFunc == null)
            throw new SemanticError("\"main\" function not found");
        if (!(mainFunc.getType().getType() == Type.TYPE.INT))
            throw new SemanticError("\"main\" function's return type should be \"int\"");
        if (!mainFunc.getParameters().isEmpty())
            throw new SemanticError("\"main\" function should have no parameter");
    }

    @Override
    public void visit(ProgramNode node) {
        symbolTable.setTop(true);
        addDefaultFuncs();
        addDefaultStringFuncs();
        addDefaultArrayFuncs();
        for (DeclNode declNode : node.getDecls()) {
            if (declNode instanceof VarDeclNode)
                continue;
            declNode.accept(this);
        }
        checkMainFunc();
    }

    @Override
    public void visit(FuncDeclNode node) {
        String key = "$FUNC_" + node.getName();
        Symbol symbol = new FuncSymbol(node);
        symbolTable.put(node.getLocation(), node.getName(), key, symbol);
    }

    @Override
    public void visit(ClassDeclNode node) {
        String key = "$CLASS_" + node.getName();
        Symbol symbol = new ClassSymbol(node, symbolTable);
        symbolTable.put(node.getLocation(), node.getName(), key, symbol);
    }
}
