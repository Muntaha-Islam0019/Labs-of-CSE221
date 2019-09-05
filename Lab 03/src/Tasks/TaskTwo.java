package Tasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;

public class TaskTwo {

    public static void main(String[] args) throws Exception {

        System.out.println();

        File file = new File("C:\\Users\\User\\Desktop\\Graph.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        int a = Integer.parseInt(st) + 1;
        int[][] und = new int[a][a];

        while ((st = br.readLine()) != null) {

            String[] s = st.split(" ");
            int i = Integer.parseInt(s[0]);
            int j = Integer.parseInt(s[1]);

            und[i][j] = 1;
            und[j][i] = 1;

        }
        bfs(und, 1);
    }

    private static void bfs(int[][] a, int s) {

        String[] color = new String[a.length];
        int[] distance = new int[a.length];
        int[] parent = new int[a.length];
        Queue<Integer> list = new LinkedList<>();

        for (int i = 1; i < a.length; i++) {
            color[i] = "white";
            distance[i] = 100000000;
            parent[i] = -1;
        }

        color[s] = "grey";
        distance[s] = 0;
        parent[s] = -1;

        list.add(s);
        while (!list.isEmpty()) {

            int u = list.poll();

            for (int j = 1; j < a.length; j++) {

                if (a[u][j] == 1 && color[j].equals("white")) {
                    color[j] = "grey";
                    distance[j] = distance[u] + 1;
                    parent[j] = u;
                    list.add(j);
                }
            }

            color[u] = "black";

        }

        print(parent, distance);

    }

    private static void print(int[] parent, int[] d) {

        for (int i = 1; i < parent.length; i++) {
            System.out.println(i + " : distance from the source - " + d[i] +
                    ",path -> " + direction(parent, i));
        }
    }


    private static String direction(int[] parent, int i) {

        String t;
        int temp = i;
        StringBuilder tBuilder = new StringBuilder();

        while (parent[i] != -1) {
            String s = "" + parent[i];
            tBuilder.insert(0, s + ", ");
            i = parent[i];
        }

        t = tBuilder.toString();
        t = t + temp;

        return t;
    }
}