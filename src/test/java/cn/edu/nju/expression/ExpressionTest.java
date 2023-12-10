package cn.edu.nju.expression;

import cn.edu.nju.expression.cktuple.CKTuple;
import cn.edu.nju.expression.cktuple.CKTuples;
import cn.edu.nju.expression.cktuple.KTuple;
import cn.edu.nju.expression.cktuple.constraint.Constraint;
import cn.edu.nju.expression.cktuple.tuple.ColumnNode;
import cn.edu.nju.expression.cktuple.tuple.TupleBaseNode;
import cn.edu.nju.graph.Graph;
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
    public void testInverse0() {
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
    public void testInverse1() {
        Graph.Table a1 = graph.getTable("A1");
        Graph.Table a2 = graph.getTable("A2");
        Graph.Table b = graph.getTable("B");
        Graph.Table c = graph.getTable("C");
        Graph.Column a11 = a1.getColumn("A11");
        Graph.Column a12 = a1.getColumn("A12");
        Graph.Column a13 = a1.getColumn("A13");
        Graph.Column a14 = a1.getColumn("A14");
        Graph.Column a15 = a1.getColumn("A15");
        Graph.Column a16 = a1.getColumn("A16");
        Graph.Column b11 = a1.getColumn("B11");
        Graph.Column a21 = a2.getColumn("A21");
        Graph.Column a22 = a2.getColumn("A22");
        Graph.Column a23 = a2.getColumn("A23");
        Graph.Column a24 = a2.getColumn("A24");
        Graph.Column a25 = a2.getColumn("A25");
        Graph.Column a26 = a2.getColumn("A26");
        Graph.Column b21 = a2.getColumn("B21");
        Graph.Column b01 = b.getColumn("B01");
        Graph.Column b02 = b.getColumn("B02");
        Graph.Column b03 = b.getColumn("B03");
        Graph.Column b04 = b.getColumn("B04");
        Graph.Column gh = c.getColumn("GH");
        Graph.Column xm = c.getColumn("XM");
        Graph.Column gj = c.getColumn("GJ");

        CKTuples target = new CKTuples(new KTuple(c, c.getTuple()), new Constraint(""));
        CKTuples results = this.expression2.inverse(target);
        Assert.assertEquals(results.getCkTuples().size(),4);

        for(CKTuple ckTuple : results.getCkTuples()) {
            KTuple kTuple = ckTuple.getKTuple();
            Constraint constraint = ckTuple.getConstraint();
            String tableName = kTuple.getTable().tableName;

            switch (tableName) {
                case "A1" -> {
                    Assert.assertEquals(a1.allScheme(), kTuple.allScheme());
                    Assert.assertEquals("(((LENGTH(NVL(A1.A11,'')) > 0) AND (A1.A14 <= '#{ETL_DT}')) AND (A1.A15 > '#{ETL_DT}')) AND (((A1.B11 = B.B01) AND (B.B02 <= '#{ETL_DT}')) AND (B.B03 > '#{ETL_DT}'))", constraint.toString());
                    KTuple exceptedKTuple = new KTuple(a1).addTupleNode(
                            new ColumnNode(a11, gh),
                            new ColumnNode(a12, xm),
                            new ColumnNode(a13, gj),
                            new ColumnNode(a14, a14),
                            new ColumnNode(a15, a15),
                            new ColumnNode(a16, a16),
                            new ColumnNode(b11, b11)
                            );
                    Assert.assertEquals(exceptedKTuple.getTable(),kTuple.getTable());
                    Assert.assertEquals(exceptedKTuple.getTuple().size(), kTuple.getTuple().size());
                    for(TupleBaseNode t : kTuple.getTuple())
                        if(!exceptedKTuple.getTuple().contains(t))
                            Assert.fail();
                }
                case "A2" -> {
                    Assert.assertEquals(a2.allScheme(), kTuple.allScheme());
                    Assert.assertEquals("((((LENGTH(NVL(A2.A21,'')) > 0) AND (A2.A24 <= '#{ETL_DT}')) AND (A2.A25 > '#{ETL_DT}')) AND (A2.A26 <> '0101';)) AND (((A2.B21 = B.B01) AND (B.B02 <= '#{ETL_DT}')) AND (B.B03 > '#{ETL_DT}'))", constraint.toString());
                    KTuple exceptedKTuple = new KTuple(a2).addTupleNode(
                            new ColumnNode(a21, gh),
                            new ColumnNode(a22, xm),
                            new ColumnNode(a23, gj),
                            new ColumnNode(a24, a24),
                            new ColumnNode(a25, a25),
                            new ColumnNode(a26, a26),
                            new ColumnNode(b21, b21)
                    );
                    Assert.assertEquals(exceptedKTuple.getTable(),kTuple.getTable());
                    Assert.assertEquals(exceptedKTuple.getTuple().size(), kTuple.getTuple().size());
                    for(TupleBaseNode t : kTuple.getTuple())
                        if(!exceptedKTuple.getTuple().contains(t))
                            Assert.fail();
                }
                case "B" -> {
                    Assert.assertEquals(b.allScheme(), kTuple.allScheme());
                    Set<String> expectedConstraints = new HashSet<>();
                    expectedConstraints.add("(((LENGTH(NVL(A1.A11,'')) > 0) AND (A1.A14 <= '#{ETL_DT}')) AND (A1.A15 > '#{ETL_DT}')) AND (((A1.B11 = B.B01) AND (B.B02 <= '#{ETL_DT}')) AND (B.B03 > '#{ETL_DT}'))");
                    expectedConstraints.add("((((LENGTH(NVL(A2.A21,'')) > 0) AND (A2.A24 <= '#{ETL_DT}')) AND (A2.A25 > '#{ETL_DT}')) AND (A2.A26 <> '0101';)) AND (((A2.B21 = B.B01) AND (B.B02 <= '#{ETL_DT}')) AND (B.B03 > '#{ETL_DT}'))");
                    Assert.assertTrue(expectedConstraints.contains(constraint.toString()));
                    KTuple exceptedKTuple = new KTuple(b).addTupleNode(
                            new ColumnNode(b01, b01),
                            new ColumnNode(b02, b02),
                            new ColumnNode(b03, b03),
                            new ColumnNode(b04, b04)
                    );
                    Assert.assertEquals(exceptedKTuple.getTable(),kTuple.getTable());
                    Assert.assertEquals(exceptedKTuple.getTuple().size(), kTuple.getTuple().size());
                    for(TupleBaseNode t : kTuple.getTuple())
                        if(!exceptedKTuple.getTuple().contains(t))
                            Assert.fail();
                }
                default -> Assert.fail();
            }
        }
    }
}
