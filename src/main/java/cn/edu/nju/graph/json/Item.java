package cn.edu.nju.graph.json;

import java.util.Objects;

/**
 * @className：Item
 * @version: 1.0.0
 * @description：物品
 * @author: Xin
 * @date: 2023-12-25 15:34:19
 */
public class Item {
    private String text;
    public Item(String text) {
        this.text = text;
    }

    /**
     * 相等
     *
     * @param obj 对象
     * @return boolean
     * @author: Xin
     * @date: 2023-12-25 15:34:46
     */
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

    /**
     * 散列码
     *
     * @return int
     * @author: Xin
     * @date: 2023-12-25 15:34:52
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.text);
    }
}
