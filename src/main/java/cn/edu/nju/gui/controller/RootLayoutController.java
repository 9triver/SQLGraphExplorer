package cn.edu.nju.gui.controller;

import cn.edu.nju.core.PlSqlVisitor;
import cn.edu.nju.core.grammar.PlSqlLexer;
import cn.edu.nju.core.grammar.PlSqlParser;
import cn.edu.nju.core.graph.Graph;
import cn.edu.nju.core.tools.Tools;
import cn.edu.nju.gui.model.CustomVBox;
import com.google.common.base.Joiner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RootLayoutController {
    private Graph graph;
    private Map<String, VBox> hBoxHashMap = new HashMap<>();
    private List<String> insertSql = null, deleteSql = null, inverseSql = null;
    public static Logger logger = Logger.getLogger(RootLayoutController.class);

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox rootVBox;
    @FXML
    private HBox inputHBox;
    @FXML
    private VBox tablesVBox;
    @FXML
    private TextArea inputSql;
    @FXML
    private TextField inputDstTable;
    @FXML
    private Button generateButton;

    public RootLayoutController() {}
    @FXML
    private void initialize() {}

    @FXML
    void generateTables(ActionEvent event) {
        String sql = inputSql.getText();
        String dstTableName = inputDstTable.getText();
        PlSqlVisitor visitor = Tools.parseSql(sql,dstTableName);
        graph = visitor.getGraph();
        for(Map.Entry<String, Graph.Table> entry : graph.getTableNameMapper().entrySet()) {
            Graph.Table table = entry.getValue();
            VBox vBox = new CustomVBox(table, dstTableName, this);
            hBoxHashMap.put(table.tableName, vBox);
            tablesVBox.getChildren().addAll(vBox);
        }
        insertSql = visitor.getInsertTranslation().toSql();
        deleteSql = visitor.getDeleteTranslation().toSql();
        inverseSql = visitor.getInverseSqls();
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
}
