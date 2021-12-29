package lab.graphs.dsa;

import java.util.*;

public class DepthFirstTraversal<T> {
    private final ArrayList<T> vertices;
    private final HashMap<Integer, List<Integer>> edges;
    private final boolean[] visitedVertices;

    public DepthFirstTraversal(ArrayList<T> vertices, HashMap<Integer, List<Integer>> edges) {
        this.vertices = vertices;
        this.edges = edges;
        this.visitedVertices = new boolean[vertices.size()];
    }

    public void printGraph(int sourceVertex) throws IndexOutOfBoundsException {
        if (indexOutOfBound(sourceVertex)) {
            throw new IndexOutOfBoundsException("Vertex Index Out of bound");
        }
        visitedVertices[sourceVertex] = true;
        System.out.print(vertices.get(sourceVertex).toString() + ",\t");
        for (int index : edges.get(sourceVertex)) {
            if (!visitedVertices[index]) {
                printGraph(index);
            }
        }
    }

    public boolean indexOutOfBound(int index) {
        return index >= vertices.size() || index < 0;
    }

}
