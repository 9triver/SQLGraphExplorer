package cn.edu.nju.graph;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;

public class GraphDotTest {
    String srcTableA = "HRS_HRS_USRA01";
    String srcTableB = "HRS_HRS_B01";
    String dstTable = "EAST51_YGB";
    Graph graph = null;
    @Before
    public void initGraph() throws IOException, URISyntaxException {
        graph = new Graph(dstTable);


        Assert.assertTrue(graph.addColumn(dstTable,"JRXKZH"));
        Assert.assertTrue(graph.addEdge(new Node(NodeType.COLUMN, srcTableB+":B010A"), new Node(NodeType.COLUMN,dstTable+":NBJGH")));
        Assert.assertTrue(graph.addColumn(dstTable,"YHJGMC"));
        Assert.assertTrue(graph.addEdge(new Node(NodeType.COLUMN, srcTableA+":A0144"), new Node(NodeType.COLUMN,dstTable+":GH")));
        Assert.assertTrue(graph.addEdge(new Node(NodeType.COLUMN, srcTableA+":A0101"), new Node(NodeType.COLUMN,dstTable+":XM")));
        Assert.assertTrue(graph.addEdge(new Node(NodeType.COLUMN, srcTableA+":A01CA"), new Node(NodeType.COLUMN,dstTable+":GJ")));
        Assert.assertTrue(graph.addEdge(new Node(NodeType.COLUMN, srcTableA+":A0130"), new Node(NodeType.COLUMN,dstTable+":ZJLB")));
        Assert.assertTrue(graph.addEdge(new Node(NodeType.COLUMN, srcTableA+":A0177"), new Node(NodeType.COLUMN,dstTable+":ZJHM")));
        Assert.assertTrue(graph.addEdge(new Node(NodeType.COLUMN, srcTableA+":A0148"), new Node(NodeType.COLUMN,dstTable+":LXDH")));
        Assert.assertTrue(graph.addEdge(new Node(NodeType.COLUMN, srcTableA+":A01CV"), new Node(NodeType.COLUMN,dstTable+":SSBM")));
        Assert.assertTrue(graph.addEdge(new Node(NodeType.COLUMN, srcTableA+":A01BK"), new Node(NodeType.COLUMN,dstTable+":GWBH")));
        Assert.assertTrue(graph.addEdge(new Node(NodeType.COLUMN, srcTableA+":A01AD"), new Node(NodeType.COLUMN,dstTable+":GWMC")));
        Assert.assertTrue(graph.addColumn(dstTable,"SFGG"));
        Assert.assertTrue(graph.addColumn(dstTable,"PFRQ"));
        Assert.assertTrue(graph.addColumn(dstTable,"RZRQ"));
        Assert.assertTrue(graph.addEdge(new Node(NodeType.COLUMN, srcTableA+":A01AH"), new Node(NodeType.COLUMN,dstTable+":YHLX")));
        Assert.assertTrue(graph.addEdge(new Node(NodeType.COLUMN, srcTableA+":A0182"), new Node(NodeType.COLUMN,dstTable+":YGZT")));
        Assert.assertTrue(graph.addColumn(dstTable,"BBZ"));
        Assert.assertTrue(graph.addColumn(dstTable,"CJRQ"));

        Assert.assertFalse(graph.addColumn(dstTable,"JRXKZH"));
        Assert.assertFalse(graph.addEdge(new Node(NodeType.COLUMN, srcTableB+":B010A"), new Node(NodeType.COLUMN,dstTable+":NBJGH")));

        writeIntoFile(graph.toDOT(), "init");
    }
    @Test
    public void testChangeTableName() throws IOException, URISyntaxException {
        Assert.assertFalse(graph.changeTableName(srcTableA,srcTableA));
        Assert.assertFalse(graph.changeTableName(srcTableB,srcTableB));
        Assert.assertFalse(graph.changeTableName(dstTable,dstTable));

        Assert.assertTrue(graph.changeTableName(srcTableA, "A"));
        Assert.assertTrue(graph.changeTableName(srcTableB, "B"));
        Assert.assertTrue(graph.changeTableName(dstTable, "C"));

        writeIntoFile(graph.toDOT(), "changeTableName");
    }

