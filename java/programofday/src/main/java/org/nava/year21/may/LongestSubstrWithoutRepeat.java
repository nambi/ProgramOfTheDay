package org.nava.year21.may;

public class LongestSubstrWithoutRepeat {

    static String longestSubstr(String input) {

        /**
         * charArray loop
         * longestSubstr match with next char contains, reset if starting again
         */

        char[] inputArr = input.toCharArray();
        String currStr = input.substring(0, 1);
        int currIndex = 0;
        String lonSubStr = currStr;
        for (int i = 1; i < inputArr.length; i++) {
            String currChar = String.valueOf(inputArr[i]);
            if (currStr.contains(currChar)) {
                currIndex = i;
                currStr = currChar;
            } else {
                currStr = input.substring(currIndex, i+1);
                lonSubStr = currStr;
            }
        }

        return lonSubStr;
    }

    static void test1() {

        String input = "bbbbb";
        String output = longestSubstr(input);
        if (output != null && output.equals("b")) {
            System.out.println("Test1 pass");
        } else {
            System.out.println("Test1 fail");
        }

    }

    static void test2() {

        String input = "pwwkep";
        String output = longestSubstr(input);
        if (output != null && output.equals("wkep")) {
            System.out.println("Test2 pass");
        } else {
            System.out.println("Test2 fail");
        }

    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
