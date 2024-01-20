// Generated from D:/Antlr-SQLGraphExplorer/SQLGraphExplorer/src/main/java/cn/edu/nju/core/tools/ra/grammar/RelationalAlgebra.g4 by ANTLR 4.13.1
package cn.edu.nju.core.tools.ra.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RelationalAlgebraParser}.
 */
public interface RelationalAlgebraListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RelationalAlgebraParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(RelationalAlgebraParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelationalAlgebraParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(RelationalAlgebraParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code viewAssignment}
	 * labeled alternative in {@link RelationalAlgebraParser#view}.
	 * @param ctx the parse tree
	 */
	void enterViewAssignment(RelationalAlgebraParser.ViewAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code viewAssignment}
	 * labeled alternative in {@link RelationalAlgebraParser#view}.
	 * @param ctx the parse tree
	 */
	void exitViewAssignment(RelationalAlgebraParser.ViewAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code division}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDivision(RelationalAlgebraParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code division}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDivision(RelationalAlgebraParser.DivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cartesianProduct}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCartesianProduct(RelationalAlgebraParser.CartesianProductContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cartesianProduct}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCartesianProduct(RelationalAlgebraParser.CartesianProductContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selection}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSelection(RelationalAlgebraParser.SelectionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selection}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSelection(RelationalAlgebraParser.SelectionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code naturalJoin}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNaturalJoin(RelationalAlgebraParser.NaturalJoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code naturalJoin}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNaturalJoin(RelationalAlgebraParser.NaturalJoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationFromExpr}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRelationFromExpr(RelationalAlgebraParser.RelationFromExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationFromExpr}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRelationFromExpr(RelationalAlgebraParser.RelationFromExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intersection}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIntersection(RelationalAlgebraParser.IntersectionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intersection}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIntersection(RelationalAlgebraParser.IntersectionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code difference}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDifference(RelationalAlgebraParser.DifferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code difference}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDifference(RelationalAlgebraParser.DifferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code projection}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterProjection(RelationalAlgebraParser.ProjectionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code projection}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitProjection(RelationalAlgebraParser.ProjectionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code union}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnion(RelationalAlgebraParser.UnionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code union}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnion(RelationalAlgebraParser.UnionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code join}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterJoin(RelationalAlgebraParser.JoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code join}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitJoin(RelationalAlgebraParser.JoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bracketsExpr}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBracketsExpr(RelationalAlgebraParser.BracketsExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bracketsExpr}
	 * labeled alternative in {@link RelationalAlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBracketsExpr(RelationalAlgebraParser.BracketsExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attributeFromAttrlist}
	 * labeled alternative in {@link RelationalAlgebraParser#attrlist}.
	 * @param ctx the parse tree
	 */
	void enterAttributeFromAttrlist(RelationalAlgebraParser.AttributeFromAttrlistContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attributeFromAttrlist}
	 * labeled alternative in {@link RelationalAlgebraParser#attrlist}.
	 * @param ctx the parse tree
	 */
	void exitAttributeFromAttrlist(RelationalAlgebraParser.AttributeFromAttrlistContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attributeList}
	 * labeled alternative in {@link RelationalAlgebraParser#attrlist}.
	 * @param ctx the parse tree
	 */
	void enterAttributeList(RelationalAlgebraParser.AttributeListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attributeList}
	 * labeled alternative in {@link RelationalAlgebraParser#attrlist}.
	 * @param ctx the parse tree
	 */
	void exitAttributeList(RelationalAlgebraParser.AttributeListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 */
	void enterAtomCondlist(RelationalAlgebraParser.AtomCondlistContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 */
	void exitAtomCondlist(RelationalAlgebraParser.AtomCondlistContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bracketsCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 */
	void enterBracketsCondlist(RelationalAlgebraParser.BracketsCondlistContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bracketsCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 */
	void exitBracketsCondlist(RelationalAlgebraParser.BracketsCondlistContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 */
	void enterNotCondlist(RelationalAlgebraParser.NotCondlistContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 */
	void exitNotCondlist(RelationalAlgebraParser.NotCondlistContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparedCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 */
	void enterComparedCondlist(RelationalAlgebraParser.ComparedCondlistContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparedCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 */
	void exitComparedCondlist(RelationalAlgebraParser.ComparedCondlistContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 */
	void enterFuncCondlist(RelationalAlgebraParser.FuncCondlistContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 */
	void exitFuncCondlist(RelationalAlgebraParser.FuncCondlistContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 */
	void enterAndCondlist(RelationalAlgebraParser.AndCondlistContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 */
	void exitAndCondlist(RelationalAlgebraParser.AndCondlistContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 */
	void enterOrCondlist(RelationalAlgebraParser.OrCondlistContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orCondlist}
	 * labeled alternative in {@link RelationalAlgebraParser#condlist}.
	 * @param ctx the parse tree
	 */
	void exitOrCondlist(RelationalAlgebraParser.OrCondlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link RelationalAlgebraParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(RelationalAlgebraParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelationalAlgebraParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(RelationalAlgebraParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equal}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterEqual(RelationalAlgebraParser.EqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equal}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitEqual(RelationalAlgebraParser.EqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nonEqual}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterNonEqual(RelationalAlgebraParser.NonEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nonEqual}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitNonEqual(RelationalAlgebraParser.NonEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code greaterThan}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterGreaterThan(RelationalAlgebraParser.GreaterThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code greaterThan}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitGreaterThan(RelationalAlgebraParser.GreaterThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code greaterEqual}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterGreaterEqual(RelationalAlgebraParser.GreaterEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code greaterEqual}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitGreaterEqual(RelationalAlgebraParser.GreaterEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lessThan}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterLessThan(RelationalAlgebraParser.LessThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lessThan}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitLessThan(RelationalAlgebraParser.LessThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lessEqual}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterLessEqual(RelationalAlgebraParser.LessEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lessEqual}
	 * labeled alternative in {@link RelationalAlgebraParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitLessEqual(RelationalAlgebraParser.LessEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attributeFromCompared}
	 * labeled alternative in {@link RelationalAlgebraParser#compared}.
	 * @param ctx the parse tree
	 */
	void enterAttributeFromCompared(RelationalAlgebraParser.AttributeFromComparedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attributeFromCompared}
	 * labeled alternative in {@link RelationalAlgebraParser#compared}.
	 * @param ctx the parse tree
	 */
	void exitAttributeFromCompared(RelationalAlgebraParser.AttributeFromComparedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringFromCompared}
	 * labeled alternative in {@link RelationalAlgebraParser#compared}.
	 * @param ctx the parse tree
	 */
	void enterStringFromCompared(RelationalAlgebraParser.StringFromComparedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringFromCompared}
	 * labeled alternative in {@link RelationalAlgebraParser#compared}.
	 * @param ctx the parse tree
	 */
	void exitStringFromCompared(RelationalAlgebraParser.StringFromComparedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberFromCompared}
	 * labeled alternative in {@link RelationalAlgebraParser#compared}.
	 * @param ctx the parse tree
	 */
	void enterNumberFromCompared(RelationalAlgebraParser.NumberFromComparedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberFromCompared}
	 * labeled alternative in {@link RelationalAlgebraParser#compared}.
	 * @param ctx the parse tree
	 */
	void exitNumberFromCompared(RelationalAlgebraParser.NumberFromComparedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionFromCompared}
	 * labeled alternative in {@link RelationalAlgebraParser#compared}.
	 * @param ctx the parse tree
	 */
	void enterFunctionFromCompared(RelationalAlgebraParser.FunctionFromComparedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionFromCompared}
	 * labeled alternative in {@link RelationalAlgebraParser#compared}.
	 * @param ctx the parse tree
	 */
	void exitFunctionFromCompared(RelationalAlgebraParser.FunctionFromComparedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationIdentifier}
	 * labeled alternative in {@link RelationalAlgebraParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelationIdentifier(RelationalAlgebraParser.RelationIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationIdentifier}
	 * labeled alternative in {@link RelationalAlgebraParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelationIdentifier(RelationalAlgebraParser.RelationIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attributeIdentifier}
	 * labeled alternative in {@link RelationalAlgebraParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttributeIdentifier(RelationalAlgebraParser.AttributeIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attributeIdentifier}
	 * labeled alternative in {@link RelationalAlgebraParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttributeIdentifier(RelationalAlgebraParser.AttributeIdentifierContext ctx);
}