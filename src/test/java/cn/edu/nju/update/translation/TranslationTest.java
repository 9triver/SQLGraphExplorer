package cn.edu.nju.update.translation;

import cn.edu.nju.expression.Expression;
import cn.edu.nju.expression.cktuple.Tuple;
import cn.edu.nju.expression.cktuple.constraint.Constraint;
import cn.edu.nju.expression.cktuple.tuple.ColumnNode;
import cn.edu.nju.expression.cktuple.tuple.TupleBaseNode;
import cn.edu.nju.graph.Graph;
import cn.edu.nju.update.UpdateType;
import cn.edu.nju.update.viewUpdate.ViewUpdate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TranslationTest {
    private Graph graph;
    Expression expression0, expression1;

    @Before
    public void initial() {
        this.graph = new Graph();
        // insert view update
        Graph.Table emp = graph.createTable("emp");
        Graph.Table dept = graph.createTable("dept");
        Graph.Table insertView = graph.createTable("emp_dept");
        this.graph.addColumns("emp","Ename", "Pname");
        this.graph.addColumns("dept","Ename", "Dname");
        this.graph.addColumns("emp_dept","Ename", "Dname");

        Expression e = Expression.production(Expression.table(emp),Expression.table(dept));
        e = Expression.selection(new Constraint("PNAME=P"),e);
        this.expression0 = Expression.projection(insertView.allSchema(), e);

        // delete view update
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
        Assert.assertTrue(empTuple[0] instanceof ColumnNode);
        Assert.assertTrue(empTuple[1] instanceof ColumnNode);
        Assert.assertTrue(deptTuple[0] instanceof ColumnNode);
        Assert.assertTrue(deptTuple[1] instanceof ColumnNode);

        Assert.assertEquals("EMP.PNAME", empTuple[0].getColumnSchema().toString());
        Assert.assertEquals("EMP.PNAME", ((ColumnNode) empTuple[0]).getColumn().toString());
        Assert.assertEquals("EMP.ENAME", empTuple[1].getColumnSchema().toString());
        Assert.assertEquals("EMP_DEPT.ENAME", ((ColumnNode) empTuple[1]).getColumn().toString());

        Assert.assertEquals("DEPT.ENAME", deptTuple[0].getColumnSchema().toString());
        Assert.assertEquals("EMP_DEPT.ENAME", ((ColumnNode) deptTuple[0]).getColumn().toString());
        Assert.assertEquals("DEPT.DNAME", deptTuple[1].getColumnSchema().toString());
        Assert.assertEquals("EMP_DEPT.DNAME", ((ColumnNode) deptTuple[1]).getColumn().toString());
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
        Assert.assertTrue(empTuple[0] instanceof ColumnNode);
        Assert.assertTrue(empTuple[1] instanceof ColumnNode);

        Assert.assertEquals("EMP.PNAME", empTuple[0].getColumnSchema().toString());
        Assert.assertEquals("EMP.PNAME", ((ColumnNode) empTuple[0]).getColumn().toString());
        Assert.assertEquals("EMP.ENAME", empTuple[1].getColumnSchema().toString());
        Assert.assertEquals("EMP_DEPT.ENAME", ((ColumnNode) empTuple[1]).getColumn().toString());
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
        Assert.assertTrue(r1Tuple[0] instanceof ColumnNode);
        Assert.assertTrue(r1Tuple[1] instanceof ColumnNode);
        Assert.assertTrue(r2Tuple[0] instanceof ColumnNode);
        Assert.assertTrue(r2Tuple[1] instanceof ColumnNode);

        Assert.assertEquals("R1.A", r1Tuple[0].getColumnSchema().toString());
        Assert.assertEquals("R123.A", ((ColumnNode) r1Tuple[0]).getColumn().toString());
        Assert.assertEquals("R1.B", r1Tuple[1].getColumnSchema().toString());
        Assert.assertEquals("R1.B", ((ColumnNode) r1Tuple[1]).getColumn().toString());

        Assert.assertEquals("R2.B", r2Tuple[0].getColumnSchema().toString());
        Assert.assertEquals("R2.B", ((ColumnNode) r2Tuple[0]).getColumn().toString());
        Assert.assertEquals("R2.C", r2Tuple[1].getColumnSchema().toString());
        Assert.assertEquals("R123.C", ((ColumnNode) r2Tuple[1]).getColumn().toString());
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
        Assert.assertTrue(r1Tuple[0] instanceof ColumnNode);
        Assert.assertTrue(r1Tuple[1] instanceof ColumnNode);
        Assert.assertTrue(r3Tuple[0] instanceof ColumnNode);
        Assert.assertTrue(r3Tuple[1] instanceof ColumnNode);

        Assert.assertEquals("R1.A", r1Tuple[0].getColumnSchema().toString());
        Assert.assertEquals("R123.A", ((ColumnNode) r1Tuple[0]).getColumn().toString());
        Assert.assertEquals("R1.B", r1Tuple[1].getColumnSchema().toString());
        Assert.assertEquals("R1.B", ((ColumnNode) r1Tuple[1]).getColumn().toString());

        Assert.assertEquals("R3.A", r3Tuple[0].getColumnSchema().toString());
        Assert.assertEquals("R123.A", ((ColumnNode) r3Tuple[0]).getColumn().toString());
        Assert.assertEquals("R3.C", r3Tuple[1].getColumnSchema().toString());
        Assert.assertEquals("R123.C", ((ColumnNode) r3Tuple[1]).getColumn().toString());
    }
}
