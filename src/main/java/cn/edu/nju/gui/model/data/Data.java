package cn.edu.nju.gui.model.data;

import javafx.beans.property.SimpleStringProperty;

import java.util.List;

public class Data {
    protected SimpleStringProperty first;
    protected SimpleStringProperty second;
    protected SimpleStringProperty third;
    protected SimpleStringProperty fourth;
    protected SimpleStringProperty fifth;
    protected SimpleStringProperty sixth;
    protected SimpleStringProperty seventh;
    public Data(List<String> data) {
        assert data.size() <= 7;
        switch (data.size()) {
            case 7 : this.seventh = new SimpleStringProperty(data.get(6));
            case 6 : this.sixth = new SimpleStringProperty(data.get(5));
            case 5 : this.fifth = new SimpleStringProperty(data.get(4));
            case 4 : this.fourth = new SimpleStringProperty(data.get(3));
            case 3 : this.third = new SimpleStringProperty(data.get(2));
            case 2 : this.second = new SimpleStringProperty(data.get(1));
            case 1 : this.first = new SimpleStringProperty(data.get(0));
        }
    }
    public Data(String... data) {
        assert data.length <= 7;
        switch (data.length) {
            case 7 : this.seventh = new SimpleStringProperty(data[6]);
            case 6 : this.sixth = new SimpleStringProperty(data[5]);
            case 5 : this.fifth = new SimpleStringProperty(data[4]);
            case 4 : this.fourth = new SimpleStringProperty(data[3]);
            case 3 : this.third = new SimpleStringProperty(data[2]);
            case 2 : this.second = new SimpleStringProperty(data[1]);
            case 1 : this.first = new SimpleStringProperty(data[0]);
        }
    }

    public String getFirst() {
        return first.get();
    }

    public String getSecond() {
        return second.get();
    }

    public String getThird() {
        return third.get();
    }

    public String getFourth() {
        return fourth.get();
    }

    public String getFifth() {
        return fifth.get();
    }

    public String getSixth() {
        return sixth.get();
    }

    public String getSeventh() {
        return seventh.get();
    }
}
