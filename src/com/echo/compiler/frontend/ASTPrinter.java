//package com.echo.compiler.frontend;
//
//import com.echo.compiler.ast.ASTVisitor;
//import com.echo.compiler.ast.DeclNode.*;
//import com.echo.compiler.ast.ExprNode.*;
//import com.echo.compiler.ast.Node;
//import com.echo.compiler.ast.ProgramNode;
//import com.echo.compiler.ast.StatNode.*;
//import com.echo.compiler.ast.TypeNode.TypeNode;
//
//public class ASTPrinter implements ASTVisitor {
//    private static final String INDENT_UNIT = "    ";
//    private StringBuilder indentStrBuilder = new StringBuilder();
//
//
//    private void indent() {
//        indentStrBuilder.append(INDENT_UNIT);
//    }
//
//    private void unindent() {
//        indentStrBuilder.delete(indentStrBuilder.length() - INDENT_UNIT.length(), indentStrBuilder.length());
//    }
//
//    private String getIndentStr() {
//        return indentStrBuilder.toString();
//    }
//
//    private void println(String str) {
//        println(getIndentStr() + str);
//    }
//
//    private void print(String str) {
//        print(getIndentStr() + str);
//    }
//
//    private void printf(String str, Object... args) {
//        printf(getIndentStr() + str, args);
//    }
//
//
//    @Override
//    public void visit(ProgramNode node) {
//        if (node.getLocation() == null) System.err.println("???");
//        printf("@ ProgramNode %s:\n", node.getLocation().toString());
//        if (!(node.getDecls().isEmpty())) {
//            println(">>> decls:");
//            for (DeclNode decl : node.getDecls()) {
//                decl.accept(this);
//            }
//        }
//        else {
//            println(">>> decls: null");
//        }
//    }
//
//    @Override
//    public void visit(DeclNode node) {
//
//    }
//
//    // no use
//    @Override
//    public void visit(VarDeclListNode node) {
//    }
//
//    @Override
//    public void visit(FuncDeclNode node) {
//        indent();
//        printf("@ FuncDeclNode %s:\n", node.getLocation().toString());
//        printf(">>> isContruct: %b\n"/*, node.isConstruct()*/);
//        if (node.getType() != null) {
//            println(">>> returnType:");
//            node.getType().accept(this);
//        }
//        else {
//            println(">>> returnType: null");
//        }
//        printf(">>> name: %s\n", node.getName());
//        if (!(node.getFormalParameters().isEmpty())) {
//            println(">>> parameterList:");
//            for (VarDeclNode parameter : node.getFormalParameters()) {
//                parameter.accept(this);
//            }
//        }
//        else {
//            println(">>> parameterList: null");
//        }
//        println(">>> body:");
//        node.getBody().accept(this);
//        unindent();
//    }
//
//    @Override
//    public void visit(ClassDeclNode node) {
//        indent();
//        printf("@ ClassDeclNode %s:\n", node.getLocation().toString());
//        printf(">>> name: %s\n", node.getName());
//        if (!(node.getVarMember().isEmpty())) {
//            println(">>> varMember:");
//            for (VarDeclNode varMem : node.getVarMember()) {
//                varMem.accept(this);
//            }
//        }
//        else {
//            println(">>> varMember: null");
//        }
//        if (!(node.getFuncMember().isEmpty())) {
//            println(">>> funcMember:");
//            for (FuncDeclNode funcMem : node.getFuncMember()) {
//                funcMem.accept(this);
//            }
//        }
//        else {
//            println(">>> funcMember: null");
//        }
//        unindent();
//    }
//
//    @Override
//    public void visit(VarDeclNode node) {
//        indent();
//        printf("@ VaeDeclNode %s:\n", node.getLocation().toString());
//        println(">>> type:");
//        node.getType().accept(this);
//        printf(">>> name: %s\n", node.getName());
//        if (node.getInit() != null) {
//            println(">>> init:");
//            node.getInit().accept(this);
//        }
//        else {
//            println(">>> init: null");
//        }
//        unindent();
//    }
//
//    @Override
//    public void visit(StatNode node) {
//
//    }
//
//    @Override
//    public void visit(BlockStatNode node) {
//        indent();
//        printf("@ BlockStatNode %s:\n", node.getLocation().toString());
//        if (!(node.getBlockbody().isEmpty())) {
//            println(">>> stmtsAndVarDecls:");
//            for (Node item : node.getBlockbody()) {
//                item.accept(this);
//            }
//        }
//        else {
//            println(">>> stmtsAndVarDecls: null");
//        }
//        unindent();
//    }
//
//    @Override
//    public void visit(ExpressionStatNode node) {
//        indent();
//        printf("@ ExprStatNode %s:\n", node.getLocation().toString());
//        println(">>> expr:");
//        node.getExpr().accept(this);
//        unindent();
//    }
//
//    @Override
//    public void visit(IfStatNode node) {
//        indent();
//        printf("@ CondStatNode %s:\n", node.getLocation().toString());
//        println(">>> cond:");
//        node.getCond().accept(this);
//        if (node.getThenbody() != null) {
//            println(">>> thenStat:");
//            node.getThenbody().accept(this);
//        }
//        else {
//            println(">>> thenStat: null");
//        }
//        if (node.getElsebody() != null) {
//            println(">>> elseStat:");
//            node.getElsebody().accept(this);
//        }
//        else {
//            println(">>> elseStat: null");
//        }
//        unindent();
//    }
//
//    @Override
//    public void visit(IterationStatNode node) {
//
//    }
//
//    @Override
//    public void visit(WhileStatNode node) {
//        indent();
//        printf("@ WhileStatNode %s:\n", node.getLocation().toString());
//        println(">>> cond:");
//        node.getCond().accept(this);
//        if (node.getWhilebody() != null) {
//            println(">>> stmt:");
//            node.getWhilebody().accept(this);
//        }
//        else {
//            println(">>> stmt: null");
//        }
//        unindent();
//    }
//
//    @Override
//    public void visit(ForStatNode node) {
//        indent();
//        printf("@ ForStatNode %s:\n", node.getLocation().toString());
//        if (node.getInit() != null) {
//            println(">>> init:");
//            node.getInit().accept(this);
//        }
//        else {
//            println(">>> init: null");
//        }
//        if (node.getCond() != null) {
//            println(">>> cond:");
//            node.getCond().accept(this);
//        }
//        else {
//            println(">>> cond: null");
//        }
//        if (node.getStep() != null) {
//            println(">>> step:");
//            node.getStep().accept(this);
//        }
//        else {
//            println(">>> step: null");
//        }
//        if (node.getStat() != null) {
//            println(">>> stmt:");
//            node.getStat().accept(this);
//        }
//        else {
//            println(">>> stmt: null");
//        }
//        unindent();
//    }
//
//    @Override
//    public void visit(JumpStatNode node) {
//
//    }
//
//    @Override
//    public void visit(ContinueStatNode node) {
//        indent();
//        printf("@ ContinueStatNode %s:\n", node.getLocation().toString());
//        unindent();
//    }
//
//    @Override
//    public void visit(BreakStatNode node) {
//        indent();
//        printf("@ BreakStatNode %s:\n", node.getLocation().toString());
//        unindent();
//    }
//
//    @Override
//    public void visit(ReturnStatNode node) {
//        indent();
//        printf("@ ReturnStatNode %s:\n", node.getLocation().toString());
//        if (node.getExpr() != null) {
//            println(">>> expr:");
//            node.getExpr().accept(this);
//        }
//        else {
//            println(">>> expr: null");
//        }
//        unindent();
//    }
//
//    @Override
//    public void visit(ExprNode node) {
//
//    }
//
//    @Override
//    public void visit(SuffixExprNode node) {
//        indent();
//        printf("@ SuffixExprNode %s:\n", node.getLocation().toString());
//        printf(">>> op: %s\n", node.getOp().toString());
//        println(">>> expr:");
//        node.getExpr().accept(this);
//        unindent();
//    }
//
//    @Override
//    public void visit(FuncCallExprNode node) {
//        indent();
//        printf("@ FuncCallExprNode %s:\n", node.getLocation().toString());
//        println(">>> func:");
//        node.getFunction().accept(this);
//        if (!(node.getArgs().isEmpty())) {
//            println(">>> args:");
//            for (ExprNode arg : node.getArgs()) {
//                arg.accept(this);
//            }
//        }
//        else {
//            println(">>> args: null");
//        }
//        unindent();
//    }
//
//    @Override
//    public void visit(SubscriptExprNode node) {
//        indent();
//        printf("@ SubscriptExprNode %s:\n", node.getLocation().toString());
//        println(">>> arr:");
//        node.getArray().accept(this);
//        println(">>> sub:");
//        node.getSub().accept(this);
//        unindent();
//    }
//
//    @Override
//    public void visit(MemAccessExprNode node) {
//        indent();
//        printf("@ MemberAccessExprNode %s:\n", node.getLocation().toString());
//        println(">>> expr:");
//        node.getExpr().accept(this);
//        printf(">>> member: %s\n", node.getMember());
//        unindent();
//    }
//
//    @Override
//    public void visit(PrefixExprNode node) {
//        indent();
//        printf("@ PrefixExprNode %s:\n", node.getLocation().toString());
//        printf(">>> op: %s\n", node.getOp().toString());
//        println(">>> expr:");
//        node.getExpr().accept(this);
//        unindent();
//    }
//
//    @Override
//    public void visit(NewExprNode node) {
//        indent();
//        printf("@ NewExprNode %s:\n", node.getLocation().toString());
//        println(">>> newType:");
//        node.getNewType().accept(this);
//        if (node.getDim() != 0) {
//            println(">>> dims:");
//            for (ExprNode dim : node.getDims()) {
//                dim.accept(this);
//            }
//            printf(">>> numDim: %d\n", node.getDim());
//        }
//        else {
//            println(">>> numDim: 0");
//        }
//        unindent();
//    }
//
//    @Override
//    public void visit(BinaryExprNode node) {
//        indent();
//        printf("@ BinaryExprNode %s:\n", node.getLocation().toString());
//        printf(">>> op: %s\n", node.getOp().toString());
//        println(">>> lhs:");
//        node.getLeft().accept(this);
//        println(">>> rhs:");
//        node.getRight().accept(this);
//        unindent();
//    }
//
//    @Override
//    public void visit(AssignExprNode node) {
//        indent();
//        printf("@ AssignExprNode %s:\n", node.getLocation().toString());
//        println(">>> lhs:");
//        node.getLeft().accept(this);
//        println(">>> rhs:");
//        node.getRight().accept(this);
//        unindent();
//    }
//
//    @Override
//    public void visit(IdentifierExprNode node) {
//        indent();
//        printf("@ IdentifierExprNode %s:\n", node.getLocation().toString());
//        printf(">>> identifier: %s\n", node.getIdentifier());
//        unindent();
//    }
//
//    @Override
//    public void visit(ConstantExprNode node) {
//
//    }
//
//    @Override
//    public void visit(IntConstExprNode node) {
//        indent();
//        printf("@ IntConstExprNode %s:\n", node.getLocation().toString());
//        printf(">>> value: %d\n", node.getValue());
//        unindent();
//    }
//
//    @Override
//    public void visit(StringConstExprNode node) {
//        indent();
//        printf("@ StringConstExprNode %s:\n", node.getLocation().toString());
//        printf(">>> value: %s\n", node.getValue());
//        unindent();
//    }
//
//    @Override
//    public void visit(BoolConstExprNode node) {
//        indent();
//        printf("@ BoolConstExprNode %s:\n", node.getLocation().toString());
//        printf(">>> value: %b\n", node.getValue());
//        unindent();
//    }
//
//    @Override
//    public void visit(NullExprNode node) {
//        indent();
//        printf("@ NullExprNode %s:\n", node.getLocation().toString());
//        unindent();
//    }
//
//    @Override
//    public void visit(ThisExprNode node) {
//        indent();
//        printf("@ ThisExprNode %s:\n", node.getLocation().toString());
//        unindent();
//    }
//
//    @Override
//    public void visit(TypeNode node) {
//        indent();
//        printf("@ TypeNode %s:\n", node.getLocation().toString());
//        printf(">>> type: %s\n", node.getType().toString());
//        unindent();
//    }
//}
package com.echo.compiler.frontend;


