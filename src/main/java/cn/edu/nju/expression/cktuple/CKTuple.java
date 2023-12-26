package cn.edu.nju.expression.cktuple;

import cn.edu.nju.expression.RenameMap;
import cn.edu.nju.expression.Schema;
import cn.edu.nju.expression.cktuple.constraint.Constraint;
import cn.edu.nju.expression.cktuple.tuple.ColumnNode;
import cn.edu.nju.expression.cktuple.tuple.TupleBaseNode;
import cn.edu.nju.graph.Graph;
import cn.edu.nju.tools.Tools;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * @className：CKTuple
 * @version: 1.0.0
 * @description： cktuple
 * @author: Xin
 * @date: 2023-12-25 15:05:35
 */
public class CKTuple {
    public static Logger logger = Logger.getLogger(CKTuple.class);
    private final KTuple kTuple;
    private final Constraint constraint;

    /**
     * cktuple复制构造函数
     *
     * @param ckTuple ck元组
     * @author: Xin
     * @date: 2023-12-25 15:05:48
     */
    public CKTuple(CKTuple ckTuple) {
        this.kTuple = ckTuple.kTuple;
        this.constraint = ckTuple.constraint;
    }

    /**
     * cktuple构造函数
     *
     * @param kTuple     k元组
     * @param constraint 限制
     * @author: Xin
     * @date: 2023-12-25 15:05:51
     */
    public CKTuple(KTuple kTuple, Constraint constraint) {
        this.kTuple = kTuple;
        this.constraint = constraint;
    }


    /**
     * rename运算
     *
     * @param ckTuple   ck元组
     * @param renameMap 重命名地图
     * @return {@link CKTuple }
     * @author: Xin
     * @date: 2023-12-25 15:05:56
     */
    public static CKTuple rename(CKTuple ckTuple, RenameMap renameMap) {
        Constraint constraint = ckTuple.constraint;
        Set<TupleBaseNode> tuple = ckTuple.kTuple.getTuple();
        Graph.Table table = ckTuple.kTuple.getTable();
        Set<TupleBaseNode> results = new HashSet<>();

        for (TupleBaseNode t : tuple) {
            Graph.Column srcSchema = renameMap.getSrc(t.getColumnSchema());
            if (srcSchema != null)
                results.add(t.setNewColumnSchema(srcSchema));
        }

        return new CKTuple(new KTuple(table, results), constraint);
    }

    /**
     * projection运算
     *
     * @param ckTuple        ck元组
     * @param relationSchema 关系模式
     * @return {@link CKTuple }
     * @author: Xin
     * @date: 2023-12-25 15:06:00
     */
    public static CKTuple projection(CKTuple ckTuple, Schema relationSchema) {
        Constraint constraint = ckTuple.constraint;
        Set<TupleBaseNode> tuple = ckTuple.kTuple.getTuple();
        Graph.Table table = ckTuple.kTuple.getTable();
        Set<TupleBaseNode> results = new HashSet<>();

        for (TupleBaseNode t : tuple) {
            if (relationSchema.containColumn(t.getColumnSchema()))
                results.add(t);
        }
        return new CKTuple(new KTuple(table, results), constraint);
    }

    /**
     * extension运算
     *
     * @param ckTuple        ck元组
     * @param relationSchema 关系模式
     * @return {@link CKTuple }
     * @author: Xin
     * @date: 2023-12-25 15:06:04
     */
    public static CKTuple extension(CKTuple ckTuple, Schema relationSchema) {
        Constraint constraint = ckTuple.constraint;
        Set<TupleBaseNode> tuple = ckTuple.kTuple.getTuple();
        Graph.Table table = ckTuple.kTuple.getTable();
        Set<TupleBaseNode> results = new HashSet<>();

        for (Graph.Column s : relationSchema.getColumns()) {
            boolean exist = false;
            for (TupleBaseNode t : tuple) {
                if (t.getColumnSchemaName().equals(s.columnName)) {
                    exist = true;
                    results.add(t.setNewColumnSchema(s));
                    break;
                }
            }
            if (!exist)
                results.add(new ColumnNode(s, s));
        }

        return new CKTuple(new KTuple(table, results), constraint);
    }


    /**
     * append运算
     *
     * @param ckTuple1 ck元组1
     * @param ckTuple2 ck元组2
     * @return {@link List }<{@link CKTuple }>
     * @author: Xin
     * @date: 2023-12-25 15:06:08
     */
    public static List<CKTuple> append(CKTuple ckTuple1, CKTuple ckTuple2) {
        List<CKTuple> ret = new ArrayList<>();
        ret.add(new CKTuple(ckTuple1.kTuple, Constraint.and(ckTuple1.constraint, ckTuple2.constraint)));
        ret.add(new CKTuple(ckTuple2.kTuple, Constraint.and(ckTuple1.constraint, ckTuple2.constraint)));
        return ret;
    }

