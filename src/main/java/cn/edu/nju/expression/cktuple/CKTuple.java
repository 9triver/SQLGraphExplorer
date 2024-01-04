package cn.edu.nju.expression.cktuple;

import cn.edu.nju.expression.RenameMap;
import cn.edu.nju.expression.Schema;
import cn.edu.nju.expression.cktuple.constraint.Constraint;
import cn.edu.nju.expression.cktuple.tuple.ColumnNode;
import cn.edu.nju.expression.cktuple.tuple.TupleBaseNode;
import cn.edu.nju.graph.Graph;
import cn.edu.nju.tools.Tools;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.*;

/**
 * @className：CKTuple
 * @version: 1.0.0
 * @description：cktuple
 * @author: Xin
 * @date: 2024-01-04 16:02:48
 */
public class CKTuple {
    public static Logger logger = Logger.getLogger(CKTuple.class);
    private List<KTuple> kTuples = new ArrayList<>();
    private Map<KTuple,Constraint> constraints = new HashMap<>();
    private Constraint mainConstraint;

    /**
     * cktuple复制构造函数
     *
     * @param other ck元组
     * @author: Xin
     * @date: 2023-12-25 15:05:48
     */
    public CKTuple(CKTuple other) {
        try {
            for(KTuple kTuple : other.kTuples)
                this.kTuples.add(Tools.clone(kTuple));
            this.mainConstraint = Tools.clone(other.mainConstraint);
            for(Map.Entry<KTuple, Constraint> entry : other.constraints.entrySet()) {
                KTuple key = entry.getKey();
                Constraint value = entry.getValue();
                this.constraints.put(Tools.clone(key),Tools.clone(value));
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * cktuple构造函数
     *
     * @param kTuples     k元组
     * @param mainConstraint 主限制
     * @author: Xin
     * @date: 2023-12-25 15:05:51
     */
    public CKTuple(List<KTuple> kTuples, Constraint mainConstraint) {
        this.kTuples = kTuples;
        this.mainConstraint = mainConstraint;
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
        Constraint mainConstraint = ckTuple.mainConstraint;
        List<KTuple> resultKTuples = new ArrayList<>();

        for (KTuple kTuple : ckTuple.kTuples) {
            Set<TupleBaseNode> tuple = kTuple.getTuple();
            Graph.Table table = kTuple.getTable();
            Set<TupleBaseNode> results = new HashSet<>();

            for (TupleBaseNode t : tuple) {
                Graph.Column srcSchema = renameMap.getSrc(t.getColumnSchema());
                if (srcSchema != null)
                    results.add(t.setNewColumnSchema(srcSchema));
            }
            resultKTuples.add(new KTuple(table, results));
        }

        return new CKTuple(resultKTuples, mainConstraint);
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
        Constraint mainConstraint = ckTuple.mainConstraint;
        List<KTuple> resultKTuples = new ArrayList<>();

        for (KTuple kTuple : ckTuple.kTuples) {
            Set<TupleBaseNode> tuple = kTuple.getTuple();
            Graph.Table table = kTuple.getTable();
            Set<TupleBaseNode> results = new HashSet<>();

            for (TupleBaseNode t : tuple) {
                if (relationSchema.containColumn(t.getColumnSchema()))
                    results.add(t);
            }
            resultKTuples.add(new KTuple(table, results));
        }
        return new CKTuple(resultKTuples, mainConstraint);
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
        Constraint mainConstraint = ckTuple.mainConstraint;
        List<KTuple> resultKTuples = new ArrayList<>();

        for (KTuple kTuple : ckTuple.kTuples) {
            Set<TupleBaseNode> tuple = kTuple.getTuple();
            Graph.Table table = kTuple.getTable();
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
            resultKTuples.add(new KTuple(table, results));
        }

        return new CKTuple(resultKTuples, mainConstraint);
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
    public static CKTuple append(CKTuple ckTuple1, CKTuple ckTuple2) {
        List<KTuple> kTuples = new ArrayList<>();
        Constraint mainConstraint =  Constraint.and(ckTuple1.mainConstraint, ckTuple2.mainConstraint);
        try {
            for (KTuple kTuple : ckTuple1.kTuples)
                kTuples.add(Tools.clone(kTuple));
            for (KTuple kTuple : ckTuple2.kTuples)
                kTuples.add(Tools.clone(kTuple));

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new CKTuple(kTuples,mainConstraint);
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
        return new CKTuple(ckTuple.kTuples, Constraint.and(ckTuple.mainConstraint, constraint));
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
        Constraint mainConstraint = ckTuple.mainConstraint;
        List<KTuple> resultKTuples = new ArrayList<>();

        for (KTuple kTuple : ckTuple.kTuples) {
            Set<TupleBaseNode> tuple = kTuple.getTuple();
            Graph.Table targetTable = tuple.iterator().next().getColumnSchema().table;

            resultKTuples.add(new KTuple(targetTable, tuple));
        }
        return new CKTuple(resultKTuples, mainConstraint);
    }

    /**
     * 简化约束
     *
     * @author: Xin
     * @date: 2023-12-25 15:06:19
     */
    public void simplifyConstraint() {
        try {
            for(KTuple kTuple : this.kTuples) {
                Constraint subConstraint = Tools.clone(this.mainConstraint);
                subConstraint.simplify(kTuple.getTable());
                this.constraints.put(kTuple, subConstraint);
            }
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    Map<String, String> parameters = new HashMap<>();

    /**
     * CKTuple -> Relational Algebra -> Sql
     *
     * @return {@link String }
     * @author: Xin
     * @date: 2023-12-25 15:06:25
     */
    public List<String> toSql() {
        // TODO : CKTuple -> sql
        List<String> sqls = new ArrayList<>();
        for(KTuple kTuple : this.kTuples) {
            StringBuilder buf = new StringBuilder();
            String procedureName = "INVERSE_" + kTuple.getTable().tableName;
            String procedureBody = Tools.translateFromRA2Sql(this.toRA(kTuple));
            buf.append("CREATE OR REPLACE PROCEDURE ").append(procedureName).append("(\n");
            for (String key : parameters.keySet()) {
                String value = parameters.get(key);
                buf.append(value).append(" IN VARCHAR2(255),\n");
                procedureBody = procedureBody.replaceAll(key, value);
            }
            buf.delete(buf.length() - ",\n".length(), buf.length());
            buf.append("\n) IS\nBEGIN\n").append(procedureBody).append("\nEND ").append(procedureName).append(";");

            sqls.add(buf.toString());
        }
        return sqls;
    }

    /**
     * CKTuple -> Relational Algebra
     *
     * @param kTuple k元组
     * @return {@link String }
     * @author: Xin
     * @date: 2024-01-04 15:59:23
     */
    private String toRA(KTuple kTuple) {
        this.parameters.clear();
        StringBuilder ra = new StringBuilder(),
                matchCondition = new StringBuilder(),
                projectionList = new StringBuilder();
        Graph.Table srcTable = kTuple.getTable();
        Set<TupleBaseNode> tuple = kTuple.getTuple();
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

        Constraint combinedConstraint = Constraint.and(new Constraint(matchCondition.toString()), this.mainConstraint);
        logger.info("combinedConstraint: " + combinedConstraint);
        return ra.append("project").append(projectionList).append("(select[").append(combinedConstraint).append("](")
                .append(srcTable.toString()).append("));").toString();
    }

    /**
     * 获取ktuples
     *
     * @return {@link List }<{@link KTuple }>
     * @author: Xin
     * @date: 2024-01-04 16:00:08
     */
    public List<KTuple> getkTuples() {
        return kTuples;
    }

    /**
     * 获取主限制
     *
     * @return {@link Constraint }
     * @author: Xin
     * @date: 2024-01-04 16:00:24
     */
    public Constraint getMainConstraint() {
        return mainConstraint;
    }

    /**
     * 是一元的
     *
     * @return boolean
     * @author: Xin
     * @date: 2024-01-02 20:43:47
     */
    public boolean isUnary() {
        for(KTuple kTuple : this.kTuples)
            if(!kTuple.isUnary())
                return false;
        return true;
    }

    /**
     * 等于
     *
     * @param o o
     * @return boolean
     * @author: Xin
     * @date: 2024-01-04 16:01:37
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CKTuple ckTuple = (CKTuple) o;
        return Objects.equals(kTuples, ckTuple.kTuples) && Objects.equals(constraints, ckTuple.constraints) && Objects.equals(mainConstraint, ckTuple.mainConstraint) && Objects.equals(parameters, ckTuple.parameters);
    }

    /**
     * 散列码
     *
     * @return int
     * @author: Xin
     * @date: 2024-01-04 16:01:39
     */
    @Override
    public int hashCode() {
        return Objects.hash(kTuples, constraints, mainConstraint, parameters);
    }
}