import com.echo.compiler.ast.ASTVisitor;
import com.echo.compiler.ast.DeclNode.*;
import com.echo.compiler.ast.ExprNode.*;
import com.echo.compiler.ast.Node;
import com.echo.compiler.ast.ProgramNode;
import com.echo.compiler.ast.StatNode.*;
import com.echo.compiler.ast.TypeNode.TypeNode;

public class ASTPrinter implements ASTVisitor
{
    private StringBuffer indent = new StringBuffer();

    private void printf(String format, Object... args)
    {
        System.out.printf(indent.toString() + format, args);
    }

    private void addIndent()
    {
        indent.append('\t');
    }

    private void deleteIndent()
    {
        indent.deleteCharAt(indent.length() - 1);
    }

    @Override
    public void visit(ProgramNode node)
    {
        if (node == null) printf("AST tree is null");
        else {
            printf("ProgramNode %s:\n", node.getLocation().toString());
            if (node.getDecls().isEmpty()) printf("-> decls: null\n");
            else {
                printf("-> decls:\n");
                for (DeclNode declNode : node.getDecls()) declNode.accept(this);
            }
        }
    }

    @Override
    public void visit(DeclNode node) {

    }

    @Override
    public void visit(FuncDeclNode node)
    {
        addIndent();
        printf("FuncDeclNode %s:\n", node.getLocation().toString());
        printf("-> isConstruct: %b\n", node.isConstruct());
        if (node.getReturntype() == null) printf("returnType: null\n");
        else {
            printf("-> returnType:\n");
            node.getReturntype().accept(this);
        }
        printf("-> name: %s\n", node.getName());
        if (node.getFormalParameters().isEmpty()) printf("-> parameterList: null");
        else {
            printf("-> parameterList:\n");
            for (VarDeclNode varDeclNode : node.getFormalParameters()) varDeclNode.accept(this);
        }
        printf("-> body:\n");
        node.getBody().accept(this);
        deleteIndent();
    }

