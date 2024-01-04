package cn.edu.nju.expression.cktuple;

import cn.edu.nju.expression.Schema;
import cn.edu.nju.expression.cktuple.tuple.TupleBaseNode;
import cn.edu.nju.graph.Graph;
import cn.edu.nju.tools.Tools;
import org.checkerframework.checker.units.qual.K;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @className：KTuple
 * @version: 1.0.0
 * @description：K-元组
 * @author: Xin
 * @date: 2023-12-25 15:12:22
 */
public class KTuple implements Serializable {
    private Graph.Table table;
    private Set<TupleBaseNode> tuple;

    /**
     * KTuple构造函数
     *
     * @param table 表
     * @author: Xin
     * @date: 2023-12-25 15:12:25
     */
    public KTuple(Graph.Table table) {
        this.table = table;
        this.tuple = new HashSet<>();
    }

    /**
     * KTuple构造函数
     *
     * @param table 表
     * @param tuple 元组
     * @author: Xin
     * @date: 2023-12-25 15:12:40
     */
    public KTuple(Graph.Table table, Set<TupleBaseNode> tuple) {
        this.table = table;
        this.tuple = tuple;
    }


    /**
     * KTuple构造函数
     *
     * @param table          表格
     * @param tupleBaseNodes 元组基础节点
     * @author: Xin
     * @date: 2024-01-02 21:19:33
     */
    public KTuple(Graph.Table table, TupleBaseNode... tupleBaseNodes) {
        this.table = table;
        this.tuple = Arrays.stream(tupleBaseNodes).collect(Collectors.toSet());
    }

    /**
     * 添加元组节点
     *
     * @param tupleBaseNodes 元组基节点
     * @return {@link KTuple }
     * @author: Xin
     * @date: 2023-12-25 15:13:19
     */
    public KTuple addTupleNode(TupleBaseNode... tupleBaseNodes) {
        Collections.addAll(this.tuple, tupleBaseNodes);
        return this;
    }

    /**
     * 获取kTuple的模式
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
     * 获取kTuple的全模式
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
     * 获取kTuple的全模式名
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
        for(TupleBaseNode tupleBaseNode : tuple)
            if(!tupleBaseNode.isEmpty())
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
        KTuple kTuple = (KTuple) o;
        return Objects.equals(table, kTuple.table) && Objects.equals(tuple, kTuple.tuple);
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
