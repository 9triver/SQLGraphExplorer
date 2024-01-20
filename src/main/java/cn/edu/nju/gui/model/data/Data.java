package cn.edu.nju.gui.model.data;

import java.util.List;

public class Data {
    public static Data get(List<String> data) {
        return switch (data.size()) {
            case 1 -> new Data1(data);
            case 2 -> new Data2(data);
            case 3 -> new Data3(data);
            case 4 -> new Data4(data);
            case 5 -> new Data5(data);
            case 6 -> new Data6(data);
            case 7 -> new Data7(data);
            default -> null;
        };
    }
}
