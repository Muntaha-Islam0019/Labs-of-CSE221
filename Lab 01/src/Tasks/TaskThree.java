package Tasks;

public class TaskThree {
    public static void main(String[] args) {

        System.out.println();

        try {
            System.out.println("Undirected Graph.....");

            System.out.println("Adjacency Matrix :-");
            Graph graphOne = new Graph("C:\\Users\\User\\Desktop\\input.txt");
            graphOne.printAdjacencyMatrix(false);

            System.out.println("Adjacency List :-");
            graphOne.printAdjacencyList(false);

            System.out.println("Degree of each node for this graph :-");
            graphOne.degreeCounter(false);

            System.out.println("Directed Graph.....");

            System.out.println("Adjacency Matrix :-");
            Graph graphTwo = new Graph("C:\\Users\\User\\Desktop\\input.txt");
            graphTwo.printAdjacencyMatrix(true);

            System.out.println("Adjacency List :-");
            graphOne.printAdjacencyList(true);

            System.out.println("Degree of each node for this graph :-");
            graphTwo.degreeCounter(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
