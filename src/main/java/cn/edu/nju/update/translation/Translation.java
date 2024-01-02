package cn.edu.nju.update.translation;

import cn.edu.nju.expression.Expression;
import cn.edu.nju.expression.cktuple.CKTuples;
import cn.edu.nju.expression.cktuple.KTuple;
import cn.edu.nju.graph.Graph;
import cn.edu.nju.update.UpdateType;
import cn.edu.nju.update.viewUpdate.ViewUpdate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    public static Translation inverseViewUpdate(ViewUpdate viewUpdate) {
        UpdateType updateType = viewUpdate.getUpdateType();
        KTuple kTuple = viewUpdate.getkTuple();
        Expression expression = viewUpdate.getExpression();
        CKTuples inverseSet = expression.inverse(kTuple.getTable().getCKTuples());

        if(inverseSet.isStronglyDeterministic(updateType)) {
            return switch (updateType) {
                case INSERT -> Translation.inverseStronglyViewInsert(viewUpdate);
                case DELETE -> Translation.inverseStronglyViewDelete(viewUpdate);
            };
        } else if (inverseSet.isWeaklyDeterministic()) {
            // TODO: 理论上没给出算法
            return null;
        }
        else {
            // TODO: 理论不完善
            return null;
        }
    }

    /**
     * 对强确定性的视图插入求逆
     *
     * @param viewUpdate 视图更新
     * @return {@link Translation }
     * @author: Xin
     * @date: 2024-01-02 21:31:50
     */
    private static Translation inverseStronglyViewInsert(ViewUpdate viewUpdate) {
        KTuple kTuple = viewUpdate.getkTuple();
        Expression expression = viewUpdate.getExpression();
        CKTuples inverseSet = expression.inverse(kTuple.getTable().getCKTuples());

        // TODO:
        return null;
    }

    /**
     * 对强确定性的视图删除求逆
     *
     * @param viewUpdate 视图更新
     * @return {@link Translation }
     * @author: Xin
     * @date: 2024-01-02 21:32:13
     */
    private static Translation inverseStronglyViewDelete(ViewUpdate viewUpdate) {
        KTuple kTuple = viewUpdate.getkTuple();
        Expression expression = viewUpdate.getExpression();
        CKTuples inverseSet = expression.inverse(kTuple.getTable().getCKTuples());

        // TODO:
        return null;
    }
}
