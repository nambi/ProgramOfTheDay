package org.nava.year21.mar;

import java.util.Arrays;

/*
Given an integer array, sort it in ascending order using quicksort.
 */
public class QuickSort {

    static int getPivotIndex(int[] arr, int low, int high) {
        int pivotValue = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (i <= high && arr[i] <= pivotValue) i++;
            while (arr[j] > pivotValue) j--;

            if (i < j) {
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        arr[low] = arr[j];
        arr[j] = pivotValue;

        // return the pivot index
        return j;

    }

    static void quickSortRecur(int[] arr, int low, int high) {
        if (high > low) {
            int pivotIndex = getPivotIndex(arr, low, high);
            quickSortRecur(arr, low, pivotIndex - 1);
            quickSortRecur(arr, pivotIndex + 1, high);
        }
    }


    static void quickSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            System.out.println("Invalid or Already sorted");
            return;
        }

        quickSortRecur(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] a = new int[]{55, 23, 26, 2, 18, 78, 23, 8, 2, 3};

        System.out.print("Before Sorting\n");
        System.out.print(Arrays.toString(a) + "\n");

        quickSort(a);

        System.out.print("After Sorting\n");
        System.out.print(Arrays.toString(a));
    }
}
