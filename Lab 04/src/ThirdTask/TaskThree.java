package ThirdTask;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class TaskThree {

    private static boolean[] check;
    private static int[] timeStart;
    private static int[] timeEnd;
    private static int[] sortArray;
    private static int x;
    private static int time = 0;
    private static Stack<Integer> stack = new Stack<>();

    public static void main (String[]args){

        System.out.println();

        File file1 = new File ("C:\\Users\\User\\Desktop\\Graph.txt");
        Scanner sc = null;
        try{
            sc = new Scanner(file1);
        }

        catch(IOException e){
            System.out.println("File not found");
        }

        assert sc != null;
        int w = sc.nextInt() + 1;
        int[][] graph = new int[w][w];
        check = new boolean [w];
        timeStart = new int [w];
        timeEnd = new int [w];
        sortArray = new int [w];
        x = w-1;

        while(sc.hasNextInt()){
            int p = sc.nextInt();
            int q = sc.nextInt();
            graph[p][q] = 1;
        }

        System.out.println("Adjacency Matrix");

        for(int k = 0 ; k < graph.length ; k++){
            System.out.print(k+" ");
        }
        System.out.println();

        for(int j = 0 ; j < graph.length ; j++){
            check[j] = false;
            System.out.print(j+ " ");
            for(int k = 0 ; k< graph.length ; k++){
                System.out.print(graph[j][k]+ " ");
            }
            System.out.println();


        }

        // System.out.println("\nDiscoverd Nodes:");
        dfsVisit(graph , 1);
        System.out.println();

        while (!stack.empty()){
            System.out.print(stack.pop()+" ");
        }
    }

    private static void dfsVisit(int[][] graph, int source){
        timeStart[source] = ++time;
        for(int i = 0 ; i < graph.length ; i++){
            if(graph[source][i] == 1 && !check[i]){
                check[i] = true;
                dfsVisit(graph, i);
            }
        }
        sortArray[x] = source;
        x--;
        timeEnd[source] = ++time;
        if (source!= 9)
            stack.push(source);
    }
}