/*Task 6, Heapsort should be done later.*/

package Tasks;

import java.util.Arrays;

public class TaskOneToFive {
    public static void main(String[] args) {

        int[] ints = {3, 5, 10, 23, 25, 8, 7, 9, 50, 47};

        MyArray myArray = new MyArray(Arrays.copyOf(ints, ints.length));

        long beforeTimeOne = System.currentTimeMillis();
        System.out.println("Original Array: " + Arrays.toString(ints));
        System.out.print("After sorting with the help of insertion sort: ");
        MyArray.printArray(MyArray.insertionSort());
        long afterTimeOne = System.currentTimeMillis();
        System.out.println("Time required: " + (afterTimeOne - beforeTimeOne) + " milliseconds.");
        System.out.println("------------------------------------------------------------------------------------------");

        long beforeTimeTwo = System.currentTimeMillis();
        System.out.println("Original Array: " + Arrays.toString(ints));
        System.out.print("After sorting with the help of merge sort: ");
        int[] tempArrayOne = Arrays.copyOf(ints, ints.length);
        MyArray.mergeSort(tempArrayOne, 0, ints.length - 1);
        MyArray.printArray(tempArrayOne);
        long afterTimeTwo = System.currentTimeMillis();
        System.out.println("Time required: " + (afterTimeTwo - beforeTimeTwo) + " milliseconds.");
        System.out.println("------------------------------------------------------------------------------------------");

        long beforeTimeThree = System.currentTimeMillis();
        System.out.println("Original Array: " + Arrays.toString(ints));
        System.out.print("After sorting with the help of quick sort: ");
        int[] tempArrayTwo = Arrays.copyOf(ints, ints.length);
        MyArray.quickSort(tempArrayTwo, 0, ints.length - 1);
        MyArray.printArray(tempArrayTwo);
        long afterTimeThree = System.currentTimeMillis();
        System.out.println("Time required: " + (afterTimeThree - beforeTimeThree) + " milliseconds.");
        System.out.println("------------------------------------------------------------------------------------------");

        long beforeTimeFour = System.currentTimeMillis();
        System.out.println("Original Array: " + Arrays.toString(ints));
        System.out.print("After sorting with the help of randomized quick sort: ");
        int[] tempArrayThree = Arrays.copyOf(ints, ints.length);
        MyArray.randomizedQuickSort(tempArrayTwo, 0, ints.length - 1);
        MyArray.printArray(tempArrayTwo);
        long afterTimeFour = System.currentTimeMillis();
        System.out.println("Time required: " + (afterTimeFour - beforeTimeFour) + " milliseconds.");
        System.out.println("------------------------------------------------------------------------------------------");
    }
}
