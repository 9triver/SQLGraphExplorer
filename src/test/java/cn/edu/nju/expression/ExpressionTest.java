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
    Expression expression1;
    @Before
    public void initial() {
        // tables
        graph = new Graph();
        Graph.Table r1 = graph.createTable("R1");
        graph.addColumn("R1", "A");
        graph.addColumn("R1", "B");
        Graph.Table r2 = graph.createTable("R2");
        graph.addColumn("R2", "B");
        graph.addColumn("R2", "C");
        Graph.Table r3 = graph.createTable("R3");
        graph.addColumn("R3", "A");
        graph.addColumn("R3", "C");

        // expression1
        Expression e1 = new Expression(r1);
        Expression e2 = new Expression(r2);
        Expression e = new Expression(OpType.CARTESIAN_PRODUCTION, null, null, e1, e2);
        e = new Expression(OpType.SELECTION, new Constraint("B=b"), null, e);
        e = new Expression(OpType.PROJECTION, null, r3.allScheme(), e);
        this.expression1 = e;
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
}