    @Override
    public void visit(ClassDeclNode node)
    {
        addIndent();
        printf("ClassDeclNode %s:\n", node.getLocation().toString());
        printf("-> name: %s\n", node.getName());
        if (node.getVarMember().isEmpty()) printf("-> varMember: null\n");
        else {
            printf("-> varMember:\n");
            for (VarDeclNode varDeclNode : node.getVarMember()) varDeclNode.accept(this);
        }
        if (node.getFuncMember().isEmpty()) printf("-> funcMember: null\n");
        else {
            printf("-> funcMember:\n");
            for (FuncDeclNode funcDeclNode : node.getFuncMember()) funcDeclNode.accept(this);
        }
        deleteIndent();
    }

    @Override
    public void visit(VarDeclListNode node) {

    }

    @Override
    public void visit(VarDeclNode node)
    {
        addIndent();
        printf("VarDeclNode %s:\n", node.getLocation().toString());
        printf("-> type:\n");
        node.getType().accept(this);
        printf("-> name: %s\n", node.getName());
        if (node.getInit() == null) printf("-> expr: null\n");
        else {
            printf("-> expr:\n");
            node.getInit().accept(this);
        }
        deleteIndent();
    }

    @Override
    public void visit(StatNode node) {

    }

    @Override
    public void visit(BlockStatNode node)
    {
        addIndent();
        printf("BlockStmtNode %s:\n", node.getLocation().toString());
        if (node.getBlockbody().isEmpty()) printf("-> stmtsAndVarDecls: null\n");
        else {
            printf("->stmtsAndVarDecls\n");
            for (Node node1 : node.getBlockbody()) node1.accept(this);
        }
        deleteIndent();
    }

