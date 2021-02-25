package org.nava.year21.feb;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given three integer arrays sorted in ascending order, return the smallest number that is common in all three arrays.
 */
public class SmallestNumberInArray {

    public static void main(String[] args) {
        int[] v1 = new int[]{2, 3, 5, 6, 7, 10, 25, 30, 63, 64};
        int[] v2 = new int[]{1, 4, 5, 6, 7, 8, 50};
        int[] v3 = new int[]{1, 5, 6, 10, 14};

        Integer result = findLeastCommonNumber2(v1, v2, v3);
        System.out.println("Least Common Number: " + result);
    }

    static Integer findLeastCommonNumber(int[] arr1, int[] arr2, int[] arr3) {
        Deque<Integer> leastCommon = new ArrayDeque<>();

        int len1 = arr1.length;
        int len2 = arr2.length;
        int len3 = arr3.length;

        if (arr1 == null || arr2 == null || arr3 == null || len1 < 0 || len2 < 0 || len3 < 0) {
            return -1;
        }

        int maxLength = len1 > len2 ? len1 : len2;
        maxLength = maxLength > len3 ? maxLength : len3;

        for (int i = 0; i < maxLength; i++) {
            int count = 1;
            if (!leastCommon.isEmpty()) {
                leastCommon.removeLast();
            }
            leastCommon.addLast(arr1[i]);

            for (int j = 0; j < arr2.length; j++) {
                if (arr2[j] == leastCommon.peekLast()) {
                    count++;
                    break;
                }
                if (arr2[j] > leastCommon.peekLast()) {
                    break;
                }
            }
            if (count == 1) {
                continue;
            }

            for (int k = 0; k < arr3.length; k++) {
                if (arr3[k] == leastCommon.peekLast()) {
                    count++;
                    break;
                }

                if (arr3[k] > leastCommon.peekLast()) {
                    break;
                }
            }

            if (count == 3) {
                return leastCommon.peekLast();
            }

        }

        return -1;
    }

    static Integer findLeastCommonNumber2(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0, j = 0, k = 0;

        while(i < arr1.length && j < arr2.length && k < arr3.length) {

            // Finding the smallest common number
            if(arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                return arr1[i];
            }

            // Let's increment the iterator
            // for the smallest value.

            if(arr1[i] <= arr2[j] && arr1[i] <= arr3[k]) {
                i++;
            }

            else if(arr2[j] <= arr1[i] && arr2[j] <= arr3[k]) {
                j++;
            }

            else if(arr3[k] <= arr1[i] && arr3[k] <= arr2[j]) {
                k++;
            }
        }
        return -1;
    }

}
