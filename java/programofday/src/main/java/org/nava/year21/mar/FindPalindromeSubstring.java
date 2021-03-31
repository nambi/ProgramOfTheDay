package org.nava.year21.mar;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a string, find all substrings that are palindromes.
 */
public class FindPalindromeSubstring {

    public static int palindromeCount(String input) {
        return palindromeSubstrings(input).size();
    }

    public static List<String> palindromeSubstrings(String input) {

        if (input == null || input.length() < 2) {
            return null;
        }

        List<String> palindromes = new ArrayList<>();

        /**
         * char[]
         * loop through.
         */

        char[] inputArr = input.toCharArray();

        for (int matchIndex = 0; matchIndex < inputArr.length; matchIndex++) {
            for (int i = matchIndex; i < inputArr.length; i++) {
                String sub = input.substring(matchIndex, i);
                if (!sub.isEmpty() && sub.length() > 1 && foundMatch(matchIndex, inputArr, sub)) {
                    palindromes.add(sub);
                    break;
                }
            }
        }
        return palindromes;
    }

    public static boolean foundMatch(int startIndex, char[] inputArr, String sub) {

        char[] subArr = sub.toCharArray();
        for (int i = startIndex, j = subArr.length - 1; j >= 0 && i < (startIndex + subArr.length); i++, j--) {
            if (subArr[j] == inputArr[i]) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public static boolean test1() {

        String input = "Hiammaneeva";
        List<String> output = palindromeSubstrings(input);
        boolean result = (output != null && output.get(0).equalsIgnoreCase("amma"));
        System.out.println("Test1 result " + result);
        return result;

    }

    public static boolean doTestsPass() {

        return test1();
    }

    public static void main(String[] args) {

        if (doTestsPass()) {
            System.out.println("All Tests pass");
        } else {
            System.out.println("Tests failed");
        }

    }

}
