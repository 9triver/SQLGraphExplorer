package cn.edu.nju.expression.tuple;

import cn.edu.nju.graph.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CKTuple {
    private List<KTuple> kTuples;
    private Constraint constraint;
    public CKTuple(KTuple kTuple, Constraint constraint) {
        this.kTuples = new ArrayList<>();
        this.kTuples.add(kTuple);
        this.constraint = constraint;
    }
    public CKTuple(List<KTuple> kTuples, Constraint constraint) {
        this.kTuples = kTuples;
        this.constraint = constraint;
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
    public static CKTuple append(CKTuple p1, CKTuple p2) {
        List<KTuple> kTuples = new ArrayList<>();
        kTuples.addAll(p1.kTuples);
        kTuples.addAll(p2.kTuples);
        Constraint constraint = Constraint.and(p1.constraint,p2.constraint);
        return new CKTuple(kTuples, constraint);
    }
    public static CKTuple completion(CKTuple p1, CKTuple p2) {
        // TODO: 使用空元组进行对齐补全，不太直观。。。
    }
    public static CKTuple constraintIntersection(CKTuple p, Constraint c) {
        return new CKTuple(p.kTuples, Constraint.and(p.constraint, c));
    }

    public List<KTuple> getKTuples() {
        return kTuples;
    }
    public Constraint getConstraint() {
        return constraint;
    }
}
