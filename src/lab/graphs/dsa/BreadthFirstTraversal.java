package lab.graphs.dsa;

import java.util.*;

public class BreadthFirstTraversal<T> {
    private final ArrayList<T> vertices;
    private final HashMap<Integer, List<Integer>> edges;
    private final boolean[] visitedVertices;

    public BreadthFirstTraversal(ArrayList<T> vertices, HashMap<Integer, List<Integer>> edges) {
        this.vertices = vertices;
        this.edges = edges;
        this.visitedVertices = new boolean[vertices.size()];
    }

    public void printGraph(int sourceVertex) throws IndexOutOfBoundsException{
        if (indexOutOfBound(sourceVertex)){
            throw new IndexOutOfBoundsException("Vertex Index Out of bound");
        }
        List<Integer> queue = new LinkedList<>();
        queue.add(sourceVertex);
        visitedVertices[sourceVertex] = true;

        while (!queue.isEmpty()){
            Integer vertexIndex = pop(queue);
            System.out.print(vertices.get(vertexIndex).toString() + ",\t");

            for (Integer vertex : edges.get(vertexIndex)) {
                vertexIndex = vertex;
                if (!visitedVertices[vertexIndex]) {
                    visitedVertices[vertexIndex] = true;
                    queue.add(vertexIndex);
                }
            }
        }
        System.out.println();
    }
    public boolean indexOutOfBound(int index){
        return index >= vertices.size() || index < 0;
    }

    private int pop(List<Integer> queue){
        int element = queue.get(0);
        queue.remove(0);
        return element;
    }
}
