package cn.edu.nju.gui.model.data;

import javafx.beans.property.SimpleStringProperty;

import java.util.List;

public class Data5 extends Data4{
    protected SimpleStringProperty fifth ;
    public Data5(List<String> data) {
        super(data);
        this.fifth  = new SimpleStringProperty(data.get(4));
    }

    public String getFifth() {
        return fifth.get();
    }

    public void setFifth(String fifth) {
        this.fifth.set(fifth);
    }
}
