package com.echo.compiler.frontend;

import com.echo.compiler.ast.DeclNode.*;
import com.echo.compiler.ast.ExprNode.*;
import com.echo.compiler.ast.Location;
import com.echo.compiler.ast.Node;
import com.echo.compiler.ast.ProgramNode;
import com.echo.compiler.ast.StatNode.*;
import com.echo.compiler.ast.TypeNode.*;
import com.echo.compiler.error.CompilerError;
import com.echo.compiler.parser.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.List;


public class ASTBuilder extends mBaseVisitor<Node> {
    TypeNode TYPE;
    //    program : programBody*EOF
    @Override
    public Node visitProgram(mParser.ProgramContext ctx) {
        List<DeclNode> Decls = new ArrayList<>();
        for(ParserRuleContext programBody : ctx.programBody()){
            Node Decl = visit(programBody);
            if(Decl instanceof VarDeclListNode)
                Decls.addAll(((VarDeclListNode)Decl).getDecls());
            else
                Decls.add((DeclNode)Decl);
        }
        Location location = new Location(ctx.getStart());
        ProgramNode programNode = new ProgramNode(Decls, location);
        return programNode;
    }

    @Override
    public Node visitProgramBody(mParser.ProgramBodyContext ctx) {
        Location location = new Location(ctx.getStart());
        if(ctx.classDeclare() != null)
            return visit(ctx.classDeclare());
        else if(ctx.functionDeclare() != null)
            return visit(ctx.functionDeclare());
        else if(ctx.variableDeclare() != null)
            return visit(ctx.variableDeclare());
        else
            throw new CompilerError(location, "invalid declaration");
    }

    //    functionDeclare : typeSpecifier Identifier '(' formalParameters? ')' blockStat
    @Override
    public Node visitFunctionDeclare(mParser.FunctionDeclareContext ctx) {
        TypeNode type = (TypeNode)visit(ctx.typeSpecifier());
        String name = ctx.Identifier().getText();
        List<VarDeclNode> Parters = new ArrayList<>();
        VarDeclNode Parter;
        if(ctx.formalParameters() != null){
            for(ParserRuleContext formalParter : ctx.formalParameters().formalParameter()){
                Parter = (VarDeclNode)visit(formalParter);
                Parters.add(Parter);
            }
        }
        BlockStatNode body = (BlockStatNode)visit(ctx.blockStat());
        Location location = new Location(ctx.getStart());
        FuncDeclNode funcDeclNode = new FuncDeclNode(type, name, Parters, body, location);
        return funcDeclNode;
    }

    //    formalParameters : formalParameter (',' formalParameter)*
    @Override
    public Node visitFormalParameters(mParser.FormalParametersContext ctx) {
        return super.visitFormalParameters(ctx);
    }

    //    formalParameter : typeSpecifier Identifier
    @Override
    public Node visitFormalParameter(mParser.FormalParameterContext ctx) {
        TypeNode type = (TypeNode)visit(ctx.typeSpecifier());
        String name = ctx.Identifier().getText();
        Location location = new Location(ctx.getStart());
        VarDeclNode varDeclNode = new VarDeclNode(type, name, null, location);
        return varDeclNode;
    }

    //    classDeclare : 'class' Identifier '{' classBody* '}'
    @Override
    public Node visitClassDeclare(mParser.ClassDeclareContext ctx) {
        String name = ctx.Identifier().getText();
        List<VarDeclNode> varmember = new ArrayList<>();
        List<FuncDeclNode> funcmember = new ArrayList<>();
        Location location = new Location(ctx.getStart());
        Node member;
        if(ctx.classBody() != null){
            for(ParserRuleContext classBody : ctx.classBody()){
                member = visit(classBody);
                if(member instanceof VarDeclListNode) {
                    varmember.addAll(((VarDeclListNode)member).getDecls());
                }
                else if(member instanceof FuncDeclNode) {
                    funcmember.add((FuncDeclNode) member);
                }
                else{
                    throw new CompilerError(location, "invalid class member");
                }
            }
        }
        ClassDeclNode classDeclNode = new ClassDeclNode(name, varmember, funcmember, location);
        return classDeclNode;
    }

