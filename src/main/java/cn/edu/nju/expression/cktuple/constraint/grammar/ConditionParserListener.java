// Generated from D:/Antlr-SQLGraphExplorer/SQLGraphExplorer/src/main/java/cn/edu/nju/expression/cktuple/constraint/grammar/ConditionParser.g4 by ANTLR 4.13.1
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ConditionParser}.
 */
public interface ConditionParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ConditionParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(ConditionParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(ConditionParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(ConditionParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(ConditionParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(ConditionParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(ConditionParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpression(ConditionParser.BoolExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpression(ConditionParser.BoolExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpression(ConditionParser.AtomExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpression(ConditionParser.AtomExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(ConditionParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(ConditionParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code columnExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterColumnExpression(ConditionParser.ColumnExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code columnExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitColumnExpression(ConditionParser.ColumnExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpression(ConditionParser.ParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpression(ConditionParser.ParenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparatorExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterComparatorExpression(ConditionParser.ComparatorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparatorExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitComparatorExpression(ConditionParser.ComparatorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpression(ConditionParser.FunctionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpression(ConditionParser.FunctionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConditionParser#functionName}.
	 * @param ctx the parse tree
	 */
	void enterFunctionName(ConditionParser.FunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionParser#functionName}.
	 * @param ctx the parse tree
	 */
	void exitFunctionName(ConditionParser.FunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConditionParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterComparator(ConditionParser.ComparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitComparator(ConditionParser.ComparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConditionParser#binary}.
	 * @param ctx the parse tree
	 */
	void enterBinary(ConditionParser.BinaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionParser#binary}.
	 * @param ctx the parse tree
	 */
	void exitBinary(ConditionParser.BinaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConditionParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(ConditionParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(ConditionParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConditionParser#identifer}.
	 * @param ctx the parse tree
	 */
	void enterIdentifer(ConditionParser.IdentiferContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionParser#identifer}.
	 * @param ctx the parse tree
	 */
	void exitIdentifer(ConditionParser.IdentiferContext ctx);
}