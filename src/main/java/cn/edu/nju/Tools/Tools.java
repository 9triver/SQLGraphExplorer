package cn.edu.nju.Tools;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;

import java.io.*;

public class Tools {
    /**
     * @author: Xu YangXin
     * @return {T} 目标对象
     * @description: 对某个对象进行深拷贝
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

    public static String getFullContext(ParserRuleContext context) {
        if(context.start == null || context.stop == null ||
                context.start.getStartIndex() < 0 ||
                context.stop.getStopIndex() < 0)
            return context.getText();
        return context.start.getInputStream().getText(Interval.of(context.start.getStartIndex(), context.stop.getStopIndex()));
    }
}
