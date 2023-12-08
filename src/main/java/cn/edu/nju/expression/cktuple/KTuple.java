package cn.edu.nju.expression.cktuple;

import cn.edu.nju.expression.Scheme;
import cn.edu.nju.expression.cktuple.tuple.TupleBaseNode;
import cn.edu.nju.graph.Graph;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class KTuple {
    private Graph.Table table;
    private Set<TupleBaseNode> tuple;
    public KTuple(Graph.Table table) {
        this.table = table;
        this.tuple = new HashSet<>();
    }
    public KTuple(Graph.Table table, Set<TupleBaseNode> tuple) {
        this.table = table;
        this.tuple = tuple;
    }
    public KTuple addTupleNode(TupleBaseNode ... tuple) {
        Collections.addAll(this.tuple, tuple);
        return this;
    }

    public Set<Graph.Column> scheme() {
        Set<Graph.Column> ret = new HashSet<>();
        for(TupleBaseNode t : tuple)
            ret.add(t.getColumnScheme());
        return ret;
    }

    public Scheme allScheme() {
        Set<Graph.Column> ret = new HashSet<>();
        for(TupleBaseNode t : tuple)
            ret.add(t.getColumnScheme());
        return new Scheme(ret);
    }
    public Set<String> allSchemeName() {
        Set<String> ret = new HashSet<>();
        for(TupleBaseNode t : tuple)
            ret.add(t.getColumnSchemeName());
        return ret;
    }

    public Graph.Table getTable() {
        return table;
    }

    public Set<TupleBaseNode> getTuple() {
        return tuple;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KTuple kTuple = (KTuple) o;
        return Objects.equals(table, kTuple.table) && Objects.equals(tuple, kTuple.tuple);
    }

    @Override
    public int hashCode() {
        return Objects.hash(table, tuple);
    }
}
