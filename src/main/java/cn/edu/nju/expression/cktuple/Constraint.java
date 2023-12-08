package cn.edu.nju.expression.cktuple;

import java.util.ArrayList;
import java.util.List;

public class Constraint {
    private final String context;
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

    public List<Constraint> orSplit() {
        List<Constraint> ret = new ArrayList<>();
        int i = 0, j = 0, count = 0;
        boolean isAND = false;
        for(;j < context.length(); ++j) {
            if(context.charAt(j)=='(') count++;
            else if(context.charAt(j)==')') count--;
            else if(count == 0) {
                boolean is_or = j<context.length()-1 &&
                                (context.charAt(j)=='O' || context.charAt(j)=='o') &&
                                (context.charAt(j+1)=='R' || context.charAt(j+1)=='r');
                boolean is_and = j<context.length()-2 &&
                                (context.charAt(j)=='A' || context.charAt(j)=='a') &&
                                (context.charAt(j+1)=='N' || context.charAt(j+1)=='n') &&
                                (context.charAt(j+2)=='D' || context.charAt(j+2)=='d');
                if(is_or || is_and) {
                    if (isAND) {
                        for (int index = 0; index < ret.size(); ++index)
                            ret.set(index, Constraint.and(ret.get(index), new Constraint(context.substring(i, j).trim())));
                    } else {
                        ret.add(new Constraint(context.substring(i, j).trim()));
                    }
                    ++j;
                    if(is_and) ++j;
                    i = j + 1;
                    isAND=is_and;
                }
            }
        }

        if(count == 0 && i < j) {
            if (isAND) {
                for (int index = 0; index < ret.size(); ++index)
                    ret.set(index, Constraint.and(ret.get(index), new Constraint(context.substring(i, j).trim())));
            } else {
                ret.add(new Constraint(context.substring(i, j).trim()));
            }
        }

        return ret;
    }
    @Override
    public String toString() {
        return this.context;
    }
}
