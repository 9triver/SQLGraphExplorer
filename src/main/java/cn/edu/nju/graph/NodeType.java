package cn.edu.nju.graph;

import java.io.Serializable;

public enum NodeType implements Serializable {
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
