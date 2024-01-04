package cn.edu.nju.expression.cktuple;

import cn.edu.nju.expression.RenameMap;
import cn.edu.nju.expression.Schema;
import cn.edu.nju.expression.cktuple.constraint.Constraint;
import cn.edu.nju.update.UpdateType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @className：CKTuples
 * @version: 1.0.0
 * @description：cktuples
 * @author: Xin
 * @date: 2023-12-25 15:07:34
 */
public class CKTuples {
    private final List<CKTuple> ckTuples;

    /**
     * CKTuples构造函数
     *
     * @param kTuple     k元组
     * @param constraint 限制
     * @author: Xin
     * @date: 2023-12-25 15:07:37
     */
    public CKTuples(KTuple kTuple, Constraint constraint) {
        this.ckTuples = new ArrayList<>();
        this.ckTuples.add(new CKTuple(Stream.of(kTuple).toList(), constraint));
    }

    /**
     * CKTuples构造函数
     *
     * @param kTuples    k元组
     * @param constraint 限制
     * @author: Xin
     * @date: 2023-12-25 15:07:48
     */
    public CKTuples(List<KTuple> kTuples, Constraint constraint) {
        this.ckTuples = new ArrayList<>();
        this.ckTuples.add(new CKTuple(kTuples, constraint));
    }

    /**
     * CKTuples构造函数
     *
     * @param ckTuples ck元组
     * @author: Xin
     * @date: 2023-12-25 15:08:05
     */
    public CKTuples(List<CKTuple> ckTuples) {
        this.ckTuples = ckTuples;
    }

    /**
     * 获取ck元组
     *
     * @return {@link List }<{@link CKTuple }>
     * @author: Xin
     * @date: 2023-12-25 15:08:15
     */
    public List<CKTuple> getCkTuples() {
        return ckTuples;
    }

    /**
     * projection_{relationSchema}(ckTuples)
     *
     * @param ckTuples       ck元组
     * @param relationSchema 关系模式
     * @return {@link CKTuples }
     * @author: Xin
     * @date: 2023-12-25 15:08:51
     */
    public static CKTuples projection(CKTuples ckTuples, Schema relationSchema) {
        List<CKTuple> ckTuplesTmp = new ArrayList<>();
        for (CKTuple p : ckTuples.ckTuples)
            ckTuplesTmp.add(CKTuple.projection(p, relationSchema));
        return new CKTuples(ckTuplesTmp);
    }

    /**
     * extension_{relationSchema}(ckTuples)
     *
     * @param ckTuples       ck元组
     * @param relationSchema 关系模式
     * @return {@link CKTuples }
     * @author: Xin
     * @date: 2023-12-25 15:09:32
     */
    public static CKTuples extension(CKTuples ckTuples, Schema relationSchema) {
        List<CKTuple> ckTuplesTmp = new ArrayList<>();
        for (CKTuple p : ckTuples.ckTuples)
            ckTuplesTmp.add(CKTuple.extension(p, relationSchema));
        return new CKTuples(ckTuplesTmp);
    }

    /**
     * ckTuples1 append ckTuples2
     *
     * @param ckTuples1 ck元组1
     * @param ckTuples2 ck元组2
     * @return {@link CKTuples }
     * @author: Xin
     * @date: 2023-12-25 15:10:16
     */
    public static CKTuples append(CKTuples ckTuples1, CKTuples ckTuples2) {
        List<CKTuple> ckTuplesTmp = new ArrayList<>();
        for (CKTuple p1 : ckTuples1.ckTuples)
            for (CKTuple p2 : ckTuples2.ckTuples)
                ckTuplesTmp.add(CKTuple.append(p1, p2));
        return new CKTuples(ckTuplesTmp);
    }

    /**
     * ckTuples1 completion ckTuples2
     *
     * @param ckTuples1 ck元组1
     * @param ckTuples2 ck元组2
     * @return {@link CKTuples }
     * @author: Xin
     * @date: 2023-12-25 15:10:41
     */
    public static CKTuples completion(CKTuples ckTuples1, CKTuples ckTuples2) {
        List<CKTuple> ckTuplesTmp = new ArrayList<>();
        ckTuplesTmp.addAll(ckTuples1.ckTuples);
        ckTuplesTmp.addAll(ckTuples2.ckTuples);
        return new CKTuples(ckTuplesTmp);
    }


    /**
     * selection_{constraint}(ckTuples)
     *
     * @param ckTuples   ck元组
     * @param constraint 限制
     * @return {@link CKTuples }
     * @author: Xin
     * @date: 2023-12-25 15:11:42
     */
    public static CKTuples selection(CKTuples ckTuples, Constraint constraint) {
        List<CKTuple> ckTuplesTmp = new ArrayList<>();
        List<Constraint> splitResult = constraint.orSplit();
        for (CKTuple p : ckTuples.ckTuples)
            for (Constraint c : splitResult)
                ckTuplesTmp.add(CKTuple.andConstraint(p, c));

        return new CKTuples(ckTuplesTmp);
    }

    /**
     * atom运算
     *
     * @param ckTuples ck元组
     * @return {@link CKTuples }
     * @author: Xin
     * @date: 2023-12-25 15:12:01
     */
    public static CKTuples atom(CKTuples ckTuples) {
        List<CKTuple> ckTuplesTmp = new ArrayList<>();
        for (CKTuple p : ckTuples.ckTuples)
            ckTuplesTmp.add(CKTuple.atom(p));
        return new CKTuples(ckTuplesTmp);
    }


    /**
     * 重命名
     *
     * @param ckTuples  ck元组
     * @param renameMap 重命名映射
     * @return {@link CKTuples }
     * @author: Xin
     * @date: 2024-01-02 20:25:52
     */
    public static CKTuples rename(CKTuples ckTuples, RenameMap renameMap) {
        List<CKTuple> ckTuplesTmp = new ArrayList<>();
        for (CKTuple p : ckTuples.ckTuples)
            ckTuplesTmp.add(CKTuple.rename(p, renameMap));
        return new CKTuples(ckTuplesTmp);
    }

    /**
     * 简化Constraint
     *
     * @return {@link CKTuples }
     * @author: Xin
     * @date: 2024-01-02 20:26:15
     */
    public CKTuples simplifyConstraints() {
        for (CKTuple p : this.ckTuples)
            p.simplifyConstraint();
        return this;
    }

    /**
     * 转换为Sql
     *
     * @return {@link List }<{@link String }>
     * @author: Xin
     * @date: 2024-01-02 20:26:26
     */
    public List<String> toSql() {
        List<String> sqls = new ArrayList<>();
        for (CKTuple ckTuple : this.ckTuples) {
            try {
                sqls.addAll(ckTuple.toSql());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sqls;
    }

    /**
     * 数量
     *
     * @return int
     * @author: Xin
     * @date: 2024-01-02 20:26:40
     */
    public int size() {
        return this.ckTuples.size();
    }

    public boolean isStronglyDeterministic(UpdateType updateType) {
        return switch (updateType) {
            case INSERT -> this.size() == 1;
            case DELETE -> this.isUnary();
        };
    }

    public boolean isWeaklyDeterministic() {
        //TODO: 理论上尚未给出算法
        return true;
    }

    public boolean isUnary() {
        for(CKTuple ckTuple : this.ckTuples)
            if(!ckTuple.isUnary())
                return false;
        return true;
    }
}
