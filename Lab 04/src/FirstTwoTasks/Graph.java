package FirstTwoTasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Graph {

    private String pathname;
    private int vertices;
    private int[][] adjacencyMatrix;
    private String[] processStatus;
    private int[] discoveredQueue;
    private int[] processedQueue;
    private int discoveredIndex;
    private int processedIndex;
    private int time;
    private int[] hopTimings;
    private int[] finishTimings;
    private int[] arrayToSaveTopologicalSortedOrder;
    private int indexOfArrayToSort;

    Graph(String pathname) {

        File file = new File(pathname);
        this.pathname = pathname;
        try {
            Scanner scanner = new Scanner(file);
            vertices = Integer.parseInt(scanner.nextLine());
            arrayToSaveTopologicalSortedOrder = new int[vertices];
            indexOfArrayToSort = 0;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private int[][] createDirectedGraph() {

        int[][] adjacencyMatrix;
        adjacencyMatrix = new int[vertices + 1][vertices + 1];

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

                adjacencyMatrix[intOne][intTwo] = 1;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        this.adjacencyMatrix = adjacencyMatrix;

        return adjacencyMatrix;
    }

    void printAdjacencyMatrix() {

        System.out.println("Adjacency matrix of given graph: ");

        int[][] adjacencyMatrix;

        adjacencyMatrix = createDirectedGraph();

        System.out.print("  ");
        for (int i = 1; i <= 6; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 1; i < adjacencyMatrix.length; i++) {

            System.out.print(i + " ");

            for (int j = 1; j < adjacencyMatrix.length; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void depthFirstSearch() {

        processStatus = new String[vertices + 1];
        discoveredQueue = new int[vertices + 1];
        processedQueue = new int[vertices + 1];
        discoveredIndex = processedIndex = 0;
        hopTimings = new int[vertices + 1];
        finishTimings = new int[vertices + 1];

        for (int i = 1; i < adjacencyMatrix.length; i++) {
            processStatus[i] = "Non discovered";
        }

        time = 0;

        for (int i = 1; i < adjacencyMatrix.length; i++) {
            if(processStatus[i].equals("Non discovered")) visit(i);
        }

        System.out.print("Discovered indices: ");
        System.out.print(Arrays.toString(discoveredQueue));
        System.out.println("\nHere, 0 means null.");

        System.out.println("_________________________________________________________________________________________");

        System.out.print("Processed indices: ");
        System.out.print(Arrays.toString(processedQueue));
        System.out.println("\nHere, 0 means null.");

        System.out.println("_________________________________________________________________________________________");

        System.out.println("Finish timings: ");
        System.out.println(Arrays.toString(finishTimings));
        System.out.println("Here, 0 means null.");
    }

    private void visit(int i) {

        processStatus[i] = "Discovered";
        discoveredQueue[discoveredIndex++] = i;
        hopTimings[i] = ++time;

        for (int k = 1; k < adjacencyMatrix.length; k++) {
            if(adjacencyMatrix[i][k] == 1) {
                if(processStatus[k].equals("Non discovered")) {
                    visit(k);
                }
            }
        }

        processStatus[i] = "Processed";
        processedQueue[processedIndex++] = i;
        finishTimings[i] = ++time;
        arrayToSaveTopologicalSortedOrder[indexOfArrayToSort++] = i;
    }

    void topologicalSort() {

        System.out.println("_________________________________________________________________________________________");

        System.out.println("Topological sort: ");

        for(int i = 0; i < arrayToSaveTopologicalSortedOrder.length / 2; i++) {
            int temp = arrayToSaveTopologicalSortedOrder[i];
            arrayToSaveTopologicalSortedOrder[i]
                    = arrayToSaveTopologicalSortedOrder[arrayToSaveTopologicalSortedOrder.length - i - 1];
            arrayToSaveTopologicalSortedOrder[arrayToSaveTopologicalSortedOrder.length - i - 1] = temp;
        }

        System.out.println(Arrays.toString(arrayToSaveTopologicalSortedOrder));
    }
}