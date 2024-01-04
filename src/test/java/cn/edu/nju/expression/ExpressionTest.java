package cn.edu.nju.expression;

import cn.edu.nju.PlSqlVisitor;
import cn.edu.nju.expression.cktuple.CKTuple;
import cn.edu.nju.expression.cktuple.CKTuples;
import cn.edu.nju.expression.cktuple.KTuple;
import cn.edu.nju.expression.cktuple.constraint.Constraint;
import cn.edu.nju.expression.cktuple.tuple.ColumnNode;
import cn.edu.nju.expression.cktuple.tuple.TupleBaseNode;
import cn.edu.nju.graph.Graph;
import grammar.PlSqlLexer;
import grammar.PlSqlParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExpressionTest {
    public static Logger logger = Logger.getLogger(ExpressionTest.class);
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
        graph.addColumns("A1", "A11", "A12", "A13", "A14", "A15", "A16", "B11");
        Graph.Table a2 = graph.createTable("A2");
        graph.addColumns("A2", "A21", "A22", "A23", "A24", "A25", "A26", "B21");
        Graph.Table b = graph.createTable("B");
        graph.addColumns("B", "B01", "B02", "B03", "B04");
        Graph.Table c = graph.createTable("C");
        graph.addColumns("C", "GH", "XM", "GJ");

        // expression1
        Expression er1 = Expression.table(r1);
        Expression er2 = Expression.table(r2);
        Expression e = Expression.production(er1, er2);
        e = Expression.selection(new Constraint("B=b"), e);
        e = Expression.projection(r3.allSchema(), e);
        this.expression1 = e;
        // expression2
        Expression ea1 = Expression.table(a1);
        Expression ea2 = Expression.table(a2);
        Expression eb = Expression.table(b);

        Expression e1 = Expression.production(ea1, eb);
        e1 = Expression.selection(new Constraint("A1.B11 = B.B01 AND B.B02 <= '#{ETL_DT}' AND B.B03 > '#{ETL_DT}'"),
                e1);
        e1 = Expression.selection(
                new Constraint("LENGTH(NVL(A1.A11,'')) > 0 AND A1.A14 <= '#{ETL_DT}' AND A1.A15 > '#{ETL_DT}'"), e1);
        e1 = Expression.projection(a1.schema("A11", "A12", "A13"), e1);
        RenameMap renameMap1 = new RenameMap();
        renameMap1.add(a1.getColumn("A11"), c.getColumn("GH"));
        renameMap1.add(a1.getColumn("A12"), c.getColumn("XM"));
        renameMap1.add(a1.getColumn("A13"), c.getColumn("GJ"));
        e1 = Expression.rename(renameMap1, e1);

        Expression e2 = Expression.production(ea2, eb);
        e2 = Expression.selection(new Constraint("A2.B21 = B.B01 AND B.B02 <= '#{ETL_DT}' AND B.B03 > '#{ETL_DT}'"),
                e2);
        e2 = Expression.selection(new Constraint(
                "LENGTH(NVL(A2.A21,'')) > 0 AND A2.A24 <= '#{ETL_DT}' AND A2.A25 > '#{ETL_DT}' AND A2.A26 <> '0101'"),
                e2);
        e2 = Expression.projection(a2.schema("A21", "A22", "A23"), e2);
        RenameMap renameMap2 = new RenameMap();
        renameMap2.add(a2.getColumn("A21"), c.getColumn("GH"));
        renameMap2.add(a2.getColumn("A22"), c.getColumn("XM"));
        renameMap2.add(a2.getColumn("A23"), c.getColumn("GJ"));
        e2 = Expression.rename(renameMap2, e2);

        this.expression2 = Expression.union(e1, e2);
    }

    @Test
    public void testSchema1() {
        Schema answer = graph.getTable("R3").allSchema();
        Schema result = this.expression1.schema();
        Assert.assertEquals(result, answer);

        answer = graph.getTable("R1").allSchema();
        answer.add(graph.getTable("R2").allSchema());
        result = this.expression1.getExpression1().schema();
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

        // Check CKTuples
        Assert.assertEquals(1, results.getCkTuples().size());
        CKTuple ckTuple1 = results.getCkTuples().get(0);
        KTuple kTuple1 = ckTuple1.getkTuples().get(0);
        KTuple kTuple2 = ckTuple1.getkTuples().get(1);
        KTuple exceptedKTuple1 = new KTuple(r1).addTupleNode(new ColumnNode(r1a, r3a), new ColumnNode(r1b, r1b));
        KTuple exceptedKTuple2 = new KTuple(r2).addTupleNode(new ColumnNode(r2b, r2b), new ColumnNode(r2c, r3c));
        Constraint mainConstraint = ckTuple1.getMainConstraint();

        Assert.assertEquals("B=b", mainConstraint.toString());
        Assert.assertEquals("R1", kTuple1.getTable().tableName);
        Assert.assertEquals("R2", kTuple2.getTable().tableName);
        Assert.assertEquals(r1.allSchema(), kTuple1.allSchema());
        Assert.assertEquals(r2.allSchema(), kTuple2.allSchema());
        Assert.assertEquals(exceptedKTuple1, kTuple1);
        Assert.assertEquals(exceptedKTuple2, kTuple2);

        // check Sqls
        List<String> resultSqls = results.toSql();
        Assert.assertEquals(2, resultSqls.size());
        Assert.assertEquals(
                "CREATE OR REPLACE PROCEDURE INVERSE_R1(\n" +
                "PARA_A IN VARCHAR2(255)\n" +
                ") IS\n" +
                "BEGIN\n" +
                "SELECT R1.A, R1.B FROM R1 WHERE (R1.A = PARA_A) AND (B = b);\n" +
                "END INVERSE_R1;", resultSqls.get(0));
        Assert.assertEquals("CREATE OR REPLACE PROCEDURE INVERSE_R2(\n" +
                "PARA_C IN VARCHAR2(255)\n" +
                ") IS\n" +
                "BEGIN\n" +
                "SELECT R2.C, R2.B FROM R2 WHERE (R2.C = PARA_C) AND (B = b);\n" +
                "END INVERSE_R2;", resultSqls.get(1));
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
        CKTuples results = this.expression2.inverse(target).simplifyConstraints();

        // check CKTuples
        Assert.assertEquals(results.getCkTuples().size(), 4);
        for (CKTuple ckTuple : results.getCkTuples()) {
            for(KTuple kTuple : ckTuple.getkTuples()) {
                Constraint constraint = ckTuple.getMainConstraint();
                String tableName = kTuple.getTable().tableName;

                switch (tableName) {
                    case "A1" -> {
                        Assert.assertEquals(a1.allSchema(), kTuple.allSchema());
                        Assert.assertEquals(
                                "(((LENGTH((NVL((A1.A11),(''))))>0) AND (A1.A14<='#{ETL_DT}')) AND (A1.A15>'#{ETL_DT}'))",
                                constraint.toString());
                        KTuple exceptedKTuple = new KTuple(a1).addTupleNode(
                                new ColumnNode(a11, gh),
                                new ColumnNode(a12, xm),
                                new ColumnNode(a13, gj),
                                new ColumnNode(a14, a14),
                                new ColumnNode(a15, a15),
                                new ColumnNode(a16, a16),
                                new ColumnNode(b11, b11));
                        Assert.assertEquals(exceptedKTuple.getTable(), kTuple.getTable());
                        Assert.assertEquals(exceptedKTuple.getTuple().size(), kTuple.getTuple().size());
                        for (TupleBaseNode t : kTuple.getTuple())
                            if (!exceptedKTuple.getTuple().contains(t))
                                Assert.fail();
                    }
                    case "A2" -> {
                        Assert.assertEquals(a2.allSchema(), kTuple.allSchema());
                        Assert.assertEquals(
                                "((((LENGTH((NVL((A2.A21),(''))))>0) AND (A2.A24<='#{ETL_DT}')) AND (A2.A25>'#{ETL_DT}')) AND (A2.A26<>'0101'))",
                                constraint.toString());
                        KTuple exceptedKTuple = new KTuple(a2).addTupleNode(
                                new ColumnNode(a21, gh),
                                new ColumnNode(a22, xm),
                                new ColumnNode(a23, gj),
                                new ColumnNode(a24, a24),
                                new ColumnNode(a25, a25),
                                new ColumnNode(a26, a26),
                                new ColumnNode(b21, b21));
                        Assert.assertEquals(exceptedKTuple.getTable(), kTuple.getTable());
                        Assert.assertEquals(exceptedKTuple.getTuple().size(), kTuple.getTuple().size());
                        for (TupleBaseNode t : kTuple.getTuple())
                            if (!exceptedKTuple.getTuple().contains(t))
                                Assert.fail();
                    }
                    case "B" -> {
                        Assert.assertEquals(b.allSchema(), kTuple.allSchema());
                        Assert.assertEquals("((B.B02<='#{ETL_DT}') AND (B.B03>'#{ETL_DT}'))", constraint.toString());
                        KTuple exceptedKTuple = new KTuple(b).addTupleNode(
                                new ColumnNode(b01, b01),
                                new ColumnNode(b02, b02),
                                new ColumnNode(b03, b03),
                                new ColumnNode(b04, b04));
                        Assert.assertEquals(exceptedKTuple.getTable(), kTuple.getTable());
                        Assert.assertEquals(exceptedKTuple.getTuple().size(), kTuple.getTuple().size());
                        for (TupleBaseNode t : kTuple.getTuple())
                            if (!exceptedKTuple.getTuple().contains(t))
                                Assert.fail();
                    }
                    default -> Assert.fail();
                }
            }
        }

        // check Sqls
        List<String> resultSqls = results.toSql();
        Assert.assertEquals(2, resultSqls.size());
        Assert.assertEquals(
                "SELECT A1.A11, A1.A13, A1.B11, A1.A15, A1.A14, A1.A16, A1.A12 FROM A1 WHERE (A1.A11 = C.GH) AND (A1.A13 = C.GJ) AND (A1.A12 = C.XM) AND (LENGTH(NVL(A1.A11,'')) > 0) AND (A1.A14 <= '#{ETL_DT}') AND (A1.A15 > '#{ETL_DT}');",
                resultSqls.get(0));
        Assert.assertEquals(
                "SELECT A2.A22, A2.A21, A2.A23, A2.B21, A2.A25, A2.A24, A2.A26 FROM A2 WHERE (A2.A22 = C.XM) AND (A2.A21 = C.GH) AND (A2.A23 = C.GJ) AND (LENGTH(NVL(A2.A21,'')) > 0) AND (A2.A24 <= '#{ETL_DT}') AND (A2.A25 > '#{ETL_DT}') AND (A2.A26 <> '0101');",
                resultSqls.get(1));
    }

    @Test
    public void testExpression0() {
        String createR1Sql = "create table R1 (\n" +
                "  A VARCHAR2(255),\n" +
                "  B VARCHAR2(255)\n" +
                ") tablespace USERS pctfree 10 initrans 1 maxtrans 255 storage (\n" +
                "  initial 64K next 1M minextents 1 maxextents unlimited\n" +
                ");\n";
        String createR2Sql = "create table R2 (\n" +
                "  B VARCHAR2(255),\n" +
                "  C VARCHAR2(255)\n" +
                ") tablespace USERS pctfree 10 initrans 1 maxtrans 255 storage (\n" +
                "  initial 64K next 1M minextents 1 maxextents unlimited\n" +
                ");\n";
        String createR3Sql = "create table R3 (\n" +
                "  A VARCHAR2(255),\n" +
                "  C VARCHAR2(255)\n" +
                ") tablespace USERS pctfree 10 initrans 1 maxtrans 255 storage (\n" +
                "  initial 64K next 1M minextents 1 maxextents unlimited\n" +
                ");\n";
        String selectSql = "SELECT A,C FROM R1 JOIN R2 WHERE B=b;";
        PlSqlVisitor visitor = testExpression(createR1Sql + createR2Sql + createR3Sql + selectSql, "R3");
    }

    @Test
    public void testExpression1() {
        String createA1Sql = "create table A1 (\n" +
                "  A11 VARCHAR2(255),\n" +
                "  A12 VARCHAR2(255),\n" +
                "  A13 VARCHAR2(255),\n" +
                "  A14 VARCHAR2(255),\n" +
                "  A15 VARCHAR2(255),\n" +
                "  A16 VARCHAR2(255),\n" +
                "  B11 VARCHAR2(255)\n" +
                ") tablespace USERS pctfree 10 initrans 1 maxtrans 255 storage (\n" +
                "  initial 64K next 1M minextents 1 maxextents unlimited\n" +
                ");\n";
        String createA2Sql = "create table A2 (\n" +
                "  A21 VARCHAR2(255),\n" +
                "  A22 VARCHAR2(255),\n" +
                "  A23 VARCHAR2(255),\n" +
                "  A24 VARCHAR2(255),\n" +
                "  A25 VARCHAR2(255),\n" +
                "  A26 VARCHAR2(255),\n" +
                "  B21 VARCHAR2(255)\n" +
                ") tablespace USERS pctfree 10 initrans 1 maxtrans 255 storage (\n" +
                "  initial 64K next 1M minextents 1 maxextents unlimited\n" +
                ");\n";
        String createBSql = "create table B (\n" +
                "  B01 VARCHAR2(255),\n" +
                "  B02 VARCHAR2(255),\n" +
                "  B03 VARCHAR2(255),\n" +
                "  B04 VARCHAR2(255)\n" +
                ") tablespace USERS pctfree 10 initrans 1 maxtrans 255 storage (\n" +
                "  initial 64K next 1M minextents 1 maxextents unlimited\n" +
                ");\n";
        String createCSql = "create table C (\n" +
                "  GH VARCHAR2(255),\n" +
                "  XM VARCHAR2(255),\n" +
                "  GJ VARCHAR2(255)\n" +
                ") tablespace USERS pctfree 10 initrans 1 maxtrans 255 storage (\n" +
                "  initial 64K next 1M minextents 1 maxextents unlimited\n" +
                ");\n";
        String selectUnionSql = "SELECT\n" +
                "  A1.A11 AS GH, /*工号*/\n" +
                "  A1.A12 AS XM, /*姓名*/\n" +
                "  A1.A13 AS GJ  /*国籍*/\n" +
                "FROM\n" +
                "  A1 /*在职人员基本信息*/\n" +
                "  JOIN B /*机构基本情况*/\n" +
                "  ON A1.B11 = B.B01\n" +
                "  AND B.B02 <= '#{ETL_DT}'\n" +
                "  AND B.B03 > '#{ETL_DT}'\n" +
                "WHERE\n" +
                "  LENGTH (NVL (A1.A11, '')) > 0 /*员工编号有值的数据*/\n" +
                "  AND A1.A14 <= '#{ETL_DT}'\n" +
                "  AND A1.A15 > '#{ETL_DT}'\n" +
                "\n" +
                "UNION ALL --从减员人员基本信息表中获取除了状态为'非正常在岗'的人员信息\n" +
                "\n" +
                "SELECT\n" +
                "  A2.A21 AS GH, /*工号*/\n" +
                "  A2.A22 AS XM, /*姓名*/\n" +
                "  A2.A23 AS GJ  /*国籍*/\n" +
                "FROM\n" +
                "  A2\n" +
                "  JOIN B /*机构基本情况*/\n" +
                "  ON A2.B21 = B.B01\n" +
                "  AND B.B02 <= '#{ETL_DT}'\n" +
                "  AND B.B03 > '#{ETL_DT}'\n" +
                "WHERE\n" +
                "  LENGTH (NVL (A2.A21, '')) > 0 /*员工编号有值的数据*/\n" +
                "  AND A2.A24 <= '#{ETL_DT}'\n" +
                "  AND A2.A25 > '#{ETL_DT}'\n" +
                "  AND A2.A26 <> '0101';";
        PlSqlVisitor visitor = testExpression(createA1Sql + createA2Sql + createBSql + createCSql + selectUnionSql,
                "C");
    }

    private PlSqlVisitor testExpression(String sql, String dstTableName) {
        PlSqlLexer lexer = new PlSqlLexer(CharStreams.fromString(sql));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PlSqlParser parser = new PlSqlParser(tokens);
        PlSqlParser.Sql_scriptContext rootContext = parser.sql_script();
        PlSqlVisitor visitor;
        if (dstTableName == null)
            visitor = new PlSqlVisitor();
        else
            visitor = new PlSqlVisitor(dstTableName);
        visitor.visitSql_script(rootContext);
        return visitor;
    }

    @Test
    public void test_EAST51_YGB() {
        try {
            ExpressionTest.testExpression("EAST51_YGB");
        } catch (IOException e) {
            logger.error("IOException: " + e.getMessage());
        } catch (URISyntaxException e) {
            logger.error("URISyntaxException: " + e.getMessage());
        }
    }

    @Test
    public void test_PE5_YGB() {
        try {
            ExpressionTest.testExpression("PE5_YGB");
        } catch (IOException e) {
            logger.error("IOException: " + e.getMessage());
        } catch (URISyntaxException e) {
            logger.error("URISyntaxException: " + e.getMessage());
        }
    }

    @Test
    public void test_PEAST5_YGB() {
        try {
            ExpressionTest.testExpression("PEAST5_YGB");
        } catch (IOException e) {
            logger.error("IOException: " + e.getMessage());
        } catch (URISyntaxException e) {
            logger.error("URISyntaxException: " + e.getMessage());
        }
    }

    public static void testExpression(String fileName) throws IOException, URISyntaxException {
        String filePath = ExpressionTest.class.getClassLoader().getResource("data/modify/" + fileName + ".sql").toURI()
                .getPath();
        File file = new File(filePath);
        BufferedReader inputBuffer = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));

        ANTLRInputStream input = new ANTLRInputStream(inputBuffer);
        PlSqlLexer lexer = new PlSqlLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PlSqlParser parser = new PlSqlParser(tokens);
        PlSqlParser.Sql_scriptContext rootContext = parser.sql_script();
        PlSqlVisitor visitor = new PlSqlVisitor(fileName);

        visitor.visitSql_script(rootContext);
        List<String> resultSqls = visitor.getInverseSqls();

        System.out
                .println("------------------------------------------------------------------------------------------");
        System.out.println(fileName + ":");
        for (String resultSql : resultSqls)
            System.out.println(resultSql);

        ExpressionTest.writeIntoFile(resultSqls, fileName);
    }

    public static void writeIntoFile(List<String> context, String fileName) throws IOException, URISyntaxException {
        String rootPath = ExpressionTest.class.getResource("/").toURI().getPath();
        String dirPath = "../../src/main/resources/data/output/";
        String fullFilePath = rootPath + dirPath + fileName + ".sql";
        File file = new File(fullFilePath);

        if (!file.exists() && !file.createNewFile())
            return;

        FileWriter writer = new FileWriter(file);

        writer.write(String.join("", context));
        writer.flush();
        writer.close();
    }
}
