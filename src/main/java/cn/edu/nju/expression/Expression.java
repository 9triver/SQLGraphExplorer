package cn.edu.nju.expression;

import cn.edu.nju.expression.cktuple.CKTuple;
import cn.edu.nju.expression.cktuple.CKTuples;
import cn.edu.nju.expression.cktuple.constraint.Constraint;
import cn.edu.nju.graph.Graph.Table;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class Expression {
    private final OpType op;
    private Expression e1;
    private Expression e2;
    private Table table;
    private Scheme projectionScheme;
    private RenameMap renameMap;
    private Constraint selectionCondition;
    static Logger logger = Logger.getLogger(Expression.class);
    public Expression(Table table) {
        this.op = OpType.ATOM;
        this.table = table;
    }
    public Expression(OpType op, Constraint selectionCondition, Scheme projectionScheme, RenameMap renameMap, Expression... e) {
        this.op = op;
        if (e.length > 1)
            e2 = e[1];
        if (e.length > 0)
            e1 = e[0];

        if (op == OpType.PROJECTION)
            this.projectionScheme = projectionScheme;
        if(op == OpType.SELECTION)
            this.selectionCondition = selectionCondition;
        if(op == OpType.RENAME)
            this.renameMap = renameMap;
    }
    public static Expression table(Table table) {
        return new Expression(table);
    }
    public static Expression selection(Constraint selectionCondition, Expression e) {
        return new Expression(OpType.SELECTION,selectionCondition,null,null, e);
    }
    public static Expression projection(Scheme projectionScheme, Expression e) {
        return new Expression(OpType.PROJECTION,null,projectionScheme,null, e);
    }
    public static Expression rename(RenameMap renameMap, Expression e) {
        return new Expression(OpType.RENAME,null,null,renameMap, e);
    }
    public static Expression union(Expression e1, Expression e2) {
        return new Expression(OpType.UNION,null,null,null, e1,e2);
    }
    public static Expression intersection(Expression e1, Expression e2) {
        return new Expression(OpType.INTERSECTION,null,null,null, e1,e2);
    }
    public static Expression production(Expression e1, Expression e2) {
        return new Expression(OpType.CARTESIAN_PRODUCTION,null,null,null, e1,e2);
    }

    public CKTuples inverse(CKTuples pSet) {
        CKTuples result = switch (this.op) {
            case ATOM -> CKTuples.atom(pSet);
            case SELECTION -> e1.inverse(CKTuples.selection(pSet, this.selectionCondition));
            case PROJECTION -> e1.inverse(CKTuples.extension(pSet, e1.scheme()));
            case CARTESIAN_PRODUCTION -> CKTuples.append(e1.inverse(CKTuples.projection(pSet, e1.scheme())),
                                                         e2.inverse(CKTuples.projection(pSet, e2.scheme())));
            case INTERSECTION -> CKTuples.append(e1.inverse(pSet), e2.inverse(pSet));
            case UNION -> CKTuples.completion(e1.inverse(pSet), e2.inverse(pSet));
            case RENAME -> e1.inverse(CKTuples.rename(pSet, this.renameMap));
            case DIFFERENCE -> null;
        };

        assert result != null;
        logger.debug("op: " + this.op);
        logger.debug("size: " + result.size());
        List<String> tableNames = new ArrayList<>();
        for(CKTuple ckTuple : result.getCkTuples())
            tableNames.add(ckTuple.getKTuple().getTable().tableName);
        logger.debug("tables: "+tableNames);
        return result;
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
