package cn.edu.nju.graph;

import java.io.Serializable;

/**
 * @className：NodeType
 * @version: 1.0.0
 * @description：节点类型
 * @author: Xin
 * @date: 2023-12-25 15:49:35
 */
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
