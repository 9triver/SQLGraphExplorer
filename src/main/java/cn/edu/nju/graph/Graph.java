package cn.edu.nju.graph;

import cn.edu.nju.expression.Schema;
import cn.edu.nju.expression.cktuple.CKTuples;
import cn.edu.nju.expression.cktuple.Tuple;
import cn.edu.nju.expression.cktuple.constraint.Constraint;
import cn.edu.nju.expression.cktuple.tuple.ColumnNode;
import cn.edu.nju.expression.cktuple.tuple.TupleBaseNode;
import cn.edu.nju.graph.json.GraphJSON;
import cn.edu.nju.tools.Tools;
import com.google.gson.Gson;
import org.antlr.v4.runtime.misc.MultiMap;
import org.apache.commons.lang3.tuple.Pair;

import java.io.Serializable;
import java.util.*;

/**
 * @className：Graph
 * @version: 1.0.0
 * @description：图
 * @author: Xin
 * @date: 2023-12-25 15:36:03
 */
public class Graph implements Serializable {
    private final String NEWLINE = "\n";
    private final String SEMI = ";";
    private final String QUOTE = "\"";
    private final String diagraph = "digraph ";
    private final String digraphConfigure = """
              graph [pad="0.5", nodesep="0.5", ranksep="2"];
              node [shape=plain];
              rankdir=LR;
            """;
    private final String edgeConfigure = "\n";
    private final String nodeConfigure = "\n";

    private final Set<Node> nodes = new HashSet<>();
    private final MultiMap<Node, Node> edges = new MultiMap<>();
    private final Map<String, Table> tableNameMapper = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    private String graphName = "G";

    /**
     * @className：Table
     * @version: 1.0.0
     * @description：表格
     * @author: Xin
     * @date: 2023-12-25 15:36:12
     */
    public class Table implements Serializable {
        public String tableName;
        public Map<String, Column> columnNameMapper;

        /**
         * Table构造函数
         *
         * @param tableName 表格名称
         * @author: Xin
         * @date: 2023-12-25 15:36:20
         */
        public Table(String tableName) {
            this.tableName = tableName;
            this.columnNameMapper = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        }

        /**
         * 获取表格的所有模式
         *
         * @return {@link Schema }
         * @author: Xin
         * @date: 2023-12-25 15:36:27
         */
        public Schema allSchema() {
            Set<Graph.Column> ret = new HashSet<>();
            for (Map.Entry<String, Graph.Column> entry : this.columnNameMapper.entrySet())
                ret.add(entry.getValue());
            return new Schema(ret);
        }

        /**
         * 获取表格的某些列名对应的模式
         *
         * @param columnNames 列名称
         * @return {@link Schema }
         * @author: Xin
         * @date: 2023-12-25 15:36:37
         */
        public Schema schema(String... columnNames) {
            Set<Graph.Column> ret = new HashSet<>();
            for (String columnName : columnNames)
                if (this.columnNameMapper.containsKey(columnName))
                    ret.add(this.columnNameMapper.get(columnName));
            return new Schema(ret);
        }

        /**
         * 获取元组
         *
         * @return {@link Set }<{@link TupleBaseNode }>
         * @author: Xin
         * @date: 2023-12-25 15:36:53
         */
        public Set<TupleBaseNode> getTuple() {
            Set<TupleBaseNode> ret = new HashSet<>();
            for (Graph.Column column : this.allSchema().getColumns())
                ret.add(new ColumnNode(column, column));
            return ret;
        }

        /**
         * 获取K-元组
         *
         * @return {@link Tuple }
         * @author: Xin
         * @date: 2024-01-05 12:02:45
         */
        public Tuple getKTuple() {
            return new Tuple(this,this.getTuple());
        }

        /**
         * 获取cktuples
         *
         * @return {@link CKTuples }
         * @author: Xin
         * @date: 2023-12-25 15:37:13
         */
        public CKTuples getCKTuples() {
            return new CKTuples(new Tuple(this, this.getTuple()), new Constraint(""));
        }

