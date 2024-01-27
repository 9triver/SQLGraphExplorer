package cn.edu.nju.gui.model;

import cn.edu.nju.core.graph.Graph;
import cn.edu.nju.gui.controller.RootLayoutController;
import cn.edu.nju.gui.model.data.*;
import com.google.common.base.Joiner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

public class CustomVBox extends VBox {
    public static final String[] property = {"first","second","third","fourth","fifth","sixth","seventh"};
    private Graph.Table table;
    private VBox vBox;
    private Label label;
    private TableView<Data> tableView;
    private HBox hBox;
    private List<TextField> insertTextFields = new ArrayList<>();
    private Button insertButton;
    private TextArea output;
    private Button insertUpdateButton;
    private Button deleteUpdateButton;
    private Button inverseButton;

    public CustomVBox(Graph.Table table, String dstTableName, RootLayoutController controller) {
        super(CustomVBox.createVBox(table));
        this.table = table;
        vBox = (VBox) this.getChildren().get(0);
        label = (Label) vBox.getChildren().get(0);
        tableView = (TableView<Data>) vBox.getChildren().get(1);
        // hBox
        hBox = (HBox) vBox.getChildren().get(2);
        int columnSize = hBox.getChildren().size()-1;
        for(int i = 0; i < columnSize; ++i)
            insertTextFields.add((TextField) hBox.getChildren().get(i));
        insertButton = (Button) hBox.getChildren().get(columnSize);
        CustomVBox customVBox = this;
        insertButton.setOnAction(e -> controller.getDataBase().insertData(customVBox));
        if(dstTableName.equals(table.tableName)) {
            // 1. output
            output = new TextArea();
            output.setPromptText("Output");
            output.setMinWidth(400);
            output.setMinHeight(300);
            // 2. insert
            insertUpdateButton = (new Button("Insert Update"));
            insertUpdateButton.setMinWidth(100);
            insertUpdateButton.setOnAction(e -> output.setText("Insert:\n" + Joiner.on("\n").join(controller.getInsertSql())));
            // 3. delete
            deleteUpdateButton = new Button("Delete Update");
            deleteUpdateButton.setMinWidth(100);
            deleteUpdateButton.setOnAction(e -> {
                output.clear();
                output.setText("Delete:\n"+ Joiner.on("\n").join(controller.getDeleteSql()));
            });
            // 4. inverse
            inverseButton = new Button("Inverse");
            inverseButton.setMinWidth(100);
            inverseButton.setOnAction(e -> {
                output.clear();
                output.setText("Inverse:\n" + Joiner.on("\n").join(controller.getInverseSql()));
            });

            hBox.getChildren().addAll(insertUpdateButton, deleteUpdateButton, inverseButton, output);
        }
    }

    public Graph.Table getTable() {
        return table;
    }
    public String getTableName() {
        return this.getTable().tableName;
    }
    public List<TextField> getInsertTextFields() {
        return insertTextFields;
    }

    public TableView<Data> getTableView() {
        return tableView;
    }

    public static VBox createVBox(Graph.Table table) {
        int size = table.allSchema().getColumns().size();
        HBox hBox = new HBox();
        //        1. create table
        TableView<Data> tableView = new TableView<>();
        tableView.setMinHeight(400);
        ObservableList<Data> data = FXCollections.observableArrayList();

        final Label label = new Label(table.tableName);
        label.setFont(new Font("Arial", 20));
        tableView.setEditable(true);

        List<TextField> columnTextFields = new ArrayList<>();
        List<Graph.Column> columns = table.allSchema().getColumns().stream().toList();
        for(int index = 0; index < size; ++index) {
            Graph.Column column = columns.get(index);
            TableColumn col = new TableColumn(column.columnName);
            col.setCellValueFactory(new PropertyValueFactory<Data, String>(CustomVBox.property[index]));
            tableView.getColumns().addAll(col);

            TextField addCol = new TextField();
            addCol.setPromptText(column.columnName);
            addCol.setMinWidth(col.getPrefWidth());
            hBox.getChildren().addAll(addCol);
            columnTextFields.add(addCol);
        }

        tableView.setItems(data);

        Button insertButton = new Button("Insert");
        insertButton.setMinWidth(100);
        hBox.getChildren().addAll(insertButton);
        hBox.setSpacing(3);

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, tableView, hBox);

        return vbox;
    }
}
