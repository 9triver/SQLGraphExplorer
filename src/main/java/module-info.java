module cn.edu.nju {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.antlr.antlr4.runtime;
    requires com.google.gson;
    requires org.apache.commons.lang3;
    requires log4j;
    requires com.google.common;
    requires java.desktop;


    opens cn.edu.nju to javafx.fxml;
    opens cn.edu.nju.gui to javafx.fxml;
    opens cn.edu.nju.gui.data to javafx.fxml;
    opens grammar to javafx.fxml;

    exports cn.edu.nju;
    exports cn.edu.nju.gui;
    exports cn.edu.nju.gui.data;
    exports cn.edu.nju.graph;
    exports grammar;
}