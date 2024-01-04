// Generated from D:/Antlr-SQLGraphExplorer/SQLGraphExplorer/src/main/java/cn/edu/nju/tools/condition/grammar/simplifier/SimplifierParser.g4 by ANTLR 4.13.1
package cn.edu.nju.tools.condition.grammar.simplifier;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimplifierParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimplifierParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimplifierParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(SimplifierParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimplifierParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SimplifierParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiParenExpression}
	 * labeled alternative in {@link SimplifierParser#parenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiParenExpression(SimplifierParser.MultiParenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleParenExpression}
	 * labeled alternative in {@link SimplifierParser#parenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleParenExpression(SimplifierParser.SingleParenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notParenBlockExpression1}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotParenBlockExpression1(SimplifierParser.NotParenBlockExpression1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code andDistributiveLawExpression}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndDistributiveLawExpression(SimplifierParser.AndDistributiveLawExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notParenBlockExpression3}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotParenBlockExpression3(SimplifierParser.NotParenBlockExpression3Context ctx);
	/**
	 * Visit a parse tree produced by the {@code notParenBlockExpression2}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotParenBlockExpression2(SimplifierParser.NotParenBlockExpression2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code annulmentLawExpression}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnulmentLawExpression(SimplifierParser.AnnulmentLawExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identityLawExpression}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityLawExpression(SimplifierParser.IdentityLawExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notParenBlockExpression4}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotParenBlockExpression4(SimplifierParser.NotParenBlockExpression4Context ctx);
	/**
	 * Visit a parse tree produced by the {@code notsExpression}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotsExpression(SimplifierParser.NotsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orBasicExpression}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrBasicExpression(SimplifierParser.OrBasicExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code basicBlockExpression}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicBlockExpression(SimplifierParser.BasicBlockExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andBasicExpression}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndBasicExpression(SimplifierParser.AndBasicExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andDeMorganLawExpression}
	 * labeled alternative in {@link SimplifierParser#notExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndDeMorganLawExpression(SimplifierParser.AndDeMorganLawExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code involutionLawExpression}
	 * labeled alternative in {@link SimplifierParser#notExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvolutionLawExpression(SimplifierParser.InvolutionLawExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleNotExpression}
	 * labeled alternative in {@link SimplifierParser#notExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleNotExpression(SimplifierParser.SingleNotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimplifierParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(SimplifierParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimplifierParser#orExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(SimplifierParser.OrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compareExpression}
	 * labeled alternative in {@link SimplifierParser#basicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpression(SimplifierParser.CompareExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link SimplifierParser#basicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpression(SimplifierParser.BoolExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpression}
	 * labeled alternative in {@link SimplifierParser#basicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpression(SimplifierParser.AtomExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code columnExpression}
	 * labeled alternative in {@link SimplifierParser#basicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnExpression(SimplifierParser.ColumnExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionExpression}
	 * labeled alternative in {@link SimplifierParser#basicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpression(SimplifierParser.FunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimplifierParser#funcExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncExpression(SimplifierParser.FuncExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimplifierParser#colExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColExpression(SimplifierParser.ColExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimplifierParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(SimplifierParser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimplifierParser#trueExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueExpression(SimplifierParser.TrueExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimplifierParser#falseExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseExpression(SimplifierParser.FalseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimplifierParser#comparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparator(SimplifierParser.ComparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimplifierParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(SimplifierParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimplifierParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(SimplifierParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimplifierParser#identifer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifer(SimplifierParser.IdentiferContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimplifierParser#logicOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicOp(SimplifierParser.LogicOpContext ctx);
}