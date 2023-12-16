package cn.edu.nju.tools.condition;

import cn.edu.nju.tools.Tools;
import cn.edu.nju.tools.condition.grammar.spliter.SpliterParser;
import cn.edu.nju.tools.condition.grammar.spliter.SpliterParserBaseVisitor;


public class Spliter extends SpliterParserBaseVisitor<String> {
    @Override
    public String visitParse(SpliterParser.ParseContext ctx) {
        String context = Tools.getFullContext(ctx);
        if(context.contains("@#$%")) return context;
        return visit(ctx.rootExpression());
    }

    @Override
    public String visitRootAndsExpression(SpliterParser.RootAndsExpressionContext ctx) {
        return visit(ctx.multiAndsExpression());
    }

    @Override
    public String visitRootOrsExpression(SpliterParser.RootOrsExpressionContext ctx) {
        return visit(ctx.multiOrsExpression());
    }

    @Override
    public String visitMultiRootExpression(SpliterParser.MultiRootExpressionContext ctx) {
        return visit(ctx.rootExpression());
    }

    @Override
    public String visitOrSplitsExression(SpliterParser.OrSplitsExressionContext ctx) {
        return visit(ctx.orSplitExpression());
    }

    @Override
    public String visitCantSplitExpression(SpliterParser.CantSplitExpressionContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public String visitOrSplitParenExpression(SpliterParser.OrSplitParenExpressionContext ctx) {
        return "(" + visit(ctx.orSplitExpression()) + ")";
    }

    @Override
    public String visitOrSplitRecursiveExpression(SpliterParser.OrSplitRecursiveExpressionContext ctx) {
        return visit(ctx.orSplitExpression(0)) + "@#$%" + visit(ctx.orSplitExpression(1));
    }

    @Override
    public String visitOrSplitBasicExpression(SpliterParser.OrSplitBasicExpressionContext ctx) {StringBuilder ret = new StringBuilder();
        for (SpliterParser.UnitExpressionContext uCtx : ctx.unitExpression())
            ret.append(visit(uCtx)).append("@#$%");
        ret.delete(ret.length()-"@#$%".length(), ret.length());
        return ret.toString();
    }

    @Override
    public String visitAndsExpression(SpliterParser.AndsExpressionContext ctx) {
        return "(" + visit(ctx.multiAndsExpression()) + ")";
    }

    @Override
    public String visitOrsExpression(SpliterParser.OrsExpressionContext ctx) {
        return "(" + visit(ctx.multiOrsExpression()) + ")";
    }

    @Override
    public String visitMultiAndsRecursiveExpression(SpliterParser.MultiAndsRecursiveExpressionContext ctx) {
        return visit(ctx.multiAndsExpression()) + " AND " + visit(ctx.expression());
    }

    @Override
    public String visitMultiAndsBasicExpression(SpliterParser.MultiAndsBasicExpressionContext ctx) {
        return visit(ctx.expression(0)) + " AND " + visit(ctx.expression(1)) + " AND " + visit(ctx.expression(2));
    }

    @Override
    public String visitMultiOrsRecursiveExpression(SpliterParser.MultiOrsRecursiveExpressionContext ctx) {
        return visit(ctx.multiOrsExpression()) + " OR " + visit(ctx.expression());
    }

    @Override
    public String visitMultiOrsBasicExpression(SpliterParser.MultiOrsBasicExpressionContext ctx) {
        return visit(ctx.expression(0)) + " OR " + visit(ctx.expression(1)) + " OR " + visit(ctx.expression(2));
    }

    @Override
    public String visitMultiParenExpression(SpliterParser.MultiParenExpressionContext ctx) {
        return visit(ctx.parenExpression());
    }

    @Override
    public String visitSingleParenExpression(SpliterParser.SingleParenExpressionContext ctx) {
        return "(" + visit(ctx.expression()) + ")";
    }

    @Override
    public String visitParenBasicExpression(SpliterParser.ParenBasicExpressionContext ctx) {
        return visit(ctx.basicExpression());
    }

    @Override
    public String visitAndExpression(SpliterParser.AndExpressionContext ctx) {
        return visit(ctx.expression(0)) + " AND " + visit(ctx.expression(1));
    }

    @Override
    public String visitOrExpression(SpliterParser.OrExpressionContext ctx) {
        return visit(ctx.expression(0)) + " OR " + visit(ctx.expression(1));
    }

    @Override
    public String visitNotExpression(SpliterParser.NotExpressionContext ctx) {
        return "NOT " + visit(ctx.expression());
    }

    @Override
    public String visitCompareExpression(SpliterParser.CompareExpressionContext ctx) {
        return Tools.getFullContext(ctx);
    }

    @Override
    public String visitBoolExpression(SpliterParser.BoolExpressionContext ctx) {
        return Tools.getFullContext(ctx);
    }

    @Override
    public String visitFunctionExpression(SpliterParser.FunctionExpressionContext ctx) {
        return Tools.getFullContext(ctx);
    }

    @Override
    public String visitColumnExpression(SpliterParser.ColumnExpressionContext ctx) {
        return Tools.getFullContext(ctx);
    }

    @Override
    public String visitAtomExpression(SpliterParser.AtomExpressionContext ctx) {
        return Tools.getFullContext(ctx);
    }

    @Override
    public String visitTrueExpression(SpliterParser.TrueExpressionContext ctx) {
        return "TRUE";
    }

    @Override
    public String visitFalseExpression(SpliterParser.FalseExpressionContext ctx) {
        return "FALSE";
    }
}
