package cn.edu.nju.update.viewUpdate;

import cn.edu.nju.expression.Expression;
import cn.edu.nju.expression.cktuple.Tuple;
import cn.edu.nju.expression.cktuple.tuple.TupleBaseNode;
import cn.edu.nju.graph.Graph;
import cn.edu.nju.update.UpdateType;

public class ViewUpdate {
    private final UpdateType updateType;
    private final Tuple tuple;
    private final Expression expression;

    /**
     * 视图更新(ViewUpdate)构造函数
     *
     * @param updateType 更新类型
     * @param tuple      k元组
     * @param expression 表达式
     * @author: Xin
     * @date: 2024-01-02 21:18:34
     */
    public ViewUpdate(UpdateType updateType, Tuple tuple, Expression expression) {
        this.updateType = updateType;
        this.tuple = tuple;
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
    public ViewUpdate(UpdateType updateType, Expression expression, Graph.Table targetTable,
            TupleBaseNode... tupleBaseNodes) {
        this.updateType = updateType;
        this.tuple = new Tuple(targetTable, tupleBaseNodes);
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
     * @return {@link Tuple }
     * @author: Xin
     * @date: 2024-01-02 21:20:24
     */
    public Tuple getkTuple() {
        return tuple;
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
