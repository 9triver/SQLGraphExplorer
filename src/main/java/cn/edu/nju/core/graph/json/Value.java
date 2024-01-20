package cn.edu.nju.core.graph.json;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @className：Value
 * @version: 1.0.0
 * @description：值
 * @author: Xin
 * @date: 2023-12-25 15:35:33
 */
public class Value {
    private final String title;
    private final List<Item> items;

    /**
     * Value构造函数
     *
     * @param title 标题
     * @param texts 文本
     * @author: Xin
     * @date: 2023-12-25 15:35:38
     */
    public Value(String title, String... texts) {
        this.title = title;
        this.items = new ArrayList<>();
        for(String text : texts)
            this.items.add(new Item(text));
    }

    /**
     * 等于
     *
     * @param o o
     * @return boolean
     * @author: Xin
     * @date: 2024-01-07 18:43:09
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Value value = (Value) o;
        return Objects.equals(title, value.title) && Objects.equals(items, value.items);
    }

    /**
     * 散列码
     *
     * @return int
     * @author: Xin
     * @date: 2024-01-07 18:43:13
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, items);
    }
}
