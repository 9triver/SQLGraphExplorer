package cn.edu.nju.core;

import cn.edu.nju.core.graph.GraphJSONTest;
import cn.edu.nju.core.grammar.PlSqlLexer;
import cn.edu.nju.core.grammar.PlSqlParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

public class YGB_JSON_Test {
    @Test
    public void test_EAST51_YGB() throws IOException, URISyntaxException {
        test("EAST51_YGB");
    }
    @Test
    public void test_EAST51_YGB_GL() throws IOException, URISyntaxException {
        test("EAST51_YGB_GL");
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
    @Test
    public void test_CREATE() throws IOException, URISyntaxException {
        test("CREATE");
    }
    @Test
    public void test_SelectStar() throws IOException, URISyntaxException {
        test("select_star");
    }

    @Test
    public void test_groupBy() throws IOException, URISyntaxException {
        test("groupby06");
    }

    @Test
    public void test_With() throws IOException, URISyntaxException {
        test("with");
    }


    private void test(String name) throws IOException, URISyntaxException {
        String filePath = YGB_JSON_Test.class.getClassLoader().
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

        GraphJSONTest.writeIntoFile(visitor.toJSON(), name+"_Test");
    }
}
