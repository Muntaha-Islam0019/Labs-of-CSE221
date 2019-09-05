package ProblemFromShafayetsBlog;

public class TaskOne {

    public static void main(String[] args) {

        System.out.println();

        int capacityOfBag = 10;
        int elementCount = 5;
        int[] profits = {120, 400, 280, 150, 200};
        int[] weights = {1, 7, 4, 3, 4};
        int[][] matrixForDynamicProgramming = new int[elementCount + 1][capacityOfBag + 1];

        for (int i = 0; i < matrixForDynamicProgramming.length; i++) {
            for (int j = 0; j < matrixForDynamicProgramming.length; j++) {
                matrixForDynamicProgramming[i][j] = -1;
            }
        }

        System.out.println(knapsack(0, 0, elementCount,
                capacityOfBag, weights, profits, matrixForDynamicProgramming));
    }

    private static int knapsack(int elementNumber, int currentWeight, int elementCount,
                                int capacityOfBag, int[] weights,
                                int[] profits, int[][] matrixForDynamicProgramming) {

        if(elementNumber >= elementCount) {
            return 0;
        }

        if(matrixForDynamicProgramming[elementNumber][currentWeight] != -1) {
            return matrixForDynamicProgramming[elementNumber][currentWeight];
        }

        int profitOne = 0, profitTwo;
        if(currentWeight + weights[elementNumber] <= capacityOfBag) {
            profitOne = knapsack(elementNumber + 1,
                    currentWeight + weights[elementNumber], elementCount,
                    capacityOfBag, weights, profits, matrixForDynamicProgramming) + profits[elementNumber];
        }

        profitTwo = knapsack(elementNumber + 1,
                currentWeight, elementCount, capacityOfBag, weights, profits,
                matrixForDynamicProgramming);

        return matrixForDynamicProgramming[elementNumber][currentWeight] = Math.max(profitOne, profitTwo);
    }
}
