package cn.edu.nju.update.viewUpdate;

import cn.edu.nju.expression.Expression;
import cn.edu.nju.expression.cktuple.KTuple;
import cn.edu.nju.expression.cktuple.tuple.TupleBaseNode;
import cn.edu.nju.graph.Graph;
import cn.edu.nju.update.UpdateType;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ViewUpdate {
    private UpdateType updateType;
    private KTuple kTuple;
    private Expression expression;

    /**
     * 视图更新(ViewUpdate)构造函数
     *
     * @param updateType 更新类型
     * @param kTuple     k元组
     * @param expression 表达式
     * @author: Xin
     * @date: 2024-01-02 21:18:34
     */
    public ViewUpdate(UpdateType updateType, KTuple kTuple, Expression expression) {
        this.updateType = updateType;
        this.kTuple = kTuple;
        this.expression = expression;
    }

    /**
     * 视图更新(ViewUpdate)构造函数
     *
     * @param updateType     更新类型
     * @param expression     表达式
     * @param targetTable    目标表格
     * @param tupleBaseNodes 元组基础节点
     * @author: Xin
     * @date: 2024-01-02 21:18:39
     */
    public ViewUpdate(UpdateType updateType, Expression expression, Graph.Table targetTable, TupleBaseNode... tupleBaseNodes) {
        this.updateType = updateType;
        this.kTuple = new KTuple(targetTable, tupleBaseNodes);
        this.expression = expression;
    }

    /**
     * 获取更新类型
     *
     * @return {@link UpdateType }
     * @author: Xin
     * @date: 2024-01-02 21:10:20
     */
    public UpdateType getUpdateType() {
        return updateType;
    }

    /**
     * 获取K-元组
     *
     * @return {@link KTuple }
     * @author: Xin
     * @date: 2024-01-02 21:20:24
     */
    public KTuple getkTuple() {
        return kTuple;
    }

    /**
     * 获取表达式
     *
     * @return {@link Expression }
     * @author: Xin
     * @date: 2024-01-02 21:10:26
     */
    public Expression getExpression() {
        return expression;
    }
}
