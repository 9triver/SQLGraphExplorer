package cn.edu.nju.gui.model.data;

import javafx.beans.property.SimpleStringProperty;

import java.util.List;

public class Data7 extends Data6 {
    protected SimpleStringProperty seventh;

    public Data7(List<String> data) {
        super(data);
        this.seventh = new SimpleStringProperty(data.get(6));
    }

    public String getSeventh() {
        return seventh.get();
    }

    public void setSeventh(String seventh) {
        this.seventh.set(seventh);
    }
}

