// Generated from D:/Antlr-SQLGraphExplorer/SQLGraphExplorer/src/main/java/cn/edu/nju/core/tools/condition/grammar/spliter/SpliterParser.g4 by ANTLR 4.13.1
package cn.edu.nju.core.tools.condition.grammar.spliter;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SpliterParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AND=1, OR=2, NOT=3, TRUE=4, FALSE=5, GT=6, GE=7, LT=8, LE=9, EQ=10, LPAREN=11, 
		RPAREN=12, COMMA=13, DOT=14, DECIMAL=15, IDENTIFIER=16, PUNCTUATION=17, 
		WS=18;
	public static final int
		RULE_parse = 0, RULE_rootExpression = 1, RULE_orSplitExpression = 2, RULE_expression = 3, 
		RULE_multiAndsExpression = 4, RULE_multiOrsExpression = 5, RULE_parenExpression = 6, 
		RULE_unitExpression = 7, RULE_basicExpression = 8, RULE_funcExpression = 9, 
		RULE_colExpression = 10, RULE_functionName = 11, RULE_trueExpression = 12, 
		RULE_falseExpression = 13, RULE_comparator = 14, RULE_atom = 15, RULE_bool = 16, 
		RULE_identifer = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "rootExpression", "orSplitExpression", "expression", "multiAndsExpression", 
			"multiOrsExpression", "parenExpression", "unitExpression", "basicExpression", 
			"funcExpression", "colExpression", "functionName", "trueExpression", 
			"falseExpression", "comparator", "atom", "bool", "identifer"
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
	public String getGrammarFileName() { return "SpliterParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SpliterParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParseContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SpliterParser.EOF, 0); }
		public RootExpressionContext rootExpression() {
			return getRuleContext(RootExpressionContext.class,0);
		}
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitParse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(36);
				rootExpression();
				}
				break;
			}
			setState(39);
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
	public static class RootExpressionContext extends ParserRuleContext {
		public RootExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rootExpression; }
	 
		public RootExpressionContext() { }
		public void copyFrom(RootExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CantSplitExpressionContext extends RootExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CantSplitExpressionContext(RootExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterCantSplitExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitCantSplitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitCantSplitExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RootAndsExpressionContext extends RootExpressionContext {
		public MultiAndsExpressionContext multiAndsExpression() {
			return getRuleContext(MultiAndsExpressionContext.class,0);
		}
		public RootAndsExpressionContext(RootExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterRootAndsExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitRootAndsExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitRootAndsExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrSplitsExressionContext extends RootExpressionContext {
		public OrSplitExpressionContext orSplitExpression() {
			return getRuleContext(OrSplitExpressionContext.class,0);
		}
		public OrSplitsExressionContext(RootExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterOrSplitsExression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitOrSplitsExression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitOrSplitsExression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiRootExpressionContext extends RootExpressionContext {
		public TerminalNode LPAREN() { return getToken(SpliterParser.LPAREN, 0); }
		public RootExpressionContext rootExpression() {
			return getRuleContext(RootExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SpliterParser.RPAREN, 0); }
		public MultiRootExpressionContext(RootExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterMultiRootExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitMultiRootExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitMultiRootExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RootOrsExpressionContext extends RootExpressionContext {
		public MultiOrsExpressionContext multiOrsExpression() {
			return getRuleContext(MultiOrsExpressionContext.class,0);
		}
		public RootOrsExpressionContext(RootExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterRootOrsExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitRootOrsExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitRootOrsExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RootExpressionContext rootExpression() throws RecognitionException {
		RootExpressionContext _localctx = new RootExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_rootExpression);
		try {
			setState(49);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new RootAndsExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				multiAndsExpression();
				}
				break;
			case 2:
				_localctx = new RootOrsExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				multiOrsExpression();
				}
				break;
			case 3:
				_localctx = new MultiRootExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(43);
				match(LPAREN);
				setState(44);
				rootExpression();
				setState(45);
				match(RPAREN);
				}
				break;
			case 4:
				_localctx = new OrSplitsExressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(47);
				orSplitExpression(0);
				}
				break;
			case 5:
				_localctx = new CantSplitExpressionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(48);
				expression(0);
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
	public static class OrSplitExpressionContext extends ParserRuleContext {
		public OrSplitExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orSplitExpression; }
	 
		public OrSplitExpressionContext() { }
		public void copyFrom(OrSplitExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrSplitBasicExpressionContext extends OrSplitExpressionContext {
		public List<UnitExpressionContext> unitExpression() {
			return getRuleContexts(UnitExpressionContext.class);
		}
		public UnitExpressionContext unitExpression(int i) {
			return getRuleContext(UnitExpressionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(SpliterParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(SpliterParser.OR, i);
		}
		public OrSplitBasicExpressionContext(OrSplitExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterOrSplitBasicExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitOrSplitBasicExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitOrSplitBasicExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrSplitParenExpressionContext extends OrSplitExpressionContext {
		public TerminalNode LPAREN() { return getToken(SpliterParser.LPAREN, 0); }
		public OrSplitExpressionContext orSplitExpression() {
			return getRuleContext(OrSplitExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SpliterParser.RPAREN, 0); }
		public OrSplitParenExpressionContext(OrSplitExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterOrSplitParenExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitOrSplitParenExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitOrSplitParenExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrSplitRecursiveExpressionContext extends OrSplitExpressionContext {
		public List<OrSplitExpressionContext> orSplitExpression() {
			return getRuleContexts(OrSplitExpressionContext.class);
		}
		public OrSplitExpressionContext orSplitExpression(int i) {
			return getRuleContext(OrSplitExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(SpliterParser.OR, 0); }
		public OrSplitRecursiveExpressionContext(OrSplitExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterOrSplitRecursiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitOrSplitRecursiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitOrSplitRecursiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrSplitExpressionContext orSplitExpression() throws RecognitionException {
		return orSplitExpression(0);
	}

	private OrSplitExpressionContext orSplitExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		OrSplitExpressionContext _localctx = new OrSplitExpressionContext(_ctx, _parentState);
		OrSplitExpressionContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_orSplitExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				_localctx = new OrSplitParenExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(52);
				match(LPAREN);
				setState(53);
				orSplitExpression(0);
				setState(54);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new OrSplitBasicExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(56);
				unitExpression();
				setState(59); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(57);
						match(OR);
						setState(58);
						unitExpression();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(61); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(70);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OrSplitRecursiveExpressionContext(new OrSplitExpressionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_orSplitExpression);
					setState(65);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(66);
					match(OR);
					setState(67);
					orSplitExpression(3);
					}
					} 
				}
				setState(72);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndsExpressionContext extends ExpressionContext {
		public MultiAndsExpressionContext multiAndsExpression() {
			return getRuleContext(MultiAndsExpressionContext.class,0);
		}
		public AndsExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterAndsExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitAndsExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitAndsExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(SpliterParser.OR, 0); }
		public OrExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(SpliterParser.AND, 0); }
		public AndExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParensExpressionContext extends ExpressionContext {
		public ParenExpressionContext parenExpression() {
			return getRuleContext(ParenExpressionContext.class,0);
		}
		public ParensExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterParensExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitParensExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitParensExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotExpressionContext extends ExpressionContext {
		public TerminalNode NOT() { return getToken(SpliterParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterNotExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitNotExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitNotExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrsExpressionContext extends ExpressionContext {
		public MultiOrsExpressionContext multiOrsExpression() {
			return getRuleContext(MultiOrsExpressionContext.class,0);
		}
		public OrsExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterOrsExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitOrsExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitOrsExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BasicBlockExpressionContext extends ExpressionContext {
		public BasicExpressionContext basicExpression() {
			return getRuleContext(BasicExpressionContext.class,0);
		}
		public BasicBlockExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterBasicBlockExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitBasicBlockExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitBasicBlockExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				_localctx = new AndsExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(74);
				multiAndsExpression();
				}
				break;
			case 2:
				{
				_localctx = new OrsExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(75);
				multiOrsExpression();
				}
				break;
			case 3:
				{
				_localctx = new BasicBlockExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(76);
				basicExpression(0);
				}
				break;
			case 4:
				{
				_localctx = new ParensExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77);
				parenExpression();
				}
				break;
			case 5:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78);
				match(NOT);
				setState(79);
				expression(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(90);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(88);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new AndExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(82);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(83);
						match(AND);
						setState(84);
						expression(4);
						}
						break;
					case 2:
						{
						_localctx = new OrExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(85);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(86);
						match(OR);
						setState(87);
						expression(3);
						}
						break;
					}
					} 
				}
				setState(92);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
	public static class MultiAndsExpressionContext extends ParserRuleContext {
		public MultiAndsExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiAndsExpression; }
	 
		public MultiAndsExpressionContext() { }
		public void copyFrom(MultiAndsExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiAndsBasicExpressionContext extends MultiAndsExpressionContext {
		public List<TerminalNode> LPAREN() { return getTokens(SpliterParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(SpliterParser.LPAREN, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(SpliterParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(SpliterParser.AND, i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(SpliterParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(SpliterParser.RPAREN, i);
		}
		public MultiAndsBasicExpressionContext(MultiAndsExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterMultiAndsBasicExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitMultiAndsBasicExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitMultiAndsBasicExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiAndsRecursiveExpressionContext extends MultiAndsExpressionContext {
		public TerminalNode LPAREN() { return getToken(SpliterParser.LPAREN, 0); }
		public MultiAndsExpressionContext multiAndsExpression() {
			return getRuleContext(MultiAndsExpressionContext.class,0);
		}
		public TerminalNode AND() { return getToken(SpliterParser.AND, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SpliterParser.RPAREN, 0); }
		public MultiAndsRecursiveExpressionContext(MultiAndsExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterMultiAndsRecursiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitMultiAndsRecursiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitMultiAndsRecursiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiAndsExpressionContext multiAndsExpression() throws RecognitionException {
		MultiAndsExpressionContext _localctx = new MultiAndsExpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_multiAndsExpression);
		try {
			setState(125);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new MultiAndsRecursiveExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				match(LPAREN);
				setState(94);
				multiAndsExpression();
				setState(95);
				match(AND);
				setState(96);
				expression(0);
				setState(97);
				match(RPAREN);
				}
				break;
			case 2:
				_localctx = new MultiAndsRecursiveExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				match(LPAREN);
				setState(100);
				expression(0);
				setState(101);
				match(AND);
				setState(102);
				multiAndsExpression();
				setState(103);
				match(RPAREN);
				}
				break;
			case 3:
				_localctx = new MultiAndsBasicExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(105);
				match(LPAREN);
				setState(106);
				match(LPAREN);
				setState(107);
				expression(0);
				setState(108);
				match(AND);
				setState(109);
				expression(0);
				setState(110);
				match(RPAREN);
				setState(111);
				match(AND);
				setState(112);
				expression(0);
				setState(113);
				match(RPAREN);
				}
				break;
			case 4:
				_localctx = new MultiAndsBasicExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(115);
				match(LPAREN);
				setState(116);
				expression(0);
				setState(117);
				match(AND);
				setState(118);
				match(LPAREN);
				setState(119);
				expression(0);
				setState(120);
				match(AND);
				setState(121);
				expression(0);
				setState(122);
				match(RPAREN);
				setState(123);
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
	public static class MultiOrsExpressionContext extends ParserRuleContext {
		public MultiOrsExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiOrsExpression; }
	 
		public MultiOrsExpressionContext() { }
		public void copyFrom(MultiOrsExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiOrsBasicExpressionContext extends MultiOrsExpressionContext {
		public List<TerminalNode> LPAREN() { return getTokens(SpliterParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(SpliterParser.LPAREN, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(SpliterParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(SpliterParser.OR, i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(SpliterParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(SpliterParser.RPAREN, i);
		}
		public MultiOrsBasicExpressionContext(MultiOrsExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterMultiOrsBasicExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitMultiOrsBasicExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitMultiOrsBasicExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiOrsRecursiveExpressionContext extends MultiOrsExpressionContext {
		public TerminalNode LPAREN() { return getToken(SpliterParser.LPAREN, 0); }
		public MultiOrsExpressionContext multiOrsExpression() {
			return getRuleContext(MultiOrsExpressionContext.class,0);
		}
		public TerminalNode OR() { return getToken(SpliterParser.OR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SpliterParser.RPAREN, 0); }
		public MultiOrsRecursiveExpressionContext(MultiOrsExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterMultiOrsRecursiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitMultiOrsRecursiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitMultiOrsRecursiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiOrsExpressionContext multiOrsExpression() throws RecognitionException {
		MultiOrsExpressionContext _localctx = new MultiOrsExpressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_multiOrsExpression);
		try {
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new MultiOrsRecursiveExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				match(LPAREN);
				setState(128);
				multiOrsExpression();
				setState(129);
				match(OR);
				setState(130);
				expression(0);
				setState(131);
				match(RPAREN);
				}
				break;
			case 2:
				_localctx = new MultiOrsRecursiveExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
				match(LPAREN);
				setState(134);
				expression(0);
				setState(135);
				match(OR);
				setState(136);
				multiOrsExpression();
				setState(137);
				match(RPAREN);
				}
				break;
			case 3:
				_localctx = new MultiOrsBasicExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(139);
				match(LPAREN);
				setState(140);
				match(LPAREN);
				setState(141);
				expression(0);
				setState(142);
				match(OR);
				setState(143);
				expression(0);
				setState(144);
				match(RPAREN);
				setState(145);
				match(OR);
				setState(146);
				expression(0);
				setState(147);
				match(RPAREN);
				}
				break;
			case 4:
				_localctx = new MultiOrsBasicExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(149);
				match(LPAREN);
				setState(150);
				expression(0);
				setState(151);
				match(OR);
				setState(152);
				match(LPAREN);
				setState(153);
				expression(0);
				setState(154);
				match(OR);
				setState(155);
				expression(0);
				setState(156);
				match(RPAREN);
				setState(157);
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
		public TerminalNode LPAREN() { return getToken(SpliterParser.LPAREN, 0); }
		public ParenExpressionContext parenExpression() {
			return getRuleContext(ParenExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SpliterParser.RPAREN, 0); }
		public MultiParenExpressionContext(ParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterMultiParenExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitMultiParenExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitMultiParenExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleParenExpressionContext extends ParenExpressionContext {
		public TerminalNode LPAREN() { return getToken(SpliterParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SpliterParser.RPAREN, 0); }
		public SingleParenExpressionContext(ParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterSingleParenExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitSingleParenExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitSingleParenExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenExpressionContext parenExpression() throws RecognitionException {
		ParenExpressionContext _localctx = new ParenExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parenExpression);
		try {
			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new MultiParenExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				match(LPAREN);
				setState(162);
				parenExpression();
				setState(163);
				match(RPAREN);
				}
				break;
			case 2:
				_localctx = new SingleParenExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				match(LPAREN);
				setState(166);
				expression(0);
				setState(167);
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
	public static class UnitExpressionContext extends ParserRuleContext {
		public UnitExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unitExpression; }
	 
		public UnitExpressionContext() { }
		public void copyFrom(UnitExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnitParenExpressionContext extends UnitExpressionContext {
		public ParenExpressionContext parenExpression() {
			return getRuleContext(ParenExpressionContext.class,0);
		}
		public UnitParenExpressionContext(UnitExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterUnitParenExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitUnitParenExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitUnitParenExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnitBasicExpressionContext extends UnitExpressionContext {
		public BasicExpressionContext basicExpression() {
			return getRuleContext(BasicExpressionContext.class,0);
		}
		public UnitBasicExpressionContext(UnitExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterUnitBasicExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitUnitBasicExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitUnitBasicExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnitExpressionContext unitExpression() throws RecognitionException {
		UnitExpressionContext _localctx = new UnitExpressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_unitExpression);
		try {
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new UnitBasicExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				basicExpression(0);
				}
				break;
			case 2:
				_localctx = new UnitParenExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
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
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterCompareExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitCompareExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitCompareExpression(this);
			else return visitor.visitChildren(this);
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
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterBoolExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitBoolExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitBoolExpression(this);
			else return visitor.visitChildren(this);
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
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterAtomExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitAtomExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitAtomExpression(this);
			else return visitor.visitChildren(this);
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
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterColumnExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitColumnExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitColumnExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenBasicExpressionContext extends BasicExpressionContext {
		public TerminalNode LPAREN() { return getToken(SpliterParser.LPAREN, 0); }
		public BasicExpressionContext basicExpression() {
			return getRuleContext(BasicExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SpliterParser.RPAREN, 0); }
		public ParenBasicExpressionContext(BasicExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterParenBasicExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitParenBasicExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitParenBasicExpression(this);
			else return visitor.visitChildren(this);
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
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterFunctionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitFunctionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitFunctionExpression(this);
			else return visitor.visitChildren(this);
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
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_basicExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				_localctx = new ParenBasicExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(176);
				match(LPAREN);
				setState(177);
				basicExpression(0);
				setState(178);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new BoolExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(180);
				bool();
				}
				break;
			case 3:
				{
				_localctx = new FunctionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(181);
				funcExpression();
				}
				break;
			case 4:
				{
				_localctx = new ColumnExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(182);
				colExpression();
				}
				break;
			case 5:
				{
				_localctx = new AtomExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(183);
				atom();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(192);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CompareExpressionContext(new BasicExpressionContext(_parentctx, _parentState));
					((CompareExpressionContext)_localctx).left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_basicExpression);
					setState(186);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(187);
					((CompareExpressionContext)_localctx).op = comparator();
					setState(188);
					((CompareExpressionContext)_localctx).right = basicExpression(6);
					}
					} 
				}
				setState(194);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		public TerminalNode LPAREN() { return getToken(SpliterParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(SpliterParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SpliterParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SpliterParser.COMMA, i);
		}
		public FuncExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterFuncExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitFuncExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitFuncExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncExpressionContext funcExpression() throws RecognitionException {
		FuncExpressionContext _localctx = new FuncExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_funcExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			functionName();
			setState(196);
			match(LPAREN);
			setState(197);
			expression(0);
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(198);
				match(COMMA);
				setState(199);
				expression(0);
				}
				}
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(205);
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
		public TerminalNode DOT() { return getToken(SpliterParser.DOT, 0); }
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
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterColExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitColExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitColExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColExpressionContext colExpression() throws RecognitionException {
		ColExpressionContext _localctx = new ColExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_colExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			((ColExpressionContext)_localctx).table = identifer();
			setState(208);
			match(DOT);
			setState(209);
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
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterFunctionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitFunctionName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitFunctionName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionNameContext functionName() throws RecognitionException {
		FunctionNameContext _localctx = new FunctionNameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_functionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
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
		public TerminalNode TRUE() { return getToken(SpliterParser.TRUE, 0); }
		public TerminalNode LPAREN() { return getToken(SpliterParser.LPAREN, 0); }
		public TrueExpressionContext trueExpression() {
			return getRuleContext(TrueExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SpliterParser.RPAREN, 0); }
		public TerminalNode NOT() { return getToken(SpliterParser.NOT, 0); }
		public FalseExpressionContext falseExpression() {
			return getRuleContext(FalseExpressionContext.class,0);
		}
		public TrueExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trueExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterTrueExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitTrueExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitTrueExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrueExpressionContext trueExpression() throws RecognitionException {
		TrueExpressionContext _localctx = new TrueExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_trueExpression);
		try {
			setState(220);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(213);
				match(TRUE);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(214);
				match(LPAREN);
				setState(215);
				trueExpression();
				setState(216);
				match(RPAREN);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 3);
				{
				setState(218);
				match(NOT);
				setState(219);
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
		public TerminalNode FALSE() { return getToken(SpliterParser.FALSE, 0); }
		public TerminalNode LPAREN() { return getToken(SpliterParser.LPAREN, 0); }
		public FalseExpressionContext falseExpression() {
			return getRuleContext(FalseExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SpliterParser.RPAREN, 0); }
		public TerminalNode NOT() { return getToken(SpliterParser.NOT, 0); }
		public TrueExpressionContext trueExpression() {
			return getRuleContext(TrueExpressionContext.class,0);
		}
		public FalseExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_falseExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterFalseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitFalseExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitFalseExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FalseExpressionContext falseExpression() throws RecognitionException {
		FalseExpressionContext _localctx = new FalseExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_falseExpression);
		try {
			setState(229);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				match(FALSE);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				match(LPAREN);
				setState(224);
				falseExpression();
				setState(225);
				match(RPAREN);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 3);
				{
				setState(227);
				match(NOT);
				setState(228);
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
		public TerminalNode GT() { return getToken(SpliterParser.GT, 0); }
		public TerminalNode GE() { return getToken(SpliterParser.GE, 0); }
		public TerminalNode LT() { return getToken(SpliterParser.LT, 0); }
		public TerminalNode LE() { return getToken(SpliterParser.LE, 0); }
		public TerminalNode EQ() { return getToken(SpliterParser.EQ, 0); }
		public ComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterComparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitComparator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitComparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparatorContext comparator() throws RecognitionException {
		ComparatorContext _localctx = new ComparatorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_comparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
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
		public List<TerminalNode> IDENTIFIER() { return getTokens(SpliterParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SpliterParser.IDENTIFIER, i);
		}
		public List<TerminalNode> DECIMAL() { return getTokens(SpliterParser.DECIMAL); }
		public TerminalNode DECIMAL(int i) {
			return getToken(SpliterParser.DECIMAL, i);
		}
		public List<TerminalNode> PUNCTUATION() { return getTokens(SpliterParser.PUNCTUATION); }
		public TerminalNode PUNCTUATION(int i) {
			return getToken(SpliterParser.PUNCTUATION, i);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_atom);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(237);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case NOT:
					case TRUE:
					case FALSE:
					case LPAREN:
						{
						setState(233);
						bool();
						}
						break;
					case IDENTIFIER:
						{
						setState(234);
						match(IDENTIFIER);
						}
						break;
					case DECIMAL:
						{
						setState(235);
						match(DECIMAL);
						}
						break;
					case PUNCTUATION:
						{
						setState(236);
						match(PUNCTUATION);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(241);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_bool);
		try {
			setState(244);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(242);
				trueExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(243);
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
		public TerminalNode IDENTIFIER() { return getToken(SpliterParser.IDENTIFIER, 0); }
		public IdentiferContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).enterIdentifer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SpliterParserListener ) ((SpliterParserListener)listener).exitIdentifer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpliterParserVisitor ) return ((SpliterParserVisitor<? extends T>)visitor).visitIdentifer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentiferContext identifer() throws RecognitionException {
		IdentiferContext _localctx = new IdentiferContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_identifer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
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
		case 2:
			return orSplitExpression_sempred((OrSplitExpressionContext)_localctx, predIndex);
		case 3:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 8:
			return basicExpression_sempred((BasicExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean orSplitExpression_sempred(OrSplitExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean basicExpression_sempred(BasicExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0012\u00f9\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0003"+
		"\u0000&\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u00012\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0004\u0002<\b\u0002\u000b"+
		"\u0002\f\u0002=\u0003\u0002@\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002E\b\u0002\n\u0002\f\u0002H\t\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"Q\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0005\u0003Y\b\u0003\n\u0003\f\u0003\\\t\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004~\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"\u00a0\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00aa\b\u0006\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u00ae\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00b9\b\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0005\b\u00bf\b\b\n\b\f\b\u00c2\t\b\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0005\t\u00c9\b\t\n\t\f\t\u00cc\t\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00dd\b\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00e6\b\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f"+
		"\u00ee\b\u000f\n\u000f\f\u000f\u00f1\t\u000f\u0001\u0010\u0001\u0010\u0003"+
		"\u0010\u00f5\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0000\u0003\u0004"+
		"\u0006\u0010\u0012\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"\u0000\u0001\u0001\u0000\u0006\n\u010b"+
		"\u0000%\u0001\u0000\u0000\u0000\u00021\u0001\u0000\u0000\u0000\u0004?"+
		"\u0001\u0000\u0000\u0000\u0006P\u0001\u0000\u0000\u0000\b}\u0001\u0000"+
		"\u0000\u0000\n\u009f\u0001\u0000\u0000\u0000\f\u00a9\u0001\u0000\u0000"+
		"\u0000\u000e\u00ad\u0001\u0000\u0000\u0000\u0010\u00b8\u0001\u0000\u0000"+
		"\u0000\u0012\u00c3\u0001\u0000\u0000\u0000\u0014\u00cf\u0001\u0000\u0000"+
		"\u0000\u0016\u00d3\u0001\u0000\u0000\u0000\u0018\u00dc\u0001\u0000\u0000"+
		"\u0000\u001a\u00e5\u0001\u0000\u0000\u0000\u001c\u00e7\u0001\u0000\u0000"+
		"\u0000\u001e\u00ef\u0001\u0000\u0000\u0000 \u00f4\u0001\u0000\u0000\u0000"+
		"\"\u00f6\u0001\u0000\u0000\u0000$&\u0003\u0002\u0001\u0000%$\u0001\u0000"+
		"\u0000\u0000%&\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\'(\u0005"+
		"\u0000\u0000\u0001(\u0001\u0001\u0000\u0000\u0000)2\u0003\b\u0004\u0000"+
		"*2\u0003\n\u0005\u0000+,\u0005\u000b\u0000\u0000,-\u0003\u0002\u0001\u0000"+
		"-.\u0005\f\u0000\u0000.2\u0001\u0000\u0000\u0000/2\u0003\u0004\u0002\u0000"+
		"02\u0003\u0006\u0003\u00001)\u0001\u0000\u0000\u00001*\u0001\u0000\u0000"+
		"\u00001+\u0001\u0000\u0000\u00001/\u0001\u0000\u0000\u000010\u0001\u0000"+
		"\u0000\u00002\u0003\u0001\u0000\u0000\u000034\u0006\u0002\uffff\uffff"+
		"\u000045\u0005\u000b\u0000\u000056\u0003\u0004\u0002\u000067\u0005\f\u0000"+
		"\u00007@\u0001\u0000\u0000\u00008;\u0003\u000e\u0007\u00009:\u0005\u0002"+
		"\u0000\u0000:<\u0003\u000e\u0007\u0000;9\u0001\u0000\u0000\u0000<=\u0001"+
		"\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000"+
		">@\u0001\u0000\u0000\u0000?3\u0001\u0000\u0000\u0000?8\u0001\u0000\u0000"+
		"\u0000@F\u0001\u0000\u0000\u0000AB\n\u0002\u0000\u0000BC\u0005\u0002\u0000"+
		"\u0000CE\u0003\u0004\u0002\u0003DA\u0001\u0000\u0000\u0000EH\u0001\u0000"+
		"\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000G\u0005"+
		"\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000IJ\u0006\u0003\uffff"+
		"\uffff\u0000JQ\u0003\b\u0004\u0000KQ\u0003\n\u0005\u0000LQ\u0003\u0010"+
		"\b\u0000MQ\u0003\f\u0006\u0000NO\u0005\u0003\u0000\u0000OQ\u0003\u0006"+
		"\u0003\u0001PI\u0001\u0000\u0000\u0000PK\u0001\u0000\u0000\u0000PL\u0001"+
		"\u0000\u0000\u0000PM\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000"+
		"QZ\u0001\u0000\u0000\u0000RS\n\u0003\u0000\u0000ST\u0005\u0001\u0000\u0000"+
		"TY\u0003\u0006\u0003\u0004UV\n\u0002\u0000\u0000VW\u0005\u0002\u0000\u0000"+
		"WY\u0003\u0006\u0003\u0003XR\u0001\u0000\u0000\u0000XU\u0001\u0000\u0000"+
		"\u0000Y\\\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001\u0000"+
		"\u0000\u0000[\u0007\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000"+
		"]^\u0005\u000b\u0000\u0000^_\u0003\b\u0004\u0000_`\u0005\u0001\u0000\u0000"+
		"`a\u0003\u0006\u0003\u0000ab\u0005\f\u0000\u0000b~\u0001\u0000\u0000\u0000"+
		"cd\u0005\u000b\u0000\u0000de\u0003\u0006\u0003\u0000ef\u0005\u0001\u0000"+
		"\u0000fg\u0003\b\u0004\u0000gh\u0005\f\u0000\u0000h~\u0001\u0000\u0000"+
		"\u0000ij\u0005\u000b\u0000\u0000jk\u0005\u000b\u0000\u0000kl\u0003\u0006"+
		"\u0003\u0000lm\u0005\u0001\u0000\u0000mn\u0003\u0006\u0003\u0000no\u0005"+
		"\f\u0000\u0000op\u0005\u0001\u0000\u0000pq\u0003\u0006\u0003\u0000qr\u0005"+
		"\f\u0000\u0000r~\u0001\u0000\u0000\u0000st\u0005\u000b\u0000\u0000tu\u0003"+
		"\u0006\u0003\u0000uv\u0005\u0001\u0000\u0000vw\u0005\u000b\u0000\u0000"+
		"wx\u0003\u0006\u0003\u0000xy\u0005\u0001\u0000\u0000yz\u0003\u0006\u0003"+
		"\u0000z{\u0005\f\u0000\u0000{|\u0005\f\u0000\u0000|~\u0001\u0000\u0000"+
		"\u0000}]\u0001\u0000\u0000\u0000}c\u0001\u0000\u0000\u0000}i\u0001\u0000"+
		"\u0000\u0000}s\u0001\u0000\u0000\u0000~\t\u0001\u0000\u0000\u0000\u007f"+
		"\u0080\u0005\u000b\u0000\u0000\u0080\u0081\u0003\n\u0005\u0000\u0081\u0082"+
		"\u0005\u0002\u0000\u0000\u0082\u0083\u0003\u0006\u0003\u0000\u0083\u0084"+
		"\u0005\f\u0000\u0000\u0084\u00a0\u0001\u0000\u0000\u0000\u0085\u0086\u0005"+
		"\u000b\u0000\u0000\u0086\u0087\u0003\u0006\u0003\u0000\u0087\u0088\u0005"+
		"\u0002\u0000\u0000\u0088\u0089\u0003\n\u0005\u0000\u0089\u008a\u0005\f"+
		"\u0000\u0000\u008a\u00a0\u0001\u0000\u0000\u0000\u008b\u008c\u0005\u000b"+
		"\u0000\u0000\u008c\u008d\u0005\u000b\u0000\u0000\u008d\u008e\u0003\u0006"+
		"\u0003\u0000\u008e\u008f\u0005\u0002\u0000\u0000\u008f\u0090\u0003\u0006"+
		"\u0003\u0000\u0090\u0091\u0005\f\u0000\u0000\u0091\u0092\u0005\u0002\u0000"+
		"\u0000\u0092\u0093\u0003\u0006\u0003\u0000\u0093\u0094\u0005\f\u0000\u0000"+
		"\u0094\u00a0\u0001\u0000\u0000\u0000\u0095\u0096\u0005\u000b\u0000\u0000"+
		"\u0096\u0097\u0003\u0006\u0003\u0000\u0097\u0098\u0005\u0002\u0000\u0000"+
		"\u0098\u0099\u0005\u000b\u0000\u0000\u0099\u009a\u0003\u0006\u0003\u0000"+
		"\u009a\u009b\u0005\u0002\u0000\u0000\u009b\u009c\u0003\u0006\u0003\u0000"+
		"\u009c\u009d\u0005\f\u0000\u0000\u009d\u009e\u0005\f\u0000\u0000\u009e"+
		"\u00a0\u0001\u0000\u0000\u0000\u009f\u007f\u0001\u0000\u0000\u0000\u009f"+
		"\u0085\u0001\u0000\u0000\u0000\u009f\u008b\u0001\u0000\u0000\u0000\u009f"+
		"\u0095\u0001\u0000\u0000\u0000\u00a0\u000b\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a2\u0005\u000b\u0000\u0000\u00a2\u00a3\u0003\f\u0006\u0000\u00a3\u00a4"+
		"\u0005\f\u0000\u0000\u00a4\u00aa\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005"+
		"\u000b\u0000\u0000\u00a6\u00a7\u0003\u0006\u0003\u0000\u00a7\u00a8\u0005"+
		"\f\u0000\u0000\u00a8\u00aa\u0001\u0000\u0000\u0000\u00a9\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a9\u00a5\u0001\u0000\u0000\u0000\u00aa\r\u0001\u0000\u0000"+
		"\u0000\u00ab\u00ae\u0003\u0010\b\u0000\u00ac\u00ae\u0003\f\u0006\u0000"+
		"\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000"+
		"\u00ae\u000f\u0001\u0000\u0000\u0000\u00af\u00b0\u0006\b\uffff\uffff\u0000"+
		"\u00b0\u00b1\u0005\u000b\u0000\u0000\u00b1\u00b2\u0003\u0010\b\u0000\u00b2"+
		"\u00b3\u0005\f\u0000\u0000\u00b3\u00b9\u0001\u0000\u0000\u0000\u00b4\u00b9"+
		"\u0003 \u0010\u0000\u00b5\u00b9\u0003\u0012\t\u0000\u00b6\u00b9\u0003"+
		"\u0014\n\u0000\u00b7\u00b9\u0003\u001e\u000f\u0000\u00b8\u00af\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b4\u0001\u0000\u0000\u0000\u00b8\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b7\u0001\u0000"+
		"\u0000\u0000\u00b9\u00c0\u0001\u0000\u0000\u0000\u00ba\u00bb\n\u0005\u0000"+
		"\u0000\u00bb\u00bc\u0003\u001c\u000e\u0000\u00bc\u00bd\u0003\u0010\b\u0006"+
		"\u00bd\u00bf\u0001\u0000\u0000\u0000\u00be\u00ba\u0001\u0000\u0000\u0000"+
		"\u00bf\u00c2\u0001\u0000\u0000\u0000\u00c0\u00be\u0001\u0000\u0000\u0000"+
		"\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1\u0011\u0001\u0000\u0000\u0000"+
		"\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c3\u00c4\u0003\u0016\u000b\u0000"+
		"\u00c4\u00c5\u0005\u000b\u0000\u0000\u00c5\u00ca\u0003\u0006\u0003\u0000"+
		"\u00c6\u00c7\u0005\r\u0000\u0000\u00c7\u00c9\u0003\u0006\u0003\u0000\u00c8"+
		"\u00c6\u0001\u0000\u0000\u0000\u00c9\u00cc\u0001\u0000\u0000\u0000\u00ca"+
		"\u00c8\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb"+
		"\u00cd\u0001\u0000\u0000\u0000\u00cc\u00ca\u0001\u0000\u0000\u0000\u00cd"+
		"\u00ce\u0005\f\u0000\u0000\u00ce\u0013\u0001\u0000\u0000\u0000\u00cf\u00d0"+
		"\u0003\"\u0011\u0000\u00d0\u00d1\u0005\u000e\u0000\u0000\u00d1\u00d2\u0003"+
		"\"\u0011\u0000\u00d2\u0015\u0001\u0000\u0000\u0000\u00d3\u00d4\u0003\""+
		"\u0011\u0000\u00d4\u0017\u0001\u0000\u0000\u0000\u00d5\u00dd\u0005\u0004"+
		"\u0000\u0000\u00d6\u00d7\u0005\u000b\u0000\u0000\u00d7\u00d8\u0003\u0018"+
		"\f\u0000\u00d8\u00d9\u0005\f\u0000\u0000\u00d9\u00dd\u0001\u0000\u0000"+
		"\u0000\u00da\u00db\u0005\u0003\u0000\u0000\u00db\u00dd\u0003\u001a\r\u0000"+
		"\u00dc\u00d5\u0001\u0000\u0000\u0000\u00dc\u00d6\u0001\u0000\u0000\u0000"+
		"\u00dc\u00da\u0001\u0000\u0000\u0000\u00dd\u0019\u0001\u0000\u0000\u0000"+
		"\u00de\u00e6\u0005\u0005\u0000\u0000\u00df\u00e0\u0005\u000b\u0000\u0000"+
		"\u00e0\u00e1\u0003\u001a\r\u0000\u00e1\u00e2\u0005\f\u0000\u0000\u00e2"+
		"\u00e6\u0001\u0000\u0000\u0000\u00e3\u00e4\u0005\u0003\u0000\u0000\u00e4"+
		"\u00e6\u0003\u0018\f\u0000\u00e5\u00de\u0001\u0000\u0000\u0000\u00e5\u00df"+
		"\u0001\u0000\u0000\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e6\u001b"+
		"\u0001\u0000\u0000\u0000\u00e7\u00e8\u0007\u0000\u0000\u0000\u00e8\u001d"+
		"\u0001\u0000\u0000\u0000\u00e9\u00ee\u0003 \u0010\u0000\u00ea\u00ee\u0005"+
		"\u0010\u0000\u0000\u00eb\u00ee\u0005\u000f\u0000\u0000\u00ec\u00ee\u0005"+
		"\u0011\u0000\u0000\u00ed\u00e9\u0001\u0000\u0000\u0000\u00ed\u00ea\u0001"+
		"\u0000\u0000\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ed\u00ec\u0001"+
		"\u0000\u0000\u0000\u00ee\u00f1\u0001\u0000\u0000\u0000\u00ef\u00ed\u0001"+
		"\u0000\u0000\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0\u001f\u0001"+
		"\u0000\u0000\u0000\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f2\u00f5\u0003"+
		"\u0018\f\u0000\u00f3\u00f5\u0003\u001a\r\u0000\u00f4\u00f2\u0001\u0000"+
		"\u0000\u0000\u00f4\u00f3\u0001\u0000\u0000\u0000\u00f5!\u0001\u0000\u0000"+
		"\u0000\u00f6\u00f7\u0005\u0010\u0000\u0000\u00f7#\u0001\u0000\u0000\u0000"+
		"\u0014%1=?FPXZ}\u009f\u00a9\u00ad\u00b8\u00c0\u00ca\u00dc\u00e5\u00ed"+
		"\u00ef\u00f4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}