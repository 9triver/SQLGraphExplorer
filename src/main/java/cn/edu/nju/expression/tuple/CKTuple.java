package cn.edu.nju.expression.tuple;

import cn.edu.nju.graph.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CKTuple {
    private final KTuple kTuple;
    private final Constraint constraint;
    public CKTuple(KTuple kTuple, Constraint constraint) {
        this.kTuple = kTuple;
        this.constraint=constraint;
    }

    public static CKTuple projection(CKTuple p, Set<Graph.Column> relationScheme)  {
        Constraint constraint = p.getConstraint();
        KTuple kTuple = new KTuple(relationScheme);
        return new CKTuple(kTuple, constraint);
    }
    public static CKTuple extension(CKTuple p, Set<Graph.Column> relationScheme)  {
        Constraint constraint = p.getConstraint();
        KTuple kTuple = new KTuple(relationScheme);
        return new CKTuple(kTuple, constraint);
    }
    public static List<CKTuple> append(CKTuple p1, CKTuple p2) {
        List<CKTuple> ret = new ArrayList<>();
        ret.add(new CKTuple(p1.kTuple, Constraint.and(p1.constraint, p2.constraint)));
        ret.add(new CKTuple(p2.kTuple, Constraint.and(p1.constraint, p2.constraint)));
        return ret;
    }
    public static List<CKTuple> completion(CKTuple p1, CKTuple p2) {
        List<CKTuple> ret = new ArrayList<>();
        ret.add(new CKTuple(p1.kTuple, p1.constraint));
        ret.add(new CKTuple(p2.kTuple, p2.constraint));
        return ret;
    }

    public static CKTuple constraintIntersection(CKTuple p, Constraint c) {
        return new CKTuple(p.kTuple, Constraint.and(p.constraint, c));
    }

    public KTuple getKTuple() {
        return kTuple;
    }
    public Constraint getConstraint() {
        return constraint;
    }
}
