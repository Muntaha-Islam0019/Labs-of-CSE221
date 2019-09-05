package Tasks;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class TaskTwo {
    public static void main(String[] args) throws Exception {

        File file = new File ("C:\\Users\\User\\Desktop\\lab05.txt");
        Scanner sc = new Scanner(file);


        String s = sc.nextLine();
        String[] cities = s.split("\\s+");

        int[][] distance = new int[cities.length][cities.length];
        for (int i = 0; i < cities.length; i++) {
            String c = sc.nextLine();
            String[] d = c.split("\\s+");
            for (int j = 0; j < cities.length; j++) {
                distance[i][j] = Integer.valueOf(d[j]);
            }
        }

        LinkedList<Integer> list;

        list = MST_Kruskal(distance);

        //routes
        for (int i = 0; i < list.size(); i++) {

            if (i!=0&&i%2==0&&i!=list.size()-1){
                System.out.print(",");
            }else{
                if (i!=0){
                    System.out.print("-");
                }
            }
            System.out.print(cities[list.get(i)]);
        }
    }

    private static LinkedList<Integer> MST_Kruskal(int[][] array) {

        LinkedList<Integer> list = new LinkedList<>();

        DisjointSet dS = new DisjointSet(array.length);

        int[] weight = new int[array.length];
        int[] source = new int[array.length];
        int[] destination = new int[array.length];
        int m = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i][j] != 0) {
                    weight[m] = array[i][j];
                    source[m] = i;
                    destination[m] = j;
                    m++;
                }
            }
        }

        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (weight[j] < weight[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = weight[minIndex];
            weight[minIndex] = weight[i];
            weight[i] = temp;

            int temp1 = source[minIndex];
            source[minIndex] = source[i];
            source[i] = temp1;

            int temp2 = destination[minIndex];
            destination[minIndex] = destination[i];
            destination[i] = temp2;
        }

        for (int i = 0; i < array.length; i++) {
            if (!dS.inSameSet(source[i], destination[i])) {
                list.add(source[i]);
                list.add(destination[i]);
                dS.union(source[i], destination[i]);
            }
        }
        return list;
    }
}