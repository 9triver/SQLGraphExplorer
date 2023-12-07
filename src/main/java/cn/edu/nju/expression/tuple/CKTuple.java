package cn.edu.nju.expression.tuple;

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

    public static CKTuple projection(CKTuple p, Set<Graph.Column> relationScheme)  {
        Constraint constraint = p.constraint;
        Set<Graph.Column> columns = p.kTuple.getColumns();
        Graph.Table table = p.kTuple.getTable();
        Set<Graph.Column> results = new HashSet<>();
        for(Graph.Column srcCol : columns) {
            for(Graph.Column targetCol : relationScheme) {
                if(srcCol.columnName.equals(targetCol.columnName)) {
                    results.add(srcCol);
                }
            }
        }

        return new CKTuple(new KTuple(table,results), constraint);
    }
    public static CKTuple extension(CKTuple p, Set<Graph.Column> relationScheme)  {
        Constraint constraint = p.constraint;
        Set<Graph.Column> columns = p.kTuple.getColumns();
        Graph.Table table = p.kTuple.getTable();
        for(Graph.Column targetCol : relationScheme) {
            boolean exist = false;
            for(Graph.Column srcCol : columns) {
                if(srcCol.columnName.equals(targetCol.columnName)) {
                    exist = true;
                    break;
                }
            }
            if(!exist)
                columns.add(targetCol);
        }

        return new CKTuple(new KTuple(table,columns), constraint);
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
