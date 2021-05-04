package org.nava.year21.may;

import java.util.ArrayList;

/**
 * Print all balanced braces combinations for a given value 'n'.
 * <p>
 * Given 2 --> will result in [{},{}]
 * Given 1 -- > {}
 * Given 3 -- > [{},{},{3}]
 */
public class BalancedBraces {

    public static void main(String[] args) {
        if (doAllTestsPass()) {
            System.out.println("All Tests pass");
        } else {
            System.out.println("Tests failed");
        }
    }


    public static boolean doAllTestsPass() {

        return test1();
    }

    public static boolean test1() {
        int input = 2;
        ArrayList result = getBracesPairs(input);
        return (result != null && result.size() == 2);
    }

    /**
     * {{{}}}
     * @param n
     * @return
     */
    public static ArrayList<ArrayList<Character>> getBracesPairs(int n) {
        int left = 0;
        int right = 0;
        ArrayList<Character> output = new ArrayList<Character>();
        ArrayList<ArrayList<Character>> result = new ArrayList<ArrayList<Character>>();
        getBracesPairsRec(output, result, n, left, right);
        print(result);
        return result;
    }

    static void print(ArrayList<ArrayList<Character>> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i).toString());
        }
    }

    public static void getBracesPairsRec(ArrayList<Character> output, ArrayList<ArrayList<Character>> result, int n, int left, int right) {

        if (left >= n && right >= n) {
            result.add((ArrayList) output.clone());
        }

        if (left < n) {
            output.add('{');
            getBracesPairsRec(output, result, n, left + 1, right);
            output.remove((output.size() - 1));
        }

        if (right < left) {
            output.add('}');
            getBracesPairsRec(output, result, n, left, right + 1);
            output.remove((output.size() - 1));
        }
    }
}
