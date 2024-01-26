package cn.edu.nju.gui.model;

import cn.edu.nju.core.graph.Graph;
import cn.edu.nju.gui.controller.RootLayoutController;
import cn.edu.nju.gui.model.data.*;
import com.google.common.base.Joiner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import javax.swing.plaf.ButtonUI;
import java.util.ArrayList;
import java.util.List;

public class CustomVBox extends VBox {
    private static String[] property = {"first","second","third","fourth","fifth","sixth","seventh"};
    private Graph.Table table = null;
    private VBox vBox = null;
    private Label label = null;
    private TableView tableView = null;
    private HBox hBox = null;
    private List<TextField> insertTextFields = new ArrayList<>();
    private Button insertButton = null;
    private TextArea output = null;
    private Button insertUpdateButton = null;
    private Button deleteUpdateButton = null;
    private Button inverseButton = null;

    public CustomVBox(Graph.Table table, String dstTableName, RootLayoutController controller) {
        super(CustomVBox.createVBox(table));
        this.table = table;
        vBox = (VBox) this.getChildren().get(0);
        label = (Label) vBox.getChildren().get(0);
        tableView = (TableView) vBox.getChildren().get(1);
        // hBox
        hBox = (HBox) vBox.getChildren().get(2);
        int columnSize = hBox.getChildren().size()-1;
        for(int i = 0; i < columnSize; ++i)
            insertTextFields.add((TextField) hBox.getChildren().get(i));
        insertButton = (Button) hBox.getChildren().get(columnSize);
        CustomVBox customVBox = this;
        insertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                controller.getDataBase().insertData(customVBox);
            }
        });
        if(dstTableName.equals(table.tableName)) {
            // 1. output
            output = new TextArea();
            output.setPromptText("Output");
            output.setMinWidth(400);
            output.setMinHeight(300);
            // 2. insert
            insertUpdateButton = (new Button("Insert Update"));
            insertUpdateButton.setMinWidth(100);
            insertUpdateButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    output.setText("Insert:\n"+ Joiner.on("\n").join(controller.getInsertSql()));
                }
            });
            // 3. delete
            deleteUpdateButton = new Button("Delete Update");
            deleteUpdateButton.setMinWidth(100);
            deleteUpdateButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    output.clear();
                    output.setText("Delete:\n"+ Joiner.on("\n").join(controller.getDeleteSql()));
                }
            });
            // 4. inverse
            inverseButton = new Button("Inverse");
            inverseButton.setMinWidth(100);
            inverseButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    output.clear();
                    output.setText("Inverse:\n"+ Joiner.on("\n").join(controller.getInverseSql()));
                }
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

    public TableView getTableView() {
        return tableView;
    }

    public static VBox createVBox(Graph.Table table) {
        int size = table.allSchema().getColumns().size();
        return switch (size) {
            case 1 -> CustomVBox.createVBox1(table);
            case 2 -> CustomVBox.createVBox2(table);
            case 3 -> CustomVBox.createVBox3(table);
            case 4 -> CustomVBox.createVBox4(table);
            case 5 -> CustomVBox.createVBox5(table);
            case 6 -> CustomVBox.createVBox6(table);
            case 7 -> CustomVBox.createVBox7(table);
            default -> null;
        };
    }
    private static VBox createVBox1(Graph.Table table) {
        int size = table.allSchema().getColumns().size();
        HBox hBox = new HBox();
        //        1. create table
        TableView<Data1> tableView = new TableView<>();
        tableView.setMinHeight(600);
        ObservableList<Data1> data = FXCollections.observableArrayList();

        final Label label = new Label(table.tableName);
        label.setFont(new Font("Arial", 20));
        tableView.setEditable(true);

        List<TextField> columnTextFields = new ArrayList<>();
        List<Graph.Column> columns = table.allSchema().getColumns().stream().toList();
        for(int index = 0; index < size; ++index) {
            Graph.Column column = columns.get(index);
            TableColumn col = new TableColumn(column.columnName);
            col.setMinWidth(100);
            col.setCellValueFactory(new PropertyValueFactory<Data1, String>(CustomVBox.property[index]));
            tableView.getColumns().addAll(col);
//       add button
            TextField addCol = new TextField();
            addCol.setPromptText(column.columnName);
            addCol.setMinWidth(col.getPrefWidth());
            hBox.getChildren().addAll(addCol);
            columnTextFields.add(addCol);
        }

        tableView.setItems(data);

        Button insertButton = new Button("Insert");
        insertButton.setMinWidth(100);
        insertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                List<String> insertData = new ArrayList<>();
                for(TextField textField : columnTextFields) {
                    insertData.add(textField.getText());
                    textField.clear();
                }
                tableView.getItems().add(new Data1(insertData));
            }
        });
        hBox.getChildren().addAll(insertButton);
        hBox.setSpacing(3);

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, tableView, hBox);

        return vbox;
    }
    private static VBox createVBox2(Graph.Table table) {
        int size = table.allSchema().getColumns().size();
        HBox hBox = new HBox();
        //        1. create table
        TableView<Data2> tableView = new TableView<>();
        tableView.setMinHeight(600);
        ObservableList<Data2> data = FXCollections.observableArrayList();

        final Label label = new Label(table.tableName);
        label.setFont(new Font("Arial", 20));
        tableView.setEditable(true);

        List<TextField> columnTextFields = new ArrayList<>();
        List<Graph.Column> columns = table.allSchema().getColumns().stream().toList();
        for(int index = 0; index < size; ++index) {
            Graph.Column column = columns.get(index);
            TableColumn col = new TableColumn(column.columnName);
            col.setMinWidth(100);
            col.setCellValueFactory(new PropertyValueFactory<Data2, String>(CustomVBox.property[index]));
            tableView.getColumns().addAll(col);
//       add button
            TextField addCol = new TextField();
            addCol.setPromptText(column.columnName);
            addCol.setMinWidth(col.getPrefWidth());
            hBox.getChildren().addAll(addCol);
            columnTextFields.add(addCol);
        }

        tableView.setItems(data);

        Button insertButton = new Button("Insert");
        insertButton.setMinWidth(100);
        insertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                List<String> insertData = new ArrayList<>();
                for(TextField textField : columnTextFields) {
                    insertData.add(textField.getText());
                    textField.clear();
                }
                tableView.getItems().add(new Data2(insertData));
            }
        });
        hBox.getChildren().addAll(insertButton);
        hBox.setSpacing(3);

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, tableView, hBox);

        return vbox;
    }
    private static VBox createVBox3(Graph.Table table) {
        int size = table.allSchema().getColumns().size();
        HBox hBox = new HBox();
        //        1. create table
        TableView<Data3> tableView = new TableView<>();
        tableView.setMinHeight(600);
        ObservableList<Data3> data = FXCollections.observableArrayList();

        final Label label = new Label(table.tableName);
        label.setFont(new Font("Arial", 20));
        tableView.setEditable(true);

        List<TextField> columnTextFields = new ArrayList<>();
        List<Graph.Column> columns = table.allSchema().getColumns().stream().toList();
        for(int index = 0; index < size; ++index) {
            Graph.Column column = columns.get(index);
            TableColumn col = new TableColumn(column.columnName);
            col.setMinWidth(100);
            col.setCellValueFactory(new PropertyValueFactory<Data3, String>(CustomVBox.property[index]));
            tableView.getColumns().addAll(col);
//       add button
            TextField addCol = new TextField();
            addCol.setPromptText(column.columnName);
            addCol.setMinWidth(col.getPrefWidth());
            hBox.getChildren().addAll(addCol);
            columnTextFields.add(addCol);
        }

        tableView.setItems(data);

        Button insertButton = new Button("Insert");
        insertButton.setMinWidth(100);
        insertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                List<String> insertData = new ArrayList<>();
                for(TextField textField : columnTextFields) {
                    insertData.add(textField.getText());
                    textField.clear();
                }
                tableView.getItems().add(new Data3(insertData));
            }
        });

        hBox.getChildren().addAll(insertButton);
        hBox.setSpacing(3);

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, tableView, hBox);

        return vbox;
    }
    private static VBox createVBox4(Graph.Table table) {
        int size = table.allSchema().getColumns().size();
        HBox hBox = new HBox();
        //        1. create table
        TableView<Data4> tableView = new TableView<>();
        tableView.setMinHeight(600);
        ObservableList<Data4> data = FXCollections.observableArrayList();

        final Label label = new Label(table.tableName);
        label.setFont(new Font("Arial", 20));
        tableView.setEditable(true);

        List<TextField> columnTextFields = new ArrayList<>();
        List<Graph.Column> columns = table.allSchema().getColumns().stream().toList();
        for(int index = 0; index < size; ++index) {
            Graph.Column column = columns.get(index);
            TableColumn col = new TableColumn(column.columnName);
            col.setMinWidth(100);
            col.setCellValueFactory(new PropertyValueFactory<Data4, String>(CustomVBox.property[index]));
            tableView.getColumns().addAll(col);
//       add button
            TextField addCol = new TextField();
            addCol.setPromptText(column.columnName);
            addCol.setMinWidth(col.getPrefWidth());
            hBox.getChildren().addAll(addCol);
            columnTextFields.add(addCol);
        }

        tableView.setItems(data);

        Button insertButton = new Button("Insert");
        insertButton.setMinWidth(100);
        insertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                List<String> insertData = new ArrayList<>();
                for(TextField textField : columnTextFields) {
                    insertData.add(textField.getText());
                    textField.clear();
                }
                tableView.getItems().add(new Data4(insertData));
            }
        });
        hBox.getChildren().addAll(insertButton);
        hBox.setSpacing(3);

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, tableView, hBox);

        return vbox;
    }
    private static VBox createVBox5(Graph.Table table) {
        int size = table.allSchema().getColumns().size();
        HBox hBox = new HBox();
        //        1. create table
        TableView<Data5> tableView = new TableView<>();
        tableView.setMinHeight(600);
        ObservableList<Data5> data = FXCollections.observableArrayList();

        final Label label = new Label(table.tableName);
        label.setFont(new Font("Arial", 20));
        tableView.setEditable(true);

        List<TextField> columnTextFields = new ArrayList<>();
        List<Graph.Column> columns = table.allSchema().getColumns().stream().toList();
        for(int index = 0; index < size; ++index) {
            Graph.Column column = columns.get(index);
            TableColumn col = new TableColumn(column.columnName);
            col.setMinWidth(100);
            col.setCellValueFactory(new PropertyValueFactory<Data5, String>(CustomVBox.property[index]));
            tableView.getColumns().addAll(col);
//       add button
            TextField addCol = new TextField();
            addCol.setPromptText(column.columnName);
            addCol.setMinWidth(col.getPrefWidth());
            hBox.getChildren().addAll(addCol);
            columnTextFields.add(addCol);
        }

        tableView.setItems(data);

        Button insertButton = new Button("Insert");
        insertButton.setMinWidth(100);
        insertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                List<String> insertData = new ArrayList<>();
                for(TextField textField : columnTextFields) {
                    insertData.add(textField.getText());
                    textField.clear();
                }
                tableView.getItems().add(new Data5(insertData));
            }
        });
        hBox.getChildren().addAll(insertButton);
        hBox.setSpacing(3);

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, tableView, hBox);

        return vbox;
    }
    private static VBox createVBox6(Graph.Table table) {
        int size = table.allSchema().getColumns().size();
        HBox hBox = new HBox();
        //        1. create table
        TableView<Data6> tableView = new TableView<>();
        tableView.setMinHeight(600);
        ObservableList<Data6> data = FXCollections.observableArrayList();

        final Label label = new Label(table.tableName);
        label.setFont(new Font("Arial", 20));
        tableView.setEditable(true);

        List<TextField> columnTextFields = new ArrayList<>();
        List<Graph.Column> columns = table.allSchema().getColumns().stream().toList();
        for(int index = 0; index < size; ++index) {
            Graph.Column column = columns.get(index);
            TableColumn col = new TableColumn(column.columnName);
            col.setMinWidth(100);
            col.setCellValueFactory(new PropertyValueFactory<Data6, String>(CustomVBox.property[index]));
            tableView.getColumns().addAll(col);
//       add button
            TextField addCol = new TextField();
            addCol.setPromptText(column.columnName);
            addCol.setMinWidth(col.getPrefWidth());
            hBox.getChildren().addAll(addCol);
            columnTextFields.add(addCol);
        }

        tableView.setItems(data);


        Button insertButton = new Button("Insert");
        insertButton.setMinWidth(100);
        insertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                List<String> insertData = new ArrayList<>();
                for(TextField textField : columnTextFields) {
                    insertData.add(textField.getText());
                    textField.clear();
                }
                tableView.getItems().add(new Data6(insertData));
            }
        });
        hBox.getChildren().addAll(insertButton);
        hBox.setSpacing(3);

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, tableView, hBox);

        return vbox;
    }
    private static VBox createVBox7(Graph.Table table) {
        int size = table.allSchema().getColumns().size();
        HBox hBox = new HBox();
        //        1. create table
        TableView<Data7> tableView = new TableView<>();
        tableView.setMinHeight(600);
        ObservableList<Data7> data = FXCollections.observableArrayList();

        final Label label = new Label(table.tableName);
        label.setFont(new Font("Arial", 20));
        tableView.setEditable(true);

        List<TextField> columnTextFields = new ArrayList<>();
        List<Graph.Column> columns = table.allSchema().getColumns().stream().toList();
        for(int index = 0; index < size; ++index) {
            Graph.Column column = columns.get(index);
            TableColumn col = new TableColumn(column.columnName);
            col.setMinWidth(100);
            col.setCellValueFactory(new PropertyValueFactory<Data7, String>(CustomVBox.property[index]));
            tableView.getColumns().addAll(col);
//       add button
            TextField addCol = new TextField();
            addCol.setPromptText(column.columnName);
            addCol.setMinWidth(col.getPrefWidth());
            hBox.getChildren().addAll(addCol);
            columnTextFields.add(addCol);
        }

        tableView.setItems(data);


        Button insertButton = new Button("Insert");
        insertButton.setMinWidth(100);
        insertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                List<String> insertData = new ArrayList<>();
                for(TextField textField : columnTextFields) {
                    insertData.add(textField.getText());
                    textField.clear();
                }
                tableView.getItems().add(new Data7(insertData));
            }
        });
        hBox.getChildren().addAll(insertButton);
        hBox.setSpacing(3);

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, tableView, hBox);

        return vbox;
    }
}
