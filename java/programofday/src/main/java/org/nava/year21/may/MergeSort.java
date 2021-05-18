package org.nava.year21.may;

public class MergeSort {

    // O (n log(n))
    static int[] sort(int[] input) {

        if (input == null || input.length < 2) {
            return input;
        }

        int middle = input.length / 2;
        int[] left = new int[middle];
        int[] right = new int[input.length - middle];

        System.arraycopy(input, 0, left, 0, left.length);
        System.arraycopy(input, middle, right, 0, right.length);

        left = sort(left);
        right = sort(right);

        return merge(input, left, right);
    }

    static int[] merge(int[] destination, int[] left, int[] right) {

        int leftSize = 0;
        int rightSize = 0;
        int destSize = 0;
        while (leftSize < left.length && rightSize < right.length) {
            if (left[leftSize] <= right[rightSize]) {
                destination[destSize] = left[leftSize];
                leftSize++;
                destSize++;
            } else {
                destination[destSize] = right[rightSize];
                rightSize++;
                destSize++;
            }
        }

        while (leftSize < left.length) {
            destination[destSize] = left[leftSize];
            leftSize++;
            destSize++;
        }

        while (rightSize < right.length) {
            destination[destSize] = right[rightSize];
            rightSize++;
            destSize++;
        }

        return destination;

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
