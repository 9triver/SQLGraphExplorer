package cn.edu.nju.gui.controller;

import cn.edu.nju.core.PlSqlVisitor;
import cn.edu.nju.core.graph.Graph;
import cn.edu.nju.core.tools.Tools;
import cn.edu.nju.gui.model.CustomVBox;
import cn.edu.nju.gui.model.data.Data;
import cn.edu.nju.gui.util.database.DataBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RootLayoutController {
    public static Logger logger = Logger.getLogger(RootLayoutController.class);
    private Graph graph = null;
    private List<String> insertSql = null, deleteSql = null, inverseSql = null;
    private final List<CustomVBox> customVBoxes = new ArrayList<>();
    private DataBase dataBase = null;

    public RootLayoutController() {}
    @FXML
    private void initialize() {}
    @FXML
    private HBox controlHBox;
    @FXML
    private TextArea execSqlTextArea;
    @FXML
    private Button executeButton;
    @FXML
    private Button generateButton;
    @FXML
    private TextField inputDstTable;
    @FXML
    private HBox inputHBox;
    @FXML
    private TextArea inputSql;
    @FXML
    private Button refreshButton;
    @FXML
    private TableView<Data> resultTable;
    @FXML
    private VBox rootVBox;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox tablesVBox;
    @FXML
    void generateTables(ActionEvent event) {
        if(dataBase != null) dataBase.close();
        String sql = inputSql.getText();
        String dstTableName = inputDstTable.getText();
        PlSqlVisitor visitor = Tools.parseSql(sql, dstTableName);
        graph = visitor.getGraph();
        dataBase = new DataBase("temp", graph);
        dataBase.execute(sql);
        for (Map.Entry<String, Graph.Table> entry : graph.getTableNameMapper().entrySet()) {
            Graph.Table table = entry.getValue();
            CustomVBox customVBox = new CustomVBox(table, dstTableName, this);
            customVBoxes.add(customVBox);
            tablesVBox.getChildren().addAll(customVBox);
        }
        insertSql = visitor.getInsertTranslation().toSql();
        deleteSql = visitor.getDeleteTranslation().toSql();
        inverseSql = visitor.getInverseSqls();
    }
    @FXML
    void executeSql(ActionEvent event) {
        ResultSet resultSet = dataBase.executeSql(execSqlTextArea.getText()).getRight();
        if(resultSet != null)
            dataBase.loadData(resultTable, resultSet);
        refreshData(event);
    }

    @FXML
    void refreshData(ActionEvent event) {
        if(dataBase == null) return;
        for(CustomVBox customVBox : customVBoxes)
            dataBase.refreshData(customVBox);
    }

    public List<String> getInsertSql() {
        return insertSql;
    }

    public List<String> getDeleteSql() {
        return deleteSql;
    }

    public List<String> getInverseSql() {
        return inverseSql;
    }

    public DataBase getDataBase() {
        return dataBase;
    }
}
