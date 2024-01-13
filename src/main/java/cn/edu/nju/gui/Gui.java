package cn.edu.nju.gui;

import cn.edu.nju.PlSqlVisitor;
import cn.edu.nju.graph.Graph;
import com.google.common.base.Joiner;
import grammar.PlSqlLexer;
import grammar.PlSqlParser;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gui extends Application {
    private Graph graph;
    private Map<String, VBox> hBoxHashMap = new HashMap<>();
    private double xOffset = 0;
    private double yOffset = 300;
    private VBox viewTable;
    private List<String> insertSql = new ArrayList<>(), deleteSql = new ArrayList<>();

    public static Logger logger = Logger.getLogger(Gui.class);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) {
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPrefHeight(300);
        scrollPane.setPrefWidth(300);

        Group group = new Group();
        scrollPane.setContent(group);

        Scene scene = new Scene(scrollPane);

        primaryStage.setTitle("Table View Sample");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(800);

        VBox vBox = createInput(this, scene);
        ((Group)((ScrollPane) scene.getRoot()).getContent()).getChildren().addAll(vBox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private static VBox createInput(Gui gui, Scene scene) {
        HBox hb = new HBox();
        hb.setSpacing(3);
        // 1.input
        TextArea input = new TextArea();
        input.setPromptText("Input");
        input.setMaxWidth(400);
        hb.getChildren().addAll(input);
        // 2.dstTable
        TextField dstTable = new TextField();
        dstTable.setPromptText("Dest-Table Name");
        dstTable.setMaxWidth(400);
        hb.getChildren().addAll(dstTable);
        // 3.button
        Button button = new Button("Generate");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String sql = input.getText();
                String dstTableName = dstTable.getText();
                PlSqlVisitor visitor = Gui.sqlVisitor(sql,dstTableName);
                gui.graph = visitor.getGraph();
                for(Map.Entry<String, Graph.Table> entry : gui.graph.getTableNameMapper().entrySet()) {
                    Graph.Table table = entry.getValue();
                    VBox vBox = new CustomVBox(table, dstTableName, gui);
                    vBox.setLayoutX(gui.xOffset);
                    vBox.setLayoutY(gui.yOffset);
                    gui.yOffset+=600;
                    gui.hBoxHashMap.put(table.tableName, vBox);
                    ((Group)((ScrollPane) scene.getRoot()).getContent()).getChildren().addAll(vBox);
                    if(table.tableName.equals(dstTableName))
                        gui.viewTable = vBox;
                }
                gui.insertSql = visitor.getInsertTranslation().toSql();
                gui.deleteSql = visitor.getDeleteTranslation().toSql();
                logger.info("Insert:\n"+Joiner.on("\n").join(gui.insertSql));
                logger.info("Delete:\n"+Joiner.on("\n").join(gui.deleteSql));
            }
        });
        hb.getChildren().addAll(button);

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(hb);

        return vbox;
    }


    public static PlSqlVisitor sqlVisitor(String sql, String dstTableName) {
        ANTLRInputStream input=null;
        try{
            BufferedReader inputBuffer = new BufferedReader(new StringReader(sql));
            input = new ANTLRInputStream(inputBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PlSqlLexer lexer = new PlSqlLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PlSqlParser parser = new PlSqlParser(tokens);
        PlSqlParser.Sql_scriptContext rootContext = parser.sql_script();
        PlSqlVisitor visitor = new PlSqlVisitor(dstTableName);

        visitor.visitSql_script(rootContext);
        return visitor;
    }

    public List<String> getInsertSql() {
        return insertSql;
    }

    public List<String> getDeleteSql() {
        return deleteSql;
    }
}