    private void printf(String var) {
        printf(var);
    }

    //    classBody : functionDeclare | variableDeclare
    @Override
    public Node visitClassBody(mParser.ClassBodyContext ctx) {
        Location location = new Location(ctx.getStart());
        if(ctx.functionDeclare() != null) {
            return visit(ctx.functionDeclare());
        }
        else if(ctx.variableDeclare() != null) {
            return visit(ctx.variableDeclare());
        }
        else
            throw new CompilerError(location, "Invalid member declaration");
    }

    //    variableDeclare : typeSpecifier variableDeclarator (',' variableDeclarator)* ';'
    @Override
    public Node visitVariableDeclare(mParser.VariableDeclareContext ctx) {
        TYPE = (TypeNode)visit(ctx.typeSpecifier());
        List<VarDeclNode> vars = new ArrayList<>();
        for(ParserRuleContext variableDeclarator : ctx.variableDeclarator()){
            VarDeclNode var = (VarDeclNode)visit(variableDeclarator);
            vars.add(var);
        }
        VarDeclListNode varDeclListNode = new VarDeclListNode(vars);
        return varDeclListNode;
    }

    //    variableDeclarator : Identifier ('=' expr)?
    @Override
    public Node visitVariableDeclarator(mParser.VariableDeclaratorContext ctx) {
        String name = ctx.Identifier().getText();
        ExprNode expr;
        if(ctx.expr() != null)
            expr = (ExprNode)visit(ctx.expr());
        else
            expr = null;
        Location location = new Location(ctx.getStart());
        VarDeclNode varDeclNode = new VarDeclNode(TYPE, name, expr, location);
        return varDeclNode;
    }

    //    typeSpecifier : typeSpecifier '[' ']'| nonArrayTypeSpecifier
    @Override public Node visitTypeSpecifier(mParser.TypeSpecifierContext ctx) {
        if(ctx.nonArrayTypeSpecifier() != null)
            return visit(ctx.nonArrayTypeSpecifier());
        else{
            Type type = ((TypeNode)visit(ctx.typeSpecifier())).getType();
            ArrayType arrayType = new ArrayType(type);
            Location location = new Location(ctx.getStart());
            TypeNode typeNode = new TypeNode(arrayType, location);
            return typeNode;
        }
    }

    //    nonArrayTypeSpecifier
//    :   type = 'bool'
//    |   type = 'int'
//    |   type = 'string'
//    |   type = 'void'
//    |   type = Identifier
    @Override public Node visitNonArrayTypeSpecifier(mParser.NonArrayTypeSpecifierContext ctx) {
        Location location = new Location(ctx.getStart());
        if(ctx.Identifier() != null){
            ClassType classType = new ClassType(ctx.Identifier().getText());
            TypeNode typeNode = new TypeNode(classType, location);
            return typeNode;
        }
        TypeNode typeNode;
        switch(ctx.type.getText()){
            case "bool":
                typeNode = new TypeNode(BoolType.getBoolType(), location);
                break;
            case "int":
                typeNode = new TypeNode(IntType.getIntType(), location);
                break;
            case "string":
                typeNode = new TypeNode(StringType.getStringType(), location);
                break;
            case "void":
                typeNode = new TypeNode(VoidType.getVoidType(), location);
                break;
            default:
                throw new CompilerError(location, "invalid type");
        }
        return typeNode;
    }

    //    stat : blockStat
    @Override
    public Node visitBlock(mParser.BlockContext ctx) {
        return visit(ctx.blockStat());
    }

    //    stat : expressionStat
    @Override
    public Node visitExpression(mParser.ExpressionContext ctx) {
        return visit(ctx.expressionStat());
    }

    //    stat : ifStat
    @Override
    public Node visitIf(mParser.IfContext ctx) {
        return visit(ctx.ifStat());
    }

