package cn.edu.nju.expression.cktuple.constraint;

import cn.edu.nju.PlSqlVisitor;
import cn.edu.nju.expression.Expression;
import cn.edu.nju.graph.GraphDotTest;
import grammar.*;
import grammar.ConditionLexer;
import grammar.ConditionParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class ConditionVisitorTest {
    private static Logger logger = Logger.getLogger(ConditionVisitorTest.class);

    @Test
    public void test0() throws IOException {
        String src = "";
        String dst = "((((((((A AND ((B))))))))))";
        while (!src.equals(dst)) {
            src = dst;
            dst = simplify(src);
        }

        Assert.assertEquals(dst,"(A AND (B))");
    }

    private String simplify(String context) {
        ConditionLexer lexer = new ConditionLexer(CharStreams.fromString(context));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ConditionParser parser = new ConditionParser(tokens);
        ConditionParser.ParseContext rootContext =  parser.parse();
        ConditionVisitor visitor = new ConditionVisitor();

        String result = visitor.visitParse(rootContext);
        logger.info(result);
        return result;
    }
}
