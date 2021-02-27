package org.nava.year21.feb;

import java.util.Arrays;

/**
 * Move all zeros to the left of an array while maintaining its order.
 * Given an integer array, move all elements that are 0 to the left while maintaining the order of other elements in the array.
 * The array has to be modified in-place.
 */
public class MoveAllZeros {

    static void moveZerosToLeft(int[] A) {
        int swapIndex = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != 0) {
                continue;
            } else {
                int temp = A[swapIndex];
                A[swapIndex] = 0;
                A[i] = temp;
                swapIndex++;
            }
        }
    }

    static void moveZerosToRight(int[] A) {
        int swapIndex = A.length-1;
        for (int i = A.length-1; i > -1; i--) {
            if (A[i] != 0) {
                continue;
            } else {
                int temp = A[swapIndex];
                A[swapIndex] = 0;
                A[i] = temp;
                swapIndex--;
            }
        }
    }

    public static void main(String[] args) {
        int[] v = new int[]{1, 10, 20, 0, 59, 63, 0, 88, 0};
        System.out.println("Original Array: " + Arrays.toString(v));

        moveZerosToLeft(v);

        System.out.println("After Moving Zeroes to Left: " + Arrays.toString(v));

        moveZerosToRight(v);

        System.out.println("After Moving Zeroes to Left: " + Arrays.toString(v));
    }
}
