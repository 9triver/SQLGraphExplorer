package cn.edu.nju.expression.cktuple.tuple;

import cn.edu.nju.Tools.Tools;
import cn.edu.nju.graph.Graph;

import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;


public abstract class TupleBaseNode implements Serializable {
    protected Graph.Column columnScheme;

    public TupleBaseNode(Graph.Column column){
        this.columnScheme = column;
    }

    public TupleBaseNode setNewColumnScheme(Graph.Column columnScheme) {
        TupleBaseNode newTupleBaseNode = null;
        try {
            newTupleBaseNode = Tools.clone(this);
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        newTupleBaseNode.columnScheme = columnScheme;
        return newTupleBaseNode;
    }
    public String getColumnSchemeName() { return columnScheme.columnName; }

    public Graph.Column getColumnScheme() {
        return columnScheme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TupleBaseNode that = (TupleBaseNode) o;
        return Objects.equals(columnScheme, that.columnScheme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(columnScheme);
    }
}
