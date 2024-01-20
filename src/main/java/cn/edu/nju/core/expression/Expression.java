package cn.edu.nju.core.expression;

import cn.edu.nju.core.expression.cktuple.CKTuple;
import cn.edu.nju.core.expression.cktuple.CKTuples;
import cn.edu.nju.core.expression.cktuple.Tuple;
import cn.edu.nju.core.expression.cktuple.constraint.Constraint;
import cn.edu.nju.core.graph.Graph.Table;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @className：Expression
 * @version: 1.0.0
 * @description：表达式
 * @author: Xin
 * @date: 2023-12-25 15:18:31
 */
public class Expression {
    private final OpType opType;
    private Expression expression1;
    private Expression expression2;
    private Table table;
    private Schema projectionSchema;
    private RenameMap renameMap;
    private Constraint selectionCondition;
    static Logger logger = Logger.getLogger(Expression.class);

    /**
     * Expression构造函数
     *
     * @param table 表
     * @author: Xin
     * @date: 2023-12-25 15:15:14
     */
    public Expression(Table table) {
        this.opType = OpType.ATOM;
        this.table = table;
    }

    /**
     * 表达式构造函数
     *
     * @param opType             op类型
     * @param selectionCondition 选择条件
     * @param projectionSchema   投影模式
     * @param renameMap          重命名地图
     * @param expressions        表达式
     * @author: Xin
     * @date: 2023-12-25 15:18:17
     */
    public Expression(OpType opType, Constraint selectionCondition, Schema projectionSchema, RenameMap renameMap,
            Expression... expressions) {
        this.opType = opType;
        if (expressions.length > 1)
            expression2 = expressions[1];
        if (expressions.length > 0)
            expression1 = expressions[0];

        if (opType == OpType.PROJECTION)
            this.projectionSchema = projectionSchema;
        if (opType == OpType.SELECTION)
            this.selectionCondition = selectionCondition;
        if (opType == OpType.RENAME)
            this.renameMap = renameMap;
    }

    /**
     * table表达式
     *
     * @param table 表格
     * @return {@link Expression }
     * @author: Xin
     * @date: 2023-12-25 15:18:36
     */
    public static Expression table(Table table) {
        return new Expression(table);
    }

    /**
     * selection 表达式: selection_{selectionCondition}(expression)
     *
     * @param selectionCondition 选择条件
     * @param expression         表达式
     * @return {@link Expression }
     * @author: Xin
     * @date: 2023-12-25 15:18:50
     */
    public static Expression selection(Constraint selectionCondition, Expression expression) {
        return new Expression(OpType.SELECTION, selectionCondition, null, null, expression);
    }

    /**
     * projection 表达式: projection_{projectionSchema}(expression)
     *
     * @param projectionSchema 投影模式
     * @param expression       表达式
     * @return {@link Expression }
     * @author: Xin
     * @date: 2023-12-25 15:19:03
     */
    public static Expression projection(Schema projectionSchema, Expression expression) {
        return new Expression(OpType.PROJECTION, null, projectionSchema, null, expression);
    }

    /**
     * rename 表达式: rename_{renameMap}(expression)
     *
     * @param renameMap  重命名地图
     * @param expression 表达式
     * @return {@link Expression }
     * @author: Xin
     * @date: 2023-12-25 15:21:16
     */
    public static Expression rename(RenameMap renameMap, Expression expression) {
        return new Expression(OpType.RENAME, null, null, renameMap, expression);
    }

    /**
     * union 表达式: expression1 union expression2
     *
     * @param expression1 表达式1
     * @param expression2 表达式2
     * @return {@link Expression }
     * @author: Xin
     * @date: 2023-12-25 15:22:40
     */
    public static Expression union(Expression expression1, Expression expression2) {
        return new Expression(OpType.UNION, null, null, null, expression1, expression2);
    }

