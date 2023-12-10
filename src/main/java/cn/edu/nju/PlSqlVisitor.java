package cn.edu.nju;

import cn.edu.nju.Tools.Tools;
import cn.edu.nju.graph.Graph;
import cn.edu.nju.graph.Node;
import cn.edu.nju.graph.NodeType;
import com.google.common.collect.Lists;
import grammar.PlSqlLexer;
import grammar.PlSqlParser;
import grammar.PlSqlParserBaseVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Interval;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.URISyntaxException;
import java.util.*;

public class PlSqlVisitor extends PlSqlParserBaseVisitor<String> {
    private static final Logger log = Logger.getLogger(PlSqlVisitor.class);
    private String curDstTableName = "";
    private final Graph graph;
    private static final Map<String, String> realTableNameMapper = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    public PlSqlVisitor() {
        this.graph = new Graph();
    }
    public PlSqlVisitor(String curDstTableName) {
        this.curDstTableName = curDstTableName;
        this.graph = new Graph(curDstTableName);
    }

    @Override
    public String visitSql_script(PlSqlParser.Sql_scriptContext ctx) {
        tableSrc.add(new Node(NodeType.TABLE, this.curDstTableName));
        String ret = visitChildren(ctx);

        tableSrcNormalPop();

        return ret;
    }

    @Override
    public String visitFactoring_element(PlSqlParser.Factoring_elementContext ctx) {
        String queryName = ctx.query_name().getText();
        Node tempTable = this.graph.addTempTable(queryName);
        tableSrc.add(tempTable);
        updateAliasTableName(tempTable.name,tempTable.name);

        if(ctx.paren_column_list() != null) visitParen_column_list(ctx.paren_column_list());
        visitSubquery(ctx.subquery());
        if(ctx.order_by_clause() != null) visitOrder_by_clause(ctx.order_by_clause());
        if(ctx.search_clause() != null) visitSearch_clause(ctx.search_clause());
        if(ctx.cycle_clause() != null) visitCycle_clause(ctx.cycle_clause());

        tableSrc.pop();
        return ctx.getText();
    }

    @Override
    public String visitSubquery(PlSqlParser.SubqueryContext ctx) {
        if (ctx.subquery_operation_part() != null &&
                !ctx.subquery_operation_part().isEmpty() &&
                ctx.subquery_operation_part(0).UNION() != null) {
            Node unionNode = graph.addUnion("UNION");
            tableSrc.add(unionNode);
        }

        visitSubquery_basic_elements(ctx.subquery_basic_elements());

        if (ctx.subquery_operation_part() != null &&
                !ctx.subquery_operation_part().isEmpty())
            for (PlSqlParser.Subquery_operation_partContext sub_op_ctx : ctx.subquery_operation_part())
                visitSubquery_operation_part(sub_op_ctx);

        return ctx.getText();
    }

