package cn.edu.nju.core.tools.ra;

import cn.edu.nju.core.tools.ra.adt.Database;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class RelationalAlgebraInterpreterTest {

    @Test
    public void test() {
        String ra = "PROJECT [Course, Section] (Course * (PROJECT [InstructorID] (SELECT [name = \"Bailes\"] ((Instructor)))));";
        String sql = "SELECT Course, Section FROM Course NATURAL JOIN ((SELECT InstructorID FROM Instructor WHERE (name = 'Bailes'))) AS q1;";

        RelationalAlgebraInterpreter interpreter = new RelationalAlgebraInterpreter(new Database("defaultDatabase"));
        Assert.assertEquals(sql, interpreter.translate(ra));
    }
}
