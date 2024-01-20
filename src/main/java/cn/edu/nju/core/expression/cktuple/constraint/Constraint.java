package cn.edu.nju.core.expression.cktuple.constraint;

import cn.edu.nju.core.graph.Graph;
import cn.edu.nju.core.tools.Tools;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * @className：Constraint
 * @version: 1.0.0
 * @description：限制
 * @author: Xin
 * @date: 2023-12-25 15:02:55
 */
public class Constraint implements Serializable {
    private String context;


    /**
     * Constraint构造函数
     *
     * @param context 上下文
     * @author: Xin
     * @date: 2023-12-25 15:02:22
     */
    public Constraint(String context) {
        this.context = context;
    }

    /**
     * Constraint复制构造函数
     *
     * @param constraint 限制
     * @author: Xin
     * @date: 2023-12-25 15:02:46
     */
    public Constraint(Constraint constraint) {
        this.context = String.copyValueOf(constraint.context.toCharArray());
    }


    /**
     * (constraint1) AND (constraint2)
     *
     * @param constraint1 约束1
     * @param constraint2 约束2
     * @return {@link Constraint }
     * @author: Xin
     * @date: 2023-12-25 15:02:57
     */
    public static Constraint and(Constraint constraint1, Constraint constraint2) {
        if(constraint1.context.isBlank()) return new Constraint(constraint2);
        if(constraint2.context.isBlank()) return new Constraint(constraint1);
        if(constraint1.context.equals(constraint2.context)) return new Constraint(constraint1);

        return new Constraint("("+constraint1+") AND ("+constraint2+")");
    }

    /**
     * (constraint1) OR (constraint2)
     *
     * @param constraint1 约束1
     * @param constraint2 约束2
     * @return {@link Constraint }
     * @author: Xin
     * @date: 2023-12-25 15:03:28
     */
    public static Constraint or(Constraint constraint1, Constraint constraint2) {
        if(constraint1.context.isBlank()) return new Constraint(constraint2);
        if(constraint2.context.isBlank()) return new Constraint(constraint1);
        if(constraint1.context.equals(constraint2.context)) return new Constraint(constraint1);
        return new Constraint("("+constraint1+") OR ("+constraint2+")");
    }

    /**
     * 简化Constraint
     *
     * @param targetTable 目标表格
     * @return {@link Constraint }
     * @author: Xin
     * @date: 2023-12-25 15:03:34
     */
    public Constraint simplify(Graph.Table targetTable) {
        this.context = Tools.simplify(this.context, targetTable);
        return this;
    }

    /**
     * 简化Constraint
     *
     * @return {@link Constraint }
     * @author: Xin
     * @date: 2023-12-25 15:03:38
     */
    public Constraint simplify() {
        this.context = Tools.simplify(this.context);
        return this;
    }

    /**
     * 按或拆分
     *
     * @return {@link List }<{@link Constraint }>
     * @author: Xin
     * @date: 2023-12-25 15:03:42
     */
    public List<Constraint> orSplit() {
        List<Constraint> ret = new ArrayList<>();
        for(String str : Tools.split(this.context))
            ret.add(new Constraint(str));
        return ret;
    }

    /**
     * toString: 获取Constraint文本内容
     *
     * @return {@link String }
     * @author: Xin
     * @date: 2023-12-25 15:03:49
     */
    @Override
    public String toString() {
        return this.context;
    }
}