    private Stack<String> tableRefs = new Stack<>();
    private Stack<Node> columnSrc = new Stack<>();
    private Map<PlSqlParser.Query_blockContext, Integer> tableRefsSize = new HashMap<>();
    @Override
    public String visitQuery_block(PlSqlParser.Query_blockContext ctx) {
        Node base = tableSrc.peek();
        int tableRefsOldSize = tableRefs.size();
        int tableSrcOldSize = tableSrc.size();

        // From -> Where? -> GroupBy? -> OrderBy? -> dstTable/union(out of select)
        if(ctx.order_by_clause() != null) { // OrderBy -> dstTable/union
            this.tableSrc.add(this.graph.addOrderBy(visitOrder_by_clause(ctx.order_by_clause())));
            tableSrcPopDst();
        }
        if(ctx.group_by_clause() != null) { // GroupBy -> OrderBy
            this.tableSrc.add(this.graph.addGroupBy(visitGroup_by_clause(ctx.group_by_clause())));
            tableSrcPopDst();
        }
        if (ctx.where_clause() != null) { // Where -> GroupBy
            this.tableSrc.add(this.graph.addWhere(visitWhere_clause(ctx.where_clause())));
            tableSrcPopDst();
        }
        // From -> Where
        Node dst = this.tableSrc.peek();
        visitFrom_clause(ctx.from_clause());
        while(this.tableSrc.size() > tableSrcOldSize)
            this.graph.addEdge(this.tableSrc.pop(),dst);
        // reverse base
        this.tableSrc.pop();
        this.tableSrc.add(base);
        if(base.nodeType == NodeType.TABLE)
            this.curDstTableName = tableSrc.peek().name;

        if (ctx.selected_list() != null) {
            this.tableRefsSize.put(ctx, tableRefsOldSize);
            visitSelected_list(ctx.selected_list());
            this.tableRefsSize.remove(ctx);
        }

        while(tableRefs.size() > tableRefsOldSize) tableRefs.pop();
        return ctx.getText();
    }
    @Override
    public String visitSelected_list(PlSqlParser.Selected_listContext ctx) {
        if(ctx.select_list_elements() != null && !ctx.select_list_elements().isEmpty())
            for(PlSqlParser.Select_list_elementsContext slCtx : ctx.select_list_elements())
                visitSelect_list_elements(slCtx);
        else { // '*'
            int oldSize = this.tableRefsSize.get((PlSqlParser.Query_blockContext)(ctx.parent));
            while(this.tableRefs.size() > oldSize) {
                String srcTableName = this.tableRefs.pop();
                List<String> allColNames = this.graph.getAllColumns(srcTableName);
                for(String colName : allColNames) {
                    columnSrc.add(new Node(NodeType.COLUMN, this.curDstTableName + ":" + colName));
                    columnSrc.add(new Node(NodeType.COLUMN, srcTableName + ":" + colName));
                    columnSrcNormalPop();
                }
            }
        }
        return ctx.getText();
    }
    @Override
    public String visitSelect_list_elements(PlSqlParser.Select_list_elementsContext ctx) {
        if(ctx.tableview_name() != null) {
            String srcTableName = PlSqlVisitor.getRealTableName(ctx.tableview_name().getText());
            List<String> allColNames = this.graph.getAllColumns(srcTableName);
            for(String colName : allColNames) {
                columnSrc.add(new Node(NodeType.COLUMN, this.curDstTableName + ":" + colName));
                columnSrc.add(new Node(NodeType.COLUMN, srcTableName + ":" + colName));
                columnSrcNormalPop();
            }
        }
        else if(ctx.expression() != null) {
            visitExpression(ctx.expression());
            Node srcColumn = columnSrc.pop();

            if (ctx.column_alias() != null)
                visitColumn_alias(ctx.column_alias());
            else if(srcColumn.nodeType == NodeType.COLUMN)
                columnSrc.add(new Node(NodeType.COLUMN, this.curDstTableName + ":" + srcColumn.name.split(":")[1]));
            else
                columnSrc.add(srcColumn);

            columnSrc.add(srcColumn);
            columnSrcNormalPop();
        }
        return ctx.getText();
    }

    @Override
    public String visitSearched_case_statement(PlSqlParser.Searched_case_statementContext ctx) {
        if(ctx.ln2 != null)
            columnSrc.add(new Node(NodeType.COLUMN, this.curDstTableName + ":" + ctx.ln2.getText()));


        String caseContext = Tools.getFullContext(ctx);
        Node caseNode = graph.addCase(caseContext);
        columnSrc.add(caseNode);

        for (PlSqlParser.Searched_case_when_partContext caseWhenPartContext : ctx.searched_case_when_part())
            visitSearched_case_when_part(caseWhenPartContext);

        if (ctx.case_else_part() != null)
            visitCase_else_part(ctx.case_else_part());

        return caseContext;
    }

    @Override
    public String visitSearched_case_when_part(PlSqlParser.Searched_case_when_partContext ctx) {
        if (ctx.seq_of_statements() != null)
            return visitChildren(ctx);

        // 只访问THEM后的expression，因为只有它可能是源列
        int oldSize = columnSrc.size();
        visitExpression(ctx.expression(1));
        int newSize = columnSrc.size();
        if (newSize > oldSize)
            columnSrcNormalPop();
        return ctx.getText();
    }

    @Override
    public String visitCase_else_part(PlSqlParser.Case_else_partContext ctx) {
        if (ctx.seq_of_statements() != null)
            return visitChildren(ctx);

        int oldSize = columnSrc.size();
        visitExpression(ctx.expression());
        int newSize = columnSrc.size();
        if (newSize > oldSize)
            columnSrcNormalPop();
        return ctx.getText();
    }

