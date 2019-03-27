package com.echo.compiler.frontend;

import com.echo.compiler.ast.ASTVisitor;
import com.echo.compiler.ast.DeclNode.*;
import com.echo.compiler.ast.ExprNode.*;
import com.echo.compiler.ast.ProgramNode;
import com.echo.compiler.ast.StatNode.*;
import com.echo.compiler.ast.TypeNode.TypeNode;

public class SymbolTableBuilder implements ASTVisitor {
    @Override
    public void visit(ProgramNode node){

    }

    @Override
    public void visit(DeclNode node){

    }

    @Override
    public void visit(FuncDeclNode node){

    }

    @Override
    public void visit(ClassDeclNode node){

    }

    @Override
    public void visit(VarDeclListNode node){

    }

    @Override
    public void visit(VarDeclNode node){

    }

    @Override
    public void visit(StatNode node){

    }

    @Override
    public void visit(BlockStatNode node){

    }

    @Override
    public void visit(ExpressionStatNode node){

    }

    @Override
    public void visit(IfStatNode node){

    }

    @Override
    public void visit(IterationStatNode node){

    }

    @Override
    public void visit(WhileStatNode node){

    }

    @Override
    public void visit(ForStatNode node){

    }

    @Override
    public void visit(JumpStatNode node){

    }

    @Override
    public void visit(ContinueStatNode node){

    }

    @Override
    public void visit(BreakStatNode node){

    }

    @Override
    public void visit(ReturnStatNode node){

    }

    @Override
    public void visit(ExprNode node){

    }

    @Override
    public void visit(SubscriptExprNode node){

    }

    @Override
    public void visit(FuncCallExprNode node){

    }

    @Override
    public void visit(MemAccessExprNode node){

    }

    @Override
    public void visit(SuffixExprNode node){

    }

    @Override
    public void visit(PrefixExprNode node){

    }

    @Override
    public void visit(NewExprNode node){

    }

    @Override
    public void visit(BinaryExprNode node){

    }

    @Override
    public void visit(AssignExprNode node){

    }

    @Override
    public void visit(IdentifierExprNode node){

    }

    @Override
    public void visit(ConstantExprNode node){

    }

    @Override
    public void visit(BoolConstExprNode node){

    }

    @Override
    public void visit(IntConstExprNode node){

    }

    @Override
    public void visit(StringConstExprNode node){

    }

    @Override
    public void visit(NullExprNode node){

    }

    @Override
    public void visit(ThisExprNode node) {

    }

    @Override
    public void visit(TypeNode node){

    }
}
