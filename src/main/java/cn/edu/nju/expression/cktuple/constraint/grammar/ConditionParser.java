// Generated from D:/Antlr-SQLGraphExplorer/SQLGraphExplorer/src/main/java/cn/edu/nju/expression/cktuple/constraint/grammar/ConditionParser.g4 by ANTLR 4.13.1
package grammar;
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
		RULE_parse = 0, RULE_expression = 1, RULE_parenExpression = 2, RULE_andExpression = 3, 
		RULE_orExpression = 4, RULE_basicExpression = 5, RULE_funcExpression = 6, 
		RULE_colExpression = 7, RULE_functionName = 8, RULE_comparator = 9, RULE_atom = 10, 
		RULE_bool = 11, RULE_identifer = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "expression", "parenExpression", "andExpression", "orExpression", 
			"basicExpression", "funcExpression", "colExpression", "functionName", 
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(26);
				expression(0);
				}
				break;
			}
			setState(29);
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
	public static class AndDistributiveLawExpressionContext extends ExpressionContext {
		public OrExpressionContext leftOr;
		public OrExpressionContext rightOr;
		public BasicExpressionContext leftBasic;
		public BasicExpressionContext rightBasic;
		public TerminalNode AND() { return getToken(ConditionParser.AND, 0); }
		public List<OrExpressionContext> orExpression() {
			return getRuleContexts(OrExpressionContext.class);
		}
		public OrExpressionContext orExpression(int i) {
			return getRuleContext(OrExpressionContext.class,i);
		}
		public BasicExpressionContext basicExpression() {
			return getRuleContext(BasicExpressionContext.class,0);
		}
		public AndDistributiveLawExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitAndDistributiveLawExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentityLawExpressionContext extends ExpressionContext {
		public TerminalNode FALSE() { return getToken(ConditionParser.FALSE, 0); }
		public TerminalNode OR() { return getToken(ConditionParser.OR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode TRUE() { return getToken(ConditionParser.TRUE, 0); }
		public TerminalNode AND() { return getToken(ConditionParser.AND, 0); }
		public IdentityLawExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitIdentityLawExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InvolutionLawExpressionContext extends ExpressionContext {
		public List<TerminalNode> NOT() { return getTokens(ConditionParser.NOT); }
		public TerminalNode NOT(int i) {
			return getToken(ConditionParser.NOT, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> LPAREN() { return getTokens(ConditionParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(ConditionParser.LPAREN, i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(ConditionParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(ConditionParser.RPAREN, i);
		}
		public InvolutionLawExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitInvolutionLawExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndDeMorganLawExpressionContext extends ExpressionContext {
		public Token not;
		public AndExpressionContext andExpression() {
			return getRuleContext(AndExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(ConditionParser.NOT, 0); }
		public AndDeMorganLawExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitAndDeMorganLawExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotExpressionContext extends ExpressionContext {
		public TerminalNode NOT() { return getToken(ConditionParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitNotExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleParenExpressionContext extends ExpressionContext {
		public ParenExpressionContext parenExpression() {
			return getRuleContext(ParenExpressionContext.class,0);
		}
		public SingleParenExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitSingleParenExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndAllExpressionContext extends ExpressionContext {
		public AndExpressionContext andExpression() {
			return getRuleContext(AndExpressionContext.class,0);
		}
		public AndAllExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitAndAllExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrBasicExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(ConditionParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(ConditionParser.OR, i);
		}
		public OrBasicExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitOrBasicExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrAllExpressionContext extends ExpressionContext {
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public OrAllExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitOrAllExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiParenExpressionContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(ConditionParser.LPAREN, 0); }
		public ParenExpressionContext parenExpression() {
			return getRuleContext(ParenExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ConditionParser.RPAREN, 0); }
		public MultiParenExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitMultiParenExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AnnulmentLawExpressionContext extends ExpressionContext {
		public Token result;
		public TerminalNode AND() { return getToken(ConditionParser.AND, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FALSE() { return getToken(ConditionParser.FALSE, 0); }
		public TerminalNode OR() { return getToken(ConditionParser.OR, 0); }
		public TerminalNode TRUE() { return getToken(ConditionParser.TRUE, 0); }
		public AnnulmentLawExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitAnnulmentLawExpression(this);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitBasicBlockExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndBasicExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(ConditionParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(ConditionParser.AND, i);
		}
		public AndBasicExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitAndBasicExpression(this);
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
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				_localctx = new MultiParenExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(32);
				match(LPAREN);
				setState(33);
				parenExpression();
				setState(34);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new SingleParenExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(36);
				parenExpression();
				}
				break;
			case 3:
				{
				_localctx = new InvolutionLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(37);
				match(NOT);
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LPAREN) {
					{
					{
					setState(38);
					match(LPAREN);
					}
					}
					setState(43);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(44);
				match(NOT);
				setState(45);
				expression(0);
				setState(49);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(46);
						match(RPAREN);
						}
						} 
					}
					setState(51);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				}
				}
				break;
			case 4:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(52);
				match(NOT);
				setState(53);
				expression(18);
				}
				break;
			case 5:
				{
				_localctx = new AndAllExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(54);
				andExpression();
				}
				break;
			case 6:
				{
				_localctx = new OrAllExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(55);
				orExpression();
				}
				break;
			case 7:
				{
				_localctx = new AnnulmentLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(56);
				((AnnulmentLawExpressionContext)_localctx).result = match(FALSE);
				setState(57);
				match(AND);
				setState(58);
				expression(12);
				}
				break;
			case 8:
				{
				_localctx = new AnnulmentLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(59);
				((AnnulmentLawExpressionContext)_localctx).result = match(TRUE);
				setState(60);
				match(OR);
				setState(61);
				expression(10);
				}
				break;
			case 9:
				{
				_localctx = new IdentityLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(62);
				match(FALSE);
				setState(63);
				match(OR);
				setState(64);
				expression(8);
				}
				break;
			case 10:
				{
				_localctx = new IdentityLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(65);
				match(TRUE);
				setState(66);
				match(AND);
				setState(67);
				expression(6);
				}
				break;
			case 11:
				{
				_localctx = new AndDistributiveLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(68);
				((AndDistributiveLawExpressionContext)_localctx).leftOr = orExpression();
				setState(69);
				match(AND);
				setState(70);
				((AndDistributiveLawExpressionContext)_localctx).rightOr = orExpression();
				}
				break;
			case 12:
				{
				_localctx = new AndDistributiveLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(72);
				((AndDistributiveLawExpressionContext)_localctx).leftBasic = basicExpression(0);
				setState(73);
				match(AND);
				setState(74);
				((AndDistributiveLawExpressionContext)_localctx).rightOr = orExpression();
				}
				break;
			case 13:
				{
				_localctx = new AndDistributiveLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(76);
				((AndDistributiveLawExpressionContext)_localctx).leftOr = orExpression();
				setState(77);
				match(AND);
				setState(78);
				((AndDistributiveLawExpressionContext)_localctx).rightBasic = basicExpression(0);
				}
				break;
			case 14:
				{
				_localctx = new AndDeMorganLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(80);
				((AndDeMorganLawExpressionContext)_localctx).not = match(NOT);
				setState(81);
				andExpression();
				}
				break;
			case 15:
				{
				_localctx = new BasicBlockExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(82);
				basicExpression(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(113);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(111);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new AndBasicExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(85);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(88); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(86);
								match(AND);
								setState(87);
								expression(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(90); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					case 2:
						{
						_localctx = new OrBasicExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(92);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(95); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(93);
								match(OR);
								setState(94);
								expression(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(97); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					case 3:
						{
						_localctx = new AnnulmentLawExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(99);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(100);
						match(AND);
						setState(101);
						((AnnulmentLawExpressionContext)_localctx).result = match(FALSE);
						}
						break;
					case 4:
						{
						_localctx = new AnnulmentLawExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(102);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(103);
						match(OR);
						setState(104);
						((AnnulmentLawExpressionContext)_localctx).result = match(TRUE);
						}
						break;
					case 5:
						{
						_localctx = new IdentityLawExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(105);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(106);
						match(OR);
						setState(107);
						match(FALSE);
						}
						break;
					case 6:
						{
						_localctx = new IdentityLawExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(108);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(109);
						match(AND);
						setState(110);
						match(TRUE);
						}
						break;
					}
					} 
				}
				setState(115);
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
	public static class ParenExpressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(ConditionParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ConditionParser.RPAREN, 0); }
		public ParenExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitParenExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenExpressionContext parenExpression() throws RecognitionException {
		ParenExpressionContext _localctx = new ParenExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_parenExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(LPAREN);
			setState(117);
			expression(0);
			setState(118);
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
	public static class AndExpressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(ConditionParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_andExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(LPAREN);
			setState(121);
			expression(0);
			setState(124); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(122);
				match(AND);
				setState(123);
				expression(0);
				}
				}
				setState(126); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==AND );
			setState(128);
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrExpressionContext orExpression() throws RecognitionException {
		OrExpressionContext _localctx = new OrExpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_orExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(LPAREN);
			setState(131);
			expression(0);
			setState(134); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(132);
				match(OR);
				setState(133);
				expression(0);
				}
				}
				setState(136); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OR );
			setState(138);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitCompareExpression(this);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitBoolExpression(this);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitAtomExpression(this);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitColumnExpression(this);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitFunctionExpression(this);
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
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_basicExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				_localctx = new BoolExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(141);
				bool();
				}
				break;
			case 2:
				{
				_localctx = new FunctionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(142);
				funcExpression();
				}
				break;
			case 3:
				{
				_localctx = new ColumnExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(143);
				colExpression();
				}
				break;
			case 4:
				{
				_localctx = new AtomExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(144);
				atom();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(153);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CompareExpressionContext(new BasicExpressionContext(_parentctx, _parentState));
					((CompareExpressionContext)_localctx).left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_basicExpression);
					setState(147);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(148);
					((CompareExpressionContext)_localctx).op = comparator();
					setState(149);
					((CompareExpressionContext)_localctx).right = basicExpression(6);
					}
					} 
				}
				setState(155);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitFuncExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncExpressionContext funcExpression() throws RecognitionException {
		FuncExpressionContext _localctx = new FuncExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_funcExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			functionName();
			setState(157);
			match(LPAREN);
			setState(158);
			expression(0);
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(159);
				match(COMMA);
				setState(160);
				expression(0);
				}
				}
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(166);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitColExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColExpressionContext colExpression() throws RecognitionException {
		ColExpressionContext _localctx = new ColExpressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_colExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			((ColExpressionContext)_localctx).table = identifer();
			setState(169);
			match(DOT);
			setState(170);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitFunctionName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionNameContext functionName() throws RecognitionException {
		FunctionNameContext _localctx = new FunctionNameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_functionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitComparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparatorContext comparator() throws RecognitionException {
		ComparatorContext _localctx = new ComparatorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_comparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_atom);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(180);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case TRUE:
					case FALSE:
						{
						setState(176);
						bool();
						}
						break;
					case IDENTIFIER:
						{
						setState(177);
						match(IDENTIFIER);
						}
						break;
					case DECIMAL:
						{
						setState(178);
						match(DECIMAL);
						}
						break;
					case PUNCTUATION:
						{
						setState(179);
						match(PUNCTUATION);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(184);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
		public TerminalNode TRUE() { return getToken(ConditionParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(ConditionParser.FALSE, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
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
	public static class IdentiferContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ConditionParser.IDENTIFIER, 0); }
		public IdentiferContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifer; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitIdentifer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentiferContext identifer() throws RecognitionException {
		IdentiferContext _localctx = new IdentiferContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_identifer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
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
		case 1:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 5:
			return basicExpression_sempred((BasicExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 15);
		case 1:
			return precpred(_ctx, 14);
		case 2:
			return precpred(_ctx, 13);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 7);
		}
		return true;
	}
	private boolean basicExpression_sempred(BasicExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0012\u00be\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0001\u0000\u0003\u0000\u001c\b\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0005\u0001(\b\u0001\n\u0001\f\u0001+\t"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u00010\b\u0001\n\u0001"+
		"\f\u00013\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001T\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0004\u0001Y\b\u0001\u000b\u0001\f\u0001Z\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0004\u0001`\b\u0001\u000b\u0001\f\u0001a\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005"+
		"\u0001p\b\u0001\n\u0001\f\u0001s\t\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004"+
		"\u0003}\b\u0003\u000b\u0003\f\u0003~\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004\u0087\b\u0004\u000b\u0004"+
		"\f\u0004\u0088\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005\u0092\b\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0005\u0005\u0098\b\u0005\n\u0005\f\u0005\u009b"+
		"\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005"+
		"\u0006\u00a2\b\u0006\n\u0006\f\u0006\u00a5\t\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00b5\b\n\n\n\f\n\u00b8"+
		"\t\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0000\u0002\u0002"+
		"\n\r\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u0000\u0002\u0001\u0000\u0006\n\u0001\u0000\u0004\u0005\u00d4\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0002S\u0001\u0000\u0000\u0000\u0004t\u0001\u0000"+
		"\u0000\u0000\u0006x\u0001\u0000\u0000\u0000\b\u0082\u0001\u0000\u0000"+
		"\u0000\n\u0091\u0001\u0000\u0000\u0000\f\u009c\u0001\u0000\u0000\u0000"+
		"\u000e\u00a8\u0001\u0000\u0000\u0000\u0010\u00ac\u0001\u0000\u0000\u0000"+
		"\u0012\u00ae\u0001\u0000\u0000\u0000\u0014\u00b6\u0001\u0000\u0000\u0000"+
		"\u0016\u00b9\u0001\u0000\u0000\u0000\u0018\u00bb\u0001\u0000\u0000\u0000"+
		"\u001a\u001c\u0003\u0002\u0001\u0000\u001b\u001a\u0001\u0000\u0000\u0000"+
		"\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000\u0000\u0000"+
		"\u001d\u001e\u0005\u0000\u0000\u0001\u001e\u0001\u0001\u0000\u0000\u0000"+
		"\u001f \u0006\u0001\uffff\uffff\u0000 !\u0005\u000b\u0000\u0000!\"\u0003"+
		"\u0004\u0002\u0000\"#\u0005\f\u0000\u0000#T\u0001\u0000\u0000\u0000$T"+
		"\u0003\u0004\u0002\u0000%)\u0005\u0003\u0000\u0000&(\u0005\u000b\u0000"+
		"\u0000\'&\u0001\u0000\u0000\u0000(+\u0001\u0000\u0000\u0000)\'\u0001\u0000"+
		"\u0000\u0000)*\u0001\u0000\u0000\u0000*,\u0001\u0000\u0000\u0000+)\u0001"+
		"\u0000\u0000\u0000,-\u0005\u0003\u0000\u0000-1\u0003\u0002\u0001\u0000"+
		".0\u0005\f\u0000\u0000/.\u0001\u0000\u0000\u000003\u0001\u0000\u0000\u0000"+
		"1/\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u00002T\u0001\u0000\u0000"+
		"\u000031\u0001\u0000\u0000\u000045\u0005\u0003\u0000\u00005T\u0003\u0002"+
		"\u0001\u00126T\u0003\u0006\u0003\u00007T\u0003\b\u0004\u000089\u0005\u0005"+
		"\u0000\u00009:\u0005\u0001\u0000\u0000:T\u0003\u0002\u0001\f;<\u0005\u0004"+
		"\u0000\u0000<=\u0005\u0002\u0000\u0000=T\u0003\u0002\u0001\n>?\u0005\u0005"+
		"\u0000\u0000?@\u0005\u0002\u0000\u0000@T\u0003\u0002\u0001\bAB\u0005\u0004"+
		"\u0000\u0000BC\u0005\u0001\u0000\u0000CT\u0003\u0002\u0001\u0006DE\u0003"+
		"\b\u0004\u0000EF\u0005\u0001\u0000\u0000FG\u0003\b\u0004\u0000GT\u0001"+
		"\u0000\u0000\u0000HI\u0003\n\u0005\u0000IJ\u0005\u0001\u0000\u0000JK\u0003"+
		"\b\u0004\u0000KT\u0001\u0000\u0000\u0000LM\u0003\b\u0004\u0000MN\u0005"+
		"\u0001\u0000\u0000NO\u0003\n\u0005\u0000OT\u0001\u0000\u0000\u0000PQ\u0005"+
		"\u0003\u0000\u0000QT\u0003\u0006\u0003\u0000RT\u0003\n\u0005\u0000S\u001f"+
		"\u0001\u0000\u0000\u0000S$\u0001\u0000\u0000\u0000S%\u0001\u0000\u0000"+
		"\u0000S4\u0001\u0000\u0000\u0000S6\u0001\u0000\u0000\u0000S7\u0001\u0000"+
		"\u0000\u0000S8\u0001\u0000\u0000\u0000S;\u0001\u0000\u0000\u0000S>\u0001"+
		"\u0000\u0000\u0000SA\u0001\u0000\u0000\u0000SD\u0001\u0000\u0000\u0000"+
		"SH\u0001\u0000\u0000\u0000SL\u0001\u0000\u0000\u0000SP\u0001\u0000\u0000"+
		"\u0000SR\u0001\u0000\u0000\u0000Tq\u0001\u0000\u0000\u0000UX\n\u000f\u0000"+
		"\u0000VW\u0005\u0001\u0000\u0000WY\u0003\u0002\u0001\u0000XV\u0001\u0000"+
		"\u0000\u0000YZ\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001"+
		"\u0000\u0000\u0000[p\u0001\u0000\u0000\u0000\\_\n\u000e\u0000\u0000]^"+
		"\u0005\u0002\u0000\u0000^`\u0003\u0002\u0001\u0000_]\u0001\u0000\u0000"+
		"\u0000`a\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000"+
		"\u0000\u0000bp\u0001\u0000\u0000\u0000cd\n\r\u0000\u0000de\u0005\u0001"+
		"\u0000\u0000ep\u0005\u0005\u0000\u0000fg\n\u000b\u0000\u0000gh\u0005\u0002"+
		"\u0000\u0000hp\u0005\u0004\u0000\u0000ij\n\t\u0000\u0000jk\u0005\u0002"+
		"\u0000\u0000kp\u0005\u0005\u0000\u0000lm\n\u0007\u0000\u0000mn\u0005\u0001"+
		"\u0000\u0000np\u0005\u0004\u0000\u0000oU\u0001\u0000\u0000\u0000o\\\u0001"+
		"\u0000\u0000\u0000oc\u0001\u0000\u0000\u0000of\u0001\u0000\u0000\u0000"+
		"oi\u0001\u0000\u0000\u0000ol\u0001\u0000\u0000\u0000ps\u0001\u0000\u0000"+
		"\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000r\u0003\u0001"+
		"\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000tu\u0005\u000b\u0000\u0000"+
		"uv\u0003\u0002\u0001\u0000vw\u0005\f\u0000\u0000w\u0005\u0001\u0000\u0000"+
		"\u0000xy\u0005\u000b\u0000\u0000y|\u0003\u0002\u0001\u0000z{\u0005\u0001"+
		"\u0000\u0000{}\u0003\u0002\u0001\u0000|z\u0001\u0000\u0000\u0000}~\u0001"+
		"\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000"+
		"\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0081\u0005\f\u0000\u0000"+
		"\u0081\u0007\u0001\u0000\u0000\u0000\u0082\u0083\u0005\u000b\u0000\u0000"+
		"\u0083\u0086\u0003\u0002\u0001\u0000\u0084\u0085\u0005\u0002\u0000\u0000"+
		"\u0085\u0087\u0003\u0002\u0001\u0000\u0086\u0084\u0001\u0000\u0000\u0000"+
		"\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000"+
		"\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u0005\f\u0000\u0000\u008b\t\u0001\u0000\u0000\u0000\u008c"+
		"\u008d\u0006\u0005\uffff\uffff\u0000\u008d\u0092\u0003\u0016\u000b\u0000"+
		"\u008e\u0092\u0003\f\u0006\u0000\u008f\u0092\u0003\u000e\u0007\u0000\u0090"+
		"\u0092\u0003\u0014\n\u0000\u0091\u008c\u0001\u0000\u0000\u0000\u0091\u008e"+
		"\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091\u0090"+
		"\u0001\u0000\u0000\u0000\u0092\u0099\u0001\u0000\u0000\u0000\u0093\u0094"+
		"\n\u0005\u0000\u0000\u0094\u0095\u0003\u0012\t\u0000\u0095\u0096\u0003"+
		"\n\u0005\u0006\u0096\u0098\u0001\u0000\u0000\u0000\u0097\u0093\u0001\u0000"+
		"\u0000\u0000\u0098\u009b\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000"+
		"\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u000b\u0001\u0000"+
		"\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009c\u009d\u0003\u0010"+
		"\b\u0000\u009d\u009e\u0005\u000b\u0000\u0000\u009e\u00a3\u0003\u0002\u0001"+
		"\u0000\u009f\u00a0\u0005\r\u0000\u0000\u00a0\u00a2\u0003\u0002\u0001\u0000"+
		"\u00a1\u009f\u0001\u0000\u0000\u0000\u00a2\u00a5\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a6\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a7\u0005\f\u0000\u0000\u00a7\r\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a9\u0003\u0018\f\u0000\u00a9\u00aa\u0005\u000e\u0000\u0000\u00aa\u00ab"+
		"\u0003\u0018\f\u0000\u00ab\u000f\u0001\u0000\u0000\u0000\u00ac\u00ad\u0003"+
		"\u0018\f\u0000\u00ad\u0011\u0001\u0000\u0000\u0000\u00ae\u00af\u0007\u0000"+
		"\u0000\u0000\u00af\u0013\u0001\u0000\u0000\u0000\u00b0\u00b5\u0003\u0016"+
		"\u000b\u0000\u00b1\u00b5\u0005\u0010\u0000\u0000\u00b2\u00b5\u0005\u000f"+
		"\u0000\u0000\u00b3\u00b5\u0005\u0011\u0000\u0000\u00b4\u00b0\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b1\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b8\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000"+
		"\u0000\u0000\u00b7\u0015\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000"+
		"\u0000\u0000\u00b9\u00ba\u0007\u0001\u0000\u0000\u00ba\u0017\u0001\u0000"+
		"\u0000\u0000\u00bb\u00bc\u0005\u0010\u0000\u0000\u00bc\u0019\u0001\u0000"+
		"\u0000\u0000\u000f\u001b)1SZaoq~\u0088\u0091\u0099\u00a3\u00b4\u00b6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}