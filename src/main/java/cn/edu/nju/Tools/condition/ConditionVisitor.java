package cn.edu.nju.tools.condition;

import cn.edu.nju.graph.Graph;
import cn.edu.nju.tools.Tools;
import cn.edu.nju.tools.condition.grammar.ConditionParser;
import cn.edu.nju.tools.condition.grammar.ConditionParserBaseVisitor;

import java.util.HashSet;
import java.util.Set;

public class ConditionVisitor extends ConditionParserBaseVisitor<String> {
    private final Set<String> targetFullColumnNames = new HashSet<>();

    public void setTargetColumnName(Graph.Table targetTable) {
        if(targetTable == null) return;

        targetFullColumnNames.clear();
        targetFullColumnNames.addAll(targetTable.allFullColumnNames());
    }

    @Override
    public String visitParse(ConditionParser.ParseContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public String visitMultiParenExpression(ConditionParser.MultiParenExpressionContext ctx) {
        return visit(ctx.parenExpression());
    }

    @Override
    public String visitSingleParenExpression(ConditionParser.SingleParenExpressionContext ctx) {
        return visit(ctx.notParenExpression());
    }

    @Override
    public String visitAnnulmentLawExpression(ConditionParser.AnnulmentLawExpressionContext ctx) {
        String ret;
        if(ctx.falseExpression() != null) ret = visitFalseExpression(ctx.falseExpression());
        else if(ctx.trueExpression() != null) ret = visitTrueExpression(ctx.trueExpression());
        else ret = visitChildren(ctx);
        return bracked(ret);
    }

    @Override
    public String visitIdentityLawExpression(ConditionParser.IdentityLawExpressionContext ctx) {
        return bracked(visit(ctx.parenExpression()));
    }

    @Override
    public String visitAndDistributiveLawExpression(ConditionParser.AndDistributiveLawExpressionContext ctx) {
        StringBuilder ret = new StringBuilder();
        if(ctx.leftOr != null && ctx.rightOr != null) {
            for(ConditionParser.ParenExpressionContext left : ctx.leftOr.parenExpression())
                for(ConditionParser.ParenExpressionContext right : ctx.rightOr.parenExpression())
                    ret.append("(").append(visit(left)).append(" AND ").append(visit(right)).append(")").append(" OR ");
        }
        else if(ctx.leftBasic != null && ctx.rightOr != null) {
            for(ConditionParser.ParenExpressionContext right : ctx.rightOr.parenExpression())
                ret.append("(").append(visit(ctx.leftBasic)).append(" AND ").append(visit(right)).append(")").append(" OR ");
        }
        else if(ctx.leftOr != null && ctx.rightBasic != null) {
            for(ConditionParser.ParenExpressionContext left : ctx.leftOr.parenExpression())
                ret.append("(").append(visit(left)).append(" AND ").append(visit(ctx.rightBasic)).append(")").append(" OR ");
        }
        else
            return visitChildren(ctx);
        ret.delete(ret.length() - " OR ".length(), ret.length());
        return bracked(ret.toString());
    }

    @Override
    public String visitAndBasicExpression(ConditionParser.AndBasicExpressionContext ctx) {
        StringBuilder ret = new StringBuilder(visit(ctx.parenExpression(0)));
        for(int i = 1; i < ctx.parenExpression().size(); ++i) {
            ret.append(" AND ").append(visit(ctx.parenExpression(i)));
        }

        return bracked(ret.toString());
    }

    @Override
    public String visitOrBasicExpression(ConditionParser.OrBasicExpressionContext ctx) {
        StringBuilder ret = new StringBuilder(visit(ctx.parenExpression(0)));
        for(int i = 1; i < ctx.parenExpression().size(); ++i) {
            ret.append(" OR ").append(visit(ctx.parenExpression(i)));
        }

        return bracked(ret.toString());
    }

    @Override
    public String visitNotsExpression(ConditionParser.NotsExpressionContext ctx) {
        return bracked(visit(ctx.notExpression()));
    }

    @Override
    public String visitNotParenBlockExpression1(ConditionParser.NotParenBlockExpression1Context ctx) {
        return bracked(visit(ctx.notParenExpression(0)) + " AND " + visit(ctx.notParenExpression(1)));
    }
    @Override
    public String visitNotParenBlockExpression2(ConditionParser.NotParenBlockExpression2Context ctx) {
        return bracked(visit(ctx.notParenExpression()) + " AND " + visit(ctx.parenExpression()));
    }
    @Override
    public String visitNotParenBlockExpression3(ConditionParser.NotParenBlockExpression3Context ctx) {
        return bracked(visit(ctx.parenExpression()) + " AND " + visit(ctx.notParenExpression()));
    }
    @Override
    public String visitNotParenBlockExpression4(ConditionParser.NotParenBlockExpression4Context ctx) {
        return bracked(visit(ctx.notParenExpression(0)) + " OR " + visit(ctx.notParenExpression(1)));
    }
    @Override
    public String visitNotParenBlockExpression5(ConditionParser.NotParenBlockExpression5Context ctx) {
        return bracked(visit(ctx.notParenExpression()) + " OR " + visit(ctx.parenExpression()));
    }
    @Override
    public String visitNotParenBlockExpression6(ConditionParser.NotParenBlockExpression6Context ctx) {
        return bracked(visit(ctx.parenExpression()) + " OR " + visit(ctx.notParenExpression()));
    }
    @Override
    public String visitNotParenBlockExpression7(ConditionParser.NotParenBlockExpression7Context ctx) {
        return bracked("NOT " + visit(ctx.notParenExpression()));
    }

    @Override
    public String visitBasicBlockExpression(ConditionParser.BasicBlockExpressionContext ctx) {
        String ret = visitChildren(ctx);
        if(ret.contains("@#$%TRUE%$#@"))
            ret = "TRUE";
        return bracked(ret);
    }

    @Override
    public String visitCompareExpression(ConditionParser.CompareExpressionContext ctx) {
        return visit(ctx.left) + Tools.getFullContext(ctx.op) + visit(ctx.right);
    }
    @Override
    public String visitBool(ConditionParser.BoolContext ctx) {
        if(ctx.trueExpression() != null) return visitTrueExpression(ctx.trueExpression());
        else if(ctx.falseExpression() != null) return visitFalseExpression(ctx.falseExpression());
        else return Tools.getFullContext(ctx);
    }

    @Override
    public String visitFuncExpression(ConditionParser.FuncExpressionContext ctx) {
        return Tools.getFullContext(ctx);
    }

    @Override
    public String visitColExpression(ConditionParser.ColExpressionContext ctx) {
        String fullColumnName = Tools.getFullContext(ctx);
        if(!this.targetFullColumnNames.contains(fullColumnName))
            fullColumnName = "@#$%TRUE%$#@";
        return fullColumnName;
    }

    @Override
    public String visitAtomExpression(ConditionParser.AtomExpressionContext ctx) {
        return Tools.getFullContext(ctx);
    }

    @Override
    public String visitInvolutionLawExpression(ConditionParser.InvolutionLawExpressionContext ctx) {
        return visit(ctx.parenExpression());
    }

    @Override
    public String visitSingleNotExpression(ConditionParser.SingleNotExpressionContext ctx) {
        return "NOT " + visit(ctx.parenExpression());
    }

    @Override
    public String visitAndExpression(ConditionParser.AndExpressionContext ctx) {
        StringBuilder ret = new StringBuilder(visit(ctx.parenExpression(0)));
        for(int i = 1; i < ctx.parenExpression().size(); ++i) {
            ret.append(" AND ").append(visit(ctx.parenExpression(i)));
        }

        return bracked(ret.toString());
    }

    @Override
    public String visitOrExpression(ConditionParser.OrExpressionContext ctx) {
        StringBuilder ret = new StringBuilder(visit(ctx.parenExpression(0)));
        for(int i = 1; i < ctx.parenExpression().size(); ++i) {
            ret.append(" OR ").append(visit(ctx.parenExpression(i)));
        }

        return bracked(ret.toString());
    }

    @Override
    public String visitTrueExpression(ConditionParser.TrueExpressionContext ctx) {
        return "TRUE";
    }

    @Override
    public String visitFalseExpression(ConditionParser.FalseExpressionContext ctx) {
        return "FALSE";
    }

    @Override
    public String visitAndDeMorganLawExpression(ConditionParser.AndDeMorganLawExpressionContext ctx) {
        StringBuilder ret = new StringBuilder();
        for (ConditionParser.ParenExpressionContext e : ctx.andExpression().parenExpression()) {
            ret.append("(NOT (").append(visit(e)).append(")) OR ");
        }
        ret.delete(ret.length()-" OR ".length(),ret.length());
        return ret.toString();
    }


    private String bracked(String str) {
        return "(" + str + ")";
    }
}