    @Override
    public void visit(ExpressionStatNode node)
    {
        addIndent();
        printf("ExprStmtNode %s:\n", node.getLocation().toString());
        printf("-> expr:\n");
        node.getExpr().accept(this);
        deleteIndent();
    }

    @Override
    public void visit(IfStatNode node)
    {
        addIndent();
        printf("IfElseStmtNode %s:\n", node.getLocation().toString());
        printf("-> condition:\n");
        node.getCond().accept(this);
        if (node.getThenbody() == null) printf("-> thenStmt: null\n");
        else {
            printf("-> thenStmt:\n");
            node.getThenbody().accept(this);
        }
        if (node.getElsebody() == null) printf("-> elseStmt: null\n");
        else {
            printf("-> elseStmt:\n");
            node.getElsebody().accept(this);
        }
        deleteIndent();
    }

    @Override
    public void visit(IterationStatNode node) {

    }

    @Override
    public void visit(WhileStatNode node)
    {
        addIndent();
        printf("WhileStmtNode %s:\n", node.getLocation().toString());
        printf("-> condition:\n");
        node.getCond().accept(this);
        if (node.getWhilebody() == null) printf("-> stmt: null\n");
        else {
            printf("-> stmt:\n");
            node.getWhilebody().accept(this);
        }
        deleteIndent();
    }

