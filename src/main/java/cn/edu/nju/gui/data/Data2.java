package cn.edu.nju.gui.data;

import javafx.beans.property.SimpleStringProperty;

import java.util.List;

public class Data2 extends Data1{
    protected SimpleStringProperty second;
    public Data2(List<String> data) {
        super(data);
        this.second = new SimpleStringProperty(data.get(1));
    }

    public String getSecond() {
        return second.get();
    }

    public void setSecond(String second) {
        this.second.set(second);
    }
}
