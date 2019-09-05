package Tasks;

import java.util.ArrayList;
import java.util.Arrays;

public class Task {

    private static int[] distance;
    private static int[] predecessor;

    private static void bellmanFord(ArrayList<Edge> graph) {

        distance = new int[7];
        predecessor = new int[7];

        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
            predecessor[i] = -1;
        }

        distance[0] = 0;

        /*Main Bellman-Ford algorithm.*/
        for (int i = 0; i < graph.size() - 1; i++) {
            for (Edge edge :
                    graph) {
                if (distance[edge.from] + edge.weight < distance[edge.to]) {

                    System.out.println();

                    System.out.println("Checking edge: [" + edge.from + "-->"+ edge.to + "]");

                    distance[edge.to] = distance[edge.from] + edge.weight;

                    System.out.println("Distance of edge.to: " + distance[edge.to]);

                    predecessor[edge.to] = edge.from;

                    System.out.println("Predecessor of edge.to: " + predecessor[edge.to]);

                    System.out.println();
                }
            }
        }

        /*For negative cycle detection.*/

        boolean doesHaveCycle = false;

        for (Edge edge :
                graph) {
            if (distance[edge.from] + edge.weight < distance[edge.to]) {
                doesHaveCycle = true;
                break;
            }
        }

        if(doesHaveCycle) {
            System.out.println("The graph contains a negative cycle.\n");
        } else {
            System.out.println("The graph does not contain a negative cycle.\n");
        }

    }

    public static void main(String[] args) {

        ArrayList<Edge> graph = new ArrayList<>();

        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 1));
        graph.add(new Edge(0, 3, 105));
        graph.add(new Edge(1, 2, 4));
        graph.add(new Edge(1, 4, 6));
        graph.add(new Edge(2, 3, 90));
        graph.add(new Edge(3, 6, 5));
        graph.add(new Edge(4, 5, 6));
        graph.add(new Edge(5, 1, -1));
        graph.add(new Edge(5, 3, 1));

        bellmanFord(graph);

        System.out.println("Distances: " + Arrays.toString(distance));
        System.out.println("Predecessors: " + Arrays.toString(predecessor));
    }
}
