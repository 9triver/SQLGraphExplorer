package cn.edu.nju.core.manager;

import cn.edu.nju.core.graph.Graph;


public class Manager {
    private Graph graph;
    private ExpressionsManager expressionsManager;
    private ProjectionsManager projectionsManager;
    private RenamesManager renamesManager;

    public Manager(Graph graph) {
        this.graph = graph;
        this.expressionsManager = new ExpressionsManager(graph);
        this.projectionsManager = new ProjectionsManager(graph);
        this.renamesManager = new RenamesManager();
    }

    public ExpressionsManager getExpressionsManager() {
        return expressionsManager;
    }

    public ProjectionsManager getProjectionsManager() {
        return projectionsManager;
    }

    public RenamesManager getRenamesManager() {
        return renamesManager;
    }
}
