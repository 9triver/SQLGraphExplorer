package cn.edu.nju.expression.cktuple.tuple;

import cn.edu.nju.graph.Graph;

import java.util.Objects;

public class FunctionNode extends TupleBaseNode{
    private String functionName;
    private TupleBaseNode argument;
    public FunctionNode(Graph.Column columnScheme, String functionName, TupleBaseNode argument) {
        super(columnScheme);
        this.functionName=functionName;
        this.argument=argument;
    }

    public String getFunctionName() {
        return functionName;
    }

    public TupleBaseNode getArgument() {
        return argument;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FunctionNode that = (FunctionNode) o;
        return Objects.equals(functionName, that.functionName) && Objects.equals(argument, that.argument);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), functionName, argument);
    }
}
