package Tasks;

import java.util.Scanner;

public class TaskOne {

    private static String[] cities;

    private static int minKey(int[] key, boolean[] nodeOfMST) {

        /*Don't get confused by the value pushed in, as we need to ensure that any values is lesser than minValue.*/
        int minValue = Integer.MAX_VALUE;
        int indexOfMinimalValue = -1;

        for (int i = 0; i < key.length; i++) {
            if(!nodeOfMST[i] && key[i] < minValue) {
                minValue = key[i];
                indexOfMinimalValue = i;
            }
        }

        return indexOfMinimalValue;
    }

    private static void printMST(int[] parent, int[][] graph) {

        System.out.println("Cities \tDistance");

        for (int i = 1; i < graph.length; i++)
            System.out.println(cities[parent[i]] + " - " + cities[i] + "\t" + graph[i][parent[i]]);
    }

    private static void prim(int[][] graph) {

        int[] parent = new int[graph.length];
        int[] key = new int[graph.length];
        boolean[] nodeOfMST = new boolean[graph.length];

        for (int i = 0; i < key.length; i++) {
            key[i] = Integer.MAX_VALUE;
            nodeOfMST[i] = false;
        }

        key[0] = 0;
        parent[0] = -1; /*Here -1 is to denote that vertex 0 has no parent, as, it's root.*/

        for (int i = 0; i < graph.length - 1; i++) {

            int u = minKey(key, nodeOfMST);

            nodeOfMST[u] = true;

            for (int j = 0; j < graph.length; j++) {

                if (!nodeOfMST[j] && graph[u][j] < key[j]) {
                    parent[j] = u;
                    key[j] = graph[u][j];
                }
            }
        }

        printMST(parent, graph);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter number of cities: ");
        int numberOfCities = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Please enter city names: ");
        cities = new String[numberOfCities];
        for (int i = 0; i < cities.length; i++) {
            cities[i] = scanner.next();
        }

        System.out.println("Please enter the distances in row by row: ");
        int[][] distances = new int[numberOfCities][numberOfCities];
        for (int i = 0; i < distances.length; i++) {
            for (int j = 0; j < distances.length; j++) {
                distances[i][j] = scanner.nextInt();
            }
        }

        prim(distances);
    }
}