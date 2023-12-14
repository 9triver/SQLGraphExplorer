// Generated from D:/Antlr-SQLGraphExplorer/SQLGraphExplorer/src/main/java/cn/edu/nju/expression/cktuple/constraint/grammar/ConditionParser.g4 by ANTLR 4.13.1
package cn.edu.nju.expression.cktuple.constraint.grammar;
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
		RULE_parse = 0, RULE_expression = 1, RULE_parenExpression = 2, RULE_notParenExpression = 3, 
		RULE_notExpression = 4, RULE_andExpression = 5, RULE_orExpression = 6, 
		RULE_basicExpression = 7, RULE_funcExpression = 8, RULE_colExpression = 9, 
		RULE_functionName = 10, RULE_trueExpression = 11, RULE_falseExpression = 12, 
		RULE_comparator = 13, RULE_atom = 14, RULE_bool = 15, RULE_identifer = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "expression", "parenExpression", "notParenExpression", "notExpression", 
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
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expression);
		try {
			setState(41);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				notParenExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
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
		public TerminalNode LPAREN() { return getToken(ConditionParser.LPAREN, 0); }
		public ParenExpressionContext parenExpression() {
			return getRuleContext(ParenExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ConditionParser.RPAREN, 0); }
		public MultiParenExpressionContext(ParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitMultiParenExpression(this);
			else return visitor.visitChildren(this);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitSingleParenExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenExpressionContext parenExpression() throws RecognitionException {
		ParenExpressionContext _localctx = new ParenExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_parenExpression);
		try {
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new MultiParenExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				match(LPAREN);
				setState(44);
				parenExpression();
				setState(45);
				match(RPAREN);
				}
				break;
			case 2:
				_localctx = new SingleParenExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				match(LPAREN);
				setState(48);
				notParenExpression(0);
				setState(49);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitAndDistributiveLawExpression(this);
			else return visitor.visitChildren(this);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitIdentityLawExpression(this);
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
		public List<TerminalNode> OR() { return getTokens(ConditionParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(ConditionParser.OR, i);
		}
		public OrBasicExpressionContext(NotParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitOrBasicExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotParenBlockExpression1Context extends NotParenExpressionContext {
		public List<NotParenExpressionContext> notParenExpression() {
			return getRuleContexts(NotParenExpressionContext.class);
		}
		public NotParenExpressionContext notParenExpression(int i) {
			return getRuleContext(NotParenExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(ConditionParser.AND, 0); }
		public NotParenBlockExpression1Context(NotParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitNotParenBlockExpression1(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotParenBlockExpression3Context extends NotParenExpressionContext {
		public ParenExpressionContext parenExpression() {
			return getRuleContext(ParenExpressionContext.class,0);
		}
		public TerminalNode AND() { return getToken(ConditionParser.AND, 0); }
		public NotParenExpressionContext notParenExpression() {
			return getRuleContext(NotParenExpressionContext.class,0);
		}
		public NotParenBlockExpression3Context(NotParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitNotParenBlockExpression3(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotParenBlockExpression2Context extends NotParenExpressionContext {
		public NotParenExpressionContext notParenExpression() {
			return getRuleContext(NotParenExpressionContext.class,0);
		}
		public TerminalNode AND() { return getToken(ConditionParser.AND, 0); }
		public ParenExpressionContext parenExpression() {
			return getRuleContext(ParenExpressionContext.class,0);
		}
		public NotParenBlockExpression2Context(NotParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitNotParenBlockExpression2(this);
			else return visitor.visitChildren(this);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitAnnulmentLawExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotParenBlockExpression5Context extends NotParenExpressionContext {
		public NotParenExpressionContext notParenExpression() {
			return getRuleContext(NotParenExpressionContext.class,0);
		}
		public TerminalNode OR() { return getToken(ConditionParser.OR, 0); }
		public ParenExpressionContext parenExpression() {
			return getRuleContext(ParenExpressionContext.class,0);
		}
		public NotParenBlockExpression5Context(NotParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitNotParenBlockExpression5(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotParenBlockExpression4Context extends NotParenExpressionContext {
		public List<NotParenExpressionContext> notParenExpression() {
			return getRuleContexts(NotParenExpressionContext.class);
		}
		public NotParenExpressionContext notParenExpression(int i) {
			return getRuleContext(NotParenExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(ConditionParser.OR, 0); }
		public NotParenBlockExpression4Context(NotParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitNotParenBlockExpression4(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotParenBlockExpression7Context extends NotParenExpressionContext {
		public TerminalNode NOT() { return getToken(ConditionParser.NOT, 0); }
		public NotParenExpressionContext notParenExpression() {
			return getRuleContext(NotParenExpressionContext.class,0);
		}
		public NotParenBlockExpression7Context(NotParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitNotParenBlockExpression7(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotParenBlockExpression6Context extends NotParenExpressionContext {
		public ParenExpressionContext parenExpression() {
			return getRuleContext(ParenExpressionContext.class,0);
		}
		public TerminalNode OR() { return getToken(ConditionParser.OR, 0); }
		public NotParenExpressionContext notParenExpression() {
			return getRuleContext(NotParenExpressionContext.class,0);
		}
		public NotParenBlockExpression6Context(NotParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitNotParenBlockExpression6(this);
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
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitNotsExpression(this);
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
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitBasicBlockExpression(this);
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
		public List<TerminalNode> AND() { return getTokens(ConditionParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(ConditionParser.AND, i);
		}
		public AndBasicExpressionContext(NotParenExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitAndBasicExpression(this);
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
			setState(124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				_localctx = new AnnulmentLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(54);
				parenExpression();
				setState(55);
				match(AND);
				setState(56);
				falseExpression();
				}
				break;
			case 2:
				{
				_localctx = new AnnulmentLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(58);
				falseExpression();
				setState(59);
				match(AND);
				setState(60);
				parenExpression();
				}
				break;
			case 3:
				{
				_localctx = new AnnulmentLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(62);
				parenExpression();
				setState(63);
				match(OR);
				setState(64);
				trueExpression();
				}
				break;
			case 4:
				{
				_localctx = new AnnulmentLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(66);
				trueExpression();
				setState(67);
				match(OR);
				setState(68);
				parenExpression();
				}
				break;
			case 5:
				{
				_localctx = new IdentityLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(70);
				parenExpression();
				setState(71);
				match(OR);
				setState(72);
				falseExpression();
				}
				break;
			case 6:
				{
				_localctx = new IdentityLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(74);
				falseExpression();
				setState(75);
				match(OR);
				setState(76);
				parenExpression();
				}
				break;
			case 7:
				{
				_localctx = new IdentityLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78);
				parenExpression();
				setState(79);
				match(AND);
				setState(80);
				trueExpression();
				}
				break;
			case 8:
				{
				_localctx = new IdentityLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(82);
				trueExpression();
				setState(83);
				match(AND);
				setState(84);
				parenExpression();
				}
				break;
			case 9:
				{
				_localctx = new AndDistributiveLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86);
				((AndDistributiveLawExpressionContext)_localctx).leftOr = orExpression();
				setState(87);
				match(AND);
				setState(88);
				((AndDistributiveLawExpressionContext)_localctx).rightOr = orExpression();
				}
				break;
			case 10:
				{
				_localctx = new AndDistributiveLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90);
				((AndDistributiveLawExpressionContext)_localctx).leftBasic = parenExpression();
				setState(91);
				match(AND);
				setState(92);
				((AndDistributiveLawExpressionContext)_localctx).rightOr = orExpression();
				}
				break;
			case 11:
				{
				_localctx = new AndDistributiveLawExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(94);
				((AndDistributiveLawExpressionContext)_localctx).leftOr = orExpression();
				setState(95);
				match(AND);
				setState(96);
				((AndDistributiveLawExpressionContext)_localctx).rightBasic = parenExpression();
				}
				break;
			case 12:
				{
				_localctx = new BasicBlockExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(98);
				basicExpression(0);
				}
				break;
			case 13:
				{
				_localctx = new NotsExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(99);
				notExpression();
				}
				break;
			case 14:
				{
				_localctx = new AndBasicExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(100);
				parenExpression();
				setState(103); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(101);
						match(AND);
						setState(102);
						parenExpression();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(105); 
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
				setState(107);
				parenExpression();
				setState(110); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(108);
						match(OR);
						setState(109);
						parenExpression();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(112); 
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
				setState(114);
				parenExpression();
				setState(115);
				match(AND);
				setState(116);
				notParenExpression(5);
				}
				break;
			case 17:
				{
				_localctx = new NotParenBlockExpression6Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(118);
				parenExpression();
				setState(119);
				match(OR);
				setState(120);
				notParenExpression(2);
				}
				break;
			case 18:
				{
				_localctx = new NotParenBlockExpression7Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(122);
				match(NOT);
				setState(123);
				notParenExpression(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(140);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(138);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new NotParenBlockExpression1Context(new NotParenExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_notParenExpression);
						setState(126);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(127);
						match(AND);
						setState(128);
						notParenExpression(8);
						}
						break;
					case 2:
						{
						_localctx = new NotParenBlockExpression4Context(new NotParenExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_notParenExpression);
						setState(129);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(130);
						match(OR);
						setState(131);
						notParenExpression(5);
						}
						break;
					case 3:
						{
						_localctx = new NotParenBlockExpression2Context(new NotParenExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_notParenExpression);
						setState(132);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(133);
						match(AND);
						setState(134);
						parenExpression();
						}
						break;
					case 4:
						{
						_localctx = new NotParenBlockExpression5Context(new NotParenExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_notParenExpression);
						setState(135);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(136);
						match(OR);
						setState(137);
						parenExpression();
						}
						break;
					}
					} 
				}
				setState(142);
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
		public TerminalNode NOT() { return getToken(ConditionParser.NOT, 0); }
		public AndExpressionContext andExpression() {
			return getRuleContext(AndExpressionContext.class,0);
		}
		public AndDeMorganLawExpressionContext(NotExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitAndDeMorganLawExpression(this);
			else return visitor.visitChildren(this);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitInvolutionLawExpression(this);
			else return visitor.visitChildren(this);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitSingleNotExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotExpressionContext notExpression() throws RecognitionException {
		NotExpressionContext _localctx = new NotExpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_notExpression);
		try {
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new AndDeMorganLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				match(NOT);
				setState(144);
				andExpression();
				}
				break;
			case 2:
				_localctx = new InvolutionLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				match(NOT);
				setState(146);
				match(NOT);
				setState(147);
				parenExpression();
				}
				break;
			case 3:
				_localctx = new InvolutionLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(148);
				match(NOT);
				setState(149);
				match(LPAREN);
				setState(150);
				match(NOT);
				setState(151);
				parenExpression();
				setState(152);
				match(RPAREN);
				}
				break;
			case 4:
				_localctx = new SingleNotExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(154);
				match(NOT);
				setState(155);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitAndExpression(this);
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
			setState(158);
			match(LPAREN);
			setState(159);
			parenExpression();
			setState(162); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(160);
				match(AND);
				setState(161);
				parenExpression();
				}
				}
				setState(164); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==AND );
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitOrExpression(this);
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
			setState(168);
			match(LPAREN);
			setState(169);
			parenExpression();
			setState(172); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(170);
				match(OR);
				setState(171);
				parenExpression();
				}
				}
				setState(174); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OR );
			setState(176);
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
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_basicExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				_localctx = new BoolExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(179);
				bool();
				}
				break;
			case 2:
				{
				_localctx = new FunctionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(180);
				funcExpression();
				}
				break;
			case 3:
				{
				_localctx = new ColumnExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(181);
				colExpression();
				}
				break;
			case 4:
				{
				_localctx = new AtomExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(182);
				atom();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(191);
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
					setState(185);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(186);
					((CompareExpressionContext)_localctx).op = comparator();
					setState(187);
					((CompareExpressionContext)_localctx).right = basicExpression(6);
					}
					} 
				}
				setState(193);
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
		enterRule(_localctx, 16, RULE_funcExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			functionName();
			setState(195);
			match(LPAREN);
			setState(196);
			expression();
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(197);
				match(COMMA);
				setState(198);
				expression();
				}
				}
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(204);
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
		enterRule(_localctx, 18, RULE_colExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			((ColExpressionContext)_localctx).table = identifer();
			setState(207);
			match(DOT);
			setState(208);
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
		enterRule(_localctx, 20, RULE_functionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitTrueExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrueExpressionContext trueExpression() throws RecognitionException {
		TrueExpressionContext _localctx = new TrueExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_trueExpression);
		try {
			setState(219);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				match(TRUE);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
				match(LPAREN);
				setState(214);
				trueExpression();
				setState(215);
				match(RPAREN);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 3);
				{
				setState(217);
				match(NOT);
				setState(218);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitFalseExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FalseExpressionContext falseExpression() throws RecognitionException {
		FalseExpressionContext _localctx = new FalseExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_falseExpression);
		try {
			setState(228);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				match(FALSE);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				match(LPAREN);
				setState(223);
				falseExpression();
				setState(224);
				match(RPAREN);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 3);
				{
				setState(226);
				match(NOT);
				setState(227);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitComparator(this);
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
			setState(230);
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
		enterRule(_localctx, 28, RULE_atom);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(236);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case NOT:
					case TRUE:
					case FALSE:
					case LPAREN:
						{
						setState(232);
						bool();
						}
						break;
					case IDENTIFIER:
						{
						setState(233);
						match(IDENTIFIER);
						}
						break;
					case DECIMAL:
						{
						setState(234);
						match(DECIMAL);
						}
						break;
					case PUNCTUATION:
						{
						setState(235);
						match(PUNCTUATION);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(240);
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
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_bool);
		try {
			setState(243);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(241);
				trueExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(242);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitIdentifer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentiferContext identifer() throws RecognitionException {
		IdentiferContext _localctx = new IdentiferContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_identifer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
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
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean basicExpression_sempred(BasicExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0012\u00f8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0003\u0000$\b\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0003\u0001*\b\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u00024\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004"+
		"\u0003h\b\u0003\u000b\u0003\f\u0003i\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0004\u0003o\b\u0003\u000b\u0003\f\u0003p\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0003\u0003}\b\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u008b\b\u0003\n"+
		"\u0003\f\u0003\u008e\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u009d\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0004\u0005\u00a3\b\u0005\u000b"+
		"\u0005\f\u0005\u00a4\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0004\u0006\u00ad\b\u0006\u000b\u0006\f\u0006\u00ae"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u00b8\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0005\u0007\u00be\b\u0007\n\u0007\f\u0007\u00c1\t\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00c8\b\b\n\b\f\b\u00cb\t\b"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u00dc\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u00e5\b\f\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00ed\b\u000e\n\u000e\f\u000e"+
		"\u00f0\t\u000e\u0001\u000f\u0001\u000f\u0003\u000f\u00f4\b\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0000\u0002\u0006\u000e\u0011\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \u0000\u0001\u0001\u0000\u0006\n\u0113\u0000#\u0001\u0000\u0000\u0000"+
		"\u0002)\u0001\u0000\u0000\u0000\u00043\u0001\u0000\u0000\u0000\u0006|"+
		"\u0001\u0000\u0000\u0000\b\u009c\u0001\u0000\u0000\u0000\n\u009e\u0001"+
		"\u0000\u0000\u0000\f\u00a8\u0001\u0000\u0000\u0000\u000e\u00b7\u0001\u0000"+
		"\u0000\u0000\u0010\u00c2\u0001\u0000\u0000\u0000\u0012\u00ce\u0001\u0000"+
		"\u0000\u0000\u0014\u00d2\u0001\u0000\u0000\u0000\u0016\u00db\u0001\u0000"+
		"\u0000\u0000\u0018\u00e4\u0001\u0000\u0000\u0000\u001a\u00e6\u0001\u0000"+
		"\u0000\u0000\u001c\u00ee\u0001\u0000\u0000\u0000\u001e\u00f3\u0001\u0000"+
		"\u0000\u0000 \u00f5\u0001\u0000\u0000\u0000\"$\u0003\u0002\u0001\u0000"+
		"#\"\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000"+
		"\u0000%&\u0005\u0000\u0000\u0001&\u0001\u0001\u0000\u0000\u0000\'*\u0003"+
		"\u0006\u0003\u0000(*\u0003\u0004\u0002\u0000)\'\u0001\u0000\u0000\u0000"+
		")(\u0001\u0000\u0000\u0000*\u0003\u0001\u0000\u0000\u0000+,\u0005\u000b"+
		"\u0000\u0000,-\u0003\u0004\u0002\u0000-.\u0005\f\u0000\u0000.4\u0001\u0000"+
		"\u0000\u0000/0\u0005\u000b\u0000\u000001\u0003\u0006\u0003\u000012\u0005"+
		"\f\u0000\u000024\u0001\u0000\u0000\u00003+\u0001\u0000\u0000\u00003/\u0001"+
		"\u0000\u0000\u00004\u0005\u0001\u0000\u0000\u000056\u0006\u0003\uffff"+
		"\uffff\u000067\u0003\u0004\u0002\u000078\u0005\u0001\u0000\u000089\u0003"+
		"\u0018\f\u00009}\u0001\u0000\u0000\u0000:;\u0003\u0018\f\u0000;<\u0005"+
		"\u0001\u0000\u0000<=\u0003\u0004\u0002\u0000=}\u0001\u0000\u0000\u0000"+
		">?\u0003\u0004\u0002\u0000?@\u0005\u0002\u0000\u0000@A\u0003\u0016\u000b"+
		"\u0000A}\u0001\u0000\u0000\u0000BC\u0003\u0016\u000b\u0000CD\u0005\u0002"+
		"\u0000\u0000DE\u0003\u0004\u0002\u0000E}\u0001\u0000\u0000\u0000FG\u0003"+
		"\u0004\u0002\u0000GH\u0005\u0002\u0000\u0000HI\u0003\u0018\f\u0000I}\u0001"+
		"\u0000\u0000\u0000JK\u0003\u0018\f\u0000KL\u0005\u0002\u0000\u0000LM\u0003"+
		"\u0004\u0002\u0000M}\u0001\u0000\u0000\u0000NO\u0003\u0004\u0002\u0000"+
		"OP\u0005\u0001\u0000\u0000PQ\u0003\u0016\u000b\u0000Q}\u0001\u0000\u0000"+
		"\u0000RS\u0003\u0016\u000b\u0000ST\u0005\u0001\u0000\u0000TU\u0003\u0004"+
		"\u0002\u0000U}\u0001\u0000\u0000\u0000VW\u0003\f\u0006\u0000WX\u0005\u0001"+
		"\u0000\u0000XY\u0003\f\u0006\u0000Y}\u0001\u0000\u0000\u0000Z[\u0003\u0004"+
		"\u0002\u0000[\\\u0005\u0001\u0000\u0000\\]\u0003\f\u0006\u0000]}\u0001"+
		"\u0000\u0000\u0000^_\u0003\f\u0006\u0000_`\u0005\u0001\u0000\u0000`a\u0003"+
		"\u0004\u0002\u0000a}\u0001\u0000\u0000\u0000b}\u0003\u000e\u0007\u0000"+
		"c}\u0003\b\u0004\u0000dg\u0003\u0004\u0002\u0000ef\u0005\u0001\u0000\u0000"+
		"fh\u0003\u0004\u0002\u0000ge\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000"+
		"\u0000ig\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000j}\u0001\u0000"+
		"\u0000\u0000kn\u0003\u0004\u0002\u0000lm\u0005\u0002\u0000\u0000mo\u0003"+
		"\u0004\u0002\u0000nl\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000"+
		"pn\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000q}\u0001\u0000\u0000"+
		"\u0000rs\u0003\u0004\u0002\u0000st\u0005\u0001\u0000\u0000tu\u0003\u0006"+
		"\u0003\u0005u}\u0001\u0000\u0000\u0000vw\u0003\u0004\u0002\u0000wx\u0005"+
		"\u0002\u0000\u0000xy\u0003\u0006\u0003\u0002y}\u0001\u0000\u0000\u0000"+
		"z{\u0005\u0003\u0000\u0000{}\u0003\u0006\u0003\u0001|5\u0001\u0000\u0000"+
		"\u0000|:\u0001\u0000\u0000\u0000|>\u0001\u0000\u0000\u0000|B\u0001\u0000"+
		"\u0000\u0000|F\u0001\u0000\u0000\u0000|J\u0001\u0000\u0000\u0000|N\u0001"+
		"\u0000\u0000\u0000|R\u0001\u0000\u0000\u0000|V\u0001\u0000\u0000\u0000"+
		"|Z\u0001\u0000\u0000\u0000|^\u0001\u0000\u0000\u0000|b\u0001\u0000\u0000"+
		"\u0000|c\u0001\u0000\u0000\u0000|d\u0001\u0000\u0000\u0000|k\u0001\u0000"+
		"\u0000\u0000|r\u0001\u0000\u0000\u0000|v\u0001\u0000\u0000\u0000|z\u0001"+
		"\u0000\u0000\u0000}\u008c\u0001\u0000\u0000\u0000~\u007f\n\u0007\u0000"+
		"\u0000\u007f\u0080\u0005\u0001\u0000\u0000\u0080\u008b\u0003\u0006\u0003"+
		"\b\u0081\u0082\n\u0004\u0000\u0000\u0082\u0083\u0005\u0002\u0000\u0000"+
		"\u0083\u008b\u0003\u0006\u0003\u0005\u0084\u0085\n\u0006\u0000\u0000\u0085"+
		"\u0086\u0005\u0001\u0000\u0000\u0086\u008b\u0003\u0004\u0002\u0000\u0087"+
		"\u0088\n\u0003\u0000\u0000\u0088\u0089\u0005\u0002\u0000\u0000\u0089\u008b"+
		"\u0003\u0004\u0002\u0000\u008a~\u0001\u0000\u0000\u0000\u008a\u0081\u0001"+
		"\u0000\u0000\u0000\u008a\u0084\u0001\u0000\u0000\u0000\u008a\u0087\u0001"+
		"\u0000\u0000\u0000\u008b\u008e\u0001\u0000\u0000\u0000\u008c\u008a\u0001"+
		"\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u0007\u0001"+
		"\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008f\u0090\u0005"+
		"\u0003\u0000\u0000\u0090\u009d\u0003\n\u0005\u0000\u0091\u0092\u0005\u0003"+
		"\u0000\u0000\u0092\u0093\u0005\u0003\u0000\u0000\u0093\u009d\u0003\u0004"+
		"\u0002\u0000\u0094\u0095\u0005\u0003\u0000\u0000\u0095\u0096\u0005\u000b"+
		"\u0000\u0000\u0096\u0097\u0005\u0003\u0000\u0000\u0097\u0098\u0003\u0004"+
		"\u0002\u0000\u0098\u0099\u0005\f\u0000\u0000\u0099\u009d\u0001\u0000\u0000"+
		"\u0000\u009a\u009b\u0005\u0003\u0000\u0000\u009b\u009d\u0003\u0004\u0002"+
		"\u0000\u009c\u008f\u0001\u0000\u0000\u0000\u009c\u0091\u0001\u0000\u0000"+
		"\u0000\u009c\u0094\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000"+
		"\u0000\u009d\t\u0001\u0000\u0000\u0000\u009e\u009f\u0005\u000b\u0000\u0000"+
		"\u009f\u00a2\u0003\u0004\u0002\u0000\u00a0\u00a1\u0005\u0001\u0000\u0000"+
		"\u00a1\u00a3\u0003\u0004\u0002\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a7\u0005\f\u0000\u0000\u00a7\u000b\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a9\u0005\u000b\u0000\u0000\u00a9\u00ac\u0003\u0004\u0002\u0000\u00aa"+
		"\u00ab\u0005\u0002\u0000\u0000\u00ab\u00ad\u0003\u0004\u0002\u0000\u00ac"+
		"\u00aa\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae"+
		"\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af"+
		"\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005\f\u0000\u0000\u00b1\r"+
		"\u0001\u0000\u0000\u0000\u00b2\u00b3\u0006\u0007\uffff\uffff\u0000\u00b3"+
		"\u00b8\u0003\u001e\u000f\u0000\u00b4\u00b8\u0003\u0010\b\u0000\u00b5\u00b8"+
		"\u0003\u0012\t\u0000\u00b6\u00b8\u0003\u001c\u000e\u0000\u00b7\u00b2\u0001"+
		"\u0000\u0000\u0000\u00b7\u00b4\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001"+
		"\u0000\u0000\u0000\u00b7\u00b6\u0001\u0000\u0000\u0000\u00b8\u00bf\u0001"+
		"\u0000\u0000\u0000\u00b9\u00ba\n\u0005\u0000\u0000\u00ba\u00bb\u0003\u001a"+
		"\r\u0000\u00bb\u00bc\u0003\u000e\u0007\u0006\u00bc\u00be\u0001\u0000\u0000"+
		"\u0000\u00bd\u00b9\u0001\u0000\u0000\u0000\u00be\u00c1\u0001\u0000\u0000"+
		"\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000"+
		"\u0000\u00c0\u000f\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c3\u0003\u0014\n\u0000\u00c3\u00c4\u0005\u000b\u0000\u0000"+
		"\u00c4\u00c9\u0003\u0002\u0001\u0000\u00c5\u00c6\u0005\r\u0000\u0000\u00c6"+
		"\u00c8\u0003\u0002\u0001\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c8"+
		"\u00cb\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000\u00c9"+
		"\u00ca\u0001\u0000\u0000\u0000\u00ca\u00cc\u0001\u0000\u0000\u0000\u00cb"+
		"\u00c9\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005\f\u0000\u0000\u00cd\u0011"+
		"\u0001\u0000\u0000\u0000\u00ce\u00cf\u0003 \u0010\u0000\u00cf\u00d0\u0005"+
		"\u000e\u0000\u0000\u00d0\u00d1\u0003 \u0010\u0000\u00d1\u0013\u0001\u0000"+
		"\u0000\u0000\u00d2\u00d3\u0003 \u0010\u0000\u00d3\u0015\u0001\u0000\u0000"+
		"\u0000\u00d4\u00dc\u0005\u0004\u0000\u0000\u00d5\u00d6\u0005\u000b\u0000"+
		"\u0000\u00d6\u00d7\u0003\u0016\u000b\u0000\u00d7\u00d8\u0005\f\u0000\u0000"+
		"\u00d8\u00dc\u0001\u0000\u0000\u0000\u00d9\u00da\u0005\u0003\u0000\u0000"+
		"\u00da\u00dc\u0003\u0018\f\u0000\u00db\u00d4\u0001\u0000\u0000\u0000\u00db"+
		"\u00d5\u0001\u0000\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00dc"+
		"\u0017\u0001\u0000\u0000\u0000\u00dd\u00e5\u0005\u0005\u0000\u0000\u00de"+
		"\u00df\u0005\u000b\u0000\u0000\u00df\u00e0\u0003\u0018\f\u0000\u00e0\u00e1"+
		"\u0005\f\u0000\u0000\u00e1\u00e5\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005"+
		"\u0003\u0000\u0000\u00e3\u00e5\u0003\u0016\u000b\u0000\u00e4\u00dd\u0001"+
		"\u0000\u0000\u0000\u00e4\u00de\u0001\u0000\u0000\u0000\u00e4\u00e2\u0001"+
		"\u0000\u0000\u0000\u00e5\u0019\u0001\u0000\u0000\u0000\u00e6\u00e7\u0007"+
		"\u0000\u0000\u0000\u00e7\u001b\u0001\u0000\u0000\u0000\u00e8\u00ed\u0003"+
		"\u001e\u000f\u0000\u00e9\u00ed\u0005\u0010\u0000\u0000\u00ea\u00ed\u0005"+
		"\u000f\u0000\u0000\u00eb\u00ed\u0005\u0011\u0000\u0000\u00ec\u00e8\u0001"+
		"\u0000\u0000\u0000\u00ec\u00e9\u0001\u0000\u0000\u0000\u00ec\u00ea\u0001"+
		"\u0000\u0000\u0000\u00ec\u00eb\u0001\u0000\u0000\u0000\u00ed\u00f0\u0001"+
		"\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001"+
		"\u0000\u0000\u0000\u00ef\u001d\u0001\u0000\u0000\u0000\u00f0\u00ee\u0001"+
		"\u0000\u0000\u0000\u00f1\u00f4\u0003\u0016\u000b\u0000\u00f2\u00f4\u0003"+
		"\u0018\f\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f3\u00f2\u0001\u0000"+
		"\u0000\u0000\u00f4\u001f\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005\u0010"+
		"\u0000\u0000\u00f6!\u0001\u0000\u0000\u0000\u0013#)3ip|\u008a\u008c\u009c"+
		"\u00a4\u00ae\u00b7\u00bf\u00c9\u00db\u00e4\u00ec\u00ee\u00f3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}