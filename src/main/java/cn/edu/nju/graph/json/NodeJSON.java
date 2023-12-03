package cn.edu.nju.graph.json;

import cn.edu.nju.graph.Graph;
import cn.edu.nju.graph.Node;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class NodeJSON {
    private String id;
    private Value value;

    public NodeJSON(String id, String title, String ...texts) {
        this.id = id;
        this.value = new Value(title, texts);
    }

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
    public static NodeJSON addNode(Node node) {
        return new NodeJSON(
                String.valueOf(node.name.hashCode()),
                node.nodeType.toString(),
                node.name
        );
    }

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
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.value);
    }
}
