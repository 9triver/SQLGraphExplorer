package cn.edu.nju.tools;

import cn.edu.nju.graph.Graph;
import cn.edu.nju.tools.condition.ConditionVisitor;
import cn.edu.nju.tools.condition.grammar.ConditionLexer;
import cn.edu.nju.tools.condition.grammar.ConditionParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.apache.log4j.Logger;

import java.io.*;

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

    private static Graph.Table targetTable;
    public static void setTargetTable(Graph.Table targetTable) {
        Tools.targetTable = targetTable;
    }

    public static String simplifyBooleanAlgebra(String context, Graph.Table targetTable) {
        Tools.targetTable = targetTable;
        return simplifyBooleanAlgebra(context);
    }
    public static String simplifyBooleanAlgebra(String context) {
        String oldStr = "";
        String newStr = context;
        while (!newStr.equals(oldStr)) {
            oldStr = newStr;
            newStr = Tools.simplify(oldStr);
        }

        return newStr;
    }

    private static String simplify(String context) {
        String result = "";
        try {
            ConditionLexer lexer = new ConditionLexer(CharStreams.fromStream(new ByteArrayInputStream(context.getBytes())));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ConditionParser parser = new ConditionParser(tokens);
            ConditionParser.ParseContext rootContext =  parser.parse();
            ConditionVisitor visitor = new ConditionVisitor();

            visitor.setTargetColumnName(Tools.targetTable);
            result = visitor.visitParse(rootContext);
        }
        catch (Exception e) {
            logger.error(e.toString());
        }
        return result;
    }
}
