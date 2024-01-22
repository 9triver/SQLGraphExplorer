package cn.edu.nju.gui.util.database;

import cn.edu.nju.core.graph.Graph;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

public class DataBase {
    public static Logger logger = Logger.getLogger(DataBase.class);
    private String jdbcURL = null;
    private Connection connection = null;
    private Statement statement = null;
    private String name;
    private Graph graph;
    public DataBase(String name, Graph graph) {
        this.name = name;
        this.graph = graph;
        this.jdbcURL = "jdbc:h2:mem:"+name;
        try {
            this.connection = DriverManager.getConnection(jdbcURL);
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("Connected to H2 in-memory database.");
    }
    public boolean execute(String sql) {
        boolean result = false;
        try {
            result = statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public int executeUpdate(String sql) {
        int result = -1;
        try {
            result = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public boolean close() throws SQLException {
        boolean result = false;
        try {
            connection.close();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Graph getGraph() {
        return graph;
    }
    public ResultSet getData(String tableName) {
        ResultSet resultSet = null;
        try {
            resultSet = this.statement.executeQuery("SELECT * FROM "+tableName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
