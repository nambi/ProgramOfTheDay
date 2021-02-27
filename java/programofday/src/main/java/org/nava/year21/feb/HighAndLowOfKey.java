package org.nava.year21.feb;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/*
Given a sorted array of integers, return the low and high index of the given key.
Given a sorted array of integers, return the low and high index of the given key. You must return -1 if the indexes are not found.
The array length can be in the millions with many duplicates.
 */
public class HighAndLowOfKey {

    static int binarySearch(List<Integer> arr, int key) {


        return -1;
    }

    static int findLowIndex(List<Integer> arr, int key) {
        //TODO: binary search, traverse left until mismatch for low
        if (arr != null && arr.size() > 0) {
            int middleIndex = Collections.binarySearch(arr, key);
            if (middleIndex > -1) {
                if (middleIndex == 0 || middleIndex == (arr.size() - 1)) return middleIndex;

                int lowIndex = middleIndex;
                int value = arr.get(middleIndex);
                for (int i = middleIndex; i > 0; i--) {
                    if (arr.get(i) == value) {
                        lowIndex = i;
                    } else {
                        return lowIndex;
                    }
                }
            }
        }
        return -1;
    }

    static int findHighIndex(List<Integer> arr, int key) {
        //TODO: binary search, traverse right until mismatch for high
        if (arr != null && arr.size() > 0) {
            int middleIndex = Collections.binarySearch(arr, key);
            if (middleIndex > -1) {
                if (middleIndex == 0 || middleIndex == (arr.size() - 1)) return middleIndex;
                int highIndex = middleIndex;
                int value = arr.get(middleIndex);
                for (int i = middleIndex; i < arr.size(); i++) {
                    if (arr.get(i) == value) {
                        highIndex = i;
                    } else {
                        return highIndex;
                    }
                }
            }
        }
        return -1;
    }

    static int findLowIndexOptimized (List<Integer> arr, int key) {
        int low = 0;
        int high = arr.size() - 1;
        int mid = high / 2;

        while (low <= high) {

            int midElem = arr.get(mid);

            if (midElem < key) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }

            mid = low + (high - low) / 2;
        }

        if (low < arr.size() && arr.get(low) == key) {
            return low;
        }

        return -1;
    }

    static int findHighIndexOptimized(List<Integer> arr, int key) {
        int low = 0;
        int high = arr.size() - 1;
        int mid = high / 2;

        while (low <= high) {

            int midElem = arr.get(mid);

            if (midElem <= key) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }

            mid = low + (high - low) / 2;
        }

        if(high == -1){
            return high;
        }

        if (high < arr.size() && arr.get(high) == key) {
            return high;
        }

        return -1;
    }

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6);
        int key = 5;
        long t1 = Calendar.getInstance().getTimeInMillis();
        int low = findLowIndexOptimized(array, key);
        int high = findHighIndexOptimized(array, key);
        long t2 = Calendar.getInstance().getTimeInMillis();
        System.out.println("Low Index of " + key + ": " + low);
        System.out.println("High Index of " + key + ": " + high);
        System.out.println("Performance "+(t2-t1));

        t1 = Calendar.getInstance().getTimeInMillis();
        key = -2;
        low = findLowIndex(array, key);
        high = findHighIndex(array, key);
        t1 = Calendar.getInstance().getTimeInMillis();
        System.out.println("Low Index of " + key + ": " + low);
        System.out.println("High Index of " + key + ": " + high);
        System.out.println("Performance "+(t2-t1));


        List<Integer> array2 = Arrays.asList(1, 2);
        key = 2;
        low = findLowIndex(array2, key);
        high = findHighIndex(array2, key);
        System.out.println("Low Index of " + key + ": " + low);
        System.out.println("High Index of " + key + ": " + high);
    }

}
