// Generated from D:/Antlr-SQLGraphExplorer/SQLGraphExplorer/src/main/java/cn/edu/nju/core/tools/condition/grammar/spliter/SpliterParser.g4 by ANTLR 4.13.1
package cn.edu.nju.core.tools.condition.grammar.spliter;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SpliterParser}.
 */
public interface SpliterParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SpliterParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(SpliterParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpliterParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(SpliterParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rootAndsExpression}
	 * labeled alternative in {@link SpliterParser#rootExpression}.
	 * @param ctx the parse tree
	 */
	void enterRootAndsExpression(SpliterParser.RootAndsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rootAndsExpression}
	 * labeled alternative in {@link SpliterParser#rootExpression}.
	 * @param ctx the parse tree
	 */
	void exitRootAndsExpression(SpliterParser.RootAndsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rootOrsExpression}
	 * labeled alternative in {@link SpliterParser#rootExpression}.
	 * @param ctx the parse tree
	 */
	void enterRootOrsExpression(SpliterParser.RootOrsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rootOrsExpression}
	 * labeled alternative in {@link SpliterParser#rootExpression}.
	 * @param ctx the parse tree
	 */
	void exitRootOrsExpression(SpliterParser.RootOrsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiRootExpression}
	 * labeled alternative in {@link SpliterParser#rootExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiRootExpression(SpliterParser.MultiRootExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiRootExpression}
	 * labeled alternative in {@link SpliterParser#rootExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiRootExpression(SpliterParser.MultiRootExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orSplitsExression}
	 * labeled alternative in {@link SpliterParser#rootExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrSplitsExression(SpliterParser.OrSplitsExressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orSplitsExression}
	 * labeled alternative in {@link SpliterParser#rootExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrSplitsExression(SpliterParser.OrSplitsExressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cantSplitExpression}
	 * labeled alternative in {@link SpliterParser#rootExpression}.
	 * @param ctx the parse tree
	 */
	void enterCantSplitExpression(SpliterParser.CantSplitExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cantSplitExpression}
	 * labeled alternative in {@link SpliterParser#rootExpression}.
	 * @param ctx the parse tree
	 */
	void exitCantSplitExpression(SpliterParser.CantSplitExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orSplitBasicExpression}
	 * labeled alternative in {@link SpliterParser#orSplitExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrSplitBasicExpression(SpliterParser.OrSplitBasicExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orSplitBasicExpression}
	 * labeled alternative in {@link SpliterParser#orSplitExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrSplitBasicExpression(SpliterParser.OrSplitBasicExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orSplitParenExpression}
	 * labeled alternative in {@link SpliterParser#orSplitExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrSplitParenExpression(SpliterParser.OrSplitParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orSplitParenExpression}
	 * labeled alternative in {@link SpliterParser#orSplitExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrSplitParenExpression(SpliterParser.OrSplitParenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orSplitRecursiveExpression}
	 * labeled alternative in {@link SpliterParser#orSplitExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrSplitRecursiveExpression(SpliterParser.OrSplitRecursiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orSplitRecursiveExpression}
	 * labeled alternative in {@link SpliterParser#orSplitExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrSplitRecursiveExpression(SpliterParser.OrSplitRecursiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andsExpression}
	 * labeled alternative in {@link SpliterParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndsExpression(SpliterParser.AndsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andsExpression}
	 * labeled alternative in {@link SpliterParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndsExpression(SpliterParser.AndsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link SpliterParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(SpliterParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link SpliterParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(SpliterParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link SpliterParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(SpliterParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link SpliterParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(SpliterParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parensExpression}
	 * labeled alternative in {@link SpliterParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParensExpression(SpliterParser.ParensExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parensExpression}
	 * labeled alternative in {@link SpliterParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParensExpression(SpliterParser.ParensExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link SpliterParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(SpliterParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link SpliterParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(SpliterParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orsExpression}
	 * labeled alternative in {@link SpliterParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrsExpression(SpliterParser.OrsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orsExpression}
	 * labeled alternative in {@link SpliterParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrsExpression(SpliterParser.OrsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code basicBlockExpression}
	 * labeled alternative in {@link SpliterParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBasicBlockExpression(SpliterParser.BasicBlockExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code basicBlockExpression}
	 * labeled alternative in {@link SpliterParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBasicBlockExpression(SpliterParser.BasicBlockExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiAndsRecursiveExpression}
	 * labeled alternative in {@link SpliterParser#multiAndsExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiAndsRecursiveExpression(SpliterParser.MultiAndsRecursiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiAndsRecursiveExpression}
	 * labeled alternative in {@link SpliterParser#multiAndsExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiAndsRecursiveExpression(SpliterParser.MultiAndsRecursiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiAndsBasicExpression}
	 * labeled alternative in {@link SpliterParser#multiAndsExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiAndsBasicExpression(SpliterParser.MultiAndsBasicExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiAndsBasicExpression}
	 * labeled alternative in {@link SpliterParser#multiAndsExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiAndsBasicExpression(SpliterParser.MultiAndsBasicExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiOrsRecursiveExpression}
	 * labeled alternative in {@link SpliterParser#multiOrsExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiOrsRecursiveExpression(SpliterParser.MultiOrsRecursiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiOrsRecursiveExpression}
	 * labeled alternative in {@link SpliterParser#multiOrsExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiOrsRecursiveExpression(SpliterParser.MultiOrsRecursiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiOrsBasicExpression}
	 * labeled alternative in {@link SpliterParser#multiOrsExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiOrsBasicExpression(SpliterParser.MultiOrsBasicExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiOrsBasicExpression}
	 * labeled alternative in {@link SpliterParser#multiOrsExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiOrsBasicExpression(SpliterParser.MultiOrsBasicExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiParenExpression}
	 * labeled alternative in {@link SpliterParser#parenExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiParenExpression(SpliterParser.MultiParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiParenExpression}
	 * labeled alternative in {@link SpliterParser#parenExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiParenExpression(SpliterParser.MultiParenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleParenExpression}
	 * labeled alternative in {@link SpliterParser#parenExpression}.
	 * @param ctx the parse tree
	 */
	void enterSingleParenExpression(SpliterParser.SingleParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleParenExpression}
	 * labeled alternative in {@link SpliterParser#parenExpression}.
	 * @param ctx the parse tree
	 */
	void exitSingleParenExpression(SpliterParser.SingleParenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unitBasicExpression}
	 * labeled alternative in {@link SpliterParser#unitExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnitBasicExpression(SpliterParser.UnitBasicExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unitBasicExpression}
	 * labeled alternative in {@link SpliterParser#unitExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnitBasicExpression(SpliterParser.UnitBasicExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unitParenExpression}
	 * labeled alternative in {@link SpliterParser#unitExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnitParenExpression(SpliterParser.UnitParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unitParenExpression}
	 * labeled alternative in {@link SpliterParser#unitExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnitParenExpression(SpliterParser.UnitParenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compareExpression}
	 * labeled alternative in {@link SpliterParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void enterCompareExpression(SpliterParser.CompareExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compareExpression}
	 * labeled alternative in {@link SpliterParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void exitCompareExpression(SpliterParser.CompareExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link SpliterParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpression(SpliterParser.BoolExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link SpliterParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpression(SpliterParser.BoolExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpression}
	 * labeled alternative in {@link SpliterParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpression(SpliterParser.AtomExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpression}
	 * labeled alternative in {@link SpliterParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpression(SpliterParser.AtomExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code columnExpression}
	 * labeled alternative in {@link SpliterParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void enterColumnExpression(SpliterParser.ColumnExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code columnExpression}
	 * labeled alternative in {@link SpliterParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void exitColumnExpression(SpliterParser.ColumnExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenBasicExpression}
	 * labeled alternative in {@link SpliterParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void enterParenBasicExpression(SpliterParser.ParenBasicExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenBasicExpression}
	 * labeled alternative in {@link SpliterParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void exitParenBasicExpression(SpliterParser.ParenBasicExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionExpression}
	 * labeled alternative in {@link SpliterParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpression(SpliterParser.FunctionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionExpression}
	 * labeled alternative in {@link SpliterParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpression(SpliterParser.FunctionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpliterParser#funcExpression}.
	 * @param ctx the parse tree
	 */
	void enterFuncExpression(SpliterParser.FuncExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpliterParser#funcExpression}.
	 * @param ctx the parse tree
	 */
	void exitFuncExpression(SpliterParser.FuncExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpliterParser#colExpression}.
	 * @param ctx the parse tree
	 */
	void enterColExpression(SpliterParser.ColExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpliterParser#colExpression}.
	 * @param ctx the parse tree
	 */
	void exitColExpression(SpliterParser.ColExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpliterParser#functionName}.
	 * @param ctx the parse tree
	 */
	void enterFunctionName(SpliterParser.FunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpliterParser#functionName}.
	 * @param ctx the parse tree
	 */
	void exitFunctionName(SpliterParser.FunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpliterParser#trueExpression}.
	 * @param ctx the parse tree
	 */
	void enterTrueExpression(SpliterParser.TrueExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpliterParser#trueExpression}.
	 * @param ctx the parse tree
	 */
	void exitTrueExpression(SpliterParser.TrueExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpliterParser#falseExpression}.
	 * @param ctx the parse tree
	 */
	void enterFalseExpression(SpliterParser.FalseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpliterParser#falseExpression}.
	 * @param ctx the parse tree
	 */
	void exitFalseExpression(SpliterParser.FalseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpliterParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterComparator(SpliterParser.ComparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpliterParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitComparator(SpliterParser.ComparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpliterParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(SpliterParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpliterParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(SpliterParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpliterParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(SpliterParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpliterParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(SpliterParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link SpliterParser#identifer}.
	 * @param ctx the parse tree
	 */
	void enterIdentifer(SpliterParser.IdentiferContext ctx);
	/**
	 * Exit a parse tree produced by {@link SpliterParser#identifer}.
	 * @param ctx the parse tree
	 */
	void exitIdentifer(SpliterParser.IdentiferContext ctx);
}