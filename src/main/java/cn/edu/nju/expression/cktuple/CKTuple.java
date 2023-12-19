package cn.edu.nju.expression.cktuple;

import cn.edu.nju.expression.RenameMap;
import cn.edu.nju.expression.Scheme;
import cn.edu.nju.expression.cktuple.constraint.Constraint;
import cn.edu.nju.expression.cktuple.tuple.ColumnNode;
import cn.edu.nju.expression.cktuple.tuple.TupleBaseNode;
import cn.edu.nju.graph.Graph;
import cn.edu.nju.tools.Tools;

import java.util.*;

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
            if(srcScheme != null) results.add(t.setNewColumnScheme(srcScheme));
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
                    results.add(t.setNewColumnScheme(s));
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

    public static CKTuple andConstraint(CKTuple p, Constraint c) {
        return new CKTuple(p.kTuple, Constraint.and(p.constraint, c));
    }
    public static CKTuple atom(CKTuple p) {
        Set<TupleBaseNode> tuple = p.kTuple.getTuple();
        Graph.Table targetTable = tuple.iterator().next().getColumnScheme().table;
        return new CKTuple(new KTuple(targetTable,tuple),p.constraint);
    }

    public void simplifyConstraint() {
        this.constraint.simplify(this.kTuple.getTable());
    }

    public String toSql() {
        // TODO : CKTuple -> sql
        return Tools.translateFromRA2Sql(this.toRA());
    }

    private String toRA() {
        StringBuilder
                ra = new StringBuilder(),
                matchCondition = new StringBuilder(),
                projectionList = new StringBuilder();
        Graph.Table srcTable = this.kTuple.getTable();
        Set<TupleBaseNode> tuple = this.kTuple.getTuple();
        for(TupleBaseNode node : tuple) {
            if(node instanceof ColumnNode columnNode) {
                String fullColumnName = columnNode.getColumn().toString();
                String fullColumnSchemaName = columnNode.getColumnScheme().toString();

                projectionList.append(fullColumnSchemaName).append(",");
                if(fullColumnName.equals(fullColumnSchemaName))
                    continue;
                matchCondition.append(fullColumnSchemaName).append("=").append(fullColumnName).append(" AND ");
            }
        }
        if(matchCondition.isEmpty())
            return null;

        matchCondition.delete(matchCondition.length()-" AND ".length(), matchCondition.length());
        projectionList.delete(projectionList.length()-1,projectionList.length());
        matchCondition.insert(0,"(").append(")");
        projectionList.insert(0,"[").append("]");

        Constraint combinedConstraint = Constraint.and(new Constraint(matchCondition.toString()), this.constraint);
        return ra.append("project").append(projectionList).
                append("(select[").append(combinedConstraint).append("](").
                append(srcTable.toString()).append("));").toString();
    }

    public KTuple getKTuple() {
        return kTuple;
    }
    public Constraint getConstraint() {
        return constraint;
    }
}
