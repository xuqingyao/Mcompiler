// Generated from C:/Users/echo/Desktop/Mcompiler/src/com/echo/compiler/parser\m.g4 by ANTLR 4.7.2
package com.echo.compiler.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class mLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "Bool", "Int", "String", "Null", "Void", "True", "False", "If", 
			"For", "While", "Break", "Continue", "Return", "New", "Class", "This", 
			"Plus", "Minus", "Star", "Div", "Mod", "Less", "Greater", "Equal", "NotEqual", 
			"LessEqual", "GreaterEqual", "AndAnd", "OrOr", "Not", "LeftShift", "RightShift", 
			"Tilde", "Or", "Caret", "And", "Assign", "PlusPlus", "MinusMinus", "Dot", 
			"LeftBracket", "RightBracket", "LeftParen", "RightParen", "LeftBrace", 
			"RightBrace", "Question", "Colon", "Semi", "Comma", "IntegerConstant", 
			"StringLiteral", "StringCharacter", "NullLiteral", "LogicalConstant", 
			"Identifier", "IdentifierNonDigitUnderline", "IdentifierNonDigit", "Digit", 
			"WhiteSpace", "NewLine", "LineComment", "BlockComment"
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


	public mLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "m.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2;\u0180\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3"+
		"\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3"+
		"\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3"+
		"\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3$\3$\3"+
		"%\3%\3&\3&\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/"+
		"\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\7\65\u0130"+
		"\n\65\f\65\16\65\u0133\13\65\3\65\5\65\u0136\n\65\3\66\3\66\7\66\u013a"+
		"\n\66\f\66\16\66\u013d\13\66\3\66\3\66\3\67\3\67\3\67\5\67\u0144\n\67"+
		"\38\38\39\39\59\u014a\n9\3:\3:\3:\7:\u014f\n:\f:\16:\u0152\13:\3;\3;\3"+
		"<\3<\3=\3=\3>\6>\u015b\n>\r>\16>\u015c\3>\3>\3?\5?\u0162\n?\3?\3?\3?\3"+
		"?\3@\3@\3@\3@\7@\u016c\n@\f@\16@\u016f\13@\3@\3@\3A\3A\3A\3A\7A\u0177"+
		"\nA\fA\16A\u017a\13A\3A\3A\3A\3A\3A\3\u0178\2B\3\3\5\4\7\5\t\6\13\2\r"+
		"\7\17\2\21\2\23\b\25\t\27\n\31\13\33\f\35\r\37\16!\17#\20%\21\'\22)\23"+
		"+\24-\25/\26\61\27\63\30\65\31\67\329\33;\34=\35?\36A\37C E!G\"I#K$M%"+
		"O&Q\'S(U)W*Y+[,]-_.a/c\60e\61g\62i\63k\64m\2o\65q\66s\67u\2w\2y\2{8}9"+
		"\177:\u0081;\3\2\n\3\2\63;\3\2\62;\6\2\f\f\17\17$$^^\5\2$$^^pp\4\2C\\"+
		"c|\5\2C\\aac|\4\2\13\13\"\"\4\2\f\f\17\17\2\u0183\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\r\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2"+
		"\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2"+
		"\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2"+
		"\2\u0081\3\2\2\2\3\u0083\3\2\2\2\5\u0088\3\2\2\2\7\u008d\3\2\2\2\t\u0091"+
		"\3\2\2\2\13\u0098\3\2\2\2\r\u009d\3\2\2\2\17\u00a2\3\2\2\2\21\u00a7\3"+
		"\2\2\2\23\u00ad\3\2\2\2\25\u00b0\3\2\2\2\27\u00b4\3\2\2\2\31\u00ba\3\2"+
		"\2\2\33\u00c0\3\2\2\2\35\u00c9\3\2\2\2\37\u00d0\3\2\2\2!\u00d4\3\2\2\2"+
		"#\u00da\3\2\2\2%\u00df\3\2\2\2\'\u00e1\3\2\2\2)\u00e3\3\2\2\2+\u00e5\3"+
		"\2\2\2-\u00e7\3\2\2\2/\u00e9\3\2\2\2\61\u00eb\3\2\2\2\63\u00ed\3\2\2\2"+
		"\65\u00f0\3\2\2\2\67\u00f3\3\2\2\29\u00f6\3\2\2\2;\u00f9\3\2\2\2=\u00fc"+
		"\3\2\2\2?\u00ff\3\2\2\2A\u0101\3\2\2\2C\u0104\3\2\2\2E\u0107\3\2\2\2G"+
		"\u0109\3\2\2\2I\u010b\3\2\2\2K\u010d\3\2\2\2M\u010f\3\2\2\2O\u0111\3\2"+
		"\2\2Q\u0114\3\2\2\2S\u0117\3\2\2\2U\u0119\3\2\2\2W\u011b\3\2\2\2Y\u011d"+
		"\3\2\2\2[\u011f\3\2\2\2]\u0121\3\2\2\2_\u0123\3\2\2\2a\u0125\3\2\2\2c"+
		"\u0127\3\2\2\2e\u0129\3\2\2\2g\u012b\3\2\2\2i\u0135\3\2\2\2k\u0137\3\2"+
		"\2\2m\u0143\3\2\2\2o\u0145\3\2\2\2q\u0149\3\2\2\2s\u014b\3\2\2\2u\u0153"+
		"\3\2\2\2w\u0155\3\2\2\2y\u0157\3\2\2\2{\u015a\3\2\2\2}\u0161\3\2\2\2\177"+
		"\u0167\3\2\2\2\u0081\u0172\3\2\2\2\u0083\u0084\7g\2\2\u0084\u0085\7n\2"+
		"\2\u0085\u0086\7u\2\2\u0086\u0087\7g\2\2\u0087\4\3\2\2\2\u0088\u0089\7"+
		"d\2\2\u0089\u008a\7q\2\2\u008a\u008b\7q\2\2\u008b\u008c\7n\2\2\u008c\6"+
		"\3\2\2\2\u008d\u008e\7k\2\2\u008e\u008f\7p\2\2\u008f\u0090\7v\2\2\u0090"+
		"\b\3\2\2\2\u0091\u0092\7u\2\2\u0092\u0093\7v\2\2\u0093\u0094\7t\2\2\u0094"+
		"\u0095\7k\2\2\u0095\u0096\7p\2\2\u0096\u0097\7i\2\2\u0097\n\3\2\2\2\u0098"+
		"\u0099\7p\2\2\u0099\u009a\7w\2\2\u009a\u009b\7n\2\2\u009b\u009c\7n\2\2"+
		"\u009c\f\3\2\2\2\u009d\u009e\7x\2\2\u009e\u009f\7q\2\2\u009f\u00a0\7k"+
		"\2\2\u00a0\u00a1\7f\2\2\u00a1\16\3\2\2\2\u00a2\u00a3\7v\2\2\u00a3\u00a4"+
		"\7t\2\2\u00a4\u00a5\7w\2\2\u00a5\u00a6\7g\2\2\u00a6\20\3\2\2\2\u00a7\u00a8"+
		"\7h\2\2\u00a8\u00a9\7c\2\2\u00a9\u00aa\7n\2\2\u00aa\u00ab\7u\2\2\u00ab"+
		"\u00ac\7g\2\2\u00ac\22\3\2\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af\7h\2\2\u00af"+
		"\24\3\2\2\2\u00b0\u00b1\7h\2\2\u00b1\u00b2\7q\2\2\u00b2\u00b3\7t\2\2\u00b3"+
		"\26\3\2\2\2\u00b4\u00b5\7y\2\2\u00b5\u00b6\7j\2\2\u00b6\u00b7\7k\2\2\u00b7"+
		"\u00b8\7n\2\2\u00b8\u00b9\7g\2\2\u00b9\30\3\2\2\2\u00ba\u00bb\7d\2\2\u00bb"+
		"\u00bc\7t\2\2\u00bc\u00bd\7g\2\2\u00bd\u00be\7c\2\2\u00be\u00bf\7m\2\2"+
		"\u00bf\32\3\2\2\2\u00c0\u00c1\7e\2\2\u00c1\u00c2\7q\2\2\u00c2\u00c3\7"+
		"p\2\2\u00c3\u00c4\7v\2\2\u00c4\u00c5\7k\2\2\u00c5\u00c6\7p\2\2\u00c6\u00c7"+
		"\7w\2\2\u00c7\u00c8\7g\2\2\u00c8\34\3\2\2\2\u00c9\u00ca\7t\2\2\u00ca\u00cb"+
		"\7g\2\2\u00cb\u00cc\7v\2\2\u00cc\u00cd\7w\2\2\u00cd\u00ce\7t\2\2\u00ce"+
		"\u00cf\7p\2\2\u00cf\36\3\2\2\2\u00d0\u00d1\7p\2\2\u00d1\u00d2\7g\2\2\u00d2"+
		"\u00d3\7y\2\2\u00d3 \3\2\2\2\u00d4\u00d5\7e\2\2\u00d5\u00d6\7n\2\2\u00d6"+
		"\u00d7\7c\2\2\u00d7\u00d8\7u\2\2\u00d8\u00d9\7u\2\2\u00d9\"\3\2\2\2\u00da"+
		"\u00db\7v\2\2\u00db\u00dc\7j\2\2\u00dc\u00dd\7k\2\2\u00dd\u00de\7u\2\2"+
		"\u00de$\3\2\2\2\u00df\u00e0\7-\2\2\u00e0&\3\2\2\2\u00e1\u00e2\7/\2\2\u00e2"+
		"(\3\2\2\2\u00e3\u00e4\7,\2\2\u00e4*\3\2\2\2\u00e5\u00e6\7\61\2\2\u00e6"+
		",\3\2\2\2\u00e7\u00e8\7\'\2\2\u00e8.\3\2\2\2\u00e9\u00ea\7>\2\2\u00ea"+
		"\60\3\2\2\2\u00eb\u00ec\7@\2\2\u00ec\62\3\2\2\2\u00ed\u00ee\7?\2\2\u00ee"+
		"\u00ef\7?\2\2\u00ef\64\3\2\2\2\u00f0\u00f1\7#\2\2\u00f1\u00f2\7?\2\2\u00f2"+
		"\66\3\2\2\2\u00f3\u00f4\7>\2\2\u00f4\u00f5\7?\2\2\u00f58\3\2\2\2\u00f6"+
		"\u00f7\7@\2\2\u00f7\u00f8\7?\2\2\u00f8:\3\2\2\2\u00f9\u00fa\7(\2\2\u00fa"+
		"\u00fb\7(\2\2\u00fb<\3\2\2\2\u00fc\u00fd\7~\2\2\u00fd\u00fe\7~\2\2\u00fe"+
		">\3\2\2\2\u00ff\u0100\7#\2\2\u0100@\3\2\2\2\u0101\u0102\7>\2\2\u0102\u0103"+
		"\7>\2\2\u0103B\3\2\2\2\u0104\u0105\7@\2\2\u0105\u0106\7@\2\2\u0106D\3"+
		"\2\2\2\u0107\u0108\7\u0080\2\2\u0108F\3\2\2\2\u0109\u010a\7~\2\2\u010a"+
		"H\3\2\2\2\u010b\u010c\7`\2\2\u010cJ\3\2\2\2\u010d\u010e\7(\2\2\u010eL"+
		"\3\2\2\2\u010f\u0110\7?\2\2\u0110N\3\2\2\2\u0111\u0112\7-\2\2\u0112\u0113"+
		"\7-\2\2\u0113P\3\2\2\2\u0114\u0115\7/\2\2\u0115\u0116\7/\2\2\u0116R\3"+
		"\2\2\2\u0117\u0118\7\60\2\2\u0118T\3\2\2\2\u0119\u011a\7]\2\2\u011aV\3"+
		"\2\2\2\u011b\u011c\7_\2\2\u011cX\3\2\2\2\u011d\u011e\7*\2\2\u011eZ\3\2"+
		"\2\2\u011f\u0120\7+\2\2\u0120\\\3\2\2\2\u0121\u0122\7}\2\2\u0122^\3\2"+
		"\2\2\u0123\u0124\7\177\2\2\u0124`\3\2\2\2\u0125\u0126\7A\2\2\u0126b\3"+
		"\2\2\2\u0127\u0128\7<\2\2\u0128d\3\2\2\2\u0129\u012a\7=\2\2\u012af\3\2"+
		"\2\2\u012b\u012c\7.\2\2\u012ch\3\2\2\2\u012d\u0131\t\2\2\2\u012e\u0130"+
		"\t\3\2\2\u012f\u012e\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0131"+
		"\u0132\3\2\2\2\u0132\u0136\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u0136\7\62"+
		"\2\2\u0135\u012d\3\2\2\2\u0135\u0134\3\2\2\2\u0136j\3\2\2\2\u0137\u013b"+
		"\7$\2\2\u0138\u013a\5m\67\2\u0139\u0138\3\2\2\2\u013a\u013d\3\2\2\2\u013b"+
		"\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013e\3\2\2\2\u013d\u013b\3\2"+
		"\2\2\u013e\u013f\7$\2\2\u013fl\3\2\2\2\u0140\u0144\n\4\2\2\u0141\u0142"+
		"\7^\2\2\u0142\u0144\t\5\2\2\u0143\u0140\3\2\2\2\u0143\u0141\3\2\2\2\u0144"+
		"n\3\2\2\2\u0145\u0146\5\13\6\2\u0146p\3\2\2\2\u0147\u014a\5\17\b\2\u0148"+
		"\u014a\5\21\t\2\u0149\u0147\3\2\2\2\u0149\u0148\3\2\2\2\u014ar\3\2\2\2"+
		"\u014b\u0150\5u;\2\u014c\u014f\5w<\2\u014d\u014f\5y=\2\u014e\u014c\3\2"+
		"\2\2\u014e\u014d\3\2\2\2\u014f\u0152\3\2\2\2\u0150\u014e\3\2\2\2\u0150"+
		"\u0151\3\2\2\2\u0151t\3\2\2\2\u0152\u0150\3\2\2\2\u0153\u0154\t\6\2\2"+
		"\u0154v\3\2\2\2\u0155\u0156\t\7\2\2\u0156x\3\2\2\2\u0157\u0158\t\3\2\2"+
		"\u0158z\3\2\2\2\u0159\u015b\t\b\2\2\u015a\u0159\3\2\2\2\u015b\u015c\3"+
		"\2\2\2\u015c\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015e\3\2\2\2\u015e"+
		"\u015f\b>\2\2\u015f|\3\2\2\2\u0160\u0162\7\17\2\2\u0161\u0160\3\2\2\2"+
		"\u0161\u0162\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0164\7\f\2\2\u0164\u0165"+
		"\3\2\2\2\u0165\u0166\b?\2\2\u0166~\3\2\2\2\u0167\u0168\7\61\2\2\u0168"+
		"\u0169\7\61\2\2\u0169\u016d\3\2\2\2\u016a\u016c\n\t\2\2\u016b\u016a\3"+
		"\2\2\2\u016c\u016f\3\2\2\2\u016d\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e"+
		"\u0170\3\2\2\2\u016f\u016d\3\2\2\2\u0170\u0171\b@\2\2\u0171\u0080\3\2"+
		"\2\2\u0172\u0173\7\61\2\2\u0173\u0174\7,\2\2\u0174\u0178\3\2\2\2\u0175"+
		"\u0177\13\2\2\2\u0176\u0175\3\2\2\2\u0177\u017a\3\2\2\2\u0178\u0179\3"+
		"\2\2\2\u0178\u0176\3\2\2\2\u0179\u017b\3\2\2\2\u017a\u0178\3\2\2\2\u017b"+
		"\u017c\7,\2\2\u017c\u017d\7\61\2\2\u017d\u017e\3\2\2\2\u017e\u017f\bA"+
		"\2\2\u017f\u0082\3\2\2\2\16\2\u0131\u0135\u013b\u0143\u0149\u014e\u0150"+
		"\u015c\u0161\u016d\u0178\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}