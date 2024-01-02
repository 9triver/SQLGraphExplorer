package cn.edu.nju.update.translation;

import cn.edu.nju.expression.cktuple.KTuple;
import cn.edu.nju.graph.Graph;
import cn.edu.nju.update.UpdateType;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Update {
    private UpdateType updateType;
    private Pair<Set<KTuple>, Graph.Table> update;

    /**
     * Translation中的更新(Update)的构造函数
     *
     * @param updateType 更新类型
     * @param kTuples    k元组
     * @param table      表格
     * @author: Xin
     * @date: 2024-01-02 21:11:27
     */
    public Update(UpdateType updateType, Set<KTuple> kTuples, Graph.Table table) {
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
    public Update(UpdateType updateType, Graph.Table table, KTuple ... kTuples){
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
     * @return {@link Pair }<{@link Set }<{@link KTuple }>, {@link Graph.Table }>
     * @author: Xin
     * @date: 2024-01-02 21:11:20
     */
    public Pair<Set<KTuple>, Graph.Table> getUpdate() {
        return update;
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
