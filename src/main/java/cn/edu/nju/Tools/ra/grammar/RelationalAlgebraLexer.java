// Generated from D:/Antlr-SQLGraphExplorer/SQLGraphExplorer/src/main/java/cn/edu/nju/tools/ra/grammar/RelationalAlgebra.g4 by ANTLR 4.13.1
package cn.edu.nju.tools.ra.grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class RelationalAlgebraLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, PROJECTION=8, 
		SELECTION=9, UNION=10, DIFFERENCE=11, CARTESIAN_PRODUCT=12, INTERSECTION=13, 
		NATURAL_JOIN=14, JOIN=15, DIVISION=16, EQUAL=17, NOT_EQUAL=18, GREATER_THAN=19, 
		GREATER_EQUAL=20, LESS_THAN=21, LESS_EQUAL=22, BOOLEAN_AND=23, BOOLEAN_OR=24, 
		BOOLEAN_NOT=25, STRING=26, IDENTIFIER=27, NUMBER=28, DECIMAL=29, PUNCTUATION=30, 
		WHITESPACES=31, COMMENT=32, LINE_COMMENT=33;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "PROJECTION", 
			"SELECTION", "UNION", "DIFFERENCE", "CARTESIAN_PRODUCT", "INTERSECTION", 
			"NATURAL_JOIN", "JOIN", "DIVISION", "EQUAL", "NOT_EQUAL", "GREATER_THAN", 
			"GREATER_EQUAL", "LESS_THAN", "LESS_EQUAL", "BOOLEAN_AND", "BOOLEAN_OR", 
			"BOOLEAN_NOT", "STRING", "IDENTIFIER", "NUMBER", "DECIMAL", "PUNCTUATION", 
			"WHITESPACES", "COMMENT", "LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'('", "')'", "'['", "']'", "','", "'NOT'", null, null, 
			null, null, null, null, null, null, null, "'='", null, "'>'", "'>='", 
			"'<'", "'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "PROJECTION", "SELECTION", 
			"UNION", "DIFFERENCE", "CARTESIAN_PRODUCT", "INTERSECTION", "NATURAL_JOIN", 
			"JOIN", "DIVISION", "EQUAL", "NOT_EQUAL", "GREATER_THAN", "GREATER_EQUAL", 
			"LESS_THAN", "LESS_EQUAL", "BOOLEAN_AND", "BOOLEAN_OR", "BOOLEAN_NOT", 
			"STRING", "IDENTIFIER", "NUMBER", "DECIMAL", "PUNCTUATION", "WHITESPACES", 
			"COMMENT", "LINE_COMMENT"
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


	public RelationalAlgebraLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RelationalAlgebra.g4"; }

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
		"\u0004\u0000!\u01ef\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007v\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0096\b\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\t\u00a3\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00ba\b\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u00ed\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u011a\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0003\r\u013f\b\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0003\u000e\u014a\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0003\u000f\u015d\b\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0165\b\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u0178"+
		"\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003"+
		"\u0017\u017f\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u0188\b\u0018\u0001\u0019\u0001"+
		"\u0019\u0005\u0019\u018c\b\u0019\n\u0019\f\u0019\u018f\t\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0005\u0019\u0194\b\u0019\n\u0019\f\u0019\u0197"+
		"\t\u0019\u0001\u0019\u0003\u0019\u019a\b\u0019\u0001\u001a\u0004\u001a"+
		"\u019d\b\u001a\u000b\u001a\f\u001a\u019e\u0001\u001a\u0005\u001a\u01a2"+
		"\b\u001a\n\u001a\f\u001a\u01a5\t\u001a\u0001\u001a\u0001\u001a\u0004\u001a"+
		"\u01a9\b\u001a\u000b\u001a\f\u001a\u01aa\u0001\u001a\u0005\u001a\u01ae"+
		"\b\u001a\n\u001a\f\u001a\u01b1\t\u001a\u0004\u001a\u01b3\b\u001a\u000b"+
		"\u001a\f\u001a\u01b4\u0003\u001a\u01b7\b\u001a\u0001\u001b\u0004\u001b"+
		"\u01ba\b\u001b\u000b\u001b\f\u001b\u01bb\u0001\u001c\u0003\u001c\u01bf"+
		"\b\u001c\u0001\u001c\u0004\u001c\u01c2\b\u001c\u000b\u001c\f\u001c\u01c3"+
		"\u0001\u001c\u0001\u001c\u0004\u001c\u01c8\b\u001c\u000b\u001c\f\u001c"+
		"\u01c9\u0003\u001c\u01cc\b\u001c\u0001\u001d\u0001\u001d\u0001\u001e\u0004"+
		"\u001e\u01d1\b\u001e\u000b\u001e\f\u001e\u01d2\u0001\u001e\u0001\u001e"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0005\u001f\u01db\b\u001f"+
		"\n\u001f\f\u001f\u01de\t\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0005 \u01e9\b \n \f \u01ec"+
		"\t \u0001 \u0001 \u0003\u018d\u0195\u01dc\u0000!\u0001\u0001\u0003\u0002"+
		"\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013"+
		"\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011"+
		"#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b"+
		"7\u001c9\u001d;\u001e=\u001f? A!\u0001\u0000\u000b\u0002\u0000XXxx\u0002"+
		"\u0000YYyy\u0002\u0000//\u00f7\u00f7\u0002\u0000&&^^\u0002\u0000vv||\u0002"+
		"\u0000AZaz\u0004\u000009AZ__az\u0001\u000009\u0007\u0000#/;;@@[^``{{}"+
		"~\u0003\u0000\t\n\r\r  \u0002\u0000\n\n\r\r\u0220\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000"+
		"#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001"+
		"\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000"+
		"\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u0000"+
		"1\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001"+
		"\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000"+
		"\u0000\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000"+
		"?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0001C\u0001"+
		"\u0000\u0000\u0000\u0003E\u0001\u0000\u0000\u0000\u0005G\u0001\u0000\u0000"+
		"\u0000\u0007I\u0001\u0000\u0000\u0000\tK\u0001\u0000\u0000\u0000\u000b"+
		"M\u0001\u0000\u0000\u0000\rO\u0001\u0000\u0000\u0000\u000fu\u0001\u0000"+
		"\u0000\u0000\u0011\u0095\u0001\u0000\u0000\u0000\u0013\u00a2\u0001\u0000"+
		"\u0000\u0000\u0015\u00b9\u0001\u0000\u0000\u0000\u0017\u00ec\u0001\u0000"+
		"\u0000\u0000\u0019\u0119\u0001\u0000\u0000\u0000\u001b\u013e\u0001\u0000"+
		"\u0000\u0000\u001d\u0149\u0001\u0000\u0000\u0000\u001f\u015c\u0001\u0000"+
		"\u0000\u0000!\u015e\u0001\u0000\u0000\u0000#\u0164\u0001\u0000\u0000\u0000"+
		"%\u0166\u0001\u0000\u0000\u0000\'\u0168\u0001\u0000\u0000\u0000)\u016b"+
		"\u0001\u0000\u0000\u0000+\u016d\u0001\u0000\u0000\u0000-\u0177\u0001\u0000"+
		"\u0000\u0000/\u017e\u0001\u0000\u0000\u00001\u0187\u0001\u0000\u0000\u0000"+
		"3\u0199\u0001\u0000\u0000\u00005\u019c\u0001\u0000\u0000\u00007\u01b9"+
		"\u0001\u0000\u0000\u00009\u01be\u0001\u0000\u0000\u0000;\u01cd\u0001\u0000"+
		"\u0000\u0000=\u01d0\u0001\u0000\u0000\u0000?\u01d6\u0001\u0000\u0000\u0000"+
		"A\u01e4\u0001\u0000\u0000\u0000CD\u0005;\u0000\u0000D\u0002\u0001\u0000"+
		"\u0000\u0000EF\u0005(\u0000\u0000F\u0004\u0001\u0000\u0000\u0000GH\u0005"+
		")\u0000\u0000H\u0006\u0001\u0000\u0000\u0000IJ\u0005[\u0000\u0000J\b\u0001"+
		"\u0000\u0000\u0000KL\u0005]\u0000\u0000L\n\u0001\u0000\u0000\u0000MN\u0005"+
		",\u0000\u0000N\f\u0001\u0000\u0000\u0000OP\u0005N\u0000\u0000PQ\u0005"+
		"O\u0000\u0000QR\u0005T\u0000\u0000R\u000e\u0001\u0000\u0000\u0000ST\u0005"+
		"P\u0000\u0000TU\u0005R\u0000\u0000UV\u0005O\u0000\u0000VW\u0005J\u0000"+
		"\u0000WX\u0005E\u0000\u0000XY\u0005C\u0000\u0000YZ\u0005T\u0000\u0000"+
		"Z[\u0005I\u0000\u0000[\\\u0005O\u0000\u0000\\v\u0005N\u0000\u0000]^\u0005"+
		"p\u0000\u0000^_\u0005r\u0000\u0000_`\u0005o\u0000\u0000`a\u0005j\u0000"+
		"\u0000ab\u0005e\u0000\u0000bc\u0005c\u0000\u0000cd\u0005t\u0000\u0000"+
		"de\u0005i\u0000\u0000ef\u0005o\u0000\u0000fv\u0005n\u0000\u0000gh\u0005"+
		"P\u0000\u0000hi\u0005R\u0000\u0000ij\u0005O\u0000\u0000jk\u0005J\u0000"+
		"\u0000kl\u0005E\u0000\u0000lm\u0005C\u0000\u0000mv\u0005T\u0000\u0000"+
		"no\u0005p\u0000\u0000op\u0005r\u0000\u0000pq\u0005o\u0000\u0000qr\u0005"+
		"j\u0000\u0000rs\u0005e\u0000\u0000st\u0005c\u0000\u0000tv\u0005t\u0000"+
		"\u0000uS\u0001\u0000\u0000\u0000u]\u0001\u0000\u0000\u0000ug\u0001\u0000"+
		"\u0000\u0000un\u0001\u0000\u0000\u0000v\u0010\u0001\u0000\u0000\u0000"+
		"wx\u0005S\u0000\u0000xy\u0005E\u0000\u0000yz\u0005L\u0000\u0000z{\u0005"+
		"E\u0000\u0000{|\u0005C\u0000\u0000|}\u0005T\u0000\u0000}~\u0005I\u0000"+
		"\u0000~\u007f\u0005O\u0000\u0000\u007f\u0096\u0005N\u0000\u0000\u0080"+
		"\u0081\u0005s\u0000\u0000\u0081\u0082\u0005e\u0000\u0000\u0082\u0083\u0005"+
		"l\u0000\u0000\u0083\u0084\u0005e\u0000\u0000\u0084\u0085\u0005c\u0000"+
		"\u0000\u0085\u0086\u0005t\u0000\u0000\u0086\u0087\u0005i\u0000\u0000\u0087"+
		"\u0088\u0005o\u0000\u0000\u0088\u0096\u0005n\u0000\u0000\u0089\u008a\u0005"+
		"S\u0000\u0000\u008a\u008b\u0005E\u0000\u0000\u008b\u008c\u0005L\u0000"+
		"\u0000\u008c\u008d\u0005E\u0000\u0000\u008d\u008e\u0005C\u0000\u0000\u008e"+
		"\u0096\u0005T\u0000\u0000\u008f\u0090\u0005s\u0000\u0000\u0090\u0091\u0005"+
		"e\u0000\u0000\u0091\u0092\u0005l\u0000\u0000\u0092\u0093\u0005e\u0000"+
		"\u0000\u0093\u0094\u0005c\u0000\u0000\u0094\u0096\u0005t\u0000\u0000\u0095"+
		"w\u0001\u0000\u0000\u0000\u0095\u0080\u0001\u0000\u0000\u0000\u0095\u0089"+
		"\u0001\u0000\u0000\u0000\u0095\u008f\u0001\u0000\u0000\u0000\u0096\u0012"+
		"\u0001\u0000\u0000\u0000\u0097\u0098\u0005U\u0000\u0000\u0098\u0099\u0005"+
		"N\u0000\u0000\u0099\u009a\u0005I\u0000\u0000\u009a\u009b\u0005O\u0000"+
		"\u0000\u009b\u00a3\u0005N\u0000\u0000\u009c\u009d\u0005u\u0000\u0000\u009d"+
		"\u009e\u0005n\u0000\u0000\u009e\u009f\u0005i\u0000\u0000\u009f\u00a0\u0005"+
		"o\u0000\u0000\u00a0\u00a3\u0005n\u0000\u0000\u00a1\u00a3\u0005U\u0000"+
		"\u0000\u00a2\u0097\u0001\u0000\u0000\u0000\u00a2\u009c\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a1\u0001\u0000\u0000\u0000\u00a3\u0014\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a5\u0005D\u0000\u0000\u00a5\u00a6\u0005I\u0000\u0000\u00a6"+
		"\u00a7\u0005F\u0000\u0000\u00a7\u00a8\u0005F\u0000\u0000\u00a8\u00a9\u0005"+
		"E\u0000\u0000\u00a9\u00aa\u0005R\u0000\u0000\u00aa\u00ab\u0005E\u0000"+
		"\u0000\u00ab\u00ac\u0005N\u0000\u0000\u00ac\u00ad\u0005C\u0000\u0000\u00ad"+
		"\u00ba\u0005E\u0000\u0000\u00ae\u00af\u0005d\u0000\u0000\u00af\u00b0\u0005"+
		"i\u0000\u0000\u00b0\u00b1\u0005f\u0000\u0000\u00b1\u00b2\u0005f\u0000"+
		"\u0000\u00b2\u00b3\u0005e\u0000\u0000\u00b3\u00b4\u0005r\u0000\u0000\u00b4"+
		"\u00b5\u0005e\u0000\u0000\u00b5\u00b6\u0005n\u0000\u0000\u00b6\u00b7\u0005"+
		"c\u0000\u0000\u00b7\u00ba\u0005e\u0000\u0000\u00b8\u00ba\u0005-\u0000"+
		"\u0000\u00b9\u00a4\u0001\u0000\u0000\u0000\u00b9\u00ae\u0001\u0000\u0000"+
		"\u0000\u00b9\u00b8\u0001\u0000\u0000\u0000\u00ba\u0016\u0001\u0000\u0000"+
		"\u0000\u00bb\u00bc\u0005C\u0000\u0000\u00bc\u00bd\u0005A\u0000\u0000\u00bd"+
		"\u00be\u0005R\u0000\u0000\u00be\u00bf\u0005T\u0000\u0000\u00bf\u00c0\u0005"+
		"E\u0000\u0000\u00c0\u00c1\u0005S\u0000\u0000\u00c1\u00c2\u0005I\u0000"+
		"\u0000\u00c2\u00c3\u0005A\u0000\u0000\u00c3\u00c4\u0005N\u0000\u0000\u00c4"+
		"\u00c5\u0005 \u0000\u0000\u00c5\u00c6\u0005P\u0000\u0000\u00c6\u00c7\u0005"+
		"R\u0000\u0000\u00c7\u00c8\u0005O\u0000\u0000\u00c8\u00c9\u0005D\u0000"+
		"\u0000\u00c9\u00ca\u0005U\u0000\u0000\u00ca\u00cb\u0005C\u0000\u0000\u00cb"+
		"\u00ed\u0005T\u0000\u0000\u00cc\u00cd\u0005c\u0000\u0000\u00cd\u00ce\u0005"+
		"a\u0000\u0000\u00ce\u00cf\u0005r\u0000\u0000\u00cf\u00d0\u0005t\u0000"+
		"\u0000\u00d0\u00d1\u0005e\u0000\u0000\u00d1\u00d2\u0005s\u0000\u0000\u00d2"+
		"\u00d3\u0005i\u0000\u0000\u00d3\u00d4\u0005a\u0000\u0000\u00d4\u00d5\u0005"+
		"n\u0000\u0000\u00d5\u00d6\u0005 \u0000\u0000\u00d6\u00d7\u0005p\u0000"+
		"\u0000\u00d7\u00d8\u0005r\u0000\u0000\u00d8\u00d9\u0005o\u0000\u0000\u00d9"+
		"\u00da\u0005d\u0000\u0000\u00da\u00db\u0005u\u0000\u0000\u00db\u00dc\u0005"+
		"c\u0000\u0000\u00dc\u00ed\u0005t\u0000\u0000\u00dd\u00de\u0005P\u0000"+
		"\u0000\u00de\u00df\u0005R\u0000\u0000\u00df\u00e0\u0005O\u0000\u0000\u00e0"+
		"\u00e1\u0005D\u0000\u0000\u00e1\u00e2\u0005U\u0000\u0000\u00e2\u00e3\u0005"+
		"C\u0000\u0000\u00e3\u00ed\u0005T\u0000\u0000\u00e4\u00e5\u0005p\u0000"+
		"\u0000\u00e5\u00e6\u0005r\u0000\u0000\u00e6\u00e7\u0005o\u0000\u0000\u00e7"+
		"\u00e8\u0005d\u0000\u0000\u00e8\u00e9\u0005u\u0000\u0000\u00e9\u00ea\u0005"+
		"c\u0000\u0000\u00ea\u00ed\u0005t\u0000\u0000\u00eb\u00ed\u0007\u0000\u0000"+
		"\u0000\u00ec\u00bb\u0001\u0000\u0000\u0000\u00ec\u00cc\u0001\u0000\u0000"+
		"\u0000\u00ec\u00dd\u0001\u0000\u0000\u0000\u00ec\u00e4\u0001\u0000\u0000"+
		"\u0000\u00ec\u00eb\u0001\u0000\u0000\u0000\u00ed\u0018\u0001\u0000\u0000"+
		"\u0000\u00ee\u00ef\u0005I\u0000\u0000\u00ef\u00f0\u0005N\u0000\u0000\u00f0"+
		"\u00f1\u0005T\u0000\u0000\u00f1\u00f2\u0005E\u0000\u0000\u00f2\u00f3\u0005"+
		"R\u0000\u0000\u00f3\u00f4\u0005S\u0000\u0000\u00f4\u00f5\u0005E\u0000"+
		"\u0000\u00f5\u00f6\u0005C\u0000\u0000\u00f6\u00f7\u0005T\u0000\u0000\u00f7"+
		"\u00f8\u0005I\u0000\u0000\u00f8\u00f9\u0005O\u0000\u0000\u00f9\u011a\u0005"+
		"N\u0000\u0000\u00fa\u00fb\u0005i\u0000\u0000\u00fb\u00fc\u0005n\u0000"+
		"\u0000\u00fc\u00fd\u0005t\u0000\u0000\u00fd\u00fe\u0005e\u0000\u0000\u00fe"+
		"\u00ff\u0005r\u0000\u0000\u00ff\u0100\u0005s\u0000\u0000\u0100\u0101\u0005"+
		"e\u0000\u0000\u0101\u0102\u0005c\u0000\u0000\u0102\u0103\u0005t\u0000"+
		"\u0000\u0103\u0104\u0005i\u0000\u0000\u0104\u0105\u0005o\u0000\u0000\u0105"+
		"\u011a\u0005n\u0000\u0000\u0106\u0107\u0005I\u0000\u0000\u0107\u0108\u0005"+
		"N\u0000\u0000\u0108\u0109\u0005T\u0000\u0000\u0109\u010a\u0005E\u0000"+
		"\u0000\u010a\u010b\u0005R\u0000\u0000\u010b\u010c\u0005S\u0000\u0000\u010c"+
		"\u010d\u0005E\u0000\u0000\u010d\u010e\u0005C\u0000\u0000\u010e\u011a\u0005"+
		"T\u0000\u0000\u010f\u0110\u0005i\u0000\u0000\u0110\u0111\u0005n\u0000"+
		"\u0000\u0111\u0112\u0005t\u0000\u0000\u0112\u0113\u0005e\u0000\u0000\u0113"+
		"\u0114\u0005r\u0000\u0000\u0114\u0115\u0005s\u0000\u0000\u0115\u0116\u0005"+
		"e\u0000\u0000\u0116\u0117\u0005c\u0000\u0000\u0117\u011a\u0005t\u0000"+
		"\u0000\u0118\u011a\u0005\u2229\u0000\u0000\u0119\u00ee\u0001\u0000\u0000"+
		"\u0000\u0119\u00fa\u0001\u0000\u0000\u0000\u0119\u0106\u0001\u0000\u0000"+
		"\u0000\u0119\u010f\u0001\u0000\u0000\u0000\u0119\u0118\u0001\u0000\u0000"+
		"\u0000\u011a\u001a\u0001\u0000\u0000\u0000\u011b\u011c\u0005N\u0000\u0000"+
		"\u011c\u011d\u0005A\u0000\u0000\u011d\u011e\u0005T\u0000\u0000\u011e\u011f"+
		"\u0005U\u0000\u0000\u011f\u0120\u0005R\u0000\u0000\u0120\u0121\u0005A"+
		"\u0000\u0000\u0121\u0122\u0005L\u0000\u0000\u0122\u0123\u0005 \u0000\u0000"+
		"\u0123\u0124\u0005J\u0000\u0000\u0124\u0125\u0005O\u0000\u0000\u0125\u0126"+
		"\u0005I\u0000\u0000\u0126\u013f\u0005N\u0000\u0000\u0127\u0128\u0005N"+
		"\u0000\u0000\u0128\u0129\u0005J\u0000\u0000\u0129\u012a\u0005O\u0000\u0000"+
		"\u012a\u012b\u0005I\u0000\u0000\u012b\u013f\u0005N\u0000\u0000\u012c\u012d"+
		"\u0005n\u0000\u0000\u012d\u012e\u0005a\u0000\u0000\u012e\u012f\u0005t"+
		"\u0000\u0000\u012f\u0130\u0005u\u0000\u0000\u0130\u0131\u0005r\u0000\u0000"+
		"\u0131\u0132\u0005a\u0000\u0000\u0132\u0133\u0005l\u0000\u0000\u0133\u0134"+
		"\u0005 \u0000\u0000\u0134\u0135\u0005j\u0000\u0000\u0135\u0136\u0005o"+
		"\u0000\u0000\u0136\u0137\u0005i\u0000\u0000\u0137\u013f\u0005n\u0000\u0000"+
		"\u0138\u0139\u0005n\u0000\u0000\u0139\u013a\u0005j\u0000\u0000\u013a\u013b"+
		"\u0005o\u0000\u0000\u013b\u013c\u0005i\u0000\u0000\u013c\u013f\u0005n"+
		"\u0000\u0000\u013d\u013f\u0005*\u0000\u0000\u013e\u011b\u0001\u0000\u0000"+
		"\u0000\u013e\u0127\u0001\u0000\u0000\u0000\u013e\u012c\u0001\u0000\u0000"+
		"\u0000\u013e\u0138\u0001\u0000\u0000\u0000\u013e\u013d\u0001\u0000\u0000"+
		"\u0000\u013f\u001c\u0001\u0000\u0000\u0000\u0140\u0141\u0005J\u0000\u0000"+
		"\u0141\u0142\u0005O\u0000\u0000\u0142\u0143\u0005I\u0000\u0000\u0143\u014a"+
		"\u0005N\u0000\u0000\u0144\u0145\u0005j\u0000\u0000\u0145\u0146\u0005o"+
		"\u0000\u0000\u0146\u0147\u0005i\u0000\u0000\u0147\u014a\u0005n\u0000\u0000"+
		"\u0148\u014a\u0007\u0001\u0000\u0000\u0149\u0140\u0001\u0000\u0000\u0000"+
		"\u0149\u0144\u0001\u0000\u0000\u0000\u0149\u0148\u0001\u0000\u0000\u0000"+
		"\u014a\u001e\u0001\u0000\u0000\u0000\u014b\u014c\u0005D\u0000\u0000\u014c"+
		"\u014d\u0005I\u0000\u0000\u014d\u014e\u0005V\u0000\u0000\u014e\u014f\u0005"+
		"I\u0000\u0000\u014f\u0150\u0005S\u0000\u0000\u0150\u0151\u0005I\u0000"+
		"\u0000\u0151\u0152\u0005O\u0000\u0000\u0152\u015d\u0005N\u0000\u0000\u0153"+
		"\u0154\u0005d\u0000\u0000\u0154\u0155\u0005i\u0000\u0000\u0155\u0156\u0005"+
		"v\u0000\u0000\u0156\u0157\u0005i\u0000\u0000\u0157\u0158\u0005s\u0000"+
		"\u0000\u0158\u0159\u0005i\u0000\u0000\u0159\u015a\u0005o\u0000\u0000\u015a"+
		"\u015d\u0005n\u0000\u0000\u015b\u015d\u0007\u0002\u0000\u0000\u015c\u014b"+
		"\u0001\u0000\u0000\u0000\u015c\u0153\u0001\u0000\u0000\u0000\u015c\u015b"+
		"\u0001\u0000\u0000\u0000\u015d \u0001\u0000\u0000\u0000\u015e\u015f\u0005"+
		"=\u0000\u0000\u015f\"\u0001\u0000\u0000\u0000\u0160\u0161\u0005!\u0000"+
		"\u0000\u0161\u0165\u0005=\u0000\u0000\u0162\u0163\u0005<\u0000\u0000\u0163"+
		"\u0165\u0005>\u0000\u0000\u0164\u0160\u0001\u0000\u0000\u0000\u0164\u0162"+
		"\u0001\u0000\u0000\u0000\u0165$\u0001\u0000\u0000\u0000\u0166\u0167\u0005"+
		">\u0000\u0000\u0167&\u0001\u0000\u0000\u0000\u0168\u0169\u0005>\u0000"+
		"\u0000\u0169\u016a\u0005=\u0000\u0000\u016a(\u0001\u0000\u0000\u0000\u016b"+
		"\u016c\u0005<\u0000\u0000\u016c*\u0001\u0000\u0000\u0000\u016d\u016e\u0005"+
		"<\u0000\u0000\u016e\u016f\u0005=\u0000\u0000\u016f,\u0001\u0000\u0000"+
		"\u0000\u0170\u0171\u0005A\u0000\u0000\u0171\u0172\u0005N\u0000\u0000\u0172"+
		"\u0178\u0005D\u0000\u0000\u0173\u0174\u0005a\u0000\u0000\u0174\u0175\u0005"+
		"n\u0000\u0000\u0175\u0178\u0005d\u0000\u0000\u0176\u0178\u0007\u0003\u0000"+
		"\u0000\u0177\u0170\u0001\u0000\u0000\u0000\u0177\u0173\u0001\u0000\u0000"+
		"\u0000\u0177\u0176\u0001\u0000\u0000\u0000\u0178.\u0001\u0000\u0000\u0000"+
		"\u0179\u017a\u0005O\u0000\u0000\u017a\u017f\u0005R\u0000\u0000\u017b\u017c"+
		"\u0005o\u0000\u0000\u017c\u017f\u0005r\u0000\u0000\u017d\u017f\u0007\u0004"+
		"\u0000\u0000\u017e\u0179\u0001\u0000\u0000\u0000\u017e\u017b\u0001\u0000"+
		"\u0000\u0000\u017e\u017d\u0001\u0000\u0000\u0000\u017f0\u0001\u0000\u0000"+
		"\u0000\u0180\u0181\u0005N\u0000\u0000\u0181\u0182\u0005O\u0000\u0000\u0182"+
		"\u0188\u0005T\u0000\u0000\u0183\u0184\u0005n\u0000\u0000\u0184\u0185\u0005"+
		"o\u0000\u0000\u0185\u0188\u0005t\u0000\u0000\u0186\u0188\u0005~\u0000"+
		"\u0000\u0187\u0180\u0001\u0000\u0000\u0000\u0187\u0183\u0001\u0000\u0000"+
		"\u0000\u0187\u0186\u0001\u0000\u0000\u0000\u01882\u0001\u0000\u0000\u0000"+
		"\u0189\u018d\u0005\"\u0000\u0000\u018a\u018c\t\u0000\u0000\u0000\u018b"+
		"\u018a\u0001\u0000\u0000\u0000\u018c\u018f\u0001\u0000\u0000\u0000\u018d"+
		"\u018e\u0001\u0000\u0000\u0000\u018d\u018b\u0001\u0000\u0000\u0000\u018e"+
		"\u0190\u0001\u0000\u0000\u0000\u018f\u018d\u0001\u0000\u0000\u0000\u0190"+
		"\u019a\u0005\"\u0000\u0000\u0191\u0195\u0005\'\u0000\u0000\u0192\u0194"+
		"\t\u0000\u0000\u0000\u0193\u0192\u0001\u0000\u0000\u0000\u0194\u0197\u0001"+
		"\u0000\u0000\u0000\u0195\u0196\u0001\u0000\u0000\u0000\u0195\u0193\u0001"+
		"\u0000\u0000\u0000\u0196\u0198\u0001\u0000\u0000\u0000\u0197\u0195\u0001"+
		"\u0000\u0000\u0000\u0198\u019a\u0005\'\u0000\u0000\u0199\u0189\u0001\u0000"+
		"\u0000\u0000\u0199\u0191\u0001\u0000\u0000\u0000\u019a4\u0001\u0000\u0000"+
		"\u0000\u019b\u019d\u0007\u0005\u0000\u0000\u019c\u019b\u0001\u0000\u0000"+
		"\u0000\u019d\u019e\u0001\u0000\u0000\u0000\u019e\u019c\u0001\u0000\u0000"+
		"\u0000\u019e\u019f\u0001\u0000\u0000\u0000\u019f\u01a3\u0001\u0000\u0000"+
		"\u0000\u01a0\u01a2\u0007\u0006\u0000\u0000\u01a1\u01a0\u0001\u0000\u0000"+
		"\u0000\u01a2\u01a5\u0001\u0000\u0000\u0000\u01a3\u01a1\u0001\u0000\u0000"+
		"\u0000\u01a3\u01a4\u0001\u0000\u0000\u0000\u01a4\u01b6\u0001\u0000\u0000"+
		"\u0000\u01a5\u01a3\u0001\u0000\u0000\u0000\u01a6\u01b2\u0005.\u0000\u0000"+
		"\u01a7\u01a9\u0007\u0005\u0000\u0000\u01a8\u01a7\u0001\u0000\u0000\u0000"+
		"\u01a9\u01aa\u0001\u0000\u0000\u0000\u01aa\u01a8\u0001\u0000\u0000\u0000"+
		"\u01aa\u01ab\u0001\u0000\u0000\u0000\u01ab\u01af\u0001\u0000\u0000\u0000"+
		"\u01ac\u01ae\u0007\u0006\u0000\u0000\u01ad\u01ac\u0001\u0000\u0000\u0000"+
		"\u01ae\u01b1\u0001\u0000\u0000\u0000\u01af\u01ad\u0001\u0000\u0000\u0000"+
		"\u01af\u01b0\u0001\u0000\u0000\u0000\u01b0\u01b3\u0001\u0000\u0000\u0000"+
		"\u01b1\u01af\u0001\u0000\u0000\u0000\u01b2\u01a8\u0001\u0000\u0000\u0000"+
		"\u01b3\u01b4\u0001\u0000\u0000\u0000\u01b4\u01b2\u0001\u0000\u0000\u0000"+
		"\u01b4\u01b5\u0001\u0000\u0000\u0000\u01b5\u01b7\u0001\u0000\u0000\u0000"+
		"\u01b6\u01a6\u0001\u0000\u0000\u0000\u01b6\u01b7\u0001\u0000\u0000\u0000"+
		"\u01b76\u0001\u0000\u0000\u0000\u01b8\u01ba\u0007\u0007\u0000\u0000\u01b9"+
		"\u01b8\u0001\u0000\u0000\u0000\u01ba\u01bb\u0001\u0000\u0000\u0000\u01bb"+
		"\u01b9\u0001\u0000\u0000\u0000\u01bb\u01bc\u0001\u0000\u0000\u0000\u01bc"+
		"8\u0001\u0000\u0000\u0000\u01bd\u01bf\u0005-\u0000\u0000\u01be\u01bd\u0001"+
		"\u0000\u0000\u0000\u01be\u01bf\u0001\u0000\u0000\u0000\u01bf\u01c1\u0001"+
		"\u0000\u0000\u0000\u01c0\u01c2\u0007\u0007\u0000\u0000\u01c1\u01c0\u0001"+
		"\u0000\u0000\u0000\u01c2\u01c3\u0001\u0000\u0000\u0000\u01c3\u01c1\u0001"+
		"\u0000\u0000\u0000\u01c3\u01c4\u0001\u0000\u0000\u0000\u01c4\u01cb\u0001"+
		"\u0000\u0000\u0000\u01c5\u01c7\u0005.\u0000\u0000\u01c6\u01c8\u0007\u0007"+
		"\u0000\u0000\u01c7\u01c6\u0001\u0000\u0000\u0000\u01c8\u01c9\u0001\u0000"+
		"\u0000\u0000\u01c9\u01c7\u0001\u0000\u0000\u0000\u01c9\u01ca\u0001\u0000"+
		"\u0000\u0000\u01ca\u01cc\u0001\u0000\u0000\u0000\u01cb\u01c5\u0001\u0000"+
		"\u0000\u0000\u01cb\u01cc\u0001\u0000\u0000\u0000\u01cc:\u0001\u0000\u0000"+
		"\u0000\u01cd\u01ce\u0007\b\u0000\u0000\u01ce<\u0001\u0000\u0000\u0000"+
		"\u01cf\u01d1\u0007\t\u0000\u0000\u01d0\u01cf\u0001\u0000\u0000\u0000\u01d1"+
		"\u01d2\u0001\u0000\u0000\u0000\u01d2\u01d0\u0001\u0000\u0000\u0000\u01d2"+
		"\u01d3\u0001\u0000\u0000\u0000\u01d3\u01d4\u0001\u0000\u0000\u0000\u01d4"+
		"\u01d5\u0006\u001e\u0000\u0000\u01d5>\u0001\u0000\u0000\u0000\u01d6\u01d7"+
		"\u0005/\u0000\u0000\u01d7\u01d8\u0005*\u0000\u0000\u01d8\u01dc\u0001\u0000"+
		"\u0000\u0000\u01d9\u01db\t\u0000\u0000\u0000\u01da\u01d9\u0001\u0000\u0000"+
		"\u0000\u01db\u01de\u0001\u0000\u0000\u0000\u01dc\u01dd\u0001\u0000\u0000"+
		"\u0000\u01dc\u01da\u0001\u0000\u0000\u0000\u01dd\u01df\u0001\u0000\u0000"+
		"\u0000\u01de\u01dc\u0001\u0000\u0000\u0000\u01df\u01e0\u0005*\u0000\u0000"+
		"\u01e0\u01e1\u0005/\u0000\u0000\u01e1\u01e2\u0001\u0000\u0000\u0000\u01e2"+
		"\u01e3\u0006\u001f\u0001\u0000\u01e3@\u0001\u0000\u0000\u0000\u01e4\u01e5"+
		"\u0005/\u0000\u0000\u01e5\u01e6\u0005/\u0000\u0000\u01e6\u01ea\u0001\u0000"+
		"\u0000\u0000\u01e7\u01e9\b\n\u0000\u0000\u01e8\u01e7\u0001\u0000\u0000"+
		"\u0000\u01e9\u01ec\u0001\u0000\u0000\u0000\u01ea\u01e8\u0001\u0000\u0000"+
		"\u0000\u01ea\u01eb\u0001\u0000\u0000\u0000\u01eb\u01ed\u0001\u0000\u0000"+
		"\u0000\u01ec\u01ea\u0001\u0000\u0000\u0000\u01ed\u01ee\u0006 \u0001\u0000"+
		"\u01eeB\u0001\u0000\u0000\u0000!\u0000u\u0095\u00a2\u00b9\u00ec\u0119"+
		"\u013e\u0149\u015c\u0164\u0177\u017e\u0187\u018d\u0195\u0199\u019e\u01a1"+
		"\u01a3\u01aa\u01ad\u01af\u01b4\u01b6\u01bb\u01be\u01c3\u01c9\u01cb\u01d2"+
		"\u01dc\u01ea\u0002\u0006\u0000\u0000\u0000\u0001\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}