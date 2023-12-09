package cn.edu.nju.expression;

import cn.edu.nju.graph.Graph;
import cn.edu.nju.graph.Node;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Scheme {
    Set<Graph.Column> columns;
    Set<String> columnNames;
    public Scheme(Set<Graph.Column> columns) {
        this.columnNames = new HashSet<>();
        if(columns == null) {
            this.columns=new HashSet<>();
            return;
        }
        this.columns = columns;
        for(Graph.Column col : columns)
            this.columnNames.add(col.columnName);
    }
    public Scheme() {
        this.columnNames = new HashSet<>();
        this.columns = new HashSet<>();
    }
    public void add(Scheme other) {
        this.columns.addAll(other.columns);
        this.columnNames.addAll(other.columnNames);
    }
    public void add(Graph.Column ... columns) {
        Collections.addAll(this.columns, columns);
        for(Graph.Column col : columns)
            this.columnNames.add(col.columnName);
    }

    public Set<Graph.Column> getColumns() {
        return columns;
    }
    public Graph.Column getColumn(String columnName) {
        for(Graph.Column column : columns)
            if(column.columnName.equals(columnName))
                return column;
        return null;
    }
    public Set<String> getColumnNames() {
        return columnNames;
    }
    public boolean containColumn(Graph.Column column) {
        return this.columns.contains(column);
    }
    public boolean constainColumnName(Graph.Column column) {
        return this.columnNames.contains(column.columnName);
    }
    public boolean constainColumnName(String columnName) {
        return this.columnNames.contains(columnName);
    }

    @Override
    public boolean equals(Object obj) {
        //自反性
        if (this == obj) return true;
        //任何对象不等于null，比较是否为同一类型
        if (!(obj instanceof Scheme)) return false;
        //强制类型转换
        Scheme other = (Scheme) obj;
        //比较属性值
        return this.columns.equals(other.columns) && this.columnNames.equals(other.columnNames);
    }

    @Override
    public String toString() {
        return "Scheme{" +
                "columns=" + columns +
                ", columnNames=" + columnNames +
                '}';
    }
}
