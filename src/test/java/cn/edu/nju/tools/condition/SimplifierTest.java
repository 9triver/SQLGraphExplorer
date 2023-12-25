package cn.edu.nju.tools.condition;

import cn.edu.nju.graph.Graph;
import cn.edu.nju.tools.Tools;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class SimplifierTest {
    private static final Logger logger = Logger.getLogger(SimplifierTest.class);

    @Test
    public void testBrackets() {
        Assert.assertEquals("((A) AND (B))", test("(((((((A) AND ((B))))))))"));
        Assert.assertEquals("(((A) AND (B)) OR (C))", test("A AND B OR C"));
    }

    @Test
    public void testDeMorganLaw() {
        Assert.assertEquals("((NOT (A)) OR (B) OR (NOT (C)))",test("NOT(((((A)) AND ((NOT (B))) AND (C))))"));
    }
    @Test
    public void testAnnulmentLaw() {
        Assert.assertEquals("(TRUE)", test("NOT(A AND FALSE)"));
        Assert.assertEquals("(FALSE)", test("NOT(A AND FALSE OR TRUE)"));
    }

    @Test
    public void testIdentityLaw() {
        Assert.assertEquals("(A)", test("A OR NOT TRUE"));
        Assert.assertEquals("(A)", test("FALSE OR A"));
        Assert.assertEquals("(A)", test("A AND NOT NOT TRUE"));
        Assert.assertEquals("(A)", test("TRUE AND A"));
    }

    @Test
    public void testDistributiveLaw() {
        Assert.assertEquals("(((A) AND (C)) OR ((B) AND (C)))",test("(A OR B) AND C"));
        Assert.assertEquals("((((A) AND (D)) OR ((B) AND (D))) OR ((C) AND (D)))",test("(A OR B) OR C AND D"));
    }

    @Test
    public void testColumn() {
        // table
        Graph graph = new Graph();
        Graph.Table a1 = graph.createTable("A1");
        graph.addColumns("A1","A11","A12","A13","A14","A15","A16","B11");
        Graph.Table b = graph.createTable("B");
        graph.addColumns("B","B01","B02","B03","B04");

        Assert.assertEquals(
            "((((((A1.A11=gh) AND (A1.A12=xm)) AND (A1.A13=gj)) AND (LENGTH((NVL((A1.A11),(''))))>0)) AND (A1.A14<='#{ETL_DT}')) AND (A1.A15>'#{ETL_DT}'))",
            test(
                "A1.A11 = gh AND " +
                "A1.A12 = xm AND " +
                "A1.A13 = gj AND " +
                "LENGTH(NVL(A1.A11,'')) > 0 AND " +
                "A1.A14 <= '#{ETL_DT}' AND " +
                "A1.A15 > '#{ETL_DT}' AND " +
                "A1.B11 = B.B01 AND " +
                "B.B02 <= '#{ETL_DT}' AND " +
                "B.B03 > '#{ETL_DT}'",
                graph.getTable("A1")));

        Assert.assertEquals(
                "((B.B02<='#{ETL_DT}') AND (B.B03>'#{ETL_DT}'))",
                test("((LENGTH(NVL(A1.A11,''))>0) AND ((B.B02<='#{ETL_DT}') AND (B.B03>'#{ETL_DT}')))",
                        graph.getTable("B")));
    }

    @Test
    public void testRedundant() {
        // table
        Graph graph = new Graph();
        Graph.Table table = graph.createTable("LEDGERREPORT");
        graph.addColumns("LEDGERREPORT","ID","TERM");

        Assert.assertEquals(
                "((LEDGERREPORT.ID=PARA_ID) AND (LEDGERREPORT.TERM=PARA_TERM) AND (LEDGERREPORT.TERM=V_DATE))",
                test("(LEDGERREPORT.ID = PARA_ID)\n" +
                "  AND (LEDGERREPORT.TERM = PARA_TERM)\n" +
                "  AND (LEDGERREPORT.TERM = V_DATE)\n" +
                "  AND (LEDGERREPORT.TERM = V_DATE)", table)
        );
    }

    private String test(String context) {
        String ret = Tools.simplify(context);
        logger.info(ret);
        return ret;
    }
    private String test(String context, Graph.Table targetTable) {
        String ret = Tools.simplify(context, targetTable);
        logger.info(ret);
        return ret;
    }
}
