package org.nava.year21.may;

/**
 * Search, or find the position of, a given key in a 2D matrix.
 * All rows and columns are sorted.
 */
public class SearchInMatrix {

    static String search(int[][] matrix, int searchInput) {
     /* option 1: loop through all and find it => complexity O(mn)
        option 2 : binary search in each row as they are sorted => complexity O(mlogn)
        option 3 :  Let's start searching from top right, move to left and rows down => complexity O(m+n)

        Alternatively, searching from bottom left

        i.e. matrix[M-1][0] can also work.
      */
        int M = matrix.length; //rows
        int N = matrix[0].length; // columns
        int row = 0;
        int col = N - 1;

        while (row < M && col >= 0) {
            int currentVal = matrix[row][col];
            if (searchInput == currentVal) {
                return row + "," + col;
            } else if (searchInput < currentVal) {
                // search left
                col--;
            } else {
                // search down.
                row++;
            }
        }

        return "0,0";
    }

    static int[][] getMatrix() {
        int len = 3;
        int factor = 1;
        int[][] input = new int[len][len];
        for (int i = 1; i < (len + 1); i++) {
            for (int j = 1; j < (len + 1); j++) {
                input[i - 1][j - 1] = factor + i + j;
            }
            factor = factor + 2;
        }

        return input;
    }

    static void printMatrix(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                System.out.print(input[i][j] + "\t");
            }
            System.out.println();
        }
    }


    static boolean test1() {
        int[][] input = getMatrix();
        printMatrix(input);
        String result = search(input, 7);
        System.out.println("Result " + result);
        return (result.equals("1,1"));
    }

    static boolean doAllTestsPass() {

        return test1();
    }

    public static void main(String[] args) {
        if (doAllTestsPass()) {
            System.out.println("All Tests pass");
        } else {
            System.out.println("Tests failed ");
        }
    }
}
