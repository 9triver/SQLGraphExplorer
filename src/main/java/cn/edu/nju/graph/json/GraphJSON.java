package cn.edu.nju.graph.json;

import cn.edu.nju.graph.Graph;
import cn.edu.nju.graph.Node;

import java.util.HashSet;
import java.util.Set;

public class GraphJSON {
    private Set<NodeJSON> nodes = new HashSet<>();
    private Set<EdgeJSON> edges = new HashSet<>();
    public void addTable(Graph.Table table) {
        this.nodes.addAll(NodeJSON.addTable(table));
        this.edges.addAll(EdgeJSON.addTable(table));
    }
    public void addNode(Node node) {
        this.nodes.add(NodeJSON.addNode(node));
    }
    public void addEdge(Node src, Node dst) {
        this.edges.add(EdgeJSON.addEdge(src,dst));
    }
}
