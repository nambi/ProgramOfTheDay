package org.nava.year21.mar;

import java.util.HashMap;
import java.util.Map;

/**
 * Get the best average for students with multiple marks
 * List of students and their marks are given in 2D array
 * {{5,6,3},{19,1,0},{14,5,2}};
 */
public class BestAverageA {

    public static int getBestAverage(int[][] inputMarks) {

        int max = 0;
        for (int i = 0; i < inputMarks.length; i++) {

            int sum = 0;
            for (int j = 0; j < inputMarks[i].length; j++) {
                sum = sum + inputMarks[i][j];

            }
            int avg = sum / inputMarks[i].length;
            if (avg > max) {
                max = avg;
            }
        }

        return max;
    }

    public static boolean test2() {

        int[][] inputMarks = {{5, 0,9}, {21, 1}, {14, 5, 2}};

        int bestAverage = getBestAverage(inputMarks);

        boolean result = (bestAverage == 11);
        if (!result) {
            System.out.println("test2 failed");
        }
        return result;
    }

    public static boolean test1() {

        int[][] inputMarks = {{5, 6, 3}, {19, 1, 0}, {14, 5, 2}};

        int bestAverage = getBestAverage(inputMarks);

        boolean result = (bestAverage == 7);
        if (!result) {
            System.out.println("test1 failed");
        }

        return result;
    }

    public static boolean doTestsPass() {

        return test1() && test2();

    }

    public static void main(String[] args) {

        if (doTestsPass()) {
            System.out.println("All tests pass");
        }
    }
}
