package org.nava.year21.may;

public class InsertionSort {

    /**
     * keep replacing the higher order elements before lower order elements
     * with System.arrayCopy
     *
     * @param input
     */
    static void sort(int[] input) {

        if (input == null || input.length < 2) {
            return;
        }
        // O (n^2)
        for (int i = 1; i < input.length; i++) {
            int valueToCompare = input[i];
            for (int j = 0; j < i; j++) {
                if (input[j] > valueToCompare) {
                    System.arraycopy(input, j, input, j + 1, i - j);
                    input[j] = valueToCompare;
                    print(input);
                    break;
                }
            }
        }
    }

    static void print(int[] input) {
        System.out.println("-----------");
        for (int i : input) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    static boolean test1() {
        int[] input = {4, 6, 2, 8, 0};
        print(input);
        sort(input);
        print(input);
        boolean result = (input != null && input[0] == 0);
        System.out.println("The  Test1 is " + result);
        return result;
    }


    static boolean doAllTestsPass() {

        return test1();
    }

    public static void main(String[] args) {
        if (doAllTestsPass()) {
            System.out.println("All Tests pass");
        } else {
            System.out.println("Tests failed");
        }

    }
}
