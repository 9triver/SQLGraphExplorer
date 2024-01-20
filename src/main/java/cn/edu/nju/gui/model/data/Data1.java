package cn.edu.nju.gui.model.data;

import javafx.beans.property.SimpleStringProperty;

import java.util.List;

public class Data1 extends Data{
    protected SimpleStringProperty first;
    public Data1(List<String> data) {
        this.first = new SimpleStringProperty(data.get(0));
    }

    public String getFirst() {
        return first.get();
    }

    public void setFirst(String first) {
        this.first.set(first);
    }
}
