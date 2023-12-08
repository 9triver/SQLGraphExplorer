package cn.edu.nju.expression;

import cn.edu.nju.expression.cktuple.CKTuples;
import cn.edu.nju.expression.cktuple.Constraint;
import cn.edu.nju.graph.Graph.Table;


public class Expression {
    private final OpType op;
    private Expression e1;
    private Expression e2;
    private Table table;
    private Scheme projectionScheme;
    private Constraint selectionCondition;

    public Expression(Table table) {
        this.op = OpType.ATOM;
        this.table = table;
    }

    public Expression(OpType op, Constraint selectionCondition, Scheme projectionScheme, Expression... e) {
        this.op = op;
        if (e.length > 1)
            e2 = e[1];
        if (e.length > 0)
            e1 = e[0];

        if (op == OpType.PROJECTION)
            this.projectionScheme = projectionScheme;
        if(op == OpType.SELECTION)
            this.selectionCondition = selectionCondition;
    }

    public CKTuples inverse(CKTuples pSet) {
        return switch (this.op) {
            case ATOM -> CKTuples.atom(pSet);
            case SELECTION -> e1.inverse(CKTuples.selection(pSet, this.selectionCondition));
            case PROJECTION -> e1.inverse(CKTuples.extension(pSet, e1.scheme()));
            case CARTESIAN_PRODUCTION -> CKTuples.append(e1.inverse(CKTuples.projection(pSet, e1.scheme())),
                                                         e2.inverse(CKTuples.projection(pSet, e2.scheme())));
            case INTERSECTION -> CKTuples.append(e1.inverse(pSet), e2.inverse(pSet));
            case UNION -> CKTuples.completion(e1.inverse(pSet), e2.inverse(pSet));
            case DIFFERENCE,RENAME -> null;
        };
    }

    public Scheme scheme() {
        Scheme ret = new Scheme();
        switch (this.op) {
            case ATOM -> ret.add(this.table.allScheme());
            case SELECTION, INTERSECTION, UNION -> ret.add(this.e1.scheme());
            case PROJECTION -> ret.add(this.projectionScheme);
            case CARTESIAN_PRODUCTION -> {
                ret.add(this.e1.scheme());
                ret.add(this.e2.scheme());
            }
            default -> ret = new Scheme();
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