    @Override
    public void visit(ForStatNode node)
    {
        addIndent();
        printf("ForStmtNode %s:\n", node.getLocation().toString());
        if (node.getInit() == null) printf("-> init: null\n");
        else {
            printf("-> init:\n");
            node.getInit().accept(this);
        }
        if (node.getCond() == null) printf("-> cond: null\n");
        else {
            printf("-> cond:\n");
            node.getCond().accept(this);
        }
        if (node.getStep() == null) printf("-> update: null\n");
        else {
            printf("-> update:\n");
            node.getStep().accept(this);
        }
        if (node.getStat() == null) printf("-> stmt: null\n");
        else {
            printf("-> stmt:\n");
            node.getStep().accept(this);
        }
        deleteIndent();
    }

    @Override
    public void visit(JumpStatNode node) {

    }

    @Override
    public void visit(ContinueStatNode node)
    {
        addIndent();
        printf("ContinueStmtNode %s:\n", node.getLocation().toString());
        deleteIndent();
    }

    @Override
    public void visit(BreakStatNode node)
    {
        addIndent();
        printf("BreakStmtNode %s:\n", node.getLocation().toString());
        deleteIndent();
    }

    @Override
    public void visit(ReturnStatNode node)
    {
        addIndent();
        printf("ReturnStmtNode %s:\n", node.getLocation().toString());
        if (node.getExpr() == null) printf("-> expr: null\n");
        else {
            printf("-> expr:\n");
            node.getExpr().accept(this);
        }
        deleteIndent();
    }

    @Override
    public void visit(ExprNode node) {

    }

    @Override
    public void visit(SuffixExprNode node)
    {
        addIndent();
        printf("SuffixExprNode %s:\n", node.getLocation().toString());
        printf("-> op: %s\n", node.getOp().toString());
        printf("-> expr:\n");
        node.getExpr().accept(this);
        deleteIndent();
    }

    @Override
    public void visit(FuncCallExprNode node)
    {
        addIndent();
        printf("FuncCallExprNode %s:\n", node.getLocation().toString());
        printf("-> expr:\n");
        node.getFunction().accept(this);
        if (node.getArgs().isEmpty()) printf("-> paraList: null\n");
        else {
            printf("-> paraList:\n");
            for (ExprNode exprNode : node.getArgs()) exprNode.accept(this);
        }
        deleteIndent();
    }

