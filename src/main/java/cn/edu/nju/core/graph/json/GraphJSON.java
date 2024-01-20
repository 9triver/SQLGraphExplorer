package cn.edu.nju.core.graph.json;

import cn.edu.nju.core.graph.Graph;
import cn.edu.nju.core.graph.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * @className：GraphJSON
 * @version: 1.0.0
 * @description：图json
 * @author: Xin
 * @date: 2023-12-25 15:33:32
 */
public class GraphJSON {
    private final Set<NodeJSON> nodes = new HashSet<>();
    private final Set<EdgeJSON> edges = new HashSet<>();

    /**
     * 添加表格
     *
     * @param table 表格
     * @author: Xin
     * @date: 2023-12-25 15:33:38
     */
    public void addTable(Graph.Table table) {
        this.nodes.addAll(NodeJSON.addTable(table));
        this.edges.addAll(EdgeJSON.addTable(table));
    }

    /**
     * 添加节点
     *
     * @param node 节点
     * @author: Xin
     * @date: 2023-12-25 15:33:41
     */
    public void addNode(Node node) {
        this.nodes.add(NodeJSON.addNode(node));
    }


    /**
     * 添加边
     *
     * @param srcNode 源节点
     * @param dstNode 目标节点
     * @author: Xin
     * @date: 2023-12-25 15:34:07
     */
    public void addEdge(Node srcNode, Node dstNode) {
        this.edges.add(EdgeJSON.addEdge(srcNode,dstNode));
    }
}
