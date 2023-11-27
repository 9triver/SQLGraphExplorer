package cn.edu.nju.expression;


import cn.edu.nju.expression.tuple.CKTuple;

public class Expression {
    private OpType op;
    private Expression e1;
    private Expression e2;
    private String tableName;

    public Expression(String tableName) {
        this.tableName = tableName;
    }
    public Expression(OpType op, Expression... e) {
        this.op = op;
        if(e.length > 1) e2=e[1];
        if(e.length > 0) e1=e[0];
    }

    public CKTuple inverse(CKTuple p) {
        return switch (this.op) {
            case ATOM -> p;
            case SELECTION -> ;
            case PROJECTION -> ;
            case CARTESIAN_PRODUCTION -> ;
            case INTERSECTION -> ;
            case UNION -> ;
        }
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
    public String getTableName() {
        return tableName;
    }
}