    @Override
    public void visit(SubscriptExprNode node)
    {
        addIndent();
        printf("ArrayExprNode %s:\n", node.getLocation().toString());
        printf("-> arr:\n");
        node.getArray().accept(this);
        printf("-> sub:\n");
        node.getSub().accept(this);
        deleteIndent();
    }

    @Override
    public void visit(MemAccessExprNode node)
    {
        addIndent();
        printf("MemExprNode %s:\n", node.getLocation().toString());
        printf("-> expr:\n");
        node.getExpr().accept(this);
        printf("-> name: %s\n", node.getMember());
        deleteIndent();
    }

    @Override
    public void visit(PrefixExprNode node)
    {
        addIndent();
        printf("PrefixExprNode %s:\n", node.getLocation().toString());
        printf("-> expr:\n");
        node.getExpr().accept(this);
        printf("-> op: %s\n", node.getOp().toString());
        deleteIndent();
    }

    @Override
    public void visit(NewExprNode node)
    {
        addIndent();
        printf("NewExprNode %s:\n", node.getLocation().toString());
        printf("-> type:\n");
        node.getNewType().accept(this);
        if (node.getDim() == 0) printf("-> dimNum: 0\n");
        else {
            printf("-> exprList:\n");
            for (ExprNode exprNode : node.getDims()) exprNode.accept(this);
            printf("-> dimNum: %d\n", node.getDim());
        }
        deleteIndent();
    }

    @Override
    public void visit(BinaryExprNode node)
    {
        addIndent();
        printf("BinaryExprNode %s:\n", node.getLocation().toString());
        printf("-> lhs:\n");
        node.getLeft().accept(this);
        printf("-> rhs:\n");
        node.getRight().accept(this);
        printf("-> op: %s\n", node.getOp().toString());
        deleteIndent();
    }

    @Override
    public void visit(AssignExprNode node)
    {
        addIndent();
        printf("AssignExprNode %s:\n", node.getLocation().toString());
        printf("-> lhs:\n");
        node.getLeft().accept(this);
        printf("-> rhs:\n");
        node.getRight().accept(this);
        deleteIndent();
    }

    @Override
    public void visit(IdentifierExprNode node)
    {
        addIndent();
        printf("IdExprNode %s:\n", node.getLocation().toString());
        printf("-> IdExprNode: %s\n", node.getIdentifier());
        deleteIndent();
    }

    @Override
    public void visit(ThisExprNode node)
    {
        addIndent();
        printf("ThisExprNode %s:\n", node.getLocation().toString());
        deleteIndent();
    }

    @Override
    public void visit(ConstantExprNode node)
    {
        addIndent();
        printf("NumExprNode %s:\n", node.getLocation().toString());
        printf("-> value: %d\n", node.getType());
        deleteIndent();
    }

    @Override
    public void visit(StringConstExprNode node)
    {
        addIndent();
        printf("StrExprNode %s:\n", node.getLocation().toString());
        printf("-> str: %s\n", node.getValue());
        deleteIndent();
    }

    @Override
    public void visit(BoolConstExprNode node)
    {
        addIndent();
        printf("BoolConstExprNode %s:\n", node.getLocation().toString());
        printf("-> value: %b\n", node.getValue());
        deleteIndent();
    }

    @Override
    public void visit(IntConstExprNode node) {

    }

    @Override
    public void visit(NullExprNode node)
    {
        addIndent();
        printf("NullExprNode %s:\n", node.getLocation().toString());
        deleteIndent();
    }

    @Override
    public void visit(TypeNode node)
    {
        addIndent();
        printf("TypeNode %s:\n", node.getLocation().toString());
        printf("-> type: %s\n", node.getType().toString());
        deleteIndent();
    }
}
