module cn.edu.nju {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.antlr.antlr4.runtime;
    requires com.google.gson;
    requires org.apache.commons.lang3;
    requires log4j;
    requires com.google.common;
    requires java.desktop;
    requires java.sql;


    opens cn.edu.nju.core to javafx.fxml;
    opens cn.edu.nju.gui to javafx.fxml;

    exports cn.edu.nju.core;
    exports cn.edu.nju.gui;
}