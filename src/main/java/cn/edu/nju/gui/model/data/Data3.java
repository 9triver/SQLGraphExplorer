package cn.edu.nju.gui.model.data;

import javafx.beans.property.SimpleStringProperty;

import java.util.List;

public class Data3 extends Data2{
    protected SimpleStringProperty third;
    public Data3(List<String> data) {
        super(data);
        this.third = new SimpleStringProperty(data.get(2));
    }
    public Data3(String... data) {
        super(data);
        this.first = new SimpleStringProperty(data[2]);
    }

    public String getThird() {
        return third.get();
    }

    public void setThird(String third) {
        this.third.set(third);
    }
}
