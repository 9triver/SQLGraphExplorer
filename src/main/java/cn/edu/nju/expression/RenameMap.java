package cn.edu.nju.expression;

import cn.edu.nju.expression.cktuple.tuple.TupleBaseNode;
import cn.edu.nju.graph.Graph;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class RenameMap {
    private BiMap<Graph.Column, Graph.Column> maps = HashBiMap.create();
    public void add(Graph.Column src, Graph.Column dst) {
        maps.put(src, dst);
    }

    public Graph.Column getDst(Graph.Column src) {
        return maps.get(src);
    }

    public Graph.Column getSrc(Graph.Column dst) {
        return maps.inverse().get(dst);
    }

    public boolean isEmpty() {
        return this.maps.isEmpty();
    }
    @Override
    public String toString() {
        return "RenameMap{" +
                "maps=" + maps +
                '}';
    }
}
