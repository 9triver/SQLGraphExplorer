package cn.edu.nju.gui.util.database;

import cn.edu.nju.core.graph.Graph;
import cn.edu.nju.gui.model.data.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
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

    /*public void refreshAll(String tableName) {
        tableView.getItems().clear();
        loadData(tableView);
    }*/

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
    private void loadData1(TableView<Data1> table,String tableName) {
        int columnSize = graph.getAllColumns(tableName).size();
        if(columnSize != 1) return;
        ResultSet resultSet = this.getData(tableName);
        List<String> tuple = new ArrayList<>();
        ObservableList<Data1> dataList = FXCollections.observableArrayList();
        try {
            while(resultSet.next()) {
                for(int i = 0; i < columnSize; ++i)
                    tuple.add(resultSet.getString(i));
                dataList.add(new Data1(tuple));
                table.setItems(dataList);
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }
    private void loadData2(TableView<Data2> table,String tableName) {
        int columnSize = graph.getAllColumns(tableName).size();
        if(columnSize != 2) return;
        ResultSet resultSet = this.getData(tableName);
        List<String> tuple = new ArrayList<>();
        ObservableList<Data2> dataList = FXCollections.observableArrayList();
        try {
            while(resultSet.next()) {
                for(int i = 0; i < columnSize; ++i)
                    tuple.add(resultSet.getString(i));
                dataList.add(new Data2(tuple));
                table.setItems(dataList);
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }
    private void loadData3(TableView<Data3> table,String tableName) {
        int columnSize = graph.getAllColumns(tableName).size();
        if(columnSize != 1) return;
        ResultSet resultSet = this.getData(tableName);
        List<String> tuple = new ArrayList<>();
        ObservableList<Data3> dataList = FXCollections.observableArrayList();
        try {
            while(resultSet.next()) {
                for(int i = 0; i < columnSize; ++i)
                    tuple.add(resultSet.getString(i));
                dataList.add(new Data3(tuple));
                table.setItems(dataList);
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }
    private void loadData4(TableView<Data4> table,String tableName) {
        int columnSize = graph.getAllColumns(tableName).size();
        if(columnSize != 1) return;
        ResultSet resultSet = this.getData(tableName);
        List<String> tuple = new ArrayList<>();
        ObservableList<Data4> dataList = FXCollections.observableArrayList();
        try {
            while(resultSet.next()) {
                for(int i = 0; i < columnSize; ++i)
                    tuple.add(resultSet.getString(i));
                dataList.add(new Data4(tuple));
                table.setItems(dataList);
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }
    private void loadData5(TableView<Data5> table,String tableName) {
        int columnSize = graph.getAllColumns(tableName).size();
        if(columnSize != 1) return;
        ResultSet resultSet = this.getData(tableName);
        List<String> tuple = new ArrayList<>();
        ObservableList<Data5> dataList = FXCollections.observableArrayList();
        try {
            while(resultSet.next()) {
                for(int i = 0; i < columnSize; ++i)
                    tuple.add(resultSet.getString(i));
                dataList.add(new Data5(tuple));
                table.setItems(dataList);
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }
    private void loadData6(TableView<Data6> table,String tableName) {
        int columnSize = graph.getAllColumns(tableName).size();
        if(columnSize != 1) return;
        ResultSet resultSet = this.getData(tableName);
        List<String> tuple = new ArrayList<>();
        ObservableList<Data6> dataList = FXCollections.observableArrayList();
        try {
            while(resultSet.next()) {
                for(int i = 0; i < columnSize; ++i)
                    tuple.add(resultSet.getString(i));
                dataList.add(new Data6(tuple));
                table.setItems(dataList);
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }
    private void loadData7(TableView<Data7> table,String tableName) {
        int columnSize = graph.getAllColumns(tableName).size();
        if(columnSize != 1) return;
        ResultSet resultSet = this.getData(tableName);
        List<String> tuple = new ArrayList<>();
        ObservableList<Data7> dataList = FXCollections.observableArrayList();
        try {
            while(resultSet.next()) {
                for(int i = 0; i < columnSize; ++i)
                    tuple.add(resultSet.getString(i));
                dataList.add(new Data7(tuple));
                table.setItems(dataList);
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
