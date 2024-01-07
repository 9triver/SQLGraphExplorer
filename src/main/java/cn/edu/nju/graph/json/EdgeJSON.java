package cn.edu.nju.graph.json;

import cn.edu.nju.graph.Graph;
import cn.edu.nju.graph.Node;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @className：EdgeJSON
 * @version: 1.0.0
 * @description：边json
 * @author: Xin
 * @date: 2023-12-25 15:33:09
 */
public class EdgeJSON {
    private final String source;
    private final String target;
    private final String value;

    /**
     * EdgeJSON构造函数
     *
     * @param source 来源
     * @param target 目标
     * @param value  价值
     * @author: Xin
     * @date: 2023-12-25 15:33:17
     */
    public EdgeJSON(String source, String target, String value) {
        this.source = source;
        this.target = target;
        this.value = value;
    }

    /**
     * 添加边
     *
     * @param src 源
     * @param dst 目标
     * @return {@link EdgeJSON }
     * @author: Xin
     * @date: 2024-01-07 18:41:03
     */
    public static EdgeJSON addEdge(Node src, Node dst) {
        return new EdgeJSON(
                String.valueOf(src.name.hashCode()),
                String.valueOf(dst.name.hashCode()),
                "");
    }

    /**
     * 添加表格
     *
     * @param table 表格
     * @return {@link Set }<{@link EdgeJSON }>
     * @author: Xin
     * @date: 2024-01-07 18:40:59
     */
    public static Set<EdgeJSON> addTable(Graph.Table table) {
        Set<EdgeJSON> ret = new HashSet<>();

        for(String columnName : table.columnNameMapper.keySet())
            ret.add(new EdgeJSON(
                    String.valueOf(table.tableName.hashCode()),
                    String.valueOf((table.tableName+":"+columnName).hashCode()),
                    ""));

        return ret;
    }

    /**
     * 等于
     *
     * @param o o
     * @return boolean
     * @author: Xin
     * @date: 2024-01-07 18:40:52
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EdgeJSON edgeJSON = (EdgeJSON) o;
        return Objects.equals(source, edgeJSON.source) && Objects.equals(target, edgeJSON.target) && Objects.equals(value, edgeJSON.value);
    }

    /**
     * 散列码
     *
     * @return int
     * @author: Xin
     * @date: 2024-01-07 18:40:55
     */
    @Override
    public int hashCode() {
        return Objects.hash(source, target, value);
    }
}
