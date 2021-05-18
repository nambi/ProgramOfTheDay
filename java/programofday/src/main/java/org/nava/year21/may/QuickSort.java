package org.nava.year21.may;

public class QuickSort {
    /**
     * compare with the middle value and keep less values in left and high values in right
     * then combine all 3 parts (left (less) + middle (equal) + right (high)). Keep doing it until you compare individual values
     *
     * @param input
     */

    // O (n log(n))
    static int[] sort(int[] input) {

        if (input == null || input.length < 2) {
            return input;
        }

        int middle = input.length / 2;
        int middleValue = input[middle];
        int leftSize = 0;
        int rightSize = 0;
        for (int i = 0; i < input.length; i++) {
            if(i == middle) continue;

            if (input[i] < input[middle]) {
                leftSize++;
            } else if (input[i] > input[middle]) {
                rightSize++;
            }
        }

        int[] left = new int[leftSize];
        int[] right = new int[rightSize];
        leftSize = 0;
        rightSize = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] < input[middle]) {
                left[leftSize] = input[i];
                leftSize++;
            } else if (input[i] > input[middle]) {
                right[rightSize] = input[i];
                rightSize++;
            }
        }
        left = sort(left);
        right = sort(right);
        System.arraycopy(left, 0, input, 0, leftSize);
        input[leftSize] = middleValue;
        System.arraycopy(right, 0, input, leftSize + 1, rightSize);
        return input;
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
