package cn.edu.nju.core.graph;

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
     * @param o o
     * @return boolean
     * @author: Xin
     * @date: 2024-01-07 18:43:53
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return nodeType == node.nodeType && Objects.equals(name, node.name);
    }

    /**
     * 散列码
     *
     * @return int
     * @author: Xin
     * @date: 2024-01-07 18:43:55
     */
    @Override
    public int hashCode() {
        return Objects.hash(nodeType, name);
    }
}
