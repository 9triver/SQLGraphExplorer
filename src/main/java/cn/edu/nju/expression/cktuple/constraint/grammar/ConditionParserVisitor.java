// Generated from D:/Antlr-SQLGraphExplorer/SQLGraphExplorer/src/main/java/cn/edu/nju/expression/cktuple/constraint/grammar/ConditionParser.g4 by ANTLR 4.13.1
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ConditionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ConditionParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ConditionParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(ConditionParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(ConditionParser.OrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(ConditionParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpression(ConditionParser.BoolExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpression(ConditionParser.AtomExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(ConditionParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code columnExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnExpression(ConditionParser.ColumnExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpression(ConditionParser.ParenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparatorExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparatorExpression(ConditionParser.ComparatorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpression(ConditionParser.FunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConditionParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(ConditionParser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConditionParser#comparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparator(ConditionParser.ComparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConditionParser#binary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary(ConditionParser.BinaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConditionParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(ConditionParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConditionParser#identifer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifer(ConditionParser.IdentiferContext ctx);
}