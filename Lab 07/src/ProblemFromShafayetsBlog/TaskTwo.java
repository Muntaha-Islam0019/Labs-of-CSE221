package ProblemFromShafayetsBlog;

public class TaskTwo {

    public static void main(String[] args) {

        System.out.println();

        int capacityOfBag = 10;
        int elementCount = 5;
        int[] profits = {0, 120, 400, 280, 150, 200};
        int[] weights = {0, 1, 7, 4, 3, 4};

        System.out.println(knapsack(elementCount, capacityOfBag, profits, weights));
    }

    private static int knapsack(int elementCount, int capacityOfBag, int[] profits, int[] weights) {

        int[][] matrix = new int[elementCount + 1][capacityOfBag + 1];

        for (int i = 0; i <= capacityOfBag; i++) {
            matrix[0][i] = 0;
        }

        for (int i = 1; i <= elementCount; i++) {
            for (int j = 0; j <= capacityOfBag; j++) {

                if(weights[i] > j) {
                    matrix[i][j] = matrix[i - 1][j];
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j],  matrix[i - 1][j - weights[i]] + profits[i]);
                }
            }
        }

        return matrix[elementCount][capacityOfBag];
    }
}
