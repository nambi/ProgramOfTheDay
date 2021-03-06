package org.nava.year21.mar;

import java.util.*;

/**
 * Given an array of integers and a value, determine if there are any two integers in the array whose sum is equal to the given value.
 * Return true if the sum exists and return false if it does not.
 */
public class FindPairForSum {

    public static boolean sumExists(int[] input, int sum) {
        // find all distinct factor pairs,  search and find these values exists (on the first exists  = break true)
        // 9 = 0+9, 1+9,2+7, 3+6, 4+5 O(logn)

        for (int i = 0; i <= sum / 2; i++) {
            int x = sum - i;
            int y = sum - x;
            if (x != y) {
                int exists = 0;
                for (int j = 0; j < input.length; j++) {
                    if (input[j] == x || input[j] == y) {
                        exists++;
                    }
                    if (exists == 2) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean sumExistsOptimized(int[] input, int sum) {
        Set<Integer> foundValues = new HashSet<Integer>();
        for (int a : input) {
            if (foundValues.contains(sum - a)) {
                return true;
            }

            foundValues.add(a);
        }
        return false;
    }

    public static void main(String[] args) {

        long t0= Calendar.getInstance().getTimeInMillis();
        System.out.println("Sum exists " + sumExists(new int[]{4, 5, 6, 8, 9}, 9));
        System.out.println("Sum exists " + sumExists(new int[]{2, 1, 8, 4, 7, 3}, 7));
        long t1= Calendar.getInstance().getTimeInMillis();
        System.out.println("Time taken : "+(t1-t0));

        t0= Calendar.getInstance().getTimeInMillis();
        System.out.println("Sum exists " + sumExistsOptimized(new int[]{4, 5, 6, 8, 9}, 9));
        System.out.println("Sum exists " + sumExistsOptimized(new int[]{2, 1, 8, 4, 7, 3}, 7));
        t1= Calendar.getInstance().getTimeInMillis();
        System.out.println("Time taken : "+(t1-t0));

    }
}
