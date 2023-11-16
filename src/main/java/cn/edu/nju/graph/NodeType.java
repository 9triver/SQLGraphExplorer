package cn.edu.nju.graph;

public enum NodeType {
    JOIN,
    WHERE,
    FUNCTION,
    UNION,
    CASE,
    MERGE,
    MERGE_UPDATE,
    MERGE_INSERT,
    TABLE,
    QUOTED_STRING,
    COLUMN;
}
