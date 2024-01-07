package cn.edu.nju;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

/**
 * @className：TableAlias
 * @version: 1.0.0
 * @description：表的别名
 * @author: Xin
 * @date: 2023-12-25 15:54:57
 */
public class TableAlias implements Serializable {
    private final Map<String, String> realTableNameMapper = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    /**
     * 清空所有表别名
     *
     * @author: Xin
     * @date: 2023-12-25 15:55:05
     */
    public void clear() {
        this.realTableNameMapper.clear();
    }

    /**
     * 获取真实的表名
     *
     * @param tableName 表格名
     * @return {@link String }
     * @author: Xin
     * @date: 2023-12-25 15:55:29
     */
    public String getRealTableName(String tableName) {
        if (tableName == null)
            return null;

        String oldTableName = tableName.toUpperCase();
        String realTableName = realTableNameMapper.get(oldTableName);
        while (realTableName != null && !realTableName.equals(oldTableName)) {
            oldTableName = realTableName;
            realTableName = realTableNameMapper.get(oldTableName);
        }

        if (realTableName == null)
            return tableName;
        return realTableName;
    }

    /**
     * 更新表的别名
     *
     * @param tableName      表格名
     * @param aliasTableName 别名表格名
     * @author: Xin
     * @date: 2023-12-25 15:55:58
     */
    public void updateAliasTableName(String tableName, String aliasTableName) {
        tableName = tableName.toUpperCase();
        aliasTableName = aliasTableName.toUpperCase();
        realTableNameMapper.put(aliasTableName, tableName);
        realTableNameMapper.put(tableName, tableName);
    }

    /**
     * 获取真实列全名
     *
     * @param fullColumnName 列全名
     * @return {@link String }
     * @author: Xin
     * @date: 2023-12-25 15:57:08
     */
    public String getRealFullColumnName(String fullColumnName) {
        String splitChar = null, combineChar = null;
        if(fullColumnName.contains(".")) {
            splitChar = "\\.";
            combineChar = ".";
        }
        else if(fullColumnName.contains(":")) {
            splitChar = ":";
            combineChar = ":";
        }
        if(splitChar == null)
            return fullColumnName;

        String []tableAndColumn = fullColumnName.split(splitChar);
        if(tableAndColumn.length != 2)
            return fullColumnName;

        tableAndColumn[0] = this.getRealTableName(tableAndColumn[0]);
        return tableAndColumn[0]+combineChar+tableAndColumn[1];
    }
}
