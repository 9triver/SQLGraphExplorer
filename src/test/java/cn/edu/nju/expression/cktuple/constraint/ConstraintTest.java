package cn.edu.nju.expression.cktuple.constraint;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ConstraintTest {
    @Test
    public void testOrSplit1() {
        Constraint c = new Constraint("firstname='Thomas' OR lastname='Carter'");
        List<Constraint> results = c.orSplit();
        String[] anwsers={"firstname='Thomas'","lastname='Carter'"};
        Assert.assertEquals(anwsers.length, results.size());
        for(int i = 0; i < results.size(); ++i)
            Assert.assertEquals(anwsers[i], results.get(i).toString());
    }
    @Test
    public void testOrSplit2() {
        Constraint c = new Constraint("((firstname='Thomas') AND (YEAR(hire_date)=1997)) OR (lastname='Carter') OR YEAR(hire_date)=1998");
        List<Constraint> results = c.orSplit();
        String[] anwsers={"(firstname='Thomas' AND YEAR(hire_date)=1997)","lastname='Carter'", "YEAR(hire_date)=1998"};
        Assert.assertEquals(anwsers.length, results.size());
        for(int i = 0; i < results.size(); ++i)
            Assert.assertEquals(anwsers[i], results.get(i).toString());
    }
    @Test
    public void testOrSplit3() {
        Constraint c = new Constraint("((firstname='Thomas') OR (YEAR(hire_date)=1997)) OR lastname='Carter' AND YEAR(hire_date)=1998");
        List<Constraint> results = c.simplify().orSplit();
        String[] anwsers={"(firstname='Thomas' AND YEAR((hire_date))=1998)", "(YEAR((hire_date))=1997 AND YEAR((hire_date))=1998)","(lastname='Carter' AND YEAR((hire_date))=1998)"};
        Assert.assertEquals(anwsers.length, results.size());
        for(int i = 0; i < results.size(); ++i)
            Assert.assertEquals(anwsers[i], results.get(i).toString());
    }

}
