// Generated from c:\Users\echo\Desktop\Mcompiler\src\com\echo\compiler\parser\m.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class mParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

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
		Identifier=49, IntegerConstant=50, CharacterConstant=51, StringLiteral=52, 
		NullLiteral=53, LogicalConstant=54, Whitespace=55, Newline=56, BlockComment=57, 
		LineComment=58;
	public static final int
		RULE_program = 0, RULE_programBody = 1, RULE_functionDeclare = 2, RULE_formalParameters = 3, 
		RULE_formalParameter = 4, RULE_classDeclare = 5, RULE_classBody = 6, RULE_variableDeclare = 7, 
		RULE_variableDeclarator = 8, RULE_typeSpecifier = 9, RULE_nonArrayTypeSpecifier = 10, 
		RULE_stat = 11, RULE_blockStat = 12, RULE_blockItemList = 13, RULE_expressionStat = 14, 
		RULE_ifStat = 15, RULE_iterationStat = 16, RULE_jumpStat = 17, RULE_expr = 18, 
		RULE_exprs = 19, RULE_creator = 20, RULE_constant = 21;
	public static final String[] ruleNames = {
		"program", "programBody", "functionDeclare", "formalParameters", "formalParameter", 
		"classDeclare", "classBody", "variableDeclare", "variableDeclarator", 
		"typeSpecifier", "nonArrayTypeSpecifier", "stat", "blockStat", "blockItemList", 
		"expressionStat", "ifStat", "iterationStat", "jumpStat", "expr", "exprs", 
		"creator", "constant"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'else'", "'bool'", "'int'", "'string'", "'void'", "'if'", "'for'", 
		"'while'", "'break'", "'continue'", "'return'", "'new'", "'class'", "'this'", 
		"'+'", "'-'", "'*'", "'/'", "'%'", "'<'", "'>'", "'=='", "'!='", "'<='", 
		"'>='", "'&&'", "'||'", "'!'", "'<<'", "'>>'", "'~'", "'|'", "'^'", "'&'", 
		"'='", "'++'", "'--'", "'.'", "'['", "']'", "'('", "')'", "'{'", "'}'", 
		"'?'", "':'", "';'", "','", null, null, null, null, "'null'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "Bool", "Int", "String", "Void", "If", "For", "While", "Break", 
		"Continue", "Return", "New", "Class", "This", "Plus", "Minus", "Star", 
		"Div", "Mod", "Less", "Greater", "Equal", "NotEqual", "LessEqual", "GreaterEqual", 
		"AndAnd", "OrOr", "Not", "LeftShift", "RightShift", "Tilde", "Or", "Caret", 
		"And", "Assign", "PlusPlus", "MinusMinus", "Dot", "LeftBracket", "RightBracket", 
		"LeftParen", "RightParen", "LeftBrace", "RightBrace", "Question", "Colon", 
		"Semi", "Comma", "Identifier", "IntegerConstant", "CharacterConstant", 
		"StringLiteral", "NullLiteral", "LogicalConstant", "Whitespace", "Newline", 
		"BlockComment", "LineComment"
	};
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
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << Class) | (1L << Identifier))) != 0)) {
				{
				{
				setState(44);
				programBody();
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
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
		public ProgramBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programBody; }
	 
		public ProgramBodyContext() { }
		public void copyFrom(ProgramBodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunctionContext extends ProgramBodyContext {
		public FunctionDeclareContext functionDeclare() {
			return getRuleContext(FunctionDeclareContext.class,0);
		}
		public FunctionContext(ProgramBodyContext ctx) { copyFrom(ctx); }
	}
	public static class VariableContext extends ProgramBodyContext {
		public VariableDeclareContext variableDeclare() {
			return getRuleContext(VariableDeclareContext.class,0);
		}
		public VariableContext(ProgramBodyContext ctx) { copyFrom(ctx); }
	}
	public static class ClassContext extends ProgramBodyContext {
		public ClassDeclareContext classDeclare() {
			return getRuleContext(ClassDeclareContext.class,0);
		}
		public ClassContext(ProgramBodyContext ctx) { copyFrom(ctx); }
	}

	public final ProgramBodyContext programBody() throws RecognitionException {
		ProgramBodyContext _localctx = new ProgramBodyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_programBody);
		try {
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new FunctionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				functionDeclare();
				}
				break;
			case 2:
				_localctx = new ClassContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				classDeclare();
				}
				break;
			case 3:
				_localctx = new VariableContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(54);
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
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(mParser.Identifier, 0); }
		public BlockStatContext blockStat() {
			return getRuleContext(BlockStatContext.class,0);
		}
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public FunctionDeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclare; }
	}

	public final FunctionDeclareContext functionDeclare() throws RecognitionException {
		FunctionDeclareContext _localctx = new FunctionDeclareContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionDeclare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			typeSpecifier(0);
			setState(58);
			match(Identifier);
			setState(59);
			match(LeftParen);
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << Identifier))) != 0)) {
				{
				setState(60);
				formalParameters();
				}
			}

			setState(63);
			match(RightParen);
			setState(64);
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

	public static class FormalParametersContext extends ParserRuleContext {
		public List<FormalParameterContext> formalParameter() {
			return getRuleContexts(FormalParameterContext.class);
		}
		public FormalParameterContext formalParameter(int i) {
			return getRuleContext(FormalParameterContext.class,i);
		}
		public FormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_formalParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			formalParameter();
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(67);
				match(Comma);
				setState(68);
				formalParameter();
				}
				}
				setState(73);
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
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_formalParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			typeSpecifier(0);
			setState(75);
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
		public TerminalNode Identifier() { return getToken(mParser.Identifier, 0); }
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
	}

	public final ClassDeclareContext classDeclare() throws RecognitionException {
		ClassDeclareContext _localctx = new ClassDeclareContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_classDeclare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(Class);
			setState(78);
			match(Identifier);
			setState(79);
			match(LeftBrace);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << Identifier))) != 0)) {
				{
				{
				setState(80);
				classBody();
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(86);
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
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_classBody);
		try {
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				functionDeclare();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
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
		public VariableDeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclare; }
	}

	public final VariableDeclareContext variableDeclare() throws RecognitionException {
		VariableDeclareContext _localctx = new VariableDeclareContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_variableDeclare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			typeSpecifier(0);
			setState(93);
			variableDeclarator();
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(94);
				match(Comma);
				setState(95);
				variableDeclarator();
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(101);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VariableDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarator; }
	}

	public final VariableDeclaratorContext variableDeclarator() throws RecognitionException {
		VariableDeclaratorContext _localctx = new VariableDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_variableDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(Identifier);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(104);
				match(Assign);
				setState(105);
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
		public TypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpecifier; }
	}

	public final TypeSpecifierContext typeSpecifier() throws RecognitionException {
		return typeSpecifier(0);
	}

	private TypeSpecifierContext typeSpecifier(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeSpecifierContext _localctx = new TypeSpecifierContext(_ctx, _parentState);
		TypeSpecifierContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_typeSpecifier, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(109);
			nonArrayTypeSpecifier();
			}
			_ctx.stop = _input.LT(-1);
			setState(116);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeSpecifierContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_typeSpecifier);
					setState(111);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(112);
					match(LeftBracket);
					setState(113);
					match(RightBracket);
					}
					} 
				}
				setState(118);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
		public TerminalNode Identifier() { return getToken(mParser.Identifier, 0); }
		public NonArrayTypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonArrayTypeSpecifier; }
	}

	public final NonArrayTypeSpecifierContext nonArrayTypeSpecifier() throws RecognitionException {
		NonArrayTypeSpecifierContext _localctx = new NonArrayTypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_nonArrayTypeSpecifier);
		try {
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Bool:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				((NonArrayTypeSpecifierContext)_localctx).type = match(Bool);
				}
				break;
			case Int:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				((NonArrayTypeSpecifierContext)_localctx).type = match(Int);
				}
				break;
			case String:
				enterOuterAlt(_localctx, 3);
				{
				setState(121);
				((NonArrayTypeSpecifierContext)_localctx).type = match(String);
				}
				break;
			case Void:
				enterOuterAlt(_localctx, 4);
				{
				setState(122);
				((NonArrayTypeSpecifierContext)_localctx).type = match(Void);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 5);
				{
				setState(123);
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
	}
	public static class IterContext extends StatContext {
		public IterationStatContext iterationStat() {
			return getRuleContext(IterationStatContext.class,0);
		}
		public IterContext(StatContext ctx) { copyFrom(ctx); }
	}
	public static class BlockContext extends StatContext {
		public BlockStatContext blockStat() {
			return getRuleContext(BlockStatContext.class,0);
		}
		public BlockContext(StatContext ctx) { copyFrom(ctx); }
	}
	public static class IfContext extends StatContext {
		public IfStatContext ifStat() {
			return getRuleContext(IfStatContext.class,0);
		}
		public IfContext(StatContext ctx) { copyFrom(ctx); }
	}
	public static class JumpContext extends StatContext {
		public JumpStatContext jumpStat() {
			return getRuleContext(JumpStatContext.class,0);
		}
		public JumpContext(StatContext ctx) { copyFrom(ctx); }
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_stat);
		try {
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftBrace:
				_localctx = new BlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				blockStat();
				}
				break;
			case New:
			case Plus:
			case Minus:
			case Not:
			case Tilde:
			case PlusPlus:
			case MinusMinus:
			case LeftParen:
			case Semi:
			case Identifier:
			case IntegerConstant:
			case CharacterConstant:
			case StringLiteral:
			case NullLiteral:
			case LogicalConstant:
				_localctx = new ExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				expressionStat();
				}
				break;
			case If:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(128);
				ifStat();
				}
				break;
			case For:
			case While:
				_localctx = new IterContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(129);
				iterationStat();
				}
				break;
			case Break:
			case Continue:
			case Return:
				_localctx = new JumpContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(130);
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
	}

	public final BlockStatContext blockStat() throws RecognitionException {
		BlockStatContext _localctx = new BlockStatContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_blockStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(LeftBrace);
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << New) | (1L << Plus) | (1L << Minus) | (1L << Not) | (1L << Tilde) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << LeftParen) | (1L << LeftBrace) | (1L << Semi) | (1L << Identifier) | (1L << IntegerConstant) | (1L << CharacterConstant) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LogicalConstant))) != 0)) {
				{
				{
				setState(134);
				blockItemList();
				}
				}
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(140);
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
	}
	public static class VariableDecContext extends BlockItemListContext {
		public VariableDeclareContext variableDeclare() {
			return getRuleContext(VariableDeclareContext.class,0);
		}
		public VariableDecContext(BlockItemListContext ctx) { copyFrom(ctx); }
	}

	public final BlockItemListContext blockItemList() throws RecognitionException {
		BlockItemListContext _localctx = new BlockItemListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_blockItemList);
		try {
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new StatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				stat();
				}
				break;
			case 2:
				_localctx = new VariableDecContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExpressionStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStat; }
	}

	public final ExpressionStatContext expressionStat() throws RecognitionException {
		ExpressionStatContext _localctx = new ExpressionStatContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expressionStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Plus) | (1L << Minus) | (1L << Not) | (1L << Tilde) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << LeftParen) | (1L << Identifier) | (1L << IntegerConstant) | (1L << CharacterConstant) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LogicalConstant))) != 0)) {
				{
				setState(146);
				expr(0);
				}
			}

			setState(149);
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
	}

	public final IfStatContext ifStat() throws RecognitionException {
		IfStatContext _localctx = new IfStatContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ifStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(If);
			setState(152);
			((IfStatContext)_localctx).cond = expr(0);
			setState(153);
			((IfStatContext)_localctx).thenbody = stat();
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(154);
				match(T__0);
				setState(155);
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
		public VariableDeclareContext declinit;
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public VariableDeclareContext variableDeclare() {
			return getRuleContext(VariableDeclareContext.class,0);
		}
		public ForContext(IterationStatContext ctx) { copyFrom(ctx); }
	}
	public static class WhileContext extends IterationStatContext {
		public ExprContext cond;
		public StatContext whilebody;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public WhileContext(IterationStatContext ctx) { copyFrom(ctx); }
	}

	public final IterationStatContext iterationStat() throws RecognitionException {
		IterationStatContext _localctx = new IterationStatContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_iterationStat);
		int _la;
		try {
			setState(192);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				match(While);
				setState(159);
				match(LeftParen);
				setState(160);
				((WhileContext)_localctx).cond = expr(0);
				setState(161);
				match(RightParen);
				setState(162);
				((WhileContext)_localctx).whilebody = stat();
				}
				break;
			case 2:
				_localctx = new ForContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				match(For);
				setState(165);
				match(LeftParen);
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Plus) | (1L << Minus) | (1L << Not) | (1L << Tilde) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << LeftParen) | (1L << Identifier) | (1L << IntegerConstant) | (1L << CharacterConstant) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LogicalConstant))) != 0)) {
					{
					setState(166);
					((ForContext)_localctx).init = expr(0);
					}
				}

				setState(169);
				match(Semi);
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Plus) | (1L << Minus) | (1L << Not) | (1L << Tilde) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << LeftParen) | (1L << Identifier) | (1L << IntegerConstant) | (1L << CharacterConstant) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LogicalConstant))) != 0)) {
					{
					setState(170);
					((ForContext)_localctx).cond = expr(0);
					}
				}

				setState(173);
				match(Semi);
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Plus) | (1L << Minus) | (1L << Not) | (1L << Tilde) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << LeftParen) | (1L << Identifier) | (1L << IntegerConstant) | (1L << CharacterConstant) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LogicalConstant))) != 0)) {
					{
					setState(174);
					((ForContext)_localctx).step = expr(0);
					}
				}

				setState(177);
				match(RightParen);
				setState(178);
				((ForContext)_localctx).forbody = stat();
				}
				break;
			case 3:
				_localctx = new ForContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(179);
				match(For);
				setState(180);
				match(LeftParen);
				setState(181);
				((ForContext)_localctx).declinit = variableDeclare();
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Plus) | (1L << Minus) | (1L << Not) | (1L << Tilde) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << LeftParen) | (1L << Identifier) | (1L << IntegerConstant) | (1L << CharacterConstant) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LogicalConstant))) != 0)) {
					{
					setState(182);
					((ForContext)_localctx).cond = expr(0);
					}
				}

				setState(185);
				match(Semi);
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Plus) | (1L << Minus) | (1L << Not) | (1L << Tilde) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << LeftParen) | (1L << Identifier) | (1L << IntegerConstant) | (1L << CharacterConstant) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LogicalConstant))) != 0)) {
					{
					setState(186);
					((ForContext)_localctx).step = expr(0);
					}
				}

				setState(189);
				match(RightParen);
				setState(190);
				((ForContext)_localctx).forbody = stat();
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
		public BreakContext(JumpStatContext ctx) { copyFrom(ctx); }
	}
	public static class ContinueContext extends JumpStatContext {
		public ContinueContext(JumpStatContext ctx) { copyFrom(ctx); }
	}
	public static class ReturnContext extends JumpStatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnContext(JumpStatContext ctx) { copyFrom(ctx); }
	}

	public final JumpStatContext jumpStat() throws RecognitionException {
		JumpStatContext _localctx = new JumpStatContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_jumpStat);
		int _la;
		try {
			setState(203);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Continue:
				_localctx = new ContinueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				match(Continue);
				setState(195);
				match(Semi);
				}
				break;
			case Break:
				_localctx = new BreakContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				match(Break);
				setState(197);
				match(Semi);
				}
				break;
			case Return:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(198);
				match(Return);
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Plus) | (1L << Minus) | (1L << Not) | (1L << Tilde) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << LeftParen) | (1L << Identifier) | (1L << IntegerConstant) | (1L << CharacterConstant) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LogicalConstant))) != 0)) {
					{
					setState(199);
					expr(0);
					}
				}

				setState(202);
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
		public CreatorContext creator() {
			return getRuleContext(CreatorContext.class,0);
		}
		public NewExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class PrefixExprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrefixExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class SubscriptExprContext extends ExprContext {
		public ExprContext array;
		public ExprContext sub;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SubscriptExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class FunccallExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprsContext exprs() {
			return getRuleContext(ExprsContext.class,0);
		}
		public FunccallExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class MemAccessExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(mParser.Identifier, 0); }
		public MemAccessExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class SuffixExprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SuffixExprContext(ExprContext ctx) { copyFrom(ctx); }
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
		public BinaryExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class SubExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SubExprContext(ExprContext ctx) { copyFrom(ctx); }
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
		public AssignExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class IdentifierExprContext extends ExprContext {
		public TerminalNode Identifier() { return getToken(mParser.Identifier, 0); }
		public IdentifierExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ConstantExprContext extends ExprContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ConstantExprContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PlusPlus:
			case MinusMinus:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(206);
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
				setState(207);
				expr(19);
				}
				break;
			case Plus:
			case Minus:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(208);
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
				setState(209);
				expr(18);
				}
				break;
			case Not:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(210);
				((PrefixExprContext)_localctx).op = match(Not);
				setState(211);
				expr(17);
				}
				break;
			case Tilde:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(212);
				((PrefixExprContext)_localctx).op = match(Tilde);
				setState(213);
				expr(16);
				}
				break;
			case New:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(214);
				match(New);
				setState(215);
				creator();
				}
				break;
			case Identifier:
				{
				_localctx = new IdentifierExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(216);
				match(Identifier);
				}
				break;
			case IntegerConstant:
			case CharacterConstant:
			case StringLiteral:
			case NullLiteral:
			case LogicalConstant:
				{
				_localctx = new ConstantExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(217);
				constant();
				}
				break;
			case LeftParen:
				{
				_localctx = new SubExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(218);
				match(LeftParen);
				setState(219);
				expr(0);
				setState(220);
				match(RightParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(275);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(273);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(224);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(225);
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
						setState(226);
						((BinaryExprContext)_localctx).rhs = expr(15);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(227);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(228);
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
						setState(229);
						((BinaryExprContext)_localctx).rhs = expr(14);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(230);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(231);
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
						setState(232);
						((BinaryExprContext)_localctx).rhs = expr(13);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(233);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(234);
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
						setState(235);
						((BinaryExprContext)_localctx).rhs = expr(12);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(236);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(237);
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
						setState(238);
						((BinaryExprContext)_localctx).rhs = expr(11);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(239);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(240);
						((BinaryExprContext)_localctx).op = match(And);
						setState(241);
						((BinaryExprContext)_localctx).rhs = expr(10);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(242);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(243);
						((BinaryExprContext)_localctx).op = match(Caret);
						setState(244);
						((BinaryExprContext)_localctx).rhs = expr(9);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(245);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(246);
						((BinaryExprContext)_localctx).op = match(Or);
						setState(247);
						((BinaryExprContext)_localctx).rhs = expr(8);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(248);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(249);
						((BinaryExprContext)_localctx).op = match(AndAnd);
						setState(250);
						((BinaryExprContext)_localctx).rhs = expr(7);
						}
						break;
					case 10:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(251);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(252);
						((BinaryExprContext)_localctx).op = match(OrOr);
						setState(253);
						((BinaryExprContext)_localctx).rhs = expr(6);
						}
						break;
					case 11:
						{
						_localctx = new AssignExprContext(new ExprContext(_parentctx, _parentState));
						((AssignExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(254);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(255);
						((AssignExprContext)_localctx).op = match(Assign);
						setState(256);
						((AssignExprContext)_localctx).rhs = expr(4);
						}
						break;
					case 12:
						{
						_localctx = new SubscriptExprContext(new ExprContext(_parentctx, _parentState));
						((SubscriptExprContext)_localctx).array = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(257);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(258);
						match(LeftBracket);
						setState(259);
						((SubscriptExprContext)_localctx).sub = expr(0);
						setState(260);
						match(RightBracket);
						}
						break;
					case 13:
						{
						_localctx = new FunccallExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(262);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(263);
						match(LeftParen);
						setState(265);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << New) | (1L << Plus) | (1L << Minus) | (1L << Not) | (1L << Tilde) | (1L << PlusPlus) | (1L << MinusMinus) | (1L << LeftParen) | (1L << Identifier) | (1L << IntegerConstant) | (1L << CharacterConstant) | (1L << StringLiteral) | (1L << NullLiteral) | (1L << LogicalConstant))) != 0)) {
							{
							setState(264);
							exprs();
							}
						}

						setState(267);
						match(RightParen);
						}
						break;
					case 14:
						{
						_localctx = new MemAccessExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(268);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(269);
						match(Dot);
						setState(270);
						match(Identifier);
						}
						break;
					case 15:
						{
						_localctx = new SuffixExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(271);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(272);
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
				setState(277);
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
		public ExprsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprs; }
	}

	public final ExprsContext exprs() throws RecognitionException {
		ExprsContext _localctx = new ExprsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_exprs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			expr(0);
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(279);
				match(Comma);
				setState(280);
				expr(0);
				}
				}
				setState(285);
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
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CreatorErrorContext(CreatorContext ctx) { copyFrom(ctx); }
	}
	public static class CreatorNonArrayContext extends CreatorContext {
		public NonArrayTypeSpecifierContext nonArrayTypeSpecifier() {
			return getRuleContext(NonArrayTypeSpecifierContext.class,0);
		}
		public CreatorNonArrayContext(CreatorContext ctx) { copyFrom(ctx); }
	}
	public static class CreatorArrayContext extends CreatorContext {
		public NonArrayTypeSpecifierContext nonArrayTypeSpecifier() {
			return getRuleContext(NonArrayTypeSpecifierContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CreatorArrayContext(CreatorContext ctx) { copyFrom(ctx); }
	}

	public final CreatorContext creator() throws RecognitionException {
		CreatorContext _localctx = new CreatorContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_creator);
		try {
			int _alt;
			setState(326);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				_localctx = new CreatorErrorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(286);
				nonArrayTypeSpecifier();
				setState(291); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(287);
						match(LeftBracket);
						setState(288);
						expr(0);
						setState(289);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(293); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(297); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(295);
						match(LeftBracket);
						setState(296);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(299); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(305); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(301);
						match(LeftBracket);
						setState(302);
						expr(0);
						setState(303);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(307); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				_localctx = new CreatorArrayContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(309);
				nonArrayTypeSpecifier();
				setState(314); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(310);
						match(LeftBracket);
						setState(311);
						expr(0);
						setState(312);
						match(RightBracket);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(316); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(322);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(318);
						match(LeftBracket);
						setState(319);
						match(RightBracket);
						}
						} 
					}
					setState(324);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				}
				}
				break;
			case 3:
				_localctx = new CreatorNonArrayContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(325);
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
		public TerminalNode CharacterConstant() { return getToken(mParser.CharacterConstant, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_constant);
		try {
			setState(333);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LogicalConstant:
				enterOuterAlt(_localctx, 1);
				{
				setState(328);
				((ConstantContext)_localctx).type = match(LogicalConstant);
				}
				break;
			case IntegerConstant:
				enterOuterAlt(_localctx, 2);
				{
				setState(329);
				((ConstantContext)_localctx).type = match(IntegerConstant);
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(330);
				((ConstantContext)_localctx).type = match(StringLiteral);
				}
				break;
			case NullLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(331);
				((ConstantContext)_localctx).type = match(NullLiteral);
				}
				break;
			case CharacterConstant:
				enterOuterAlt(_localctx, 5);
				{
				setState(332);
				((ConstantContext)_localctx).type = match(CharacterConstant);
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
		case 9:
			return typeSpecifier_sempred((TypeSpecifierContext)_localctx, predIndex);
		case 18:
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
			return precpred(_ctx, 14);
		case 2:
			return precpred(_ctx, 13);
		case 3:
			return precpred(_ctx, 12);
		case 4:
			return precpred(_ctx, 11);
		case 5:
			return precpred(_ctx, 10);
		case 6:
			return precpred(_ctx, 9);
		case 7:
			return precpred(_ctx, 8);
		case 8:
			return precpred(_ctx, 7);
		case 9:
			return precpred(_ctx, 6);
		case 10:
			return precpred(_ctx, 5);
		case 11:
			return precpred(_ctx, 4);
		case 12:
			return precpred(_ctx, 23);
		case 13:
			return precpred(_ctx, 22);
		case 14:
			return precpred(_ctx, 21);
		case 15:
			return precpred(_ctx, 20);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3<\u0152\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\7\2\60\n\2\f\2"+
		"\16\2\63\13\2\3\2\3\2\3\3\3\3\3\3\5\3:\n\3\3\4\3\4\3\4\3\4\5\4@\n\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\7\5H\n\5\f\5\16\5K\13\5\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\7\7T\n\7\f\7\16\7W\13\7\3\7\3\7\3\b\3\b\5\b]\n\b\3\t\3\t\3\t\3\t"+
		"\7\tc\n\t\f\t\16\tf\13\t\3\t\3\t\3\n\3\n\3\n\5\nm\n\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\7\13u\n\13\f\13\16\13x\13\13\3\f\3\f\3\f\3\f\3\f\5\f\177"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\5\r\u0086\n\r\3\16\3\16\7\16\u008a\n\16\f\16"+
		"\16\16\u008d\13\16\3\16\3\16\3\17\3\17\5\17\u0093\n\17\3\20\5\20\u0096"+
		"\n\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\5\21\u009f\n\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00aa\n\22\3\22\3\22\5\22\u00ae\n"+
		"\22\3\22\3\22\5\22\u00b2\n\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00ba"+
		"\n\22\3\22\3\22\5\22\u00be\n\22\3\22\3\22\3\22\5\22\u00c3\n\22\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\5\23\u00cb\n\23\3\23\5\23\u00ce\n\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\5\24\u00e1\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u010c\n\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u0114"+
		"\n\24\f\24\16\24\u0117\13\24\3\25\3\25\3\25\7\25\u011c\n\25\f\25\16\25"+
		"\u011f\13\25\3\26\3\26\3\26\3\26\3\26\6\26\u0126\n\26\r\26\16\26\u0127"+
		"\3\26\3\26\6\26\u012c\n\26\r\26\16\26\u012d\3\26\3\26\3\26\3\26\6\26\u0134"+
		"\n\26\r\26\16\26\u0135\3\26\3\26\3\26\3\26\3\26\6\26\u013d\n\26\r\26\16"+
		"\26\u013e\3\26\3\26\7\26\u0143\n\26\f\26\16\26\u0146\13\26\3\26\5\26\u0149"+
		"\n\26\3\27\3\27\3\27\3\27\3\27\5\27\u0150\n\27\3\27\2\4\24&\30\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\b\3\2&\'\3\2\21\22\3\2\23\25"+
		"\3\2\37 \4\2\26\27\32\33\3\2\30\31\2\u017e\2\61\3\2\2\2\49\3\2\2\2\6;"+
		"\3\2\2\2\bD\3\2\2\2\nL\3\2\2\2\fO\3\2\2\2\16\\\3\2\2\2\20^\3\2\2\2\22"+
		"i\3\2\2\2\24n\3\2\2\2\26~\3\2\2\2\30\u0085\3\2\2\2\32\u0087\3\2\2\2\34"+
		"\u0092\3\2\2\2\36\u0095\3\2\2\2 \u0099\3\2\2\2\"\u00c2\3\2\2\2$\u00cd"+
		"\3\2\2\2&\u00e0\3\2\2\2(\u0118\3\2\2\2*\u0148\3\2\2\2,\u014f\3\2\2\2."+
		"\60\5\4\3\2/.\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\64\3"+
		"\2\2\2\63\61\3\2\2\2\64\65\7\2\2\3\65\3\3\2\2\2\66:\5\6\4\2\67:\5\f\7"+
		"\28:\5\20\t\29\66\3\2\2\29\67\3\2\2\298\3\2\2\2:\5\3\2\2\2;<\5\24\13\2"+
		"<=\7\63\2\2=?\7+\2\2>@\5\b\5\2?>\3\2\2\2?@\3\2\2\2@A\3\2\2\2AB\7,\2\2"+
		"BC\5\32\16\2C\7\3\2\2\2DI\5\n\6\2EF\7\62\2\2FH\5\n\6\2GE\3\2\2\2HK\3\2"+
		"\2\2IG\3\2\2\2IJ\3\2\2\2J\t\3\2\2\2KI\3\2\2\2LM\5\24\13\2MN\7\63\2\2N"+
		"\13\3\2\2\2OP\7\17\2\2PQ\7\63\2\2QU\7-\2\2RT\5\16\b\2SR\3\2\2\2TW\3\2"+
		"\2\2US\3\2\2\2UV\3\2\2\2VX\3\2\2\2WU\3\2\2\2XY\7.\2\2Y\r\3\2\2\2Z]\5\6"+
		"\4\2[]\5\20\t\2\\Z\3\2\2\2\\[\3\2\2\2]\17\3\2\2\2^_\5\24\13\2_d\5\22\n"+
		"\2`a\7\62\2\2ac\5\22\n\2b`\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2eg\3\2"+
		"\2\2fd\3\2\2\2gh\7\61\2\2h\21\3\2\2\2il\7\63\2\2jk\7%\2\2km\5&\24\2lj"+
		"\3\2\2\2lm\3\2\2\2m\23\3\2\2\2no\b\13\1\2op\5\26\f\2pv\3\2\2\2qr\f\4\2"+
		"\2rs\7)\2\2su\7*\2\2tq\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2w\25\3\2\2"+
		"\2xv\3\2\2\2y\177\7\4\2\2z\177\7\5\2\2{\177\7\6\2\2|\177\7\7\2\2}\177"+
		"\7\63\2\2~y\3\2\2\2~z\3\2\2\2~{\3\2\2\2~|\3\2\2\2~}\3\2\2\2\177\27\3\2"+
		"\2\2\u0080\u0086\5\32\16\2\u0081\u0086\5\36\20\2\u0082\u0086\5 \21\2\u0083"+
		"\u0086\5\"\22\2\u0084\u0086\5$\23\2\u0085\u0080\3\2\2\2\u0085\u0081\3"+
		"\2\2\2\u0085\u0082\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0084\3\2\2\2\u0086"+
		"\31\3\2\2\2\u0087\u008b\7-\2\2\u0088\u008a\5\34\17\2\u0089\u0088\3\2\2"+
		"\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e"+
		"\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u008f\7.\2\2\u008f\33\3\2\2\2\u0090"+
		"\u0093\5\30\r\2\u0091\u0093\5\20\t\2\u0092\u0090\3\2\2\2\u0092\u0091\3"+
		"\2\2\2\u0093\35\3\2\2\2\u0094\u0096\5&\24\2\u0095\u0094\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\7\61\2\2\u0098\37\3\2\2"+
		"\2\u0099\u009a\7\b\2\2\u009a\u009b\5&\24\2\u009b\u009e\5\30\r\2\u009c"+
		"\u009d\7\3\2\2\u009d\u009f\5\30\r\2\u009e\u009c\3\2\2\2\u009e\u009f\3"+
		"\2\2\2\u009f!\3\2\2\2\u00a0\u00a1\7\n\2\2\u00a1\u00a2\7+\2\2\u00a2\u00a3"+
		"\5&\24\2\u00a3\u00a4\7,\2\2\u00a4\u00a5\5\30\r\2\u00a5\u00c3\3\2\2\2\u00a6"+
		"\u00a7\7\t\2\2\u00a7\u00a9\7+\2\2\u00a8\u00aa\5&\24\2\u00a9\u00a8\3\2"+
		"\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ad\7\61\2\2\u00ac"+
		"\u00ae\5&\24\2\u00ad\u00ac\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2"+
		"\2\2\u00af\u00b1\7\61\2\2\u00b0\u00b2\5&\24\2\u00b1\u00b0\3\2\2\2\u00b1"+
		"\u00b2\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\7,\2\2\u00b4\u00c3\5\30"+
		"\r\2\u00b5\u00b6\7\t\2\2\u00b6\u00b7\7+\2\2\u00b7\u00b9\5\20\t\2\u00b8"+
		"\u00ba\5&\24\2\u00b9\u00b8\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\3\2"+
		"\2\2\u00bb\u00bd\7\61\2\2\u00bc\u00be\5&\24\2\u00bd\u00bc\3\2\2\2\u00bd"+
		"\u00be\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\7,\2\2\u00c0\u00c1\5\30"+
		"\r\2\u00c1\u00c3\3\2\2\2\u00c2\u00a0\3\2\2\2\u00c2\u00a6\3\2\2\2\u00c2"+
		"\u00b5\3\2\2\2\u00c3#\3\2\2\2\u00c4\u00c5\7\f\2\2\u00c5\u00ce\7\61\2\2"+
		"\u00c6\u00c7\7\13\2\2\u00c7\u00ce\7\61\2\2\u00c8\u00ca\7\r\2\2\u00c9\u00cb"+
		"\5&\24\2\u00ca\u00c9\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		"\u00ce\7\61\2\2\u00cd\u00c4\3\2\2\2\u00cd\u00c6\3\2\2\2\u00cd\u00c8\3"+
		"\2\2\2\u00ce%\3\2\2\2\u00cf\u00d0\b\24\1\2\u00d0\u00d1\t\2\2\2\u00d1\u00e1"+
		"\5&\24\25\u00d2\u00d3\t\3\2\2\u00d3\u00e1\5&\24\24\u00d4\u00d5\7\36\2"+
		"\2\u00d5\u00e1\5&\24\23\u00d6\u00d7\7!\2\2\u00d7\u00e1\5&\24\22\u00d8"+
		"\u00d9\7\16\2\2\u00d9\u00e1\5*\26\2\u00da\u00e1\7\63\2\2\u00db\u00e1\5"+
		",\27\2\u00dc\u00dd\7+\2\2\u00dd\u00de\5&\24\2\u00de\u00df\7,\2\2\u00df"+
		"\u00e1\3\2\2\2\u00e0\u00cf\3\2\2\2\u00e0\u00d2\3\2\2\2\u00e0\u00d4\3\2"+
		"\2\2\u00e0\u00d6\3\2\2\2\u00e0\u00d8\3\2\2\2\u00e0\u00da\3\2\2\2\u00e0"+
		"\u00db\3\2\2\2\u00e0\u00dc\3\2\2\2\u00e1\u0115\3\2\2\2\u00e2\u00e3\f\20"+
		"\2\2\u00e3\u00e4\t\4\2\2\u00e4\u0114\5&\24\21\u00e5\u00e6\f\17\2\2\u00e6"+
		"\u00e7\t\3\2\2\u00e7\u0114\5&\24\20\u00e8\u00e9\f\16\2\2\u00e9\u00ea\t"+
		"\5\2\2\u00ea\u0114\5&\24\17\u00eb\u00ec\f\r\2\2\u00ec\u00ed\t\6\2\2\u00ed"+
		"\u0114\5&\24\16\u00ee\u00ef\f\f\2\2\u00ef\u00f0\t\7\2\2\u00f0\u0114\5"+
		"&\24\r\u00f1\u00f2\f\13\2\2\u00f2\u00f3\7$\2\2\u00f3\u0114\5&\24\f\u00f4"+
		"\u00f5\f\n\2\2\u00f5\u00f6\7#\2\2\u00f6\u0114\5&\24\13\u00f7\u00f8\f\t"+
		"\2\2\u00f8\u00f9\7\"\2\2\u00f9\u0114\5&\24\n\u00fa\u00fb\f\b\2\2\u00fb"+
		"\u00fc\7\34\2\2\u00fc\u0114\5&\24\t\u00fd\u00fe\f\7\2\2\u00fe\u00ff\7"+
		"\35\2\2\u00ff\u0114\5&\24\b\u0100\u0101\f\6\2\2\u0101\u0102\7%\2\2\u0102"+
		"\u0114\5&\24\6\u0103\u0104\f\31\2\2\u0104\u0105\7)\2\2\u0105\u0106\5&"+
		"\24\2\u0106\u0107\7*\2\2\u0107\u0114\3\2\2\2\u0108\u0109\f\30\2\2\u0109"+
		"\u010b\7+\2\2\u010a\u010c\5(\25\2\u010b\u010a\3\2\2\2\u010b\u010c\3\2"+
		"\2\2\u010c\u010d\3\2\2\2\u010d\u0114\7,\2\2\u010e\u010f\f\27\2\2\u010f"+
		"\u0110\7(\2\2\u0110\u0114\7\63\2\2\u0111\u0112\f\26\2\2\u0112\u0114\t"+
		"\2\2\2\u0113\u00e2\3\2\2\2\u0113\u00e5\3\2\2\2\u0113\u00e8\3\2\2\2\u0113"+
		"\u00eb\3\2\2\2\u0113\u00ee\3\2\2\2\u0113\u00f1\3\2\2\2\u0113\u00f4\3\2"+
		"\2\2\u0113\u00f7\3\2\2\2\u0113\u00fa\3\2\2\2\u0113\u00fd\3\2\2\2\u0113"+
		"\u0100\3\2\2\2\u0113\u0103\3\2\2\2\u0113\u0108\3\2\2\2\u0113\u010e\3\2"+
		"\2\2\u0113\u0111\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2\2\2\u0115"+
		"\u0116\3\2\2\2\u0116\'\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u011d\5&\24\2"+
		"\u0119\u011a\7\62\2\2\u011a\u011c\5&\24\2\u011b\u0119\3\2\2\2\u011c\u011f"+
		"\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e)\3\2\2\2\u011f"+
		"\u011d\3\2\2\2\u0120\u0125\5\26\f\2\u0121\u0122\7)\2\2\u0122\u0123\5&"+
		"\24\2\u0123\u0124\7*\2\2\u0124\u0126\3\2\2\2\u0125\u0121\3\2\2\2\u0126"+
		"\u0127\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u012b\3\2"+
		"\2\2\u0129\u012a\7)\2\2\u012a\u012c\7*\2\2\u012b\u0129\3\2\2\2\u012c\u012d"+
		"\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u0133\3\2\2\2\u012f"+
		"\u0130\7)\2\2\u0130\u0131\5&\24\2\u0131\u0132\7*\2\2\u0132\u0134\3\2\2"+
		"\2\u0133\u012f\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136"+
		"\3\2\2\2\u0136\u0149\3\2\2\2\u0137\u013c\5\26\f\2\u0138\u0139\7)\2\2\u0139"+
		"\u013a\5&\24\2\u013a\u013b\7*\2\2\u013b\u013d\3\2\2\2\u013c\u0138\3\2"+
		"\2\2\u013d\u013e\3\2\2\2\u013e\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f"+
		"\u0144\3\2\2\2\u0140\u0141\7)\2\2\u0141\u0143\7*\2\2\u0142\u0140\3\2\2"+
		"\2\u0143\u0146\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0149"+
		"\3\2\2\2\u0146\u0144\3\2\2\2\u0147\u0149\5\26\f\2\u0148\u0120\3\2\2\2"+
		"\u0148\u0137\3\2\2\2\u0148\u0147\3\2\2\2\u0149+\3\2\2\2\u014a\u0150\7"+
		"8\2\2\u014b\u0150\7\64\2\2\u014c\u0150\7\66\2\2\u014d\u0150\7\67\2\2\u014e"+
		"\u0150\7\65\2\2\u014f\u014a\3\2\2\2\u014f\u014b\3\2\2\2\u014f\u014c\3"+
		"\2\2\2\u014f\u014d\3\2\2\2\u014f\u014e\3\2\2\2\u0150-\3\2\2\2%\619?IU"+
		"\\dlv~\u0085\u008b\u0092\u0095\u009e\u00a9\u00ad\u00b1\u00b9\u00bd\u00c2"+
		"\u00ca\u00cd\u00e0\u010b\u0113\u0115\u011d\u0127\u012d\u0135\u013e\u0144"+
		"\u0148\u014f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}