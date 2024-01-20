package cn.edu.nju.core.expression;

/**
 * @className：OpType
 * @version: 1.0.0
 * @description：op类型
 * @author: Xin
 * @date: 2023-12-25 15:25:48
 */
public enum OpType {
    SELECTION,
    PROJECTION,
    UNION,
    DIFFERENCE,
    INTERSECTION,
    RENAME,
    CARTESIAN_PRODUCTION,
    ATOM
}
