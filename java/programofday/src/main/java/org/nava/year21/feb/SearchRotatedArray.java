package org.nava.year21.feb;

/*
Search for a given number in a sorted array, with unique elements, that has been rotated by some arbitrary number. Return -1 if the number does not exist.
Assume that the array does not contain duplicates.
 */
public class SearchRotatedArray {

    public static void main(String[] args) {

        int[] v1 = {6, 7, 1, 2, 3, 4, 5};
        System.out.println("Key(3) found at: " + binarySearchRotated(v1, 3));
        System.out.println("Key(6) found at: " + binarySearchRotated(v1, 6));

        int[] v2 = {4, 5, 6, 1, 2, 3};
        System.out.println("Key(3) found at: " + binarySearchRotated(v2, 3));
        System.out.println("Key(6) found at: " + binarySearchRotated(v2, 6));

        int[] v3 = {4, 5, 6, 1, 2, 3, 8, 9, 12, 16};
        System.out.println("Key(8) found at: " + binarySearchRotated(v3, 8));
        System.out.println("Key(6) found at: " + binarySearchRotated(v3, 6));

    }

    static int binarySearchRotated(int[] arr, int key) {

        if (arr == null || arr.length < 1) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;

        while (start < end) {

            mid = (start + end) / 2;

            if (key == arr[mid]) {
                return mid;
            }

            if (key == arr[start]) {
                return start;
            }

            if (key == arr[end]) {
                return end;
            }

            if (key > arr[start] && key < arr[mid]) {
                end = mid;
            }

            if (key > arr[mid] && key < arr[end]) {
                start = mid;
            }
        }
        return -1;
    }

}
