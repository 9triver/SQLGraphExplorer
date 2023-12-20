package cn.edu.nju;

import grammar.PlSqlLexer;
import grammar.PlSqlParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        String[] testFiles = {"EAST51_YGB", "PE5_YGB", "PEAST5_YGB"};
        for(String fileName : testFiles) {
            List<String> resultSqls = Main.test(fileName);
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println(fileName + ":");
            for(String resultSql : resultSqls)
                System.out.println(resultSql);

            Main.writeIntoFile(resultSqls, fileName);
        }
    }

    public static List<String> test(String dstTableName) throws IOException, URISyntaxException {
        String filePath = Main.class.getClassLoader().
                getResource("data/modify/" + dstTableName + ".sql").toURI().getPath();
        File file = new File(filePath);
        BufferedReader inputBuffer = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));

        ANTLRInputStream input = new ANTLRInputStream(inputBuffer);
        PlSqlLexer lexer = new PlSqlLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PlSqlParser parser = new PlSqlParser(tokens);
        PlSqlParser.Sql_scriptContext rootContext = parser.sql_script();
        PlSqlVisitor visitor = new PlSqlVisitor(dstTableName);

        visitor.visitSql_script(rootContext);
        return visitor.getInverseSqls();
    }
    public static void writeIntoFile(List<String> context, String fileName) throws IOException, URISyntaxException {
        String rootPath = Main.class.getResource("/").toURI().getPath();
        String dirPath = "../../src/main/resources/data/output/";
        String fullFilePath = rootPath + dirPath + fileName + ".sql";
        File file = new File(fullFilePath);

        if (!file.exists() && !file.createNewFile())
            return ;

        FileWriter writer = new FileWriter(file);

        writer.write(String.join("", context));
        writer.flush();
        writer.close();
    }
}