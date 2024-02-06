package cn.edu.nju.core.manager;

import cn.edu.nju.core.expression.Expression;
import cn.edu.nju.core.expression.RenameMap;
import cn.edu.nju.core.expression.Schema;
import cn.edu.nju.core.expression.cktuple.constraint.Constraint;
import cn.edu.nju.core.graph.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ExpressionsManager {
    private final Stack<List<Expression>> expressions;
    private Graph graph;
    public ExpressionsManager(Graph graph) {
        this.expressions = new Stack<>();
        this.graph = graph;
    }
    public List<Expression> peek() {
        return this.expressions.peek();
    }
    public boolean union() {
        if(this.expressions.size() < 2) return false;
        List<Expression> selectExpressions2 = this.expressions.pop();
        List<Expression> selectExpressions1 = this.expressions.pop();
        List<Expression> unionExpressions = new ArrayList<>();
        for(Expression selectExpression1 : selectExpressions1)
            for(Expression selectExpression2 : selectExpressions2)
                unionExpressions.add(Expression.union(selectExpression1,selectExpression2));
        this.expressions.push(unionExpressions);
        return true;
    }
    public boolean selection(String selectCondition) {
        if(this.expressions.size() < 1) return false;
        List<Expression> baseExpressions = this.expressions.pop();
        List<Expression> selectExpressions = new ArrayList<>();
        for(Expression fromExpression : baseExpressions)
            selectExpressions.add(Expression.selection(new Constraint(selectCondition), fromExpression));
        this.expressions.push(selectExpressions);
        return true;
    }
    public boolean projection(List<Schema> projections, Map<Expression, Schema> map) {
        if(this.expressions.size() < 1) return false;
        List<Expression> baseExpressions = this.expressions.pop();
        List<Expression> projectExpressions =new ArrayList<>();
        for(Schema projection : projections)
            for(Expression baseExpression : baseExpressions) {
                Expression e = Expression.projection(projection, baseExpression);
                projectExpressions.add(e);
                map.put(e, projection);
            }
        this.expressions.push(projectExpressions);
        return true;
    }
    public boolean rename(Map<Schema, RenameMap> renames, Map<Expression, Schema> map) {
        if(this.expressions.size() < 1) return false;
        List<Expression> baseExpressions = this.expressions.pop();
        List<Expression> renameExpressions = new ArrayList<>();
        for(Expression baseExpression : baseExpressions) {
            RenameMap rename = renames.get(map.get(baseExpression));
            renameExpressions.add(Expression.rename(rename, baseExpression));
        }
        this.expressions.push(renameExpressions);
        return true;
    }
    public boolean table(String tableName) {
        if(!graph.existTable(tableName))
            graph.createTable(tableName);
        List<Expression> tableExpressions = new ArrayList<>();
        tableExpressions.add(Expression.table(graph.getTable(tableName)));
        this.expressions.push(tableExpressions);
        return true;
    }
    public boolean join() {
        if(this.expressions.size() < 2) return false;
        List<Expression> tables2 = this.expressions.pop();
        List<Expression> tables1 = this.expressions.pop();
        List<Expression> joinExpressions = new ArrayList<>();
        for(Expression table1 : tables1)
            for(Expression table2 : tables2)
                joinExpressions.add(Expression.production(table1, table2));
        this.expressions.push(joinExpressions);
        return true;
    }
}
