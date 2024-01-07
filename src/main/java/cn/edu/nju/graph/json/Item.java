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
    private final String text;
    public Item(String text) {
        this.text = text;
    }

    /**
     * 等于
     *
     * @param o o
     * @return boolean
     * @author: Xin
     * @date: 2024-01-07 18:42:03
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(text, item.text);
    }

    /**
     * 散列码
     *
     * @return int
     * @author: Xin
     * @date: 2024-01-07 18:42:05
     */
    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
