package cn.edu.nju.expression.cktuple.constraint;

import cn.edu.nju.expression.cktuple.constraint.grammar.ConditionLexer;
import cn.edu.nju.expression.cktuple.constraint.grammar.ConditionParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class ConditionVisitorTest {
    private static Logger logger = Logger.getLogger(ConditionVisitorTest.class);

    @Test
    public void testBrackets() throws IOException {
        Assert.assertEquals("((A) AND (B))", test("(((((((A) AND ((B))))))))"));
        Assert.assertEquals("(((A) AND (B)) OR (C))", test("A AND B OR C"));
    }

    @Test
    public void testDeMorganLaw() throws IOException {
        Assert.assertEquals("((NOT (A)) OR (B) OR (NOT (C)))",test("NOT(((((A)) AND ((NOT (B))) AND (C))))"));
    }
    @Test
    public void testAnnulmentLaw() throws IOException {
        Assert.assertEquals("(TRUE)", test("NOT(A AND FALSE)"));
        Assert.assertEquals("(FALSE)", test("NOT(A AND FALSE OR TRUE)"));
    }

    @Test
    public void testIdentityLaw() throws IOException {
        Assert.assertEquals("(A)", test("A OR NOT TRUE"));
        Assert.assertEquals("(A)", test("FALSE OR A"));
        Assert.assertEquals("(A)", test("A AND NOT NOT TRUE"));
        Assert.assertEquals("(A)", test("TRUE AND A"));
    }

    @Test
    public void testDistributiveLaw() throws IOException {
        Assert.assertEquals("(((A) AND (C)) OR ((B) AND (C)))",test("(A OR B) AND C"));
    }

    private String test(String testCase) throws IOException {
        String oldStr = "";
        String newStr = testCase;
        while (!newStr.equals(oldStr)) {
            oldStr = newStr;
            newStr = simplify(oldStr);
        }

        return newStr;
    }

    private String simplify(String context) throws IOException{
        ConditionLexer lexer = new ConditionLexer(CharStreams.fromStream(new ByteArrayInputStream(context.getBytes())));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ConditionParser parser = new ConditionParser(tokens);
        ConditionParser.ParseContext rootContext =  parser.parse();
        ConditionVisitor visitor = new ConditionVisitor();

        String result = visitor.visitParse(rootContext);
        logger.info(result);
        return result;
    }
}
