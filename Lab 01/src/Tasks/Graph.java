/*Implementation using LinkedList can be done later.*/

package Tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

class Graph {

    private String pathname;
    private int vertices;

    Graph(String pathname) {

        File file = new File(pathname);
        this.pathname = pathname;
        try {
            Scanner scanner = new Scanner(file);
            vertices = Integer.parseInt(scanner.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private int[][] createUndirectedGraph() {

        int[][] adjacencyMatrix;
        adjacencyMatrix = new int[vertices][vertices];

        File file = new File(pathname);
        Scanner scOne;
        try {
            scOne = new Scanner(file);
            scOne.nextLine();

            while (scOne.hasNextInt()) {

                String temp = scOne.nextLine();
                StringTokenizer stringTokenizer = new StringTokenizer(temp);

                int intOne = Integer.parseInt(stringTokenizer.nextToken());
                int intTwo = Integer.parseInt(stringTokenizer.nextToken());

                adjacencyMatrix[intOne][intTwo] = adjacencyMatrix[intTwo][intOne] = 1;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return adjacencyMatrix;
    }

    private int[][] createDirectedGraph() {

        int[][] adjacencyMatrix;
        adjacencyMatrix = new int[vertices][vertices];

        File file = new File(pathname);
        Scanner scTwo;
        try {
            scTwo = new Scanner(file);
            scTwo.nextLine();

            while (scTwo.hasNextInt()) {

                String temp = scTwo.nextLine();
                StringTokenizer stringTokenizer = new StringTokenizer(temp);

                int intOne = Integer.parseInt(stringTokenizer.nextToken());
                int intTwo = Integer.parseInt(stringTokenizer.nextToken());

                adjacencyMatrix[intOne][intTwo] = 1;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return adjacencyMatrix;
    }

    void printAdjacencyMatrix(boolean isDirected) {

        int[][] adjacencyMatrix;

        if (isDirected) {
            adjacencyMatrix = createDirectedGraph();
        } else {
            adjacencyMatrix = createUndirectedGraph();
        }

        System.out.print("  ");
        for (int i = 0; i < 6; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < adjacencyMatrix.length; i++) {

            System.out.print(i + " ");

            for (int j = 0; j < adjacencyMatrix.length; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void printAdjacencyList(boolean isDirected) {

        int[][] adjacencyMatrix;

        if (isDirected) {
            adjacencyMatrix = createDirectedGraph();
        } else {
            adjacencyMatrix = createUndirectedGraph();
        }

        for (int i = 0; i < adjacencyMatrix.length; i++) {

            System.out.print(i + " --> ");

            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    void degreeCounter(boolean isDirected) {
        int[][] adjacencyMatrix;

        if (isDirected) {
            adjacencyMatrix = createDirectedGraph();

            System.out.println("The in-degree for each node are:");
            inDegreeCounter(adjacencyMatrix);

            System.out.println("The out-degree for each node are:");
            outDegreeCounter(adjacencyMatrix);
        } else {
            adjacencyMatrix = createUndirectedGraph();
            outDegreeCounter(adjacencyMatrix);
        }
    }

    private void outDegreeCounter(int[][] adjacencyMatrix) {
        for (int i = 0; i < adjacencyMatrix.length; i++) {

            System.out.print(i + " --> ");

            int counter = 0;

            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    counter++;
                }
            }

            System.out.println(counter);
        }
        System.out.println();
    }

    private void inDegreeCounter(int[][] adjacencyMatrix) {
        for (int i = 0; i < adjacencyMatrix.length; i++) {

            System.out.print(i + " --> ");

            int counter = 0;

            for (int[] matrix : adjacencyMatrix) {
                if (matrix[i] == 1) {
                    counter++;
                }
            }

            System.out.println(counter);
        }
        System.out.println();
    }
}