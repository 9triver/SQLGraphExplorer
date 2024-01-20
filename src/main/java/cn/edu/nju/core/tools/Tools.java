package cn.edu.nju.core.tools;

import cn.edu.nju.core.TableAlias;
import cn.edu.nju.core.graph.Graph;
import cn.edu.nju.core.tools.condition.Simplifier;
import cn.edu.nju.core.tools.condition.Spliter;
import cn.edu.nju.core.tools.condition.grammar.simplifier.SimplifierLexer;
import cn.edu.nju.core.tools.condition.grammar.simplifier.SimplifierParser;
import cn.edu.nju.core.tools.condition.grammar.spliter.SpliterLexer;
import cn.edu.nju.core.tools.condition.grammar.spliter.SpliterParser;
import cn.edu.nju.core.tools.ra.RelationalAlgebraInterpreter;
import cn.edu.nju.core.tools.ra.adt.Database;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * @className：Tools
 * @version: 1.0.0
 * @description：工具箱
 * @author: Xin
 * @date: 2023-12-25 15:51:02
 */
public class Tools {
    private static final Logger logger = Logger.getLogger(Tools.class);

    private static final TableAlias tableAlias = new TableAlias();

    /**
     * 克隆对象
     *
     * @param obj 对象
     * @return {@link T }
     * @throws IOException            IO异常
     * @throws ClassNotFoundException 未找到类异常
     * @author: Xin
     * @date: 2023-12-25 15:51:15
     */
    public static <T extends Serializable> T clone(T obj)
            throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(obj);

        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        return (T) ois.readObject();
    }

    /**
     * 获取context文本的全内容，包含空白符
     *
     * @param context 上下文
     * @return {@link String }
     * @author: Xin
     * @date: 2023-12-25 15:51:39
     */
    public static String getFullContext(ParserRuleContext context) {
        if(context.start == null || context.stop == null ||
                context.start.getStartIndex() < 0 ||
                context.stop.getStopIndex() < 0)
            return context.getText();
        return context.start.getInputStream().getText(Interval.of(context.start.getStartIndex(), context.stop.getStopIndex()));
    }

    /**
     * 简化和拆分
     *
     * @param context     上下文
     * @param targetTable 目标表格
     * @return {@link List }<{@link String }>
     * @author: Xin
     * @date: 2023-12-25 15:52:13
     */
    public static List<String> simplifyAndSplit(String context, Graph.Table targetTable) {
        return Tools.split(Tools.simplify(context, targetTable));
    }

    /**
     * 简化和拆分
     *
     * @param context 上下文
     * @return {@link List }<{@link String }>
     * @author: Xin
     * @date: 2023-12-25 15:52:18
     */
    public static List<String> simplifyAndSplit(String context) {
        return Tools.split(Tools.simplify(context));
    }
    private static Graph.Table targetTable;

    /**
     * 简化
     *
     * @param context     上下文
     * @param targetTable 目标表格
     * @return {@link String }
     * @author: Xin
     * @date: 2023-12-25 15:52:40
     */
    public static String simplify(String context, Graph.Table targetTable) {
        Tools.targetTable = targetTable;
        String ret = simplify(context);
        logger.debug(ret);
        return ret;
    }

    /**
     * 简化
     *
     * @param context 上下文
     * @return {@link String }
     * @author: Xin
     * @date: 2023-12-25 15:52:43
     */
    public static String simplify(String context) {
        String oldStr = "";
        String newStr = context;
        while (!newStr.equals(oldStr)) {
            oldStr = newStr;
            newStr = Tools.simplifyOneCycle(oldStr);
        }

        return newStr;
    }

    /**
     * 拆分
     *
     * @param context 上下文
     * @return {@link List }<{@link String }>
     * @author: Xin
     * @date: 2023-12-25 15:52:46
     */
    public static List<String> split(String context) {
        String oldStr = "";
        String newStr = context;
        while (!newStr.contains("@#$%") && !newStr.equals(oldStr)) {
            oldStr = newStr;
            newStr = Tools.splitOneCycle(oldStr);
        }

        return Arrays.stream(newStr.split("@#\\$%")).toList();
    }

    /**
     * 简化的一次周期步骤
     *
     * @param context 上下文
     * @return {@link String }
     * @author: Xin
     * @date: 2023-12-25 15:52:57
     */
    private static String simplifyOneCycle(String context) {
        String result = "";
        try {
            SimplifierLexer lexer = new SimplifierLexer(CharStreams.fromStream(new ByteArrayInputStream(context.getBytes())));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            SimplifierParser parser = new SimplifierParser(tokens);
            SimplifierParser.ParseContext rootContext =  parser.parse();
            Simplifier simplifier = new Simplifier();

            simplifier.setTargetColumnName(Tools.targetTable);
            result = simplifier.visitParse(rootContext);
        }
        catch (Exception e) {
            logger.error(e.toString());
        }
        return result;
    }

    /**
     * 拆分的一次周期步骤
     *
     * @param context 上下文
     * @return {@link String }
     * @author: Xin
     * @date: 2023-12-25 15:53:20
     */
    private static String splitOneCycle(String context) {
        String result = "";
        try {
            SpliterLexer lexer = new SpliterLexer(CharStreams.fromStream(new ByteArrayInputStream(context.getBytes())));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            SpliterParser parser = new SpliterParser(tokens);
            SpliterParser.ParseContext rootContext =  parser.parse();
            Spliter spliter = new Spliter();

            result = spliter.visitParse(rootContext);
        }
        catch (Exception e) {
            logger.error(e.toString());
        }
        return result;
    }


    private static final RelationalAlgebraInterpreter interpreter = new RelationalAlgebraInterpreter(new Database("defaultDatabase"));

    /**
     * 将关系代数翻译为sql语句
     *
     * @param relationalAlgebraInput 输入的关系代数
     * @return {@link String }
     * @author: Xin
     * @date: 2023-12-25 15:53:47
     */
    public static String translateFromRA2Sql(String relationalAlgebraInput){
        return interpreter.translate(relationalAlgebraInput);
    }


    public static void clearTableAlias() {
        Tools.tableAlias.clear();
    }
    public static void updateAliasTableName(String tableName, String aliasTableName) {
        Tools.tableAlias.updateAliasTableName(tableName, aliasTableName);
    }
    public static String getRealTableName(String tableName) {
        return Tools.tableAlias.getRealTableName(tableName);
    }
    public static String getRealFullColumnName(String fullColumnName) {
        return Tools.tableAlias.getRealFullColumnName(fullColumnName);
    }
}
