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
		Identifier=49, IntegerConstant=50, CharacterConstant=51, StringLiteral=52, 
		NullLiteral=53, LogicalConstant=54, Whitespace=55, Newline=56, BlockComment=57, 
		LineComment=58;
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
			"RightBrace", "Question", "Colon", "Semi", "Comma", "Identifier", "Letter", 
			"Nondigit", "Digit", "IntegerConstant", "CharacterConstant", "StringLiteral", 
			"NullLiteral", "LogicalConstant", "NonzeroDigit", "CCharSequence", "CChar", 
			"EscapeSequence", "SimpleEscapeSequence", "SCharSequence", "SChar", "Whitespace", 
			"Newline", "BlockComment", "LineComment"
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
			"'?'", "':'", "';'", "','", null, null, null, null, "'null'"
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
			"Semi", "Comma", "Identifier", "IntegerConstant", "CharacterConstant", 
			"StringLiteral", "NullLiteral", "LogicalConstant", "Whitespace", "Newline", 
			"BlockComment", "LineComment"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2<\u01ad\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\3\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37"+
		"\3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3(\3"+
		")\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3"+
		"\62\3\63\3\63\3\64\3\64\3\65\3\65\3\65\7\65\u013f\n\65\f\65\16\65\u0142"+
		"\13\65\3\66\3\66\3\67\3\67\38\38\39\39\79\u014c\n9\f9\169\u014f\139\3"+
		"9\59\u0152\n9\3:\3:\3:\3:\3;\3;\5;\u015a\n;\3;\3;\3<\3<\3<\3<\3<\3=\3"+
		"=\3=\3=\3=\3=\3=\3=\3=\5=\u016c\n=\3>\3>\3?\6?\u0171\n?\r?\16?\u0172\3"+
		"@\3@\5@\u0177\n@\3A\3A\3B\3B\3B\3C\6C\u017f\nC\rC\16C\u0180\3D\3D\5D\u0185"+
		"\nD\3E\6E\u0188\nE\rE\16E\u0189\3E\3E\3F\5F\u018f\nF\3F\3F\3F\3F\3G\3"+
		"G\3G\3G\7G\u0199\nG\fG\16G\u019c\13G\3G\3G\3G\3G\3G\3H\3H\3H\3H\7H\u01a7"+
		"\nH\fH\16H\u01aa\13H\3H\3H\3\u019a\2I\3\3\5\4\7\5\t\6\13\2\r\7\17\2\21"+
		"\2\23\b\25\t\27\n\31\13\33\f\35\r\37\16!\17#\20%\21\'\22)\23+\24-\25/"+
		"\26\61\27\63\30\65\31\67\329\33;\34=\35?\36A\37C E!G\"I#K$M%O&Q\'S(U)"+
		"W*Y+[,]-_.a/c\60e\61g\62i\63k\2m\2o\2q\64s\65u\66w\67y8{\2}\2\177\2\u0081"+
		"\2\u0083\2\u0085\2\u0087\2\u00899\u008b:\u008d;\u008f<\3\2\13\4\2C\\c"+
		"|\5\2C\\aac|\3\2\62;\3\2\63;\6\2\f\f\17\17))^^\f\2$$))AA^^cdhhppttvvx"+
		"x\6\2\f\f\17\17$$^^\4\2\13\13\"\"\4\2\f\f\17\17\2\u01ad\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\r\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2"+
		"\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2"+
		"\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2q"+
		"\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2\u0089\3\2\2\2\2"+
		"\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\3\u0091\3\2\2\2\5\u0096"+
		"\3\2\2\2\7\u009b\3\2\2\2\t\u009f\3\2\2\2\13\u00a6\3\2\2\2\r\u00ab\3\2"+
		"\2\2\17\u00b0\3\2\2\2\21\u00b5\3\2\2\2\23\u00bb\3\2\2\2\25\u00be\3\2\2"+
		"\2\27\u00c2\3\2\2\2\31\u00c8\3\2\2\2\33\u00ce\3\2\2\2\35\u00d7\3\2\2\2"+
		"\37\u00de\3\2\2\2!\u00e2\3\2\2\2#\u00e8\3\2\2\2%\u00ed\3\2\2\2\'\u00ef"+
		"\3\2\2\2)\u00f1\3\2\2\2+\u00f3\3\2\2\2-\u00f5\3\2\2\2/\u00f7\3\2\2\2\61"+
		"\u00f9\3\2\2\2\63\u00fb\3\2\2\2\65\u00fe\3\2\2\2\67\u0101\3\2\2\29\u0104"+
		"\3\2\2\2;\u0107\3\2\2\2=\u010a\3\2\2\2?\u010d\3\2\2\2A\u010f\3\2\2\2C"+
		"\u0112\3\2\2\2E\u0115\3\2\2\2G\u0117\3\2\2\2I\u0119\3\2\2\2K\u011b\3\2"+
		"\2\2M\u011d\3\2\2\2O\u011f\3\2\2\2Q\u0122\3\2\2\2S\u0125\3\2\2\2U\u0127"+
		"\3\2\2\2W\u0129\3\2\2\2Y\u012b\3\2\2\2[\u012d\3\2\2\2]\u012f\3\2\2\2_"+
		"\u0131\3\2\2\2a\u0133\3\2\2\2c\u0135\3\2\2\2e\u0137\3\2\2\2g\u0139\3\2"+
		"\2\2i\u013b\3\2\2\2k\u0143\3\2\2\2m\u0145\3\2\2\2o\u0147\3\2\2\2q\u0151"+
		"\3\2\2\2s\u0153\3\2\2\2u\u0157\3\2\2\2w\u015d\3\2\2\2y\u016b\3\2\2\2{"+
		"\u016d\3\2\2\2}\u0170\3\2\2\2\177\u0176\3\2\2\2\u0081\u0178\3\2\2\2\u0083"+
		"\u017a\3\2\2\2\u0085\u017e\3\2\2\2\u0087\u0184\3\2\2\2\u0089\u0187\3\2"+
		"\2\2\u008b\u018e\3\2\2\2\u008d\u0194\3\2\2\2\u008f\u01a2\3\2\2\2\u0091"+
		"\u0092\7g\2\2\u0092\u0093\7n\2\2\u0093\u0094\7u\2\2\u0094\u0095\7g\2\2"+
		"\u0095\4\3\2\2\2\u0096\u0097\7d\2\2\u0097\u0098\7q\2\2\u0098\u0099\7q"+
		"\2\2\u0099\u009a\7n\2\2\u009a\6\3\2\2\2\u009b\u009c\7k\2\2\u009c\u009d"+
		"\7p\2\2\u009d\u009e\7v\2\2\u009e\b\3\2\2\2\u009f\u00a0\7u\2\2\u00a0\u00a1"+
		"\7v\2\2\u00a1\u00a2\7t\2\2\u00a2\u00a3\7k\2\2\u00a3\u00a4\7p\2\2\u00a4"+
		"\u00a5\7i\2\2\u00a5\n\3\2\2\2\u00a6\u00a7\7p\2\2\u00a7\u00a8\7w\2\2\u00a8"+
		"\u00a9\7n\2\2\u00a9\u00aa\7n\2\2\u00aa\f\3\2\2\2\u00ab\u00ac\7x\2\2\u00ac"+
		"\u00ad\7q\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af\7f\2\2\u00af\16\3\2\2\2\u00b0"+
		"\u00b1\7v\2\2\u00b1\u00b2\7t\2\2\u00b2\u00b3\7w\2\2\u00b3\u00b4\7g\2\2"+
		"\u00b4\20\3\2\2\2\u00b5\u00b6\7h\2\2\u00b6\u00b7\7c\2\2\u00b7\u00b8\7"+
		"n\2\2\u00b8\u00b9\7u\2\2\u00b9\u00ba\7g\2\2\u00ba\22\3\2\2\2\u00bb\u00bc"+
		"\7k\2\2\u00bc\u00bd\7h\2\2\u00bd\24\3\2\2\2\u00be\u00bf\7h\2\2\u00bf\u00c0"+
		"\7q\2\2\u00c0\u00c1\7t\2\2\u00c1\26\3\2\2\2\u00c2\u00c3\7y\2\2\u00c3\u00c4"+
		"\7j\2\2\u00c4\u00c5\7k\2\2\u00c5\u00c6\7n\2\2\u00c6\u00c7\7g\2\2\u00c7"+
		"\30\3\2\2\2\u00c8\u00c9\7d\2\2\u00c9\u00ca\7t\2\2\u00ca\u00cb\7g\2\2\u00cb"+
		"\u00cc\7c\2\2\u00cc\u00cd\7m\2\2\u00cd\32\3\2\2\2\u00ce\u00cf\7e\2\2\u00cf"+
		"\u00d0\7q\2\2\u00d0\u00d1\7p\2\2\u00d1\u00d2\7v\2\2\u00d2\u00d3\7k\2\2"+
		"\u00d3\u00d4\7p\2\2\u00d4\u00d5\7w\2\2\u00d5\u00d6\7g\2\2\u00d6\34\3\2"+
		"\2\2\u00d7\u00d8\7t\2\2\u00d8\u00d9\7g\2\2\u00d9\u00da\7v\2\2\u00da\u00db"+
		"\7w\2\2\u00db\u00dc\7t\2\2\u00dc\u00dd\7p\2\2\u00dd\36\3\2\2\2\u00de\u00df"+
		"\7p\2\2\u00df\u00e0\7g\2\2\u00e0\u00e1\7y\2\2\u00e1 \3\2\2\2\u00e2\u00e3"+
		"\7e\2\2\u00e3\u00e4\7n\2\2\u00e4\u00e5\7c\2\2\u00e5\u00e6\7u\2\2\u00e6"+
		"\u00e7\7u\2\2\u00e7\"\3\2\2\2\u00e8\u00e9\7v\2\2\u00e9\u00ea\7j\2\2\u00ea"+
		"\u00eb\7k\2\2\u00eb\u00ec\7u\2\2\u00ec$\3\2\2\2\u00ed\u00ee\7-\2\2\u00ee"+
		"&\3\2\2\2\u00ef\u00f0\7/\2\2\u00f0(\3\2\2\2\u00f1\u00f2\7,\2\2\u00f2*"+
		"\3\2\2\2\u00f3\u00f4\7\61\2\2\u00f4,\3\2\2\2\u00f5\u00f6\7\'\2\2\u00f6"+
		".\3\2\2\2\u00f7\u00f8\7>\2\2\u00f8\60\3\2\2\2\u00f9\u00fa\7@\2\2\u00fa"+
		"\62\3\2\2\2\u00fb\u00fc\7?\2\2\u00fc\u00fd\7?\2\2\u00fd\64\3\2\2\2\u00fe"+
		"\u00ff\7#\2\2\u00ff\u0100\7?\2\2\u0100\66\3\2\2\2\u0101\u0102\7>\2\2\u0102"+
		"\u0103\7?\2\2\u01038\3\2\2\2\u0104\u0105\7@\2\2\u0105\u0106\7?\2\2\u0106"+
		":\3\2\2\2\u0107\u0108\7(\2\2\u0108\u0109\7(\2\2\u0109<\3\2\2\2\u010a\u010b"+
		"\7~\2\2\u010b\u010c\7~\2\2\u010c>\3\2\2\2\u010d\u010e\7#\2\2\u010e@\3"+
		"\2\2\2\u010f\u0110\7>\2\2\u0110\u0111\7>\2\2\u0111B\3\2\2\2\u0112\u0113"+
		"\7@\2\2\u0113\u0114\7@\2\2\u0114D\3\2\2\2\u0115\u0116\7\u0080\2\2\u0116"+
		"F\3\2\2\2\u0117\u0118\7~\2\2\u0118H\3\2\2\2\u0119\u011a\7`\2\2\u011aJ"+
		"\3\2\2\2\u011b\u011c\7(\2\2\u011cL\3\2\2\2\u011d\u011e\7?\2\2\u011eN\3"+
		"\2\2\2\u011f\u0120\7-\2\2\u0120\u0121\7-\2\2\u0121P\3\2\2\2\u0122\u0123"+
		"\7/\2\2\u0123\u0124\7/\2\2\u0124R\3\2\2\2\u0125\u0126\7\60\2\2\u0126T"+
		"\3\2\2\2\u0127\u0128\7]\2\2\u0128V\3\2\2\2\u0129\u012a\7_\2\2\u012aX\3"+
		"\2\2\2\u012b\u012c\7*\2\2\u012cZ\3\2\2\2\u012d\u012e\7+\2\2\u012e\\\3"+
		"\2\2\2\u012f\u0130\7}\2\2\u0130^\3\2\2\2\u0131\u0132\7\177\2\2\u0132`"+
		"\3\2\2\2\u0133\u0134\7A\2\2\u0134b\3\2\2\2\u0135\u0136\7<\2\2\u0136d\3"+
		"\2\2\2\u0137\u0138\7=\2\2\u0138f\3\2\2\2\u0139\u013a\7.\2\2\u013ah\3\2"+
		"\2\2\u013b\u0140\5k\66\2\u013c\u013f\5m\67\2\u013d\u013f\5o8\2\u013e\u013c"+
		"\3\2\2\2\u013e\u013d\3\2\2\2\u013f\u0142\3\2\2\2\u0140\u013e\3\2\2\2\u0140"+
		"\u0141\3\2\2\2\u0141j\3\2\2\2\u0142\u0140\3\2\2\2\u0143\u0144\t\2\2\2"+
		"\u0144l\3\2\2\2\u0145\u0146\t\3\2\2\u0146n\3\2\2\2\u0147\u0148\t\4\2\2"+
		"\u0148p\3\2\2\2\u0149\u014d\5{>\2\u014a\u014c\5o8\2\u014b\u014a\3\2\2"+
		"\2\u014c\u014f\3\2\2\2\u014d\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u0152"+
		"\3\2\2\2\u014f\u014d\3\2\2\2\u0150\u0152\7\62\2\2\u0151\u0149\3\2\2\2"+
		"\u0151\u0150\3\2\2\2\u0152r\3\2\2\2\u0153\u0154\7)\2\2\u0154\u0155\5}"+
		"?\2\u0155\u0156\7)\2\2\u0156t\3\2\2\2\u0157\u0159\7$\2\2\u0158\u015a\5"+
		"\u0085C\2\u0159\u0158\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015b\3\2\2\2"+
		"\u015b\u015c\7$\2\2\u015cv\3\2\2\2\u015d\u015e\7p\2\2\u015e\u015f\7w\2"+
		"\2\u015f\u0160\7n\2\2\u0160\u0161\7n\2\2\u0161x\3\2\2\2\u0162\u0163\7"+
		"v\2\2\u0163\u0164\7t\2\2\u0164\u0165\7w\2\2\u0165\u016c\7g\2\2\u0166\u0167"+
		"\7h\2\2\u0167\u0168\7c\2\2\u0168\u0169\7n\2\2\u0169\u016a\7u\2\2\u016a"+
		"\u016c\7g\2\2\u016b\u0162\3\2\2\2\u016b\u0166\3\2\2\2\u016cz\3\2\2\2\u016d"+
		"\u016e\t\5\2\2\u016e|\3\2\2\2\u016f\u0171\5\177@\2\u0170\u016f\3\2\2\2"+
		"\u0171\u0172\3\2\2\2\u0172\u0170\3\2\2\2\u0172\u0173\3\2\2\2\u0173~\3"+
		"\2\2\2\u0174\u0177\n\6\2\2\u0175\u0177\5\u0081A\2\u0176\u0174\3\2\2\2"+
		"\u0176\u0175\3\2\2\2\u0177\u0080\3\2\2\2\u0178\u0179\5\u0083B\2\u0179"+
		"\u0082\3\2\2\2\u017a\u017b\7^\2\2\u017b\u017c\t\7\2\2\u017c\u0084\3\2"+
		"\2\2\u017d\u017f\5\u0087D\2\u017e\u017d\3\2\2\2\u017f\u0180\3\2\2\2\u0180"+
		"\u017e\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0086\3\2\2\2\u0182\u0185\n\b"+
		"\2\2\u0183\u0185\5\u0081A\2\u0184\u0182\3\2\2\2\u0184\u0183\3\2\2\2\u0185"+
		"\u0088\3\2\2\2\u0186\u0188\t\t\2\2\u0187\u0186\3\2\2\2\u0188\u0189\3\2"+
		"\2\2\u0189\u0187\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u018b\3\2\2\2\u018b"+
		"\u018c\bE\2\2\u018c\u008a\3\2\2\2\u018d\u018f\7\17\2\2\u018e\u018d\3\2"+
		"\2\2\u018e\u018f\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0191\7\f\2\2\u0191"+
		"\u0192\3\2\2\2\u0192\u0193\bF\2\2\u0193\u008c\3\2\2\2\u0194\u0195\7\61"+
		"\2\2\u0195\u0196\7,\2\2\u0196\u019a\3\2\2\2\u0197\u0199\13\2\2\2\u0198"+
		"\u0197\3\2\2\2\u0199\u019c\3\2\2\2\u019a\u019b\3\2\2\2\u019a\u0198\3\2"+
		"\2\2\u019b\u019d\3\2\2\2\u019c\u019a\3\2\2\2\u019d\u019e\7,\2\2\u019e"+
		"\u019f\7\61\2\2\u019f\u01a0\3\2\2\2\u01a0\u01a1\bG\2\2\u01a1\u008e\3\2"+
		"\2\2\u01a2\u01a3\7\61\2\2\u01a3\u01a4\7\61\2\2\u01a4\u01a8\3\2\2\2\u01a5"+
		"\u01a7\n\n\2\2\u01a6\u01a5\3\2\2\2\u01a7\u01aa\3\2\2\2\u01a8\u01a6\3\2"+
		"\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01ab\3\2\2\2\u01aa\u01a8\3\2\2\2\u01ab"+
		"\u01ac\bH\2\2\u01ac\u0090\3\2\2\2\21\2\u013e\u0140\u014d\u0151\u0159\u016b"+
		"\u0172\u0176\u0180\u0184\u0189\u018e\u019a\u01a8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}