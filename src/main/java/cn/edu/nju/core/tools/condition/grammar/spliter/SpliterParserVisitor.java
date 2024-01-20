// Generated from D:/Antlr-SQLGraphExplorer/SQLGraphExplorer/src/main/java/cn/edu/nju/core/tools/condition/grammar/spliter/SpliterParser.g4 by ANTLR 4.13.1
package cn.edu.nju.core.tools.condition.grammar.spliter;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SpliterParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SpliterParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SpliterParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(SpliterParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rootAndsExpression}
	 * labeled alternative in {@link SpliterParser#rootExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRootAndsExpression(SpliterParser.RootAndsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rootOrsExpression}
	 * labeled alternative in {@link SpliterParser#rootExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRootOrsExpression(SpliterParser.RootOrsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiRootExpression}
	 * labeled alternative in {@link SpliterParser#rootExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiRootExpression(SpliterParser.MultiRootExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orSplitsExression}
	 * labeled alternative in {@link SpliterParser#rootExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrSplitsExression(SpliterParser.OrSplitsExressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cantSplitExpression}
	 * labeled alternative in {@link SpliterParser#rootExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCantSplitExpression(SpliterParser.CantSplitExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orSplitBasicExpression}
	 * labeled alternative in {@link SpliterParser#orSplitExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrSplitBasicExpression(SpliterParser.OrSplitBasicExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orSplitParenExpression}
	 * labeled alternative in {@link SpliterParser#orSplitExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrSplitParenExpression(SpliterParser.OrSplitParenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orSplitRecursiveExpression}
	 * labeled alternative in {@link SpliterParser#orSplitExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrSplitRecursiveExpression(SpliterParser.OrSplitRecursiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andsExpression}
	 * labeled alternative in {@link SpliterParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndsExpression(SpliterParser.AndsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link SpliterParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(SpliterParser.OrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link SpliterParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(SpliterParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parensExpression}
	 * labeled alternative in {@link SpliterParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensExpression(SpliterParser.ParensExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link SpliterParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(SpliterParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orsExpression}
	 * labeled alternative in {@link SpliterParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrsExpression(SpliterParser.OrsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code basicBlockExpression}
	 * labeled alternative in {@link SpliterParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicBlockExpression(SpliterParser.BasicBlockExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiAndsRecursiveExpression}
	 * labeled alternative in {@link SpliterParser#multiAndsExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiAndsRecursiveExpression(SpliterParser.MultiAndsRecursiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiAndsBasicExpression}
	 * labeled alternative in {@link SpliterParser#multiAndsExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiAndsBasicExpression(SpliterParser.MultiAndsBasicExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiOrsRecursiveExpression}
	 * labeled alternative in {@link SpliterParser#multiOrsExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiOrsRecursiveExpression(SpliterParser.MultiOrsRecursiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiOrsBasicExpression}
	 * labeled alternative in {@link SpliterParser#multiOrsExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiOrsBasicExpression(SpliterParser.MultiOrsBasicExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiParenExpression}
	 * labeled alternative in {@link SpliterParser#parenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiParenExpression(SpliterParser.MultiParenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleParenExpression}
	 * labeled alternative in {@link SpliterParser#parenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleParenExpression(SpliterParser.SingleParenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unitBasicExpression}
	 * labeled alternative in {@link SpliterParser#unitExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnitBasicExpression(SpliterParser.UnitBasicExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unitParenExpression}
	 * labeled alternative in {@link SpliterParser#unitExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnitParenExpression(SpliterParser.UnitParenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compareExpression}
	 * labeled alternative in {@link SpliterParser#basicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpression(SpliterParser.CompareExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link SpliterParser#basicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpression(SpliterParser.BoolExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpression}
	 * labeled alternative in {@link SpliterParser#basicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpression(SpliterParser.AtomExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code columnExpression}
	 * labeled alternative in {@link SpliterParser#basicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnExpression(SpliterParser.ColumnExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenBasicExpression}
	 * labeled alternative in {@link SpliterParser#basicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenBasicExpression(SpliterParser.ParenBasicExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionExpression}
	 * labeled alternative in {@link SpliterParser#basicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpression(SpliterParser.FunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpliterParser#funcExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncExpression(SpliterParser.FuncExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpliterParser#colExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColExpression(SpliterParser.ColExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpliterParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(SpliterParser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpliterParser#trueExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueExpression(SpliterParser.TrueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpliterParser#falseExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseExpression(SpliterParser.FalseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpliterParser#comparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparator(SpliterParser.ComparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpliterParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(SpliterParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpliterParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(SpliterParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link SpliterParser#identifer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifer(SpliterParser.IdentiferContext ctx);
}