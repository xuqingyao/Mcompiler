// Generated from C:/Users/echo/Desktop/Mcompiler/src/com/echo/compiler/parser\m.g4 by ANTLR 4.7.2
package com.echo.compiler.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class mParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, Bool=2, Int=3, String=4, Void=5, If=6, For=7, While=8, Break=9, 
		Continue=10, Return=11, New=12, Class=13, This=14, Plus=15, Minus=16, 
		Star=17, Div=18, Mod=19, Less=20, Greater=21, Equal=22, NotEqual=23, LessEqual=24, 
		GreaterEqual=25, AndAnd=26, OrOr=27, Not=28, LeftShift=29, RightShift=30, 
		Tilde=31, Or=32, Caret=33, And=34, Assign=35, PlusPlus=36, MinusMinus=37, 
		Dot=38, LeftBracket=39, RightBracket=40, LeftParen=41, RightParen=42, 
		LeftBrace=43, RightBrace=44, Question=45, Colon=46, Semi=47, Comma=48, 
		IntegerConstant=49, StringLiteral=50, NullLiteral=51, LogicalConstant=52, 
		Identifier=53, WhiteSpace=54, NewLine=55, LineComment=56, BlockComment=57;
	public static final int
		RULE_program = 0, RULE_programBody = 1, RULE_functionDeclare = 2, RULE_functype = 3, 
		RULE_formalParameters = 4, RULE_formalParameter = 5, RULE_classDeclare = 6, 
		RULE_classBody = 7, RULE_variableDeclare = 8, RULE_variableDeclarator = 9, 
		RULE_typeSpecifier = 10, RULE_nonArrayTypeSpecifier = 11, RULE_stat = 12, 
		RULE_blockStat = 13, RULE_blockItemList = 14, RULE_expressionStat = 15, 
		RULE_ifStat = 16, RULE_iterationStat = 17, RULE_jumpStat = 18, RULE_expr = 19, 
		RULE_exprs = 20, RULE_creator = 21, RULE_constant = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "programBody", "functionDeclare", "functype", "formalParameters", 
			"formalParameter", "classDeclare", "classBody", "variableDeclare", "variableDeclarator", 
			"typeSpecifier", "nonArrayTypeSpecifier", "stat", "blockStat", "blockItemList", 
			"expressionStat", "ifStat", "iterationStat", "jumpStat", "expr", "exprs", 
			"creator", "constant"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'else'", "'bool'", "'int'", "'string'", "'void'", "'if'", "'for'", 
			"'while'", "'break'", "'continue'", "'return'", "'new'", "'class'", "'this'", 
			"'+'", "'-'", "'*'", "'/'", "'%'", "'<'", "'>'", "'=='", "'!='", "'<='", 
			"'>='", "'&&'", "'||'", "'!'", "'<<'", "'>>'", "'~'", "'|'", "'^'", "'&'", 
			"'='", "'++'", "'--'", "'.'", "'['", "']'", "'('", "')'", "'{'", "'}'", 
			"'?'", "':'", "';'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "Bool", "Int", "String", "Void", "If", "For", "While", "Break", 
			"Continue", "Return", "New", "Class", "This", "Plus", "Minus", "Star", 
			"Div", "Mod", "Less", "Greater", "Equal", "NotEqual", "LessEqual", "GreaterEqual", 
			"AndAnd", "OrOr", "Not", "LeftShift", "RightShift", "Tilde", "Or", "Caret", 
			"And", "Assign", "PlusPlus", "MinusMinus", "Dot", "LeftBracket", "RightBracket", 
			"LeftParen", "RightParen", "LeftBrace", "RightBrace", "Question", "Colon", 
			"Semi", "Comma", "IntegerConstant", "StringLiteral", "NullLiteral", "LogicalConstant", 
			"Identifier", "WhiteSpace", "NewLine", "LineComment", "BlockComment"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "m.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public mParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(mParser.EOF, 0); }
		public List<ProgramBodyContext> programBody() {
			return getRuleContexts(ProgramBodyContext.class);
		}
		public ProgramBodyContext programBody(int i) {
			return getRuleContext(ProgramBodyContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << Class) | (1L << Identifier))) != 0)) {
				{
				{
				setState(46);
				programBody();
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramBodyContext extends ParserRuleContext {
		public FunctionDeclareContext functionDeclare() {
			return getRuleContext(FunctionDeclareContext.class,0);
		}
		public ClassDeclareContext classDeclare() {
			return getRuleContext(ClassDeclareContext.class,0);
		}
		public VariableDeclareContext variableDeclare() {
			return getRuleContext(VariableDeclareContext.class,0);
		}
		public ProgramBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterProgramBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitProgramBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitProgramBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramBodyContext programBody() throws RecognitionException {
		ProgramBodyContext _localctx = new ProgramBodyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_programBody);
		try {
			setState(57);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				functionDeclare();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				classDeclare();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				variableDeclare();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclareContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(mParser.Identifier, 0); }
		public TerminalNode LeftParen() { return getToken(mParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(mParser.RightParen, 0); }
		public BlockStatContext blockStat() {
			return getRuleContext(BlockStatContext.class,0);
		}
		public FunctypeContext functype() {
			return getRuleContext(FunctypeContext.class,0);
		}
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public FunctionDeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterFunctionDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitFunctionDeclare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitFunctionDeclare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclareContext functionDeclare() throws RecognitionException {
		FunctionDeclareContext _localctx = new FunctionDeclareContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionDeclare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(59);
				functype();
				}
				break;
			}
			setState(62);
			match(Identifier);
			setState(63);
			match(LeftParen);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(64);
				formalParameters();
				}
			}

			setState(67);
			match(RightParen);
			setState(68);
			blockStat();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctypeContext extends ParserRuleContext {
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public TerminalNode Void() { return getToken(mParser.Void, 0); }
		public FunctypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterFunctype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitFunctype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitFunctype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctypeContext functype() throws RecognitionException {
		FunctypeContext _localctx = new FunctypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functype);
		try {
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Bool:
			case Int:
			case String:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				typeSpecifier(0);
				}
				break;
			case Void:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				match(Void);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParametersContext extends ParserRuleContext {
		public List<FormalParameterContext> formalParameter() {
			return getRuleContexts(FormalParameterContext.class);
		}
		public FormalParameterContext formalParameter(int i) {
			return getRuleContext(FormalParameterContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(mParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(mParser.Comma, i);
		}
		public FormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterFormalParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitFormalParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitFormalParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_formalParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			formalParameter();
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(75);
				match(Comma);
				setState(76);
				formalParameter();
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParameterContext extends ParserRuleContext {
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(mParser.Identifier, 0); }
		public FormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitFormalParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitFormalParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_formalParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			typeSpecifier(0);
			setState(83);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclareContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(mParser.Class, 0); }
		public TerminalNode Identifier() { return getToken(mParser.Identifier, 0); }
		public TerminalNode LeftBrace() { return getToken(mParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(mParser.RightBrace, 0); }
		public List<ClassBodyContext> classBody() {
			return getRuleContexts(ClassBodyContext.class);
		}
		public ClassBodyContext classBody(int i) {
			return getRuleContext(ClassBodyContext.class,i);
		}
		public ClassDeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterClassDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitClassDeclare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitClassDeclare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclareContext classDeclare() throws RecognitionException {
		ClassDeclareContext _localctx = new ClassDeclareContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_classDeclare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(Class);
			setState(86);
			match(Identifier);
			setState(87);
			match(LeftBrace);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << Identifier))) != 0)) {
				{
				{
				setState(88);
				classBody();
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassBodyContext extends ParserRuleContext {
		public FunctionDeclareContext functionDeclare() {
			return getRuleContext(FunctionDeclareContext.class,0);
		}
		public VariableDeclareContext variableDeclare() {
			return getRuleContext(VariableDeclareContext.class,0);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitClassBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitClassBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_classBody);
		try {
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				functionDeclare();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				variableDeclare();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclareContext extends ParserRuleContext {
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public List<VariableDeclaratorContext> variableDeclarator() {
			return getRuleContexts(VariableDeclaratorContext.class);
		}
		public VariableDeclaratorContext variableDeclarator(int i) {
			return getRuleContext(VariableDeclaratorContext.class,i);
		}
		public TerminalNode Semi() { return getToken(mParser.Semi, 0); }
		public List<TerminalNode> Comma() { return getTokens(mParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(mParser.Comma, i);
		}
		public VariableDeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterVariableDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitVariableDeclare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitVariableDeclare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclareContext variableDeclare() throws RecognitionException {
		VariableDeclareContext _localctx = new VariableDeclareContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_variableDeclare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			typeSpecifier(0);
			setState(101);
			variableDeclarator();
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(102);
				match(Comma);
				setState(103);
				variableDeclarator();
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclaratorContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(mParser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(mParser.Assign, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VariableDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterVariableDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitVariableDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitVariableDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclaratorContext variableDeclarator() throws RecognitionException {
		VariableDeclaratorContext _localctx = new VariableDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_variableDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(Identifier);
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(112);
				match(Assign);
				setState(113);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeSpecifierContext extends ParserRuleContext {
		public NonArrayTypeSpecifierContext nonArrayTypeSpecifier() {
			return getRuleContext(NonArrayTypeSpecifierContext.class,0);
		}
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public TerminalNode LeftBracket() { return getToken(mParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(mParser.RightBracket, 0); }
		public TypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitTypeSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitTypeSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeSpecifierContext typeSpecifier() throws RecognitionException {
		return typeSpecifier(0);
	}

	private TypeSpecifierContext typeSpecifier(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeSpecifierContext _localctx = new TypeSpecifierContext(_ctx, _parentState);
		TypeSpecifierContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_typeSpecifier, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(117);
			nonArrayTypeSpecifier();
			}
			_ctx.stop = _input.LT(-1);
			setState(124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeSpecifierContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_typeSpecifier);
					setState(119);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(120);
					match(LeftBracket);
					setState(121);
					match(RightBracket);
					}
					}
				}
				setState(126);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class NonArrayTypeSpecifierContext extends ParserRuleContext {
		public Token type;
		public TerminalNode Bool() { return getToken(mParser.Bool, 0); }
		public TerminalNode Int() { return getToken(mParser.Int, 0); }
		public TerminalNode String() { return getToken(mParser.String, 0); }
		public TerminalNode Identifier() { return getToken(mParser.Identifier, 0); }
		public NonArrayTypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonArrayTypeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterNonArrayTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitNonArrayTypeSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitNonArrayTypeSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonArrayTypeSpecifierContext nonArrayTypeSpecifier() throws RecognitionException {
		NonArrayTypeSpecifierContext _localctx = new NonArrayTypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_nonArrayTypeSpecifier);
		try {
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Bool:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				((NonArrayTypeSpecifierContext)_localctx).type = match(Bool);
				}
				break;
			case Int:
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				((NonArrayTypeSpecifierContext)_localctx).type = match(Int);
				}
				break;
			case String:
				enterOuterAlt(_localctx, 3);
				{
				setState(129);
				((NonArrayTypeSpecifierContext)_localctx).type = match(String);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 4);
				{
				setState(130);
				((NonArrayTypeSpecifierContext)_localctx).type = match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }

		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExpressionContext extends StatContext {
		public ExpressionStatContext expressionStat() {
			return getRuleContext(ExpressionStatContext.class,0);
		}
		public ExpressionContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IterContext extends StatContext {
		public IterationStatContext iterationStat() {
			return getRuleContext(IterationStatContext.class,0);
		}
		public IterContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterIter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitIter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitIter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockContext extends StatContext {
		public BlockStatContext blockStat() {
			return getRuleContext(BlockStatContext.class,0);
		}
		public BlockContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfContext extends StatContext {
		public IfStatContext ifStat() {
			return getRuleContext(IfStatContext.class,0);
		}
		public IfContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class JumpContext extends StatContext {
		public JumpStatContext jumpStat() {
			return getRuleContext(JumpStatContext.class,0);
		}
		public JumpContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterJump(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitJump(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitJump(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stat);
		try {
			setState(138);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBrace:
				_localctx = new BlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				blockStat();
				}
				break;
			case New:
			case This:
			case Plus:
			case Minus:
			case Not:
			case Tilde:
			case PlusPlus:
			case MinusMinus:
			case LeftParen:
			case Semi:
			case IntegerConstant:
			case StringLiteral:
			case NullLiteral:
			case LogicalConstant:
			case Identifier:
				_localctx = new ExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				expressionStat();
				}
				break;
			case If:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(135);
				ifStat();
				}
				break;
			case For:
			case While:
				_localctx = new IterContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(136);
				iterationStat();
				}
				break;
			case Break:
			case Continue:
			case Return:
				_localctx = new JumpContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(137);
				jumpStat();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStatContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(mParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(mParser.RightBrace, 0); }
		public List<BlockItemListContext> blockItemList() {
			return getRuleContexts(BlockItemListContext.class);
		}
		public BlockItemListContext blockItemList(int i) {
			return getRuleContext(BlockItemListContext.class,i);
		}
		public BlockStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterBlockStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitBlockStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitBlockStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatContext blockStat() throws RecognitionException {
		BlockStatContext _localctx = new BlockStatContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_blockStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(LeftBrace);
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << New) | (1L << This) | (1L << Plus) | (1L << Minus) | (1L << Not) | (1L << Tilde) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << LeftParen) | (1L << LeftBrace) | (1L << Semi) | (1L << IntegerConstant) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LogicalConstant) | (1L << Identifier))) != 0)) {
				{
				{
				setState(141);
				blockItemList();
				}
				}
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(147);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockItemListContext extends ParserRuleContext {
		public BlockItemListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockItemList; }

		public BlockItemListContext() { }
		public void copyFrom(BlockItemListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StatementContext extends BlockItemListContext {
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public StatementContext(BlockItemListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableDecContext extends BlockItemListContext {
		public VariableDeclareContext variableDeclare() {
			return getRuleContext(VariableDeclareContext.class,0);
		}
		public VariableDecContext(BlockItemListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterVariableDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitVariableDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitVariableDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockItemListContext blockItemList() throws RecognitionException {
		BlockItemListContext _localctx = new BlockItemListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_blockItemList);
		try {
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new StatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				stat();
				}
				break;
			case 2:
				_localctx = new VariableDecContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				variableDeclare();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionStatContext extends ParserRuleContext {
		public TerminalNode Semi() { return getToken(mParser.Semi, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExpressionStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterExpressionStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitExpressionStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitExpressionStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionStatContext expressionStat() throws RecognitionException {
		ExpressionStatContext _localctx = new ExpressionStatContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expressionStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << This) | (1L << Plus) | (1L << Minus) | (1L << Not) | (1L << Tilde) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << LeftParen) | (1L << IntegerConstant) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LogicalConstant) | (1L << Identifier))) != 0)) {
				{
				setState(153);
				expr(0);
				}
			}

			setState(156);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatContext extends ParserRuleContext {
		public ExprContext cond;
		public StatContext thenbody;
		public StatContext elsebody;
		public TerminalNode If() { return getToken(mParser.If, 0); }
		public TerminalNode LeftParen() { return getToken(mParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(mParser.RightParen, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public IfStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitIfStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitIfStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatContext ifStat() throws RecognitionException {
		IfStatContext _localctx = new IfStatContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ifStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(If);
			setState(159);
			match(LeftParen);
			setState(160);
			((IfStatContext)_localctx).cond = expr(0);
			setState(161);
			match(RightParen);
			setState(162);
			((IfStatContext)_localctx).thenbody = stat();
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(163);
				match(T__0);
				setState(164);
				((IfStatContext)_localctx).elsebody = stat();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IterationStatContext extends ParserRuleContext {
		public IterationStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterationStat; }

		public IterationStatContext() { }
		public void copyFrom(IterationStatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ForContext extends IterationStatContext {
		public ExprContext init;
		public ExprContext cond;
		public ExprContext step;
		public StatContext forbody;
		public TerminalNode For() { return getToken(mParser.For, 0); }
		public TerminalNode LeftParen() { return getToken(mParser.LeftParen, 0); }
		public List<TerminalNode> Semi() { return getTokens(mParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(mParser.Semi, i);
		}
		public TerminalNode RightParen() { return getToken(mParser.RightParen, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ForContext(IterationStatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitFor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitFor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileContext extends IterationStatContext {
		public ExprContext cond;
		public StatContext whilebody;
		public TerminalNode While() { return getToken(mParser.While, 0); }
		public TerminalNode LeftParen() { return getToken(mParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(mParser.RightParen, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public WhileContext(IterationStatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterationStatContext iterationStat() throws RecognitionException {
		IterationStatContext _localctx = new IterationStatContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_iterationStat);
		int _la;
		try {
			setState(188);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case While:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				match(While);
				setState(168);
				match(LeftParen);
				setState(169);
				((WhileContext)_localctx).cond = expr(0);
				setState(170);
				match(RightParen);
				setState(171);
				((WhileContext)_localctx).whilebody = stat();
				}
				break;
			case For:
				_localctx = new ForContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				match(For);
				setState(174);
				match(LeftParen);
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << This) | (1L << Plus) | (1L << Minus) | (1L << Not) | (1L << Tilde) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << LeftParen) | (1L << IntegerConstant) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LogicalConstant) | (1L << Identifier))) != 0)) {
					{
					setState(175);
					((ForContext)_localctx).init = expr(0);
					}
				}

				setState(178);
				match(Semi);
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << This) | (1L << Plus) | (1L << Minus) | (1L << Not) | (1L << Tilde) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << LeftParen) | (1L << IntegerConstant) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LogicalConstant) | (1L << Identifier))) != 0)) {
					{
					setState(179);
					((ForContext)_localctx).cond = expr(0);
					}
				}

				setState(182);
				match(Semi);
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << This) | (1L << Plus) | (1L << Minus) | (1L << Not) | (1L << Tilde) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << LeftParen) | (1L << IntegerConstant) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LogicalConstant) | (1L << Identifier))) != 0)) {
					{
					setState(183);
					((ForContext)_localctx).step = expr(0);
					}
				}

				setState(186);
				match(RightParen);
				setState(187);
				((ForContext)_localctx).forbody = stat();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JumpStatContext extends ParserRuleContext {
		public JumpStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpStat; }

		public JumpStatContext() { }
		public void copyFrom(JumpStatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BreakContext extends JumpStatContext {
		public TerminalNode Break() { return getToken(mParser.Break, 0); }
		public TerminalNode Semi() { return getToken(mParser.Semi, 0); }
		public BreakContext(JumpStatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterBreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitBreak(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitBreak(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContinueContext extends JumpStatContext {
		public TerminalNode Continue() { return getToken(mParser.Continue, 0); }
		public TerminalNode Semi() { return getToken(mParser.Semi, 0); }
		public ContinueContext(JumpStatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterContinue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitContinue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitContinue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnContext extends JumpStatContext {
		public TerminalNode Return() { return getToken(mParser.Return, 0); }
		public TerminalNode Semi() { return getToken(mParser.Semi, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnContext(JumpStatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitReturn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JumpStatContext jumpStat() throws RecognitionException {
		JumpStatContext _localctx = new JumpStatContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_jumpStat);
		int _la;
		try {
			setState(199);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Continue:
				_localctx = new ContinueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				match(Continue);
				setState(191);
				match(Semi);
				}
				break;
			case Break:
				_localctx = new BreakContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				match(Break);
				setState(193);
				match(Semi);
				}
				break;
			case Return:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(194);
				match(Return);
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << This) | (1L << Plus) | (1L << Minus) | (1L << Not) | (1L << Tilde) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << LeftParen) | (1L << IntegerConstant) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LogicalConstant) | (1L << Identifier))) != 0)) {
					{
					setState(195);
					expr(0);
					}
				}

				setState(198);
				match(Semi);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }

		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NewExprContext extends ExprContext {
		public TerminalNode New() { return getToken(mParser.New, 0); }
		public CreatorContext creator() {
			return getRuleContext(CreatorContext.class,0);
		}
		public NewExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterNewExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitNewExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitNewExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrefixExprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PlusPlus() { return getToken(mParser.PlusPlus, 0); }
		public TerminalNode MinusMinus() { return getToken(mParser.MinusMinus, 0); }
		public TerminalNode Plus() { return getToken(mParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(mParser.Minus, 0); }
		public TerminalNode Not() { return getToken(mParser.Not, 0); }
		public TerminalNode Tilde() { return getToken(mParser.Tilde, 0); }
		public PrefixExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterPrefixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitPrefixExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitPrefixExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ThisExprContext extends ExprContext {
		public TerminalNode This() { return getToken(mParser.This, 0); }
		public ThisExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterThisExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitThisExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitThisExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubscriptExprContext extends ExprContext {
		public ExprContext array;
		public ExprContext sub;
		public TerminalNode LeftBracket() { return getToken(mParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(mParser.RightBracket, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SubscriptExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterSubscriptExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitSubscriptExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitSubscriptExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunccallExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(mParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(mParser.RightParen, 0); }
		public ExprsContext exprs() {
			return getRuleContext(ExprsContext.class,0);
		}
		public FunccallExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterFunccallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitFunccallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitFunccallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MemAccessExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Dot() { return getToken(mParser.Dot, 0); }
		public TerminalNode Identifier() { return getToken(mParser.Identifier, 0); }
		public MemAccessExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterMemAccessExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitMemAccessExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitMemAccessExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SuffixExprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PlusPlus() { return getToken(mParser.PlusPlus, 0); }
		public TerminalNode MinusMinus() { return getToken(mParser.MinusMinus, 0); }
		public SuffixExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterSuffixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitSuffixExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitSuffixExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryExprContext extends ExprContext {
		public ExprContext lhs;
		public Token op;
		public ExprContext rhs;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Star() { return getToken(mParser.Star, 0); }
		public TerminalNode Div() { return getToken(mParser.Div, 0); }
		public TerminalNode Mod() { return getToken(mParser.Mod, 0); }
		public TerminalNode Plus() { return getToken(mParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(mParser.Minus, 0); }
		public TerminalNode LeftShift() { return getToken(mParser.LeftShift, 0); }
		public TerminalNode RightShift() { return getToken(mParser.RightShift, 0); }
		public TerminalNode Greater() { return getToken(mParser.Greater, 0); }
		public TerminalNode GreaterEqual() { return getToken(mParser.GreaterEqual, 0); }
		public TerminalNode Less() { return getToken(mParser.Less, 0); }
		public TerminalNode LessEqual() { return getToken(mParser.LessEqual, 0); }
		public TerminalNode Equal() { return getToken(mParser.Equal, 0); }
		public TerminalNode NotEqual() { return getToken(mParser.NotEqual, 0); }
		public TerminalNode And() { return getToken(mParser.And, 0); }
		public TerminalNode Caret() { return getToken(mParser.Caret, 0); }
		public TerminalNode Or() { return getToken(mParser.Or, 0); }
		public TerminalNode AndAnd() { return getToken(mParser.AndAnd, 0); }
		public TerminalNode OrOr() { return getToken(mParser.OrOr, 0); }
		public BinaryExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterBinaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitBinaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitBinaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubExprContext extends ExprContext {
		public TerminalNode LeftParen() { return getToken(mParser.LeftParen, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(mParser.RightParen, 0); }
		public SubExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterSubExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitSubExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitSubExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignExprContext extends ExprContext {
		public ExprContext lhs;
		public Token op;
		public ExprContext rhs;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Assign() { return getToken(mParser.Assign, 0); }
		public AssignExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitAssignExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitAssignExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierExprContext extends ExprContext {
		public TerminalNode Identifier() { return getToken(mParser.Identifier, 0); }
		public IdentifierExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterIdentifierExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitIdentifierExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitIdentifierExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstantExprContext extends ExprContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ConstantExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterConstantExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitConstantExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitConstantExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PlusPlus:
			case MinusMinus:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(202);
				((PrefixExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PlusPlus || _la==MinusMinus) ) {
					((PrefixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(203);
				expr(20);
				}
				break;
			case Plus:
			case Minus:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(204);
				((PrefixExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Plus || _la==Minus) ) {
					((PrefixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(205);
				expr(19);
				}
				break;
			case Not:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(206);
				((PrefixExprContext)_localctx).op = match(Not);
				setState(207);
				expr(18);
				}
				break;
			case Tilde:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(208);
				((PrefixExprContext)_localctx).op = match(Tilde);
				setState(209);
				expr(17);
				}
				break;
			case New:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(210);
				match(New);
				setState(211);
				creator();
				}
				break;
			case Identifier:
				{
				_localctx = new IdentifierExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(212);
				match(Identifier);
				}
				break;
			case This:
				{
				_localctx = new ThisExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(213);
				match(This);
				}
				break;
			case IntegerConstant:
			case StringLiteral:
			case NullLiteral:
			case LogicalConstant:
				{
				_localctx = new ConstantExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(214);
				constant();
				}
				break;
			case LeftParen:
				{
				_localctx = new SubExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(215);
				match(LeftParen);
				setState(216);
				expr(0);
				setState(217);
				match(RightParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(272);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(270);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(221);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(222);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Star) | (1L << Div) | (1L << Mod))) != 0)) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(223);
						((BinaryExprContext)_localctx).rhs = expr(16);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(224);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(225);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Plus || _la==Minus) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(226);
						((BinaryExprContext)_localctx).rhs = expr(15);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(227);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(228);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==LeftShift || _la==RightShift) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(229);
						((BinaryExprContext)_localctx).rhs = expr(14);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(230);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(231);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Less) | (1L << Greater) | (1L << LessEqual) | (1L << GreaterEqual))) != 0)) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(232);
						((BinaryExprContext)_localctx).rhs = expr(13);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(233);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(234);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Equal || _la==NotEqual) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(235);
						((BinaryExprContext)_localctx).rhs = expr(12);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(236);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(237);
						((BinaryExprContext)_localctx).op = match(And);
						setState(238);
						((BinaryExprContext)_localctx).rhs = expr(11);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(239);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(240);
						((BinaryExprContext)_localctx).op = match(Caret);
						setState(241);
						((BinaryExprContext)_localctx).rhs = expr(10);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(242);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(243);
						((BinaryExprContext)_localctx).op = match(Or);
						setState(244);
						((BinaryExprContext)_localctx).rhs = expr(9);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(245);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(246);
						((BinaryExprContext)_localctx).op = match(AndAnd);
						setState(247);
						((BinaryExprContext)_localctx).rhs = expr(8);
						}
						break;
					case 10:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(248);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(249);
						((BinaryExprContext)_localctx).op = match(OrOr);
						setState(250);
						((BinaryExprContext)_localctx).rhs = expr(7);
						}
						break;
					case 11:
						{
						_localctx = new AssignExprContext(new ExprContext(_parentctx, _parentState));
						((AssignExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(251);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(252);
						((AssignExprContext)_localctx).op = match(Assign);
						setState(253);
						((AssignExprContext)_localctx).rhs = expr(5);
						}
						break;
					case 12:
						{
						_localctx = new SubscriptExprContext(new ExprContext(_parentctx, _parentState));
						((SubscriptExprContext)_localctx).array = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(254);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(255);
						match(LeftBracket);
						setState(256);
						((SubscriptExprContext)_localctx).sub = expr(0);
						setState(257);
						match(RightBracket);
						}
						break;
					case 13:
						{
						_localctx = new FunccallExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(259);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(260);
						match(LeftParen);
						setState(262);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << This) | (1L << Plus) | (1L << Minus) | (1L << Not) | (1L << Tilde) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << LeftParen) | (1L << IntegerConstant) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LogicalConstant) | (1L << Identifier))) != 0)) {
							{
							setState(261);
							exprs();
							}
						}

						setState(264);
						match(RightParen);
						}
						break;
					case 14:
						{
						_localctx = new MemAccessExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(265);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(266);
						match(Dot);
						setState(267);
						match(Identifier);
						}
						break;
					case 15:
						{
						_localctx = new SuffixExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(268);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(269);
						((SuffixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PlusPlus || _la==MinusMinus) ) {
							((SuffixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					}
				}
				setState(274);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExprsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(mParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(mParser.Comma, i);
		}
		public ExprsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterExprs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitExprs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitExprs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprsContext exprs() throws RecognitionException {
		ExprsContext _localctx = new ExprsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_exprs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			expr(0);
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(276);
				match(Comma);
				setState(277);
				expr(0);
				}
				}
				setState(282);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreatorContext extends ParserRuleContext {
		public CreatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creator; }

		public CreatorContext() { }
		public void copyFrom(CreatorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CreatorErrorContext extends CreatorContext {
		public NonArrayTypeSpecifierContext nonArrayTypeSpecifier() {
			return getRuleContext(NonArrayTypeSpecifierContext.class,0);
		}
		public List<TerminalNode> LeftBracket() { return getTokens(mParser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(mParser.LeftBracket, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(mParser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(mParser.RightBracket, i);
		}
		public CreatorErrorContext(CreatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterCreatorError(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitCreatorError(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitCreatorError(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreatorNonArrayContext extends CreatorContext {
		public NonArrayTypeSpecifierContext nonArrayTypeSpecifier() {
			return getRuleContext(NonArrayTypeSpecifierContext.class,0);
		}
		public CreatorNonArrayContext(CreatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterCreatorNonArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitCreatorNonArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitCreatorNonArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreatorArrayContext extends CreatorContext {
		public NonArrayTypeSpecifierContext nonArrayTypeSpecifier() {
			return getRuleContext(NonArrayTypeSpecifierContext.class,0);
		}
		public List<TerminalNode> LeftBracket() { return getTokens(mParser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(mParser.LeftBracket, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(mParser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(mParser.RightBracket, i);
		}
		public CreatorArrayContext(CreatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterCreatorArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitCreatorArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitCreatorArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreatorContext creator() throws RecognitionException {
		CreatorContext _localctx = new CreatorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_creator);
		try {
			int _alt;
			setState(323);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				_localctx = new CreatorErrorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(283);
				nonArrayTypeSpecifier();
				setState(288);
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(284);
						match(LeftBracket);
						setState(285);
						expr(0);
						setState(286);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(290);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
				setState(294);
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(292);
						match(LeftBracket);
						setState(293);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(296);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
				setState(302);
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(298);
						match(LeftBracket);
						setState(299);
						expr(0);
						setState(300);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(304);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				_localctx = new CreatorArrayContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(306);
				nonArrayTypeSpecifier();
				setState(311);
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(307);
						match(LeftBracket);
						setState(308);
						expr(0);
						setState(309);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(313);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
				setState(319);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(315);
						match(LeftBracket);
						setState(316);
						match(RightBracket);
						}
						} 
					}
					setState(321);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				}
				}
				break;
			case 3:
				_localctx = new CreatorNonArrayContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(322);
				nonArrayTypeSpecifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public Token type;
		public TerminalNode LogicalConstant() { return getToken(mParser.LogicalConstant, 0); }
		public TerminalNode IntegerConstant() { return getToken(mParser.IntegerConstant, 0); }
		public TerminalNode StringLiteral() { return getToken(mParser.StringLiteral, 0); }
		public TerminalNode NullLiteral() { return getToken(mParser.NullLiteral, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mListener ) ((mListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mVisitor ) return ((mVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_constant);
		try {
			setState(329);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LogicalConstant:
				enterOuterAlt(_localctx, 1);
				{
				setState(325);
				((ConstantContext)_localctx).type = match(LogicalConstant);
				}
				break;
			case IntegerConstant:
				enterOuterAlt(_localctx, 2);
				{
				setState(326);
				((ConstantContext)_localctx).type = match(IntegerConstant);
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(327);
				((ConstantContext)_localctx).type = match(StringLiteral);
				}
				break;
			case NullLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(328);
				((ConstantContext)_localctx).type = match(NullLiteral);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return typeSpecifier_sempred((TypeSpecifierContext)_localctx, predIndex);
		case 19:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean typeSpecifier_sempred(TypeSpecifierContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 15);
		case 2:
			return precpred(_ctx, 14);
		case 3:
			return precpred(_ctx, 13);
		case 4:
			return precpred(_ctx, 12);
		case 5:
			return precpred(_ctx, 11);
		case 6:
			return precpred(_ctx, 10);
		case 7:
			return precpred(_ctx, 9);
		case 8:
			return precpred(_ctx, 8);
		case 9:
			return precpred(_ctx, 7);
		case 10:
			return precpred(_ctx, 6);
		case 11:
			return precpred(_ctx, 5);
		case 12:
			return precpred(_ctx, 24);
		case 13:
			return precpred(_ctx, 23);
		case 14:
			return precpred(_ctx, 22);
		case 15:
			return precpred(_ctx, 21);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3;\u014e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\7\2\62"+
		"\n\2\f\2\16\2\65\13\2\3\2\3\2\3\3\3\3\3\3\5\3<\n\3\3\4\5\4?\n\4\3\4\3"+
		"\4\3\4\5\4D\n\4\3\4\3\4\3\4\3\5\3\5\5\5K\n\5\3\6\3\6\3\6\7\6P\n\6\f\6"+
		"\16\6S\13\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\7\b\\\n\b\f\b\16\b_\13\b\3\b\3"+
		"\b\3\t\3\t\5\te\n\t\3\n\3\n\3\n\3\n\7\nk\n\n\f\n\16\nn\13\n\3\n\3\n\3"+
		"\13\3\13\3\13\5\13u\n\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f}\n\f\f\f\16\f\u0080"+
		"\13\f\3\r\3\r\3\r\3\r\5\r\u0086\n\r\3\16\3\16\3\16\3\16\3\16\5\16\u008d"+
		"\n\16\3\17\3\17\7\17\u0091\n\17\f\17\16\17\u0094\13\17\3\17\3\17\3\20"+
		"\3\20\5\20\u009a\n\20\3\21\5\21\u009d\n\21\3\21\3\21\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\5\22\u00a8\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\5\23\u00b3\n\23\3\23\3\23\5\23\u00b7\n\23\3\23\3\23\5\23\u00bb"+
		"\n\23\3\23\3\23\5\23\u00bf\n\23\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00c7"+
		"\n\24\3\24\5\24\u00ca\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00de\n\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0109\n\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u0111\n\25\f\25\16\25\u0114\13\25"+
		"\3\26\3\26\3\26\7\26\u0119\n\26\f\26\16\26\u011c\13\26\3\27\3\27\3\27"+
		"\3\27\3\27\6\27\u0123\n\27\r\27\16\27\u0124\3\27\3\27\6\27\u0129\n\27"+
		"\r\27\16\27\u012a\3\27\3\27\3\27\3\27\6\27\u0131\n\27\r\27\16\27\u0132"+
		"\3\27\3\27\3\27\3\27\3\27\6\27\u013a\n\27\r\27\16\27\u013b\3\27\3\27\7"+
		"\27\u0140\n\27\f\27\16\27\u0143\13\27\3\27\5\27\u0146\n\27\3\30\3\30\3"+
		"\30\3\30\5\30\u014c\n\30\3\30\2\4\26(\31\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\2\b\3\2&\'\3\2\21\22\3\2\23\25\3\2\37 \4\2\26\27\32"+
		"\33\3\2\30\31\2\u0177\2\63\3\2\2\2\4;\3\2\2\2\6>\3\2\2\2\bJ\3\2\2\2\n"+
		"L\3\2\2\2\fT\3\2\2\2\16W\3\2\2\2\20d\3\2\2\2\22f\3\2\2\2\24q\3\2\2\2\26"+
		"v\3\2\2\2\30\u0085\3\2\2\2\32\u008c\3\2\2\2\34\u008e\3\2\2\2\36\u0099"+
		"\3\2\2\2 \u009c\3\2\2\2\"\u00a0\3\2\2\2$\u00be\3\2\2\2&\u00c9\3\2\2\2"+
		"(\u00dd\3\2\2\2*\u0115\3\2\2\2,\u0145\3\2\2\2.\u014b\3\2\2\2\60\62\5\4"+
		"\3\2\61\60\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\66\3\2"+
		"\2\2\65\63\3\2\2\2\66\67\7\2\2\3\67\3\3\2\2\28<\5\6\4\29<\5\16\b\2:<\5"+
		"\22\n\2;8\3\2\2\2;9\3\2\2\2;:\3\2\2\2<\5\3\2\2\2=?\5\b\5\2>=\3\2\2\2>"+
		"?\3\2\2\2?@\3\2\2\2@A\7\67\2\2AC\7+\2\2BD\5\n\6\2CB\3\2\2\2CD\3\2\2\2"+
		"DE\3\2\2\2EF\7,\2\2FG\5\34\17\2G\7\3\2\2\2HK\5\26\f\2IK\7\7\2\2JH\3\2"+
		"\2\2JI\3\2\2\2K\t\3\2\2\2LQ\5\f\7\2MN\7\62\2\2NP\5\f\7\2OM\3\2\2\2PS\3"+
		"\2\2\2QO\3\2\2\2QR\3\2\2\2R\13\3\2\2\2SQ\3\2\2\2TU\5\26\f\2UV\7\67\2\2"+
		"V\r\3\2\2\2WX\7\17\2\2XY\7\67\2\2Y]\7-\2\2Z\\\5\20\t\2[Z\3\2\2\2\\_\3"+
		"\2\2\2][\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2\2`a\7.\2\2a\17\3\2\2\2be"+
		"\5\6\4\2ce\5\22\n\2db\3\2\2\2dc\3\2\2\2e\21\3\2\2\2fg\5\26\f\2gl\5\24"+
		"\13\2hi\7\62\2\2ik\5\24\13\2jh\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2m"+
		"o\3\2\2\2nl\3\2\2\2op\7\61\2\2p\23\3\2\2\2qt\7\67\2\2rs\7%\2\2su\5(\25"+
		"\2tr\3\2\2\2tu\3\2\2\2u\25\3\2\2\2vw\b\f\1\2wx\5\30\r\2x~\3\2\2\2yz\f"+
		"\4\2\2z{\7)\2\2{}\7*\2\2|y\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2"+
		"\2\177\27\3\2\2\2\u0080~\3\2\2\2\u0081\u0086\7\4\2\2\u0082\u0086\7\5\2"+
		"\2\u0083\u0086\7\6\2\2\u0084\u0086\7\67\2\2\u0085\u0081\3\2\2\2\u0085"+
		"\u0082\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0084\3\2\2\2\u0086\31\3\2\2"+
		"\2\u0087\u008d\5\34\17\2\u0088\u008d\5 \21\2\u0089\u008d\5\"\22\2\u008a"+
		"\u008d\5$\23\2\u008b\u008d\5&\24\2\u008c\u0087\3\2\2\2\u008c\u0088\3\2"+
		"\2\2\u008c\u0089\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008b\3\2\2\2\u008d"+
		"\33\3\2\2\2\u008e\u0092\7-\2\2\u008f\u0091\5\36\20\2\u0090\u008f\3\2\2"+
		"\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095"+
		"\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0096\7.\2\2\u0096\35\3\2\2\2\u0097"+
		"\u009a\5\32\16\2\u0098\u009a\5\22\n\2\u0099\u0097\3\2\2\2\u0099\u0098"+
		"\3\2\2\2\u009a\37\3\2\2\2\u009b\u009d\5(\25\2\u009c\u009b\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\7\61\2\2\u009f!\3\2\2\2"+
		"\u00a0\u00a1\7\b\2\2\u00a1\u00a2\7+\2\2\u00a2\u00a3\5(\25\2\u00a3\u00a4"+
		"\7,\2\2\u00a4\u00a7\5\32\16\2\u00a5\u00a6\7\3\2\2\u00a6\u00a8\5\32\16"+
		"\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8#\3\2\2\2\u00a9\u00aa"+
		"\7\n\2\2\u00aa\u00ab\7+\2\2\u00ab\u00ac\5(\25\2\u00ac\u00ad\7,\2\2\u00ad"+
		"\u00ae\5\32\16\2\u00ae\u00bf\3\2\2\2\u00af\u00b0\7\t\2\2\u00b0\u00b2\7"+
		"+\2\2\u00b1\u00b3\5(\25\2\u00b2\u00b1\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\u00b4\3\2\2\2\u00b4\u00b6\7\61\2\2\u00b5\u00b7\5(\25\2\u00b6\u00b5\3"+
		"\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00ba\7\61\2\2\u00b9"+
		"\u00bb\5(\25\2\u00ba\u00b9\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\3\2"+
		"\2\2\u00bc\u00bd\7,\2\2\u00bd\u00bf\5\32\16\2\u00be\u00a9\3\2\2\2\u00be"+
		"\u00af\3\2\2\2\u00bf%\3\2\2\2\u00c0\u00c1\7\f\2\2\u00c1\u00ca\7\61\2\2"+
		"\u00c2\u00c3\7\13\2\2\u00c3\u00ca\7\61\2\2\u00c4\u00c6\7\r\2\2\u00c5\u00c7"+
		"\5(\25\2\u00c6\u00c5\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8"+
		"\u00ca\7\61\2\2\u00c9\u00c0\3\2\2\2\u00c9\u00c2\3\2\2\2\u00c9\u00c4\3"+
		"\2\2\2\u00ca\'\3\2\2\2\u00cb\u00cc\b\25\1\2\u00cc\u00cd\t\2\2\2\u00cd"+
		"\u00de\5(\25\26\u00ce\u00cf\t\3\2\2\u00cf\u00de\5(\25\25\u00d0\u00d1\7"+
		"\36\2\2\u00d1\u00de\5(\25\24\u00d2\u00d3\7!\2\2\u00d3\u00de\5(\25\23\u00d4"+
		"\u00d5\7\16\2\2\u00d5\u00de\5,\27\2\u00d6\u00de\7\67\2\2\u00d7\u00de\7"+
		"\20\2\2\u00d8\u00de\5.\30\2\u00d9\u00da\7+\2\2\u00da\u00db\5(\25\2\u00db"+
		"\u00dc\7,\2\2\u00dc\u00de\3\2\2\2\u00dd\u00cb\3\2\2\2\u00dd\u00ce\3\2"+
		"\2\2\u00dd\u00d0\3\2\2\2\u00dd\u00d2\3\2\2\2\u00dd\u00d4\3\2\2\2\u00dd"+
		"\u00d6\3\2\2\2\u00dd\u00d7\3\2\2\2\u00dd\u00d8\3\2\2\2\u00dd\u00d9\3\2"+
		"\2\2\u00de\u0112\3\2\2\2\u00df\u00e0\f\21\2\2\u00e0\u00e1\t\4\2\2\u00e1"+
		"\u0111\5(\25\22\u00e2\u00e3\f\20\2\2\u00e3\u00e4\t\3\2\2\u00e4\u0111\5"+
		"(\25\21\u00e5\u00e6\f\17\2\2\u00e6\u00e7\t\5\2\2\u00e7\u0111\5(\25\20"+
		"\u00e8\u00e9\f\16\2\2\u00e9\u00ea\t\6\2\2\u00ea\u0111\5(\25\17\u00eb\u00ec"+
		"\f\r\2\2\u00ec\u00ed\t\7\2\2\u00ed\u0111\5(\25\16\u00ee\u00ef\f\f\2\2"+
		"\u00ef\u00f0\7$\2\2\u00f0\u0111\5(\25\r\u00f1\u00f2\f\13\2\2\u00f2\u00f3"+
		"\7#\2\2\u00f3\u0111\5(\25\f\u00f4\u00f5\f\n\2\2\u00f5\u00f6\7\"\2\2\u00f6"+
		"\u0111\5(\25\13\u00f7\u00f8\f\t\2\2\u00f8\u00f9\7\34\2\2\u00f9\u0111\5"+
		"(\25\n\u00fa\u00fb\f\b\2\2\u00fb\u00fc\7\35\2\2\u00fc\u0111\5(\25\t\u00fd"+
		"\u00fe\f\7\2\2\u00fe\u00ff\7%\2\2\u00ff\u0111\5(\25\7\u0100\u0101\f\32"+
		"\2\2\u0101\u0102\7)\2\2\u0102\u0103\5(\25\2\u0103\u0104\7*\2\2\u0104\u0111"+
		"\3\2\2\2\u0105\u0106\f\31\2\2\u0106\u0108\7+\2\2\u0107\u0109\5*\26\2\u0108"+
		"\u0107\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u0111\7,"+
		"\2\2\u010b\u010c\f\30\2\2\u010c\u010d\7(\2\2\u010d\u0111\7\67\2\2\u010e"+
		"\u010f\f\27\2\2\u010f\u0111\t\2\2\2\u0110\u00df\3\2\2\2\u0110\u00e2\3"+
		"\2\2\2\u0110\u00e5\3\2\2\2\u0110\u00e8\3\2\2\2\u0110\u00eb\3\2\2\2\u0110"+
		"\u00ee\3\2\2\2\u0110\u00f1\3\2\2\2\u0110\u00f4\3\2\2\2\u0110\u00f7\3\2"+
		"\2\2\u0110\u00fa\3\2\2\2\u0110\u00fd\3\2\2\2\u0110\u0100\3\2\2\2\u0110"+
		"\u0105\3\2\2\2\u0110\u010b\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u0114\3\2"+
		"\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113)\3\2\2\2\u0114\u0112"+
		"\3\2\2\2\u0115\u011a\5(\25\2\u0116\u0117\7\62\2\2\u0117\u0119\5(\25\2"+
		"\u0118\u0116\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011a\u011b"+
		"\3\2\2\2\u011b+\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u0122\5\30\r\2\u011e"+
		"\u011f\7)\2\2\u011f\u0120\5(\25\2\u0120\u0121\7*\2\2\u0121\u0123\3\2\2"+
		"\2\u0122\u011e\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125"+
		"\3\2\2\2\u0125\u0128\3\2\2\2\u0126\u0127\7)\2\2\u0127\u0129\7*\2\2\u0128"+
		"\u0126\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2"+
		"\2\2\u012b\u0130\3\2\2\2\u012c\u012d\7)\2\2\u012d\u012e\5(\25\2\u012e"+
		"\u012f\7*\2\2\u012f\u0131\3\2\2\2\u0130\u012c\3\2\2\2\u0131\u0132\3\2"+
		"\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0146\3\2\2\2\u0134"+
		"\u0139\5\30\r\2\u0135\u0136\7)\2\2\u0136\u0137\5(\25\2\u0137\u0138\7*"+
		"\2\2\u0138\u013a\3\2\2\2\u0139\u0135\3\2\2\2\u013a\u013b\3\2\2\2\u013b"+
		"\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u0141\3\2\2\2\u013d\u013e\7)"+
		"\2\2\u013e\u0140\7*\2\2\u013f\u013d\3\2\2\2\u0140\u0143\3\2\2\2\u0141"+
		"\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0146\3\2\2\2\u0143\u0141\3\2"+
		"\2\2\u0144\u0146\5\30\r\2\u0145\u011d\3\2\2\2\u0145\u0134\3\2\2\2\u0145"+
		"\u0144\3\2\2\2\u0146-\3\2\2\2\u0147\u014c\7\66\2\2\u0148\u014c\7\63\2"+
		"\2\u0149\u014c\7\64\2\2\u014a\u014c\7\65\2\2\u014b\u0147\3\2\2\2\u014b"+
		"\u0148\3\2\2\2\u014b\u0149\3\2\2\2\u014b\u014a\3\2\2\2\u014c/\3\2\2\2"+
		"%\63;>CJQ]dlt~\u0085\u008c\u0092\u0099\u009c\u00a7\u00b2\u00b6\u00ba\u00be"+
		"\u00c6\u00c9\u00dd\u0108\u0110\u0112\u011a\u0124\u012a\u0132\u013b\u0141"+
		"\u0145\u014b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}