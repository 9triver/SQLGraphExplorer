package cn.edu.nju.update.translation;

import cn.edu.nju.expression.Expression;
import cn.edu.nju.expression.RenameMap;
import cn.edu.nju.expression.cktuple.Tuple;
import cn.edu.nju.expression.cktuple.constraint.Constraint;
import cn.edu.nju.expression.cktuple.tuple.ColumnNode;
import cn.edu.nju.expression.cktuple.tuple.TupleBaseNode;
import cn.edu.nju.graph.Graph;
import cn.edu.nju.update.UpdateType;
import cn.edu.nju.update.viewUpdate.ViewUpdate;
import com.google.common.collect.ImmutableMap;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class TranslationTest {
    private Graph graph;
    Expression expression0, expression1, expression2;

    @Before
    public void initial() {
        this.graph = new Graph();
        // expression0
        Graph.Table emp = graph.createTable("emp");
        Graph.Table dept = graph.createTable("dept");
        Graph.Table insertView = graph.createTable("emp_dept");
        this.graph.addColumns("emp","Ename", "Pname");
        this.graph.addColumns("dept","Ename", "Dname");
        this.graph.addColumns("emp_dept","Ename", "Dname");

        Expression e = Expression.production(Expression.table(emp),Expression.table(dept));
        e = Expression.selection(new Constraint("PNAME=P"),e);
        this.expression0 = Expression.projection(insertView.allSchema(), e);

        // expression1
        Graph.Table r1 = graph.createTable("R1");
        Graph.Table r2 = graph.createTable("R2");
        Graph.Table r3 = graph.createTable("R3");
        Graph.Table deleteView = graph.createTable("R123");
        graph.addColumns("R1", "A", "B");
        graph.addColumns("R2", "B", "C");
        graph.addColumns("R3", "A", "C");
        graph.addColumns("R123", "A", "C");
        e = Expression.production(Expression.table(r1), Expression.table(r2));
        e = Expression.selection(new Constraint("B>=b"), e);
        e = Expression.projection(deleteView.allSchema(), e);
        this.expression1 = Expression.union(e, Expression.projection(deleteView.allSchema(), Expression.table(r3)));

        // expression2
        Graph.Table a1 = graph.createTable("A1");
        graph.addColumns("A1", "A11", "A12", "A13", "A14", "A15", "A16", "B11");
        Graph.Table a2 = graph.createTable("A2");
        graph.addColumns("A2", "A21", "A22", "A23", "A24", "A25", "A26", "B21");
        Graph.Table b = graph.createTable("B");
        graph.addColumns("B", "B01", "B02", "B03", "B04");
        Graph.Table c = graph.createTable("C");
        graph.addColumns("C", "GH", "XM", "GJ");

        Expression e1 = Expression.production(Expression.table(a1), Expression.table(b));
        e1 = Expression.selection(
                new Constraint("A1.B11 = B.B01 AND B.B02 <= '#{ETL_DT}' AND B.B03 > '#{ETL_DT}'"), e1);
        e1 = Expression.selection(
                new Constraint("LENGTH(NVL(A1.A11,'')) > 0 AND A1.A14 <= '#{ETL_DT}' AND A1.A15 > '#{ETL_DT}'"), e1);
        e1 = Expression.projection(a1.schema("A11", "A12", "A13"), e1);
        RenameMap renameMap1 = new RenameMap();
        renameMap1.add(a1.getColumn("A11"), c.getColumn("GH"));
        renameMap1.add(a1.getColumn("A12"), c.getColumn("XM"));
        renameMap1.add(a1.getColumn("A13"), c.getColumn("GJ"));
        e1 = Expression.rename(renameMap1, e1);
        Expression e2 = Expression.production(Expression.table(a2), Expression.table(b));
        e2 = Expression.selection(
                new Constraint("A2.B21 = B.B01 AND B.B02 <= '#{ETL_DT}' AND B.B03 > '#{ETL_DT}'"), e2);
        e2 = Expression.selection(
                new Constraint("LENGTH(NVL(A2.A21,'')) > 0 AND A2.A24 <= '#{ETL_DT}' AND A2.A25 > '#{ETL_DT}' AND A2.A26 <> '0101'"), e2);
        e2 = Expression.projection(a2.schema("A21", "A22", "A23"), e2);
        RenameMap renameMap2 = new RenameMap();
        renameMap2.add(a2.getColumn("A21"), c.getColumn("GH"));
        renameMap2.add(a2.getColumn("A22"), c.getColumn("XM"));
        renameMap2.add(a2.getColumn("A23"), c.getColumn("GJ"));
        e2 = Expression.rename(renameMap2, e2);
        this.expression2 = Expression.union(e1, e2);
    }
    @Test
    public void testInsert0() {
        // Strongly Deterministic
        Graph.Table viewTable = this.graph.getTable("emp_dept");
        Assert.assertNotNull(viewTable);
        Assert.assertEquals(2, viewTable.allSchema().size());


        ViewUpdate insertViewUpdate = new ViewUpdate(UpdateType.INSERT, viewTable.getKTuple(), this.expression0);
        Translation translation = Translation.inverseViewUpdate(insertViewUpdate);
        Assert.assertNotNull(translation);
        Assert.assertEquals(2, translation.size());

        Update empUpdate = translation.getUpdate(0);
        Update deptUpdate = translation.getUpdate(1);
        Assert.assertEquals(UpdateType.INSERT, empUpdate.getUpdateType());
        Assert.assertEquals(UpdateType.INSERT, deptUpdate.getUpdateType());
        Assert.assertEquals("EMP", empUpdate.getTable().tableName);
        Assert.assertEquals("DEPT", deptUpdate.getTable().tableName);
        Assert.assertEquals(1, empUpdate.getKTuple().size());
        Assert.assertEquals(1, deptUpdate.getKTuple().size());

        Tuple empKTuple = empUpdate.getKTuple().iterator().next();
        Tuple deptKTuple = deptUpdate.getKTuple().iterator().next();
        TupleBaseNode[] empTuple = empKTuple.getTuple().toArray(new TupleBaseNode[0]);
        TupleBaseNode[] deptTuple = deptKTuple.getTuple().toArray(new TupleBaseNode[0]);

        Assert.assertEquals(2, empTuple.length);
        Assert.assertEquals(2, deptTuple.length);
        for(TupleBaseNode node : empTuple)
            Assert.assertTrue(node instanceof ColumnNode);
        for(TupleBaseNode node : deptTuple)
            Assert.assertTrue(node instanceof ColumnNode);

        Map<String, String> empMap = ImmutableMap.<String, String>builder().
                put("EMP.PNAME","EMP.PNAME").
                put("EMP.ENAME","EMP_DEPT.ENAME").
                build();
        for(TupleBaseNode node : empTuple)
            Assert.assertEquals(empMap.get(node.getColumnSchema().toString()), ((ColumnNode) node).getColumn().toString());

        Map<String, String> deptMap = ImmutableMap.<String, String>builder().
                put("DEPT.ENAME","EMP_DEPT.ENAME").
                put("DEPT.DNAME","EMP_DEPT.DNAME").
                build();
        for(TupleBaseNode node : deptTuple)
            Assert.assertEquals(deptMap.get(node.getColumnSchema().toString()), ((ColumnNode) node).getColumn().toString());
    }

    @Test
    public void testDelete0() {
        // Not Strongly Deterministic
        Graph.Table viewTable = this.graph.getTable("emp_dept");
        Assert.assertNotNull(viewTable);
        Assert.assertEquals(2, viewTable.allSchema().size());

        ViewUpdate deleteViewUpdate = new ViewUpdate(UpdateType.DELETE, viewTable.getKTuple(), this.expression0);
        Translation translation = Translation.inverseViewUpdate(deleteViewUpdate);
        Assert.assertNotNull(translation);
        Assert.assertEquals(1, translation.size());

        Update empUpdate = translation.getUpdate(0);
        Assert.assertEquals(UpdateType.DELETE, empUpdate.getUpdateType());
        Assert.assertEquals("EMP", empUpdate.getTable().tableName);
        Assert.assertEquals(1, empUpdate.getKTuple().size());

        Tuple empKTuple = empUpdate.getKTuple().iterator().next();
        TupleBaseNode[] empTuple = empKTuple.getTuple().toArray(new TupleBaseNode[0]);

        Assert.assertEquals(2, empTuple.length);
        for(TupleBaseNode node : empTuple)
            Assert.assertTrue(node instanceof ColumnNode);

        Map<String, String> empMap = ImmutableMap.<String, String>builder().
                put("EMP.PNAME","EMP.PNAME").
                put("EMP.ENAME","EMP_DEPT.ENAME").
                build();
        for(TupleBaseNode node : empTuple)
            Assert.assertEquals(empMap.get(node.getColumnSchema().toString()), ((ColumnNode) node).getColumn().toString());
    }

    @Test
    public void testInsert1() {
        Graph.Table viewTable = this.graph.getTable("R123");
        Assert.assertNotNull(viewTable);
        Assert.assertEquals(2, viewTable.allSchema().size());

        ViewUpdate insertViewUpdate = new ViewUpdate(UpdateType.INSERT, viewTable.getKTuple(), this.expression1);
        Translation translation = Translation.inverseViewUpdate(insertViewUpdate);
        Assert.assertNotNull(translation);
        Assert.assertEquals(2, translation.size());

        Update r1Update = translation.getUpdate(0);
        Update r2Update = translation.getUpdate(1);
        Assert.assertEquals(UpdateType.INSERT, r1Update.getUpdateType());
        Assert.assertEquals(UpdateType.INSERT, r2Update.getUpdateType());
        Assert.assertEquals("R1", r1Update.getTable().tableName);
        Assert.assertEquals("R2", r2Update.getTable().tableName);
        Assert.assertEquals(1, r1Update.getKTuple().size());
        Assert.assertEquals(1, r2Update.getKTuple().size());

        Tuple r1KTuple = r1Update.getKTuple().iterator().next();
        Tuple r2KTuple = r2Update.getKTuple().iterator().next();
        TupleBaseNode[] r1Tuple = r1KTuple.getTuple().toArray(new TupleBaseNode[0]);
        TupleBaseNode[] r2Tuple = r2KTuple.getTuple().toArray(new TupleBaseNode[0]);

        Assert.assertEquals(2, r1Tuple.length);
        Assert.assertEquals(2, r2Tuple.length);
        for(TupleBaseNode node : r1Tuple)
            Assert.assertTrue(node instanceof ColumnNode);
        for(TupleBaseNode node : r2Tuple)
            Assert.assertTrue(node instanceof ColumnNode);

        Map<String, String> r1Map = ImmutableMap.<String, String>builder().
                put("R1.A","R123.A").
                put("R1.B","R1.B").
                build();
        for(TupleBaseNode node : r1Tuple)
            Assert.assertEquals(r1Map.get(node.getColumnSchema().toString()), ((ColumnNode) node).getColumn().toString());
        Map<String, String> r2Map = ImmutableMap.<String, String>builder().
                put("R2.B","R2.B").
                put("R2.C","R123.C").
                build();
        for(TupleBaseNode node : r2Tuple)
            Assert.assertEquals(r2Map.get(node.getColumnSchema().toString()), ((ColumnNode) node).getColumn().toString());
    }
    @Test
    public void testDelete1() {
        Graph.Table viewTable = this.graph.getTable("R123");
        Assert.assertNotNull(viewTable);
        Assert.assertEquals(2, viewTable.allSchema().size());

        ViewUpdate deleteViewUpdate = new ViewUpdate(UpdateType.DELETE, viewTable.getKTuple(), this.expression1);
        Translation translation = Translation.inverseViewUpdate(deleteViewUpdate);
        Assert.assertNotNull(translation);
        Assert.assertEquals(2, translation.size());

        Update r3Update = translation.getUpdate(0);
        Update r1Update = translation.getUpdate(1);
        Assert.assertEquals(UpdateType.DELETE, r1Update.getUpdateType());
        Assert.assertEquals(UpdateType.DELETE, r3Update.getUpdateType());
        Assert.assertEquals("R1", r1Update.getTable().tableName);
        Assert.assertEquals("R3", r3Update.getTable().tableName);
        Assert.assertEquals(1, r1Update.getKTuple().size());
        Assert.assertEquals(1, r3Update.getKTuple().size());

        Tuple r1KTuple = r1Update.getKTuple().iterator().next();
        Tuple r3KTuple = r3Update.getKTuple().iterator().next();
        TupleBaseNode[] r1Tuple = r1KTuple.getTuple().toArray(new TupleBaseNode[0]);
        TupleBaseNode[] r3Tuple = r3KTuple.getTuple().toArray(new TupleBaseNode[0]);

        Assert.assertEquals(2, r1Tuple.length);
        Assert.assertEquals(2, r3Tuple.length);
        for(TupleBaseNode node : r1Tuple)
            Assert.assertTrue(node instanceof ColumnNode);
        for(TupleBaseNode node : r3Tuple)
            Assert.assertTrue(node instanceof ColumnNode);

        Map<String, String> r1Map = ImmutableMap.<String, String>builder().
                put("R1.A","R123.A").
                put("R1.B","R1.B").
                build();
        for(TupleBaseNode node : r1Tuple)
            Assert.assertEquals(r1Map.get(node.getColumnSchema().toString()), ((ColumnNode) node).getColumn().toString());
        Map<String, String> r3Map = ImmutableMap.<String, String>builder().
                put("R3.A","R123.A").
                put("R3.C","R123.C").
                build();
        for(TupleBaseNode node : r3Tuple)
            Assert.assertEquals(r3Map.get(node.getColumnSchema().toString()), ((ColumnNode) node).getColumn().toString());
    }
    @Test
    public void testInsert2() {
        Graph.Table viewTable = this.graph.getTable("C");
        Assert.assertNotNull(viewTable);
        Assert.assertEquals(3, viewTable.allSchema().size());

        ViewUpdate insertViewUpdate = new ViewUpdate(UpdateType.INSERT, viewTable.getKTuple(), this.expression2);
        Translation translation = Translation.inverseViewUpdate(insertViewUpdate);
        Assert.assertNotNull(translation);
        Assert.assertEquals(1, translation.size());

        Update a1Update = translation.getUpdate(0);
        Assert.assertEquals(UpdateType.INSERT, a1Update.getUpdateType());
        Assert.assertEquals("A1", a1Update.getTable().tableName);
        Assert.assertEquals(1, a1Update.getKTuple().size());

        Tuple a1KTuple = a1Update.getKTuple().iterator().next();
        TupleBaseNode[] a1Tuple = a1KTuple.getTuple().toArray(new TupleBaseNode[0]);

        Assert.assertEquals(7, a1Tuple.length);
        for(TupleBaseNode node : a1Tuple)
            Assert.assertTrue(node instanceof ColumnNode);

        Map<String, String> a1Map = ImmutableMap.<String, String>builder().
                put("A1.A11","C.GH").
                put("A1.A12","C.XM").
                put("A1.A13","C.GJ").
                put("A1.A14","A1.A14").
                put("A1.A15","A1.A15").
                put("A1.A16","A1.A16").
                put("A1.B11","A1.B11").
                build();
        for(TupleBaseNode node : a1Tuple)
            Assert.assertEquals(a1Map.get(node.getColumnSchema().toString()), ((ColumnNode) node).getColumn().toString());
    }
    @Test
    public void testDelete2() {
        Graph.Table viewTable = this.graph.getTable("C");
        Assert.assertNotNull(viewTable);
        Assert.assertEquals(3, viewTable.allSchema().size());

        ViewUpdate insertViewUpdate = new ViewUpdate(UpdateType.DELETE, viewTable.getKTuple(), this.expression2);
        Translation translation = Translation.inverseViewUpdate(insertViewUpdate);
        Assert.assertNotNull(translation);
        Assert.assertEquals(2, translation.size());

        Update a1Update = translation.getUpdate(1);
        Update a2Update = translation.getUpdate(0);
        Assert.assertEquals(UpdateType.DELETE, a1Update.getUpdateType());
        Assert.assertEquals("A1", a1Update.getTable().tableName);
        Assert.assertEquals(1, a1Update.getKTuple().size());
        Assert.assertEquals("A2", a2Update.getTable().tableName);
        Assert.assertEquals(1, a2Update.getKTuple().size());

        Tuple a1KTuple = a1Update.getKTuple().iterator().next();
        TupleBaseNode[] a1Tuple = a1KTuple.getTuple().toArray(new TupleBaseNode[0]);
        Tuple a2KTuple = a2Update.getKTuple().iterator().next();
        TupleBaseNode[] a2Tuple = a2KTuple.getTuple().toArray(new TupleBaseNode[0]);

        Assert.assertEquals(7, a1Tuple.length);
        for(TupleBaseNode node : a1Tuple)
            Assert.assertTrue(node instanceof ColumnNode);
        Assert.assertEquals(7, a2Tuple.length);
        for(TupleBaseNode node : a2Tuple)
            Assert.assertTrue(node instanceof ColumnNode);

        Map<String, String> a1Map = ImmutableMap.<String, String>builder().
                put("A1.A11","C.GH").
                put("A1.A12","C.XM").
                put("A1.A13","C.GJ").
                put("A1.A14","A1.A14").
                put("A1.A15","A1.A15").
                put("A1.A16","A1.A16").
                put("A1.B11","A1.B11").
                build();
        for(TupleBaseNode node : a1Tuple)
            Assert.assertEquals(a1Map.get(node.getColumnSchema().toString()), ((ColumnNode) node).getColumn().toString());
        Map<String, String> a2Map = ImmutableMap.<String, String>builder().
                put("A2.A21","C.GH").
                put("A2.A22","C.XM").
                put("A2.A23","C.GJ").
                put("A2.A24","A2.A24").
                put("A2.A25","A2.A25").
                put("A2.A26","A2.A26").
                put("A2.B21","A2.B21").
                build();
        for(TupleBaseNode node : a2Tuple)
            Assert.assertEquals(a2Map.get(node.getColumnSchema().toString()), ((ColumnNode) node).getColumn().toString());
    }
}
