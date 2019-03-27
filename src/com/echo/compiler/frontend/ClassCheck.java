package com.echo.compiler.frontend;

import com.echo.compiler.Symbol.ClassSymbol;
import com.echo.compiler.Symbol.SymbolTable;
import com.echo.compiler.Symbol.VarSymbol;
import com.echo.compiler.ast.DeclNode.ClassDeclNode;
import com.echo.compiler.ast.DeclNode.DeclNode;
import com.echo.compiler.ast.DeclNode.VarDeclNode;
import com.echo.compiler.ast.ProgramNode;
import com.echo.compiler.ast.TypeNode.ArrayType;
import com.echo.compiler.ast.TypeNode.ClassType;
import com.echo.compiler.ast.TypeNode.NullType;
import com.echo.compiler.ast.TypeNode.VoidType;
import com.echo.compiler.error.SemanticError;

public class ClassCheck extends SymbolTableBuilder{
    private SymbolTable globalSymbolTable;
    private String currentClass;
    private SymbolTable currentSymbolTable;

    public ClassCheck(SymbolTable toplevelScope){
        this.globalSymbolTable = toplevelScope;
    }

    public SymbolTable getGlobalSymbolTable(){
        return globalSymbolTable;
    }

    public void VarCheck(VarDeclNode node){
        if (node.getInit() != null) {
            node.getInit().accept(this);
            if (node.getType().getType() instanceof VoidType || node.getInit().getType() instanceof VoidType)
                throw new SemanticError(node.getLocation(), String.format("Invalid initialization value, expected \"%s\" but got \"%s\"", node.getType().getType().toString(), node.getInit().getType().toString()));
            else if (!(node.getType().getType().equals(node.getInit().getType())))
                throw new SemanticError(node.getLocation(), String.format("Invalid initialization value, expected \"%s\" but got \"%s\"", node.getType().getType().toString(), node.getInit().getType().toString()));
            else if (node.getInit().getType() instanceof NullType){
                if(!(node.getType().getType() instanceof ClassType || node.getType().getType() instanceof ArrayType))
                    throw new SemanticError(node.getLocation(), String.format("Invalid initialization value, expected \"%s\" but got \"%s\"", node.getType().getType().toString(), node.getInit().getType().toString()));
            }
        }
    }

    @Override
    public void visit(ProgramNode node){
        for(DeclNode declNode : node.getDecls()){
            if(declNode instanceof ClassDeclNode)
                declNode.accept(this);
        }
    }

    @Override
    public void visit(ClassDeclNode node){
        ClassSymbol classSymbol = (ClassSymbol)globalSymbolTable.get(node.getLocation(), node.getName(), "$CLASS_" + node.getName());
        currentSymbolTable = classSymbol.getSymbolTable();
        currentClass = classSymbol.getName();
        for(VarDeclNode var : node.getVarMember())
            var.accept(this);
        classSymbol.setMemorySize(0);
    }

    @Override
    public void visit(VarDeclNode node){
        if(node.getType().getType() instanceof ClassType){
            String className = ((ClassType) node.getType().getType()).getName();
            String classkey = "$CLASS_" + className;
            currentSymbolTable.get(node.getLocation(), className, classkey);
        }
        VarCheck(node);
        VarSymbol varSymbol = new VarSymbol(node.getName(), node.getType().getType(), currentClass);
        String varkey = "$VAR_" + node.getName();
        currentSymbolTable.put(node.getLocation(), node.getName(), varkey, varSymbol);
    }

}
