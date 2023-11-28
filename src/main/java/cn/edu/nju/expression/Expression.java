package cn.edu.nju.expression;

import cn.edu.nju.expression.tuple.CKTuples;
import cn.edu.nju.graph.Graph;
import cn.edu.nju.graph.Graph.Column;
import cn.edu.nju.graph.Graph.Table;

import java.util.HashSet;
import java.util.Set;

public class Expression {
    private OpType op;
    private Expression e1;
    private Expression e2;
    private Table table;
    private Set<Graph.Column> projectionColumns;

    public Expression(Table table) {
        this.table = table;
    }

    public Expression(OpType op, Set<Graph.Column> projectionColumns, Expression... e) {
        this.op = op;
        if (e.length > 1)
            e2 = e[1];
        if (e.length > 0)
            e1 = e[0];

        if (op == OpType.PROJECTION)
            this.projectionColumns = projectionColumns;
    }

    public CKTuples inverse(CKTuples pSet) {
        return switch (this.op) {
            case ATOM -> pSet;
            case SELECTION -> pSet; // TODO: 比较复杂
            case PROJECTION -> e1.inverse(CKTuples.extension(pSet, e1.scheme()));
            case CARTESIAN_PRODUCTION -> CKTuples.append(e1.inverse(CKTuples.projection(pSet, e1.scheme())),
                    e2.inverse(CKTuples.projection(pSet, e2.scheme())));
            case DIFFERENCE -> null;
            case INTERSECTION -> CKTuples.append(e1.inverse(pSet), e2.inverse(pSet));
            case UNION -> CKTuples.completion(e1.inverse(pSet), e2.inverse(pSet));
            case RENAME -> null;
        };
    }

    public Set<Graph.Column> scheme() {
        // TODO: 计算Expression的scheme
        Set<Graph.Column> ret = new HashSet<>();
        switch (this.op) {
            case ATOM:
                ret.addAll(this.table.allScheme());
                break;
            case SELECTION:
                ret.addAll(this.e1.scheme());
                break;
            case PROJECTION:
                ret.addAll(this.projectionColumns);
                break;
            case CARTESIAN_PRODUCTION:
                ret.addAll(this.e1.scheme());
                ret.addAll(this.e2.scheme());
                break;
            case INTERSECTION, UNION:
                ret.addAll(this.e1.scheme());
                break;
            default:
                ret = new HashSet<>();
                break;
        }
        ;
        return ret;
    }

    public OpType getOp() {
        return op;
    }

    public Expression getE1() {
        return e1;
    }

    public Expression getE2() {
        return e2;
    }

    public Table getTable() {
        return table;
    }

    public Set<Graph.Column> getProjectiColumns() {
        return projectionColumns;
    }
}
