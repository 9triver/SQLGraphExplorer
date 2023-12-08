package cn.edu.nju.expression.cktuple.tuple;

import cn.edu.nju.graph.Graph;

import java.util.Objects;

public class ColumnNode extends TupleBaseNode{
    protected Graph.Column column;
    public ColumnNode(Graph.Column columnScheme, Graph.Column column) {
        super(columnScheme);
        this.column = column;
    }

    public Graph.Column getColumn() {
        return this.column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ColumnNode that = (ColumnNode) o;
        return Objects.equals(column, that.column);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), column);
    }
}
