package org.nava.year21.feb;

import java.util.*;

/**
 * Given an array of integers, rotate the array by 'N' elements
 * <p>
 * Given an array of integers, rotate the array by N elements where N is an integer:
 * For positive values of N, perform a right rotation.
 * For negative values of N, perform a left rotation.
 * Make sure you make changes to the original array.
 */
public class RotateArrayByN {

    static void rotateArray(List<Integer> arr, int n) {

        if (arr == null || arr.size() < 0 || arr.size() < Math.abs(n)) {
            System.out.println("Exception- Array cannot be rotated");
        }

        if (arr.size() == n) {
            System.out.println("Array rotation is same as that of original Array");
        }

        if (arr.size() == -1 * n) {
            System.out.println("Array is fully reversed");
        }

        List<Integer> newArr = new ArrayList<>();

        if(n > 0) {
            //For positive N
            for (int i = arr.size() - n; i < arr.size(); i++) {
                newArr.add(arr.get(i));
            }

            for (int i = 0; i < arr.size() - n; i++) {
                newArr.add(arr.get(i));
            }

        }else{
            //For negative N
            for (int i = Math.abs(n); i < arr.size(); i++) {
                newArr.add(arr.get(i));
            }
            for (int i = 0; i < Math.abs(n); i++) {
                newArr.add(arr.get(i));
            }
        }

        for (int i = 0; i < newArr.size(); i++) {
            arr.set(i, newArr.get(i));
        }

    }


    static void reverseArray(List<Integer> arr, int start, int end) {
        while (start < end) {
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            ++start;
            --end;
        }
    }

    static void rotateArrayOptimized(List<Integer> arr, int n) {

        int len = arr.size();
        // Let's normalize rotations
        // if n > array size or n is negative.
        n = n % len;
        if (n < 0) {
            // calculate the positive rotations needed.
            n = n + len;
        }

        // Let's partition the array based on rotations 'n'.
        // For example: 1, 2, 3, 4, 5 where n = 2.
        // -> 5, 4, 3, 2, 1
        // -> 4, 5, 3, 2, 1
        // -> 4, 5, 1, 2, 3

        reverseArray(arr, 0, len-1);
        reverseArray(arr, 0, n-1);
        reverseArray(arr, n, len-1);
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 10, 20, 0, 59, 86, 32, 11, 9, 40);
        System.out.println("Array Before Rotation\n" + arr);
        int rotateN = 2;
        rotateArray(arr, rotateN);
        //9,40,1,10,20,0,59,86,32,11
        System.out.println("Array After Rotation by "+rotateN+"\n" + arr);
        rotateN = -1;
        rotateArrayOptimized(arr, rotateN);
        //10,20,0,59,86,32,11,9,40,1
        System.out.println("Array After Rotation by "+rotateN+"\n" + arr);
    }
}
