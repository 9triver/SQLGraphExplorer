package cn.edu.nju.tools.condition;

import cn.edu.nju.graph.Graph;
import cn.edu.nju.tools.Tools;
import cn.edu.nju.tools.condition.grammar.simplifier.SimplifierParser;
import cn.edu.nju.tools.condition.grammar.simplifier.SimplifierParserBaseVisitor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @className：Simplifier
 * @version: 1.0.0
 * @description：简化器
 * @author: Xin
 * @date: 2023-12-25 15:49:48
 */
public class Simplifier extends SimplifierParserBaseVisitor<String> {
    private final Set<String> targetFullColumnNames = new HashSet<>();

    /**
     * 设置目标列名
     *
     * @param targetTable 目标表格
     * @author: Xin
     * @date: 2023-12-25 15:49:53
     */
    public void setTargetColumnName(Graph.Table targetTable) {
        targetFullColumnNames.clear();
        if(targetTable == null) return;

        targetFullColumnNames.addAll(targetTable.allFullColumnNames());
    }

    @Override
    public String visitParse(SimplifierParser.ParseContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public String visitMultiParenExpression(SimplifierParser.MultiParenExpressionContext ctx) {
        return visit(ctx.parenExpression());
    }

    @Override
    public String visitSingleParenExpression(SimplifierParser.SingleParenExpressionContext ctx) {
        return visit(ctx.notParenExpression());
    }

    @Override
    public String visitAnnulmentLawExpression(SimplifierParser.AnnulmentLawExpressionContext ctx) {
        String ret;
        if(ctx.falseExpression() != null) ret = visitFalseExpression(ctx.falseExpression());
        else if(ctx.trueExpression() != null) ret = visitTrueExpression(ctx.trueExpression());
        else ret = visitChildren(ctx);
        return bracked(ret);
    }

    @Override
    public String visitIdentityLawExpression(SimplifierParser.IdentityLawExpressionContext ctx) {
        return bracked(visit(ctx.parenExpression()));
    }

    @Override
    public String visitAndDistributiveLawExpression(SimplifierParser.AndDistributiveLawExpressionContext ctx) {
        StringBuilder ret = new StringBuilder();
        if(ctx.leftOr != null && ctx.rightOr != null) {
            for(SimplifierParser.ParenExpressionContext left : ctx.leftOr.parenExpression())
                for(SimplifierParser.ParenExpressionContext right : ctx.rightOr.parenExpression())
                    ret.append("(").append(visit(left)).append(" AND ").append(visit(right)).append(")").append(" OR ");
        }
        else if(ctx.leftBasic != null && ctx.rightOr != null) {
            for(SimplifierParser.ParenExpressionContext right : ctx.rightOr.parenExpression())
                ret.append("(").append(visit(ctx.leftBasic)).append(" AND ").append(visit(right)).append(")").append(" OR ");
        }
        else if(ctx.leftOr != null && ctx.rightBasic != null) {
            for(SimplifierParser.ParenExpressionContext left : ctx.leftOr.parenExpression())
                ret.append("(").append(visit(left)).append(" AND ").append(visit(ctx.rightBasic)).append(")").append(" OR ");
        }
        else
            return visitChildren(ctx);
        ret.delete(ret.length() - " OR ".length(), ret.length());
        return bracked(ret.toString());
    }

    @Override
    public String visitAndBasicExpression(SimplifierParser.AndBasicExpressionContext ctx) {
        StringBuilder ret = new StringBuilder(visit(ctx.parenExpression(0)));
        for(int i = 1; i < ctx.parenExpression().size(); ++i) {
            ret.append(" AND ").append(visit(ctx.parenExpression(i)));
        }

        return bracked(ret.toString());
    }

    @Override
    public String visitOrBasicExpression(SimplifierParser.OrBasicExpressionContext ctx) {
        StringBuilder ret = new StringBuilder(visit(ctx.parenExpression(0)));
        for(int i = 1; i < ctx.parenExpression().size(); ++i) {
            ret.append(" OR ").append(visit(ctx.parenExpression(i)));
        }

        return bracked(ret.toString());
    }

    @Override
    public String visitNotsExpression(SimplifierParser.NotsExpressionContext ctx) {
        return bracked(visit(ctx.notExpression()));
    }

    @Override
    public String visitNotParenBlockExpression1(SimplifierParser.NotParenBlockExpression1Context ctx) {
        return bracked(visit(ctx.notParenExpression()) + " " + ctx.logicOp().getText() + " " + bracked(visit(ctx.basicExpression())));
    }
    @Override
    public String visitNotParenBlockExpression2(SimplifierParser.NotParenBlockExpression2Context ctx) {
        return bracked(visit(ctx.notParenExpression()) + " " + ctx.logicOp().getText() + " " + visit(ctx.parenExpression()));
    }
    @Override
    public String visitNotParenBlockExpression3(SimplifierParser.NotParenBlockExpression3Context ctx) {
        return visit(ctx.parenExpression()) + " " + ctx.logicOp().getText() + " " + bracked(visit(ctx.basicExpression()));
    }
    @Override
    public String visitNotParenBlockExpression4(SimplifierParser.NotParenBlockExpression4Context ctx) {
        return bracked("NOT " + visit(ctx.notParenExpression()));
    }

    int deepHeight = 0;
    @Override
    public String visitBasicBlockExpression(SimplifierParser.BasicBlockExpressionContext ctx) {
        deepHeight++;
        String ret = visitChildren(ctx);
        deepHeight--;
        if(deepHeight <= 0 && ret.contains("@#$%TRUE%$#@"))
            ret = "TRUE";
        return bracked(ret);
    }

    @Override
    public String visitCompareExpression(SimplifierParser.CompareExpressionContext ctx) {
        return visit(ctx.left) + Tools.getFullContext(ctx.op) + visit(ctx.right);
    }
    @Override
    public String visitBool(SimplifierParser.BoolContext ctx) {
        if(ctx.trueExpression() != null) return visitTrueExpression(ctx.trueExpression());
        else if(ctx.falseExpression() != null) return visitFalseExpression(ctx.falseExpression());
        else return Tools.getFullContext(ctx);
    }

    @Override
    public String visitFuncExpression(SimplifierParser.FuncExpressionContext ctx) {
        StringBuilder ret = new StringBuilder(ctx.functionName().getText() + "(");
        List<SimplifierParser.ExpressionContext> expressions = ctx.expression();
        ret.append(visit(expressions.get(0)));
        for(int i = 1; i < expressions.size(); ++i)
            ret.append(",").append(visit(expressions.get(i)));

        return ret.append(")").toString();
    }

    @Override
    public String visitColExpression(SimplifierParser.ColExpressionContext ctx) {
        String fullColumnName = Tools.getFullContext(ctx);
        fullColumnName = Tools.getRealFullColumnName(fullColumnName);
        if(!this.targetFullColumnNames.contains(fullColumnName))
            fullColumnName = "@#$%TRUE%$#@";
        return fullColumnName;
    }

    @Override
    public String visitAtomExpression(SimplifierParser.AtomExpressionContext ctx) {
        return Tools.getFullContext(ctx);
    }

    @Override
    public String visitInvolutionLawExpression(SimplifierParser.InvolutionLawExpressionContext ctx) {
        return visit(ctx.parenExpression());
    }

    @Override
    public String visitSingleNotExpression(SimplifierParser.SingleNotExpressionContext ctx) {
        return "NOT " + visit(ctx.parenExpression());
    }

    @Override
    public String visitAndExpression(SimplifierParser.AndExpressionContext ctx) {
        StringBuilder ret = new StringBuilder(visit(ctx.parenExpression(0)));
        for(int i = 1; i < ctx.parenExpression().size(); ++i) {
            ret.append(" AND ").append(visit(ctx.parenExpression(i)));
        }

        return bracked(ret.toString());
    }

    @Override
    public String visitOrExpression(SimplifierParser.OrExpressionContext ctx) {
        StringBuilder ret = new StringBuilder(visit(ctx.parenExpression(0)));
        for(int i = 1; i < ctx.parenExpression().size(); ++i) {
            ret.append(" OR ").append(visit(ctx.parenExpression(i)));
        }

        return bracked(ret.toString());
    }

    @Override
    public String visitTrueExpression(SimplifierParser.TrueExpressionContext ctx) {
        return "TRUE";
    }

    @Override
    public String visitFalseExpression(SimplifierParser.FalseExpressionContext ctx) {
        return "FALSE";
    }

    @Override
    public String visitAndDeMorganLawExpression(SimplifierParser.AndDeMorganLawExpressionContext ctx) {
        StringBuilder ret = new StringBuilder();
        for (SimplifierParser.ParenExpressionContext e : ctx.andExpression().parenExpression()) {
            ret.append("(NOT (").append(visit(e)).append(")) OR ");
        }
        ret.delete(ret.length()-" OR ".length(),ret.length());
        return ret.toString();
    }


    private String bracked(String str) {
        return "(" + str + ")";
    }
}