    @Override
    public String visitColumn_alias(PlSqlParser.Column_aliasContext ctx) {
        if (ctx.identifier() != null)
            columnSrc.add(new Node(NodeType.COLUMN, this.curDstTableName + ":" + ctx.identifier().getText()));
        if (ctx.quoted_string() != null)
            columnSrc.add(new Node(NodeType.QUOTED_STRING, ctx.quoted_string().getText()));
        return ctx.getText();
    }

    @Override
    public String visitQuoted_string(PlSqlParser.Quoted_stringContext ctx) {
        columnSrc.add(new Node(NodeType.QUOTED_STRING, ctx.getText()));
        return ctx.getText();
    }

    @Override
    public String visitGeneral_element(PlSqlParser.General_elementContext ctx) {
        if(ctx.general_element_part().size() == 2) { // Table.Column
            String fullColumnName = ctx.general_element_part(0).getText() + ":" + ctx.general_element_part(1).getText();
            this.columnSrc.add(new Node(NodeType.COLUMN, fullColumnName));
            return fullColumnName;
        }
        else if(ctx.general_element_part().size() == 1) { // Column or Function
            PlSqlParser.General_element_partContext generalElementPartContext = ctx.general_element_part(0);
            String text = generalElementPartContext.getText();
            if(generalElementPartContext.function_argument() == null) { // Column
                text = this.findSrcTable(text) + ":" + text;
                this.columnSrc.add(new Node(NodeType.COLUMN, text));
            }
            else // Function
                this.columnSrc.add(this.graph.addFunction(text));

            return text;
        }
        return visitChildren(ctx);
    }
    @Override
    public String visitColumn_name(PlSqlParser.Column_nameContext ctx) {
        if(ctx.id_expression() == null || ctx.id_expression().size() != 1)
            return ctx.getText();

        // Table.Column
        String tableName = ctx.identifier().getText();
        String columnName = ctx.id_expression(0).getText();
        columnSrc.add(new Node(NodeType.COLUMN, tableName+":"+columnName));
        return tableName+":"+columnName;
    }