        /**
         * 获取列
         *
         * @param columnName 列名称
         * @return {@link Graph.Column }
         * @author: Xin
         * @date: 2023-12-25 15:37:16
         */
        public Graph.Column getColumn(String columnName) {
            if (!this.columnNameMapper.containsKey(columnName))
                this.columnNameMapper.put(columnName, new Column(this, columnName));
            return this.columnNameMapper.get(columnName);
        }

        /**
         * 获取全部的列名
         *
         * @return {@link Collection }<{@link String }>
         * @author: Xin
         * @date: 2023-12-25 15:37:20
         */
        public Collection<String> allColumnNames() {
            return new ArrayList<>(this.columnNameMapper.keySet());
        }


        /**
         * 获取全部的列全名
         *
         * @return {@link Collection }<{@link String }>
         * @author: Xin
         * @date: 2023-12-25 15:38:23
         */
        public Collection<String> allFullColumnNames() {
            Collection<String> ret = new ArrayList<>();
            for (String columnName : this.columnNameMapper.keySet())
                ret.add(this.tableName + "." + columnName);
            return ret;
        }

        /**
         * toString
         *
         * @return {@link String }
         * @author: Xin
         * @date: 2023-12-25 15:38:51
         */
        @Override
        public String toString() {
            return tableName;
        }

        /**
         * 等于
         *
         * @param o o
         * @return boolean
         * @author: Xin
         * @date: 2023-12-25 15:39:07
         */
        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Table table = (Table) o;
            return Objects.equals(tableName, table.tableName);
        }

