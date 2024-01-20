package cn.edu.nju.gui.model;

import cn.edu.nju.core.graph.Graph;
import cn.edu.nju.gui.Gui;
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

import java.util.ArrayList;
import java.util.List;

public class CustomVBox extends VBox {
    private static String[] property = {"first","second","third","fourth","fifth","sixth","seventh"};
    
    public CustomVBox(Graph.Table table, String dstTableName, Gui gui) {
        super(CustomVBox.createVBox(table));
        if(dstTableName.equals(table.tableName)) {
            // 0. getHBox
            VBox vBox = (VBox) this.getChildren().get(0);
            HBox hBox = (HBox) vBox.getChildren().get(2);
            // 1. output
            TextArea output = new TextArea();
            output.setPromptText("Output");
            output.setMaxWidth(400);
            // 2. insert
            Button insertUpdateButton = (new Button("Insert Update"));
            insertUpdateButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    output.setText("Insert:\n"+ Joiner.on("\n").join(gui.getInsertSql()));
                }
            });
            // 3. delete
            Button deleteUpdateButton = new Button("Delete Update");
            deleteUpdateButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    output.clear();
                    output.setText("Delete:\n"+ Joiner.on("\n").join(gui.getDeleteSql()));
                }
            });
            // 4. inverse
            Button inverseButton = new Button("Inverse");
            inverseButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    output.clear();
                    output.setText("Inverse:\n"+ Joiner.on("\n").join(gui.getInverseSql()));
                }
            });

            hBox.getChildren().addAll(insertUpdateButton, deleteUpdateButton, inverseButton, output);
        }
    }

    public CustomVBox(Graph.Table table, String dstTableName, RootLayoutController controller) {
        super(CustomVBox.createVBox(table));
        if(dstTableName.equals(table.tableName)) {
            // 0. getHBox
            VBox vBox = (VBox) this.getChildren().get(0);
            HBox hBox = (HBox) vBox.getChildren().get(2);
            // 1. output
            TextArea output = new TextArea();
            output.setPromptText("Output");
            output.setMaxWidth(400);
            // 2. insert
            Button insertUpdateButton = (new Button("Insert Update"));
            insertUpdateButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    output.setText("Insert:\n"+ Joiner.on("\n").join(controller.getInsertSql()));
                }
            });
            // 3. delete
            Button deleteUpdateButton = new Button("Delete Update");
            deleteUpdateButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    output.clear();
                    output.setText("Delete:\n"+ Joiner.on("\n").join(controller.getDeleteSql()));
                }
            });
            // 4. inverse
            Button inverseButton = new Button("Inverse");
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
        HBox hb = new HBox();
        //        1. create table
        TableView<Data1> tableView = new TableView<>();
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
            addCol.setMaxWidth(col.getPrefWidth());
            hb.getChildren().addAll(addCol);
            columnTextFields.add(addCol);
        }

        tableView.setItems(data);


        Button insertButton = new Button("Insert");
        insertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                List<String> insertData = new ArrayList<>();
                for(TextField textField : columnTextFields) {
                    insertData.add(textField.getText());
                    textField.clear();
                }
                data.add(new Data1(insertData));
            }
        });
        hb.getChildren().addAll(insertButton);
        hb.setSpacing(3);

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, tableView, hb);

        return vbox;
    }
    private static VBox createVBox2(Graph.Table table) {
        int size = table.allSchema().getColumns().size();
        HBox hb = new HBox();
        //        1. create table
        TableView<Data2> tableView = new TableView<>();
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
            addCol.setMaxWidth(col.getPrefWidth());
            hb.getChildren().addAll(addCol);
            columnTextFields.add(addCol);
        }

        tableView.setItems(data);


        Button insertButton = new Button("Insert");
        insertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                List<String> insertData = new ArrayList<>();
                for(TextField textField : columnTextFields) {
                    insertData.add(textField.getText());
                    textField.clear();
                }
                data.add(new Data2(insertData));
            }
        });
        hb.getChildren().addAll(insertButton);
        hb.setSpacing(3);


        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, tableView, hb);

        return vbox;
    }
    private static VBox createVBox3(Graph.Table table) {
        int size = table.allSchema().getColumns().size();
        HBox hb = new HBox();
        //        1. create table
        TableView<Data3> tableView = new TableView<>();
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
            addCol.setMaxWidth(col.getPrefWidth());
            hb.getChildren().addAll(addCol);
            columnTextFields.add(addCol);
        }

        tableView.setItems(data);


        Button insertButton = new Button("Insert");
        insertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                List<String> insertData = new ArrayList<>();
                for(TextField textField : columnTextFields) {
                    insertData.add(textField.getText());
                    textField.clear();
                }
                data.add(new Data3(insertData));
            }
        });

        hb.getChildren().addAll(insertButton);
        hb.setSpacing(3);


        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, tableView, hb);

        return vbox;
    }
    private static VBox createVBox4(Graph.Table table) {
        int size = table.allSchema().getColumns().size();
        HBox hb = new HBox();
        //        1. create table
        TableView<Data4> tableView = new TableView<>();
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
            addCol.setMaxWidth(col.getPrefWidth());
            hb.getChildren().addAll(addCol);
            columnTextFields.add(addCol);
        }

        tableView.setItems(data);


        Button insertButton = new Button("Insert");
        insertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                List<String> insertData = new ArrayList<>();
                for(TextField textField : columnTextFields) {
                    insertData.add(textField.getText());
                    textField.clear();
                }

                data.add(new Data4(insertData));
            }
        });
        hb.getChildren().addAll(insertButton);
        hb.setSpacing(3);


        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, tableView, hb);

        return vbox;
    }
    private static VBox createVBox5(Graph.Table table) {
        int size = table.allSchema().getColumns().size();
        HBox hb = new HBox();
        //        1. create table
        TableView<Data5> tableView = new TableView<>();
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
            addCol.setMaxWidth(col.getPrefWidth());
            hb.getChildren().addAll(addCol);
            columnTextFields.add(addCol);
        }

        tableView.setItems(data);


        Button insertButton = new Button("Insert");
        insertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                List<String> insertData = new ArrayList<>();
                for(TextField textField : columnTextFields) {
                    insertData.add(textField.getText());
                    textField.clear();
                }
                data.add(new Data5(insertData));
            }
        });
        hb.getChildren().addAll(insertButton);
        hb.setSpacing(3);


        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, tableView, hb);

        return vbox;
    }
    private static VBox createVBox6(Graph.Table table) {
        int size = table.allSchema().getColumns().size();
        HBox hb = new HBox();
        //        1. create table
        TableView<Data6> tableView = new TableView<>();
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
            addCol.setMaxWidth(col.getPrefWidth());
            hb.getChildren().addAll(addCol);
            columnTextFields.add(addCol);
        }

        tableView.setItems(data);


        Button insertButton = new Button("Insert");
        insertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                List<String> insertData = new ArrayList<>();
                for(TextField textField : columnTextFields) {
                    insertData.add(textField.getText());
                    textField.clear();
                }

                data.add(new Data6(insertData));
            }
        });
        hb.getChildren().addAll(insertButton);
        hb.setSpacing(3);


        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, tableView, hb);

        return vbox;
    }
    private static VBox createVBox7(Graph.Table table) {
        int size = table.allSchema().getColumns().size();
        HBox hb = new HBox();
        //        1. create table
        TableView<Data7> tableView = new TableView<>();
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
            addCol.setMaxWidth(col.getPrefWidth());
            hb.getChildren().addAll(addCol);
            columnTextFields.add(addCol);
        }

        tableView.setItems(data);


        Button insertButton = new Button("Insert");
        insertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                List<String> insertData = new ArrayList<>();
                for(TextField textField : columnTextFields) {
                    insertData.add(textField.getText());
                    textField.clear();
                }
                data.add(new Data7(insertData));
            }
        });
        hb.getChildren().addAll(insertButton);
        hb.setSpacing(3);


        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, tableView, hb);

        return vbox;
    }
}
