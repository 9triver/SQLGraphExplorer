package cn.edu.nju.gui.util.database;

import cn.edu.nju.core.graph.Graph;
import cn.edu.nju.gui.model.data.Data;
import cn.edu.nju.gui.model.data.Data1;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        String[] sqls = sql.split(";");
        boolean result = true;
        try {
            for(String stat : sqls)
                result ^= statement.execute(stat);
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
    public ResultSet executeQuery(String sql) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
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

    public void renderData(TableView table,String tableName) {
        // TODO: 渲染数据
        ObservableList<Data> data = FXCollections.observableArrayList();
        ResultSet resultSet = null;
        List<String> columns = graph.getAllColumns(tableName);
        try {
            resultSet = this.getData(tableName);
            while(resultSet.next()) {
                data.add();
                table.setItems(data);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    //增加数据
    public void sqladd(TableView table, String name,
                       String phone, String address) throws ClassNotFoundException {
        jdbcload();
        String sql = "insert into kh_table (kh_name, kh_phone, kh_address) values(?,?,?)";
        try {
            cont = DriverManager.getConnection(url, user, pwd);
            pst = cont.prepareStatement("insert into kh_table (kh_name, kh_phone, kh_address) values(?,?,?)");
            pst.setString(1, name);
            pst.setString(2, phone);
            pst.setString(3, address);
            pst.execute();
        }catch(Exception e) {
            e.printStackTrace();
        }
        date(table);
    }


    public Graph getGraph() {
        return graph;
    }
    public ResultSet getData(String tableName) {
        if(!graph.existTable(tableName))
            return null;
        ResultSet resultSet = null;
        try {
            resultSet = this.statement.executeQuery("SELECT * FROM "+tableName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
