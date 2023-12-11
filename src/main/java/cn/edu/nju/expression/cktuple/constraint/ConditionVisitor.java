package cn.edu.nju.expression.cktuple.constraint;

import cn.edu.nju.Tools.Tools;
import grammar.ConditionParser;
import grammar.ConditionParserBaseVisitor;

import java.util.HashSet;
import java.util.Set;

public class ConditionVisitor extends ConditionParserBaseVisitor<String> {
    private Set<String> columnNames = new HashSet<>();

    @Override
    public String visitParse(ConditionParser.ParseContext ctx) {
        columnNames.clear();
        return visitChildren(ctx);
    }

    @Override
    public String visitMultiParenExpression(ConditionParser.MultiParenExpressionContext ctx) {
        return visitParenExpression(ctx.parenExpression());
    }

    @Override
    public String visitSingleParenExpression(ConditionParser.SingleParenExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitParenExpression(ConditionParser.ParenExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitInvolutionLawExpression(ConditionParser.InvolutionLawExpressionContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public String visitNotExpression(ConditionParser.NotExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitAndAllExpression(ConditionParser.AndAllExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitOrAllExpression(ConditionParser.OrAllExpressionContext ctx) {
        return visitChildren(ctx);
    }
    @Override
    public String visitAndBasicExpression(ConditionParser.AndBasicExpressionContext ctx) {
        StringBuilder ret = new StringBuilder(visit(ctx.expression(0)));
        for(int i = 1; i < ctx.expression().size(); ++i) {
            ret.append(" AND ").append(visit(ctx.expression(i)));
        }

        return ret.toString();
    }

    @Override
    public String visitOrBasicExpression(ConditionParser.OrBasicExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitAndExpression(ConditionParser.AndExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitAnnulmentLawExpression(ConditionParser.AnnulmentLawExpressionContext ctx) {
        return ctx.result.getText();
    }

    @Override
    public String visitIdentityLawExpression(ConditionParser.IdentityLawExpressionContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public String visitAndDistributiveLawExpression(ConditionParser.AndDistributiveLawExpressionContext ctx) {
        StringBuilder ret = new StringBuilder();
        if(ctx.leftOr != null && ctx.rightOr != null) {
            for(ConditionParser.ExpressionContext left : ctx.leftOr.expression())
                for(ConditionParser.ExpressionContext right : ctx.rightOr.expression())
                    ret.append("(").append(visit(left)).append(" AND ").append(visit(right)).append(")").append(" OR ");
        }
        else if(ctx.leftBasic != null && ctx.rightOr != null) {
            for(ConditionParser.ExpressionContext right : ctx.rightOr.expression())
                ret.append("(").append(visit(ctx.leftBasic)).append(" AND ").append(visit(right)).append(")").append(" OR ");
        }
        else if(ctx.leftOr != null && ctx.rightBasic != null) {
            for(ConditionParser.ExpressionContext left : ctx.leftOr.expression())
                ret.append("(").append(visit(left)).append(" AND ").append(visit(ctx.rightBasic)).append(")").append(" OR ");
        }
        else
            return visitChildren(ctx);
        ret.delete(ret.length() - " OR ".length(), ret.length());
        return ret.toString();
    }

    @Override
    public String visitAndDeMorganLawExpression(ConditionParser.AndDeMorganLawExpressionContext ctx) {
        StringBuilder ret = new StringBuilder();
        for (ConditionParser.ExpressionContext e : ctx.andExpression().expression()) {
            ret.append("(NOT (").append(visit(e)).append(")) OR ");
        }
        ret.delete(ret.length()-" OR ".length(),ret.length());
        return ret.toString();
    }

    @Override
    public String visitColumnExpression(ConditionParser.ColumnExpressionContext ctx) {
        columnNames.add(ctx.getText());
        return Tools.getFullContext(ctx);
    }

    @Override
    public String visitBasicBlockExpression(ConditionParser.BasicBlockExpressionContext ctx) {
        visitChildren(ctx);
        return Tools.getFullContext(ctx);
    }

    public Set<String> getColumnNames() {
        return columnNames;
    }
}
