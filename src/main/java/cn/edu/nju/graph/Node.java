package cn.edu.nju.graph;

import java.io.Serializable;
import java.util.Objects;

/**
 * @className：Node
 * @version: 1.0.0
 * @description：节点
 * @author: Xin
 * @date: 2023-12-25 15:49:01
 */
public class Node implements Serializable{
    public NodeType nodeType;
    public String name;

    /**
     * Node构造函数
     *
     * @param nodeType 节点类型
     * @param name     名
     * @author: Xin
     * @date: 2023-12-25 15:49:04
     */
    public Node(NodeType nodeType, String name) {
        this.nodeType = nodeType;
        this.name = name;
    }

    /**
     * 是否是中间节点
     *
     * @return boolean
     * @author: Xin
     * @date: 2023-12-25 15:49:11
     */
    public boolean isNode() {
        return this.nodeType != NodeType.TABLE && this.nodeType != NodeType.COLUMN;
    }

    /**
     * 等于
     *
     * @param obj 对象
     * @return boolean
     * @author: Xin
     * @date: 2023-12-25 15:49:16
     */
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

    /**
     * 散列码
     *
     * @return int
     * @author: Xin
     * @date: 2023-12-25 15:49:22
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.nodeType, this.name);
    }
}
