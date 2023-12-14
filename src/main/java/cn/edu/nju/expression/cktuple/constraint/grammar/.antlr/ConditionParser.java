// Generated from d:/Antlr-SQLGraphExplorer/SQLGraphExplorer/src/main/java/cn/edu/nju/expression/cktuple/constraint/grammar/ConditionParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ConditionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AND=1, OR=2, NOT=3, TRUE=4, FALSE=5, GT=6, GE=7, LT=8, LE=9, EQ=10, LPAREN=11, 
		RPAREN=12, COMMA=13, DOT=14, DECIMAL=15, IDENTIFIER=16, PUNCTUATION=17, 
		WS=18;
	public static final int
		RULE_parse = 0, RULE_expression = 1, RULE_notParenExpression = 2, RULE_parenExpression = 3, 
		RULE_notExpression = 4, RULE_andExpression = 5, RULE_orExpression = 6, 
		RULE_basicExpression = 7, RULE_funcExpression = 8, RULE_colExpression = 9, 
		RULE_functionName = 10, RULE_trueExpression = 11, RULE_falseExpression = 12, 
		RULE_comparator = 13, RULE_atom = 14, RULE_bool = 15, RULE_identifer = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "expression", "notParenExpression", "parenExpression", "notExpression", 
			"andExpression", "orExpression", "basicExpression", "funcExpression", 
			"colExpression", "functionName", "trueExpression", "falseExpression", 
			"comparator", "atom", "bool", "identifer"
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

	@Override
	public String getGrammarFileName() { return "ConditionParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ConditionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParseContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ConditionParser.EOF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitParse(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(34);
				expression();
				}
				break;
			}
			setState(37);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ParenExpressionContext parenExpression() {
			return getRuleContext(ParenExpressionContext.class,0);
		}
		public NotParenExpressionContext notParenExpression() {
			return getRuleContext(NotParenExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expression);
		try {
			setState(42);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				parenExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(41);
				notParenExpression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class NotParenExpressionContext extends ParserRuleContext {
		public NotParenExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notParenExpression; }
	 
		public NotParenExpressionContext() { }
		public void copyFrom(NotParenExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrAllExpressionContext extends NotParenExpressionContext {
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public OrAllExpressionContext(NotParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterOrAllExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitOrAllExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndDistributiveLawExpressionContext extends NotParenExpressionContext {
		public OrExpressionContext leftOr;
		public OrExpressionContext rightOr;
		public ParenExpressionContext leftBasic;
		public ParenExpressionContext rightBasic;
		public TerminalNode AND() { return getToken(ConditionParser.AND, 0); }
		public List<OrExpressionContext> orExpression() {
			return getRuleContexts(OrExpressionContext.class);
		}
		public OrExpressionContext orExpression(int i) {
			return getRuleContext(OrExpressionContext.class,i);
		}
		public ParenExpressionContext parenExpression() {
			return getRuleContext(ParenExpressionContext.class,0);
		}
		public AndDistributiveLawExpressionContext(NotParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterAndDistributiveLawExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitAndDistributiveLawExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AnnulmentLawExpressionContext extends NotParenExpressionContext {
		public ParenExpressionContext parenExpression() {
			return getRuleContext(ParenExpressionContext.class,0);
		}
		public TerminalNode AND() { return getToken(ConditionParser.AND, 0); }
		public FalseExpressionContext falseExpression() {
			return getRuleContext(FalseExpressionContext.class,0);
		}
		public TerminalNode OR() { return getToken(ConditionParser.OR, 0); }
		public TrueExpressionContext trueExpression() {
			return getRuleContext(TrueExpressionContext.class,0);
		}
		public AnnulmentLawExpressionContext(NotParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterAnnulmentLawExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitAnnulmentLawExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentityLawExpressionContext extends NotParenExpressionContext {
		public ParenExpressionContext parenExpression() {
			return getRuleContext(ParenExpressionContext.class,0);
		}
		public TerminalNode OR() { return getToken(ConditionParser.OR, 0); }
		public FalseExpressionContext falseExpression() {
			return getRuleContext(FalseExpressionContext.class,0);
		}
		public TerminalNode AND() { return getToken(ConditionParser.AND, 0); }
		public TrueExpressionContext trueExpression() {
			return getRuleContext(TrueExpressionContext.class,0);
		}
		public IdentityLawExpressionContext(NotParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterIdentityLawExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitIdentityLawExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndAllExpressionContext extends NotParenExpressionContext {
		public AndExpressionContext andExpression() {
			return getRuleContext(AndExpressionContext.class,0);
		}
		public AndAllExpressionContext(NotParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterAndAllExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitAndAllExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrBasicExpressionContext extends NotParenExpressionContext {
		public List<ParenExpressionContext> parenExpression() {
			return getRuleContexts(ParenExpressionContext.class);
		}
		public ParenExpressionContext parenExpression(int i) {
			return getRuleContext(ParenExpressionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(ConditionParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(ConditionParser.OR, i);
		}
		public OrBasicExpressionContext(NotParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterOrBasicExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitOrBasicExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotsExpressionContext extends NotParenExpressionContext {
		public NotExpressionContext notExpression() {
			return getRuleContext(NotExpressionContext.class,0);
		}
		public NotsExpressionContext(NotParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterNotsExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitNotsExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BasicBlockExpressionContext extends NotParenExpressionContext {
		public BasicExpressionContext basicExpression() {
			return getRuleContext(BasicExpressionContext.class,0);
		}
		public BasicBlockExpressionContext(NotParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterBasicBlockExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitBasicBlockExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndBasicExpressionContext extends NotParenExpressionContext {
		public List<ParenExpressionContext> parenExpression() {
			return getRuleContexts(ParenExpressionContext.class);
		}
		public ParenExpressionContext parenExpression(int i) {
			return getRuleContext(ParenExpressionContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(ConditionParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(ConditionParser.AND, i);
		}
		public AndBasicExpressionContext(NotParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterAndBasicExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitAndBasicExpression(this);
		}
	}

	public final NotParenExpressionContext notParenExpression() throws RecognitionException {
		NotParenExpressionContext _localctx = new NotParenExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_notParenExpression);
		int _la;
		try {
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new AnnulmentLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				parenExpression();
				setState(45);
				match(AND);
				setState(46);
				falseExpression();
				}
				break;
			case 2:
				_localctx = new AnnulmentLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				falseExpression();
				setState(49);
				match(AND);
				setState(50);
				parenExpression();
				}
				break;
			case 3:
				_localctx = new AnnulmentLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(52);
				parenExpression();
				setState(53);
				match(OR);
				setState(54);
				trueExpression();
				}
				break;
			case 4:
				_localctx = new AnnulmentLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(56);
				trueExpression();
				setState(57);
				match(OR);
				setState(58);
				parenExpression();
				}
				break;
			case 5:
				_localctx = new IdentityLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(60);
				parenExpression();
				setState(61);
				match(OR);
				setState(62);
				falseExpression();
				}
				break;
			case 6:
				_localctx = new IdentityLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(64);
				falseExpression();
				setState(65);
				match(OR);
				setState(66);
				parenExpression();
				}
				break;
			case 7:
				_localctx = new IdentityLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(68);
				parenExpression();
				setState(69);
				match(AND);
				setState(70);
				trueExpression();
				}
				break;
			case 8:
				_localctx = new IdentityLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(72);
				trueExpression();
				setState(73);
				match(AND);
				setState(74);
				parenExpression();
				}
				break;
			case 9:
				_localctx = new AndDistributiveLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(76);
				((AndDistributiveLawExpressionContext)_localctx).leftOr = orExpression();
				setState(77);
				match(AND);
				setState(78);
				((AndDistributiveLawExpressionContext)_localctx).rightOr = orExpression();
				}
				break;
			case 10:
				_localctx = new AndDistributiveLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(80);
				((AndDistributiveLawExpressionContext)_localctx).leftBasic = parenExpression();
				setState(81);
				match(AND);
				setState(82);
				((AndDistributiveLawExpressionContext)_localctx).rightOr = orExpression();
				}
				break;
			case 11:
				_localctx = new AndDistributiveLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(84);
				((AndDistributiveLawExpressionContext)_localctx).leftOr = orExpression();
				setState(85);
				match(AND);
				setState(86);
				((AndDistributiveLawExpressionContext)_localctx).rightBasic = parenExpression();
				}
				break;
			case 12:
				_localctx = new AndAllExpressionContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(88);
				andExpression();
				}
				break;
			case 13:
				_localctx = new OrAllExpressionContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(89);
				orExpression();
				}
				break;
			case 14:
				_localctx = new AndBasicExpressionContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(90);
				parenExpression();
				setState(93); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(91);
					match(AND);
					setState(92);
					parenExpression();
					}
					}
					setState(95); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==AND );
				}
				break;
			case 15:
				_localctx = new OrBasicExpressionContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(97);
				parenExpression();
				setState(100); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(98);
					match(OR);
					setState(99);
					parenExpression();
					}
					}
					setState(102); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==OR );
				}
				break;
			case 16:
				_localctx = new NotsExpressionContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(104);
				notExpression();
				}
				break;
			case 17:
				_localctx = new BasicBlockExpressionContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(105);
				basicExpression(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParenExpressionContext extends ParserRuleContext {
		public ParenExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenExpression; }
	 
		public ParenExpressionContext() { }
		public void copyFrom(ParenExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiParenExpressionContext extends ParenExpressionContext {
		public TerminalNode LPAREN() { return getToken(ConditionParser.LPAREN, 0); }
		public ParenExpressionContext parenExpression() {
			return getRuleContext(ParenExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ConditionParser.RPAREN, 0); }
		public MultiParenExpressionContext(ParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterMultiParenExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitMultiParenExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleParenExpressionContext extends ParenExpressionContext {
		public TerminalNode LPAREN() { return getToken(ConditionParser.LPAREN, 0); }
		public NotParenExpressionContext notParenExpression() {
			return getRuleContext(NotParenExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ConditionParser.RPAREN, 0); }
		public SingleParenExpressionContext(ParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterSingleParenExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitSingleParenExpression(this);
		}
	}

	public final ParenExpressionContext parenExpression() throws RecognitionException {
		ParenExpressionContext _localctx = new ParenExpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_parenExpression);
		try {
			setState(116);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new MultiParenExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				match(LPAREN);
				setState(109);
				parenExpression();
				setState(110);
				match(RPAREN);
				}
				break;
			case 2:
				_localctx = new SingleParenExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				match(LPAREN);
				setState(113);
				notParenExpression();
				setState(114);
				match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class NotExpressionContext extends ParserRuleContext {
		public NotExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notExpression; }
	 
		public NotExpressionContext() { }
		public void copyFrom(NotExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndDeMorganLawExpressionContext extends NotExpressionContext {
		public TerminalNode NOT() { return getToken(ConditionParser.NOT, 0); }
		public AndExpressionContext andExpression() {
			return getRuleContext(AndExpressionContext.class,0);
		}
		public AndDeMorganLawExpressionContext(NotExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterAndDeMorganLawExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitAndDeMorganLawExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InvolutionLawExpressionContext extends NotExpressionContext {
		public List<TerminalNode> NOT() { return getTokens(ConditionParser.NOT); }
		public TerminalNode NOT(int i) {
			return getToken(ConditionParser.NOT, i);
		}
		public ParenExpressionContext parenExpression() {
			return getRuleContext(ParenExpressionContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(ConditionParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ConditionParser.RPAREN, 0); }
		public InvolutionLawExpressionContext(NotExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterInvolutionLawExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitInvolutionLawExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleNotExpressionContext extends NotExpressionContext {
		public TerminalNode NOT() { return getToken(ConditionParser.NOT, 0); }
		public ParenExpressionContext parenExpression() {
			return getRuleContext(ParenExpressionContext.class,0);
		}
		public SingleNotExpressionContext(NotExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterSingleNotExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitSingleNotExpression(this);
		}
	}

	public final NotExpressionContext notExpression() throws RecognitionException {
		NotExpressionContext _localctx = new NotExpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_notExpression);
		try {
			setState(131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new AndDeMorganLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				match(NOT);
				setState(119);
				andExpression();
				}
				break;
			case 2:
				_localctx = new InvolutionLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				match(NOT);
				setState(121);
				match(NOT);
				setState(122);
				parenExpression();
				}
				break;
			case 3:
				_localctx = new InvolutionLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(123);
				match(NOT);
				setState(124);
				match(LPAREN);
				setState(125);
				match(NOT);
				setState(126);
				parenExpression();
				setState(127);
				match(RPAREN);
				}
				break;
			case 4:
				_localctx = new SingleNotExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(129);
				match(NOT);
				setState(130);
				parenExpression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AndExpressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(ConditionParser.LPAREN, 0); }
		public List<ParenExpressionContext> parenExpression() {
			return getRuleContexts(ParenExpressionContext.class);
		}
		public ParenExpressionContext parenExpression(int i) {
			return getRuleContext(ParenExpressionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ConditionParser.RPAREN, 0); }
		public List<TerminalNode> AND() { return getTokens(ConditionParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(ConditionParser.AND, i);
		}
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitAndExpression(this);
		}
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_andExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(LPAREN);
			setState(134);
			parenExpression();
			setState(137); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(135);
				match(AND);
				setState(136);
				parenExpression();
				}
				}
				setState(139); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==AND );
			setState(141);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class OrExpressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(ConditionParser.LPAREN, 0); }
		public List<ParenExpressionContext> parenExpression() {
			return getRuleContexts(ParenExpressionContext.class);
		}
		public ParenExpressionContext parenExpression(int i) {
			return getRuleContext(ParenExpressionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ConditionParser.RPAREN, 0); }
		public List<TerminalNode> OR() { return getTokens(ConditionParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(ConditionParser.OR, i);
		}
		public OrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitOrExpression(this);
		}
	}

	public final OrExpressionContext orExpression() throws RecognitionException {
		OrExpressionContext _localctx = new OrExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_orExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(LPAREN);
			setState(144);
			parenExpression();
			setState(147); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(145);
				match(OR);
				setState(146);
				parenExpression();
				}
				}
				setState(149); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OR );
			setState(151);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BasicExpressionContext extends ParserRuleContext {
		public BasicExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicExpression; }
	 
		public BasicExpressionContext() { }
		public void copyFrom(BasicExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompareExpressionContext extends BasicExpressionContext {
		public BasicExpressionContext left;
		public ComparatorContext op;
		public BasicExpressionContext right;
		public List<BasicExpressionContext> basicExpression() {
			return getRuleContexts(BasicExpressionContext.class);
		}
		public BasicExpressionContext basicExpression(int i) {
			return getRuleContext(BasicExpressionContext.class,i);
		}
		public ComparatorContext comparator() {
			return getRuleContext(ComparatorContext.class,0);
		}
		public CompareExpressionContext(BasicExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterCompareExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitCompareExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolExpressionContext extends BasicExpressionContext {
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public BoolExpressionContext(BasicExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterBoolExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitBoolExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AtomExpressionContext extends BasicExpressionContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AtomExpressionContext(BasicExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterAtomExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitAtomExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ColumnExpressionContext extends BasicExpressionContext {
		public ColExpressionContext colExpression() {
			return getRuleContext(ColExpressionContext.class,0);
		}
		public ColumnExpressionContext(BasicExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterColumnExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitColumnExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionExpressionContext extends BasicExpressionContext {
		public FuncExpressionContext funcExpression() {
			return getRuleContext(FuncExpressionContext.class,0);
		}
		public FunctionExpressionContext(BasicExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterFunctionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitFunctionExpression(this);
		}
	}

	public final BasicExpressionContext basicExpression() throws RecognitionException {
		return basicExpression(0);
	}

	private BasicExpressionContext basicExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BasicExpressionContext _localctx = new BasicExpressionContext(_ctx, _parentState);
		BasicExpressionContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_basicExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				_localctx = new BoolExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(154);
				bool();
				}
				break;
			case 2:
				{
				_localctx = new FunctionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(155);
				funcExpression();
				}
				break;
			case 3:
				{
				_localctx = new ColumnExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(156);
				colExpression();
				}
				break;
			case 4:
				{
				_localctx = new AtomExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(157);
				atom();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(166);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CompareExpressionContext(new BasicExpressionContext(_parentctx, _parentState));
					((CompareExpressionContext)_localctx).left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_basicExpression);
					setState(160);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(161);
					((CompareExpressionContext)_localctx).op = comparator();
					setState(162);
					((CompareExpressionContext)_localctx).right = basicExpression(6);
					}
					} 
				}
				setState(168);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FuncExpressionContext extends ParserRuleContext {
		public FunctionNameContext functionName() {
			return getRuleContext(FunctionNameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(ConditionParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ConditionParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ConditionParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ConditionParser.COMMA, i);
		}
		public FuncExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterFuncExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitFuncExpression(this);
		}
	}

	public final FuncExpressionContext funcExpression() throws RecognitionException {
		FuncExpressionContext _localctx = new FuncExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_funcExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			functionName();
			setState(170);
			match(LPAREN);
			setState(171);
			expression();
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(172);
				match(COMMA);
				setState(173);
				expression();
				}
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(179);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ColExpressionContext extends ParserRuleContext {
		public IdentiferContext table;
		public IdentiferContext column;
		public TerminalNode DOT() { return getToken(ConditionParser.DOT, 0); }
		public List<IdentiferContext> identifer() {
			return getRuleContexts(IdentiferContext.class);
		}
		public IdentiferContext identifer(int i) {
			return getRuleContext(IdentiferContext.class,i);
		}
		public ColExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterColExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitColExpression(this);
		}
	}

	public final ColExpressionContext colExpression() throws RecognitionException {
		ColExpressionContext _localctx = new ColExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_colExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			((ColExpressionContext)_localctx).table = identifer();
			setState(182);
			match(DOT);
			setState(183);
			((ColExpressionContext)_localctx).column = identifer();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionNameContext extends ParserRuleContext {
		public IdentiferContext identifer() {
			return getRuleContext(IdentiferContext.class,0);
		}
		public FunctionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterFunctionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitFunctionName(this);
		}
	}

	public final FunctionNameContext functionName() throws RecognitionException {
		FunctionNameContext _localctx = new FunctionNameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_functionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			identifer();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TrueExpressionContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(ConditionParser.TRUE, 0); }
		public TerminalNode LPAREN() { return getToken(ConditionParser.LPAREN, 0); }
		public TrueExpressionContext trueExpression() {
			return getRuleContext(TrueExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ConditionParser.RPAREN, 0); }
		public TerminalNode NOT() { return getToken(ConditionParser.NOT, 0); }
		public FalseExpressionContext falseExpression() {
			return getRuleContext(FalseExpressionContext.class,0);
		}
		public TrueExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trueExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterTrueExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitTrueExpression(this);
		}
	}

	public final TrueExpressionContext trueExpression() throws RecognitionException {
		TrueExpressionContext _localctx = new TrueExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_trueExpression);
		try {
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				match(TRUE);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				match(LPAREN);
				setState(189);
				trueExpression();
				setState(190);
				match(RPAREN);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				match(NOT);
				setState(193);
				falseExpression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FalseExpressionContext extends ParserRuleContext {
		public TerminalNode FALSE() { return getToken(ConditionParser.FALSE, 0); }
		public TerminalNode LPAREN() { return getToken(ConditionParser.LPAREN, 0); }
		public FalseExpressionContext falseExpression() {
			return getRuleContext(FalseExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ConditionParser.RPAREN, 0); }
		public TerminalNode NOT() { return getToken(ConditionParser.NOT, 0); }
		public TrueExpressionContext trueExpression() {
			return getRuleContext(TrueExpressionContext.class,0);
		}
		public FalseExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_falseExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterFalseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitFalseExpression(this);
		}
	}

	public final FalseExpressionContext falseExpression() throws RecognitionException {
		FalseExpressionContext _localctx = new FalseExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_falseExpression);
		try {
			setState(203);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				match(FALSE);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				match(LPAREN);
				setState(198);
				falseExpression();
				setState(199);
				match(RPAREN);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 3);
				{
				setState(201);
				match(NOT);
				setState(202);
				trueExpression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ComparatorContext extends ParserRuleContext {
		public TerminalNode GT() { return getToken(ConditionParser.GT, 0); }
		public TerminalNode GE() { return getToken(ConditionParser.GE, 0); }
		public TerminalNode LT() { return getToken(ConditionParser.LT, 0); }
		public TerminalNode LE() { return getToken(ConditionParser.LE, 0); }
		public TerminalNode EQ() { return getToken(ConditionParser.EQ, 0); }
		public ComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterComparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitComparator(this);
		}
	}

	public final ComparatorContext comparator() throws RecognitionException {
		ComparatorContext _localctx = new ComparatorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_comparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1984L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AtomContext extends ParserRuleContext {
		public List<BoolContext> bool() {
			return getRuleContexts(BoolContext.class);
		}
		public BoolContext bool(int i) {
			return getRuleContext(BoolContext.class,i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(ConditionParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ConditionParser.IDENTIFIER, i);
		}
		public List<TerminalNode> DECIMAL() { return getTokens(ConditionParser.DECIMAL); }
		public TerminalNode DECIMAL(int i) {
			return getToken(ConditionParser.DECIMAL, i);
		}
		public List<TerminalNode> PUNCTUATION() { return getTokens(ConditionParser.PUNCTUATION); }
		public TerminalNode PUNCTUATION(int i) {
			return getToken(ConditionParser.PUNCTUATION, i);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitAtom(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_atom);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(211);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case NOT:
					case TRUE:
					case FALSE:
					case LPAREN:
						{
						setState(207);
						bool();
						}
						break;
					case IDENTIFIER:
						{
						setState(208);
						match(IDENTIFIER);
						}
						break;
					case DECIMAL:
						{
						setState(209);
						match(DECIMAL);
						}
						break;
					case PUNCTUATION:
						{
						setState(210);
						match(PUNCTUATION);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(215);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BoolContext extends ParserRuleContext {
		public TrueExpressionContext trueExpression() {
			return getRuleContext(TrueExpressionContext.class,0);
		}
		public FalseExpressionContext falseExpression() {
			return getRuleContext(FalseExpressionContext.class,0);
		}
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitBool(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_bool);
		try {
			setState(218);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(216);
				trueExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(217);
				falseExpression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class IdentiferContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ConditionParser.IDENTIFIER, 0); }
		public IdentiferContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).enterIdentifer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionParserListener ) ((ConditionParserListener)listener).exitIdentifer(this);
		}
	}

	public final IdentiferContext identifer() throws RecognitionException {
		IdentiferContext _localctx = new IdentiferContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_identifer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(IDENTIFIER);
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
		case 7:
			return basicExpression_sempred((BasicExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean basicExpression_sempred(BasicExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0012\u00df\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0003\u0000$\b\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001+\b"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0004\u0002^\b\u0002\u000b\u0002\f\u0002_\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0004\u0002e\b\u0002\u000b\u0002\f\u0002f\u0001"+
		"\u0002\u0001\u0002\u0003\u0002k\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003u\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u0084\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0004\u0005\u008a\b\u0005\u000b\u0005\f"+
		"\u0005\u008b\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0004\u0006\u0094\b\u0006\u000b\u0006\f\u0006\u0095\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007\u009f\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0005\u0007\u00a5\b\u0007\n\u0007\f\u0007\u00a8\t\u0007\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00af\b\b\n\b\f\b\u00b2\t\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u00c3\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0003\f\u00cc\b\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0005\u000e\u00d4\b\u000e\n\u000e\f\u000e\u00d7\t\u000e"+
		"\u0001\u000f\u0001\u000f\u0003\u000f\u00db\b\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0000\u0001\u000e\u0011\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \u0000\u0001\u0001\u0000"+
		"\u0006\n\u00f6\u0000#\u0001\u0000\u0000\u0000\u0002*\u0001\u0000\u0000"+
		"\u0000\u0004j\u0001\u0000\u0000\u0000\u0006t\u0001\u0000\u0000\u0000\b"+
		"\u0083\u0001\u0000\u0000\u0000\n\u0085\u0001\u0000\u0000\u0000\f\u008f"+
		"\u0001\u0000\u0000\u0000\u000e\u009e\u0001\u0000\u0000\u0000\u0010\u00a9"+
		"\u0001\u0000\u0000\u0000\u0012\u00b5\u0001\u0000\u0000\u0000\u0014\u00b9"+
		"\u0001\u0000\u0000\u0000\u0016\u00c2\u0001\u0000\u0000\u0000\u0018\u00cb"+
		"\u0001\u0000\u0000\u0000\u001a\u00cd\u0001\u0000\u0000\u0000\u001c\u00d5"+
		"\u0001\u0000\u0000\u0000\u001e\u00da\u0001\u0000\u0000\u0000 \u00dc\u0001"+
		"\u0000\u0000\u0000\"$\u0003\u0002\u0001\u0000#\"\u0001\u0000\u0000\u0000"+
		"#$\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000%&\u0005\u0000\u0000"+
		"\u0001&\u0001\u0001\u0000\u0000\u0000\'+\u0001\u0000\u0000\u0000(+\u0003"+
		"\u0006\u0003\u0000)+\u0003\u0004\u0002\u0000*\'\u0001\u0000\u0000\u0000"+
		"*(\u0001\u0000\u0000\u0000*)\u0001\u0000\u0000\u0000+\u0003\u0001\u0000"+
		"\u0000\u0000,-\u0003\u0006\u0003\u0000-.\u0005\u0001\u0000\u0000./\u0003"+
		"\u0018\f\u0000/k\u0001\u0000\u0000\u000001\u0003\u0018\f\u000012\u0005"+
		"\u0001\u0000\u000023\u0003\u0006\u0003\u00003k\u0001\u0000\u0000\u0000"+
		"45\u0003\u0006\u0003\u000056\u0005\u0002\u0000\u000067\u0003\u0016\u000b"+
		"\u00007k\u0001\u0000\u0000\u000089\u0003\u0016\u000b\u00009:\u0005\u0002"+
		"\u0000\u0000:;\u0003\u0006\u0003\u0000;k\u0001\u0000\u0000\u0000<=\u0003"+
		"\u0006\u0003\u0000=>\u0005\u0002\u0000\u0000>?\u0003\u0018\f\u0000?k\u0001"+
		"\u0000\u0000\u0000@A\u0003\u0018\f\u0000AB\u0005\u0002\u0000\u0000BC\u0003"+
		"\u0006\u0003\u0000Ck\u0001\u0000\u0000\u0000DE\u0003\u0006\u0003\u0000"+
		"EF\u0005\u0001\u0000\u0000FG\u0003\u0016\u000b\u0000Gk\u0001\u0000\u0000"+
		"\u0000HI\u0003\u0016\u000b\u0000IJ\u0005\u0001\u0000\u0000JK\u0003\u0006"+
		"\u0003\u0000Kk\u0001\u0000\u0000\u0000LM\u0003\f\u0006\u0000MN\u0005\u0001"+
		"\u0000\u0000NO\u0003\f\u0006\u0000Ok\u0001\u0000\u0000\u0000PQ\u0003\u0006"+
		"\u0003\u0000QR\u0005\u0001\u0000\u0000RS\u0003\f\u0006\u0000Sk\u0001\u0000"+
		"\u0000\u0000TU\u0003\f\u0006\u0000UV\u0005\u0001\u0000\u0000VW\u0003\u0006"+
		"\u0003\u0000Wk\u0001\u0000\u0000\u0000Xk\u0003\n\u0005\u0000Yk\u0003\f"+
		"\u0006\u0000Z]\u0003\u0006\u0003\u0000[\\\u0005\u0001\u0000\u0000\\^\u0003"+
		"\u0006\u0003\u0000][\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000"+
		"_]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`k\u0001\u0000\u0000"+
		"\u0000ad\u0003\u0006\u0003\u0000bc\u0005\u0002\u0000\u0000ce\u0003\u0006"+
		"\u0003\u0000db\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fd\u0001"+
		"\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gk\u0001\u0000\u0000\u0000"+
		"hk\u0003\b\u0004\u0000ik\u0003\u000e\u0007\u0000j,\u0001\u0000\u0000\u0000"+
		"j0\u0001\u0000\u0000\u0000j4\u0001\u0000\u0000\u0000j8\u0001\u0000\u0000"+
		"\u0000j<\u0001\u0000\u0000\u0000j@\u0001\u0000\u0000\u0000jD\u0001\u0000"+
		"\u0000\u0000jH\u0001\u0000\u0000\u0000jL\u0001\u0000\u0000\u0000jP\u0001"+
		"\u0000\u0000\u0000jT\u0001\u0000\u0000\u0000jX\u0001\u0000\u0000\u0000"+
		"jY\u0001\u0000\u0000\u0000jZ\u0001\u0000\u0000\u0000ja\u0001\u0000\u0000"+
		"\u0000jh\u0001\u0000\u0000\u0000ji\u0001\u0000\u0000\u0000k\u0005\u0001"+
		"\u0000\u0000\u0000lm\u0005\u000b\u0000\u0000mn\u0003\u0006\u0003\u0000"+
		"no\u0005\f\u0000\u0000ou\u0001\u0000\u0000\u0000pq\u0005\u000b\u0000\u0000"+
		"qr\u0003\u0004\u0002\u0000rs\u0005\f\u0000\u0000su\u0001\u0000\u0000\u0000"+
		"tl\u0001\u0000\u0000\u0000tp\u0001\u0000\u0000\u0000u\u0007\u0001\u0000"+
		"\u0000\u0000vw\u0005\u0003\u0000\u0000w\u0084\u0003\n\u0005\u0000xy\u0005"+
		"\u0003\u0000\u0000yz\u0005\u0003\u0000\u0000z\u0084\u0003\u0006\u0003"+
		"\u0000{|\u0005\u0003\u0000\u0000|}\u0005\u000b\u0000\u0000}~\u0005\u0003"+
		"\u0000\u0000~\u007f\u0003\u0006\u0003\u0000\u007f\u0080\u0005\f\u0000"+
		"\u0000\u0080\u0084\u0001\u0000\u0000\u0000\u0081\u0082\u0005\u0003\u0000"+
		"\u0000\u0082\u0084\u0003\u0006\u0003\u0000\u0083v\u0001\u0000\u0000\u0000"+
		"\u0083x\u0001\u0000\u0000\u0000\u0083{\u0001\u0000\u0000\u0000\u0083\u0081"+
		"\u0001\u0000\u0000\u0000\u0084\t\u0001\u0000\u0000\u0000\u0085\u0086\u0005"+
		"\u000b\u0000\u0000\u0086\u0089\u0003\u0006\u0003\u0000\u0087\u0088\u0005"+
		"\u0001\u0000\u0000\u0088\u008a\u0003\u0006\u0003\u0000\u0089\u0087\u0001"+
		"\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u0089\u0001"+
		"\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008d\u0001"+
		"\u0000\u0000\u0000\u008d\u008e\u0005\f\u0000\u0000\u008e\u000b\u0001\u0000"+
		"\u0000\u0000\u008f\u0090\u0005\u000b\u0000\u0000\u0090\u0093\u0003\u0006"+
		"\u0003\u0000\u0091\u0092\u0005\u0002\u0000\u0000\u0092\u0094\u0003\u0006"+
		"\u0003\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000"+
		"\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000"+
		"\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097\u0098\u0005\f\u0000"+
		"\u0000\u0098\r\u0001\u0000\u0000\u0000\u0099\u009a\u0006\u0007\uffff\uffff"+
		"\u0000\u009a\u009f\u0003\u001e\u000f\u0000\u009b\u009f\u0003\u0010\b\u0000"+
		"\u009c\u009f\u0003\u0012\t\u0000\u009d\u009f\u0003\u001c\u000e\u0000\u009e"+
		"\u0099\u0001\u0000\u0000\u0000\u009e\u009b\u0001\u0000\u0000\u0000\u009e"+
		"\u009c\u0001\u0000\u0000\u0000\u009e\u009d\u0001\u0000\u0000\u0000\u009f"+
		"\u00a6\u0001\u0000\u0000\u0000\u00a0\u00a1\n\u0005\u0000\u0000\u00a1\u00a2"+
		"\u0003\u001a\r\u0000\u00a2\u00a3\u0003\u000e\u0007\u0006\u00a3\u00a5\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a0\u0001\u0000\u0000\u0000\u00a5\u00a8\u0001"+
		"\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001"+
		"\u0000\u0000\u0000\u00a7\u000f\u0001\u0000\u0000\u0000\u00a8\u00a6\u0001"+
		"\u0000\u0000\u0000\u00a9\u00aa\u0003\u0014\n\u0000\u00aa\u00ab\u0005\u000b"+
		"\u0000\u0000\u00ab\u00b0\u0003\u0002\u0001\u0000\u00ac\u00ad\u0005\r\u0000"+
		"\u0000\u00ad\u00af\u0003\u0002\u0001\u0000\u00ae\u00ac\u0001\u0000\u0000"+
		"\u0000\u00af\u00b2\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u00b3\u0001\u0000\u0000"+
		"\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005\f\u0000\u0000"+
		"\u00b4\u0011\u0001\u0000\u0000\u0000\u00b5\u00b6\u0003 \u0010\u0000\u00b6"+
		"\u00b7\u0005\u000e\u0000\u0000\u00b7\u00b8\u0003 \u0010\u0000\u00b8\u0013"+
		"\u0001\u0000\u0000\u0000\u00b9\u00ba\u0003 \u0010\u0000\u00ba\u0015\u0001"+
		"\u0000\u0000\u0000\u00bb\u00c3\u0005\u0004\u0000\u0000\u00bc\u00bd\u0005"+
		"\u000b\u0000\u0000\u00bd\u00be\u0003\u0016\u000b\u0000\u00be\u00bf\u0005"+
		"\f\u0000\u0000\u00bf\u00c3\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005\u0003"+
		"\u0000\u0000\u00c1\u00c3\u0003\u0018\f\u0000\u00c2\u00bb\u0001\u0000\u0000"+
		"\u0000\u00c2\u00bc\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000"+
		"\u0000\u00c3\u0017\u0001\u0000\u0000\u0000\u00c4\u00cc\u0005\u0005\u0000"+
		"\u0000\u00c5\u00c6\u0005\u000b\u0000\u0000\u00c6\u00c7\u0003\u0018\f\u0000"+
		"\u00c7\u00c8\u0005\f\u0000\u0000\u00c8\u00cc\u0001\u0000\u0000\u0000\u00c9"+
		"\u00ca\u0005\u0003\u0000\u0000\u00ca\u00cc\u0003\u0016\u000b\u0000\u00cb"+
		"\u00c4\u0001\u0000\u0000\u0000\u00cb\u00c5\u0001\u0000\u0000\u0000\u00cb"+
		"\u00c9\u0001\u0000\u0000\u0000\u00cc\u0019\u0001\u0000\u0000\u0000\u00cd"+
		"\u00ce\u0007\u0000\u0000\u0000\u00ce\u001b\u0001\u0000\u0000\u0000\u00cf"+
		"\u00d4\u0003\u001e\u000f\u0000\u00d0\u00d4\u0005\u0010\u0000\u0000\u00d1"+
		"\u00d4\u0005\u000f\u0000\u0000\u00d2\u00d4\u0005\u0011\u0000\u0000\u00d3"+
		"\u00cf\u0001\u0000\u0000\u0000\u00d3\u00d0\u0001\u0000\u0000\u0000\u00d3"+
		"\u00d1\u0001\u0000\u0000\u0000\u00d3\u00d2\u0001\u0000\u0000\u0000\u00d4"+
		"\u00d7\u0001\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d5"+
		"\u00d6\u0001\u0000\u0000\u0000\u00d6\u001d\u0001\u0000\u0000\u0000\u00d7"+
		"\u00d5\u0001\u0000\u0000\u0000\u00d8\u00db\u0003\u0016\u000b\u0000\u00d9"+
		"\u00db\u0003\u0018\f\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00da\u00d9"+
		"\u0001\u0000\u0000\u0000\u00db\u001f\u0001\u0000\u0000\u0000\u00dc\u00dd"+
		"\u0005\u0010\u0000\u0000\u00dd!\u0001\u0000\u0000\u0000\u0011#*_fjt\u0083"+
		"\u008b\u0095\u009e\u00a6\u00b0\u00c2\u00cb\u00d3\u00d5\u00da";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}