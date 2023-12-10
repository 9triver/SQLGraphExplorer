package cn.edu.nju.expression.cktuple.constraint;

import grammar.ConditionParser;
import grammar.ConditionParserBaseVisitor;

import java.util.HashSet;
import java.util.Set;

public class ConditionVisitor extends ConditionParserBaseVisitor<String> {
    private Set<String> columnNames = new HashSet<>();

    private Constraint constraint;

    @Override
    public String visitParse(ConditionParser.ParseContext ctx) {
        columnNames.clear();
        return visitChildren(ctx);
    }

    @Override
    public String visitColumnExpression(ConditionParser.ColumnExpressionContext ctx) {
        columnNames.add(ctx.getText());
        return visitChildren(ctx);
    }
}
