package cn.edu.nju.core.expression.cktuple;

import cn.edu.nju.core.expression.Schema;
import cn.edu.nju.core.expression.cktuple.tuple.TupleBaseNode;
import cn.edu.nju.core.graph.Graph;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @className：Tuple
 * @version: 1.0.0
 * @description：元组
 * @author: Xin
 * @date: 2023-12-25 15:12:22
 */
public class Tuple implements Serializable {
    private final Graph.Table table;
    private final Set<TupleBaseNode> tuple;

    /**
     * Tuple构造函数
     *
     * @param table 表
     * @author: Xin
     * @date: 2023-12-25 15:12:25
     */
    public Tuple(Graph.Table table) {
        this.table = table;
        this.tuple = new HashSet<>();
    }

    /**
     * Tuple构造函数
     *
     * @param table 表
     * @param tuple 元组
     * @author: Xin
     * @date: 2023-12-25 15:12:40
     */
    public Tuple(Graph.Table table, Set<TupleBaseNode> tuple) {
        this.table = table;
        this.tuple = tuple;
    }

    /**
     * Tuple构造函数
     *
     * @param table          表格
     * @param tupleBaseNodes 元组基础节点
     * @author: Xin
     * @date: 2024-01-02 21:19:33
     */
    public Tuple(Graph.Table table, TupleBaseNode... tupleBaseNodes) {
        this.table = table;
        this.tuple = Arrays.stream(tupleBaseNodes).collect(Collectors.toSet());
    }

    /**
     * 添加元组节点
     *
     * @param tupleBaseNodes 元组基节点
     * @return {@link Tuple }
     * @author: Xin
     * @date: 2023-12-25 15:13:19
     */
    public Tuple addTupleNode(TupleBaseNode... tupleBaseNodes) {
        Collections.addAll(this.tuple, tupleBaseNodes);
        return this;
    }

    /**
     * 获取tuple的模式
     *
     * @return {@link Set }<{@link Graph.Column }>
     * @author: Xin
     * @date: 2023-12-25 15:13:26
     */
    public Set<Graph.Column> schema() {
        Set<Graph.Column> ret = new HashSet<>();
        for (TupleBaseNode t : tuple)
            ret.add(t.getColumnSchema());
        return ret;
    }

    /**
     * 获取tuple的全模式
     *
     * @return {@link Schema }
     * @author: Xin
     * @date: 2023-12-25 15:14:19
     */
    public Schema allSchema() {
        Set<Graph.Column> ret = new HashSet<>();
        for (TupleBaseNode t : tuple)
            ret.add(t.getColumnSchema());
        return new Schema(ret);
    }

    /**
     * 获取tuple的全模式名
     *
     * @return {@link Set }<{@link String }>
     * @author: Xin
     * @date: 2023-12-25 15:14:40
     */
    public Set<String> allSchemaName() {
        Set<String> ret = new HashSet<>();
        for (TupleBaseNode t : tuple)
            ret.add(t.getColumnSchemaName());
        return ret;
    }

    /**
     * 获取表格
     *
     * @return {@link Graph.Table }
     * @author: Xin
     * @date: 2023-12-25 15:14:51
     */
    public Graph.Table getTable() {
        return table;
    }

    /**
     * 获取元组
     *
     * @return {@link Set }<{@link TupleBaseNode }>
     * @author: Xin
     * @date: 2023-12-25 15:14:54
     */
    public Set<TupleBaseNode> getTuple() {
        return tuple;
    }

    /**
     * 是否为空
     *
     * @return boolean
     * @author: Xin
     * @date: 2024-01-04 20:28:42
     */
    public boolean isEmpty() {
        for (TupleBaseNode tupleBaseNode : tuple)
            if (!tupleBaseNode.isEmpty())
                return false;
        return true;
    }

    /**
     * 等于
     *
     * @param o o
     * @return boolean
     * @author: Xin
     * @date: 2023-12-25 15:14:57
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Tuple otherTuple = (Tuple) o;
        return Objects.equals(table, otherTuple.table) && Objects.equals(tuple, otherTuple.tuple);
    }

    /**
     * 散列码
     *
     * @return int
     * @author: Xin
     * @date: 2023-12-25 15:14:59
     */
    @Override
    public int hashCode() {
        return Objects.hash(table, tuple);
    }
}
