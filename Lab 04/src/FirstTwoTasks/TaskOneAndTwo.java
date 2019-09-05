package FirstTwoTasks;

public class TaskOneAndTwo {
    public static void main(String[] args) {

        try {

            System.out.println();

            Graph graphOne =
                    new Graph("C:\\Users\\User\\Desktop\\Graph.txt");
            graphOne.printAdjacencyMatrix();
            graphOne.depthFirstSearch();
            graphOne.topologicalSort();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
