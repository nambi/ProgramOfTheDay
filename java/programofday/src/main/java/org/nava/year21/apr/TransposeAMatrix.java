package org.nava.year21.apr;

public class TransposeAMatrix {

    public static void swap(int[][] inputa, int[][] inputb) {
        int[][] inputc = inputa;
        inputa = inputb;
        inputb = inputa;
    }

    public static void transpose(int[][] input) {
        //first change column to row
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                int c = input[j][i];
                input[j][i] = input[i][j];
                input[i][j] = c;
            }
        }
        //reverse each row
        int len = input.length - 1;
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= len / 2; j++) {
                int c = input[i][len - j];
                input[i][len - j] = input[i][j];
                input[i][j] = c;
            }
        }
    }

    public static boolean test1() {
        int len = 3;
        int factor = 2;
        int[][] input = new int[len][len];
        for (int i = 1; i < (len + 1); i++) {
            for (int j = 1; j < (len + 1); j++) {
                input[i - 1][j - 1] = factor * i * j;
            }
        }
        System.out.println("Input Matrix");
        printMatrix(input);
        System.out.println("============================");
        transpose(input);
        System.out.println("Transposed Matrix");
        printMatrix(input);
        System.out.println("============================");

        return (input[0][0] == 6);
    }

    public static void printMatrix(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                System.out.print(input[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static boolean doAllTestsPass() {

        return test1();
    }

    public static void main(String[] args) {

        if (doAllTestsPass()) {
            System.out.println("All Tests pass");
        } else {
            System.out.println("Test failed");
        }

    }
}
