package com.echo.compiler.ast;

import com.echo.compiler.ast.DeclNode.*;
import com.echo.compiler.ast.ExprNode.*;
import com.echo.compiler.ast.StatNode.*;
import com.echo.compiler.ast.TypeNode.*;

public interface ASTVisitor{
    void visit(ProgramNode node);
    void visit(DeclNode node);
    void visit(FuncDeclNode node);
    void visit(ClassDeclNode node);
    void visit(VarDeclListNode node);
    void visit(VarDeclNode node);
    void visit(StatNode node);
    void visit(BlockStatNode node);
    void visit(ExpressionStatNode node);
    void visit(IfStatNode node);
    void visit(IterationStatNode node); 
    void visit(WhileStatNode node);
    void visit(ForStatNode node);
    void visit(JumpStatNode node);
    void visit(ContinueStatNode node);
    void visit(BreakStatNode node);
    void visit(ReturnStatNode node);
    void visit(ExprNode node);
    void visit(SubscriptExprNode node);
    void visit(FuncCallExprNode node);
    void visit(MemAccessExprNode node);
    void visit(SuffixExprNode node);
    void visit(PrefixExprNode node);
    void visit(NewExprNode node);
    void visit(BinaryExprNode node);
    void visit(AssignExprNode node);
    void visit(IdentifierExprNode node);
    void visit(ConstantExprNode node);
    void visit(BoolConstExprNode node);
    void visit(IntConstExprNode node);
    void visit(StringConstExprNode node);
    void visit(NullExprNode node);
    void visit(ThisExprNode node);
    void visit(TypeNode node);
}