    //    stat : iterStat
    @Override
    public Node visitIter(mParser.IterContext ctx) {
        return visit(ctx.iterationStat());
    }

    //    stat : jumpStat
    @Override
    public Node visitJump(mParser.JumpContext ctx) {
        return visit(ctx.jumpStat());
    }

    //    BlockStat : '{' blockItemList* '}'
    @Override public Node visitBlockStat(mParser.BlockStatContext ctx) {
        List<Node> stats = new ArrayList<>();
        Node node;
        if(ctx.blockItemList() != null){
            for(ParserRuleContext blockItemList : ctx.blockItemList()) {
                node = visit(blockItemList);
                if (node != null) {
                    if (node instanceof VarDeclListNode)
                        stats.addAll(((VarDeclListNode) node).getDecls());
                    else
                        stats.add(node);
                }
            }
        }
        Location location = new Location(ctx.getStart());
        BlockStatNode blockStatNode = new BlockStatNode(stats, location);
        return blockStatNode;
    }

    //    blockItemList : stat
    @Override public Node visitStatement(mParser.StatementContext ctx) {
        return visit(ctx.stat());
    }

    //    blockItemList : variableDeclare
    @Override public Node visitVariableDec(mParser.VariableDecContext ctx) {
        return visit(ctx.variableDeclare());
    }

    //    expressionStat : expr? ';'
    @Override public Node visitExpressionStat(mParser.ExpressionStatContext ctx) {
        ExprNode expr = (ExprNode)visit(ctx.expr());
        Location location = new Location(ctx.getStart());
        ExpressionStatNode expressionStatNode = new ExpressionStatNode(expr, location);
        return expressionStatNode;
    }

    //    ifStat : 'if' cond = expr  thenbody = stat ('else' elsebody = stat)?
    @Override
    public Node visitIfStat(mParser.IfStatContext ctx) {
        ExprNode cond = (ExprNode)visit(ctx.cond);
        StatNode thenbody = (StatNode)visit(ctx.thenbody);
        StatNode elsebody;
        if(ctx.elsebody != null)
            elsebody = (StatNode)visit(ctx.elsebody);
        else
            elsebody = null;
        Location location = new Location(ctx.getStart());
        IfStatNode ifStatNode = new IfStatNode(cond, thenbody, elsebody, location);
        return  ifStatNode;
    }

    //    iterationStat : 'while' '(' cond = expr ')' whilebody = stat
    @Override
    public Node visitWhile(mParser.WhileContext ctx) {
        ExprNode cond = (ExprNode)visit(ctx.cond);
        StatNode whilebody = (StatNode)visit(ctx.whilebody);
        Location location = new Location(ctx.getStart());
        WhileStatNode whileStatNode = new WhileStatNode(cond, whilebody, location);
        return  whileStatNode;
    }

    //    iterationStat : 'for' '(' init = expr? ';' cond = expr?  ';' step = expr? ')' forbody = stat    #for
    @Override public Node visitFor(mParser.ForContext ctx) {
        ExprNode init, cond, step;
        StatNode forbody = (StatNode)visit(ctx.forbody);
        if(ctx.init != null)
            init = (ExprNode)visit(ctx.init);
        else
            init = null;
        if(ctx.cond != null)
            cond = (ExprNode)visit(ctx.cond);
        else
            cond = null;
        if(ctx.step != null)
            step = (ExprNode)visit(ctx.step);
        else
            step = null;
        Location location = new Location(ctx.getStart());
        ForStatNode forStatNode = new ForStatNode(init, cond, step, forbody, location);
        return forStatNode;
    }

    //    jumpStat : 'continue' ';'
    @Override
    public Node visitContinue(mParser.ContinueContext ctx) {
        Location location = new Location(ctx.getStart());
        ContinueStatNode continueStatNode = new ContinueStatNode(location);
        return continueStatNode;
    }

