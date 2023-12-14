// Generated from d:/Antlr-SQLGraphExplorer/SQLGraphExplorer/src/main/java/cn/edu/nju/expression/cktuple/constraint/grammar/ConditionParser.g4 by ANTLR 4.13.1
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
	 * Enter a parse tree produced by {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ConditionParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ConditionParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code annulmentLawExpression}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void enterAnnulmentLawExpression(ConditionParser.AnnulmentLawExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code annulmentLawExpression}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void exitAnnulmentLawExpression(ConditionParser.AnnulmentLawExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identityLawExpression}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void enterIdentityLawExpression(ConditionParser.IdentityLawExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identityLawExpression}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void exitIdentityLawExpression(ConditionParser.IdentityLawExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andDistributiveLawExpression}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndDistributiveLawExpression(ConditionParser.AndDistributiveLawExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andDistributiveLawExpression}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndDistributiveLawExpression(ConditionParser.AndDistributiveLawExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andAllExpression}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndAllExpression(ConditionParser.AndAllExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andAllExpression}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndAllExpression(ConditionParser.AndAllExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orAllExpression}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrAllExpression(ConditionParser.OrAllExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orAllExpression}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrAllExpression(ConditionParser.OrAllExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andBasicExpression}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndBasicExpression(ConditionParser.AndBasicExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andBasicExpression}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndBasicExpression(ConditionParser.AndBasicExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orBasicExpression}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrBasicExpression(ConditionParser.OrBasicExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orBasicExpression}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrBasicExpression(ConditionParser.OrBasicExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notsExpression}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void enterNotsExpression(ConditionParser.NotsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notsExpression}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void exitNotsExpression(ConditionParser.NotsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code basicBlockExpression}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void enterBasicBlockExpression(ConditionParser.BasicBlockExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code basicBlockExpression}
	 * labeled alternative in {@link ConditionParser#notParenExpression}.
	 * @param ctx the parse tree
	 */
	void exitBasicBlockExpression(ConditionParser.BasicBlockExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiParenExpression}
	 * labeled alternative in {@link ConditionParser#parenExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiParenExpression(ConditionParser.MultiParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiParenExpression}
	 * labeled alternative in {@link ConditionParser#parenExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiParenExpression(ConditionParser.MultiParenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleParenExpression}
	 * labeled alternative in {@link ConditionParser#parenExpression}.
	 * @param ctx the parse tree
	 */
	void enterSingleParenExpression(ConditionParser.SingleParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleParenExpression}
	 * labeled alternative in {@link ConditionParser#parenExpression}.
	 * @param ctx the parse tree
	 */
	void exitSingleParenExpression(ConditionParser.SingleParenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andDeMorganLawExpression}
	 * labeled alternative in {@link ConditionParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndDeMorganLawExpression(ConditionParser.AndDeMorganLawExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andDeMorganLawExpression}
	 * labeled alternative in {@link ConditionParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndDeMorganLawExpression(ConditionParser.AndDeMorganLawExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code involutionLawExpression}
	 * labeled alternative in {@link ConditionParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void enterInvolutionLawExpression(ConditionParser.InvolutionLawExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code involutionLawExpression}
	 * labeled alternative in {@link ConditionParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void exitInvolutionLawExpression(ConditionParser.InvolutionLawExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleNotExpression}
	 * labeled alternative in {@link ConditionParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void enterSingleNotExpression(ConditionParser.SingleNotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleNotExpression}
	 * labeled alternative in {@link ConditionParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void exitSingleNotExpression(ConditionParser.SingleNotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConditionParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(ConditionParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(ConditionParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConditionParser#orExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(ConditionParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionParser#orExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(ConditionParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compareExpression}
	 * labeled alternative in {@link ConditionParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void enterCompareExpression(ConditionParser.CompareExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compareExpression}
	 * labeled alternative in {@link ConditionParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void exitCompareExpression(ConditionParser.CompareExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link ConditionParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpression(ConditionParser.BoolExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link ConditionParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpression(ConditionParser.BoolExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpression}
	 * labeled alternative in {@link ConditionParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpression(ConditionParser.AtomExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpression}
	 * labeled alternative in {@link ConditionParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpression(ConditionParser.AtomExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code columnExpression}
	 * labeled alternative in {@link ConditionParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void enterColumnExpression(ConditionParser.ColumnExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code columnExpression}
	 * labeled alternative in {@link ConditionParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void exitColumnExpression(ConditionParser.ColumnExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionExpression}
	 * labeled alternative in {@link ConditionParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpression(ConditionParser.FunctionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionExpression}
	 * labeled alternative in {@link ConditionParser#basicExpression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpression(ConditionParser.FunctionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConditionParser#funcExpression}.
	 * @param ctx the parse tree
	 */
	void enterFuncExpression(ConditionParser.FuncExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionParser#funcExpression}.
	 * @param ctx the parse tree
	 */
	void exitFuncExpression(ConditionParser.FuncExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConditionParser#colExpression}.
	 * @param ctx the parse tree
	 */
	void enterColExpression(ConditionParser.ColExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionParser#colExpression}.
	 * @param ctx the parse tree
	 */
	void exitColExpression(ConditionParser.ColExpressionContext ctx);
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
	 * Enter a parse tree produced by {@link ConditionParser#trueExpression}.
	 * @param ctx the parse tree
	 */
	void enterTrueExpression(ConditionParser.TrueExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionParser#trueExpression}.
	 * @param ctx the parse tree
	 */
	void exitTrueExpression(ConditionParser.TrueExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConditionParser#falseExpression}.
	 * @param ctx the parse tree
	 */
	void enterFalseExpression(ConditionParser.FalseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionParser#falseExpression}.
	 * @param ctx the parse tree
	 */
	void exitFalseExpression(ConditionParser.FalseExpressionContext ctx);
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
	 * Enter a parse tree produced by {@link ConditionParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(ConditionParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConditionParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(ConditionParser.AtomContext ctx);
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