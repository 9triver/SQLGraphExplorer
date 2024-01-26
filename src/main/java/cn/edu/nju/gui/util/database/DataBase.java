package cn.edu.nju.gui.util.database;

import cn.edu.nju.core.graph.Graph;
import cn.edu.nju.gui.model.CustomVBox;
import cn.edu.nju.gui.model.data.*;
import com.google.common.base.Joiner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.*;

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

    public int executeSql(String sqlStatements) {
        String[] sqls = sqlStatements.split(";");
        int count = 0;
        for(String sqlStatement : sqls) {
            if(this.executeUpdate(sqlStatement) > 0)
                count++;
            else if (this.executeQuery(sqlStatement) != null)
                count++;
            else if(this.execute(sqlStatement))
                count++;
        }
        return count;
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
    public ResultSet executeQuery(String sql) {
        ResultSet result = null;
        try {
            result = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public boolean close() {
        boolean result = false;
        try {
            connection.close();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int insertData(CustomVBox customVBox) {
        List<TextField> insertTextFields = customVBox.getInsertTextFields();
        List<String> columnNames = new ArrayList<>(), data = new ArrayList<>();
        for(TextField textField : insertTextFields) {
            columnNames.add(textField.getPromptText());
            data.add(textField.getText());
            textField.clear();
        }
        int count = this.insertData(customVBox.getTableName(), columnNames, data);
        this.refreshData(customVBox);
        return count;
    }

    public boolean refreshData(CustomVBox customVBox) {
        TableView tableView = customVBox.getTableView();
        String tableName = customVBox.getTableName();
        tableView.getItems().clear();
        int columnSize = graph.getTable(tableName).columnSize();
        return switch (columnSize) {
            case 1 -> loadData1((TableView<Data1>) tableView, tableName);
            case 2 -> loadData2((TableView<Data2>) tableView, tableName);
            case 3 -> loadData3((TableView<Data3>) tableView, tableName);
            case 4 -> loadData4((TableView<Data4>) tableView, tableName);
            case 5 -> loadData5((TableView<Data5>) tableView, tableName);
            case 6 -> loadData6((TableView<Data6>) tableView, tableName);
            case 7 -> loadData7((TableView<Data7>) tableView, tableName);
            default -> false;
        };
    }
    public Graph getGraph() {
        return graph;
    }

    public String getName() {
        return name;
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
    private int insertData(String tableName, List<String> columnNames, List<String> data) {
        /*INSERT INTO A1
                (A11, A12, A13, A14, A15, A16, B11) VALUES
                ('a11', 'a12', 'a13', 'a14', 'a15', 'a16', 'b11')*/
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO ").append(tableName);
        sql.append("(").append(Joiner.on(", ").join(columnNames)).append(") VALUES ");
        sql.append("('").append(Joiner.on("', '").join(data)).append("')");
        return this.executeUpdate(sql.toString());
    }
    private boolean loadData1(TableView<Data1> tableView,String tableName) {
        int columnSize = graph.getAllColumns(tableName).size();
        if(columnSize != 1) return false;
        ResultSet resultSet = this.getData(tableName);
        ObservableList<Data1> dataList = FXCollections.observableArrayList();
        try {
            while(resultSet.next()) {
                List<String> tuple = new ArrayList<>();
                for(int i = 1; i <= columnSize; ++i)
                    tuple.add(resultSet.getString(i));
                dataList.add(new Data1(tuple));
                tableView.setItems(dataList);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return true;
    }
    private boolean loadData2(TableView<Data2> tableView,String tableName) {
        int columnSize = graph.getAllColumns(tableName).size();
        if(columnSize != 2) return false;
        ResultSet resultSet = this.getData(tableName);
        ObservableList<Data2> dataList = FXCollections.observableArrayList();
        try {
            while(resultSet.next()) {
                List<String> tuple = new ArrayList<>();
                for(int i = 1; i <= columnSize; ++i)
                    tuple.add(resultSet.getString(i));
                dataList.add(new Data2(tuple));
                tableView.setItems(dataList);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return true;
    }
    private boolean loadData3(TableView<Data3> tableView,String tableName) {
        int columnSize = graph.getAllColumns(tableName).size();
        if(columnSize != 3) return false;
        ResultSet resultSet = this.getData(tableName);
        ObservableList<Data3> dataList = FXCollections.observableArrayList();
        try {
            while(resultSet.next()) {
                List<String> tuple = new ArrayList<>();
                for(int i = 1; i <= columnSize; ++i)
                    tuple.add(resultSet.getString(i));
                dataList.add(new Data3(tuple));
                tableView.setItems(dataList);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return true;
    }
    private boolean loadData4(TableView<Data4> tableView,String tableName) {
        int columnSize = graph.getAllColumns(tableName).size();
        if(columnSize != 4) return false;
        ResultSet resultSet = this.getData(tableName);
        ObservableList<Data4> dataList = FXCollections.observableArrayList();
        try {
            while(resultSet.next()) {
                List<String> tuple = new ArrayList<>();
                for(int i = 1; i <= columnSize; ++i)
                    tuple.add(resultSet.getString(i));
                dataList.add(new Data4(tuple));
                tableView.setItems(dataList);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return true;
    }
    private boolean loadData5(TableView<Data5> tableView,String tableName) {
        int columnSize = graph.getAllColumns(tableName).size();
        if(columnSize != 5) return false;
        ResultSet resultSet = this.getData(tableName);
        ObservableList<Data5> dataList = FXCollections.observableArrayList();
        try {
            while(resultSet.next()) {
                List<String> tuple = new ArrayList<>();
                for(int i = 1; i <= columnSize; ++i)
                    tuple.add(resultSet.getString(i));
                dataList.add(new Data5(tuple));
                tableView.setItems(dataList);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return true;
    }
    private boolean loadData6(TableView<Data6> tableView,String tableName) {
        int columnSize = graph.getAllColumns(tableName).size();
        if(columnSize != 6) return false;
        ResultSet resultSet = this.getData(tableName);
        ObservableList<Data6> dataList = FXCollections.observableArrayList();
        try {
            while(resultSet.next()) {
                List<String> tuple = new ArrayList<>();
                for(int i = 1; i <= columnSize; ++i)
                    tuple.add(resultSet.getString(i));
                dataList.add(new Data6(tuple));
                tableView.setItems(dataList);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return true;
    }
    private boolean loadData7(TableView<Data7> tableView,String tableName) {
        int columnSize = graph.getAllColumns(tableName).size();
        if(columnSize != 7) return false;
        ResultSet resultSet = this.getData(tableName);
        ObservableList<Data7> dataList = FXCollections.observableArrayList();
        try {
            while(resultSet.next()) {
                List<String> tuple = new ArrayList<>();
                for(int i = 1; i <= columnSize; ++i)
                    tuple.add(resultSet.getString(i));
                dataList.add(new Data7(tuple));
                tableView.setItems(dataList);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return true;
    }
}
