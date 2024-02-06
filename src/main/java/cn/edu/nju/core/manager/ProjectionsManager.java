package cn.edu.nju.core.manager;

import cn.edu.nju.core.expression.RenameMap;
import cn.edu.nju.core.expression.Schema;
import cn.edu.nju.core.graph.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ProjectionsManager {
    private final Stack<List<Schema>> projections;
    private final Graph graph;
    public ProjectionsManager(Graph graph) {
        this.projections = new Stack<>();
        this.graph = graph;
    }
    public List<Schema> push(List<Schema> schemas) {
        return this.projections.push(schemas);
    }
    public List<Schema> push(Schema schema) {
        List<Schema> schemas = new ArrayList<>();
        schemas.add(schema);
        return this.push(schemas);
    }
    public List<Schema> pop() {
        return this.projections.pop();
    }
    public List<Schema> peek() {
        return this.projections.peek();
    }
    public void caseGenerate(Graph.Table table, List<String> selectListElement, Map<Schema, RenameMap> schemaRenameMapMap) {
        List<Schema> oldProjections = this.projections.pop();
        List<Schema> newProjections = new ArrayList<>();
        for (Schema projection : oldProjections) {
            RenameMap renameMap = schemaRenameMapMap.get(projection);
            schemaRenameMapMap.remove(projection, renameMap);
            for(String columnName : selectListElement) {
                Schema newProjection = new Schema(projection);
                Graph.Column sourceColumn = Graph.Column.parseColumnName(graph, columnName, table).getRight();
                newProjection.add(sourceColumn);
                schemaRenameMapMap.put(newProjection, new RenameMap(renameMap));
                newProjections.add(newProjection);
            }
        }
        this.projections.push(newProjections);
    }
}
