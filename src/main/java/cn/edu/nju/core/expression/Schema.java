package cn.edu.nju.core.expression;

import cn.edu.nju.core.graph.Graph;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @className：Schema
 * @version: 1.0.0
 * @description：模式
 * @author: Xin
 * @date: 2023-12-25 15:30:43
 */
public class Schema {
    Set<Graph.Column> columns;
    Set<String> columnNames;

    /**
     * Schema构造函数
     *
     * @param columns 列
     * @author: Xin
     * @date: 2023-12-25 15:30:48
     */
    public Schema(Set<Graph.Column> columns) {
        this.columnNames = new HashSet<>();
        if (columns == null) {
            this.columns = new HashSet<>();
            return;
        }
        this.columns = columns;
        for (Graph.Column col : columns)
            this.columnNames.add(col.columnName);
    }

    /**
     * Schema默认构造函数
     *
     * @author: Xin
     * @date: 2023-12-25 15:30:58
     */
    public Schema() {
        this.columnNames = new HashSet<>();
        this.columns = new HashSet<>();
    }


    /**
     * 两个模式合并
     *
     * @param otherSchema 其他模式
     * @author: Xin
     * @date: 2023-12-25 15:31:28
     */
    public void add(Schema otherSchema) {
        this.columns.addAll(otherSchema.columns);
        this.columnNames.addAll(otherSchema.columnNames);
    }

    /**
     * 添加列到模式中
     *
     * @param columns 列
     * @author: Xin
     * @date: 2023-12-25 15:31:40
     */
    public void add(Graph.Column... columns) {
        Collections.addAll(this.columns, columns);
        for (Graph.Column col : columns)
            this.columnNames.add(col.columnName);
    }

    /**
     * 获取列
     *
     * @return {@link Set }<{@link Graph.Column }>
     * @author: Xin
     * @date: 2023-12-25 15:32:00
     */
    public Set<Graph.Column> getColumns() {
        return columns;
    }

    public Graph.Column getColumn(String columnName) {
        for (Graph.Column column : columns)
            if (column.columnName.equals(columnName))
                return column;
        return null;
    }

    /**
     * 获取列名称
     *
     * @return {@link Set }<{@link String }>
     * @author: Xin
     * @date: 2023-12-25 15:32:04
     */
    public Set<String> getColumnNames() {
        return columnNames;
    }

    /**
     * 包含列
     *
     * @param column 列
     * @return boolean
     * @author: Xin
     * @date: 2023-12-25 15:32:10
     */
    public boolean containColumn(Graph.Column column) {
        return this.columns.contains(column);
    }


    /**
     * 包含列名称
     *
     * @param column 列
     * @return boolean
     * @author: Xin
     * @date: 2023-12-25 15:32:33
     */
    public boolean containColumnName(Graph.Column column) {
        return this.columnNames.contains(column.columnName);
    }

    /**
     * 包含列名称
     *
     * @param columnName 列名称
     * @return boolean
     * @author: Xin
     * @date: 2023-12-25 15:32:36
     */
    public boolean containColumnName(String columnName) {
        return this.columnNames.contains(columnName);
    }

    /**
     * 是否为空
     *
     * @return boolean
     * @author: Xin
     * @date: 2023-12-25 15:32:41
     */
    public boolean isEmpty() {
        return this.columns.isEmpty();
    }

    /**
     * 等于
     *
     * @param o o
     * @return boolean
     * @author: Xin
     * @date: 2024-01-07 18:40:10
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schema schema = (Schema) o;
        return Objects.equals(columns, schema.columns) && Objects.equals(columnNames, schema.columnNames);
    }

    /**
     * 散列码
     *
     * @return int
     * @author: Xin
     * @date: 2024-01-07 18:40:14
     */
    @Override
    public int hashCode() {
        return Objects.hash(columns, columnNames);
    }

    /**
     * toString
     *
     * @return {@link String }
     * @author: Xin
     * @date: 2023-12-25 15:32:54
     */
    @Override
    public String toString() {
        return "Schema{" +
                "columns=" + columns +
                ", columnNames=" + columnNames +
                '}';
    }

    public int size() {
        return this.columns.size();
    }
}
