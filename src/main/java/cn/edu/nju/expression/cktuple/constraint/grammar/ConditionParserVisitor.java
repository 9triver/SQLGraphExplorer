// Generated from D:/Antlr-SQLGraphExplorer/SQLGraphExplorer/src/main/java/cn/edu/nju/expression/cktuple/constraint/grammar/ConditionParser.g4 by ANTLR 4.13.1
package cn.edu.nju.expression.cktuple.constraint.grammar;
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
	 * Visit a parse tree produced by {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ConditionParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiParenExpression}
	 * labeled alternative in {@link ConditionParser#parenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiParenExpression(ConditionParser.MultiParenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleParenExpression}
	 * labeled alternative in {@link ConditionParser#parenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleParenExpression(ConditionParser.SingleParenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andDistributiveLawExpression}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndDistributiveLawExpression(ConditionParser.AndDistributiveLawExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identityLawExpression}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityLawExpression(ConditionParser.IdentityLawExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orBasicExpression}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrBasicExpression(ConditionParser.OrBasicExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notParenBlockExpression1}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotParenBlockExpression1(ConditionParser.NotParenBlockExpression1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code notParenBlockExpression3}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotParenBlockExpression3(ConditionParser.NotParenBlockExpression3Context ctx);
	/**
	 * Visit a parse tree produced by the {@code notParenBlockExpression2}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotParenBlockExpression2(ConditionParser.NotParenBlockExpression2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code annulmentLawExpression}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnulmentLawExpression(ConditionParser.AnnulmentLawExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notParenBlockExpression5}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotParenBlockExpression5(ConditionParser.NotParenBlockExpression5Context ctx);
	/**
	 * Visit a parse tree produced by the {@code notParenBlockExpression4}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotParenBlockExpression4(ConditionParser.NotParenBlockExpression4Context ctx);
	/**
	 * Visit a parse tree produced by the {@code notParenBlockExpression7}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotParenBlockExpression7(ConditionParser.NotParenBlockExpression7Context ctx);
	/**
	 * Visit a parse tree produced by the {@code notParenBlockExpression6}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotParenBlockExpression6(ConditionParser.NotParenBlockExpression6Context ctx);
	/**
	 * Visit a parse tree produced by the {@code notsExpression}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotsExpression(ConditionParser.NotsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code basicBlockExpression}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicBlockExpression(ConditionParser.BasicBlockExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andBasicExpression}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndBasicExpression(ConditionParser.AndBasicExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andDeMorganLawExpression}
	 * labeled alternative in {@link ConditionParser#notExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndDeMorganLawExpression(ConditionParser.AndDeMorganLawExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code involutionLawExpression}
	 * labeled alternative in {@link ConditionParser#notExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvolutionLawExpression(ConditionParser.InvolutionLawExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleNotExpression}
	 * labeled alternative in {@link ConditionParser#notExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleNotExpression(ConditionParser.SingleNotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConditionParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(ConditionParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConditionParser#orExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(ConditionParser.OrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compareExpression}
	 * labeled alternative in {@link ConditionParser#basicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpression(ConditionParser.CompareExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link ConditionParser#basicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpression(ConditionParser.BoolExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpression}
	 * labeled alternative in {@link ConditionParser#basicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpression(ConditionParser.AtomExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code columnExpression}
	 * labeled alternative in {@link ConditionParser#basicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnExpression(ConditionParser.ColumnExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionExpression}
	 * labeled alternative in {@link ConditionParser#basicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpression(ConditionParser.FunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConditionParser#funcExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncExpression(ConditionParser.FuncExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConditionParser#colExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColExpression(ConditionParser.ColExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConditionParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(ConditionParser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConditionParser#trueExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueExpression(ConditionParser.TrueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConditionParser#falseExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseExpression(ConditionParser.FalseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConditionParser#comparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparator(ConditionParser.ComparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConditionParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(ConditionParser.AtomContext ctx);
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