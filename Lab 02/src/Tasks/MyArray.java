package Tasks;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

class MyArray {

    private static int[] ints;

    MyArray(int[] ints) {
        MyArray.ints = Arrays.copyOf(ints, ints.length);
    }

    static int[] insertionSort() {

        int[] tempArray = Arrays.copyOf(ints, ints.length);

        int length = tempArray.length;
        for (int index = 1; index < length; ++index) {

            int key = tempArray[index];
            int lastIndex = index - 1;

            /*Putting key in sorted array.*/
            while (lastIndex >= 0 && tempArray[lastIndex] > key) {
                tempArray[lastIndex + 1] = tempArray[lastIndex];
                lastIndex = lastIndex - 1;
            }

            tempArray[lastIndex + 1] = key;
        }

        return tempArray;
    }

    private static void merge(int[] tempArray, int firstIndex, int middleIndex, int lastIndex) {

        /*Setting two indices to two subarray.*/
        int indexOfFirstSubArray = middleIndex - firstIndex + 1;
        int indexOfSecondSubArray = lastIndex - middleIndex;

        /* Creating 2 subarray. One of the first portion of the tempArray,
         * and second one with last elements.*/
        int[] firstSubArray = new int[indexOfFirstSubArray];
        int[] secondSubArray = new int[indexOfSecondSubArray];

        /* Using arraycopy to simplify.*/
        System.arraycopy(tempArray, firstIndex, firstSubArray, 0, indexOfFirstSubArray);
        System.arraycopy(tempArray, middleIndex + 1, secondSubArray, 0, indexOfSecondSubArray);

        /*To keep track of how many values I've pushed.*/
        int indexOne = 0, indexTwo = 0;

        int mainIndex = firstIndex;
        while (indexOne < indexOfFirstSubArray && indexTwo < indexOfSecondSubArray) {

            if (firstSubArray[indexOne] <= secondSubArray[indexTwo]) {
                tempArray[mainIndex] = firstSubArray[indexOne];
                indexOne++;
            } else {
                tempArray[mainIndex] = secondSubArray[indexTwo];
                indexTwo++;
            }

            mainIndex++;
        }

        /*Adding the rest of the values.*/
        while (indexOne < indexOfFirstSubArray) {
            tempArray[mainIndex] = firstSubArray[indexOne];
            indexOne++;
            mainIndex++;
        }

        /*Adding the rest of the values.*/
        while (indexTwo < indexOfSecondSubArray) {
            tempArray[mainIndex] = secondSubArray[indexTwo];
            indexTwo++;
            mainIndex++;
        }
    }

    static void mergeSort(int[] tempArray, int firstIndex, int lastIndex) {

        if (firstIndex < lastIndex) {

            int middleIndex = (firstIndex + lastIndex) / 2;

            mergeSort(tempArray, firstIndex, middleIndex);
            mergeSort(tempArray, middleIndex + 1, lastIndex);

            merge(tempArray, firstIndex, middleIndex, lastIndex);
        }
    }

    private static int partition(int[] tempArray, int low, int high) {

        int pivot = tempArray[low];

        int i = low;

        for (int j = low + 1; j <= high; j++) {

            if (tempArray[j] <= pivot) {

                i++;

                int temp = tempArray[i];
                tempArray[i] = tempArray[j];
                tempArray[j] = temp;
            }
        }

        int temp = tempArray[i];
        tempArray[i] = pivot;
        tempArray[low] = temp;

        return i;
    }

    static void quickSort(int[] tempArray, int low, int high) {

        if (low < high) {

            int partitionIndex = partition(tempArray, low, high);

            quickSort(tempArray, low, partitionIndex - 1);
            quickSort(tempArray, partitionIndex + 1, high);
        }
    }

    private static int randomizedPartition(int[] tempArray, int low, int high) {

        int randomPivotIndex = ThreadLocalRandom.current().nextInt(low, high + 1);

        int temp = tempArray[low];
        tempArray[low] = tempArray[randomPivotIndex];
        tempArray[randomPivotIndex] = temp;

        return partition(tempArray, low, high);
    }

    static void randomizedQuickSort(int[] tempArray, int low, int high) {
        if (low < high) {

            int partitionIndex = randomizedPartition(tempArray, low, high);

            randomizedQuickSort(tempArray, low, partitionIndex - 1);
            randomizedQuickSort(tempArray, partitionIndex + 1, high);
        }
    }

    static void printArray(int[] tempArray) {
        System.out.println(Arrays.toString(tempArray));
    }
}