    /**
     * ckTuple and constraint
     *
     * @param ckTuple    ck元组
     * @param constraint 限制
     * @return {@link CKTuple }
     * @author: Xin
     * @date: 2023-12-25 15:06:11
     */
    public static CKTuple andConstraint(CKTuple ckTuple, Constraint constraint) {
        return new CKTuple(ckTuple.kTuple, Constraint.and(ckTuple.constraint, constraint));
    }

    /**
     * atom运算
     *
     * @param ckTuple ck元组
     * @return {@link CKTuple }
     * @author: Xin
     * @date: 2023-12-25 15:06:17
     */
    public static CKTuple atom(CKTuple ckTuple) {
        Set<TupleBaseNode> tuple = ckTuple.kTuple.getTuple();
        Graph.Table targetTable = tuple.iterator().next().getColumnSchema().table;
        return new CKTuple(new KTuple(targetTable, tuple), ckTuple.constraint);
    }

    /**
     * 简化约束
     *
     * @author: Xin
     * @date: 2023-12-25 15:06:19
     */
    public void simplifyConstraint() {
        this.constraint.simplify(this.kTuple.getTable());
    }

    Map<String, String> parameters = new HashMap<>();

    /**
     * CKTuple -> Relational Algebra -> Sql
     *
     * @return {@link String }
     * @author: Xin
     * @date: 2023-12-25 15:06:25
     */
    public String toSql() {
        // TODO : CKTuple -> sql
        StringBuilder buf = new StringBuilder();
        String procedureName = "INVERSE_" + this.kTuple.getTable().tableName;
        String procedureBody = Tools.translateFromRA2Sql(this.toRA());
        buf.append("CREATE OR REPLACE PROCEDURE ").append(procedureName).append("(\n");
        for (String key : parameters.keySet()) {
            String value = parameters.get(key);
            buf.append(value).append(" IN VARCHAR2(255),\n");
            procedureBody = procedureBody.replaceAll(key, value);
        }
        buf.delete(buf.length() - ",\n".length(), buf.length());
        buf.append("\n) IS\nBEGIN\n").append(procedureBody).append("\nEND ").append(procedureName).append(";");
        return buf.toString();
    }

    /**
     * CKTuple -> Relational Algebra
     *
     * @return {@link String }
     * @author: Xin
     * @date: 2023-12-25 15:06:49
     */
    private String toRA() {
        this.parameters.clear();
        StringBuilder ra = new StringBuilder(),
                matchCondition = new StringBuilder(),
                projectionList = new StringBuilder();
        Graph.Table srcTable = this.kTuple.getTable();
        Set<TupleBaseNode> tuple = this.kTuple.getTuple();
        for (TupleBaseNode node : tuple) {
            if (node instanceof ColumnNode columnNode) {
                String fullColumnName = columnNode.getColumn().toString();
                String fullColumnSchemaName = columnNode.getColumnSchema().toString();

                projectionList.append(fullColumnSchemaName).append(",");
                if (fullColumnName.equals(fullColumnSchemaName))
                    continue;
                parameters.put(fullColumnName, "PARA_" + columnNode.getColumn().columnName);
                matchCondition.append(fullColumnSchemaName).append("=").append(fullColumnName).append(" AND ");
            }
        }
        if (matchCondition.isEmpty())
            return null;

        matchCondition.delete(matchCondition.length() - " AND ".length(), matchCondition.length());
        projectionList.delete(projectionList.length() - 1, projectionList.length());
        matchCondition.insert(0, "(").append(")");
        projectionList.insert(0, "[").append("]");

        Constraint combinedConstraint = Constraint.and(new Constraint(matchCondition.toString()), this.constraint);
        logger.info("combinedConstraint: " + combinedConstraint);
        return ra.append("project").append(projectionList).append("(select[").append(combinedConstraint).append("](")
                .append(srcTable.toString()).append("));").toString();
    }

    /**
     * 获取ktuple
     *
     * @return {@link KTuple }
     * @author: Xin
     * @date: 2023-12-25 15:07:16
     */
    public KTuple getKTuple() {
        return kTuple;
    }

    /**
     * 获取约束
     *
     * @return {@link Constraint }
     * @author: Xin
     * @date: 2023-12-25 15:07:27
     */
    public Constraint getConstraint() {
        return constraint;
    }
}
