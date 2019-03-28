// Generated from C:/Users/echo/Desktop/Mcompiler/src/com/echo/compiler/parser\m.g4 by ANTLR 4.7.2
package com.echo.compiler.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link mParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface mVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link mParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(mParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link mParser#programBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramBody(mParser.ProgramBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link mParser#functionDeclare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclare(mParser.FunctionDeclareContext ctx);
	/**
	 * Visit a parse tree produced by {@link mParser#functype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctype(mParser.FunctypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link mParser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(mParser.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link mParser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(mParser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link mParser#classDeclare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclare(mParser.ClassDeclareContext ctx);
	/**
	 * Visit a parse tree produced by {@link mParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(mParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link mParser#variableDeclare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclare(mParser.VariableDeclareContext ctx);
	/**
	 * Visit a parse tree produced by {@link mParser#variableDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarator(mParser.VariableDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link mParser#typeSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSpecifier(mParser.TypeSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link mParser#nonArrayTypeSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonArrayTypeSpecifier(mParser.NonArrayTypeSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code block}
	 * labeled alternative in {@link mParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(mParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expression}
	 * labeled alternative in {@link mParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(mParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link mParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(mParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iter}
	 * labeled alternative in {@link mParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIter(mParser.IterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jump}
	 * labeled alternative in {@link mParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJump(mParser.JumpContext ctx);
	/**
	 * Visit a parse tree produced by {@link mParser#blockStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStat(mParser.BlockStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statement}
	 * labeled alternative in {@link mParser#blockItemList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(mParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableDec}
	 * labeled alternative in {@link mParser#blockItemList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDec(mParser.VariableDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link mParser#expressionStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStat(mParser.ExpressionStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link mParser#ifStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(mParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while}
	 * labeled alternative in {@link mParser#iterationStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(mParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code for}
	 * labeled alternative in {@link mParser#iterationStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor(mParser.ForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continue}
	 * labeled alternative in {@link mParser#jumpStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinue(mParser.ContinueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code break}
	 * labeled alternative in {@link mParser#jumpStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak(mParser.BreakContext ctx);
	/**
	 * Visit a parse tree produced by the {@code return}
	 * labeled alternative in {@link mParser#jumpStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(mParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpr(mParser.NewExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExpr(mParser.PrefixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code thisExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisExpr(mParser.ThisExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subscriptExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptExpr(mParser.SubscriptExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funccallExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunccallExpr(mParser.FunccallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code memAccessExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemAccessExpr(mParser.MemAccessExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code suffixExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuffixExpr(mParser.SuffixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpr(mParser.BinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubExpr(mParser.SubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpr(mParser.AssignExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpr(mParser.IdentifierExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constantExpr}
	 * labeled alternative in {@link mParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantExpr(mParser.ConstantExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link mParser#exprs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprs(mParser.ExprsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code creatorError}
	 * labeled alternative in {@link mParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatorError(mParser.CreatorErrorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code creatorArray}
	 * labeled alternative in {@link mParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatorArray(mParser.CreatorArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code creatorNonArray}
	 * labeled alternative in {@link mParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatorNonArray(mParser.CreatorNonArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link mParser#nonArrayTypeCreator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonArrayTypeCreator(mParser.NonArrayTypeCreatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link mParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(mParser.ConstantContext ctx);
}