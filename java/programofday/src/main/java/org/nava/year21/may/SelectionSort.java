package org.nava.year21.may;


public class SelectionSort {


    static int findMinIndex(int[] input, int start) {
        if (start >= input.length) {
            start = input.length - 1;
        }
        int minIndex = start;
        int minValue = input[start];
        for (int i = start + 1; i < input.length; i++) {
            if (input[i] < minValue) {
                minIndex = i;
                minValue = input[i];

            }
        }
        return minIndex;
    }

    /**
     * find the min of array and move to the left most
     *
     * @param input
     */
    static void sort(int[] input) {

        if (input == null || input.length < 2) {
            return;
        }
        // O (n^2)
        for (int i = 0; i < input.length; i++) {
            int minIndexInRestOfTheArray = findMinIndex(input, i + 1);
            int minValInRestOfTheArray = input[minIndexInRestOfTheArray];
            if (input[i] > minValInRestOfTheArray) {
                int temp = input[i];
                input[i] = minValInRestOfTheArray;
                input[minIndexInRestOfTheArray] = temp;
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

    static boolean test0() {
        int[] input = {4, 6, 0, 2, 8, 4, 2, 6};

        int min = findMinIndex(input, 5);
        boolean result = (input != null && min == 6);
        System.out.println("The min index is " + min + " Test0 is " + result);
        return result;
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

        return test0() && test1();
    }

    public static void main(String[] args) {
        if (doAllTestsPass()) {
            System.out.println("All Tests pass");
        } else {
            System.out.println("Tests failed");
        }

    }

}
