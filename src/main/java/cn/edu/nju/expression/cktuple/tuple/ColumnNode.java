package cn.edu.nju.expression.cktuple.tuple;

import cn.edu.nju.graph.Graph;

import java.util.Objects;

/**
 * @className：ColumnNode
 * @version: 1.0.0
 * @description： Tuple的列节点
 * @author: Xin
 * @date: 2023-12-25 15:04:21
 */
public class ColumnNode extends TupleBaseNode {
    protected Graph.Column column;


    /**
     * ColumnNode构造函数
     *
     * @param columnSchema 列模式
     * @param column       列
     * @author: Xin
     * @date: 2023-12-25 15:04:23
     */
    public ColumnNode(Graph.Column columnSchema, Graph.Column column) {
        super(columnSchema);
        this.column = column;
    }

    /**
     * 获取列
     *
     * @return {@link Graph.Column }
     * @author: Xin
     * @date: 2023-12-25 15:04:26
     */
    public Graph.Column getColumn() {
        return this.column;
    }


    /**
     * 等于
     *
     * @param o o
     * @return boolean
     * @author: Xin
     * @date: 2023-12-25 15:04:29
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        ColumnNode that = (ColumnNode) o;
        return Objects.equals(column, that.column);
    }

    /**
     * 散列码
     *
     * @return int
     * @author: Xin
     * @date: 2023-12-25 15:04:32
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), column);
    }
}