    //    jumpStat : 'break' ';'
    @Override
    public Node visitBreak(mParser.BreakContext ctx) {
        Location location = new Location(ctx.getStart());
        BreakStatNode breakStatNode = new BreakStatNode(location);
        return breakStatNode;
    }

    //    jumpStat : 'return' expr? ';'
    @Override
    public Node visitReturn(mParser.ReturnContext ctx) {
        ExprNode expr;
        if(ctx.expr() != null)
            expr = (ExprNode)visit(ctx.expr());
        else
            expr = null;
        Location location = new Location(ctx.getStart());
        ReturnStatNode returnStatNode = new ReturnStatNode(expr, location);
        return returnStatNode;
    }

    //    expr : <assoc = right> 'new' creator
    @Override
    public Node visitNewExpr(mParser.NewExprContext ctx) {
        return visit(ctx.creator());
    }

    //     expr :   <assoc = right> op = ('++'|'--') expr
//     |   <assoc = right> op = ('+'|'-') expr
//     |   <assoc = right> op = '!' expr
//     |   <assoc = right> op = '~' expr
    @Override
    public Node visitPrefixExpr(mParser.PrefixExprContext ctx) {
        PrefixExprNode.PrefixOp op;
        Location location = new Location(ctx.getStart());
        switch(ctx.op.getText()){
            case "++" :
                op = PrefixExprNode.PrefixOp.PLUS_PLUS;
                break;
            case "--" :
                op = PrefixExprNode.PrefixOp.MINUS_MINUS;
                break;
            case "+"  :
                op = PrefixExprNode.PrefixOp.PLUS;
                break;
            case "-"  :
                op = PrefixExprNode.PrefixOp.MINUS;
                break;
            case "!"  :
                op = PrefixExprNode.PrefixOp.NOT;
                break;
            case "~"  :
                op = PrefixExprNode.PrefixOp.TILDE;
                break;
            default:
                throw new CompilerError(location, "Invalid prefix operator");
        }
        ExprNode expr = (ExprNode)visit(ctx.expr());
        PrefixExprNode prefixExprNode = new PrefixExprNode(op, expr, location);
        return prefixExprNode;
    }

    //    expr :   expr '[' expr ']'
    @Override
    public Node visitSubscriptExpr(mParser.SubscriptExprContext ctx) {
        ExprNode array = (ExprNode)visit(ctx.array);
        ExprNode sub = (ExprNode) visit(ctx.sub);
        Location location = new Location(ctx.getStart());
        SubscriptExprNode subscriptExprNode = new SubscriptExprNode(array, sub, location);
        return subscriptExprNode;
    }

    //    expr :   expr '(' exprs? ')'
    @Override
    public Node visitFunccallExpr(mParser.FunccallExprContext ctx) {
        ExprNode func = (ExprNode)visit(ctx.expr());
        List<ExprNode> args = new ArrayList<>();
        if (ctx.exprs() != null) {
            for (ParserRuleContext expr : ctx.exprs().expr()) {
                ExprNode exprNode = (ExprNode)visit(expr);
                args.add(exprNode);
            }
        }
        Location location = new Location(ctx.getStart());
        FuncCallExprNode funcCallExprNode =  new FuncCallExprNode(func, args, location);
        return funcCallExprNode;
    }

    //    expr :   expr '.' Identifier
    @Override
    public Node visitMemAccessExpr(mParser.MemAccessExprContext ctx) {
        ExprNode expr = (ExprNode)visit(ctx.expr());
        String member = ctx.Identifier().getText();
        Location location = new Location(ctx.getStart());
        MemAccessExprNode memAccessExprNode = new MemAccessExprNode(expr, member, location);
        return memAccessExprNode;
    }

