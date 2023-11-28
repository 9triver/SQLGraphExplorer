package cn.edu.nju.expression.tuple;

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

    public static CKTuples projection(CKTuples P, Set<Graph.Column> relationScheme)  {
        List<CKTuple> ckTuplesTmp = new ArrayList<>();
        for(CKTuple p : P.ckTuples)
            ckTuplesTmp.add(CKTuple.projection(p,relationScheme));
        return new CKTuples(ckTuplesTmp);
    }
    public static CKTuples extension(CKTuples P, Set<Graph.Column> relationScheme)  {
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
        for(CKTuple p1 : P1.ckTuples)
            for(CKTuple p2 : P2.ckTuples)
                ckTuplesTmp.addAll(CKTuple.completion(p1,p2));
        return new CKTuples(ckTuplesTmp);
    }
}
