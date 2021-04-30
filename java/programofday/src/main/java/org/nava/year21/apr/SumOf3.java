package org.nava.year21.apr;

/**
 * Given an array of integers and a value,
 * determine if there are any three integers in the array whose sum equals the given value.
 * [1,5,2,3,6,8] -- > 6
 */
public class SumOf3 {


    public static boolean sumExists(int[] input, int sum) {

        if (input.length >= 3 && sum > 0) {
            if (input.length == 3) {
                return (sum == input[0] + input[1] + input[2]);
            }

            /**
             * iterate on 2nd and 3rd combinations
             */

            for (int i = 0; i < input.length - 2; i++) {
                int first = input[i];
                for (int j = i + 1; j < input.length - 1; j++) {
                    int second = input[j];
                    for (int k = j + 1; k < input.length; k++) {
                        int third = input[k];
                        System.out.println("Sum of  " + first + "," + second + "," + third);
                        int currentSum = (first + second + third);
                        if (currentSum == sum) {
                            return true;
                        }
                    }
                }
            }

        }
        return false;
    }


    public static boolean test1() {

        int[] input = {3, 7, 4, 9, 2, 5};
        int sum = 10;
        boolean result = sumExists(input, sum);

        return result;
    }

    public static boolean doAllTestsPass() {


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