    Stack<Node> tableSrc = new Stack<>();
    @Override
    public String visitFrom_clause(PlSqlParser.From_clauseContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitWhere_clause(PlSqlParser.Where_clauseContext ctx) {
        if(ctx.expression() == null)
            return null;

        // 不再继续向下访问
        return Tools.getFullContext(ctx.expression());
    }

    @Override
    public String visitGroup_by_clause(PlSqlParser.Group_by_clauseContext ctx) {
        // 不再继续向下访问
        return Tools.getFullContext(ctx);
    }

    @Override
    public String visitOrder_by_clause(PlSqlParser.Order_by_clauseContext ctx) {
        // 不再继续向下访问
        return Tools.getFullContext(ctx);
    }

    @Override
    public String visitTable_ref(PlSqlParser.Table_refContext ctx) {
        visitTable_ref_aux(ctx.table_ref_aux());

        if (ctx.join_clause() != null && !ctx.join_clause().isEmpty()) {
            for (PlSqlParser.Join_clauseContext join_clause_ctx : ctx.join_clause()) {
                String joinTypeWithCondition = visitJoin_clause(join_clause_ctx);
                String joinType = joinTypeWithCondition.split("@")[0];
                String condition = joinTypeWithCondition.split("@")[1];

                Node src1 = tableSrc.pop();
                Node src2 = tableSrc.pop();
                Node dst = graph.addJoin(joinType + condition);
                tableSrc.add(dst);
                this.graph.addEdge(src1, dst);
                this.graph.addEdge(src2, dst);
            }
        }

        return ctx.getText();
    }

    @Override
    public String visitTable_ref_aux(PlSqlParser.Table_ref_auxContext ctx) {
        String srcTableName = ctx.table_ref_aux_internal().getText();
        if (!srcTableName.isEmpty() && !Character.isLetter(srcTableName.charAt(0))) { // 嵌套select，需要中间缓存表
            Node tempTable = graph.addTempTable();
            srcTableName = tempTable.name;
            tableSrc.add(tempTable);
        }

        String ret = visitChildren(ctx);

        String aliasTableName = srcTableName;
        if (ctx.table_alias() != null)
            aliasTableName = ctx.table_alias().getText();
        PlSqlVisitor.updateAliasTableName(srcTableName, aliasTableName);

        // 记录此次select中from子句中出现的源表
        this.tableRefs.push(PlSqlVisitor.getRealTableName(srcTableName));

        return ret;
    }

    @Override
    public String visitTableview_name(PlSqlParser.Tableview_nameContext ctx) {
        tableSrc.add(new Node(NodeType.TABLE, ctx.getText()));
        return ctx.getText();
    }

    @Override
    public String visitTable_alias(PlSqlParser.Table_aliasContext ctx) {
        return ctx.getText();
    }

    @Override
    /**
     * 返回 JoinType @ Condition
     */
    public String visitJoin_clause(PlSqlParser.Join_clauseContext ctx) {
        visitTable_ref_aux(ctx.table_ref_aux());

        String joinType = "";
        if (ctx.CROSS() != null)
            joinType += ctx.CROSS().getText() + " ";
        if (ctx.NATURAL() != null)
            joinType += ctx.NATURAL().getText() + " ";
        if (ctx.INNER() != null)
            joinType += ctx.INNER().getText() + " ";
        if (ctx.outer_join_type() != null)
            joinType += ctx.outer_join_type().getText() + " ";
        joinType += "JOIN\n";

        StringBuilder condition = new StringBuilder();
        if (ctx.join_on_part() != null)
            for (PlSqlParser.Join_on_partContext join_on_ctx : ctx.join_on_part())
                condition.append(Tools.getFullContext(join_on_ctx.condition()));

        return joinType + "@" + condition;
    }


    @Override
    public String visitSingle_table_insert(PlSqlParser.Single_table_insertContext ctx) {
        if (ctx.select_statement() == null) {
            // TODO : insert语句没有select子句
            return ctx.getText();
        }

        // TODO : insert...values...

        visitInsert_into_clause(ctx.insert_into_clause());

        if (ctx.select_statement() != null)
            visitSelect_statement(ctx.select_statement());

        tableSrcNormalPop();

        return ctx.getText();
    }

    @Override
    public String visitInsert_into_clause(PlSqlParser.Insert_into_clauseContext ctx) {
        String insertDstTable = ctx.general_table_ref().getText();
        this.curDstTableName = insertDstTable;
        tableSrc.add(new Node(NodeType.TABLE, insertDstTable));
        if (ctx.paren_column_list() == null) {
            // TODO : INSERT INTO TABLE ，没有给出目标表的列名
            return ctx.getText();
        }

        for (PlSqlParser.Column_nameContext column_nameContext : ctx.paren_column_list().column_list().column_name())
            graph.addColumn(this.curDstTableName, column_nameContext.getText());

        return ctx.getText();
    }

    @Override
    public String visitSubstr_function(PlSqlParser.Substr_functionContext ctx) {
        String functionName = Tools.getFullContext(ctx);
        Node functionNode = graph.addFunction(functionName);
        columnSrc.add(functionNode);
        // arg1
        visitExpression(ctx.expression(0));
        columnSrcNormalPop();
        // arg2
        visitExpression(ctx.expression(1));
        columnSrcNormalPop();
        // arg3?
        if (ctx.expression().size() > 2) {
            visitExpression(ctx.expression(2));
            columnSrcNormalPop();
        }
        return functionName;
    }
    @Override
    public String visitTo_char_function(PlSqlParser.To_char_functionContext ctx) {
        String functionName = Tools.getFullContext(ctx);
        Node functionNode = graph.addFunction(functionName);
        columnSrc.add(functionNode);
        // arg1
        if (ctx.table_element() != null) {
            visitTable_element(ctx.table_element());
            columnSrcNormalPop();
        }
        if (ctx.standard_function() != null) {
            visitStandard_function(ctx.standard_function());
            columnSrcNormalPop();
        }
        if (ctx.expression() != null) {
            visitExpression(ctx.expression());
            columnSrcNormalPop();
        }
        // arg2? arg3?
        if (ctx.quoted_string() != null) {
            for (PlSqlParser.Quoted_stringContext quotedStringCtx : ctx.quoted_string()) {
                visitQuoted_string(quotedStringCtx);
                columnSrcNormalPop();
            }
        }
        return functionName;
    }
    @Override
    public String visitDecode_function(PlSqlParser.Decode_functionContext ctx) {
        String functionName = Tools.getFullContext(ctx);
        Node functionNode = graph.addFunction(functionName);
        columnSrc.add(functionNode);
        // args...
        for (PlSqlParser.ExpressionContext expressionCtx : ctx.expressions().expression()) {
            visitExpression(expressionCtx);
            columnSrcNormalPop();
        }
        return functionName;
    }
    @Override
    public String visitChr_function(PlSqlParser.Chr_functionContext ctx) {
        String functionName = Tools.getFullContext(ctx);
        Node functionNode = graph.addFunction(functionName);
        columnSrc.add(functionNode);
        // arg1
        visitConcatenation(ctx.concatenation());
        columnSrcNormalPop();
        return functionName;
    }
    @Override
    public String visitNvl_function(PlSqlParser.Nvl_functionContext ctx) {
        String functionName = Tools.getFullContext(ctx);
        Node functionNode = graph.addFunction(functionName);
        columnSrc.add(functionNode);
        // arg1, arg2
        for (PlSqlParser.ExpressionContext expressionCtx : ctx.expression()) {
            visitExpression(expressionCtx);
            columnSrcNormalPop();
        }
        return functionName;
    }
    @Override
    public String visitTrim_function(PlSqlParser.Trim_functionContext ctx) {
        String functionName = Tools.getFullContext(ctx);
        Node functionNode = graph.addFunction(functionName);
        columnSrc.add(functionNode);
        // arg1
        if (ctx.expression() != null) {
            visitExpression(ctx.expression());
            columnSrcNormalPop();
        }
        // arg2
        visitConcatenation(ctx.concatenation());
        columnSrcNormalPop();
        return functionName;
    }
    @Override
    public String visitTo_date_function(PlSqlParser.To_date_functionContext ctx) {
        String functionName = Tools.getFullContext(ctx);
        Node functionNode = graph.addFunction(functionName);
        columnSrc.add(functionNode);
        // arg1
        if (ctx.table_element() != null) {
            visitTable_element(ctx.table_element());
            columnSrcNormalPop();
        }
        if (ctx.standard_function() != null) {
            visitStandard_function(ctx.standard_function());
            columnSrcNormalPop();
        }
        if (ctx.expression() != null) {
            visitExpression(ctx.expression());
            columnSrcNormalPop();
        }
        // arg2?
        if (ctx.concatenation() != null) {
            visitConcatenation(ctx.concatenation());
            columnSrcNormalPop();
        }
        // arg3? arg4
        if (ctx.quoted_string() != null) {
            for (PlSqlParser.Quoted_stringContext quotedStringCtx : ctx.quoted_string()) {
                visitQuoted_string(quotedStringCtx);
                columnSrcNormalPop();
            }
        }
        return functionName;
    }
    @Override
    public String visitGeneral_element_part(PlSqlParser.General_element_partContext ctx) {
        if (ctx.function_argument() != null &&
                ctx.function_argument().argument() != null &&
                !ctx.function_argument().argument().isEmpty()) {
            String functionName = Tools.getFullContext(ctx);
            Node functionNode = graph.addFunction(functionName);
            columnSrc.add(functionNode);
        }
        return visitChildren(ctx);
    }
    @Override
    public String visitFunction_argument(PlSqlParser.Function_argumentContext ctx) {
        if (ctx.argument() != null) {
            for (PlSqlParser.ArgumentContext argCtx : ctx.argument()) {
                visitArgument(argCtx);
                columnSrcNormalPop();
            }
        }
        if (ctx.keep_clause() != null)
            visitKeep_clause(ctx.keep_clause());
        return ctx.getText();
    }
    @Override
    public String visitOther_function(PlSqlParser.Other_functionContext ctx) {
        String ret = Tools.getFullContext(ctx);
        columnSrc.add(this.graph.addFunction(ret));
        return ret;
    }
    @Override
    public String visitSum_function(PlSqlParser.Sum_functionContext ctx) {
        String functionName = Tools.getFullContext(ctx);
        columnSrc.add(this.graph.addFunction(functionName));
        // arg1
        visitExpression(ctx.expression());
        columnSrcNormalPop();
        return functionName;
    }
    @Override
    public String visitCount_function(PlSqlParser.Count_functionContext ctx) {
        String functionName = Tools.getFullContext(ctx);
        columnSrc.add(this.graph.addFunction(functionName));
        // arg1?
        if(ctx.concatenation() != null) {
            visitConcatenation(ctx.concatenation());
            columnSrcNormalPop();
        }
        return functionName;
    }
    @Override
    public String visitRound_function(PlSqlParser.Round_functionContext ctx) {
        String functionName = Tools.getFullContext(ctx);
        columnSrc.add(this.graph.addFunction(functionName));
        // arg1
        visitExpression(ctx.expression());
        columnSrcNormalPop();
        return functionName;
    }
    @Override
    public String visitAvg_function(PlSqlParser.Avg_functionContext ctx) {
        String functionName = Tools.getFullContext(ctx);
        columnSrc.add(this.graph.addFunction(functionName));
        // arg1
        visitExpression(ctx.expression());
        columnSrcNormalPop();
        return functionName;
    }
    @Override
    public String visitMax_function(PlSqlParser.Max_functionContext ctx) {
        String functionName = Tools.getFullContext(ctx);
        columnSrc.add(this.graph.addFunction(functionName));
        // arg1
        visitExpression(ctx.expression());
        columnSrcNormalPop();
        return functionName;
    }
    @Override
    public String visitLeast_function(PlSqlParser.Least_functionContext ctx) {
        String functionName = Tools.getFullContext(ctx);
        columnSrc.add(this.graph.addFunction(functionName));
        // args...
        for (PlSqlParser.ExpressionContext expressionCtx : ctx.expressions().expression()) {
            visitExpression(expressionCtx);
            columnSrcNormalPop();
        }
        return functionName;
    }
    @Override
    public String visitGreatest_function(PlSqlParser.Greatest_functionContext ctx) {
        String functionName = Tools.getFullContext(ctx);
        columnSrc.add(this.graph.addFunction(functionName));
        // args...
        for (PlSqlParser.ExpressionContext expressionCtx : ctx.expressions().expression()) {
            visitExpression(expressionCtx);
            columnSrcNormalPop();
        }
        return functionName;
    }

    @Override
    /*
    Table:
    --------
    dstTable
    --------
    WHEN MATCHED THEN UPDATE SET/WHEN NOT MATCHED THEN INSERT
    --------
    MERGE INTO ... USING ... ON dondition
    --------
    srcTable
    --------
    */
    public String visitMerge_statement(PlSqlParser.Merge_statementContext ctx) {
        // 1. 目标表
        String dstTableName = visitTableview_name(ctx.tableview_name());
        String aliasTableName = dstTableName;
        if(ctx.table_alias()!=null)
            aliasTableName = ctx.table_alias().getText();
        // 2. Merge
        String condition = Tools.getFullContext(ctx.condition());
        tableSrc.add(graph.addMerge(condition));
        // 3. 源表
        visitSelected_tableview(ctx.selected_tableview());

        tableSrcNormalPop();// srcTable -> Merge
        Node merge = tableSrc.pop();
        PlSqlVisitor.updateAliasTableName(dstTableName, aliasTableName);

        // 4. merge update
        if(ctx.merge_update_clause()!=null) {
            tableSrc.add(graph.addMergeUpdate(""));
            tableSrc.add(merge);
            tableSrcNormalPop(); // Merge -> update
            visitMerge_update_clause(ctx.merge_update_clause());
        }
        tableSrcNormalPop(); // update -> dstTable
        // 5. merge insert
        if(ctx.merge_insert_clause()!=null) {
            tableSrc.add(graph.addMergeInsert(""));
            tableSrc.add(merge);
            tableSrcNormalPop(); // Merge -> insert
            visitMerge_insert_clause(ctx.merge_insert_clause());
        }
        tableSrcNormalPop(); // insert -> dstTable

        return ctx.getText();
    }
    @Override
    public String visitMerge_update_clause(PlSqlParser.Merge_update_clauseContext ctx) {
        return visitChildren(ctx);
    }
    @Override
    public String visitMerge_element(PlSqlParser.Merge_elementContext ctx) {
        visitColumn_name(ctx.column_name());
        visitExpression(ctx.expression());
        columnSrcNormalPop();
        columnSrc.pop();
        return ctx.getText();
    }

    @Override
    public String visitMerge_insert_clause(PlSqlParser.Merge_insert_clauseContext ctx) {
        if(ctx.paren_column_list() != null) visitParen_column_list(ctx.paren_column_list());
        else return ctx.getText();

        visitValues_clause(ctx.values_clause());

        if(ctx.where_clause() != null) visitWhere_clause(ctx.where_clause());

        return ctx.getText();
    }

    @Override
    public String visitValues_clause(PlSqlParser.Values_clauseContext ctx) {
        if(ctx.expressions() != null) {
            for(PlSqlParser.ExpressionContext expressionCtx : Lists.reverse(ctx.expressions().expression())) {
                int oldSize = columnSrc.size();
                visitExpression(expressionCtx);
                int newSize = columnSrc.size();
                if(newSize > oldSize) columnSrcNormalPop();
                columnSrc.pop();
            }
        }
        return ctx.getText();
    }

    @Override
    public String visitSelected_tableview(PlSqlParser.Selected_tableviewContext ctx) {
        String srcTableName = "";
        if(ctx.tableview_name()!=null)
            srcTableName = visitTableview_name(ctx.tableview_name());
        else if(ctx.select_statement()!=null) {
            Node tempTable = graph.addTempTable();
            srcTableName = tempTable.name;
            tableSrc.add(tempTable);
            visitSelect_statement(ctx.select_statement());
        }

        String aliasTableName = srcTableName;
        if(ctx.table_alias()!=null)
            aliasTableName = ctx.table_alias().getText();

        PlSqlVisitor.updateAliasTableName(srcTableName, aliasTableName);

        return ctx.getText();
    }

    @Override
    public String visitCreate_table(PlSqlParser.Create_tableContext ctx) {
        if(ctx.schema_name() != null)
            visitSchema_name(ctx.schema_name());

        String tableName = visitTable_name(ctx.table_name());
        this.graph.createTable(tableName);

        if(ctx.relational_table() != null) {
            String[] columnNames = visitRelational_table(ctx.relational_table()).split(",");
            for(String columnName : columnNames)
                this.graph.addColumn(tableName, columnName);
        }


        return ctx.getText();
    }
    @Override
    public String visitRelational_table(PlSqlParser.Relational_tableContext ctx) {
        if(ctx.relational_property() != null && ctx.relational_property().isEmpty()) // 没有列
            return "";

        StringBuilder ret= new StringBuilder();
        for(PlSqlParser.Relational_propertyContext rpCtx : ctx.relational_property())
            ret.append(visitRelational_property(rpCtx)).append(",");
        ret.deleteCharAt(ret.length()-1);

        return ret.toString();
    }
    @Override
    public String visitColumn_definition(PlSqlParser.Column_definitionContext ctx) {
        return visitColumn_name(ctx.column_name());
    }
    @Override
    public String visitTable_name(PlSqlParser.Table_nameContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitAlter_table(PlSqlParser.Alter_tableContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitTruncate_table(PlSqlParser.Truncate_tableContext ctx) {
        return ctx.getText();
    }


    private boolean columnSrcNormalPop() {
        if (columnSrc.size() < 2)
            return false;
        Node src = columnSrc.pop();
        Node dst = columnSrc.pop();
        columnSrc.add(dst);
        this.graph.addEdge(src, dst);
        return true;
    }

    private boolean tableSrcNormalPop() {
        if (tableSrc.size() < 2)
            return false;
        Node src = tableSrc.pop();
        Node dst = tableSrc.pop();
        tableSrc.add(dst);
        this.graph.addEdge(src, dst);
        return true;
    }
    private boolean tableSrcPopDst() {
        if (tableSrc.size() < 2)
            return false;
        Node src = tableSrc.pop();
        Node dst = tableSrc.pop();
        tableSrc.add(src);
        this.graph.addEdge(src, dst);
        return true;
    }

    public String toDot() {
        return graph.toDOT();
    }
    public String toJSON() {
        return graph.toJSON();
    }

    public static String getRealTableName(String tableName) {
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

    private static void updateAliasTableName(String tableName, String aliasTableName) {
        tableName = tableName.toUpperCase();
        aliasTableName = aliasTableName.toUpperCase();
        realTableNameMapper.put(aliasTableName, tableName);
        realTableNameMapper.put(tableName, tableName);
    }

    private String findSrcTable(String columnName) {
        for(String srcTableName : this.tableRefs)
            if(this.graph.existColumn(srcTableName, columnName))
                return srcTableName;
        return "";
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        PlSqlLexer lexer = new PlSqlLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PlSqlParser parser = new PlSqlParser(tokens);
        PlSqlParser.Sql_scriptContext rootContext = parser.sql_script();
        PlSqlVisitor visitor = new PlSqlVisitor("dstTable");
        visitor.visitSql_script(rootContext);
        System.out.println(visitor.toDot());
    }
}