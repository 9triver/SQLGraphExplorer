package cn.edu.nju.graph;

import java.io.Serializable;
import java.util.Objects;

public class Node implements Serializable{
    public NodeType nodeType;
    public String name;

    public Node(NodeType nodeType, String name) {
        this.nodeType = nodeType;
        this.name = name;
    }

    public boolean isNode() {
        return this.nodeType != NodeType.TABLE && this.nodeType != NodeType.COLUMN;
    }

    @Override
    public boolean equals(Object obj) {
        //自反性
        if (this == obj) return true;
        //任何对象不等于null，比较是否为同一类型
        if (!(obj instanceof Node)) return false;
        //强制类型转换
        Node other = (Node) obj;
        //比较属性值
        return this.nodeType == other.nodeType && this.name.equals(other.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.nodeType, this.name);
    }
}
