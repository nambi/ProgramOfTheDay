package org.nava.algo;

/**
 * Step-1: You have to pick a pivot. This could be randomly selected or the
 * middle one. Here we select the last element of the array. Step-2: Put all the
 * items smaller than the pivot value to the left and larger than the pivot
 * value to the right. Step-3:Repeat the step-2 for both left and right side of
 * the pivot (pick a pivot, put all item smaller than the pivot to the left and
 * larger on the right)
 * 
 * https://khan4019.github.io/front-end-Interview-Questions/sort.html#quickSort
 */

public class QuickSort {

    public static void main(String[] args) {
        int[] input = { 5,3, 8, 1, 7 };
        System.out.println("Input Array...");
        print(input);
        int left = 0;
        int right = input.length - 1;
        quickSort(input, left, right);
        System.out.println("Sorted Array...");
        print(input);

    }

    private static void print(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i]);
            if (i == (len - 1)) {
                System.out.println();
            } else {
                System.out.print(",");
            }
        }
    }

    private static void quickSort(int[] arr, int left, int right) {
        int pivot, partitionIndex;

        if (left < right) {
            pivot = right;
            partitionIndex = partition(arr, pivot, left, right);

            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
    }

    private static int partition(int[] arr, int pivot, int left, int right) {
        int pivotValue = arr[pivot], partitionIndex = left;

        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(arr, right, partitionIndex);
        return partitionIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}