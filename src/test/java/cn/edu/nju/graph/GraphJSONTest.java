package cn.edu.nju.graph;

import cn.edu.nju.graph.json.GraphJSON;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;

public class GraphJSONTest {
    String srcTableA = "Table1";
    String srcTableB = "Table2";
    String dstTable = "Table3";
    Graph graph = null;
    @Before
    public void initGraph() throws IOException, URISyntaxException {
        graph = new Graph(dstTable);

        Assert.assertTrue(graph.addColumn(dstTable,"Column1"));
        Assert.assertTrue(graph.addColumn(dstTable,"Column2"));
        Assert.assertTrue(graph.addEdge(new Node(NodeType.COLUMN, srcTableA+":Column1"), new Node(NodeType.COLUMN,dstTable+":Column1")));
        Assert.assertTrue(graph.addEdge(new Node(NodeType.COLUMN, srcTableA+":Column2"), new Node(NodeType.COLUMN,dstTable+":Column2")));
        Assert.assertTrue(graph.addEdge(new Node(NodeType.COLUMN, srcTableB+":Column1"), new Node(NodeType.COLUMN,dstTable+":Column3")));
        Assert.assertTrue(graph.addEdge(new Node(NodeType.COLUMN, srcTableB+":Column2"), new Node(NodeType.COLUMN,dstTable+":Column4")));

        writeIntoFile(graph.toJSON(), "init");
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

        writeIntoFile(graph.toJSON(), "join");
    }

    @Test
    public void testFunction() throws IOException, URISyntaxException {
        String columnName = "functionColumn";
        Node f = graph.addFunction("f");
        Node g = graph.addFunction("g");
        graph.addColumn(srcTableB,columnName);
        graph.addColumn(dstTable,columnName);
        Assert.assertTrue(graph.addEdge(new Node(NodeType.COLUMN, srcTableB+":"+columnName),f));
        Assert.assertTrue(graph.addEdge(g,new Node(NodeType.COLUMN, dstTable+":"+columnName)));
        Assert.assertTrue(graph.addEdge(f, g));

        writeIntoFile(graph.toJSON(), "function");
    }

    @After
    public void destroyGraph() {
        graph = null;
    }

    public static void writeIntoFile(String context, String fileName) throws IOException, URISyntaxException {
        String rootPath = GraphJSONTest.class.getResource("/").toURI().getPath();
        String dirPath = "../../src/test/resources/json/";
        String fullFilePath = rootPath + dirPath + fileName + ".json";
        File file = new File(fullFilePath);

        if (!file.exists() && !file.createNewFile())
            return ;

        FileWriter writer = new FileWriter(file);

        writer.write(context);
        writer.flush();
        writer.close();
    }
}
