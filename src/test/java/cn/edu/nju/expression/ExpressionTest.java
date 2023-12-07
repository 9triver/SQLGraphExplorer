package cn.edu.nju.expression;

import cn.edu.nju.expression.tuple.CKTuple;
import cn.edu.nju.expression.tuple.CKTuples;
import cn.edu.nju.expression.tuple.Constraint;
import cn.edu.nju.expression.tuple.KTuple;
import cn.edu.nju.graph.Graph;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class ExpressionTest {
    Graph graph;
    Expression expression1, expression2;
    @Before
    public void initial() {
        // tables
        graph = new Graph();
        Graph.Table r1 = graph.createTable("R1");
        graph.addColumns("R1", "A", "B");
        Graph.Table r2 = graph.createTable("R2");
        graph.addColumns("R2", "B", "C");
        Graph.Table r3 = graph.createTable("R3");
        graph.addColumns("R3", "A", "C");
        Graph.Table a1 = graph.createTable("A1");
        graph.addColumns("A1","A11","A12","A13","A14","A15","A16","B11");
        Graph.Table a2 = graph.createTable("A2");
        graph.addColumns("A2","A21","A22","A23","A24","A25","A26","B21");
        Graph.Table b = graph.createTable("B");
        graph.addColumns("B","B01","B02","B03","B04");
        Graph.Table c = graph.createTable("C");
        graph.addColumns("B","GH","XM","GJ");

        // expression1
        Expression er1 = new Expression(r1);
        Expression er2 = new Expression(r2);
        Expression e = new Expression(OpType.CARTESIAN_PRODUCTION, null, null, er1, er2);
        e = new Expression(OpType.SELECTION, new Constraint("B=b"), null, e);
        e = new Expression(OpType.PROJECTION, null, r3.allScheme(), e);
        this.expression1 = e;
        // expression2
        Expression ea1 = new Expression(a1);
        Expression ea2 = new Expression(a2);
        Expression eb = new Expression(b);
        Expression e1 = new Expression(OpType.CARTESIAN_PRODUCTION, null, null, ea1, eb);
        Expression e2 = new Expression(OpType.CARTESIAN_PRODUCTION, null, null, ea2, eb);
        e1 = new Expression(OpType.SELECTION,
                new Constraint("A1.B11 = B.B01 AND B.B02 <= '#{ETL_DT}' AND B.B03 > '#{ETL_DT}'"),
                null,e1);
        e1 = new Expression(OpType.SELECTION,
                new Constraint("LENGTH(NVL(A1.A11,'')) > 0 AND A1.A14 <= '#{ETL_DT}' AND A1.A15 > '#{ETL_DT}'"),
                null,e1);
        e2 = new Expression(OpType.SELECTION,
                new Constraint("A2.B21 = B.B01 AND B.B02 <= '#{ETL_DT}' AND B.B03 > '#{ETL_DT}'"),
                null,e2);
        e2 = new Expression(OpType.SELECTION,
                new Constraint("LENGTH(NVL(A2.A21,'')) > 0 AND A2.A24 <= '#{ETL_DT}' AND A2.A25 > '#{ETL_DT}' AND A2.A26 <> '0101';"),
                null,e2);
        e1 = new Expression(OpType.PROJECTION, null, a1.scheme("A11","A12","A13"), e1);
        e2 = new Expression(OpType.PROJECTION, null, a1.scheme("A21","A22","A23"), e2);
        this.expression2 = new Expression(OpType.UNION, null, null, e1, e2);
    }
    @Test
    public void testScheme1() {
        Set<Graph.Column> answer = graph.getTable("R3").allScheme();
        Set<Graph.Column> result = this.expression1.scheme();
        Assert.assertEquals(result, answer);

        answer=graph.getTable("R1").allScheme();
        answer.addAll(graph.getTable("R2").allScheme());
        result=this.expression1.getE1().scheme();
        Assert.assertEquals(result, answer);
    }

    @Test
    public void testInverse1() {
        CKTuples target = new CKTuples(new KTuple(graph.getTable("R3").allScheme()), new Constraint(""));
        CKTuples results = this.expression1.inverse(target);
        Assert.assertEquals(results.getCkTuples().size(),2);

        CKTuple ckTuple1 = results.getCkTuples().get(0);
        CKTuple ckTuple2 = results.getCkTuples().get(1);
        Assert.assertEquals(ckTuple1.getConstraint().toString(), "B=b");
        Assert.assertEquals(ckTuple2.getConstraint().toString(), "B=b");
        Assert.assertEquals(ckTuple1.getKTuple().getTable().tableName, "R1");
        Assert.assertEquals(ckTuple2.getKTuple().getTable().tableName, "R2");
        Assert.assertEquals(ckTuple1.getKTuple().allScheme(),graph.getTable("R1").allScheme());
        Assert.assertEquals(ckTuple2.getKTuple().allScheme(),graph.getTable("R2").allScheme());
    }

    @Test
    public void testInverse2() {
    }
}
