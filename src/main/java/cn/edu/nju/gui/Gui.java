package cn.edu.nju.gui;

import cn.edu.nju.PlSqlVisitor;
import cn.edu.nju.graph.Graph;
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
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Gui extends Application {
    Graph graph;
    Map<String, VBox> hBoxHashMap = new HashMap<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(450);
        stage.setHeight(550);

        VBox vBox = createInput(this, scene);
        ((Group) scene.getRoot()).getChildren().addAll(vBox);

        stage.setScene(scene);
        stage.show();
    }
    private static VBox createInput(Gui gui, Scene scene) {
        HBox hb = new HBox();
        TextArea input = new TextArea();
        input.setPromptText("Input");
        input.setMaxWidth(400);
        hb.getChildren().addAll(input);

        TextField dstTable = new TextField();
        dstTable.setPromptText("Dest-Table Name");
        dstTable.setMaxWidth(400);
        hb.getChildren().addAll(dstTable);

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
                    VBox vBox = new CustomVBox(table);
                    gui.hBoxHashMap.put(table.tableName, vBox);
                    ((Group) scene.getRoot()).getChildren().addAll(vBox);
                }
            }
        });
        hb.getChildren().addAll(button);
        hb.setSpacing(3);

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
}
