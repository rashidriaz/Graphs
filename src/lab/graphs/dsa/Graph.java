package lab.graphs.dsa;

import java.util.*;

public class Graph<T> {
    private final ArrayList<T> vertices;
    private final HashMap<Integer, List<Integer>> edges;
    private final boolean IS_BI_DIRECTIONAL;

    public Graph(boolean isBiDirectional) {
        IS_BI_DIRECTIONAL = isBiDirectional;
        vertices = new ArrayList<>();
        edges = new HashMap<>();
    }

    public void addNewVertex(T vertex) {
        boolean vertexExists = vertices.contains(vertex);
        if (vertexExists) {
            return;
        }
        vertices.add(vertex);
        int indexOfNewVertex = vertices.indexOf(vertex);
        edges.put(indexOfNewVertex, new LinkedList<>());
    }

    public void addNewEdge(T source, T destination) {
        addVertexIfNotExist(source);
        addVertexIfNotExist(destination);
        int indexOfSourceVertex = vertices.indexOf(source), indexOfDestinationVertex = vertices.indexOf(destination);

        edges.get(indexOfSourceVertex).add(indexOfDestinationVertex);
        if (IS_BI_DIRECTIONAL)
            edges.get(indexOfDestinationVertex).add(indexOfSourceVertex);
    }

    private void addVertexIfNotExist(T vertex) {
        if (!vertices.contains(vertex)) {
            vertices.add(vertex);
            int indexOfVertex = vertices.indexOf(vertex);
            edges.put(indexOfVertex, new LinkedList<>());
        }
    }

    public int vertexCount() {
        return vertices.size();
    }

    public int edgesCount() {
        int edges = 0;
        for (Integer key : this.edges.keySet()) {
            edges += this.edges.get(key).size();
        }
        return IS_BI_DIRECTIONAL ? edges / 2 : edges;
    }

    public boolean containsVertex(T vertex) {
        return vertices.contains(vertex);
    }

    public boolean containsEdge(T source, T destination) {
        return vertices.contains(source) && edges.get(vertices.indexOf(source)).contains(vertices.indexOf(destination));
    }

    @Override
    public String toString() {
        StringBuilder resultantString = new StringBuilder();
        resultantString.append("Graph{ \n");
        for (Integer vertex : edges.keySet()) {
            resultantString.append(vertices.get(vertex).toString());
            resultantString.append(" : ");
            for (Integer edge : edges.get(vertex)) {
                resultantString.append(vertices.get(edge).toString());
                resultantString.append(", ");

            }
            resultantString.append("\n");
        }
        resultantString.append("\n}\n");
        return resultantString.toString();
    }

    public void printGraphUsingBFS(){
        BreadthFirstTraversal<T> bfs = new BreadthFirstTraversal<>(new ArrayList<>(vertices), new HashMap<>(edges));
        try {
            System.out.println("\nGraph using BFS: \n");
            bfs.printGraph(0);
        }catch (Exception e){
            System.out.println("An exception occurred");
        }
    }
    public void printGraphUsingDFS(){
        DepthFirstTraversal<T> dfs = new DepthFirstTraversal<>(new ArrayList<>(vertices), new HashMap<>(edges));
        try {
            System.out.println("\nGraph using DFS: \n");
            dfs.printGraph(0);
        }catch (Exception e){
            System.out.println("An exception occurred");
        }
    }
}
