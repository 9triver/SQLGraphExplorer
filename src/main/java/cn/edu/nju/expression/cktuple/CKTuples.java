package cn.edu.nju.expression.cktuple;

import cn.edu.nju.expression.RenameMap;
import cn.edu.nju.expression.Scheme;
import cn.edu.nju.expression.cktuple.constraint.Constraint;
import cn.edu.nju.graph.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CKTuples {
    private final List<CKTuple> ckTuples;
    public CKTuples(KTuple kTuple, Constraint constraint) {
        this.ckTuples = new ArrayList<>();
        this.ckTuples.add(new CKTuple(kTuple,constraint));
    }
    public CKTuples(List<KTuple> kTuples, Constraint constraint) {
        this.ckTuples = new ArrayList<>();
        for(KTuple kTuple : kTuples)
            this.ckTuples.add(new CKTuple(kTuple,constraint));
    }
    public CKTuples(List<CKTuple> ckTuples) {
        this.ckTuples = ckTuples;
    }

    public List<CKTuple> getCkTuples() {
        return ckTuples;
    }

    public static CKTuples projection(CKTuples P, Scheme relationScheme)  {
        List<CKTuple> ckTuplesTmp = new ArrayList<>();
        for(CKTuple p : P.ckTuples)
            ckTuplesTmp.add(CKTuple.projection(p,relationScheme));
        return new CKTuples(ckTuplesTmp);
    }
    public static CKTuples extension(CKTuples P, Scheme relationScheme)  {
        List<CKTuple> ckTuplesTmp = new ArrayList<>();
        for(CKTuple p : P.ckTuples)
            ckTuplesTmp.add(CKTuple.extension(p,relationScheme));
        return new CKTuples(ckTuplesTmp);
    }
    public static CKTuples append(CKTuples P1, CKTuples P2) {
        List<CKTuple> ckTuplesTmp = new ArrayList<>();
        for(CKTuple p1 : P1.ckTuples)
            for(CKTuple p2 : P2.ckTuples)
                ckTuplesTmp.addAll(CKTuple.append(p1,p2));
        return new CKTuples(ckTuplesTmp);
    }
    public static CKTuples completion(CKTuples P1, CKTuples P2) {
        List<CKTuple> ckTuplesTmp = new ArrayList<>();
        ckTuplesTmp.addAll(P1.ckTuples);
        ckTuplesTmp.addAll(P2.ckTuples);
        return new CKTuples(ckTuplesTmp);
    }
    public static CKTuples selection(CKTuples P, Constraint C) {
        List<CKTuple> ckTuplesTmp = new ArrayList<>();
        List<Constraint> splitResult = C.orSplit();
        for(CKTuple p : P.ckTuples)
            for(Constraint c : splitResult)
                ckTuplesTmp.add(CKTuple.andConstraint(p, c));

        return new CKTuples(ckTuplesTmp);
    }
    public static CKTuples atom(CKTuples P) {
        List<CKTuple> ckTuplesTmp = new ArrayList<>();
        for(CKTuple p : P.ckTuples)
            ckTuplesTmp.add(CKTuple.atom(p));
        return new CKTuples(ckTuplesTmp);
    }
    public static CKTuples rename(CKTuples P, RenameMap renameMap) {
        List<CKTuple> ckTuplesTmp = new ArrayList<>();
        for(CKTuple p : P.ckTuples)
            ckTuplesTmp.add(CKTuple.rename(p,renameMap));
        return new CKTuples(ckTuplesTmp);
    }

    public CKTuples simplifyConstraints() {
        for(CKTuple p : this.ckTuples)
            p.simplifyConstraint();
        return this;
    }

    public List<String> toSql() {
        List<String> sqls = new ArrayList<>();
        for(CKTuple ckTuple : this.ckTuples) {
            try {
                sqls.add(ckTuple.toSql());
            } catch (Exception e) {}
        }
        return sqls;
    }

    public int size() {
        return this.ckTuples.size();
    }
}
