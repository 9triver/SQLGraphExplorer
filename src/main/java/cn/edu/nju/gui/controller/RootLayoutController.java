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
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenSource;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RootLayoutController {
    private Graph graph;
    private Map<String, VBox> hBoxHashMap = new HashMap<>();
    private double xOffset = 0;
    private double yOffset = 300;
    private List<String> insertSql = null, deleteSql = null, inverseSql = null;
    public static Logger logger = Logger.getLogger(RootLayoutController.class);

    @FXML
    private ScrollPane ScrollPane;
    @FXML
    private Button generateButton;
    @FXML
    private Group group;
    @FXML
    private HBox hbox;
    @FXML
    private TextField inputDstTable;
    @FXML
    private TextArea inputSql;

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
            vBox.setLayoutX(xOffset);
            vBox.setLayoutY(yOffset);
            yOffset+=600;
            hBoxHashMap.put(table.tableName, vBox);
            group.getChildren().addAll(vBox);
        }
        insertSql = visitor.getInsertTranslation().toSql();
        deleteSql = visitor.getDeleteTranslation().toSql();
        inverseSql = visitor.getInverseSqls();
        logger.info("Insert:\n"+ Joiner.on("\n").join(insertSql));
        logger.info("Delete:\n"+Joiner.on("\n").join(deleteSql));
        logger.info("Inverse:\n"+Joiner.on("\n").join(inverseSql));
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