    @Test
    public void testChangeColumnName() throws IOException, URISyntaxException {
        Assert.assertFalse(graph.changeColumnName("E","YHLX", "newLine"));
        Assert.assertFalse(graph.changeColumnName("A","notExist", "newLine"));
        Assert.assertFalse(graph.changeColumnName("A","A0144", "A0144"));


        Assert.assertTrue(graph.changeTableName(srcTableA, "A"));
        Assert.assertTrue(graph.changeTableName(srcTableB, "B"));
        Assert.assertTrue(graph.changeTableName(dstTable, "C"));

        Assert.assertTrue(graph.changeColumnName("A","A0144", "A1"));
        Assert.assertTrue(graph.changeColumnName("A","A0101", "A2"));
        Assert.assertTrue(graph.changeColumnName("A","A01CA", "A3"));
        Assert.assertTrue(graph.changeColumnName("A","A0130", "A4"));
        Assert.assertTrue(graph.changeColumnName("A","A0177", "A5"));
        Assert.assertTrue(graph.changeColumnName("A","A0148", "A6"));
        Assert.assertTrue(graph.changeColumnName("A","A01CV", "A7"));
        Assert.assertTrue(graph.changeColumnName("A","A01BK", "A8"));
        Assert.assertTrue(graph.changeColumnName("A","A01AD", "A9"));
        Assert.assertTrue(graph.changeColumnName("A","A01AH", "A10"));
        Assert.assertTrue(graph.changeColumnName("A","A0182", "A11"));

        Assert.assertTrue(graph.changeColumnName("B","B010A", "B1"));

        Assert.assertTrue(graph.changeColumnName("C","GH", "AC1"));
        Assert.assertTrue(graph.changeColumnName("C","XM", "AC2"));
        Assert.assertTrue(graph.changeColumnName("C","GJ", "AC3"));
        Assert.assertTrue(graph.changeColumnName("C","ZJLB", "AC4"));
        Assert.assertTrue(graph.changeColumnName("C","ZJHM", "AC5"));
        Assert.assertTrue(graph.changeColumnName("C","LXDH", "AC6"));
        Assert.assertTrue(graph.changeColumnName("C","SSBM", "AC7"));
        Assert.assertTrue(graph.changeColumnName("C","GWBH", "AC8"));
        Assert.assertTrue(graph.changeColumnName("C","GWMC", "AC9"));
        Assert.assertTrue(graph.changeColumnName("C","YHLX", "AC10"));
        Assert.assertTrue(graph.changeColumnName("C","YGZT", "AC11"));
        Assert.assertTrue(graph.changeColumnName("C","NBJGH", "BC1"));

        writeIntoFile(graph.toDOT(), "changeColumnName");
    }

    @Test
    public void testDeleteTable1() throws IOException, URISyntaxException {
        Assert.assertFalse(graph.deleteTable("A"));
        Assert.assertTrue(graph.deleteTable(srcTableA));
        Assert.assertFalse(graph.deleteTable(srcTableA));

        writeIntoFile(graph.toDOT(), "deleteTable1");
    }

    @Test
    public void testDeleteTable2() throws IOException, URISyntaxException {
        Assert.assertFalse(graph.deleteTable("C"));
        Assert.assertTrue(graph.deleteTable(dstTable));
        Assert.assertFalse(graph.deleteTable(dstTable));

        writeIntoFile(graph.toDOT(), "deleteTable2");
    }

    @Test
    public void testMergeTable1() throws IOException, URISyntaxException {
        Assert.assertFalse(graph.mergeTable(srcTableA,srcTableA));
        Assert.assertFalse(graph.mergeTable(srcTableA,"A"));

        Assert.assertTrue(graph.mergeTable(srcTableA,srcTableB));

        writeIntoFile(graph.toDOT(), "mergeTable1");
    }

    @Test
    public void testMergeTable2() throws IOException, URISyntaxException {
        Assert.assertTrue(graph.mergeTable(srcTableA,dstTable));

        writeIntoFile(graph.toDOT(), "mergeTable2");
    }

    @Test
    public void testJoinAndWhere() throws IOException, URISyntaxException {
        String joinContext = "LEFT JOIN\n(A.NBJGH=B.NBJGH)";
        String whereContext = "A.CJRQ=I_DATE\nAND\nB.CJRQ=I_DATE;";
        Node joinNode = graph.addJoin(joinContext);
        Assert.assertTrue(graph.addEdge(new Node(NodeType.TABLE, srcTableA), joinNode));
        Assert.assertTrue(graph.addEdge(new Node(NodeType.TABLE, srcTableB), joinNode));
        Node whereNode = graph.addWhere(whereContext);
        Assert.assertTrue(graph.addEdge(joinNode, whereNode));
        Assert.assertTrue(graph.addEdge(whereNode, new Node(NodeType.TABLE, dstTable)));

        writeIntoFile(graph.toDOT(), "join");
    }

    @Test
    public void testFunction() throws IOException, URISyntaxException {
        String columnName = "ZJLB";
        Node f = graph.addFunction("f");
        Node g = graph.addFunction("g");
        graph.addColumn(srcTableB,columnName);
        graph.addColumn(dstTable,columnName);
        Assert.assertTrue(graph.addEdge(new Node(NodeType.COLUMN, srcTableB+":"+columnName),f));
        Assert.assertTrue(graph.addEdge(g,new Node(NodeType.COLUMN, dstTable+":"+columnName)));
        Assert.assertTrue(graph.addEdge(f, g));

        writeIntoFile(graph.toDOT(), "function");
    }

    @After
    public void destroyGraph() {
        graph = null;
    }


    public static void writeIntoFile(String context, String fileName) throws IOException, URISyntaxException {
        String rootPath = GraphDotTest.class.getResource("/").toURI().getPath();
        String dirPath = "../../src/test/resources/dot/";
        String fullFilePath = rootPath + dirPath + fileName + ".gv";
        File file = new File(fullFilePath);

        if (!file.exists() && !file.createNewFile())
            return ;

        FileWriter writer = new FileWriter(file);

        writer.write(context);
        writer.flush();
        writer.close();
    }
}