        /**
         * 散列码
         *
         * @return int
         * @author: Xin
         * @date: 2023-12-25 15:39:11
         */
        @Override
        public int hashCode() {
            return Objects.hash(tableName);
        }
    }

    /**
     * @className：Column
     * @version: 1.0.0
     * @description：列
     * @author: Xin
     * @date: 2023-12-25 15:39:14
     */
    public class Column implements Serializable {
        public Table table;
        public String columnName;

        /**
         * Column构造函数
         *
         * @param table      表格
         * @param columnName 列名
         * @author: Xin
         * @date: 2023-12-25 15:39:17
         */
        public Column(Table table, String columnName) {
            this.table = table;
            this.columnName = columnName;
        }

        /**
         * 解析列名
         *
         * @param graph      图表
         * @param columnName 列名
         * @param table      表格
         * @return {@link Pair }<{@link Table }, {@link Column }>
         * @author: Xin
         * @date: 2023-12-25 15:39:26
         */
        public static Pair<Table, Column> parseColumnName(Graph graph, String columnName, Table table) {
            if (!columnName.contains(".") && !columnName.contains(":")) {
                if (table == null)
                    return Pair.of(null, null);
                return Pair.of(table, table.getColumn(columnName));
            }

            String[] results = columnName.split(":|\\.");
            if (results.length != 2)
                return Pair.of(null, null);
            table = graph.getTable(Tools.getRealTableName(results[0]));
            return Pair.of(table, table.getColumn(results[1]));
        }

        /**
         * 到字符串
         *
         * @return {@link String }
         * @author: Xin
         * @date: 2023-12-25 15:39:50
         */
        @Override
        public String toString() {
            return this.table.tableName + "." + this.columnName;
        }

        /**
         * 等于
         *
         * @param o o
         * @return boolean
         * @author: Xin
         * @date: 2023-12-25 15:39:53
         */
        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Column column = (Column) o;
            return Objects.equals(table, column.table) && Objects.equals(columnName, column.columnName);
        }

        /**
         * 散列码
         *
         * @return int
         * @author: Xin
         * @date: 2023-12-25 15:39:55
         */
        @Override
        public int hashCode() {
            return Objects.hash(table, columnName);
        }
    }

    /**
     * Graph默认构造函数
     *
     * @author: Xin
     * @date: 2023-12-25 15:40:06
     */
    public Graph() {}

    /**
     * Graph构造函数
     *
     * @param graphName 图形名称
     * @author: Xin
     * @date: 2023-12-25 15:40:14
     */
    public Graph(String graphName) {
        this.graphName = graphName;
    }

    /**
     * 是否存在表格
     *
     * @param tableName 表格名称
     * @return boolean
     * @author: Xin
     * @date: 2023-12-25 15:40:25
     */
    public boolean existTable(String tableName) {
        return tableNameMapper.containsKey(tableName);
    }

    /**
     * 是否存在列
     *
     * @param tableName  表格名称
     * @param columnName 列名
     * @return boolean
     * @author: Xin
     * @date: 2023-12-25 15:40:33
     */
    public boolean existColumn(String tableName, String columnName) {
        if (!tableNameMapper.containsKey(tableName))
            return false;
        return tableNameMapper.get(tableName).columnNameMapper.containsKey(columnName);
    }

    /**
     * 获取全部列
     *
     * @param tableName 表格名称
     * @return {@link List }<{@link String }>
     * @author: Xin
     * @date: 2023-12-25 15:40:38
     */
    public List<String> getAllColumns(String tableName) {
        tableName = Tools.getRealTableName(tableName);
        if (!existTable(tableName))
            return null;

        Map<String, Column> targetCols = this.tableNameMapper.get(tableName).columnNameMapper;

        return new ArrayList<>(targetCols.keySet());
    }

    /**
     * 添加边
     *
     * @param src 源
     * @param dst 目标
     * @return boolean
     * @author: Xin
     * @date: 2023-12-25 15:40:43
     */
    public boolean addEdge(Node src, Node dst) {
        checkNode(src);
        checkNode(dst);

        if (src.equals(dst) || // 自环
                (edges.containsKey(src) && edges.get(src).contains(dst))) // 重复边
            return false;

        edges.map(src, dst);
        return true;
    }

    /**
     * 检查节点
     *
     * @param node 节点
     * @author: Xin
     * @date: 2023-12-25 15:41:04
     */
    private void checkNode(Node node) {
        node.name = node.name.toUpperCase();
        switch (node.nodeType) {
            case TABLE -> {
                node.name = Tools.getRealTableName(node.name);
                createTable(node.name);
            }
            case COLUMN -> {
                String tableName = Tools.getRealTableName(node.name.split(":")[0]);
                String columnName = node.name.split(":")[1];
                node.name = tableName + ":" + columnName;
                addColumn(tableName, columnName);
            }
        }
    }

    /**
     * 添加列
     *
     * @param tableName   表格名称
     * @param columnNames 列名称
     * @author: Xin
     * @date: 2023-12-25 15:41:07
     */
    public void addColumns(String tableName, String... columnNames) {
        for (String columnName : columnNames)
            addColumn(tableName, columnName);
    }

    /**
     * 添加列
     *
     * @param tableName  表格名称
     * @param columnName 列名
     * @return boolean
     * @author: Xin
     * @date: 2023-12-25 15:41:10
     */
    public boolean addColumn(String tableName, String columnName) {
        if (tableName == null || tableName.isEmpty() || columnName == null || columnName.isEmpty())
            return false;
        tableName = Tools.getRealTableName(tableName.toUpperCase());
        columnName = columnName.toUpperCase();
        createTable(tableName);
        if (existColumn(tableName, columnName))
            return false;

        Table table = tableNameMapper.get(tableName);
        Map<String, Column> columns = table.columnNameMapper;
        columns.put(columnName, new Column(table, columnName));
        return true;
    }

    int joinCount = 0;

    /**
     * 添加Join节点
     *
     * @param joinContext join文本内容
     * @return {@link Node }
     * @author: Xin
     * @date: 2023-12-25 15:41:13
     */
    public Node addJoin(String joinContext) {
        Node ret = addNode(NodeType.JOIN, "JOIN" + joinCount + NEWLINE + joinContext);
        joinCount++;
        return ret;
    }

    int whereCount = 0;

    /**
     * 添加Where节点
     *
     * @param whereContext where文本内容
     * @return {@link Node }
     * @author: Xin
     * @date: 2023-12-25 15:41:28
     */
    public Node addWhere(String whereContext) {
        Node ret = addNode(NodeType.WHERE, "WHERE" + whereCount + NEWLINE + whereContext);
        whereCount++;
        return ret;
    }

    int groupByCount = 0;

    /**
     * 添加GroupBy节点
     *
     * @param groupByContext groupBy的文本内容
     * @return {@link Node }
     * @author: Xin
     * @date: 2023-12-25 15:41:37
     */
    public Node addGroupBy(String groupByContext) {
        Node ret = addNode(NodeType.GROUP_BY, "GROUP BY" + groupByCount + NEWLINE + groupByContext);
        groupByCount++;
        return ret;
    }

    int orderByCount = 0;

    /**
     * 添加OrderBy
     *
     * @param orderByContext orderBy文本内容
     * @return {@link Node }
     * @author: Xin
     * @date: 2023-12-25 15:42:23
     */
    public Node addOrderBy(String orderByContext) {
        Node ret = addNode(NodeType.ORDER_BY, "ORDER BY" + orderByCount + NEWLINE + orderByContext);
        orderByCount++;
        return ret;
    }

    int unionCount = 0;

    /**
     * 添加union节点
     *
     * @param unionName union名
     * @return {@link Node }
     * @author: Xin
     * @date: 2023-12-25 15:42:44
     */
    public Node addUnion(String unionName) {
        Node ret = addNode(NodeType.UNION, unionName + unionCount);
        unionCount++;
        return ret;
    }

    int mergeCount = 0;

    /**
     * 添加Merge节点
     *
     * @param MergeContext merge文本内容
     * @return {@link Node }
     * @author: Xin
     * @date: 2023-12-25 15:43:23
     */
    public Node addMerge(String MergeContext) {
        Node ret = addNode(NodeType.MERGE, "MERGE" + mergeCount + NEWLINE + MergeContext);
        mergeCount++;
        return ret;
    }

    int mergeUpdateCount = 0;

    /**
     * 添加MergeUpdate节点
     *
     * @param mergeUpdateContext mergeUpdate上下文
     * @return {@link Node }
     * @author: Xin
     * @date: 2023-12-25 15:43:39
     */
    public Node addMergeUpdate(String mergeUpdateContext) {
        Node ret = addNode(NodeType.MERGE_UPDATE,
                "MATCHED -> UPDATE SET-" + mergeUpdateCount + NEWLINE + mergeUpdateContext);
        mergeUpdateCount++;
        return ret;
    }

    int mergeInsertCount = 0;

    /**
     * 添加MergeInsert节点
     *
     * @param mergeInsertContext MergeInsert文本内容
     * @return {@link Node }
     * @author: Xin
     * @date: 2023-12-25 15:44:08
     */
    public Node addMergeInsert(String mergeInsertContext) {
        Node ret = addNode(NodeType.MERGE_INSERT,
                "NOT MATCHED -> INSERT-" + mergeInsertCount + NEWLINE + mergeInsertContext);
        mergeInsertCount++;
        return ret;
    }

    int functionCount = 0;

    /**
     * 添加函数节点
     *
     * @param functionName 函数名
     * @return {@link Node }
     * @author: Xin
     * @date: 2023-12-25 15:44:33
     */
    public Node addFunction(String functionName) {
        Node ret = addNode(NodeType.FUNCTION, "FUNCTION" + functionCount + NEWLINE + functionName);
        functionCount++;
        return ret;
    }

    int caseCount = 0;

    /**
     * 添加Case节点
     *
     * @param caseContext case文本内容
     * @return {@link Node }
     * @author: Xin
     * @date: 2023-12-25 15:45:07
     */
    public Node addCase(String caseContext) {
        Node ret = addNode(NodeType.CASE, "CASE" + caseCount + NEWLINE + caseContext);
        caseCount++;
        return ret;
    }

    /**
     * 添加节点
     *
     * @param nodeType 节点类型
     * @param name     节点名
     * @return {@link Node }
     * @author: Xin
     * @date: 2023-12-25 15:45:22
     */
    private Node addNode(NodeType nodeType, String name) {
        name = name.toUpperCase();
        Node ret = new Node(nodeType, name);
        nodes.add(ret);
        return ret;
    }

    int tempTableCount = 0;

    /**
     * 添加临时表格
     *
     * @return {@link Node }
     * @author: Xin
     * @date: 2023-12-25 15:45:35
     */
    public Node addTempTable() {
        String tableName = "Temp_Table_" + tempTableCount;
        tempTableCount++;
        createTable(tableName);
        return new Node(NodeType.TABLE, tableName);
    }

    /**
     * 添加临时表格
     *
     * @param tableName 表格名
     * @return {@link Node }
     * @author: Xin
     * @date: 2023-12-25 15:45:52
     */
    public Node addTempTable(String tableName) {
        createTable(tableName);
        return new Node(NodeType.TABLE, tableName);
    }

    /**
     * 创建表格
     *
     * @param tableName 表格名
     * @return {@link Table }
     * @author: Xin
     * @date: 2023-12-25 15:45:56
     */
    public Table createTable(String tableName) {
        if (tableName == null || tableName.isEmpty())
            return null;
        tableName = Tools.getRealTableName(tableName.toUpperCase());
        if (existTable(tableName))
            return null;

        Table newTable = new Table(tableName);
        tableNameMapper.put(tableName, newTable);
        return newTable;
    }

    /**
     * 删除表格
     *
     * @param targetTableName 目标表格名
     * @return boolean
     * @author: Xin
     * @date: 2023-12-25 15:46:04
     */
    public boolean deleteTable(String targetTableName) {
        if (targetTableName == null || targetTableName.isEmpty())
            return false;
        targetTableName = targetTableName.toUpperCase();
        if (!tableNameMapper.containsKey(targetTableName))
            return false;

        // 1. 找到所有相关量
        Table targetTable = tableNameMapper.get(targetTableName);
        Map<String, Column> targetColumnNameMap = targetTable.columnNameMapper;
        Set<Column> columnsToBeDeleted = new HashSet<>();
        Set<Node> columNamesToBeDeleted = new HashSet<>();
        for (Map.Entry<String, Column> entry : targetColumnNameMap.entrySet()) {
            columnsToBeDeleted.add(entry.getValue());
            columNamesToBeDeleted.add(new Node(NodeType.COLUMN, targetTableName + ":" + entry.getValue().columnName));
        }

        // 2. 删除相关边
        for (Iterator<Map.Entry<Node, List<Node>>> srcIt = edges.entrySet().iterator(); srcIt.hasNext();) {
            Map.Entry<Node, List<Node>> srcItem = srcIt.next();
            if (columNamesToBeDeleted.contains(srcItem.getKey()))
                srcIt.remove();
            else
                edges.get(srcItem.getKey()).removeIf(columNamesToBeDeleted::contains);
        }

        // 3. 断开Column和Table之间的关系
        for (Column c : columnsToBeDeleted)
            c.table = null;
        // 4. 解除 ColumnName->Column 映射
        targetColumnNameMap.clear();
        // 6. 解除 TableName->Table 映射
        tableNameMapper.remove(targetTableName);

        return true;
    }

    /**
     * 修改表格名
     *
     * @param fromTableName 从…起表格名
     * @param toTableName   到表格名
     * @return boolean
     * @author: Xin
     * @date: 2023-12-25 15:46:14
     */
    public boolean changeTableName(String fromTableName, String toTableName) {
        fromTableName = fromTableName.toUpperCase();
        toTableName = toTableName.toUpperCase();

        if (fromTableName.equals(toTableName) || !tableNameMapper.containsKey(fromTableName))
            return false;

        Table targetTable = tableNameMapper.get(fromTableName);
        targetTable.tableName = toTableName;
        tableNameMapper.remove(fromTableName);
        tableNameMapper.put(toTableName, targetTable);

        return true;
    }

    /**
     * 修改列名
     *
     * @param targetTableName 目标表格名
     * @param fromColumnName  从…起列名
     * @param toColumnName    到列名
     * @return boolean
     * @author: Xin
     * @date: 2023-12-25 15:46:23
     */
    public boolean changeColumnName(String targetTableName, String fromColumnName, String toColumnName) {
        targetTableName = targetTableName.toUpperCase();
        fromColumnName = fromColumnName.toUpperCase();
        toColumnName = toColumnName.toUpperCase();

        if (fromColumnName.equals(toColumnName) || !tableNameMapper.containsKey(targetTableName))
            return false;

        Table targetTable = tableNameMapper.get(targetTableName);
        Map<String, Column> columnMapper = targetTable.columnNameMapper;
        if (!columnMapper.containsKey(fromColumnName))
            return false;

        Column targetColumn = columnMapper.get(fromColumnName);
        targetColumn.columnName = toColumnName;
        columnMapper.remove(fromColumnName);
        columnMapper.put(toColumnName, targetColumn);

        return true;
    }

    /**
     * 合并表格
     *
     * @param srcTableName 源表格名
     * @param dstTableName 目标表格名
     * @return boolean
     * @author: Xin
     * @date: 2023-12-25 15:46:30
     */
    public boolean mergeTable(String srcTableName, String dstTableName) {
        srcTableName = srcTableName.toUpperCase();
        dstTableName = dstTableName.toUpperCase();

        if (srcTableName.equals(dstTableName) ||
                !existTable(srcTableName) ||
                !existTable(dstTableName))
            return false;

        // 1. 查询相关结构
        Table srcTable = tableNameMapper.get(srcTableName);
        Table dstTable = tableNameMapper.get(dstTableName);
        Map<String, Column> srcColumns = srcTable.columnNameMapper;
        Map<String, Column> dstColumns = dstTable.columnNameMapper;

        // 2. 将源表的列条目合并入目标表
        for (Map.Entry<String, Column> entry : srcColumns.entrySet()) {
            String srcColumnName = entry.getKey();
            Column srcColumn = entry.getValue();
            // 目标表中已经存在同名列，跳过
            if (dstColumns.containsKey(srcColumnName))
                continue;

            // 将源列挂在目标表下，并添加查找条目
            srcColumn.table = dstTable;
            dstColumns.put(srcColumnName, srcColumn);
        }

        // 3. 删除源表
        srcColumns.clear();
        srcTable.columnNameMapper = null;
        tableNameMapper.remove(srcTableName);

        return true;
    }

    /**
     * 获取表格
     *
     * @param tableName 表格名
     * @return {@link Table }
     * @author: Xin
     * @date: 2023-12-25 15:46:35
     */
    public Table getTable(String tableName) {
        if (!existTable(tableName))
            return null;
        return this.tableNameMapper.get(tableName);
    }

    /**
     * 将graph转换为dot格式文件
     *
     * @return {@link String }
     * @author: Xin
     * @date: 2023-12-25 15:46:39
     */
    public String toDOT() {
        StringBuilder buf = new StringBuilder();

        buf.append(diagraph).append(graphName).append(" {\n");
        buf.append(digraphConfigure);
        buf.append(nodeConfigure);
        buf.append(edgeConfigure);
        buf.append(NEWLINE).append(NEWLINE).append(NEWLINE);
        dotDrawNodes(buf);
        buf.append(NEWLINE).append(NEWLINE).append(NEWLINE);
        dotDrawTablesAndColumns(buf);
        buf.append(NEWLINE).append(NEWLINE).append(NEWLINE);
        dotDrawEdges(buf);

        return buf.toString();
    }

    /**
     * dot版本的绘制表和列
     *
     * @param buf buf
     * @author: Xin
     * @date: 2023-12-25 15:47:08
     */
    private void dotDrawTablesAndColumns(StringBuilder buf) {
        for (Map.Entry<String, Table> entry : tableNameMapper.entrySet()) {
            String tableName = entry.getKey();
            Table table = entry.getValue();
            Map<String, Column> columns = table.columnNameMapper;

            buf.append(QUOTE).append(tableName).append(QUOTE).append(" [");

            buf.append("label=<\n<table border=\"0\" cellspacing=\"0\" cellborder=\"1\">\n");
            buf.append("<tr><td bgcolor=\"lightblue2\"><i>").append(tableName).append("</i></td></tr>").append(NEWLINE);

            for (Map.Entry<String, Column> entry1 : columns.entrySet()) {
                Column column = entry1.getValue();
                buf.append("  <tr><td port=\"").append(column.columnName).append("\">").append(column.columnName)
                        .append("</td></tr>").append(NEWLINE);
            }

            buf.append("</table>>];\n");
            buf.append(NEWLINE).append(NEWLINE);
        }
        buf.append(NEWLINE);
    }

    /**
     * dot版本的绘制节点
     *
     * @param buf 缓冲区
     * @author: Xin
     * @date: 2023-12-25 15:47:45
     */
    private void dotDrawNodes(StringBuilder buf) {
        String attribute = "[shape=\"%s\", color=\"%s\", style=filled]";
        String certainAttribute;
        for (Node node : nodes) {
            buf.append(QUOTE).append(node.name).append(QUOTE);

            certainAttribute = switch (node.nodeType) {
                case JOIN -> String.format(attribute, "parallelogram", "lightblue2");
                case WHERE -> String.format(attribute, "diamond", "lightblue2");
                case GROUP_BY -> String.format(attribute, "trapezium", "lightblue2");
                case ORDER_BY -> String.format(attribute, "house", "lightblue2");
                case FUNCTION -> String.format(attribute, "cds", "lightyellow2");
                case UNION -> String.format(attribute, "circle", "lightblue2");
                case CASE -> String.format(attribute, "rectangle", "lightyellow2");
                case MERGE -> String.format(attribute, "polygon", "lightblue2");
                case MERGE_UPDATE -> String.format(attribute, "fivepoverhang", "lightblue2");
                case MERGE_INSERT -> String.format(attribute, "primersite", "lightblue2");
                default -> "";
            };

            buf.append(certainAttribute).append(SEMI).append(NEWLINE);
        }
    }

    /**
     * dot版本的绘制边
     *
     * @param buf 缓冲区
     * @author: Xin
     * @date: 2023-12-25 15:47:55
     */
    private void dotDrawEdges(StringBuilder buf) {
        String attribute = "[style=\"%s\", color=\"%s\", ]";
        String certainAttribute = "";
        for (Map.Entry<Node, List<Node>> edge : edges.entrySet()) {
            Node src = edge.getKey();
            for (Node dst : edge.getValue()) {
                buf.append(quote(src));
                buf.append(" -> ");
                buf.append(quote(dst));

                certainAttribute = switch (src.nodeType) {
                    case TABLE, JOIN, WHERE, GROUP_BY, ORDER_BY, UNION, MERGE, MERGE_UPDATE, MERGE_INSERT ->
                        String.format(attribute, "dotted", "blue");
                    case COLUMN, QUOTED_STRING, FUNCTION, CASE ->
                        String.format(attribute, "bold", "black");
                };

                buf.append(certainAttribute).append(SEMI).append(NEWLINE);
            }
        }
        buf.append("}\n");
    }

    /**
     * 将graph转换为json格式文件
     *
     * @return {@link String }
     * @author: Xin
     * @date: 2023-12-25 15:48:12
     */
    public String toJSON() {
        Gson gson = new Gson();
        GraphJSON graphJSON = new GraphJSON();

        jsonDrawTablesAndColumns(graphJSON);
        jsonDrawNodes(graphJSON);
        jsonDrawEdges(graphJSON);

        return gson.toJson(graphJSON);
    }

    /**
     * json版本的绘制表和列
     *
     * @param graphJSON 图形json
     * @author: Xin
     * @date: 2023-12-25 15:48:26
     */
    private void jsonDrawTablesAndColumns(GraphJSON graphJSON) {
        for (Map.Entry<String, Table> entry : tableNameMapper.entrySet())
            graphJSON.addTable(entry.getValue());
    }

    /**
     * json版本的绘制节点
     *
     * @param graphJSON 图形json
     * @author: Xin
     * @date: 2023-12-25 15:48:35
     */
    private void jsonDrawNodes(GraphJSON graphJSON) {
        for (Node node : nodes)
            graphJSON.addNode(node);
    }

    /**
     * json版本的绘制边
     *
     * @param graphJSON 图形json
     * @author: Xin
     * @date: 2023-12-25 15:48:39
     */
    private void jsonDrawEdges(GraphJSON graphJSON) {
        for (Map.Entry<Node, List<Node>> edge : edges.entrySet()) {
            Node src = edge.getKey();
            for (Node dst : edge.getValue())
                graphJSON.addEdge(src, dst);
        }
    }

    /**
     * 给节点添加引号
     *
     * @param node 节点
     * @return {@link String }
     * @author: Xin
     * @date: 2023-12-25 15:48:42
     */
    private String quote(Node node) {
        return switch (node.nodeType) {
            case COLUMN -> QUOTE + node.name.split(":")[0] + QUOTE + ":" + QUOTE + node.name.split(":")[1] + QUOTE;
            default -> QUOTE + node.name + QUOTE;
        };
    }

    public Map<String, Table> getTableNameMapper() {
        return tableNameMapper;
    }
}
