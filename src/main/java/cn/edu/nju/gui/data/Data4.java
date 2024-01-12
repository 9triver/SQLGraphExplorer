package cn.edu.nju.gui.data;

import javafx.beans.property.SimpleStringProperty;

import java.util.List;

public class Data4 extends Data3{
    protected SimpleStringProperty fourth ;
    public Data4(List<String> data) {
        super(data);
        this.fourth  = new SimpleStringProperty(data.get(3));
    }

    public String getFourth() {
        return fourth.get();
    }

    public void setFourth(String fourth) {
        this.fourth.set(fourth);
    }
}