    //    expr :   expr op = ('++'|'--')
    @Override
    public Node visitSuffixExpr(mParser.SuffixExprContext ctx) {
        SuffixExprNode.SuffixOp op;
        Location location = new Location(ctx.getStart());
        switch (ctx.op.getText()) {
            case "++" :
                op = SuffixExprNode.SuffixOp.PLUS_PLUS;
                break;
            case "--" :
                op = SuffixExprNode.SuffixOp.MINUS_MINUS;
                break;
            default:
                throw new CompilerError(location, "invalid suffix operator");
        }
        ExprNode expr = (ExprNode)visit(ctx.expr());
        SuffixExprNode suffixExprNode =  new SuffixExprNode(expr, op, location);
        return suffixExprNode;
    }

    //     expr :   expr op = ('*'|'/'|'%') expr
//     |   expr op = ('+'|'-') expr
//     |   expr op = ('<<'|'>>') expr
//     |   expr op = ('>'|'>='|'<'|'<=') expr
//     |   expr op = ('=='|'!=') expr
//     |   expr op = '&' expr
//     |   expr op = '^' expr
//     |   expr op = '|' expr
//     |   expr op = '&&' expr
//     |   expr op = '||' expr
    @Override
    public Node visitBinaryExpr(mParser.BinaryExprContext ctx) {
        BinaryExprNode.BinaryOp op;
        Location location = new Location(ctx.getStart());
        switch (ctx.op.getText()) {
            case "*"  :
                op = BinaryExprNode.BinaryOp.MUL;
                break;
            case "/"  :
                op = BinaryExprNode.BinaryOp.DIV;
                break;
            case "%"  :
                op = BinaryExprNode.BinaryOp.MOD;
                break;
            case "+"  :
                op = BinaryExprNode.BinaryOp.ADD;
                break;
            case "-"  :
                op = BinaryExprNode.BinaryOp.SUB;
                break;
            case "<<" :
                op = BinaryExprNode.BinaryOp.LEFT_SHIFT;
                break;
            case ">>" :
                op = BinaryExprNode.BinaryOp.RIGHT_SHIFT;
                break;
            case "<"  :
                op = BinaryExprNode.BinaryOp.LESS;
                break;
            case ">"  :
                op = BinaryExprNode.BinaryOp.GREATER;
                break;
            case "<=" :
                op = BinaryExprNode.BinaryOp.LESS_EQUAL;
                break;
            case ">=" :
                op = BinaryExprNode.BinaryOp.GREATER_EQUAL;
                break;
            case "==" :
                op = BinaryExprNode.BinaryOp.EQUAL;
                break;
            case "!=" :
                op = BinaryExprNode.BinaryOp.NOT_EQUAL;
                break;
            case "&"  :
                op = BinaryExprNode.BinaryOp.AND;
                break;
            case "^"  :
                op = BinaryExprNode.BinaryOp.CARET;
                break;
            case "|"  :
                op = BinaryExprNode.BinaryOp.OR;
                break;
            case "&&" :
                op = BinaryExprNode.BinaryOp.AND_AND;
                break;
            case "||" :
                op = BinaryExprNode.BinaryOp.OR_OR;
                break;
            default:
                throw new CompilerError(location, "Invalid binary operator");
        }
        ExprNode lhs = (ExprNode) visit(ctx.lhs);
        ExprNode rhs = (ExprNode) visit(ctx.rhs);
        BinaryExprNode binaryExprNode = new BinaryExprNode(lhs, op, rhs, location);
        return binaryExprNode;
    }

    //    expr :   '(' expr ')'
    @Override
    public Node visitSubExpr(mParser.SubExprContext ctx) {
        return visit(ctx.expr());
    }

    //    expr :   <assoc = right> lhs = expr op = '=' rhd = expr
    @Override
    public Node visitAssignExpr(mParser.AssignExprContext ctx) {
        ExprNode lhs = (ExprNode)visit(ctx.lhs);
        ExprNode rhs = (ExprNode)visit(ctx.rhs);
        Location location = new Location(ctx.getStart());
        AssignExprNode assignExprNode = new AssignExprNode(lhs, rhs, location);
        return assignExprNode;
    }

