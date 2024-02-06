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
    opens cn.edu.nju.gui.controller to javafx.fxml;
    opens cn.edu.nju.gui.model.data to javafx.base;

    exports cn.edu.nju;
    exports cn.edu.nju.core;
    exports cn.edu.nju.core.expression;
    exports cn.edu.nju.core.graph;
}