package cn.edu.nju.expression.cktuple.tuple;

import cn.edu.nju.graph.Graph;

import java.io.Serializable;
import java.util.Objects;

/**
 * @className：FunctionNode
 * @version: 1.0.0
 * @description： 函数节点
 * @author: Xin
 * @date: 2023-12-25 15:04:38
 */
public class FunctionNode extends TupleBaseNode implements Serializable {
    private String functionName;
    private TupleBaseNode argument;


    public FunctionNode(Graph.Column columnSchema, String functionName, TupleBaseNode argument) {
        super(columnSchema);
        this.functionName = functionName;
        this.argument = argument;
    }

    public String getFunctionName() {
        return functionName;
    }

    public TupleBaseNode getArgument() {
        return argument;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        FunctionNode that = (FunctionNode) o;
        return Objects.equals(functionName, that.functionName) && Objects.equals(argument, that.argument);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), functionName, argument);
    }
}
