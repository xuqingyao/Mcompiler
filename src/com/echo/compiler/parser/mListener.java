// Generated from C:/Users/echo/Desktop/Mcompiler/src/com/echo/compiler/parser\m.g4 by ANTLR 4.7.2
package com.echo.compiler.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link mParser}.
 */
public interface mListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link mParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(mParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link mParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(mParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link mParser#programBody}.
	 * @param ctx the parse tree
	 */
	void enterProgramBody(mParser.ProgramBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link mParser#programBody}.
	 * @param ctx the parse tree
	 */
	void exitProgramBody(mParser.ProgramBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link mParser#functionDeclare}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclare(mParser.FunctionDeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link mParser#functionDeclare}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclare(mParser.FunctionDeclareContext ctx);
	/**
	 * Enter a parse tree produced by {@link mParser#functype}.
	 * @param ctx the parse tree
	 */
	void enterFunctype(mParser.FunctypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link mParser#functype}.
	 * @param ctx the parse tree
	 */
	void exitFunctype(mParser.FunctypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link mParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(mParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link mParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(mParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link mParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(mParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link mParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(mParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link mParser#classDeclare}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclare(mParser.ClassDeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link mParser#classDeclare}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclare(mParser.ClassDeclareContext ctx);
	/**
	 * Enter a parse tree produced by {@link mParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(mParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link mParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(mParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link mParser#variableDeclare}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclare(mParser.VariableDeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link mParser#variableDeclare}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclare(mParser.VariableDeclareContext ctx);
	/**
	 * Enter a parse tree produced by {@link mParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarator(mParser.VariableDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link mParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarator(mParser.VariableDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link mParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpecifier(mParser.TypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link mParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpecifier(mParser.TypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link mParser#nonArrayTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterNonArrayTypeSpecifier(mParser.NonArrayTypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link mParser#nonArrayTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitNonArrayTypeSpecifier(mParser.NonArrayTypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code block}
	 * labeled alternative in {@link mParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlock(mParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code block}
	 * labeled alternative in {@link mParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlock(mParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expression}
	 * labeled alternative in {@link mParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterExpression(mParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expression}
	 * labeled alternative in {@link mParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitExpression(mParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code if}
	 * labeled alternative in {@link mParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterIf(mParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code if}
	 * labeled alternative in {@link mParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitIf(mParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code iter}
	 * labeled alternative in {@link mParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterIter(mParser.IterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code iter}
	 * labeled alternative in {@link mParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitIter(mParser.IterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jump}
	 * labeled alternative in {@link mParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterJump(mParser.JumpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jump}
	 * labeled alternative in {@link mParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitJump(mParser.JumpContext ctx);
	/**
	 * Enter a parse tree produced by {@link mParser#blockStat}.
	 * @param ctx the parse tree
	 */
	void enterBlockStat(mParser.BlockStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mParser#blockStat}.
	 * @param ctx the parse tree
	 */
	void exitBlockStat(mParser.BlockStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statement}
	 * labeled alternative in {@link mParser#blockItemList}.
	 * @param ctx the parse tree
	 */
	void enterStatement(mParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statement}
	 * labeled alternative in {@link mParser#blockItemList}.
	 * @param ctx the parse tree
	 */
	void exitStatement(mParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableDec}
	 * labeled alternative in {@link mParser#blockItemList}.
	 * @param ctx the parse tree
	 */
	void enterVariableDec(mParser.VariableDecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableDec}
	 * labeled alternative in {@link mParser#blockItemList}.
	 * @param ctx the parse tree
	 */
	void exitVariableDec(mParser.VariableDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link mParser#expressionStat}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStat(mParser.ExpressionStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mParser#expressionStat}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStat(mParser.ExpressionStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link mParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(mParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link mParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(mParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code while}
	 * labeled alternative in {@link mParser#iterationStat}.
	 * @param ctx the parse tree
	 */
	void enterWhile(mParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code while}
	 * labeled alternative in {@link mParser#iterationStat}.
	 * @param ctx the parse tree
	 */
	void exitWhile(mParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code for}
	 * labeled alternative in {@link mParser#iterationStat}.
	 * @param ctx the parse tree
	 */
	void enterFor(mParser.ForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code for}
	 * labeled alternative in {@link mParser#iterationStat}.
	 * @param ctx the parse tree
	 */
	void exitFor(mParser.ForContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continue}
	 * labeled alternative in {@link mParser#jumpStat}.
	 * @param ctx the parse tree
	 */
	void enterContinue(mParser.ContinueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continue}
	 * labeled alternative in {@link mParser#jumpStat}.
	 * @param ctx the parse tree
	 */
	void exitContinue(mParser.ContinueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code break}
	 * labeled alternative in {@link mParser#jumpStat}.
	 * @param ctx the parse tree
	 */
	void enterBreak(mParser.BreakContext ctx);
	/**
	 * Exit a parse tree produced by the {@code break}
	 * labeled alternative in {@link mParser#jumpStat}.
	 * @param ctx the parse tree
	 */
	void exitBreak(mParser.BreakContext ctx);
	/**
	 * Enter a parse tree produced by the {@code return}
	 * labeled alternative in {@link mParser#jumpStat}.
	 * @param ctx the parse tree
	 */
	void enterReturn(mParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code return}
	 * labeled alternative in {@link mParser#jumpStat}.
	 * @param ctx the parse tree
	 */
	void exitReturn(mParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNewExpr(mParser.NewExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNewExpr(mParser.NewExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExpr(mParser.PrefixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExpr(mParser.PrefixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code thisExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterThisExpr(mParser.ThisExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code thisExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitThisExpr(mParser.ThisExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subscriptExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSubscriptExpr(mParser.SubscriptExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subscriptExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSubscriptExpr(mParser.SubscriptExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funccallExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunccallExpr(mParser.FunccallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funccallExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunccallExpr(mParser.FunccallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code memAccessExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMemAccessExpr(mParser.MemAccessExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code memAccessExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMemAccessExpr(mParser.MemAccessExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code suffixExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSuffixExpr(mParser.SuffixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code suffixExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSuffixExpr(mParser.SuffixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(mParser.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(mParser.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSubExpr(mParser.SubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSubExpr(mParser.SubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpr(mParser.AssignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpr(mParser.AssignExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpr(mParser.IdentifierExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpr(mParser.IdentifierExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constantExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpr(mParser.ConstantExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constantExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpr(mParser.ConstantExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link mParser#exprs}.
	 * @param ctx the parse tree
	 */
	void enterExprs(mParser.ExprsContext ctx);
	/**
	 * Exit a parse tree produced by {@link mParser#exprs}.
	 * @param ctx the parse tree
	 */
	void exitExprs(mParser.ExprsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code creatorError}
	 * labeled alternative in {@link mParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterCreatorError(mParser.CreatorErrorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code creatorError}
	 * labeled alternative in {@link mParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitCreatorError(mParser.CreatorErrorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code creatorArray}
	 * labeled alternative in {@link mParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterCreatorArray(mParser.CreatorArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code creatorArray}
	 * labeled alternative in {@link mParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitCreatorArray(mParser.CreatorArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code creatorNonArray}
	 * labeled alternative in {@link mParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterCreatorNonArray(mParser.CreatorNonArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code creatorNonArray}
	 * labeled alternative in {@link mParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitCreatorNonArray(mParser.CreatorNonArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link mParser#nonArrayTypeCreator}.
	 * @param ctx the parse tree
	 */
	void enterNonArrayTypeCreator(mParser.NonArrayTypeCreatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link mParser#nonArrayTypeCreator}.
	 * @param ctx the parse tree
	 */
	void exitNonArrayTypeCreator(mParser.NonArrayTypeCreatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link mParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(mParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link mParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(mParser.ConstantContext ctx);
}