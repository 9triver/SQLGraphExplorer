package cn.edu.nju.graph.json;

import cn.edu.nju.graph.Graph;
import cn.edu.nju.graph.Node;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @className：NodeJSON
 * @version: 1.0.0
 * @description：节点json
 * @author: Xin
 * @date: 2023-12-25 15:35:21
 */
public class NodeJSON {
    private String id;
    private Value value;

    /**
     * NodeJSON构造函数
     *
     * @param id    id
     * @param title 标题
     * @param texts 文本
     * @author: Xin
     * @date: 2023-12-25 15:35:01
     */
    public NodeJSON(String id, String title, String ...texts) {
        this.id = id;
        this.value = new Value(title, texts);
    }

    /**
     * 添加表格
     *
     * @param table 表格
     * @return {@link Set }<{@link NodeJSON }>
     * @author: Xin
     * @date: 2023-12-25 15:35:09
     */
    public static Set<NodeJSON> addTable(Graph.Table table) {
        Set<NodeJSON> ret = new HashSet<>();
        ret.add(new NodeJSON(
                String.valueOf(table.tableName.hashCode()),
                table.tableName,
                table.columnNameMapper.keySet().toArray(new String[0])));

        for(String columnName : table.columnNameMapper.keySet())
            ret.add(new NodeJSON(
                    String.valueOf((table.tableName+":"+columnName).hashCode()),
                    columnName,
                    ""));

        return ret;
    }

    /**
     * 添加节点
     *
     * @param node 节点
     * @return {@link NodeJSON }
     * @author: Xin
     * @date: 2023-12-25 15:35:24
     */
    public static NodeJSON addNode(Node node) {
        return new NodeJSON(
                String.valueOf(node.name.hashCode()),
                node.nodeType.toString(),
                node.name
        );
    }

    /**
     * 等于
     *
     * @param obj 对象
     * @return boolean
     * @author: Xin
     * @date: 2023-12-25 15:35:26
     */
    @Override
    public boolean equals(Object obj) {
        //自反性
        if (this == obj) return true;
        //任何对象不等于null，比较是否为同一类型
        if (!(obj instanceof NodeJSON)) return false;
        //强制类型转换
        NodeJSON other = (NodeJSON) obj;
        //比较属性值
        return this.id.equals(other.id) &&
                this.value.equals(other.value);
    }

    /**
     * 散列码
     *
     * @return int
     * @author: Xin
     * @date: 2023-12-25 15:35:28
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.value);
    }
}
