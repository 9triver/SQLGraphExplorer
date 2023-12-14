package cn.edu.nju.graph;

import cn.edu.nju.PlSqlVisitor;
import cn.edu.nju.expression.Scheme;
import cn.edu.nju.expression.cktuple.tuple.ColumnNode;
import cn.edu.nju.expression.cktuple.tuple.TupleBaseNode;
import cn.edu.nju.graph.json.GraphJSON;
import com.google.gson.Gson;
import org.antlr.v4.runtime.misc.MultiMap;

import java.io.Serializable;
import java.util.*;

public class Graph implements Serializable{
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

    public class Table implements Serializable{
        public String tableName;
        public Map<String, Column> columnNameMapper;

        public Table(String tableName) {
            this.tableName = tableName;
            this.columnNameMapper = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        }

        public Scheme allScheme() {
            Set<Graph.Column> ret = new HashSet<>();
            for (Map.Entry<String, Graph.Column> entry : this.columnNameMapper.entrySet())
                ret.add(entry.getValue());
            return new Scheme(ret);
        }

        public Scheme scheme(String ... columnNames) {
            Set<Graph.Column> ret = new HashSet<>();
            for (String columnName : columnNames)
                if (this.columnNameMapper.containsKey(columnName))
                    ret.add(this.columnNameMapper.get(columnName));
            return new Scheme(ret);
        }
        public Set<TupleBaseNode> getTuple() {
            Set<TupleBaseNode> ret = new HashSet<>();
            for(Graph.Column column : this.allScheme().getColumns())
                ret.add(new ColumnNode(column, column));
            return ret;
        }
        public Graph.Column getColumn(String columnName) {
            return this.columnNameMapper.get(columnName);
        }

        public Collection<String> allColumnNames() {
            return new ArrayList<>(this.columnNameMapper.keySet());
        }
        public Collection<String> allFullColumnNames() {
            Collection<String> ret = new ArrayList<>();
            for(String columnName : this.columnNameMapper.keySet())
                ret.add(this.tableName + "." + columnName);
            return ret;
        }


        @Override
        public String toString() {
            return "Table{" +
                    "tableName='" + tableName + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Table table = (Table) o;
            return Objects.equals(tableName, table.tableName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(tableName);
        }
    }

    public class Column implements Serializable {
        public Table table;
        public String columnName;
        public Column(Table table, String columnName) {
            this.table = table;
            this.columnName = columnName;
        }
        @Override
        public String toString() {
            return this.table.tableName+"."+this.columnName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Column column = (Column) o;
            return Objects.equals(table, column.table) && Objects.equals(columnName, column.columnName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(table, columnName);
        }
    }

    public Graph() {
    }

    public Graph(String graphName) {
        this.graphName = graphName;
    }

    public boolean existTable(String tableName) {
        return tableNameMapper.containsKey(tableName);
    }

    public boolean existColumn(String tableName, String columnName) {
        if (!tableNameMapper.containsKey(tableName))
            return false;
        return tableNameMapper.get(tableName).columnNameMapper.containsKey(columnName);
    }

    public List<String> getAllColumns(String tableName) {
        tableName = PlSqlVisitor.getRealTableName(tableName);
        if (!existTable(tableName))
            return null;

        Map<String, Column> targetCols = this.tableNameMapper.get(tableName).columnNameMapper;

        return new ArrayList<>(targetCols.keySet());
    }

    public boolean addEdge(Node src, Node dst) {
        checkNode(src);
        checkNode(dst);

        if (src.equals(dst) || // 自环
                (edges.containsKey(src) && edges.get(src).contains(dst))) // 重复边
            return false;

        edges.map(src, dst);
        return true;
    }

    private void checkNode(Node node) {
        node.name = node.name.toUpperCase();
        switch (node.nodeType) {
            case TABLE -> {
                node.name = PlSqlVisitor.getRealTableName(node.name);
                createTable(node.name);
            }
            case COLUMN -> {
                String tableName = PlSqlVisitor.getRealTableName(node.name.split(":")[0]);
                String columnName = node.name.split(":")[1];
                node.name = tableName + ":" + columnName;
                addColumn(tableName, columnName);
            }
        }
    }

    public void addColumns(String tableName, String ... columnNames) {
        for (String columnName:columnNames)
            addColumn(tableName, columnName);
    }

