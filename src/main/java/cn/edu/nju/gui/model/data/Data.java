package cn.edu.nju.gui.model.data;

import javafx.beans.property.SimpleStringProperty;

import java.util.List;

public class Data {
    public static final String[] property = {
            "first","second","third","fourth","fifth","sixth","seventh","eighth",
            "ninth","tenth","eleventh","twelfth","thirteenth","fourteenth","fifteenth",
            "sixteenth","seventeenth","eighteenth","nineteenth","twentieth"};
    protected SimpleStringProperty first;
    protected SimpleStringProperty second;
    protected SimpleStringProperty third;
    protected SimpleStringProperty fourth;
    protected SimpleStringProperty fifth;
    protected SimpleStringProperty sixth;
    protected SimpleStringProperty seventh;
    protected SimpleStringProperty eighth;
    protected SimpleStringProperty ninth;
    protected SimpleStringProperty tenth;
    protected SimpleStringProperty eleventh;
    protected SimpleStringProperty twelfth;
    protected SimpleStringProperty thirteenth;
    protected SimpleStringProperty fourteenth;
    protected SimpleStringProperty fifteenth;
    protected SimpleStringProperty sixteenth;
    protected SimpleStringProperty seventeenth;
    protected SimpleStringProperty eighteenth;
    protected SimpleStringProperty nineteenth;
    protected SimpleStringProperty twentieth;
    public Data(List<String> data) {
        assert data.size() <= 20;
        switch (data.size()) {
            case 20 : this.twentieth = new SimpleStringProperty(data.get(19));
            case 19 : this.nineteenth = new SimpleStringProperty(data.get(18));
            case 18 : this.eighteenth = new SimpleStringProperty(data.get(17));
            case 17 : this.seventeenth = new SimpleStringProperty(data.get(16));
            case 16 : this.sixteenth = new SimpleStringProperty(data.get(15));
            case 15 : this.fifteenth = new SimpleStringProperty(data.get(14));
            case 14 : this.fourteenth = new SimpleStringProperty(data.get(13));
            case 13 : this.thirteenth = new SimpleStringProperty(data.get(12));
            case 12 : this.twelfth = new SimpleStringProperty(data.get(11));
            case 11 : this.eleventh = new SimpleStringProperty(data.get(10));
            case 10 : this.tenth = new SimpleStringProperty(data.get(9));
            case 9 : this.ninth = new SimpleStringProperty(data.get(8));
            case 8 : this.eighth = new SimpleStringProperty(data.get(7));
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
        assert data.length <= 20;
        switch (data.length) {
            case 20 : this.twentieth = new SimpleStringProperty(data[19]);
            case 19 : this.nineteenth = new SimpleStringProperty(data[18]);
            case 18 : this.eighteenth = new SimpleStringProperty(data[17]);
            case 17 : this.seventeenth = new SimpleStringProperty(data[16]);
            case 16 : this.sixteenth = new SimpleStringProperty(data[15]);
            case 15 : this.fifteenth = new SimpleStringProperty(data[14]);
            case 14 : this.fourteenth = new SimpleStringProperty(data[13]);
            case 13 : this.thirteenth = new SimpleStringProperty(data[12]);
            case 12 : this.twelfth = new SimpleStringProperty(data[11]);
            case 11 : this.eleventh = new SimpleStringProperty(data[10]);
            case 10 : this.tenth = new SimpleStringProperty(data[9]);
            case 9 : this.ninth = new SimpleStringProperty(data[8]);
            case 8 : this.eighth = new SimpleStringProperty(data[7]);
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

    public String getEighth() {
        return eighth.get();
    }

    public String getNinth() {
        return ninth.get();
    }

    public String getTenth() {
        return tenth.get();
    }

    public String getEleventh() {
        return eleventh.get();
    }

    public String getTwelfth() {
        return twelfth.get();
    }

    public String getThirteenth() {
        return thirteenth.get();
    }

    public String getFourteenth() {
        return fourteenth.get();
    }

    public String getFifteenth() {
        return fifteenth.get();
    }

    public String getSixteenth() {
        return sixteenth.get();
    }

    public String getSeventeenth() {
        return seventeenth.get();
    }

    public String getEighteenth() {
        return eighteenth.get();
    }

    public String getNineteenth() {
        return nineteenth.get();
    }

    public String getTwentieth() {
        return twentieth.get();
    }
}
