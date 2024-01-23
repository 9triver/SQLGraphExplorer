package cn.edu.nju.gui.util.database;

import cn.edu.nju.core.PlSqlVisitor;
import cn.edu.nju.core.tools.Tools;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseTest {
    public static Logger logger = Logger.getLogger(DataBaseTest.class);

    private String sql0 = "create table A1 (\n" +
            "  A11 VARCHAR2(255),\n" +
            "  A12 VARCHAR2(255),\n" +
            "  A13 VARCHAR2(255),\n" +
            "  A14 VARCHAR2(255),\n" +
            "  A15 VARCHAR2(255),\n" +
            "  A16 VARCHAR2(255),\n" +
            "  B11 VARCHAR2(255)\n" +
            ");\n" +
            "create table A2 (\n" +
            "  A21 VARCHAR2(255),\n" +
            "  A22 VARCHAR2(255),\n" +
            "  A23 VARCHAR2(255),\n" +
            "  A24 VARCHAR2(255),\n" +
            "  A25 VARCHAR2(255),\n" +
            "  A26 VARCHAR2(255),\n" +
            "  B21 VARCHAR2(255)\n" +
            ");\n" +
            "create table B (\n" +
            "  B01 VARCHAR2(255),\n" +
            "  B02 VARCHAR2(255),\n" +
            "  B03 VARCHAR2(255),\n" +
            "  B04 VARCHAR2(255)\n" +
            ");\n" +
            "create table C (\n" +
            "  GH VARCHAR2(255),\n" +
            "  XM VARCHAR2(255),\n" +
            "  GJ VARCHAR2(255)\n" +
            ");\n" +
            "SELECT\n" +
            "  A1.A11 AS GH, /*工号*/\n" +
            "  A1.A12 AS XM, /*姓名*/\n" +
            "  A1.A13 AS GJ  /*国籍*/\n" +
            "FROM\n" +
            "  A1 /*在职人员基本信息*/\n" +
            "  JOIN B /*机构基本情况*/\n" +
            "  ON A1.B11 = B.B01\n" +
            "  AND B.B02 <= '#{ETL_DT}'\n" +
            "  AND B.B03 > '#{ETL_DT}'\n" +
            "WHERE\n" +
            "  LENGTH (NVL (A1.A11, '')) > 0 /*员工编号有值的数据*/\n" +
            "  AND A1.A14 <= '#{ETL_DT}'\n" +
            "  AND A1.A15 > '#{ETL_DT}'\n" +
            "\n" +
            "UNION ALL --从减员人员基本信息表中获取除了状态为'非正常在岗'的人员信息\n" +
            "\n" +
            "SELECT\n" +
            "  A2.A21 AS GH, /*工号*/\n" +
            "  A2.A22 AS XM, /*姓名*/\n" +
            "  A2.A23 AS GJ  /*国籍*/\n" +
            "FROM\n" +
            "  A2\n" +
            "  JOIN B /*机构基本情况*/\n" +
            "  ON A2.B21 = B.B01\n" +
            "  AND B.B02 <= '#{ETL_DT}'\n" +
            "  AND B.B03 > '#{ETL_DT}'\n" +
            "WHERE\n" +
            "  LENGTH (NVL (A2.A21, '')) > 0 /*员工编号有值的数据*/\n" +
            "  AND A2.A24 <= '#{ETL_DT}'\n" +
            "  AND A2.A25 > '#{ETL_DT}'\n" +
            "  AND A2.A26 <> '0101';\n";
    @Test
    public void test0() throws SQLException {
        PlSqlVisitor visitor = Tools.parseSql(sql0,"C");
        DataBase dataBase = new DataBase("test", visitor.getGraph());
        Assert.assertNotNull(dataBase);
        Assert.assertFalse(dataBase.execute(sql0));
        Assert.assertEquals(1,
                dataBase.executeUpdate("INSERT INTO A1 " +
                        "(A11, A12, A13, A14, A15, A16, B11) VALUES " +
                        "('a11', 'a12', 'a13', 'a14', 'a15', 'a16', 'b11') "));
        ResultSet resultSet = dataBase.getData("A1");
        Assert.assertNotNull(resultSet);
        Assert.assertTrue(resultSet.next());
        Assert.assertEquals("a11",resultSet.getString("A11"));
        Assert.assertEquals("a12",resultSet.getString("A12"));
        Assert.assertEquals("a13",resultSet.getString("A13"));
        Assert.assertEquals("a14",resultSet.getString("A14"));
        Assert.assertEquals("a15",resultSet.getString("A15"));
        Assert.assertEquals("a16",resultSet.getString("A16"));
        Assert.assertEquals("b11",resultSet.getString("B11"));
    }
}
