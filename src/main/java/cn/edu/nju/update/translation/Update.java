package cn.edu.nju.update.translation;

import cn.edu.nju.expression.cktuple.Tuple;
import cn.edu.nju.expression.cktuple.tuple.ColumnNode;
import cn.edu.nju.expression.cktuple.tuple.TupleBaseNode;
import cn.edu.nju.graph.Graph;
import cn.edu.nju.update.UpdateType;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class Update {
    private final UpdateType updateType;
    private final Pair<Set<Tuple>, Graph.Table> update;
    public List<String> toSql() {
//        DELETE FROM 表名称 WHERE 列名称 = 值
        List<String> sqls = new ArrayList<>();
        Set<Tuple> kTuple = update.getLeft();
        Graph.Table table = update.getRight();
        for(Tuple tuple : kTuple) {
            StringBuilder updateSql = new StringBuilder();
            updateSql.append(this.updateType.toString()).append(" FROM ").append(table.tableName).append(" WHERE ");
            for(TupleBaseNode node : tuple.getTuple()) {
                if(!(node instanceof ColumnNode columnNode))
                    continue;
                if(columnNode.isEmpty())
                    continue;
                updateSql.append(columnNode.getColumn()).append("=").append(columnNode.getColumnSchema()).append(" AND ");
            }
            updateSql.delete(updateSql.length()-" AND ".length(),updateSql.length()).append(";");
            sqls.add(updateSql.toString());
        }
        return sqls;
    }

    /**
     * Translation中的更新(Update)的构造函数
     *
     * @param updateType 更新类型
     * @param kTuples    k元组
     * @param table      表格
     * @author: Xin
     * @date: 2024-01-02 21:11:27
     */
    public Update(UpdateType updateType, Set<Tuple> kTuples, Graph.Table table) {
        this.updateType = updateType;
        this.update = Pair.of(kTuples,table);
    }

    /**
     * Translation中的更新(Update)的构造函数
     *
     * @param updateType 更新类型
     * @param table      表格
     * @param kTuples    k元组
     * @author: Xin
     * @date: 2024-01-02 21:11:55
     */
    public Update(UpdateType updateType, Graph.Table table, Tuple... kTuples){
        this.updateType = updateType;
        this.update = Pair.of(Arrays.stream(kTuples).collect(Collectors.toSet()), table);
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
     * 获取更新
     *
     * @return {@link Pair }<{@link Set }<{@link Tuple }>, {@link Graph.Table }>
     * @author: Xin
     * @date: 2024-01-02 21:11:20
     */
    public Pair<Set<Tuple>, Graph.Table> getUpdate() {
        return update;
    }

    /**
     * 获取K-元组
     *
     * @return {@link Set }<{@link Tuple }>
     * @author: Xin
     * @date: 2024-01-05 12:12:41
     */
    public Set<Tuple> getKTuple() {
        return update.getLeft();
    }

    /**
     * 获取表格
     *
     * @return {@link Graph.Table }
     * @author: Xin
     * @date: 2024-01-05 12:12:49
     */
    public Graph.Table getTable() {
        return update.getRight();
    }

    /**
     * 等于
     *
     * @param o o
     * @return boolean
     * @author: Xin
     * @date: 2024-01-02 21:11:12
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Update update1 = (Update) o;
        return updateType == update1.updateType && Objects.equals(update, update1.update);
    }

    /**
     * 散列码
     *
     * @return int
     * @author: Xin
     * @date: 2024-01-02 21:11:14
     */
    @Override
    public int hashCode() {
        return Objects.hash(updateType, update);
    }
}
