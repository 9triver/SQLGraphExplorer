package cn.edu.nju.expression.cktuple;

import cn.edu.nju.expression.RenameMap;
import cn.edu.nju.expression.Scheme;
import cn.edu.nju.expression.cktuple.tuple.ColumnNode;
import cn.edu.nju.expression.cktuple.tuple.TupleBaseNode;
import cn.edu.nju.graph.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CKTuple {
    private final KTuple kTuple;
    private final Constraint constraint;
    public CKTuple(CKTuple ckTuple) {
        this.kTuple = ckTuple.kTuple;
        this.constraint = ckTuple.constraint;
    }
    public CKTuple(KTuple kTuple, Constraint constraint) {
        this.kTuple = kTuple;
        this.constraint=constraint;
    }

    public static CKTuple rename(CKTuple p, RenameMap renameMap) {
        Constraint constraint = p.constraint;
        Set<TupleBaseNode> tuple = p.kTuple.getTuple();
        Graph.Table table = p.kTuple.getTable();
        Set<TupleBaseNode> results = new HashSet<>();

        for(TupleBaseNode t : tuple) {
            Graph.Column srcScheme = renameMap.getSrc(t.getColumnScheme());
            if(srcScheme != null) results.add(t.setColumnScheme(srcScheme));
        }

        return new CKTuple(new KTuple(table,results), constraint);
    }
    public static CKTuple projection(CKTuple p, Scheme relationScheme) {
        Constraint constraint = p.constraint;
        Set<TupleBaseNode> tuple = p.kTuple.getTuple();
        Graph.Table table = p.kTuple.getTable();
        Set<TupleBaseNode> results = new HashSet<>();

        for(TupleBaseNode t : tuple) {
            if(relationScheme.containColumn(t.getColumnScheme()))
                results.add(t);
        }
        return new CKTuple(new KTuple(table,results), constraint);
    }
    public static CKTuple extension(CKTuple p, Scheme relationScheme)  {
        Constraint constraint = p.constraint;
        Set<TupleBaseNode> tuple = p.kTuple.getTuple();
        Graph.Table table = p.kTuple.getTable();
        Set<TupleBaseNode> results = new HashSet<>();

        for(Graph.Column s : relationScheme.getColumns()) {
            boolean exist = false;
            for(TupleBaseNode t : tuple) {
                if(t.getColumnSchemeName().equals(s.columnName)){
                    exist = true;
                    results.add(t.setColumnScheme(s));
                    break;
                }
            }
            if(!exist) results.add(new ColumnNode(s,s));
        }

        return new CKTuple(new KTuple(table,results), constraint);
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

    public static CKTuple andConstraint(CKTuple p, Constraint c) {
        return new CKTuple(p.kTuple, Constraint.and(p.constraint, c));
    }
    public static CKTuple atom(CKTuple p) {
        Set<TupleBaseNode> tuple = p.kTuple.getTuple();
        Graph.Table targetTable = tuple.iterator().next().getColumnScheme().table;
        return new CKTuple(new KTuple(targetTable,tuple),p.constraint);
    }

    public String toSql(Graph.Table dstTable) {
        // TODO : CKTuple -> sql, 很困难，感觉这CKTuple的结构要改一下
        return "";
    }
    public KTuple getKTuple() {
        return kTuple;
    }
    public Constraint getConstraint() {
        return constraint;
    }
}
