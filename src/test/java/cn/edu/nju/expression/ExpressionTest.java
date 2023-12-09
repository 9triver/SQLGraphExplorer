package cn.edu.nju.expression;

import cn.edu.nju.expression.cktuple.CKTuple;
import cn.edu.nju.expression.cktuple.CKTuples;
import cn.edu.nju.expression.cktuple.Constraint;
import cn.edu.nju.expression.cktuple.KTuple;
import cn.edu.nju.expression.cktuple.tuple.ColumnNode;
import cn.edu.nju.expression.cktuple.tuple.TupleBaseNode;
import cn.edu.nju.graph.Graph;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        graph.addColumns("C","GH","XM","GJ");

        // expression1
        Expression er1 = Expression.table(r1);
        Expression er2 = Expression.table(r2);
        Expression e = Expression.production(er1,er2);
        e = Expression.selection(new Constraint("B=b"),e);
        e = Expression.projection(r3.allScheme(),e);
        this.expression1 = e;
        // expression2
        Expression ea1 = Expression.table(a1);
        Expression ea2 = Expression.table(a2);
        Expression eb = Expression.table(b);

        Expression e1 = Expression.production(ea1,eb);
        e1 = Expression.selection(new Constraint("A1.B11 = B.B01 AND B.B02 <= '#{ETL_DT}' AND B.B03 > '#{ETL_DT}'"),e1);
        e1 = Expression.selection(new Constraint("LENGTH(NVL(A1.A11,'')) > 0 AND A1.A14 <= '#{ETL_DT}' AND A1.A15 > '#{ETL_DT}'"),e1);
        e1 = Expression.projection(a1.scheme("A11","A12","A13"), e1);
        RenameMap renameMap1 = new RenameMap();
        renameMap1.add(a1.getColumn("A11"), c.getColumn("GH"));
        renameMap1.add(a1.getColumn("A12"), c.getColumn("XM"));
        renameMap1.add(a1.getColumn("A13"), c.getColumn("GJ"));
        e1 = Expression.rename(renameMap1, e1);

        Expression e2 = Expression.production(ea2,eb);
        e2 = Expression.selection(new Constraint("A2.B21 = B.B01 AND B.B02 <= '#{ETL_DT}' AND B.B03 > '#{ETL_DT}'"), e2);
        e2 = Expression.selection(new Constraint("LENGTH(NVL(A2.A21,'')) > 0 AND A2.A24 <= '#{ETL_DT}' AND A2.A25 > '#{ETL_DT}' AND A2.A26 <> '0101';"), e2);
        e2 = Expression.projection(a2.scheme("A21","A22","A23"), e2);
        RenameMap renameMap2 = new RenameMap();
        renameMap2.add(a2.getColumn("A21"), c.getColumn("GH"));
        renameMap2.add(a2.getColumn("A22"), c.getColumn("XM"));
        renameMap2.add(a2.getColumn("A23"), c.getColumn("GJ"));
        e2 = Expression.rename(renameMap2, e2);

        this.expression2 = Expression.union(e1,e2);
    }
    @Test
    public void testScheme1() {
        Scheme answer = graph.getTable("R3").allScheme();
        Scheme result = this.expression1.scheme();
        Assert.assertEquals(result, answer);

        answer=graph.getTable("R1").allScheme();
        answer.add(graph.getTable("R2").allScheme());
        result=this.expression1.getE1().scheme();
        Assert.assertEquals(result, answer);
    }

    @Test
    public void testInverse1() {
        Graph.Table r1 = graph.getTable("R1");
        Graph.Table r2 = graph.getTable("R2");
        Graph.Table r3 = graph.getTable("R3");
        Graph.Column r1a = r1.getColumn("A");
        Graph.Column r1b = r1.getColumn("B");
        Graph.Column r2b = r2.getColumn("B");
        Graph.Column r2c = r2.getColumn("C");
        Graph.Column r3a = r3.getColumn("A");
        Graph.Column r3c = r3.getColumn("C");
        CKTuples target = new CKTuples(new KTuple(r3, r3.getTuple()), new Constraint(""));
        CKTuples results = this.expression1.inverse(target);
        Assert.assertEquals(results.getCkTuples().size(),2);

        CKTuple ckTuple1 = results.getCkTuples().get(0);
        CKTuple ckTuple2 = results.getCkTuples().get(1);
        KTuple kTuple1 = ckTuple1.getKTuple();
        KTuple kTuple2 = ckTuple2.getKTuple();
        KTuple exceptedKTuple1 = new KTuple(r1).addTupleNode(new ColumnNode(r1a, r3a), new ColumnNode(r1b, r1b));
        KTuple exceptedKTuple2 = new KTuple(r2).addTupleNode(new ColumnNode(r2b, r2b), new ColumnNode(r2c, r3c));
        Constraint constraint1 = ckTuple1.getConstraint();
        Constraint constraint2 = ckTuple2.getConstraint();

        Assert.assertEquals("B=b",constraint1.toString());
        Assert.assertEquals("B=b",constraint2.toString());
        Assert.assertEquals("R1",kTuple1.getTable().tableName);
        Assert.assertEquals("R2",kTuple2.getTable().tableName);
        Assert.assertEquals(r1.allScheme(),kTuple1.allScheme());
        Assert.assertEquals(r2.allScheme(),kTuple2.allScheme());
        Assert.assertEquals(exceptedKTuple1, kTuple1);
        Assert.assertEquals(exceptedKTuple2, kTuple2);
    }

    @Test
    public void testInverse2() {
    }
}