    /**
     * expression1 intersection expression2
     *
     * @param expression1 表达式1
     * @param expression2 表达式2
     * @return {@link Expression }
     * @author: Xin
     * @date: 2023-12-25 15:22:59
     */
    public static Expression intersection(Expression expression1, Expression expression2) {
        return new Expression(OpType.INTERSECTION, null, null, null, expression1, expression2);
    }

    /**
     * expression1 production expression2
     *
     * @param expression1 表达式1
     * @param expression2 表达式2
     * @return {@link Expression }
     * @author: Xin
     * @date: 2023-12-25 15:23:16
     */
    public static Expression production(Expression expression1, Expression expression2) {
        return new Expression(OpType.CARTESIAN_PRODUCTION, null, null, null, expression1, expression2);
    }

    /**
     * 核心代码：求逆函数
     *
     * @param ckTuples ck元组
     * @return {@link CKTuples }
     * @author: Xin
     * @date: 2023-12-25 15:24:18
     */
    public CKTuples inverse(CKTuples ckTuples) {
        CKTuples result = switch (this.opType) {
            case ATOM -> CKTuples.atom(ckTuples);
            case SELECTION -> expression1.inverse(CKTuples.selection(ckTuples, this.selectionCondition));
            case PROJECTION -> expression1.inverse(CKTuples.extension(ckTuples, expression1.schema()));
            case CARTESIAN_PRODUCTION ->
                CKTuples.append(expression1.inverse(CKTuples.projection(ckTuples, expression1.schema())),
                        expression2.inverse(CKTuples.projection(ckTuples, expression2.schema())));
            case INTERSECTION -> CKTuples.append(expression1.inverse(ckTuples), expression2.inverse(ckTuples));
            case UNION -> CKTuples.completion(expression1.inverse(ckTuples), expression2.inverse(ckTuples));
            case RENAME -> expression1.inverse(CKTuples.rename(ckTuples, this.renameMap));
            case DIFFERENCE -> null;
        };

        assert result != null;
        logger.debug("opType: " + this.opType);
        logger.debug("size: " + result.size());
        List<List<String>> tableNames = new ArrayList<>();
        for (CKTuple ckTuple : result.getCkTuples()) {
            List<String> tmp = new ArrayList<>();
            for (Tuple tuple : ckTuple.getKTuple())
                tmp.add(tuple.getTable().tableName);
            tableNames.add(tmp);
        }
        logger.debug("tables: " + tableNames);
        return result;
    }

    /**
     * 获取表达式的模式
     *
     * @return {@link Schema }
     * @author: Xin
     * @date: 2023-12-25 15:24:50
     */
    public Schema schema() {
        Schema ret = new Schema();
        switch (this.opType) {
            case ATOM -> ret.add(this.table.allSchema());
            case SELECTION, INTERSECTION, UNION -> ret.add(this.expression1.schema());
            case PROJECTION -> ret.add(this.projectionSchema);
            case CARTESIAN_PRODUCTION -> {
                ret.add(this.expression1.schema());
                ret.add(this.expression2.schema());
            }
            default -> ret = new Schema();
        }
        return ret;
    }

    /**
     * 获取操作类型
     *
     * @return {@link OpType }
     * @author: Xin
     * @date: 2023-12-25 15:25:28
     */
    public OpType getOpType() {
        return opType;
    }

    /**
     * 获取表格
     *
     * @return {@link Table }
     * @author: Xin
     * @date: 2023-12-25 15:25:32
     */
    public Table getTable() {
        return table;
    }

    /**
     * 获取表达式1
     *
     * @return {@link Expression }
     * @author: Xin
     * @date: 2023-12-25 15:25:39
     */
    public Expression getExpression1() {
        return expression1;
    }

    /**
     * 获取表达式2
     *
     * @return {@link Expression }
     * @author: Xin
     * @date: 2023-12-25 15:25:42
     */
    public Expression getExpression2() {
        return expression2;
    }

    @Override
    public String toString() {
        return "Expression{" +
                "opType=" + opType +
                ", expression1=" + expression1 +
                ", expression2=" + expression2 +
                '}';
    }
}
