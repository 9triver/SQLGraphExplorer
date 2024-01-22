package cn.edu.nju.core.tools.condition;

import cn.edu.nju.core.tools.Tools;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SpliterTest {
    private static Logger logger = Logger.getLogger(SpliterTest.class);
    @Test
    public void testBracked() {
        List<String> expected = Arrays.asList("A", "(NOT B)", "(C AND D)", "(E OR F)");
        test(expected,"A OR (NOT B) OR (C AND D) OR (E OR F)");

        expected = Arrays.asList("(A AND B)", "C");
        test(expected,"(((A) AND (B)) OR (C))");

        expected = Arrays.asList("(NOT A)", "B", "(NOT C)");
        test(expected,"((NOT (A)) OR (B) OR (NOT (C)))");
    }
    @Test
    public void test1() {
        List<String> expected = Arrays.asList("A", "B", "C", "D");
        test(expected,"((((A) OR (B)) OR (C)) OR (D))");
    }

    @Test
    public void test2() {
        List<String> expected = Arrays.asList("A1.A11=gh AND A1.A12=xm AND A1.A13=gj AND LENGTH(NVL(A1.A11,''))>0 AND A1.A14<='#{ETL_DT}' AND A1.A15>'#{ETL_DT}'");
        test(expected, "((((((A1.A11=gh) AND (A1.A12=xm)) AND (A1.A13=gj)) AND (LENGTH(NVL(A1.A11,''))>0)) AND (A1.A14<='#{ETL_DT}')) AND (A1.A15>'#{ETL_DT}'))");
    }

    private void test(List<String> expected, String context) {
        List<String> result = Tools.split(context);
        logger.info(result);
        Assert.assertEquals(expected.size(),result.size());
        for(int i = 0; i < expected.size(); ++i)
            Assert.assertEquals(expected.get(i),result.get(i));
    }
}
