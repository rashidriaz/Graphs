package lab.graphs.dsa;

public class Main {

    public static void main(String[] args) {
        Graph<String> graph=new Graph<>(true);

        String[] cities = {"Lahore", "Karachi", "Quetta", "Peshawar", "Multan"};
        graph.addNewEdge(cities[0], cities[1]);
        graph.addNewEdge(cities[0], cities[4]);
        graph.addNewEdge(cities[1], cities[2]);
        graph.addNewEdge(cities[1], cities[3]);
        graph.addNewEdge(cities[1], cities[4]);
        graph.addNewEdge(cities[2], cities[3]);
        graph.addNewEdge(cities[2], cities[4]);
        graph.addNewEdge(cities[3], cities[0]);
        graph.addNewEdge(cities[2], cities[0]);

        System.out.println("Adjacency List for the graph:\n"+ graph.toString());

        System.out.print("\nTotal vertex count is: " + graph.vertexCount() + "\n");
        System.out.print("\nTotal vertex count is: " + graph.edgesCount() + "\n");

        if(graph.containsEdge("Peshawar", "Multan"))
            System.out.println("\nGraph contains Peshawar - Multan edge");
        if(graph.containsEdge("Quetta", "Multan"))
            System.out.println("\nGraph contains Quetta - Multan edge");

        if(graph.containsVertex("Peshawar"))
            System.out.println("\nGraph contains Peshawar vertex");
        if(graph.containsVertex("Hyderabad"))
            System.out.println("\nGraph contains Hyderabad vertex");

        graph.printGraphUsingBFS();
        graph.printGraphUsingDFS();

    }
}
