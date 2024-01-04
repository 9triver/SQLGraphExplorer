// Generated from D:/Antlr-SQLGraphExplorer/SQLGraphExplorer/src/main/java/cn/edu/nju/tools/condition/grammar/simplifier/SimplifierParser.g4 by ANTLR 4.13.1
package cn.edu.nju.tools.condition.grammar.simplifier;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SimplifierParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AND=1, OR=2, NOT=3, TRUE=4, FALSE=5, GT=6, GE=7, LT=8, LE=9, EQ=10, LPAREN=11, 
		RPAREN=12, COMMA=13, DOT=14, DECIMAL=15, IDENTIFIER=16, PUNCTUATION=17, 
		WS=18;
	public static final int
		RULE_parse = 0, RULE_expression = 1, RULE_parenExpression = 2, RULE_notParenExpression = 3, 
		RULE_notExpression = 4, RULE_andExpression = 5, RULE_orExpression = 6, 
		RULE_basicExpression = 7, RULE_funcExpression = 8, RULE_colExpression = 9, 
		RULE_functionName = 10, RULE_trueExpression = 11, RULE_falseExpression = 12, 
		RULE_comparator = 13, RULE_atom = 14, RULE_bool = 15, RULE_identifer = 16, 
		RULE_logicOp = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "expression", "parenExpression", "notParenExpression", "notExpression", 
			"andExpression", "orExpression", "basicExpression", "funcExpression", 
			"colExpression", "functionName", "trueExpression", "falseExpression", 
			"comparator", "atom", "bool", "identifer", "logicOp"
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
	public String getGrammarFileName() { return "SimplifierParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimplifierParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParseContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SimplifierParser.EOF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitParse(this);
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
				expression();
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
	public static class ExpressionContext extends ParserRuleContext {
		public NotParenExpressionContext notParenExpression() {
			return getRuleContext(NotParenExpressionContext.class,0);
		}
		public ParenExpressionContext parenExpression() {
			return getRuleContext(ParenExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expression);
		try {
			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				notParenExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
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
		public TerminalNode LPAREN() { return getToken(SimplifierParser.LPAREN, 0); }
		public ParenExpressionContext parenExpression() {
			return getRuleContext(ParenExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SimplifierParser.RPAREN, 0); }
		public MultiParenExpressionContext(ParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitMultiParenExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleParenExpressionContext extends ParenExpressionContext {
		public TerminalNode LPAREN() { return getToken(SimplifierParser.LPAREN, 0); }
		public NotParenExpressionContext notParenExpression() {
			return getRuleContext(NotParenExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SimplifierParser.RPAREN, 0); }
		public SingleParenExpressionContext(ParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitSingleParenExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenExpressionContext parenExpression() throws RecognitionException {
		ParenExpressionContext _localctx = new ParenExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_parenExpression);
		try {
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new MultiParenExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				match(LPAREN);
				setState(46);
				parenExpression();
				setState(47);
				match(RPAREN);
				}
				break;
			case 2:
				_localctx = new SingleParenExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				match(LPAREN);
				setState(50);
				notParenExpression(0);
				setState(51);
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
	public static class NotParenBlockExpression1Context extends NotParenExpressionContext {
		public NotParenExpressionContext notParenExpression() {
			return getRuleContext(NotParenExpressionContext.class,0);
		}
		public LogicOpContext logicOp() {
			return getRuleContext(LogicOpContext.class,0);
		}
		public BasicExpressionContext basicExpression() {
			return getRuleContext(BasicExpressionContext.class,0);
		}
		public NotParenBlockExpression1Context(NotParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitNotParenBlockExpression1(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndDistributiveLawExpressionContext extends NotParenExpressionContext {
		public OrExpressionContext leftOr;
		public OrExpressionContext rightOr;
		public ParenExpressionContext leftBasic;
		public ParenExpressionContext rightBasic;
		public TerminalNode AND() { return getToken(SimplifierParser.AND, 0); }
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitAndDistributiveLawExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotParenBlockExpression3Context extends NotParenExpressionContext {
		public ParenExpressionContext parenExpression() {
			return getRuleContext(ParenExpressionContext.class,0);
		}
		public LogicOpContext logicOp() {
			return getRuleContext(LogicOpContext.class,0);
		}
		public BasicExpressionContext basicExpression() {
			return getRuleContext(BasicExpressionContext.class,0);
		}
		public NotParenBlockExpression3Context(NotParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitNotParenBlockExpression3(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotParenBlockExpression2Context extends NotParenExpressionContext {
		public NotParenExpressionContext notParenExpression() {
			return getRuleContext(NotParenExpressionContext.class,0);
		}
		public LogicOpContext logicOp() {
			return getRuleContext(LogicOpContext.class,0);
		}
		public ParenExpressionContext parenExpression() {
			return getRuleContext(ParenExpressionContext.class,0);
		}
		public NotParenBlockExpression2Context(NotParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitNotParenBlockExpression2(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AnnulmentLawExpressionContext extends NotParenExpressionContext {
		public ParenExpressionContext parenExpression() {
			return getRuleContext(ParenExpressionContext.class,0);
		}
		public TerminalNode AND() { return getToken(SimplifierParser.AND, 0); }
		public FalseExpressionContext falseExpression() {
			return getRuleContext(FalseExpressionContext.class,0);
		}
		public TerminalNode OR() { return getToken(SimplifierParser.OR, 0); }
		public TrueExpressionContext trueExpression() {
			return getRuleContext(TrueExpressionContext.class,0);
		}
		public AnnulmentLawExpressionContext(NotParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitAnnulmentLawExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentityLawExpressionContext extends NotParenExpressionContext {
		public ParenExpressionContext parenExpression() {
			return getRuleContext(ParenExpressionContext.class,0);
		}
		public TerminalNode OR() { return getToken(SimplifierParser.OR, 0); }
		public FalseExpressionContext falseExpression() {
			return getRuleContext(FalseExpressionContext.class,0);
		}
		public TerminalNode AND() { return getToken(SimplifierParser.AND, 0); }
		public TrueExpressionContext trueExpression() {
			return getRuleContext(TrueExpressionContext.class,0);
		}
		public IdentityLawExpressionContext(NotParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitIdentityLawExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotParenBlockExpression4Context extends NotParenExpressionContext {
		public TerminalNode NOT() { return getToken(SimplifierParser.NOT, 0); }
		public NotParenExpressionContext notParenExpression() {
			return getRuleContext(NotParenExpressionContext.class,0);
		}
		public NotParenBlockExpression4Context(NotParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitNotParenBlockExpression4(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotsExpressionContext extends NotParenExpressionContext {
		public NotExpressionContext notExpression() {
			return getRuleContext(NotExpressionContext.class,0);
		}
		public NotsExpressionContext(NotParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitNotsExpression(this);
			else return visitor.visitChildren(this);
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
		public List<TerminalNode> OR() { return getTokens(SimplifierParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(SimplifierParser.OR, i);
		}
		public OrBasicExpressionContext(NotParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitOrBasicExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BasicBlockExpressionContext extends NotParenExpressionContext {
		public BasicExpressionContext basicExpression() {
			return getRuleContext(BasicExpressionContext.class,0);
		}
		public BasicBlockExpressionContext(NotParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitBasicBlockExpression(this);
			else return visitor.visitChildren(this);
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
		public List<TerminalNode> AND() { return getTokens(SimplifierParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(SimplifierParser.AND, i);
		}
		public AndBasicExpressionContext(NotParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitAndBasicExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotParenExpressionContext notParenExpression() throws RecognitionException {
		return notParenExpression(0);
	}

	private NotParenExpressionContext notParenExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NotParenExpressionContext _localctx = new NotParenExpressionContext(_ctx, _parentState);
		NotParenExpressionContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_notParenExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				_localctx = new AnnulmentLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(56);
				parenExpression();
				setState(57);
				match(AND);
				setState(58);
				falseExpression();
				}
				break;
			case 2:
				{
				_localctx = new AnnulmentLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(60);
				falseExpression();
				setState(61);
				match(AND);
				setState(62);
				parenExpression();
				}
				break;
			case 3:
				{
				_localctx = new AnnulmentLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(64);
				parenExpression();
				setState(65);
				match(OR);
				setState(66);
				trueExpression();
				}
				break;
			case 4:
				{
				_localctx = new AnnulmentLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(68);
				trueExpression();
				setState(69);
				match(OR);
				setState(70);
				parenExpression();
				}
				break;
			case 5:
				{
				_localctx = new IdentityLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(72);
				parenExpression();
				setState(73);
				match(OR);
				setState(74);
				falseExpression();
				}
				break;
			case 6:
				{
				_localctx = new IdentityLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(76);
				falseExpression();
				setState(77);
				match(OR);
				setState(78);
				parenExpression();
				}
				break;
			case 7:
				{
				_localctx = new IdentityLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(80);
				parenExpression();
				setState(81);
				match(AND);
				setState(82);
				trueExpression();
				}
				break;
			case 8:
				{
				_localctx = new IdentityLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(84);
				trueExpression();
				setState(85);
				match(AND);
				setState(86);
				parenExpression();
				}
				break;
			case 9:
				{
				_localctx = new AndDistributiveLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88);
				((AndDistributiveLawExpressionContext)_localctx).leftOr = orExpression();
				setState(89);
				match(AND);
				setState(90);
				((AndDistributiveLawExpressionContext)_localctx).rightOr = orExpression();
				}
				break;
			case 10:
				{
				_localctx = new AndDistributiveLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(92);
				((AndDistributiveLawExpressionContext)_localctx).leftBasic = parenExpression();
				setState(93);
				match(AND);
				setState(94);
				((AndDistributiveLawExpressionContext)_localctx).rightOr = orExpression();
				}
				break;
			case 11:
				{
				_localctx = new AndDistributiveLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96);
				((AndDistributiveLawExpressionContext)_localctx).leftOr = orExpression();
				setState(97);
				match(AND);
				setState(98);
				((AndDistributiveLawExpressionContext)_localctx).rightBasic = parenExpression();
				}
				break;
			case 12:
				{
				_localctx = new BasicBlockExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(100);
				basicExpression(0);
				}
				break;
			case 13:
				{
				_localctx = new NotsExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(101);
				notExpression();
				}
				break;
			case 14:
				{
				_localctx = new AndBasicExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(102);
				parenExpression();
				setState(105); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(103);
						match(AND);
						setState(104);
						parenExpression();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(107); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 15:
				{
				_localctx = new OrBasicExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(109);
				parenExpression();
				setState(112); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(110);
						match(OR);
						setState(111);
						parenExpression();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(114); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 16:
				{
				_localctx = new NotParenBlockExpression3Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(116);
				parenExpression();
				setState(117);
				logicOp();
				setState(118);
				basicExpression(0);
				}
				break;
			case 17:
				{
				_localctx = new NotParenBlockExpression4Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(120);
				match(NOT);
				setState(121);
				notParenExpression(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(134);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(132);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new NotParenBlockExpression1Context(new NotParenExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_notParenExpression);
						setState(124);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(125);
						logicOp();
						setState(126);
						basicExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new NotParenBlockExpression2Context(new NotParenExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_notParenExpression);
						setState(128);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(129);
						logicOp();
						setState(130);
						parenExpression();
						}
						break;
					}
					} 
				}
				setState(136);
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
		public TerminalNode NOT() { return getToken(SimplifierParser.NOT, 0); }
		public AndExpressionContext andExpression() {
			return getRuleContext(AndExpressionContext.class,0);
		}
		public AndDeMorganLawExpressionContext(NotExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitAndDeMorganLawExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InvolutionLawExpressionContext extends NotExpressionContext {
		public List<TerminalNode> NOT() { return getTokens(SimplifierParser.NOT); }
		public TerminalNode NOT(int i) {
			return getToken(SimplifierParser.NOT, i);
		}
		public ParenExpressionContext parenExpression() {
			return getRuleContext(ParenExpressionContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(SimplifierParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimplifierParser.RPAREN, 0); }
		public InvolutionLawExpressionContext(NotExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitInvolutionLawExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleNotExpressionContext extends NotExpressionContext {
		public TerminalNode NOT() { return getToken(SimplifierParser.NOT, 0); }
		public ParenExpressionContext parenExpression() {
			return getRuleContext(ParenExpressionContext.class,0);
		}
		public SingleNotExpressionContext(NotExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitSingleNotExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotExpressionContext notExpression() throws RecognitionException {
		NotExpressionContext _localctx = new NotExpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_notExpression);
		try {
			setState(150);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new AndDeMorganLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				match(NOT);
				setState(138);
				andExpression();
				}
				break;
			case 2:
				_localctx = new InvolutionLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				match(NOT);
				setState(140);
				match(NOT);
				setState(141);
				parenExpression();
				}
				break;
			case 3:
				_localctx = new InvolutionLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(142);
				match(NOT);
				setState(143);
				match(LPAREN);
				setState(144);
				match(NOT);
				setState(145);
				parenExpression();
				setState(146);
				match(RPAREN);
				}
				break;
			case 4:
				_localctx = new SingleNotExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(148);
				match(NOT);
				setState(149);
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
		public TerminalNode LPAREN() { return getToken(SimplifierParser.LPAREN, 0); }
		public List<ParenExpressionContext> parenExpression() {
			return getRuleContexts(ParenExpressionContext.class);
		}
		public ParenExpressionContext parenExpression(int i) {
			return getRuleContext(ParenExpressionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(SimplifierParser.RPAREN, 0); }
		public List<TerminalNode> AND() { return getTokens(SimplifierParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(SimplifierParser.AND, i);
		}
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_andExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(LPAREN);
			setState(153);
			parenExpression();
			setState(156); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(154);
				match(AND);
				setState(155);
				parenExpression();
				}
				}
				setState(158); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==AND );
			setState(160);
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
		public TerminalNode LPAREN() { return getToken(SimplifierParser.LPAREN, 0); }
		public List<ParenExpressionContext> parenExpression() {
			return getRuleContexts(ParenExpressionContext.class);
		}
		public ParenExpressionContext parenExpression(int i) {
			return getRuleContext(ParenExpressionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(SimplifierParser.RPAREN, 0); }
		public List<TerminalNode> OR() { return getTokens(SimplifierParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(SimplifierParser.OR, i);
		}
		public OrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrExpressionContext orExpression() throws RecognitionException {
		OrExpressionContext _localctx = new OrExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_orExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(LPAREN);
			setState(163);
			parenExpression();
			setState(166); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(164);
				match(OR);
				setState(165);
				parenExpression();
				}
				}
				setState(168); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OR );
			setState(170);
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
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitCompareExpression(this);
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
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitBoolExpression(this);
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
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitAtomExpression(this);
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
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitColumnExpression(this);
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
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitFunctionExpression(this);
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
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_basicExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				_localctx = new BoolExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(173);
				bool();
				}
				break;
			case 2:
				{
				_localctx = new FunctionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(174);
				funcExpression();
				}
				break;
			case 3:
				{
				_localctx = new ColumnExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(175);
				colExpression();
				}
				break;
			case 4:
				{
				_localctx = new AtomExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(176);
				atom();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(185);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CompareExpressionContext(new BasicExpressionContext(_parentctx, _parentState));
					((CompareExpressionContext)_localctx).left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_basicExpression);
					setState(179);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(180);
					((CompareExpressionContext)_localctx).op = comparator();
					setState(181);
					((CompareExpressionContext)_localctx).right = basicExpression(6);
					}
					} 
				}
				setState(187);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
		public TerminalNode LPAREN() { return getToken(SimplifierParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(SimplifierParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SimplifierParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimplifierParser.COMMA, i);
		}
		public FuncExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitFuncExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncExpressionContext funcExpression() throws RecognitionException {
		FuncExpressionContext _localctx = new FuncExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_funcExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			functionName();
			setState(189);
			match(LPAREN);
			setState(190);
			expression();
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(191);
				match(COMMA);
				setState(192);
				expression();
				}
				}
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(198);
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
		public TerminalNode DOT() { return getToken(SimplifierParser.DOT, 0); }
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
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitColExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColExpressionContext colExpression() throws RecognitionException {
		ColExpressionContext _localctx = new ColExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_colExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			((ColExpressionContext)_localctx).table = identifer();
			setState(201);
			match(DOT);
			setState(202);
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
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitFunctionName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionNameContext functionName() throws RecognitionException {
		FunctionNameContext _localctx = new FunctionNameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_functionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
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
		public TerminalNode TRUE() { return getToken(SimplifierParser.TRUE, 0); }
		public TerminalNode LPAREN() { return getToken(SimplifierParser.LPAREN, 0); }
		public TrueExpressionContext trueExpression() {
			return getRuleContext(TrueExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SimplifierParser.RPAREN, 0); }
		public TerminalNode NOT() { return getToken(SimplifierParser.NOT, 0); }
		public FalseExpressionContext falseExpression() {
			return getRuleContext(FalseExpressionContext.class,0);
		}
		public TrueExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trueExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitTrueExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrueExpressionContext trueExpression() throws RecognitionException {
		TrueExpressionContext _localctx = new TrueExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_trueExpression);
		try {
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(206);
				match(TRUE);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(207);
				match(LPAREN);
				setState(208);
				trueExpression();
				setState(209);
				match(RPAREN);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 3);
				{
				setState(211);
				match(NOT);
				setState(212);
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
		public TerminalNode FALSE() { return getToken(SimplifierParser.FALSE, 0); }
		public TerminalNode LPAREN() { return getToken(SimplifierParser.LPAREN, 0); }
		public FalseExpressionContext falseExpression() {
			return getRuleContext(FalseExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SimplifierParser.RPAREN, 0); }
		public TerminalNode NOT() { return getToken(SimplifierParser.NOT, 0); }
		public TrueExpressionContext trueExpression() {
			return getRuleContext(TrueExpressionContext.class,0);
		}
		public FalseExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_falseExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitFalseExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FalseExpressionContext falseExpression() throws RecognitionException {
		FalseExpressionContext _localctx = new FalseExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_falseExpression);
		try {
			setState(222);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				match(FALSE);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				match(LPAREN);
				setState(217);
				falseExpression();
				setState(218);
				match(RPAREN);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 3);
				{
				setState(220);
				match(NOT);
				setState(221);
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
		public TerminalNode GT() { return getToken(SimplifierParser.GT, 0); }
		public TerminalNode GE() { return getToken(SimplifierParser.GE, 0); }
		public TerminalNode LT() { return getToken(SimplifierParser.LT, 0); }
		public TerminalNode LE() { return getToken(SimplifierParser.LE, 0); }
		public TerminalNode EQ() { return getToken(SimplifierParser.EQ, 0); }
		public ComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitComparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparatorContext comparator() throws RecognitionException {
		ComparatorContext _localctx = new ComparatorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_comparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
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
		public List<TerminalNode> IDENTIFIER() { return getTokens(SimplifierParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(SimplifierParser.IDENTIFIER, i);
		}
		public List<TerminalNode> DECIMAL() { return getTokens(SimplifierParser.DECIMAL); }
		public TerminalNode DECIMAL(int i) {
			return getToken(SimplifierParser.DECIMAL, i);
		}
		public List<TerminalNode> PUNCTUATION() { return getTokens(SimplifierParser.PUNCTUATION); }
		public TerminalNode PUNCTUATION(int i) {
			return getToken(SimplifierParser.PUNCTUATION, i);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_atom);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(230);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case NOT:
					case TRUE:
					case FALSE:
					case LPAREN:
						{
						setState(226);
						bool();
						}
						break;
					case IDENTIFIER:
						{
						setState(227);
						match(IDENTIFIER);
						}
						break;
					case DECIMAL:
						{
						setState(228);
						match(DECIMAL);
						}
						break;
					case PUNCTUATION:
						{
						setState(229);
						match(PUNCTUATION);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(234);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_bool);
		try {
			setState(237);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(235);
				trueExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
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
		public TerminalNode IDENTIFIER() { return getToken(SimplifierParser.IDENTIFIER, 0); }
		public IdentiferContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifer; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitIdentifer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentiferContext identifer() throws RecognitionException {
		IdentiferContext _localctx = new IdentiferContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_identifer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LogicOpContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(SimplifierParser.AND, 0); }
		public TerminalNode OR() { return getToken(SimplifierParser.OR, 0); }
		public LogicOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicOp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimplifierParserVisitor ) return ((SimplifierParserVisitor<? extends T>)visitor).visitLogicOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicOpContext logicOp() throws RecognitionException {
		LogicOpContext _localctx = new LogicOpContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_logicOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return notParenExpression_sempred((NotParenExpressionContext)_localctx, predIndex);
		case 7:
			return basicExpression_sempred((BasicExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean notParenExpression_sempred(NotParenExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean basicExpression_sempred(BasicExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0012\u00f4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0003"+
		"\u0000&\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0003"+
		"\u0001,\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00026\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0004\u0003j\b\u0003\u000b\u0003\f\u0003k\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0004\u0003q\b\u0003\u000b\u0003\f\u0003r\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003{\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u0085\b\u0003\n"+
		"\u0003\f\u0003\u0088\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u0097\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0004\u0005\u009d\b\u0005\u000b"+
		"\u0005\f\u0005\u009e\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0004\u0006\u00a7\b\u0006\u000b\u0006\f\u0006\u00a8"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u00b2\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0005\u0007\u00b8\b\u0007\n\u0007\f\u0007\u00bb\t\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00c2\b\b\n\b\f\b\u00c5\t\b"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u00d6\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u00df\b\f\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00e7\b\u000e\n\u000e\f\u000e"+
		"\u00ea\t\u000e\u0001\u000f\u0001\u000f\u0003\u000f\u00ee\b\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0000\u0002\u0006"+
		"\u000e\u0012\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"\u0000\u0002\u0001\u0000\u0006\n\u0001\u0000"+
		"\u0001\u0002\u010b\u0000%\u0001\u0000\u0000\u0000\u0002+\u0001\u0000\u0000"+
		"\u0000\u00045\u0001\u0000\u0000\u0000\u0006z\u0001\u0000\u0000\u0000\b"+
		"\u0096\u0001\u0000\u0000\u0000\n\u0098\u0001\u0000\u0000\u0000\f\u00a2"+
		"\u0001\u0000\u0000\u0000\u000e\u00b1\u0001\u0000\u0000\u0000\u0010\u00bc"+
		"\u0001\u0000\u0000\u0000\u0012\u00c8\u0001\u0000\u0000\u0000\u0014\u00cc"+
		"\u0001\u0000\u0000\u0000\u0016\u00d5\u0001\u0000\u0000\u0000\u0018\u00de"+
		"\u0001\u0000\u0000\u0000\u001a\u00e0\u0001\u0000\u0000\u0000\u001c\u00e8"+
		"\u0001\u0000\u0000\u0000\u001e\u00ed\u0001\u0000\u0000\u0000 \u00ef\u0001"+
		"\u0000\u0000\u0000\"\u00f1\u0001\u0000\u0000\u0000$&\u0003\u0002\u0001"+
		"\u0000%$\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&\'\u0001\u0000"+
		"\u0000\u0000\'(\u0005\u0000\u0000\u0001(\u0001\u0001\u0000\u0000\u0000"+
		"),\u0003\u0006\u0003\u0000*,\u0003\u0004\u0002\u0000+)\u0001\u0000\u0000"+
		"\u0000+*\u0001\u0000\u0000\u0000,\u0003\u0001\u0000\u0000\u0000-.\u0005"+
		"\u000b\u0000\u0000./\u0003\u0004\u0002\u0000/0\u0005\f\u0000\u000006\u0001"+
		"\u0000\u0000\u000012\u0005\u000b\u0000\u000023\u0003\u0006\u0003\u0000"+
		"34\u0005\f\u0000\u000046\u0001\u0000\u0000\u00005-\u0001\u0000\u0000\u0000"+
		"51\u0001\u0000\u0000\u00006\u0005\u0001\u0000\u0000\u000078\u0006\u0003"+
		"\uffff\uffff\u000089\u0003\u0004\u0002\u00009:\u0005\u0001\u0000\u0000"+
		":;\u0003\u0018\f\u0000;{\u0001\u0000\u0000\u0000<=\u0003\u0018\f\u0000"+
		"=>\u0005\u0001\u0000\u0000>?\u0003\u0004\u0002\u0000?{\u0001\u0000\u0000"+
		"\u0000@A\u0003\u0004\u0002\u0000AB\u0005\u0002\u0000\u0000BC\u0003\u0016"+
		"\u000b\u0000C{\u0001\u0000\u0000\u0000DE\u0003\u0016\u000b\u0000EF\u0005"+
		"\u0002\u0000\u0000FG\u0003\u0004\u0002\u0000G{\u0001\u0000\u0000\u0000"+
		"HI\u0003\u0004\u0002\u0000IJ\u0005\u0002\u0000\u0000JK\u0003\u0018\f\u0000"+
		"K{\u0001\u0000\u0000\u0000LM\u0003\u0018\f\u0000MN\u0005\u0002\u0000\u0000"+
		"NO\u0003\u0004\u0002\u0000O{\u0001\u0000\u0000\u0000PQ\u0003\u0004\u0002"+
		"\u0000QR\u0005\u0001\u0000\u0000RS\u0003\u0016\u000b\u0000S{\u0001\u0000"+
		"\u0000\u0000TU\u0003\u0016\u000b\u0000UV\u0005\u0001\u0000\u0000VW\u0003"+
		"\u0004\u0002\u0000W{\u0001\u0000\u0000\u0000XY\u0003\f\u0006\u0000YZ\u0005"+
		"\u0001\u0000\u0000Z[\u0003\f\u0006\u0000[{\u0001\u0000\u0000\u0000\\]"+
		"\u0003\u0004\u0002\u0000]^\u0005\u0001\u0000\u0000^_\u0003\f\u0006\u0000"+
		"_{\u0001\u0000\u0000\u0000`a\u0003\f\u0006\u0000ab\u0005\u0001\u0000\u0000"+
		"bc\u0003\u0004\u0002\u0000c{\u0001\u0000\u0000\u0000d{\u0003\u000e\u0007"+
		"\u0000e{\u0003\b\u0004\u0000fi\u0003\u0004\u0002\u0000gh\u0005\u0001\u0000"+
		"\u0000hj\u0003\u0004\u0002\u0000ig\u0001\u0000\u0000\u0000jk\u0001\u0000"+
		"\u0000\u0000ki\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000l{\u0001"+
		"\u0000\u0000\u0000mp\u0003\u0004\u0002\u0000no\u0005\u0002\u0000\u0000"+
		"oq\u0003\u0004\u0002\u0000pn\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000"+
		"\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000s{\u0001\u0000"+
		"\u0000\u0000tu\u0003\u0004\u0002\u0000uv\u0003\"\u0011\u0000vw\u0003\u000e"+
		"\u0007\u0000w{\u0001\u0000\u0000\u0000xy\u0005\u0003\u0000\u0000y{\u0003"+
		"\u0006\u0003\u0001z7\u0001\u0000\u0000\u0000z<\u0001\u0000\u0000\u0000"+
		"z@\u0001\u0000\u0000\u0000zD\u0001\u0000\u0000\u0000zH\u0001\u0000\u0000"+
		"\u0000zL\u0001\u0000\u0000\u0000zP\u0001\u0000\u0000\u0000zT\u0001\u0000"+
		"\u0000\u0000zX\u0001\u0000\u0000\u0000z\\\u0001\u0000\u0000\u0000z`\u0001"+
		"\u0000\u0000\u0000zd\u0001\u0000\u0000\u0000ze\u0001\u0000\u0000\u0000"+
		"zf\u0001\u0000\u0000\u0000zm\u0001\u0000\u0000\u0000zt\u0001\u0000\u0000"+
		"\u0000zx\u0001\u0000\u0000\u0000{\u0086\u0001\u0000\u0000\u0000|}\n\u0004"+
		"\u0000\u0000}~\u0003\"\u0011\u0000~\u007f\u0003\u000e\u0007\u0000\u007f"+
		"\u0085\u0001\u0000\u0000\u0000\u0080\u0081\n\u0003\u0000\u0000\u0081\u0082"+
		"\u0003\"\u0011\u0000\u0082\u0083\u0003\u0004\u0002\u0000\u0083\u0085\u0001"+
		"\u0000\u0000\u0000\u0084|\u0001\u0000\u0000\u0000\u0084\u0080\u0001\u0000"+
		"\u0000\u0000\u0085\u0088\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000"+
		"\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0007\u0001\u0000"+
		"\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0089\u008a\u0005\u0003"+
		"\u0000\u0000\u008a\u0097\u0003\n\u0005\u0000\u008b\u008c\u0005\u0003\u0000"+
		"\u0000\u008c\u008d\u0005\u0003\u0000\u0000\u008d\u0097\u0003\u0004\u0002"+
		"\u0000\u008e\u008f\u0005\u0003\u0000\u0000\u008f\u0090\u0005\u000b\u0000"+
		"\u0000\u0090\u0091\u0005\u0003\u0000\u0000\u0091\u0092\u0003\u0004\u0002"+
		"\u0000\u0092\u0093\u0005\f\u0000\u0000\u0093\u0097\u0001\u0000\u0000\u0000"+
		"\u0094\u0095\u0005\u0003\u0000\u0000\u0095\u0097\u0003\u0004\u0002\u0000"+
		"\u0096\u0089\u0001\u0000\u0000\u0000\u0096\u008b\u0001\u0000\u0000\u0000"+
		"\u0096\u008e\u0001\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000"+
		"\u0097\t\u0001\u0000\u0000\u0000\u0098\u0099\u0005\u000b\u0000\u0000\u0099"+
		"\u009c\u0003\u0004\u0002\u0000\u009a\u009b\u0005\u0001\u0000\u0000\u009b"+
		"\u009d\u0003\u0004\u0002\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009d"+
		"\u009e\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009e"+
		"\u009f\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0"+
		"\u00a1\u0005\f\u0000\u0000\u00a1\u000b\u0001\u0000\u0000\u0000\u00a2\u00a3"+
		"\u0005\u000b\u0000\u0000\u00a3\u00a6\u0003\u0004\u0002\u0000\u00a4\u00a5"+
		"\u0005\u0002\u0000\u0000\u00a5\u00a7\u0003\u0004\u0002\u0000\u00a6\u00a4"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u00aa"+
		"\u0001\u0000\u0000\u0000\u00aa\u00ab\u0005\f\u0000\u0000\u00ab\r\u0001"+
		"\u0000\u0000\u0000\u00ac\u00ad\u0006\u0007\uffff\uffff\u0000\u00ad\u00b2"+
		"\u0003\u001e\u000f\u0000\u00ae\u00b2\u0003\u0010\b\u0000\u00af\u00b2\u0003"+
		"\u0012\t\u0000\u00b0\u00b2\u0003\u001c\u000e\u0000\u00b1\u00ac\u0001\u0000"+
		"\u0000\u0000\u00b1\u00ae\u0001\u0000\u0000\u0000\u00b1\u00af\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b9\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b4\n\u0005\u0000\u0000\u00b4\u00b5\u0003\u001a\r"+
		"\u0000\u00b5\u00b6\u0003\u000e\u0007\u0006\u00b6\u00b8\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b3\u0001\u0000\u0000\u0000\u00b8\u00bb\u0001\u0000\u0000"+
		"\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000"+
		"\u0000\u00ba\u000f\u0001\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000"+
		"\u0000\u00bc\u00bd\u0003\u0014\n\u0000\u00bd\u00be\u0005\u000b\u0000\u0000"+
		"\u00be\u00c3\u0003\u0002\u0001\u0000\u00bf\u00c0\u0005\r\u0000\u0000\u00c0"+
		"\u00c2\u0003\u0002\u0001\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000\u00c3"+
		"\u00c4\u0001\u0000\u0000\u0000\u00c4\u00c6\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c3\u0001\u0000\u0000\u0000\u00c6\u00c7\u0005\f\u0000\u0000\u00c7\u0011"+
		"\u0001\u0000\u0000\u0000\u00c8\u00c9\u0003 \u0010\u0000\u00c9\u00ca\u0005"+
		"\u000e\u0000\u0000\u00ca\u00cb\u0003 \u0010\u0000\u00cb\u0013\u0001\u0000"+
		"\u0000\u0000\u00cc\u00cd\u0003 \u0010\u0000\u00cd\u0015\u0001\u0000\u0000"+
		"\u0000\u00ce\u00d6\u0005\u0004\u0000\u0000\u00cf\u00d0\u0005\u000b\u0000"+
		"\u0000\u00d0\u00d1\u0003\u0016\u000b\u0000\u00d1\u00d2\u0005\f\u0000\u0000"+
		"\u00d2\u00d6\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005\u0003\u0000\u0000"+
		"\u00d4\u00d6\u0003\u0018\f\u0000\u00d5\u00ce\u0001\u0000\u0000\u0000\u00d5"+
		"\u00cf\u0001\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d6"+
		"\u0017\u0001\u0000\u0000\u0000\u00d7\u00df\u0005\u0005\u0000\u0000\u00d8"+
		"\u00d9\u0005\u000b\u0000\u0000\u00d9\u00da\u0003\u0018\f\u0000\u00da\u00db"+
		"\u0005\f\u0000\u0000\u00db\u00df\u0001\u0000\u0000\u0000\u00dc\u00dd\u0005"+
		"\u0003\u0000\u0000\u00dd\u00df\u0003\u0016\u000b\u0000\u00de\u00d7\u0001"+
		"\u0000\u0000\u0000\u00de\u00d8\u0001\u0000\u0000\u0000\u00de\u00dc\u0001"+
		"\u0000\u0000\u0000\u00df\u0019\u0001\u0000\u0000\u0000\u00e0\u00e1\u0007"+
		"\u0000\u0000\u0000\u00e1\u001b\u0001\u0000\u0000\u0000\u00e2\u00e7\u0003"+
		"\u001e\u000f\u0000\u00e3\u00e7\u0005\u0010\u0000\u0000\u00e4\u00e7\u0005"+
		"\u000f\u0000\u0000\u00e5\u00e7\u0005\u0011\u0000\u0000\u00e6\u00e2\u0001"+
		"\u0000\u0000\u0000\u00e6\u00e3\u0001\u0000\u0000\u0000\u00e6\u00e4\u0001"+
		"\u0000\u0000\u0000\u00e6\u00e5\u0001\u0000\u0000\u0000\u00e7\u00ea\u0001"+
		"\u0000\u0000\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001"+
		"\u0000\u0000\u0000\u00e9\u001d\u0001\u0000\u0000\u0000\u00ea\u00e8\u0001"+
		"\u0000\u0000\u0000\u00eb\u00ee\u0003\u0016\u000b\u0000\u00ec\u00ee\u0003"+
		"\u0018\f\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ed\u00ec\u0001\u0000"+
		"\u0000\u0000\u00ee\u001f\u0001\u0000\u0000\u0000\u00ef\u00f0\u0005\u0010"+
		"\u0000\u0000\u00f0!\u0001\u0000\u0000\u0000\u00f1\u00f2\u0007\u0001\u0000"+
		"\u0000\u00f2#\u0001\u0000\u0000\u0000\u0013%+5krz\u0084\u0086\u0096\u009e"+
		"\u00a8\u00b1\u00b9\u00c3\u00d5\u00de\u00e6\u00e8\u00ed";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}