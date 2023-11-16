package cn.edu.nju;

import cn.edu.nju.graph.GraphTest;
import grammar.PlSqlLexer;
import grammar.PlSqlParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

public class YGB_Test {
    @Test
    public void test_EAST51_YGB() throws IOException, URISyntaxException {
        test("EAST51_YGB");
    }
    @Test
    public void test_EAST51_YGB_GL() throws IOException, URISyntaxException {
        test("EAST51_YGB");
    }
    @Test
    public void test_PE5_YGB() throws IOException, URISyntaxException {
        test("PE5_YGB");
    }
    @Test
    public void test_PEAST5_YGB() throws IOException, URISyntaxException {
        test("PEAST5_YGB");
    }
    @Test
    public void test_PROC_GET_BL_YGB() throws IOException, URISyntaxException {
        test("PROC_GET_BL_YGB");
    }

    private void test(String name) throws IOException, URISyntaxException {
        String filePath = YGB_Test.class.getClassLoader().
                getResource("data/" + name + ".sql").toURI().getPath();
        File file = new File(filePath);
        BufferedReader inputBuffer = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));

        ANTLRInputStream input = new ANTLRInputStream(inputBuffer);
        PlSqlLexer lexer = new PlSqlLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PlSqlParser parser = new PlSqlParser(tokens);
        PlSqlParser.Sql_scriptContext rootContext = parser.sql_script();
        PlSqlVisitor visitor = new PlSqlVisitor(name);

        visitor.visitSql_script(rootContext);

        GraphTest.writeIntoFile(visitor.toDot(), name+"_Test");
    }
}
