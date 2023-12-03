package cn.edu.nju.graph.json;

import java.util.Iterator;
import java.util.Objects;

public class Item {
    private String text;
    public Item(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object obj) {
        //自反性
        if (this == obj) return true;
        //任何对象不等于null，比较是否为同一类型
        if (!(obj instanceof Item)) return false;
        //强制类型转换
        Item other = (Item) obj;
        //比较属性值
        return this.text.equals(other.text);
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.text);
    }
}
