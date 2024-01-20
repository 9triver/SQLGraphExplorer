// Generated from D:/Antlr-SQLGraphExplorer/SQLGraphExplorer/src/main/java/cn/edu/nju/core/tools/ra/grammar/RelationalAlgebra.g4 by ANTLR 4.13.1
package cn.edu.nju.core.tools.ra.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class RelationalAlgebraParser extends Parser {
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
	public static final int
		RULE_start = 0, RULE_view = 1, RULE_expr = 2, RULE_attrlist = 3, RULE_condlist = 4, 
		RULE_function = 5, RULE_comparator = 6, RULE_compared = 7, RULE_relation = 8, 
		RULE_attribute = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "view", "expr", "attrlist", "condlist", "function", "comparator", 
			"compared", "relation", "attribute"
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

	@Override
	public String getGrammarFileName() { return "RelationalAlgebra.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RelationalAlgebraParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EOF() { return getToken(RelationalAlgebraParser.EOF, 0); }
		public List<ViewContext> view() {
			return getRuleContexts(ViewContext.class);
		}
		public ViewContext view(int i) {
			return getRuleContext(ViewContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(20);
					view();
					setState(21);
					match(T__0);
					}
					} 
				}
				setState(27);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(28);
			expr(0);
			setState(29);
			match(T__0);
			setState(30);
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
	public static class ViewContext extends ParserRuleContext {
		public ViewContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_view; }
	 
		public ViewContext() { }
		public void copyFrom(ViewContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ViewAssignmentContext extends ViewContext {
		public TerminalNode IDENTIFIER() { return getToken(RelationalAlgebraParser.IDENTIFIER, 0); }
		public TerminalNode EQUAL() { return getToken(RelationalAlgebraParser.EQUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ViewAssignmentContext(ViewContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterViewAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitViewAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitViewAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ViewContext view() throws RecognitionException {
		ViewContext _localctx = new ViewContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_view);
		try {
			_localctx = new ViewAssignmentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(IDENTIFIER);
			setState(33);
			match(EQUAL);
			setState(34);
			expr(0);
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
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DivisionContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DIVISION() { return getToken(RelationalAlgebraParser.DIVISION, 0); }
		public DivisionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterDivision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitDivision(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitDivision(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CartesianProductContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CARTESIAN_PRODUCT() { return getToken(RelationalAlgebraParser.CARTESIAN_PRODUCT, 0); }
		public CartesianProductContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterCartesianProduct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitCartesianProduct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitCartesianProduct(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelectionContext extends ExprContext {
		public TerminalNode SELECTION() { return getToken(RelationalAlgebraParser.SELECTION, 0); }
		public CondlistContext condlist() {
			return getRuleContext(CondlistContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SelectionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterSelection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitSelection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitSelection(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NaturalJoinContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NATURAL_JOIN() { return getToken(RelationalAlgebraParser.NATURAL_JOIN, 0); }
		public NaturalJoinContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterNaturalJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitNaturalJoin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitNaturalJoin(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelationFromExprContext extends ExprContext {
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public RelationFromExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterRelationFromExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitRelationFromExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitRelationFromExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntersectionContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode INTERSECTION() { return getToken(RelationalAlgebraParser.INTERSECTION, 0); }
		public IntersectionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterIntersection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitIntersection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitIntersection(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DifferenceContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DIFFERENCE() { return getToken(RelationalAlgebraParser.DIFFERENCE, 0); }
		public DifferenceContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterDifference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitDifference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitDifference(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ProjectionContext extends ExprContext {
		public TerminalNode PROJECTION() { return getToken(RelationalAlgebraParser.PROJECTION, 0); }
		public AttrlistContext attrlist() {
			return getRuleContext(AttrlistContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ProjectionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterProjection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitProjection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitProjection(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnionContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode UNION() { return getToken(RelationalAlgebraParser.UNION, 0); }
		public UnionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterUnion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitUnion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitUnion(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JoinContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode JOIN() { return getToken(RelationalAlgebraParser.JOIN, 0); }
		public CondlistContext condlist() {
			return getRuleContext(CondlistContext.class,0);
		}
		public JoinContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitJoin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitJoin(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BracketsExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BracketsExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterBracketsExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitBracketsExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitBracketsExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				_localctx = new RelationFromExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(37);
				relation();
				}
				break;
			case T__1:
				{
				_localctx = new BracketsExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(38);
				match(T__1);
				setState(39);
				expr(0);
				setState(40);
				match(T__2);
				}
				break;
			case PROJECTION:
				{
				_localctx = new ProjectionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(42);
				match(PROJECTION);
				setState(43);
				match(T__3);
				setState(44);
				attrlist();
				setState(45);
				match(T__4);
				setState(46);
				match(T__1);
				setState(47);
				expr(0);
				setState(48);
				match(T__2);
				}
				break;
			case SELECTION:
				{
				_localctx = new SelectionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(50);
				match(SELECTION);
				setState(51);
				match(T__3);
				setState(52);
				condlist(0);
				setState(53);
				match(T__4);
				setState(54);
				match(T__1);
				setState(55);
				expr(0);
				setState(56);
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(87);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(85);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new UnionContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(60);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(61);
						match(UNION);
						setState(62);
						expr(8);
						}
						break;
					case 2:
						{
						_localctx = new CartesianProductContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(63);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(64);
						match(CARTESIAN_PRODUCT);
						setState(65);
						expr(7);
						}
						break;
					case 3:
						{
						_localctx = new DifferenceContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(66);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(67);
						match(DIFFERENCE);
						setState(68);
						expr(6);
						}
						break;
					case 4:
						{
						_localctx = new NaturalJoinContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(69);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(70);
						match(NATURAL_JOIN);
						setState(71);
						expr(5);
						}
						break;
					case 5:
						{
						_localctx = new IntersectionContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(72);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(73);
						match(INTERSECTION);
						setState(74);
						expr(4);
						}
						break;
					case 6:
						{
						_localctx = new DivisionContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(75);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(76);
						match(DIVISION);
						setState(77);
						expr(2);
						}
						break;
					case 7:
						{
						_localctx = new JoinContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(78);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(79);
						match(JOIN);
						setState(80);
						expr(0);
						setState(81);
						match(T__3);
						setState(82);
						condlist(0);
						setState(83);
						match(T__4);
						}
						break;
					}
					} 
				}
				setState(89);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
	public static class AttrlistContext extends ParserRuleContext {
		public AttrlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrlist; }
	 
		public AttrlistContext() { }
		public void copyFrom(AttrlistContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttributeFromAttrlistContext extends AttrlistContext {
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public AttributeFromAttrlistContext(AttrlistContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterAttributeFromAttrlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitAttributeFromAttrlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitAttributeFromAttrlist(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttributeListContext extends AttrlistContext {
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public AttrlistContext attrlist() {
			return getRuleContext(AttrlistContext.class,0);
		}
		public AttributeListContext(AttrlistContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterAttributeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitAttributeList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitAttributeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrlistContext attrlist() throws RecognitionException {
		AttrlistContext _localctx = new AttrlistContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_attrlist);
		try {
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new AttributeFromAttrlistContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				attribute();
				}
				break;
			case 2:
				_localctx = new AttributeListContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				attribute();
				setState(92);
				match(T__5);
				setState(93);
				attrlist();
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
	public static class CondlistContext extends ParserRuleContext {
		public CondlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condlist; }
	 
		public CondlistContext() { }
		public void copyFrom(CondlistContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AtomCondlistContext extends CondlistContext {
		public List<TerminalNode> STRING() { return getTokens(RelationalAlgebraParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(RelationalAlgebraParser.STRING, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(RelationalAlgebraParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(RelationalAlgebraParser.IDENTIFIER, i);
		}
		public List<TerminalNode> DECIMAL() { return getTokens(RelationalAlgebraParser.DECIMAL); }
		public TerminalNode DECIMAL(int i) {
			return getToken(RelationalAlgebraParser.DECIMAL, i);
		}
		public List<TerminalNode> PUNCTUATION() { return getTokens(RelationalAlgebraParser.PUNCTUATION); }
		public TerminalNode PUNCTUATION(int i) {
			return getToken(RelationalAlgebraParser.PUNCTUATION, i);
		}
		public AtomCondlistContext(CondlistContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterAtomCondlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitAtomCondlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitAtomCondlist(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BracketsCondlistContext extends CondlistContext {
		public CondlistContext condlist() {
			return getRuleContext(CondlistContext.class,0);
		}
		public BracketsCondlistContext(CondlistContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterBracketsCondlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitBracketsCondlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitBracketsCondlist(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotCondlistContext extends CondlistContext {
		public CondlistContext condlist() {
			return getRuleContext(CondlistContext.class,0);
		}
		public NotCondlistContext(CondlistContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterNotCondlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitNotCondlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitNotCondlist(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparedCondlistContext extends CondlistContext {
		public List<ComparedContext> compared() {
			return getRuleContexts(ComparedContext.class);
		}
		public ComparedContext compared(int i) {
			return getRuleContext(ComparedContext.class,i);
		}
		public ComparatorContext comparator() {
			return getRuleContext(ComparatorContext.class,0);
		}
		public ComparedCondlistContext(CondlistContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterComparedCondlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitComparedCondlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitComparedCondlist(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncCondlistContext extends CondlistContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public FuncCondlistContext(CondlistContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterFuncCondlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitFuncCondlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitFuncCondlist(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndCondlistContext extends CondlistContext {
		public List<CondlistContext> condlist() {
			return getRuleContexts(CondlistContext.class);
		}
		public CondlistContext condlist(int i) {
			return getRuleContext(CondlistContext.class,i);
		}
		public TerminalNode BOOLEAN_AND() { return getToken(RelationalAlgebraParser.BOOLEAN_AND, 0); }
		public AndCondlistContext(CondlistContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterAndCondlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitAndCondlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitAndCondlist(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrCondlistContext extends CondlistContext {
		public List<CondlistContext> condlist() {
			return getRuleContexts(CondlistContext.class);
		}
		public CondlistContext condlist(int i) {
			return getRuleContext(CondlistContext.class,i);
		}
		public TerminalNode BOOLEAN_OR() { return getToken(RelationalAlgebraParser.BOOLEAN_OR, 0); }
		public OrCondlistContext(CondlistContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterOrCondlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitOrCondlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitOrCondlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondlistContext condlist() throws RecognitionException {
		return condlist(0);
	}

	private CondlistContext condlist(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CondlistContext _localctx = new CondlistContext(_ctx, _parentState);
		CondlistContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_condlist, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new NotCondlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(98);
				match(T__6);
				setState(99);
				condlist(5);
				}
				break;
			case 2:
				{
				_localctx = new BracketsCondlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(100);
				match(T__1);
				setState(101);
				condlist(0);
				setState(102);
				match(T__2);
				}
				break;
			case 3:
				{
				_localctx = new ComparedCondlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(104);
				compared();
				setState(105);
				comparator();
				setState(106);
				compared();
				}
				break;
			case 4:
				{
				_localctx = new FuncCondlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(108);
				function();
				}
				break;
			case 5:
				{
				_localctx = new AtomCondlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(112);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(109);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1811939328L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						} 
					}
					setState(114);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(125);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(123);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new OrCondlistContext(new CondlistContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condlist);
						setState(117);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(118);
						match(BOOLEAN_OR);
						setState(119);
						condlist(8);
						}
						break;
					case 2:
						{
						_localctx = new AndCondlistContext(new CondlistContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_condlist);
						setState(120);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(121);
						match(BOOLEAN_AND);
						setState(122);
						condlist(7);
						}
						break;
					}
					} 
				}
				setState(127);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
	public static class FunctionContext extends ParserRuleContext {
		public Token funcName;
		public List<CondlistContext> condlist() {
			return getRuleContexts(CondlistContext.class);
		}
		public CondlistContext condlist(int i) {
			return getRuleContext(CondlistContext.class,i);
		}
		public TerminalNode IDENTIFIER() { return getToken(RelationalAlgebraParser.IDENTIFIER, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			((FunctionContext)_localctx).funcName = match(IDENTIFIER);
			setState(129);
			match(T__1);
			setState(130);
			condlist(0);
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(131);
				match(T__5);
				setState(132);
				condlist(0);
				}
				}
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(138);
			match(T__2);
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
		public ComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparator; }
	 
		public ComparatorContext() { }
		public void copyFrom(ComparatorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualContext extends ComparatorContext {
		public TerminalNode EQUAL() { return getToken(RelationalAlgebraParser.EQUAL, 0); }
		public EqualContext(ComparatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LessThanContext extends ComparatorContext {
		public TerminalNode LESS_THAN() { return getToken(RelationalAlgebraParser.LESS_THAN, 0); }
		public LessThanContext(ComparatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterLessThan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitLessThan(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitLessThan(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GreaterEqualContext extends ComparatorContext {
		public TerminalNode GREATER_EQUAL() { return getToken(RelationalAlgebraParser.GREATER_EQUAL, 0); }
		public GreaterEqualContext(ComparatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterGreaterEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitGreaterEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitGreaterEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LessEqualContext extends ComparatorContext {
		public TerminalNode LESS_EQUAL() { return getToken(RelationalAlgebraParser.LESS_EQUAL, 0); }
		public LessEqualContext(ComparatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterLessEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitLessEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitLessEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NonEqualContext extends ComparatorContext {
		public TerminalNode NOT_EQUAL() { return getToken(RelationalAlgebraParser.NOT_EQUAL, 0); }
		public NonEqualContext(ComparatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterNonEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitNonEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitNonEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GreaterThanContext extends ComparatorContext {
		public TerminalNode GREATER_THAN() { return getToken(RelationalAlgebraParser.GREATER_THAN, 0); }
		public GreaterThanContext(ComparatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterGreaterThan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitGreaterThan(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitGreaterThan(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparatorContext comparator() throws RecognitionException {
		ComparatorContext _localctx = new ComparatorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_comparator);
		try {
			setState(146);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EQUAL:
				_localctx = new EqualContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				match(EQUAL);
				}
				break;
			case NOT_EQUAL:
				_localctx = new NonEqualContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				match(NOT_EQUAL);
				}
				break;
			case GREATER_THAN:
				_localctx = new GreaterThanContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(142);
				match(GREATER_THAN);
				}
				break;
			case GREATER_EQUAL:
				_localctx = new GreaterEqualContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(143);
				match(GREATER_EQUAL);
				}
				break;
			case LESS_THAN:
				_localctx = new LessThanContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(144);
				match(LESS_THAN);
				}
				break;
			case LESS_EQUAL:
				_localctx = new LessEqualContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(145);
				match(LESS_EQUAL);
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
	public static class ComparedContext extends ParserRuleContext {
		public ComparedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compared; }
	 
		public ComparedContext() { }
		public void copyFrom(ComparedContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringFromComparedContext extends ComparedContext {
		public TerminalNode STRING() { return getToken(RelationalAlgebraParser.STRING, 0); }
		public StringFromComparedContext(ComparedContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterStringFromCompared(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitStringFromCompared(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitStringFromCompared(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttributeFromComparedContext extends ComparedContext {
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public AttributeFromComparedContext(ComparedContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterAttributeFromCompared(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitAttributeFromCompared(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitAttributeFromCompared(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberFromComparedContext extends ComparedContext {
		public TerminalNode NUMBER() { return getToken(RelationalAlgebraParser.NUMBER, 0); }
		public NumberFromComparedContext(ComparedContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterNumberFromCompared(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitNumberFromCompared(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitNumberFromCompared(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionFromComparedContext extends ComparedContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public FunctionFromComparedContext(ComparedContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterFunctionFromCompared(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitFunctionFromCompared(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitFunctionFromCompared(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparedContext compared() throws RecognitionException {
		ComparedContext _localctx = new ComparedContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_compared);
		try {
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new AttributeFromComparedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				attribute();
				}
				break;
			case 2:
				_localctx = new StringFromComparedContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				match(STRING);
				}
				break;
			case 3:
				_localctx = new NumberFromComparedContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(150);
				match(NUMBER);
				}
				break;
			case 4:
				_localctx = new FunctionFromComparedContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(151);
				function();
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
	public static class RelationContext extends ParserRuleContext {
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
	 
		public RelationContext() { }
		public void copyFrom(RelationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelationIdentifierContext extends RelationContext {
		public TerminalNode IDENTIFIER() { return getToken(RelationalAlgebraParser.IDENTIFIER, 0); }
		public RelationIdentifierContext(RelationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterRelationIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitRelationIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitRelationIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationContext relation() throws RecognitionException {
		RelationContext _localctx = new RelationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_relation);
		try {
			_localctx = new RelationIdentifierContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
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
	public static class AttributeContext extends ParserRuleContext {
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
	 
		public AttributeContext() { }
		public void copyFrom(AttributeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttributeIdentifierContext extends AttributeContext {
		public TerminalNode IDENTIFIER() { return getToken(RelationalAlgebraParser.IDENTIFIER, 0); }
		public AttributeIdentifierContext(AttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).enterAttributeIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationalAlgebraListener ) ((RelationalAlgebraListener)listener).exitAttributeIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationalAlgebraVisitor ) return ((RelationalAlgebraVisitor<? extends T>)visitor).visitAttributeIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_attribute);
		try {
			_localctx = new AttributeIdentifierContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
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
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 4:
			return condlist_sempred((CondlistContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 1);
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean condlist_sempred(CondlistContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 7);
		case 8:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001!\u009f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000"+
		"\u0018\b\u0000\n\u0000\f\u0000\u001b\t\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002;\b\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0005\u0002V\b\u0002\n\u0002\f\u0002Y\t\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003`\b\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004o\b\u0004\n\u0004\f\u0004r\t\u0004\u0003\u0004t\b\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004|\b\u0004\n\u0004\f\u0004\u007f\t\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u0086\b\u0005\n"+
		"\u0005\f\u0005\u0089\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u0093"+
		"\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0099"+
		"\b\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0000\u0002\u0004\b\n"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0000\u0001\u0002\u0000"+
		"\u001a\u001b\u001d\u001e\u00b0\u0000\u0019\u0001\u0000\u0000\u0000\u0002"+
		" \u0001\u0000\u0000\u0000\u0004:\u0001\u0000\u0000\u0000\u0006_\u0001"+
		"\u0000\u0000\u0000\bs\u0001\u0000\u0000\u0000\n\u0080\u0001\u0000\u0000"+
		"\u0000\f\u0092\u0001\u0000\u0000\u0000\u000e\u0098\u0001\u0000\u0000\u0000"+
		"\u0010\u009a\u0001\u0000\u0000\u0000\u0012\u009c\u0001\u0000\u0000\u0000"+
		"\u0014\u0015\u0003\u0002\u0001\u0000\u0015\u0016\u0005\u0001\u0000\u0000"+
		"\u0016\u0018\u0001\u0000\u0000\u0000\u0017\u0014\u0001\u0000\u0000\u0000"+
		"\u0018\u001b\u0001\u0000\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000"+
		"\u0019\u001a\u0001\u0000\u0000\u0000\u001a\u001c\u0001\u0000\u0000\u0000"+
		"\u001b\u0019\u0001\u0000\u0000\u0000\u001c\u001d\u0003\u0004\u0002\u0000"+
		"\u001d\u001e\u0005\u0001\u0000\u0000\u001e\u001f\u0005\u0000\u0000\u0001"+
		"\u001f\u0001\u0001\u0000\u0000\u0000 !\u0005\u001b\u0000\u0000!\"\u0005"+
		"\u0011\u0000\u0000\"#\u0003\u0004\u0002\u0000#\u0003\u0001\u0000\u0000"+
		"\u0000$%\u0006\u0002\uffff\uffff\u0000%;\u0003\u0010\b\u0000&\'\u0005"+
		"\u0002\u0000\u0000\'(\u0003\u0004\u0002\u0000()\u0005\u0003\u0000\u0000"+
		");\u0001\u0000\u0000\u0000*+\u0005\b\u0000\u0000+,\u0005\u0004\u0000\u0000"+
		",-\u0003\u0006\u0003\u0000-.\u0005\u0005\u0000\u0000./\u0005\u0002\u0000"+
		"\u0000/0\u0003\u0004\u0002\u000001\u0005\u0003\u0000\u00001;\u0001\u0000"+
		"\u0000\u000023\u0005\t\u0000\u000034\u0005\u0004\u0000\u000045\u0003\b"+
		"\u0004\u000056\u0005\u0005\u0000\u000067\u0005\u0002\u0000\u000078\u0003"+
		"\u0004\u0002\u000089\u0005\u0003\u0000\u00009;\u0001\u0000\u0000\u0000"+
		":$\u0001\u0000\u0000\u0000:&\u0001\u0000\u0000\u0000:*\u0001\u0000\u0000"+
		"\u0000:2\u0001\u0000\u0000\u0000;W\u0001\u0000\u0000\u0000<=\n\u0007\u0000"+
		"\u0000=>\u0005\n\u0000\u0000>V\u0003\u0004\u0002\b?@\n\u0006\u0000\u0000"+
		"@A\u0005\f\u0000\u0000AV\u0003\u0004\u0002\u0007BC\n\u0005\u0000\u0000"+
		"CD\u0005\u000b\u0000\u0000DV\u0003\u0004\u0002\u0006EF\n\u0004\u0000\u0000"+
		"FG\u0005\u000e\u0000\u0000GV\u0003\u0004\u0002\u0005HI\n\u0003\u0000\u0000"+
		"IJ\u0005\r\u0000\u0000JV\u0003\u0004\u0002\u0004KL\n\u0001\u0000\u0000"+
		"LM\u0005\u0010\u0000\u0000MV\u0003\u0004\u0002\u0002NO\n\u0002\u0000\u0000"+
		"OP\u0005\u000f\u0000\u0000PQ\u0003\u0004\u0002\u0000QR\u0005\u0004\u0000"+
		"\u0000RS\u0003\b\u0004\u0000ST\u0005\u0005\u0000\u0000TV\u0001\u0000\u0000"+
		"\u0000U<\u0001\u0000\u0000\u0000U?\u0001\u0000\u0000\u0000UB\u0001\u0000"+
		"\u0000\u0000UE\u0001\u0000\u0000\u0000UH\u0001\u0000\u0000\u0000UK\u0001"+
		"\u0000\u0000\u0000UN\u0001\u0000\u0000\u0000VY\u0001\u0000\u0000\u0000"+
		"WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000X\u0005\u0001\u0000"+
		"\u0000\u0000YW\u0001\u0000\u0000\u0000Z`\u0003\u0012\t\u0000[\\\u0003"+
		"\u0012\t\u0000\\]\u0005\u0006\u0000\u0000]^\u0003\u0006\u0003\u0000^`"+
		"\u0001\u0000\u0000\u0000_Z\u0001\u0000\u0000\u0000_[\u0001\u0000\u0000"+
		"\u0000`\u0007\u0001\u0000\u0000\u0000ab\u0006\u0004\uffff\uffff\u0000"+
		"bc\u0005\u0007\u0000\u0000ct\u0003\b\u0004\u0005de\u0005\u0002\u0000\u0000"+
		"ef\u0003\b\u0004\u0000fg\u0005\u0003\u0000\u0000gt\u0001\u0000\u0000\u0000"+
		"hi\u0003\u000e\u0007\u0000ij\u0003\f\u0006\u0000jk\u0003\u000e\u0007\u0000"+
		"kt\u0001\u0000\u0000\u0000lt\u0003\n\u0005\u0000mo\u0007\u0000\u0000\u0000"+
		"nm\u0001\u0000\u0000\u0000or\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000"+
		"\u0000pq\u0001\u0000\u0000\u0000qt\u0001\u0000\u0000\u0000rp\u0001\u0000"+
		"\u0000\u0000sa\u0001\u0000\u0000\u0000sd\u0001\u0000\u0000\u0000sh\u0001"+
		"\u0000\u0000\u0000sl\u0001\u0000\u0000\u0000sp\u0001\u0000\u0000\u0000"+
		"t}\u0001\u0000\u0000\u0000uv\n\u0007\u0000\u0000vw\u0005\u0018\u0000\u0000"+
		"w|\u0003\b\u0004\bxy\n\u0006\u0000\u0000yz\u0005\u0017\u0000\u0000z|\u0003"+
		"\b\u0004\u0007{u\u0001\u0000\u0000\u0000{x\u0001\u0000\u0000\u0000|\u007f"+
		"\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000"+
		"\u0000~\t\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u0080"+
		"\u0081\u0005\u001b\u0000\u0000\u0081\u0082\u0005\u0002\u0000\u0000\u0082"+
		"\u0087\u0003\b\u0004\u0000\u0083\u0084\u0005\u0006\u0000\u0000\u0084\u0086"+
		"\u0003\b\u0004\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0086\u0089\u0001"+
		"\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001"+
		"\u0000\u0000\u0000\u0088\u008a\u0001\u0000\u0000\u0000\u0089\u0087\u0001"+
		"\u0000\u0000\u0000\u008a\u008b\u0005\u0003\u0000\u0000\u008b\u000b\u0001"+
		"\u0000\u0000\u0000\u008c\u0093\u0005\u0011\u0000\u0000\u008d\u0093\u0005"+
		"\u0012\u0000\u0000\u008e\u0093\u0005\u0013\u0000\u0000\u008f\u0093\u0005"+
		"\u0014\u0000\u0000\u0090\u0093\u0005\u0015\u0000\u0000\u0091\u0093\u0005"+
		"\u0016\u0000\u0000\u0092\u008c\u0001\u0000\u0000\u0000\u0092\u008d\u0001"+
		"\u0000\u0000\u0000\u0092\u008e\u0001\u0000\u0000\u0000\u0092\u008f\u0001"+
		"\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0092\u0091\u0001"+
		"\u0000\u0000\u0000\u0093\r\u0001\u0000\u0000\u0000\u0094\u0099\u0003\u0012"+
		"\t\u0000\u0095\u0099\u0005\u001a\u0000\u0000\u0096\u0099\u0005\u001c\u0000"+
		"\u0000\u0097\u0099\u0003\n\u0005\u0000\u0098\u0094\u0001\u0000\u0000\u0000"+
		"\u0098\u0095\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000"+
		"\u0098\u0097\u0001\u0000\u0000\u0000\u0099\u000f\u0001\u0000\u0000\u0000"+
		"\u009a\u009b\u0005\u001b\u0000\u0000\u009b\u0011\u0001\u0000\u0000\u0000"+
		"\u009c\u009d\u0005\u001b\u0000\u0000\u009d\u0013\u0001\u0000\u0000\u0000"+
		"\f\u0019:UW_ps{}\u0087\u0092\u0098";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}