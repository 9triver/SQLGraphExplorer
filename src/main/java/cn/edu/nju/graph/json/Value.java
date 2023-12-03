package cn.edu.nju.graph.json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Value {
    private String title;
    private List<Item> items;
    public Value(String title, String... texts) {
        this.title = title;
        this.items = new ArrayList<>();
        for(String text : texts)
            this.items.add(new Item(text));
    }

    @Override
    public boolean equals(Object obj) {
        //自反性
        if (this == obj) return true;
        //任何对象不等于null，比较是否为同一类型
        if (!(obj instanceof Value)) return false;
        //强制类型转换
        Value other = (Value) obj;
        //比较属性值
        if(!this.title.equals(other.title) || this.items.size()!=other.items.size()) return false;
        for(int i = 0; i < this.items.size(); ++i)
            if(!this.items.get(i).equals(other.items.get(i)))
                return false;

        return true;
    }
    @Override
    public int hashCode() {
        List<Object> objs = new ArrayList<>();
        objs.add(this.title);
        objs.addAll(this.items);
        return Objects.hash(objs);
    }
}
