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
		RULE_parse = 0, RULE_expression = 1, RULE_parenExpression = 2, RULE_notExpression = 3, 
		RULE_andExpression = 4, RULE_orExpression = 5, RULE_basicExpression = 6, 
		RULE_funcExpression = 7, RULE_colExpression = 8, RULE_functionName = 9, 
		RULE_trueExpression = 10, RULE_falseExpression = 11, RULE_comparator = 12, 
		RULE_atom = 13, RULE_bool = 14, RULE_identifer = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "expression", "parenExpression", "notExpression", "andExpression", 
			"orExpression", "basicExpression", "funcExpression", "colExpression", 
			"functionName", "trueExpression", "falseExpression", "comparator", "atom", 
			"bool", "identifer"
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
			setState(33);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(32);
				expression();
				}
				break;
			}
			setState(35);
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
	public static class AndDistributiveLawExpressionContext extends ExpressionContext {
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
		public AndDistributiveLawExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitAndDistributiveLawExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AnnulmentLawExpressionContext extends ExpressionContext {
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
		public AnnulmentLawExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitAnnulmentLawExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentityLawExpressionContext extends ExpressionContext {
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
		public IdentityLawExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitIdentityLawExpression(this);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitParensExpression(this);
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
		public OrBasicExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitOrBasicExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotsExpressionContext extends ExpressionContext {
		public NotExpressionContext notExpression() {
			return getRuleContext(NotExpressionContext.class,0);
		}
		public NotsExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitNotsExpression(this);
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
		public AndBasicExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionParserVisitor ) return ((ConditionParserVisitor<? extends T>)visitor).visitAndBasicExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expression);
		int _la;
		try {
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new BasicBlockExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				basicExpression(0);
				}
				break;
			case 2:
				_localctx = new AnnulmentLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
				parenExpression();
				setState(39);
				match(AND);
				setState(40);
				falseExpression();
				}
				break;
			case 3:
				_localctx = new AnnulmentLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(42);
				falseExpression();
				setState(43);
				match(AND);
				setState(44);
				parenExpression();
				}
				break;
			case 4:
				_localctx = new AnnulmentLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(46);
				parenExpression();
				setState(47);
				match(OR);
				setState(48);
				trueExpression();
				}
				break;
			case 5:
				_localctx = new AnnulmentLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(50);
				trueExpression();
				setState(51);
				match(OR);
				setState(52);
				parenExpression();
				}
				break;
			case 6:
				_localctx = new IdentityLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(54);
				parenExpression();
				setState(55);
				match(OR);
				setState(56);
				falseExpression();
				}
				break;
			case 7:
				_localctx = new IdentityLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(58);
				falseExpression();
				setState(59);
				match(OR);
				setState(60);
				parenExpression();
				}
				break;
			case 8:
				_localctx = new IdentityLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(62);
				parenExpression();
				setState(63);
				match(AND);
				setState(64);
				trueExpression();
				}
				break;
			case 9:
				_localctx = new IdentityLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(66);
				trueExpression();
				setState(67);
				match(AND);
				setState(68);
				parenExpression();
				}
				break;
			case 10:
				_localctx = new AndDistributiveLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(70);
				((AndDistributiveLawExpressionContext)_localctx).leftOr = orExpression();
				setState(71);
				match(AND);
				setState(72);
				((AndDistributiveLawExpressionContext)_localctx).rightOr = orExpression();
				}
				break;
			case 11:
				_localctx = new AndDistributiveLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(74);
				((AndDistributiveLawExpressionContext)_localctx).leftBasic = parenExpression();
				setState(75);
				match(AND);
				setState(76);
				((AndDistributiveLawExpressionContext)_localctx).rightOr = orExpression();
				}
				break;
			case 12:
				_localctx = new AndDistributiveLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(78);
				((AndDistributiveLawExpressionContext)_localctx).leftOr = orExpression();
				setState(79);
				match(AND);
				setState(80);
				((AndDistributiveLawExpressionContext)_localctx).rightBasic = parenExpression();
				}
				break;
			case 13:
				_localctx = new AndAllExpressionContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(82);
				andExpression();
				}
				break;
			case 14:
				_localctx = new OrAllExpressionContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(83);
				orExpression();
				}
				break;
			case 15:
				_localctx = new AndBasicExpressionContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(84);
				parenExpression();
				setState(87); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(85);
					match(AND);
					setState(86);
					parenExpression();
					}
					}
					setState(89); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==AND );
				}
				break;
			case 16:
				_localctx = new OrBasicExpressionContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(91);
				parenExpression();
				setState(94); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(92);
					match(OR);
					setState(93);
					parenExpression();
					}
					}
					setState(96); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==OR );
				}
				break;
			case 17:
				_localctx = new NotsExpressionContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(98);
				notExpression();
				}
				break;
			case 18:
				_localctx = new ParensExpressionContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(99);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new MultiParenExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				match(LPAREN);
				setState(103);
				parenExpression();
				setState(104);
				match(RPAREN);
				}
				break;
			case 2:
				_localctx = new SingleParenExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				match(LPAREN);
				setState(107);
				expression();
				setState(108);
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
		enterRule(_localctx, 6, RULE_notExpression);
		try {
			setState(125);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new AndDeMorganLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				match(NOT);
				setState(113);
				andExpression();
				}
				break;
			case 2:
				_localctx = new InvolutionLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				match(NOT);
				setState(115);
				match(NOT);
				setState(116);
				parenExpression();
				}
				break;
			case 3:
				_localctx = new InvolutionLawExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(117);
				match(NOT);
				setState(118);
				match(LPAREN);
				setState(119);
				match(NOT);
				setState(120);
				parenExpression();
				setState(121);
				match(RPAREN);
				}
				break;
			case 4:
				_localctx = new SingleNotExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(123);
				match(NOT);
				setState(124);
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
		enterRule(_localctx, 8, RULE_andExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(LPAREN);
			setState(128);
			parenExpression();
			setState(131); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(129);
				match(AND);
				setState(130);
				parenExpression();
				}
				}
				setState(133); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==AND );
			setState(135);
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
		enterRule(_localctx, 10, RULE_orExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(LPAREN);
			setState(138);
			parenExpression();
			setState(141); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(139);
				match(OR);
				setState(140);
				parenExpression();
				}
				}
				setState(143); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OR );
			setState(145);
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
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_basicExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new BoolExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(148);
				bool();
				}
				break;
			case 2:
				{
				_localctx = new FunctionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(149);
				funcExpression();
				}
				break;
			case 3:
				{
				_localctx = new ColumnExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(150);
				colExpression();
				}
				break;
			case 4:
				{
				_localctx = new AtomExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(151);
				atom();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(160);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CompareExpressionContext(new BasicExpressionContext(_parentctx, _parentState));
					((CompareExpressionContext)_localctx).left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_basicExpression);
					setState(154);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(155);
					((CompareExpressionContext)_localctx).op = comparator();
					setState(156);
					((CompareExpressionContext)_localctx).right = basicExpression(6);
					}
					} 
				}
				setState(162);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
		enterRule(_localctx, 14, RULE_funcExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			functionName();
			setState(164);
			match(LPAREN);
			setState(165);
			expression();
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(166);
				match(COMMA);
				setState(167);
				expression();
				}
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(173);
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
		enterRule(_localctx, 16, RULE_colExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			((ColExpressionContext)_localctx).table = identifer();
			setState(176);
			match(DOT);
			setState(177);
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
		enterRule(_localctx, 18, RULE_functionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
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
		enterRule(_localctx, 20, RULE_trueExpression);
		try {
			setState(188);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				match(TRUE);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(182);
				match(LPAREN);
				setState(183);
				trueExpression();
				setState(184);
				match(RPAREN);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 3);
				{
				setState(186);
				match(NOT);
				setState(187);
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
		enterRule(_localctx, 22, RULE_falseExpression);
		try {
			setState(197);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				match(FALSE);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				match(LPAREN);
				setState(192);
				falseExpression();
				setState(193);
				match(RPAREN);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 3);
				{
				setState(195);
				match(NOT);
				setState(196);
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
		enterRule(_localctx, 24, RULE_comparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
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
		enterRule(_localctx, 26, RULE_atom);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(205);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case NOT:
					case TRUE:
					case FALSE:
					case LPAREN:
						{
						setState(201);
						bool();
						}
						break;
					case IDENTIFIER:
						{
						setState(202);
						match(IDENTIFIER);
						}
						break;
					case DECIMAL:
						{
						setState(203);
						match(DECIMAL);
						}
						break;
					case PUNCTUATION:
						{
						setState(204);
						match(PUNCTUATION);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(209);
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
		enterRule(_localctx, 28, RULE_bool);
		try {
			setState(212);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				trueExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
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
		enterRule(_localctx, 30, RULE_identifer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
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
		case 6:
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
		"\u0004\u0001\u0012\u00d9\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0001\u0000\u0003\u0000\"\b\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0004\u0001X\b\u0001\u000b\u0001\f\u0001Y\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0004\u0001_\b\u0001\u000b\u0001\f\u0001`\u0001"+
		"\u0001\u0001\u0001\u0003\u0001e\b\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002o\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003~\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0004\u0004\u0084\b\u0004\u000b\u0004\f"+
		"\u0004\u0085\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0004\u0005\u008e\b\u0005\u000b\u0005\f\u0005\u008f\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006\u0099\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0005\u0006\u009f\b\u0006\n\u0006\f\u0006\u00a2\t\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00a9\b\u0007"+
		"\n\u0007\f\u0007\u00ac\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0003\n\u00bd\b\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00c6\b\u000b"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00ce\b\r\n\r"+
		"\f\r\u00d1\t\r\u0001\u000e\u0001\u000e\u0003\u000e\u00d5\b\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0000\u0001\f\u0010\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e\u0000\u0001"+
		"\u0001\u0000\u0006\n\u00f0\u0000!\u0001\u0000\u0000\u0000\u0002d\u0001"+
		"\u0000\u0000\u0000\u0004n\u0001\u0000\u0000\u0000\u0006}\u0001\u0000\u0000"+
		"\u0000\b\u007f\u0001\u0000\u0000\u0000\n\u0089\u0001\u0000\u0000\u0000"+
		"\f\u0098\u0001\u0000\u0000\u0000\u000e\u00a3\u0001\u0000\u0000\u0000\u0010"+
		"\u00af\u0001\u0000\u0000\u0000\u0012\u00b3\u0001\u0000\u0000\u0000\u0014"+
		"\u00bc\u0001\u0000\u0000\u0000\u0016\u00c5\u0001\u0000\u0000\u0000\u0018"+
		"\u00c7\u0001\u0000\u0000\u0000\u001a\u00cf\u0001\u0000\u0000\u0000\u001c"+
		"\u00d4\u0001\u0000\u0000\u0000\u001e\u00d6\u0001\u0000\u0000\u0000 \""+
		"\u0003\u0002\u0001\u0000! \u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000"+
		"\u0000\"#\u0001\u0000\u0000\u0000#$\u0005\u0000\u0000\u0001$\u0001\u0001"+
		"\u0000\u0000\u0000%e\u0003\f\u0006\u0000&\'\u0003\u0004\u0002\u0000\'"+
		"(\u0005\u0001\u0000\u0000()\u0003\u0016\u000b\u0000)e\u0001\u0000\u0000"+
		"\u0000*+\u0003\u0016\u000b\u0000+,\u0005\u0001\u0000\u0000,-\u0003\u0004"+
		"\u0002\u0000-e\u0001\u0000\u0000\u0000./\u0003\u0004\u0002\u0000/0\u0005"+
		"\u0002\u0000\u000001\u0003\u0014\n\u00001e\u0001\u0000\u0000\u000023\u0003"+
		"\u0014\n\u000034\u0005\u0002\u0000\u000045\u0003\u0004\u0002\u00005e\u0001"+
		"\u0000\u0000\u000067\u0003\u0004\u0002\u000078\u0005\u0002\u0000\u0000"+
		"89\u0003\u0016\u000b\u00009e\u0001\u0000\u0000\u0000:;\u0003\u0016\u000b"+
		"\u0000;<\u0005\u0002\u0000\u0000<=\u0003\u0004\u0002\u0000=e\u0001\u0000"+
		"\u0000\u0000>?\u0003\u0004\u0002\u0000?@\u0005\u0001\u0000\u0000@A\u0003"+
		"\u0014\n\u0000Ae\u0001\u0000\u0000\u0000BC\u0003\u0014\n\u0000CD\u0005"+
		"\u0001\u0000\u0000DE\u0003\u0004\u0002\u0000Ee\u0001\u0000\u0000\u0000"+
		"FG\u0003\n\u0005\u0000GH\u0005\u0001\u0000\u0000HI\u0003\n\u0005\u0000"+
		"Ie\u0001\u0000\u0000\u0000JK\u0003\u0004\u0002\u0000KL\u0005\u0001\u0000"+
		"\u0000LM\u0003\n\u0005\u0000Me\u0001\u0000\u0000\u0000NO\u0003\n\u0005"+
		"\u0000OP\u0005\u0001\u0000\u0000PQ\u0003\u0004\u0002\u0000Qe\u0001\u0000"+
		"\u0000\u0000Re\u0003\b\u0004\u0000Se\u0003\n\u0005\u0000TW\u0003\u0004"+
		"\u0002\u0000UV\u0005\u0001\u0000\u0000VX\u0003\u0004\u0002\u0000WU\u0001"+
		"\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000"+
		"YZ\u0001\u0000\u0000\u0000Ze\u0001\u0000\u0000\u0000[^\u0003\u0004\u0002"+
		"\u0000\\]\u0005\u0002\u0000\u0000]_\u0003\u0004\u0002\u0000^\\\u0001\u0000"+
		"\u0000\u0000_`\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000`a\u0001"+
		"\u0000\u0000\u0000ae\u0001\u0000\u0000\u0000be\u0003\u0006\u0003\u0000"+
		"ce\u0003\u0004\u0002\u0000d%\u0001\u0000\u0000\u0000d&\u0001\u0000\u0000"+
		"\u0000d*\u0001\u0000\u0000\u0000d.\u0001\u0000\u0000\u0000d2\u0001\u0000"+
		"\u0000\u0000d6\u0001\u0000\u0000\u0000d:\u0001\u0000\u0000\u0000d>\u0001"+
		"\u0000\u0000\u0000dB\u0001\u0000\u0000\u0000dF\u0001\u0000\u0000\u0000"+
		"dJ\u0001\u0000\u0000\u0000dN\u0001\u0000\u0000\u0000dR\u0001\u0000\u0000"+
		"\u0000dS\u0001\u0000\u0000\u0000dT\u0001\u0000\u0000\u0000d[\u0001\u0000"+
		"\u0000\u0000db\u0001\u0000\u0000\u0000dc\u0001\u0000\u0000\u0000e\u0003"+
		"\u0001\u0000\u0000\u0000fg\u0005\u000b\u0000\u0000gh\u0003\u0004\u0002"+
		"\u0000hi\u0005\f\u0000\u0000io\u0001\u0000\u0000\u0000jk\u0005\u000b\u0000"+
		"\u0000kl\u0003\u0002\u0001\u0000lm\u0005\f\u0000\u0000mo\u0001\u0000\u0000"+
		"\u0000nf\u0001\u0000\u0000\u0000nj\u0001\u0000\u0000\u0000o\u0005\u0001"+
		"\u0000\u0000\u0000pq\u0005\u0003\u0000\u0000q~\u0003\b\u0004\u0000rs\u0005"+
		"\u0003\u0000\u0000st\u0005\u0003\u0000\u0000t~\u0003\u0004\u0002\u0000"+
		"uv\u0005\u0003\u0000\u0000vw\u0005\u000b\u0000\u0000wx\u0005\u0003\u0000"+
		"\u0000xy\u0003\u0004\u0002\u0000yz\u0005\f\u0000\u0000z~\u0001\u0000\u0000"+
		"\u0000{|\u0005\u0003\u0000\u0000|~\u0003\u0004\u0002\u0000}p\u0001\u0000"+
		"\u0000\u0000}r\u0001\u0000\u0000\u0000}u\u0001\u0000\u0000\u0000}{\u0001"+
		"\u0000\u0000\u0000~\u0007\u0001\u0000\u0000\u0000\u007f\u0080\u0005\u000b"+
		"\u0000\u0000\u0080\u0083\u0003\u0004\u0002\u0000\u0081\u0082\u0005\u0001"+
		"\u0000\u0000\u0082\u0084\u0003\u0004\u0002\u0000\u0083\u0081\u0001\u0000"+
		"\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000"+
		"\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000"+
		"\u0000\u0000\u0087\u0088\u0005\f\u0000\u0000\u0088\t\u0001\u0000\u0000"+
		"\u0000\u0089\u008a\u0005\u000b\u0000\u0000\u008a\u008d\u0003\u0004\u0002"+
		"\u0000\u008b\u008c\u0005\u0002\u0000\u0000\u008c\u008e\u0003\u0004\u0002"+
		"\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000"+
		"\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000"+
		"\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0092\u0005\f\u0000\u0000"+
		"\u0092\u000b\u0001\u0000\u0000\u0000\u0093\u0094\u0006\u0006\uffff\uffff"+
		"\u0000\u0094\u0099\u0003\u001c\u000e\u0000\u0095\u0099\u0003\u000e\u0007"+
		"\u0000\u0096\u0099\u0003\u0010\b\u0000\u0097\u0099\u0003\u001a\r\u0000"+
		"\u0098\u0093\u0001\u0000\u0000\u0000\u0098\u0095\u0001\u0000\u0000\u0000"+
		"\u0098\u0096\u0001\u0000\u0000\u0000\u0098\u0097\u0001\u0000\u0000\u0000"+
		"\u0099\u00a0\u0001\u0000\u0000\u0000\u009a\u009b\n\u0005\u0000\u0000\u009b"+
		"\u009c\u0003\u0018\f\u0000\u009c\u009d\u0003\f\u0006\u0006\u009d\u009f"+
		"\u0001\u0000\u0000\u0000\u009e\u009a\u0001\u0000\u0000\u0000\u009f\u00a2"+
		"\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a0\u00a1"+
		"\u0001\u0000\u0000\u0000\u00a1\r\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001"+
		"\u0000\u0000\u0000\u00a3\u00a4\u0003\u0012\t\u0000\u00a4\u00a5\u0005\u000b"+
		"\u0000\u0000\u00a5\u00aa\u0003\u0002\u0001\u0000\u00a6\u00a7\u0005\r\u0000"+
		"\u0000\u00a7\u00a9\u0003\u0002\u0001\u0000\u00a8\u00a6\u0001\u0000\u0000"+
		"\u0000\u00a9\u00ac\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000"+
		"\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ad\u0001\u0000\u0000"+
		"\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005\f\u0000\u0000"+
		"\u00ae\u000f\u0001\u0000\u0000\u0000\u00af\u00b0\u0003\u001e\u000f\u0000"+
		"\u00b0\u00b1\u0005\u000e\u0000\u0000\u00b1\u00b2\u0003\u001e\u000f\u0000"+
		"\u00b2\u0011\u0001\u0000\u0000\u0000\u00b3\u00b4\u0003\u001e\u000f\u0000"+
		"\u00b4\u0013\u0001\u0000\u0000\u0000\u00b5\u00bd\u0005\u0004\u0000\u0000"+
		"\u00b6\u00b7\u0005\u000b\u0000\u0000\u00b7\u00b8\u0003\u0014\n\u0000\u00b8"+
		"\u00b9\u0005\f\u0000\u0000\u00b9\u00bd\u0001\u0000\u0000\u0000\u00ba\u00bb"+
		"\u0005\u0003\u0000\u0000\u00bb\u00bd\u0003\u0016\u000b\u0000\u00bc\u00b5"+
		"\u0001\u0000\u0000\u0000\u00bc\u00b6\u0001\u0000\u0000\u0000\u00bc\u00ba"+
		"\u0001\u0000\u0000\u0000\u00bd\u0015\u0001\u0000\u0000\u0000\u00be\u00c6"+
		"\u0005\u0005\u0000\u0000\u00bf\u00c0\u0005\u000b\u0000\u0000\u00c0\u00c1"+
		"\u0003\u0016\u000b\u0000\u00c1\u00c2\u0005\f\u0000\u0000\u00c2\u00c6\u0001"+
		"\u0000\u0000\u0000\u00c3\u00c4\u0005\u0003\u0000\u0000\u00c4\u00c6\u0003"+
		"\u0014\n\u0000\u00c5\u00be\u0001\u0000\u0000\u0000\u00c5\u00bf\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c6\u0017\u0001\u0000"+
		"\u0000\u0000\u00c7\u00c8\u0007\u0000\u0000\u0000\u00c8\u0019\u0001\u0000"+
		"\u0000\u0000\u00c9\u00ce\u0003\u001c\u000e\u0000\u00ca\u00ce\u0005\u0010"+
		"\u0000\u0000\u00cb\u00ce\u0005\u000f\u0000\u0000\u00cc\u00ce\u0005\u0011"+
		"\u0000\u0000\u00cd\u00c9\u0001\u0000\u0000\u0000\u00cd\u00ca\u0001\u0000"+
		"\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00cd\u00cc\u0001\u0000"+
		"\u0000\u0000\u00ce\u00d1\u0001\u0000\u0000\u0000\u00cf\u00cd\u0001\u0000"+
		"\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0\u001b\u0001\u0000"+
		"\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d2\u00d5\u0003\u0014"+
		"\n\u0000\u00d3\u00d5\u0003\u0016\u000b\u0000\u00d4\u00d2\u0001\u0000\u0000"+
		"\u0000\u00d4\u00d3\u0001\u0000\u0000\u0000\u00d5\u001d\u0001\u0000\u0000"+
		"\u0000\u00d6\u00d7\u0005\u0010\u0000\u0000\u00d7\u001f\u0001\u0000\u0000"+
		"\u0000\u0010!Y`dn}\u0085\u008f\u0098\u00a0\u00aa\u00bc\u00c5\u00cd\u00cf"+
		"\u00d4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}