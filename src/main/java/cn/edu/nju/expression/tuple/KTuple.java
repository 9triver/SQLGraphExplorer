package cn.edu.nju.expression.tuple;

import cn.edu.nju.graph.Graph;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KTuple {
    private Graph.Table table;
    private Set<Graph.Column> columns;

    public KTuple(Set<Graph.Column> columns) {
        if (columns == null || columns.isEmpty())
            return;
        this.columns = columns;
        this.table = columns.iterator().next().table;
    }

    public Set<Graph.Column> scheme() {
        return columns;
    }

    public Set<Graph.Column> allScheme() {
        return this.table.allScheme();
    }

    public Graph.Table getTable() {
        return table;
    }
}
