package cn.edu.nju.gui.model.data;

import javafx.beans.property.SimpleStringProperty;

import java.util.List;

public class Data6 extends Data5{
    protected SimpleStringProperty sixth ;
    public Data6(List<String> data) {
        super(data);
        this.sixth  = new SimpleStringProperty(data.get(5));
    }

    public String getSixth() {
        return sixth.get();
    }

    public void setSixth(String sixth) {
        this.sixth.set(sixth);
    }
}
