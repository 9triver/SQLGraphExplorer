package cn.edu.nju.expression.cktuple.constraint;

import cn.edu.nju.graph.Graph;
import cn.edu.nju.tools.Tools;

import java.util.ArrayList;
import java.util.List;

public class Constraint {
    private String context;

    public Constraint(String context) {
        this.context = context;
    }
    public Constraint(Constraint constraint) {
        this.context = String.copyValueOf(constraint.context.toCharArray());
    }

    public static Constraint and(Constraint c1, Constraint c2) {
        if(c1.context.isBlank()) return new Constraint(c2);
        if(c2.context.isBlank()) return new Constraint(c1);
        if(c1.context.equals(c2.context)) return new Constraint(c1);
        return new Constraint("("+c1+") AND ("+c2+")");
    }
    public static Constraint or(Constraint c1, Constraint c2) {
        if(c1.context.isBlank()) return new Constraint(c2);
        if(c2.context.isBlank()) return new Constraint(c1);
        if(c1.context.equals(c2.context)) return new Constraint(c1);
        return new Constraint("("+c1+") OR ("+c2+")");
    }

    public Constraint simplify(Graph.Table targetTable) {
        this.context = Tools.simplify(this.context, targetTable);
        return this;
    }
    public Constraint simplify() {
        this.context = Tools.simplify(this.context);
        return this;
    }

    public List<Constraint> orSplit() {
        List<Constraint> ret = new ArrayList<>();
        for(String str : Tools.split(this.context))
            ret.add(new Constraint(str));
        return ret;
    }

    @Override
    public String toString() {
        return this.context;
    }
}
