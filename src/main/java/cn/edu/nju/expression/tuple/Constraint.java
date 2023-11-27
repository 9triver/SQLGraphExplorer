package cn.edu.nju.expression.tuple;

public class Constraint {
    private String context;
    public Constraint(String context) {
        this.context = context;
    }

    public static Constraint and(Constraint c1, Constraint c2) {
        return new Constraint(c1.getContext()+"^"+c2.getContext());
    }

    public String getContext() {
        return context;
    }
}
