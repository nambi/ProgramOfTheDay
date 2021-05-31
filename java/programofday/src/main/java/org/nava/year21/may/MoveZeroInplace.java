package org.nava.year21.may;

public class MoveZeroInplace {

    static void moveZeroes(int[] nums) {

        int lastNonZeroFoundAt = 0;
        // If the current element is not 0, then we need to
        // append it just in front of last non 0 element we found.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        // After we have finished processing new elements,
        // all the non-zero elements are already at beginning of array.
        // We just need to fill remaining array with 0's.
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

        static void moveZerosToRight ( int[] A){
            int swapIndex = A.length - 1;
            for (int i = A.length - 1; i > -1; i--) {
                if (A[i] != 0) {
                    continue;
                } else {
                    for (int k = i; k < swapIndex; k++) {
                        int temp = A[k + 1];
                        A[k + 1] = A[k];
                        A[k] = temp;
                    }
                    swapIndex--;
                }
            }
        }

        static void test1 () {

            int[] input = {0, 1, 0, 3, 12};
            moveZeroes(input);
            for (int i : input) {
                System.out.print(i + ",");
            }
            boolean result = (input[0] == 1);
            System.out.println("\ntest1 result " + result);
        }

        public static void main (String[]args){
            test1();
        }
    }
