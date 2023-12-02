package cn.edu.nju.expression;

import cn.edu.nju.expression.tuple.CKTuples;
import cn.edu.nju.expression.tuple.Constraint;
import cn.edu.nju.graph.Graph;
import cn.edu.nju.graph.Graph.Table;

import java.util.HashSet;
import java.util.Set;

public class Expression {
    private OpType op;
    private Expression e1;
    private Expression e2;
    private Table table;
    private Set<Graph.Column> projectionColumns;
    private Constraint selectionCondition;

    public Expression(Table table) {
        this.op = OpType.ATOM;
        this.table = table;
    }

    public Expression(OpType op, Constraint selectionCondition, Set<Graph.Column> projectionColumns, Expression... e) {
        this.op = op;
        if (e.length > 1)
            e2 = e[1];
        if (e.length > 0)
            e1 = e[0];

        if (op == OpType.PROJECTION)
            this.projectionColumns = projectionColumns;
        if(op == OpType.SELECTION)
            this.selectionCondition = selectionCondition;
    }

    public CKTuples inverse(CKTuples pSet) {
        return switch (this.op) {
            case ATOM -> pSet;
            case SELECTION -> e1.inverse(CKTuples.selection(pSet, this.selectionCondition));
            case PROJECTION -> e1.inverse(CKTuples.extension(pSet, e1.scheme()));
            case CARTESIAN_PRODUCTION -> CKTuples.append(e1.inverse(CKTuples.projection(pSet, e1.scheme())),
                                                         e2.inverse(CKTuples.projection(pSet, e2.scheme())));
            case INTERSECTION -> CKTuples.append(e1.inverse(pSet), e2.inverse(pSet));
            case UNION -> CKTuples.completion(e1.inverse(pSet), e2.inverse(pSet));
            case DIFFERENCE,RENAME -> null;
        };
    }

    public Set<Graph.Column> scheme() {
        Set<Graph.Column> ret = new HashSet<>();
        switch (this.op) {
            case ATOM -> ret.addAll(this.table.allScheme());
            case SELECTION, INTERSECTION, UNION -> ret.addAll(this.e1.scheme());
            case PROJECTION -> ret.addAll(this.projectionColumns);
            case CARTESIAN_PRODUCTION -> {
                ret.addAll(this.e1.scheme());
                ret.addAll(this.e2.scheme());
            }
            default -> ret = new HashSet<>();
        }
        return ret;
    }

    public OpType getOp() {
        return op;
    }
    public Table getTable() {
        return table;
    }
    public Expression getE1() {
        return e1;
    }
    public Expression getE2() {
        return e2;
    }
}
