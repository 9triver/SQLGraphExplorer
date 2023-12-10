// Generated from D:/Antlr-SQLGraphExplorer/SQLGraphExplorer/src/main/java/cn/edu/nju/expression/cktuple/constraint/grammar/ConditionLexer.g4 by ANTLR 4.13.1
package grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ConditionLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AND=1, OR=2, NOT=3, TRUE=4, FALSE=5, GT=6, GE=7, LT=8, LE=9, EQ=10, LPAREN=11, 
		RPAREN=12, COMMA=13, DOT=14, DECIMAL=15, IDENTIFIER=16, PUNCTUATION=17, 
		WS=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", "LPAREN", 
			"RPAREN", "COMMA", "DOT", "DECIMAL", "IDENTIFIER", "PUNCTUATION", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'AND'", "'OR'", "'NOT'", "'TRUE'", "'FALSE'", "'>'", "'>='", "'<'", 
			"'<='", "'='", "'('", "')'", "','", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", 
			"LPAREN", "RPAREN", "COMMA", "DOT", "DECIMAL", "IDENTIFIER", "PUNCTUATION", 
			"WS"
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


	public ConditionLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ConditionLexer.g4"; }

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
		"\u0004\u0000\u0012u\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0003\u000eQ\b\u000e\u0001\u000e"+
		"\u0004\u000eT\b\u000e\u000b\u000e\f\u000eU\u0001\u000e\u0001\u000e\u0004"+
		"\u000eZ\b\u000e\u000b\u000e\f\u000e[\u0003\u000e^\b\u000e\u0001\u000f"+
		"\u0001\u000f\u0005\u000fb\b\u000f\n\u000f\f\u000fe\t\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010"+
		"m\b\u0010\u0001\u0011\u0004\u0011p\b\u0011\u000b\u0011\f\u0011q\u0001"+
		"\u0011\u0001\u0011\u0000\u0000\u0012\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015"+
		"\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012"+
		"\u0001\u0000\u0011\u0002\u0000AAaa\u0002\u0000NNnn\u0002\u0000DDdd\u0002"+
		"\u0000OOoo\u0002\u0000RRrr\u0002\u0000TTtt\u0002\u0000UUuu\u0002\u0000"+
		"EEee\u0002\u0000FFff\u0002\u0000LLll\u0002\u0000SSss\u0001\u000009\u0003"+
		"\u0000AZ__az\u0004\u000009AZ__az\u0007\u0000#\'*+--//;;@@[^\u0003\u0000"+
		"``{{}~\u0003\u0000\t\n\f\r  \u007f\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f"+
		"\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000"+
		"\u0000\u0000\u0001%\u0001\u0000\u0000\u0000\u0003)\u0001\u0000\u0000\u0000"+
		"\u0005,\u0001\u0000\u0000\u0000\u00070\u0001\u0000\u0000\u0000\t5\u0001"+
		"\u0000\u0000\u0000\u000b;\u0001\u0000\u0000\u0000\r=\u0001\u0000\u0000"+
		"\u0000\u000f@\u0001\u0000\u0000\u0000\u0011B\u0001\u0000\u0000\u0000\u0013"+
		"E\u0001\u0000\u0000\u0000\u0015G\u0001\u0000\u0000\u0000\u0017I\u0001"+
		"\u0000\u0000\u0000\u0019K\u0001\u0000\u0000\u0000\u001bM\u0001\u0000\u0000"+
		"\u0000\u001dP\u0001\u0000\u0000\u0000\u001f_\u0001\u0000\u0000\u0000!"+
		"l\u0001\u0000\u0000\u0000#o\u0001\u0000\u0000\u0000%&\u0007\u0000\u0000"+
		"\u0000&\'\u0007\u0001\u0000\u0000\'(\u0007\u0002\u0000\u0000(\u0002\u0001"+
		"\u0000\u0000\u0000)*\u0007\u0003\u0000\u0000*+\u0007\u0004\u0000\u0000"+
		"+\u0004\u0001\u0000\u0000\u0000,-\u0007\u0001\u0000\u0000-.\u0007\u0003"+
		"\u0000\u0000./\u0007\u0005\u0000\u0000/\u0006\u0001\u0000\u0000\u0000"+
		"01\u0007\u0005\u0000\u000012\u0007\u0004\u0000\u000023\u0007\u0006\u0000"+
		"\u000034\u0007\u0007\u0000\u00004\b\u0001\u0000\u0000\u000056\u0007\b"+
		"\u0000\u000067\u0007\u0000\u0000\u000078\u0007\t\u0000\u000089\u0007\n"+
		"\u0000\u00009:\u0007\u0007\u0000\u0000:\n\u0001\u0000\u0000\u0000;<\u0005"+
		">\u0000\u0000<\f\u0001\u0000\u0000\u0000=>\u0005>\u0000\u0000>?\u0005"+
		"=\u0000\u0000?\u000e\u0001\u0000\u0000\u0000@A\u0005<\u0000\u0000A\u0010"+
		"\u0001\u0000\u0000\u0000BC\u0005<\u0000\u0000CD\u0005=\u0000\u0000D\u0012"+
		"\u0001\u0000\u0000\u0000EF\u0005=\u0000\u0000F\u0014\u0001\u0000\u0000"+
		"\u0000GH\u0005(\u0000\u0000H\u0016\u0001\u0000\u0000\u0000IJ\u0005)\u0000"+
		"\u0000J\u0018\u0001\u0000\u0000\u0000KL\u0005,\u0000\u0000L\u001a\u0001"+
		"\u0000\u0000\u0000MN\u0005.\u0000\u0000N\u001c\u0001\u0000\u0000\u0000"+
		"OQ\u0005-\u0000\u0000PO\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000"+
		"QS\u0001\u0000\u0000\u0000RT\u0007\u000b\u0000\u0000SR\u0001\u0000\u0000"+
		"\u0000TU\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UV\u0001\u0000"+
		"\u0000\u0000V]\u0001\u0000\u0000\u0000WY\u0005.\u0000\u0000XZ\u0007\u000b"+
		"\u0000\u0000YX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[Y\u0001"+
		"\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\^\u0001\u0000\u0000\u0000"+
		"]W\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^\u001e\u0001\u0000"+
		"\u0000\u0000_c\u0007\f\u0000\u0000`b\u0007\r\u0000\u0000a`\u0001\u0000"+
		"\u0000\u0000be\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000cd\u0001"+
		"\u0000\u0000\u0000d \u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000"+
		"fm\u0003\u0019\f\u0000gm\u0003\u001b\r\u0000hm\u0007\u000e\u0000\u0000"+
		"im\u0003\u0015\n\u0000jm\u0003\u0017\u000b\u0000km\u0007\u000f\u0000\u0000"+
		"lf\u0001\u0000\u0000\u0000lg\u0001\u0000\u0000\u0000lh\u0001\u0000\u0000"+
		"\u0000li\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000lk\u0001\u0000"+
		"\u0000\u0000m\"\u0001\u0000\u0000\u0000np\u0007\u0010\u0000\u0000on\u0001"+
		"\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000"+
		"qr\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000st\u0006\u0011\u0000"+
		"\u0000t$\u0001\u0000\u0000\u0000\b\u0000PU[]clq\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}