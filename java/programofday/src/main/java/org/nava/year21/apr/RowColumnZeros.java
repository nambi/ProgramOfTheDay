package org.nava.year21.apr;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a two-dimensional array, if any element within is zero,
 * make its whole row and column zero.
 */
public class RowColumnZeros {


    static void makeZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        Set<Integer> zeroRows = new HashSet<Integer>();
        Set<Integer> zeroCols = new HashSet<Integer>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (matrix[i][j] == 0) {
                    if (!zeroRows.contains(i)) {
                        zeroRows.add(i);
                    }

                    if (!zeroCols.contains(j)) {
                        zeroCols.add(j);
                    }
                }
            }
        }

        for (int r : zeroRows) {
            for (int c = 0; c < cols; ++c) {
                matrix[r][c] = 0;
            }
        }

        for (int c : zeroCols) {
            for (int r = 0; r < rows; ++r) {
                matrix[r][c] = 0;
            }
        }
    }

    public static boolean test2() {

        int[][] input = {{5, 4, 3, 9}, {2, 0, 7, 6}, {1, 3, 4, 0}, {9, 8, 3, 4}};

        System.out.println("Before\n");
        printMatrix(input);
        makeZeroes(input);
        System.out.println("\nAfter\n");
        printMatrix(input);

        int[][] expectedResult = {{5, 0, 3, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {9, 0, 3, 0}};

        System.out.println("\nExpected\n");
        printMatrix(expectedResult);

        return (input[1][0] == 0);
    }

    public static boolean test1() {

        int[][] input = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                input[i][j] = i + j;
                if (i + j == 2) {
                    input[i][j] = 0;
                }
            }
        }
        System.out.println("Before\n");
        printMatrix(input);
        makeZeroes(input);
        System.out.println("\nAfter\n");
        printMatrix(input);
        return (input[1][0] == 0);
    }

    public static void printMatrix(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                System.out.print(input[i][j] + "\t");

            }
            System.out.println();
        }

    }

    public static boolean doAllTestsPass() {


        return test1() && test2();
    }

    public static void main(String[] args) {
        if (doAllTestsPass()) {
            System.out.println("All Tests pass");
        } else {
            System.out.println("Tests failed");
        }
    }
}
