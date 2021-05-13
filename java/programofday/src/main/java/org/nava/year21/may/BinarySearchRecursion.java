package org.nava.year21.may;

public class BinarySearchRecursion {

    // linear, O (n)
    static int searchNonRecur(int[] input, int num) {

        for (int i = 0; i < input.length; i++) {
            if (input[i] == num) {
                return i;
            }
        }

        return -1;
    }

    // want to achieve better with O(log(n)); - logarithmic
    //sorted array, keep checking the mid and ignore the rest if its greater than required value
    static int searchRecur(int[] input, int num, int minIndex, int maxIndex) {

        if (input.length == 0 || minIndex > input.length || maxIndex < 0) {
            return -1;
        }

        if (num == input[minIndex]) {
            return minIndex;
        }

        if (num == input[maxIndex]) {
            return maxIndex;
        }

        int mid = (maxIndex + minIndex) / 2;

        int midValue = input[mid];
        if (midValue == num) {
            return mid;
        }
        if (midValue > num) {
            maxIndex = mid;
            minIndex = minIndex + 1;
        }
        if (midValue < num) {
            minIndex = mid;
            maxIndex = maxIndex - 1;
        }

        return searchRecur(input, num, minIndex, maxIndex);
    }

    public static void main(String[] args) {

        int[] input = {4, 5, 1, 8, 9};
        int num = 8;
        int result = searchNonRecur(input, num);
        System.out.println("Binary Search Result " + result + " and is it correct " + (result == 3));

        int[] input1 = {4, 5, 1, 8, 9};
        int num1 = 18;
        int result1 = searchNonRecur(input1, num1);
        System.out.println("Binary Search Result " + result1 + " and is it correct " + (result1 == -1));

        int[] input2 = {4, 5, 1, 8, 9};
        int num2 = 18;
        int result2 = searchRecur(input2, num2, 0, input2.length - 1);
        System.out.println("Binary Search Result " + result + " and is it correct " + (result2 == -1));

        int[] input3 = {4, 5, 1, 8, 9};
        int num3 = 8;
        int result3 = searchRecur(input3, num3, 0, input3.length - 1);
        System.out.println("Binary Search Result " + result + " and is it correct " + (result3 == 3));


    }
}
