package cn.edu.nju.core.manager;

import cn.edu.nju.core.expression.RenameMap;
import cn.edu.nju.core.expression.Schema;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RenamesManager {
    private final Stack<Map<Schema, RenameMap>> renames = new Stack<>();
    public Map<Schema, RenameMap> push(Map<Schema, RenameMap> renames) {
        return this.renames.push(renames);
    }
    public Map<Schema, RenameMap> push(Schema schema) {
        Map<Schema, RenameMap> renameMaps = new HashMap<>();
        renameMaps.put(schema,new RenameMap());
        return this.push(renameMaps);
    }
    public Map<Schema, RenameMap> peek() {
        return this.renames.peek();
    }
    public Map<Schema, RenameMap> pop() {
        return this.renames.pop();
    }
}
