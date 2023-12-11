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
	 * Visit a parse tree produced by the {@code andDistributiveLawExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndDistributiveLawExpression(ConditionParser.AndDistributiveLawExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identityLawExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentityLawExpression(ConditionParser.IdentityLawExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code involutionLawExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvolutionLawExpression(ConditionParser.InvolutionLawExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andDeMorganLawExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndDeMorganLawExpression(ConditionParser.AndDeMorganLawExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(ConditionParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleParenExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleParenExpression(ConditionParser.SingleParenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andAllExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndAllExpression(ConditionParser.AndAllExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orBasicExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrBasicExpression(ConditionParser.OrBasicExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orAllExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrAllExpression(ConditionParser.OrAllExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiParenExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiParenExpression(ConditionParser.MultiParenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code annulmentLawExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnulmentLawExpression(ConditionParser.AnnulmentLawExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code basicBlockExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicBlockExpression(ConditionParser.BasicBlockExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andBasicExpression}
	 * labeled alternative in {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndBasicExpression(ConditionParser.AndBasicExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConditionParser#parenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpression(ConditionParser.ParenExpressionContext ctx);
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