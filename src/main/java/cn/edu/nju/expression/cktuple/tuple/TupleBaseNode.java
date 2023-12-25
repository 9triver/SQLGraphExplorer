package cn.edu.nju.expression.cktuple.tuple;

import cn.edu.nju.tools.Tools;
import cn.edu.nju.graph.Graph;

import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

/**
 * @className：TupleBaseNode
 * @version: 1.0.0
 * @description： 元组的基节点
 * @author: Xin
 * @date: 2023-12-25 15:04:49
 */
public abstract class TupleBaseNode implements Serializable {
    protected Graph.Column columnSchema;

    /**
     * 元组基节点构造函数
     *
     * @param column 列
     * @author: Xin
     * @date: 2023-12-25 15:05:04
     */
    public TupleBaseNode(Graph.Column column) {
        this.columnSchema = column;
    }

    /**
     * 设置列的新模式
     *
     * @param columnSchema 列模式
     * @return {@link TupleBaseNode }
     * @author: Xin
     * @date: 2023-12-25 15:05:09
     */
    public TupleBaseNode setNewColumnSchema(Graph.Column columnSchema) {
        TupleBaseNode newTupleBaseNode = null;
        try {
            newTupleBaseNode = Tools.clone(this);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        newTupleBaseNode.columnSchema = columnSchema;
        return newTupleBaseNode;
    }

    /**
     * 获取列模式的名称
     *
     * @return {@link String }
     * @author: Xin
     * @date: 2023-12-25 15:05:12
     */
    public String getColumnSchemaName() {
        return columnSchema.columnName;
    }

    /**
     * 获取列模式
     *
     * @return {@link Graph.Column }
     * @author: Xin
     * @date: 2023-12-25 15:05:15
     */
    public Graph.Column getColumnSchema() {
        return columnSchema;
    }

    /**
     * 等于
     *
     * @param o o
     * @return boolean
     * @author: Xin
     * @date: 2023-12-25 15:05:17
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        TupleBaseNode that = (TupleBaseNode) o;
        return Objects.equals(columnSchema, that.columnSchema);
    }

    /**
     * 散列码
     *
     * @return int
     * @author: Xin
     * @date: 2023-12-25 15:05:24
     */
    @Override
    public int hashCode() {
        return Objects.hash(columnSchema);
    }
}
