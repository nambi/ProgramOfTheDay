

package org.nava.year21.may;

import java.util.ArrayList;
import java.lang.Integer;

public class FindSumSubSet {

    public static void main(String[] args) {
        if (doAllTestsPass()) {
            System.out.println("All Tests pass");
        } else {
            System.out.println("Tests failed");
        }
    }

    static boolean doAllTestsPass() {
        return test1();
    }

    static boolean test1() {
        int[] input = {1, 3, 5, 21, 19, 7, 2};
        int sum = 10;
        ArrayList<ArrayList<Integer>> result = findSubSetSum(input, sum);
        //Expected - [{3,7}, {1,7,2}, {3,5,2}]
        return (result != null && result.size() == 3);
    }

    static ArrayList<ArrayList<Integer>> findSubSetSum(int[] input, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        findSumRec(result, input, 0, sum);
        return result;
    }

    static void findSumRec(ArrayList<ArrayList<Integer>> result, int[] input, int index, int sum) {
        if (index == (input.length - 2)) {
            return;
        }
        int currentSum = 0;
        ArrayList<Integer> currentList = new ArrayList<Integer>();

        for (int i = index; i < input.length; i++) {

            currentList.add(input[i]);
            currentSum += input[i];
            if (currentSum == sum) {
                result.add(currentList);
                break;
            }

            if (currentSum > sum) {
                currentSum = input[index];
                currentList  = new ArrayList<Integer>();
                currentList.add(input[index]);
            }
        }
        findSumRec(result, input, ++index, sum);
    }
}



