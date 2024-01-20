// Generated from D:/Antlr-SQLGraphExplorer/SQLGraphExplorer/src/main/java/cn/edu/nju/core/tools/condition/grammar/simplifier/SimplifierParser.g4 by ANTLR 4.13.1
package cn.edu.nju.core.tools.condition.grammar.simplifier;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimplifierParser}.
 */
public interface SimplifierParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimplifierParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(SimplifierParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifierParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(SimplifierParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifierParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SimplifierParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifierParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SimplifierParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiParenExpression}
	 * labeled alternative in {@link SimplifierParser#parenExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiParenExpression(SimplifierParser.MultiParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiParenExpression}
	 * labeled alternative in {@link SimplifierParser#parenExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiParenExpression(SimplifierParser.MultiParenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleParenExpression}
	 * labeled alternative in {@link SimplifierParser#parenExpression}.
	 * @param ctx the parse tree
	 */
	void enterSingleParenExpression(SimplifierParser.SingleParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleParenExpression}
	 * labeled alternative in {@link SimplifierParser#parenExpression}.
	 * @param ctx the parse tree
	 */
	void exitSingleParenExpression(SimplifierParser.SingleParenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notParenBlockExpression1}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void enterNotParenBlockExpression1(SimplifierParser.NotParenBlockExpression1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code notParenBlockExpression1}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void exitNotParenBlockExpression1(SimplifierParser.NotParenBlockExpression1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code andDistributiveLawExpression}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndDistributiveLawExpression(SimplifierParser.AndDistributiveLawExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andDistributiveLawExpression}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndDistributiveLawExpression(SimplifierParser.AndDistributiveLawExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notParenBlockExpression3}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void enterNotParenBlockExpression3(SimplifierParser.NotParenBlockExpression3Context ctx);
	/**
	 * Exit a parse tree produced by the {@code notParenBlockExpression3}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void exitNotParenBlockExpression3(SimplifierParser.NotParenBlockExpression3Context ctx);
	/**
	 * Enter a parse tree produced by the {@code notParenBlockExpression2}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void enterNotParenBlockExpression2(SimplifierParser.NotParenBlockExpression2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code notParenBlockExpression2}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void exitNotParenBlockExpression2(SimplifierParser.NotParenBlockExpression2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code annulmentLawExpression}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void enterAnnulmentLawExpression(SimplifierParser.AnnulmentLawExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code annulmentLawExpression}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void exitAnnulmentLawExpression(SimplifierParser.AnnulmentLawExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identityLawExpression}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void enterIdentityLawExpression(SimplifierParser.IdentityLawExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identityLawExpression}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void exitIdentityLawExpression(SimplifierParser.IdentityLawExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notParenBlockExpression4}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void enterNotParenBlockExpression4(SimplifierParser.NotParenBlockExpression4Context ctx);
	/**
	 * Exit a parse tree produced by the {@code notParenBlockExpression4}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void exitNotParenBlockExpression4(SimplifierParser.NotParenBlockExpression4Context ctx);
	/**
	 * Enter a parse tree produced by the {@code notsExpression}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void enterNotsExpression(SimplifierParser.NotsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notsExpression}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void exitNotsExpression(SimplifierParser.NotsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orBasicExpression}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrBasicExpression(SimplifierParser.OrBasicExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orBasicExpression}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrBasicExpression(SimplifierParser.OrBasicExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code basicBlockExpression}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void enterBasicBlockExpression(SimplifierParser.BasicBlockExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code basicBlockExpression}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void exitBasicBlockExpression(SimplifierParser.BasicBlockExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andBasicExpression}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndBasicExpression(SimplifierParser.AndBasicExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andBasicExpression}
	 * labeled alternative in {@link SimplifierParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndBasicExpression(SimplifierParser.AndBasicExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andDeMorganLawExpression}
	 * labeled alternative in {@link SimplifierParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndDeMorganLawExpression(SimplifierParser.AndDeMorganLawExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andDeMorganLawExpression}
	 * labeled alternative in {@link SimplifierParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndDeMorganLawExpression(SimplifierParser.AndDeMorganLawExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code involutionLawExpression}
	 * labeled alternative in {@link SimplifierParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void enterInvolutionLawExpression(SimplifierParser.InvolutionLawExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code involutionLawExpression}
	 * labeled alternative in {@link SimplifierParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void exitInvolutionLawExpression(SimplifierParser.InvolutionLawExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleNotExpression}
	 * labeled alternative in {@link SimplifierParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void enterSingleNotExpression(SimplifierParser.SingleNotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleNotExpression}
	 * labeled alternative in {@link SimplifierParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void exitSingleNotExpression(SimplifierParser.SingleNotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifierParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(SimplifierParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifierParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(SimplifierParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifierParser#orExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(SimplifierParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifierParser#orExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(SimplifierParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compareExpression}
	 * labeled alternative in {@link SimplifierParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void enterCompareExpression(SimplifierParser.CompareExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compareExpression}
	 * labeled alternative in {@link SimplifierParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void exitCompareExpression(SimplifierParser.CompareExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link SimplifierParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpression(SimplifierParser.BoolExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link SimplifierParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpression(SimplifierParser.BoolExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpression}
	 * labeled alternative in {@link SimplifierParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpression(SimplifierParser.AtomExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpression}
	 * labeled alternative in {@link SimplifierParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpression(SimplifierParser.AtomExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code columnExpression}
	 * labeled alternative in {@link SimplifierParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void enterColumnExpression(SimplifierParser.ColumnExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code columnExpression}
	 * labeled alternative in {@link SimplifierParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void exitColumnExpression(SimplifierParser.ColumnExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionExpression}
	 * labeled alternative in {@link SimplifierParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpression(SimplifierParser.FunctionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionExpression}
	 * labeled alternative in {@link SimplifierParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpression(SimplifierParser.FunctionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifierParser#funcExpression}.
	 * @param ctx the parse tree
	 */
	void enterFuncExpression(SimplifierParser.FuncExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifierParser#funcExpression}.
	 * @param ctx the parse tree
	 */
	void exitFuncExpression(SimplifierParser.FuncExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifierParser#colExpression}.
	 * @param ctx the parse tree
	 */
	void enterColExpression(SimplifierParser.ColExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifierParser#colExpression}.
	 * @param ctx the parse tree
	 */
	void exitColExpression(SimplifierParser.ColExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifierParser#functionName}.
	 * @param ctx the parse tree
	 */
	void enterFunctionName(SimplifierParser.FunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifierParser#functionName}.
	 * @param ctx the parse tree
	 */
	void exitFunctionName(SimplifierParser.FunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifierParser#trueExpression}.
	 * @param ctx the parse tree
	 */
	void enterTrueExpression(SimplifierParser.TrueExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifierParser#trueExpression}.
	 * @param ctx the parse tree
	 */
	void exitTrueExpression(SimplifierParser.TrueExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifierParser#falseExpression}.
	 * @param ctx the parse tree
	 */
	void enterFalseExpression(SimplifierParser.FalseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifierParser#falseExpression}.
	 * @param ctx the parse tree
	 */
	void exitFalseExpression(SimplifierParser.FalseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifierParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterComparator(SimplifierParser.ComparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifierParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitComparator(SimplifierParser.ComparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifierParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(SimplifierParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifierParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(SimplifierParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifierParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(SimplifierParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifierParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(SimplifierParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifierParser#identifer}.
	 * @param ctx the parse tree
	 */
	void enterIdentifer(SimplifierParser.IdentiferContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifierParser#identifer}.
	 * @param ctx the parse tree
	 */
	void exitIdentifer(SimplifierParser.IdentiferContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimplifierParser#logicOp}.
	 * @param ctx the parse tree
	 */
	void enterLogicOp(SimplifierParser.LogicOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimplifierParser#logicOp}.
	 * @param ctx the parse tree
	 */
	void exitLogicOp(SimplifierParser.LogicOpContext ctx);
}