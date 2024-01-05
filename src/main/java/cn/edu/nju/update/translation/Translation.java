package cn.edu.nju.update.translation;

import cn.edu.nju.expression.Expression;
import cn.edu.nju.expression.cktuple.CKTuple;
import cn.edu.nju.expression.cktuple.CKTuples;
import cn.edu.nju.expression.cktuple.KTuple;
import cn.edu.nju.graph.Graph;
import cn.edu.nju.tools.Tools;
import cn.edu.nju.update.UpdateType;
import cn.edu.nju.update.viewUpdate.ViewUpdate;
import org.checkerframework.checker.units.qual.K;

import java.io.IOException;
import java.util.*;

public class Translation {
    private List<Update> updates = new ArrayList<>();
    public void addUpdate(Update update) {
        this.updates.add(update);
    }
    public void addUpdate(UpdateType updateType, Set<KTuple> kTuples, Graph.Table table) {
        this.updates.add(new Update(updateType, kTuples, table));
    }
    public void addUpdate(UpdateType updateType, Graph.Table table, KTuple ... kTuples){
        this.updates.add(new Update(updateType, table, kTuples));
    }

    public Update getUpdate(int index) throws NullPointerException{
        if(index < 0 || index >= updates.size())
            return null;
        return updates.get(index);
    }

    public static Translation inverseViewUpdate(ViewUpdate viewUpdate) {
        UpdateType updateType = viewUpdate.getUpdateType();
        KTuple kTuple = viewUpdate.getkTuple();
        Expression expression = viewUpdate.getExpression();
        CKTuples inverseSet = expression.inverse(kTuple.getTable().getCKTuples()).simplifyConstraints();

        if(inverseSet.isStronglyDeterministic(updateType)) {
            // case-强确定性
            return switch (updateType) {
                case INSERT -> Translation.inverseStronglyViewInsert(inverseSet);
                case DELETE -> Translation.inverseStronglyViewDelete(inverseSet);
            };
        }
        else {
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
        assert inverseSet.size()==1;
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
        for(KTuple kTuple : ckTuple.getkTuples())
            translation.addUpdate(UpdateType.INSERT, kTuple.getTable(), kTuple);

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
        try{
            inverseSet = Tools.clone(inverseSet);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        Map<Graph.Table, List<KTuple>> tau = new HashMap<>();
        while (!inverseSet.isEmpty()) {
            CKTuple ckTuple = inverseSet.getCkTuples().get(0);
            for(KTuple kTuple : ckTuple.getkTuples()) {
                if(kTuple.isEmpty()) continue;
                Graph.Table table = kTuple.getTable();

                // update tau
                if(!tau.containsKey(table))
                    tau.put(table,new ArrayList<>());
                tau.get(table).add(kTuple);
                break;
            }
            // update inverseSet
            inverseSet.delete(ckTuple);
        }

        Translation translation = new Translation();
        for(Map.Entry<Graph.Table, List<KTuple>> entry : tau.entrySet()) {
            Graph.Table table = entry.getKey();
            List<KTuple> kTuples = entry.getValue();
            translation.addUpdate(UpdateType.DELETE, table, kTuples.toArray(new KTuple[0]));
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
