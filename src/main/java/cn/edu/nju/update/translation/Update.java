package cn.edu.nju.update.translation;

import cn.edu.nju.expression.cktuple.Tuple;
import cn.edu.nju.expression.cktuple.constraint.Constraint;
import cn.edu.nju.expression.cktuple.tuple.ColumnNode;
import cn.edu.nju.expression.cktuple.tuple.TupleBaseNode;
import cn.edu.nju.graph.Graph;
import cn.edu.nju.update.UpdateType;
import com.google.common.base.Joiner;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class Update {
    private final UpdateType updateType;
    private final List<Pair<Tuple, Constraint>> updateTuples = new ArrayList<>();
    private Graph.Table updateTable;

    public String toSql() {
        String procedureName = "INVERSE_UPDATE_"+updateTable.tableName;
        Pair<List<String>, Map<String, String>> pair= this.getProcedureBody();
        Map<String, String> parameters = pair.getRight();
        String procedureBody = Joiner.on("\n").join(pair.getLeft());
        StringBuilder buf = new StringBuilder();
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

    private Pair<List<String>,Map<String,String>> getProcedureBody() {
        List<String> sqls = new ArrayList<>();
        Map<String,String> parameters = new HashMap<>();
        Graph.Table table = this.updateTable;
        List<Pair<Tuple, Constraint>> kTuple = this.updateTuples;
        if(updateType == UpdateType.DELETE) { //DELETE FROM 表名称 WHERE 列名称 = 值
            for (Pair<Tuple, Constraint> entry: kTuple) {
                Tuple tuple = entry.getLeft();
                Constraint constraint = entry.getRight();
                StringBuilder updateSql = new StringBuilder();
                StringBuilder matchCondition = new StringBuilder();
                updateSql.append("DELETE FROM ").append(table.tableName).append(" WHERE ");
                for (TupleBaseNode node : tuple.getTuple()) {
                    if ((node instanceof ColumnNode columnNode) && !columnNode.isEmpty()) {
                        matchCondition.append(columnNode.getColumnSchema()).append("=").append(columnNode.getColumn()).append(" AND ");
                        parameters.put(columnNode.getColumn().toString(), "PARA_" + columnNode.getColumn().columnName);
                    }
                }
                matchCondition.delete(matchCondition.length() - " AND ".length(), matchCondition.length());
                Constraint combinedConstraint = Constraint.and(new Constraint(matchCondition.toString()), constraint);
                updateSql.append(combinedConstraint).append(";");
                sqls.add(updateSql.toString());
            }
        }
        else if(updateType == UpdateType.INSERT) { //INSERT INTO table_name (列1, 列2,...) VALUES (值1, 值2,....)
            for (Pair<Tuple, Constraint> entry: kTuple) {
                Tuple tuple = entry.getLeft();
                Constraint constraint = entry.getRight();
                StringBuilder updateSql = new StringBuilder();
                updateSql.append("INSERT INTO ").append(table.tableName);
                StringBuilder columns = new StringBuilder("(");
                StringBuilder values = new StringBuilder("(");
                for (TupleBaseNode node : tuple.getTuple()) {
                    if ((node instanceof ColumnNode columnNode) && !columnNode.isEmpty()) {
                        columns.append(columnNode.getColumnSchema()).append(", ");
                        values.append(columnNode.getColumn()).append(", ");
                        parameters.put(columnNode.getColumn().toString(), "PARA_" + columnNode.getColumn().columnName);
                    }
                }
                columns.delete(columns.length()-", ".length(), columns.length()).append(")");
                values.delete(values.length()-", ".length(), values.length()).append(")");
                updateSql.append(columns).append(" VALUES ").append(values);
                updateSql.append("\nConstraint: ").append(constraint).append("\n");
                sqls.add(updateSql.toString());
            }
        }
        return Pair.of(sqls,parameters);
    }

    /**
     * Translation中的更新(Update)的构造函数
     *
     * @param updateType   更新类型
     * @param updateTuples 更新元组
     * @param table        表格
     * @author: Xin
     * @date: 2024-01-15 12:13:27
     */
    public Update(UpdateType updateType, Graph.Table table, List<Pair<Tuple, Constraint>> updateTuples) {
        this.updateType = updateType;
        this.updateTable = table;
        this.updateTuples.addAll(updateTuples);
    }

    /**
     * Translation中的更新(Update)的构造函数
     *
     * @param updateType   更新类型
     * @param table        表格
     * @param updateTuples 更新元组
     * @author: Xin
     * @date: 2024-01-15 12:20:22
     */
    public Update(UpdateType updateType, Graph.Table table, Pair<Tuple, Constraint>... updateTuples){
        this.updateType = updateType;
        this.updateTable = table;
        this.updateTuples.addAll(Arrays.stream(updateTuples).toList());
    }

    /**
     * 获取更新类型
     *
     * @return {@link UpdateType }
     * @author: Xin
     * @date: 2024-01-02 21:11:17
     */
    public UpdateType getUpdateType() {
        return updateType;
    }

    /**
     * 获取更新表格
     *
     * @return {@link Graph.Table }
     * @author: Xin
     * @date: 2024-01-15 12:17:20
     */
    public Graph.Table getUpdateTable() {
        return updateTable;
    }

    /**
     * 获取更新元组
     *
     * @return {@link List }<{@link Pair }<{@link Tuple }, {@link Constraint }>>
     * @author: Xin
     * @date: 2024-01-15 12:17:25
     */
    public List<Pair<Tuple, Constraint>> getUpdateTuples() {
        return updateTuples;
    }

    /**
     * 获取K-元组
     *
     * @return {@link Set }<{@link Tuple }>
     * @author: Xin
     * @date: 2024-01-05 12:12:41
     */
    public Set<Tuple> getKTuple() {
        Set<Tuple> tuples = new HashSet<>();
        for (Pair<Tuple, Constraint> entry: this.updateTuples)
            tuples.add(entry.getLeft());
        return tuples;
    }

    /**
     * 等于
     *
     * @param o o
     * @return boolean
     * @author: Xin
     * @date: 2024-01-15 12:19:23
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Update update = (Update) o;
        return updateType == update.updateType && Objects.equals(updateTuples, update.updateTuples) && Objects.equals(updateTable, update.updateTable);
    }

    /**
     * 散列码
     *
     * @return int
     * @author: Xin
     * @date: 2024-01-15 12:19:25
     */
    @Override
    public int hashCode() {
        return Objects.hash(updateType, updateTuples, updateTable);
    }
}
