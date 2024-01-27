package cn.edu.nju.gui.util.database;

import cn.edu.nju.core.graph.Graph;
import cn.edu.nju.gui.model.CustomVBox;
import cn.edu.nju.gui.model.data.*;
import com.google.common.base.Joiner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.*;

public class DataBase {
    public static Logger logger = Logger.getLogger(DataBase.class);
    private String jdbcURL;
    private Connection connection = null;
    private Statement statement = null;
    private final String name;
    private final Graph graph;
    public DataBase(String name, Graph graph) {
        this.name = name;
        this.graph = graph;
        jdbcURL = "jdbc:h2:mem:" + name;
        try {
            this.connection = DriverManager.getConnection(jdbcURL);
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("Connected to H2 in-memory database.");
    }

    public Pair<Integer, ResultSet> executeSql(String sqlStatements) {
        String[] sqls = sqlStatements.split(";");
        int count = 0;
        ResultSet resultSet = null;
        for(String sqlStatement : sqls) {
            if(this.executeUpdate(sqlStatement) > 0)
                count++;
            else{
                resultSet = this.executeQuery(sqlStatement);
                if (resultSet != null)
                    count++;
                else if(this.execute(sqlStatement))
                    count++;
            }
        }
        return Pair.of(count, resultSet);
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
//            e.printStackTrace();
        }
        return result;
    }
    public ResultSet executeQuery(String sql) {
        ResultSet result = null;
        try {
            result = statement.executeQuery(sql);
        } catch (SQLException e) {
//            e.printStackTrace();
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
        TableView<Data> tableView = customVBox.getTableView();
        String tableName = customVBox.getTableName();
        tableView.getItems().clear();
        return loadData(tableView, tableName);
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
        String sql = "INSERT INTO " + tableName +
                "(" + Joiner.on(", ").join(columnNames) + ") VALUES " +
                "('" + Joiner.on("', '").join(data) + "')";
        return this.executeUpdate(sql);
    }
    private boolean loadData(TableView<Data> tableView, String tableName) {
        int columnSize = graph.getAllColumns(tableName).size();
        if(columnSize > 7) return false;
        ResultSet resultSet = this.getData(tableName);
        ObservableList<Data> dataList = FXCollections.observableArrayList();
        try {
            while(resultSet.next()) {
                List<String> tuple = new ArrayList<>();
                for(int i = 0; i < columnSize; ++i) {
                    String columnName = tableView.getColumns().get(i).getText();
                    tuple.add(resultSet.getString(columnName));
                }
                dataList.add(new Data(tuple));
                tableView.setItems(dataList);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return true;
    }
    public boolean loadData(TableView<Data> tableView, ResultSet resultSet) {
        int columnSize = Integer.MAX_VALUE;
        try {
            columnSize = resultSet.getMetaData().getColumnCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(columnSize > 7) return false;

        ObservableList<Data> dataList = FXCollections.observableArrayList();
        try {
            while(resultSet.next()) {
                List<String> tuple = new ArrayList<>();
                for(int i = 1; i <= columnSize; ++i) {
                    String columnName = resultSet.getMetaData().getColumnName(i);
                    TableColumn col = tableView.getColumns().get(i-1);
                    col.setText(columnName);
                    col.setCellValueFactory(new PropertyValueFactory<Data, String>(CustomVBox.property[i-1]));
                    tuple.add(resultSet.getString(columnName));
                }
                dataList.add(new Data(tuple));
                tableView.setItems(dataList);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return true;
    }
}