    //    expr :   Identifier
    @Override
    public Node visitIdentifierExpr(mParser.IdentifierExprContext ctx) {
        String identifier = ctx.Identifier().getText();
        Location location = new Location(ctx.getStart());
        IdentifierExprNode identifierExprNode =  new IdentifierExprNode(identifier, location);
        return identifierExprNode;
    }

    //    expr : constant
    @Override
    public Node visitConstantExpr(mParser.ConstantExprContext ctx) {
        return visit(ctx.constant());
    }


    @Override
    public Node visitExprs(mParser.ExprsContext ctx) {
        return super.visitExprs(ctx);
    }


    @Override
    public Node visitCreatorError(mParser.CreatorErrorContext ctx) {
        Location location = new Location(ctx.getStart());
        throw new CompilerError(location, "Invalid creator");
    }

    //    creator : nonArrayTypeSpecifier ('[' expr ']') + ('[' ']')*                       # creatorArray
    @Override
    public Node visitCreatorArray(mParser.CreatorArrayContext ctx) {
        TypeNode type = (TypeNode) visit(ctx.nonArrayTypeSpecifier());
        List<ExprNode> dims = new ArrayList<>();
        for (ParserRuleContext dim : ctx.expr())
            dims.add((ExprNode) visit(dim));
        int dim = (ctx.getChildCount() - 1 - dims.size()) / 2;
        for (int i = 0; i < dim; ++i)
            type.setType(new ArrayType(type.getType()));
        Location location = new Location(ctx.getStart());
        NewExprNode newExprNode = new NewExprNode(type, dims, dim, location);
        return newExprNode;
    }

    //|   nonArrayTypeSpecifier                                                   # creatorNonArray
    @Override
    public Node visitCreatorNonArray(mParser.CreatorNonArrayContext ctx) {
        TypeNode type = (TypeNode)visit(ctx.nonArrayTypeSpecifier());
        Location location = new Location(ctx.getStart());
        NewExprNode newExprNode = new NewExprNode(type, null, 0, location);
        return newExprNode;
    }

    //     constant
//     :   type = LogicalConstant
//     |   type = IntegerConstant
//     |   type = StringLiteral
//     |   type = NullLiteral
//     |   type = CharacterConstant
    @Override
    public Node visitConstant(mParser.ConstantContext ctx) {
        Location location = new Location(ctx.getStart());
        if (ctx.LogicalConstant() != null) {
            boolean value;
            if (ctx.getText() == "true")
                value = true;
            else if(ctx.getText() == "false")
                value = false;
            else
                throw new CompilerError(location, "Invalid bool constant");
            BoolConstExprNode boolConstExprNode = new BoolConstExprNode(value, location);
            return boolConstExprNode;
        }
        else if (ctx.IntegerConstant() != null) {
            int value = Integer.parseInt(ctx.getText());
            IntConstExprNode intConstExprNode = new IntConstExprNode(value, location);
            return intConstExprNode;
        }
        else if (ctx.StringLiteral() != null) {
            String value = ctx.getText();
            StringBuffer stringBuffer = new StringBuffer();
            int len = value.length();
            for(int i = 0; i < len; i++){
                if(i + 1 <len && value.charAt(i) == '\\'){
                    if(value.charAt(i + 1) == '\\')
                        stringBuffer.append('\\');
                    else if(value.charAt(i + 1) == 'n')
                        stringBuffer.append('\n');
                    else if(value.charAt(i + 1) == '\"')
                        stringBuffer.append('\"');
                    else
                        throw new CompilerError("invalid escaped string");
                    i++;
                }
                else
                    stringBuffer.append(value.charAt(i));
            }
            StringConstExprNode stringConstExprNode = new StringConstExprNode(stringBuffer.toString(), location);
            return stringConstExprNode;
        }
        else if (ctx.NullLiteral() != null) {
            NullExprNode nullExprNode = new NullExprNode(location);
            return nullExprNode;
        }
        else
            throw new CompilerError("invalid constant");
    }
}
