package cn.edu.nju.tools;

import cn.edu.nju.graph.Graph;
import cn.edu.nju.tools.condition.Simplifier;
import cn.edu.nju.tools.condition.Spliter;
import cn.edu.nju.tools.condition.grammar.simplifier.SimplifierLexer;
import cn.edu.nju.tools.condition.grammar.simplifier.SimplifierParser;
import cn.edu.nju.tools.condition.grammar.spliter.SpliterLexer;
import cn.edu.nju.tools.condition.grammar.spliter.SpliterParser;
import cn.edu.nju.tools.ra.RelationalAlgebraInterpreter;
import cn.edu.nju.tools.ra.adt.Database;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Tools {
    private static final Logger logger = Logger.getLogger(Tools.class);
    public static <T extends Serializable> T clone(T obj)
            throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(obj);

        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        return (T) ois.readObject();
    }

    public static String getFullContext(ParserRuleContext context) {
        if(context.start == null || context.stop == null ||
                context.start.getStartIndex() < 0 ||
                context.stop.getStopIndex() < 0)
            return context.getText();
        return context.start.getInputStream().getText(Interval.of(context.start.getStartIndex(), context.stop.getStopIndex()));
    }

    public static List<String> simplifyAndSplit(String context, Graph.Table targetTable) {
        return Tools.split(Tools.simplify(context, targetTable));
    }

    public static List<String> simplifyAndSplit(String context) {
        return Tools.split(Tools.simplify(context));
    }
    private static Graph.Table targetTable;
    public static String simplify(String context, Graph.Table targetTable) {
        Tools.targetTable = targetTable;
        return simplify(context);
    }
    public static String simplify(String context) {
        String oldStr = "";
        String newStr = context;
        while (!newStr.equals(oldStr)) {
            oldStr = newStr;
            newStr = Tools.simplifyOneCycle(oldStr);
        }

        return newStr;
    }

    public static List<String> split(String context) {
        String oldStr = "";
        String newStr = context;
        while (!newStr.contains("@#$%") && !newStr.equals(oldStr)) {
            oldStr = newStr;
            newStr = Tools.splitOneCycle(oldStr);
        }

        return Arrays.stream(newStr.split("@#\\$%")).toList();
    }

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


    private static RelationalAlgebraInterpreter interpreter = new RelationalAlgebraInterpreter(new Database("defaultDatabase"));
    public static String translateFromRA2Sql(String relationalAlgebraInput){
        return interpreter.translate(relationalAlgebraInput);
    }
}
