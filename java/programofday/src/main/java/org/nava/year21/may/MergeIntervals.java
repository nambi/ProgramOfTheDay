package org.nava.year21.may;

import java.util.ArrayList;

/**
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 */
public class MergeIntervals {

    static int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return null;
        }

        int[][] output = new int[intervals.length][2];

        int currentMin = intervals[0][0];
        int currentMax = intervals[0][1];
        int outputIndex = 0;
        boolean minMaxChanged = false;
        for (int i = 1; i < intervals.length; i++) {
            minMaxChanged = false;
            int rowVal = intervals[i][0];
            int colVal = intervals[i][1];

            if(currentMax >= rowVal) {
                if (currentMax <= colVal) {
                    currentMax = colVal;
                    minMaxChanged = true;
                }else if (colVal >0){
                    minMaxChanged = true;
                }

            }

            if (rowVal <= currentMin) {
                if(colVal >= currentMin) {
                    currentMin = rowVal;
                    minMaxChanged = true;
                }
            }
            if (!minMaxChanged) {
                output[outputIndex][0] = currentMin;
                output[outputIndex][1] = currentMax;
                outputIndex++;
                currentMin = rowVal;
                currentMax = colVal;

            }
        }
        output[outputIndex][0] = currentMin;
        output[outputIndex][1] = currentMax;
        outputIndex++;

        int[][] newOutput = new int[outputIndex][2];

        for (int i = 0; i < outputIndex; i++) {
            newOutput[i] = output[i];
        }

        return newOutput;
    }

    static void print(int[][] output) {
        if (output != null) {
            for (int i = 0; i < output.length; i++) {
                if (output[i] != null) {
                    for (int j = 0; j < output[i].length; j++) {
                        System.out.println(i + "," + j + " == >" + output[i][j]);
                    }
                    System.out.println("------");
                }
            }
        }
    }


    static boolean test6() {
        int[][] intervals = {{2, 3}, {4, 5},{6,7},{8,9},{1,10}};
        System.out.println("Input");
        print(intervals);

        int[][] output = merge(intervals);
        System.out.println("Output");
        print(output);
        boolean result = (output != null && output.length == 1 && output[0][0] == 1);
        System.out.println("Test6 result " + result);
        return result;
    }
    static boolean test5() {
        int[][] intervals = {{1, 4}, {2, 3}};
        System.out.println("Input");
        print(intervals);

        int[][] output = merge(intervals);
        System.out.println("Output");
        print(output);
        boolean result = (output != null && output.length == 1 && output[0][0] == 1);
        System.out.println("Test5 result " + result);
        return result;
    }

    static boolean test4() {
        int[][] intervals = {{1, 4}, {0, 0}};
        System.out.println("Input");
        print(intervals);

        int[][] output = merge(intervals);
        System.out.println("Output");
        print(output);
        boolean result = (output != null && output.length == 2);
        System.out.println("Test4 result " + result);
        return result;
    }

    static boolean test3() {
        int[][] intervals = {{1, 4}, {0, 1}};
        System.out.println("Input");
        print(intervals);

        int[][] output = merge(intervals);
        System.out.println("Output");
        print(output);
        boolean result = (output != null && output.length == 1 && output[0][1] == 4);
        System.out.println("Test3 result " + result);
        return result;
    }

    static boolean test2() {
        int[][] intervals = {{1, 4}, {0, 4}};
        System.out.println("Input");
        print(intervals);

        int[][] output = merge(intervals);
        System.out.println("Output");
        print(output);
        boolean result = (output != null && output.length == 1 && output[0][1] == 4);
        System.out.println("Test2 result " + result);
        return result;
    }

    static boolean test1() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Input");
        print(intervals);

        int[][] output = merge(intervals);
        System.out.println("Output");
        print(output);
        boolean result = (output != null && output.length == 3 && output[0][1] == 6);
        System.out.println("Test1 result " + result);
        return result;
    }

    static boolean doAllTestsPass() {

        return test1() && test2() && test3() && test4() && test5() && test6();
    }


    public static void main(String[] args) {
        if (doAllTestsPass()) {
            System.out.println("All Tests pass");
        } else {
            System.out.println("Tests failed");
        }

    }
}