    public boolean addColumn(String tableName, String columnName) {
        if (tableName == null || tableName.isEmpty() || columnName == null || columnName.isEmpty())
            return false;
        tableName = PlSqlVisitor.getRealTableName(tableName.toUpperCase());
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

    public Node addJoin(String joinContext) {
        Node ret = addNode(NodeType.JOIN, "JOIN" + joinCount + NEWLINE + joinContext);
        joinCount++;
        return ret;
    }

    int whereCount = 0;

    public Node addWhere(String whereContext) {
        Node ret = addNode(NodeType.WHERE, "WHERE" + whereCount + NEWLINE + whereContext);
        whereCount++;
        return ret;
    }

    int groupByCount = 0;

    public Node addGroupBy(String groupByContext) {
        Node ret = addNode(NodeType.GROUP_BY, "GROUP BY" + groupByCount + NEWLINE + groupByContext);
        groupByCount++;
        return ret;
    }

    int orderByCount = 0;

    public Node addOrderBy(String orderByContext) {
        Node ret = addNode(NodeType.ORDER_BY, "ORDER BY" + orderByCount + NEWLINE + orderByContext);
        orderByCount++;
        return ret;
    }

    int unionCount = 0;

    public Node addUnion(String unionName) {
        Node ret = addNode(NodeType.UNION, unionName + unionCount);
        unionCount++;
        return ret;
    }

    int mergeCount = 0;

    public Node addMerge(String MergeContext) {
        Node ret = addNode(NodeType.MERGE, "MERGE" + mergeCount + NEWLINE + MergeContext);
        mergeCount++;
        return ret;
    }

    int mergeUpdateCount = 0;

    public Node addMergeUpdate(String MergeUpdateContext) {
        Node ret = addNode(NodeType.MERGE_UPDATE,
                "MATCHED -> UPDATE SET-" + mergeUpdateCount + NEWLINE + MergeUpdateContext);
        mergeUpdateCount++;
        return ret;
    }

    int mergeInsertCount = 0;

    public Node addMergeInsert(String MergeInsertContext) {
        Node ret = addNode(NodeType.MERGE_INSERT,
                "NOT MATCHED -> INSERT-" + mergeInsertCount + NEWLINE + MergeInsertContext);
        mergeInsertCount++;
        return ret;
    }

    int functionCount = 0;

    public Node addFunction(String functionName) {
        Node ret = addNode(NodeType.FUNCTION, "FUNCTION" + functionCount + NEWLINE + functionName);
        functionCount++;
        return ret;
    }

    int caseCount = 0;

    public Node addCase(String caseContext) {
        Node ret = addNode(NodeType.CASE, "CASE" + caseCount + NEWLINE + caseContext);
        caseCount++;
        return ret;
    }

    private Node addNode(NodeType nodeType, String name) {
        name = name.toUpperCase();
        Node ret = new Node(nodeType, name);
        nodes.add(ret);
        return ret;
    }

    int tempTableCount = 0;

    public Node addTempTable() {
        String tableName = "Temp-Table-" + tempTableCount;
        tempTableCount++;
        createTable(tableName);
        return new Node(NodeType.TABLE, tableName);
    }

    public Node addTempTable(String tableName) {
        createTable(tableName);
        return new Node(NodeType.TABLE, tableName);
    }

    public Table createTable(String tableName) {
        if (tableName == null || tableName.isEmpty())
            return null;
        tableName = PlSqlVisitor.getRealTableName(tableName.toUpperCase());
        if (existTable(tableName))
            return null;

        Table newTable = new Table(tableName);
        tableNameMapper.put(tableName, newTable);
        return newTable;
    }

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

    public Table getTable(String tableName) {
        if(!existTable(tableName)) return null;
        return this.tableNameMapper.get(tableName);
    }

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

    public String toJSON() {
        Gson gson = new Gson();
        GraphJSON graphJSON = new GraphJSON();

        jsonDrawTablesAndColumns(graphJSON);
        jsonDrawNodes(graphJSON);
        jsonDrawEdges(graphJSON);

        return gson.toJson(graphJSON);
    }

    private void jsonDrawTablesAndColumns(GraphJSON graphJSON) {
        for (Map.Entry<String, Table> entry : tableNameMapper.entrySet())
            graphJSON.addTable(entry.getValue());
    }
    private void jsonDrawNodes(GraphJSON graphJSON) {
        for (Node node : nodes)
            graphJSON.addNode(node);
    }
    private void jsonDrawEdges(GraphJSON graphJSON) {
        for (Map.Entry<Node, List<Node>> edge : edges.entrySet()) {
            Node src = edge.getKey();
            for (Node dst : edge.getValue())
                graphJSON.addEdge(src,dst);
        }
    }

    private String quote(Node node) {
        return switch (node.nodeType) {
            case COLUMN -> QUOTE + node.name.split(":")[0] + QUOTE + ":" + QUOTE + node.name.split(":")[1] + QUOTE;
            default -> QUOTE + node.name + QUOTE;
        };
    }
}
