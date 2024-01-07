package cn.edu.nju.expression;

import cn.edu.nju.graph.Graph;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * @className：RenameMap
 * @version: 1.0.0
 * @description：重命名映射
 * @author: Xin
 * @date: 2023-12-25 15:26:02
 */
public class RenameMap {
    private final BiMap<Graph.Column, Graph.Column> maps = HashBiMap.create();


    /**
     * 添加 srcColumn -> dstColumn 的重命名映射
     *
     * @param srcColumn 源列
     * @param dstColumn 目标列
     * @author: Xin
     * @date: 2023-12-25 15:28:22
     */
    public void add(Graph.Column srcColumn, Graph.Column dstColumn) {
        maps.put(srcColumn, dstColumn);
    }

    /**
     * 获取srcColumn对应的dst
     *
     * @param srcColumn 源列
     * @return {@link Graph.Column }
     * @author: Xin
     * @date: 2023-12-25 15:28:47
     */
    public Graph.Column getDst(Graph.Column srcColumn) {
        return maps.get(srcColumn);
    }

    /**
     * 获取dstColumn对应的src
     *
     * @param dstColumn 目标列
     * @return {@link Graph.Column }
     * @author: Xin
     * @date: 2023-12-25 15:29:09
     */
    public Graph.Column getSrc(Graph.Column dstColumn) {
        return maps.inverse().get(dstColumn);
    }

    /**
     * 是否为空
     *
     * @return boolean
     * @author: Xin
     * @date: 2023-12-25 15:29:53
     */
    public boolean isEmpty() {
        return this.maps.isEmpty();
    }

    /**
     * toString
     *
     * @return {@link String }
     * @author: Xin
     * @date: 2023-12-25 15:29:57
     */
    @Override
    public String toString() {
        return "RenameMap{" +
                "maps=" + maps +
                '}';
    }
}
