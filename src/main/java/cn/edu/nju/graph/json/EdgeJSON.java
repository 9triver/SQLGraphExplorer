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
    private String source;
    private String target;
    private String value;

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

    public static EdgeJSON addEdge(Node src, Node dst) {
        return new EdgeJSON(
                String.valueOf(src.name.hashCode()),
                String.valueOf(dst.name.hashCode()),
                "");
    }
    public static Set<EdgeJSON> addTable(Graph.Table table) {
        Set<EdgeJSON> ret = new HashSet<>();

        for(String columnName : table.columnNameMapper.keySet())
            ret.add(new EdgeJSON(
                    String.valueOf(table.tableName.hashCode()),
                    String.valueOf((table.tableName+":"+columnName).hashCode()),
                    ""));

        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        //自反性
        if (this == obj) return true;
        //任何对象不等于null，比较是否为同一类型
        if (!(obj instanceof EdgeJSON)) return false;
        //强制类型转换
        EdgeJSON other = (EdgeJSON) obj;
        //比较属性值
        return this.source.equals(other.source) &&
                this.target.equals(other.target) &&
                this.value.equals(other.value);
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.source, this.target, this.value);
    }
}
