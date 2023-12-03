package cn.edu.nju.graph;

public enum NodeType {
    JOIN,
    WHERE,
    GROUP_BY,
    ORDER_BY,
    FUNCTION,
    UNION,
    CASE,
    MERGE,
    MERGE_UPDATE,
    MERGE_INSERT,
    TABLE,
    QUOTED_STRING,
    COLUMN;

    @Override
    public String toString() {
        return this.name();
    }
}
