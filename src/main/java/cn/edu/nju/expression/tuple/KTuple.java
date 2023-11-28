package cn.edu.nju.expression.tuple;

import cn.edu.nju.graph.Graph;
import org.checkerframework.checker.units.qual.C;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KTuple {
    private Graph.Table table;
    private Set<Graph.Column> columns;
    public KTuple(Set<Graph.Column> columns) {
        if(columns == null || columns.isEmpty()) return ;
        this.columns = columns;
        this.table = columns.iterator().next().table;
    }
    public Set<Graph.Column> scheme() {
        return columns;
    }
    public Set<Graph.Column> allScheme() {
        Set<Graph.Column> ret = new HashSet<>();
        for(Map.Entry<String, Graph.Column> entry : this.table.columnNameMapper.entrySet())
            ret.add(entry.getValue());
        return ret;
    }

    public Graph.Table getTable() {
        return table;
    }
}
