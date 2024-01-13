package cn.edu.nju.update.translation;

import cn.edu.nju.expression.Expression;
import cn.edu.nju.expression.cktuple.CKTuple;
import cn.edu.nju.expression.cktuple.CKTuples;
import cn.edu.nju.expression.cktuple.Tuple;
import cn.edu.nju.graph.Graph;
import cn.edu.nju.tools.Tools;
import cn.edu.nju.update.UpdateType;
import cn.edu.nju.update.viewUpdate.ViewUpdate;

import java.io.IOException;
import java.util.*;

public class Translation {
    private final List<Update> updates = new ArrayList<>();

    public List<String> toSql() {
        List<String> sqls = new ArrayList<>();
        for(Update update : updates)
            sqls.addAll(update.toSql());
        return sqls;
    }

    /**
     * 添加更新
     *
     * @param update 更新
     * @author: Xin
     * @date: 2024-01-07 18:45:17
     */
    public void addUpdate(Update update) {
        this.updates.add(update);
    }

    /**
     * 添加更新
     *
     * @param updateType 更新类型
     * @param kTuple    k元组
     * @param table      表格
     * @author: Xin
     * @date: 2024-01-07 18:45:21
     */
    public void addUpdate(UpdateType updateType, Set<Tuple> kTuple, Graph.Table table) {
        this.updates.add(new Update(updateType, kTuple, table));
    }


    /**
     * 添加更新
     *
     * @param updateType 更新类型
     * @param table      表格
     * @param kTuple     k元组
     * @author: Xin
     * @date: 2024-01-07 18:48:16
     */
    public void addUpdate(UpdateType updateType, Graph.Table table, Tuple... kTuple) {
        this.updates.add(new Update(updateType, table, kTuple));
    }

    /**
     * 获取更新
     *
     * @param index 下标
     * @return {@link Update }
     * @throws NullPointerException 空指针异常
     * @author: Xin
     * @date: 2024-01-07 18:48:23
     */
    public Update getUpdate(int index) throws NullPointerException {
        if (index < 0 || index >= updates.size())
            return null;
        return updates.get(index);
    }

    /**
     * 对视图更新求逆
     *
     * @param viewUpdate 视图更新
     * @return {@link Translation }
     * @author: Xin
     * @date: 2024-01-07 18:48:36
     */
    public static Translation inverseViewUpdate(ViewUpdate viewUpdate) {
        UpdateType updateType = viewUpdate.getUpdateType();
        Tuple tuple = viewUpdate.getkTuple();
        Expression expression = viewUpdate.getExpression();
        CKTuples inverseSet = expression.inverse(tuple.getTable().getCKTuples()).simplifyConstraints();

        if (inverseSet.isStronglyDeterministic(updateType)) {
            // case-强确定性
            return switch (updateType) {
                case INSERT -> Translation.inverseStronglyViewInsert(inverseSet);
                case DELETE -> Translation.inverseStronglyViewDelete(inverseSet);
            };
        } else {
            // case-非强确定性：包括 弱确定性 和 非确定性
            return switch (updateType) {
                case INSERT -> Translation.inverseNotStronglyViewInsert(inverseSet);
                case DELETE -> Translation.inverseNotStronglyViewDelete(inverseSet);
            };

        }
    }

    /**
     * 对强确定性的视图插入求逆
     *
     * @param inverseSet inverse的结果集
     * @return {@link Translation }
     * @author: Xin
     * @date: 2024-01-04 19:50:39
     */
    private static Translation inverseStronglyViewInsert(CKTuples inverseSet) {
        assert inverseSet != null;
        assert inverseSet.size() == 1;
        return Translation.inverseViewInsert(inverseSet);
    }

    /**
     * 对非强确定性的视图插入求逆
     *
     * @param inverseSet inverse的结果集
     * @return {@link Translation }
     * @author: Xin
     * @date: 2024-01-05 13:41:44
     */
    private static Translation inverseNotStronglyViewInsert(CKTuples inverseSet) {
        assert inverseSet != null;
        assert !inverseSet.isEmpty();
        return Translation.inverseViewInsert(inverseSet);
    }

    /**
     * 对视图插入求逆
     *
     * @param inverseSet inverse的结果集
     * @return {@link Translation }
     * @author: Xin
     * @date: 2024-01-05 13:42:10
     */
    private static Translation inverseViewInsert(CKTuples inverseSet) {
        Translation translation = new Translation();
        CKTuple ckTuple = inverseSet.getCkTuples().get(0);
        for (Tuple tuple : ckTuple.getKTuple())
            if(!tuple.isEmpty())
                translation.addUpdate(UpdateType.INSERT, tuple.getTable(), tuple);

        return translation;
    }

    /**
     * 对强确定性的视图删除求逆
     *
     * @param inverseSet inverse的结果集
     * @return {@link Translation }
     * @author: Xin
     * @date: 2024-01-04 19:51:04
     */
    private static Translation inverseStronglyViewDelete(CKTuples inverseSet) {
        assert inverseSet != null;
        assert !inverseSet.isEmpty();
        assert inverseSet.isUnary();
        return Translation.inverseViewDelete(inverseSet);
    }

    /**
     * 对非强确定性的视图删除求逆
     *
     * @param inverseSet inverse的结果集
     * @return {@link Translation }
     * @author: Xin
     * @date: 2024-01-05 13:44:13
     */
    private static Translation inverseNotStronglyViewDelete(CKTuples inverseSet) {
        assert inverseSet != null;
        assert !inverseSet.isEmpty();
        return Translation.inverseViewDelete(inverseSet);
    }

    /**
     * 对视图删除求逆
     *
     * @param inverseSet inverse的结果集
     * @return {@link Translation }
     * @author: Xin
     * @date: 2024-01-05 13:44:30
     */
    private static Translation inverseViewDelete(CKTuples inverseSet) {
        try {
            inverseSet = Tools.clone(inverseSet);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        Map<Graph.Table, List<Tuple>> tau = new HashMap<>();
        while (!inverseSet.isEmpty()) {
            CKTuple ckTuple = inverseSet.getCkTuples().get(0);
            for (Tuple tuple : ckTuple.getKTuple()) {
                if (tuple.isEmpty())
                    continue;
                Graph.Table table = tuple.getTable();

                // update tau
                if (!tau.containsKey(table))
                    tau.put(table, new ArrayList<>());
                tau.get(table).add(tuple);
                break;
            }
            // update inverseSet
            inverseSet.delete(ckTuple);
        }

        Translation translation = new Translation();
        for (Map.Entry<Graph.Table, List<Tuple>> entry : tau.entrySet()) {
            Graph.Table table = entry.getKey();
            List<Tuple> kTuple = entry.getValue();
            translation.addUpdate(UpdateType.DELETE, table, kTuple.toArray(new Tuple[0]));
        }

        return translation;
    }

    /**
     * 大小
     *
     * @return int
     * @author: Xin
     * @date: 2024-01-05 12:05:21
     */
    public int size() {
        return this.updates.size();
    }
}
