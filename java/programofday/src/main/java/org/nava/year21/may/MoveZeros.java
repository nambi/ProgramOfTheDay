package org.nava.year21.may;

public class MoveZeros {

    static int[] moveZeros(int[] input) {

        if (input == null || input.length < 1) {
            return input;
        }

        int zeroIndex = 0;
        for (int i = 1; i < input.length; i++) {
            int element = input[i];
            if (element == 0) {
                //swap
                int zeroIndexVal = input[zeroIndex];
                input[i] = zeroIndexVal;
                input[zeroIndex] = element; //can be zero
                zeroIndex++;
            }
        }
        return input;
    }

    static void print(int[] input) {
        System.out.println("print input");
        for (int i : input) {
            System.out.print(i + ",");
        }
        System.out.println("");
    }

    static boolean test1() {
        int[] input = {4, 5, 0, 3, 1, 0};
        int[] result = moveZeros(input);
        print(result);
        return (result != null && result.length == 6 && result[1] == 0);
    }

    static boolean doAllTestsPass() {

        return test1();
    }


    public static void main(String[] args) {

        if (doAllTestsPass()) {
            System.out.println("All Tests pass");
        } else {
            System.out.println("Failed");
        }

    }
}
