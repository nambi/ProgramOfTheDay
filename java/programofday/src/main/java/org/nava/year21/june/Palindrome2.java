package org.nava.year21.june;

/**
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 */
public class Palindrome2 {


    static boolean isPalindromeAfterDelete(String s) {
        //Ammas
        /**
         * iterate and delete a string and reverse string to match it
         */
        StringBuilder sb = new StringBuilder(s);
        if (s.equalsIgnoreCase(sb.reverse().toString())) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            sb = new StringBuilder(s);
            sb.deleteCharAt(i);
            if (sb.toString().equalsIgnoreCase(sb.reverse().toString())) {
                return true;
            }
        }
        return false;
    }

    static boolean test1() {

        boolean output = isPalindromeAfterDelete("Ammas");
        boolean result = (output == true);
        System.out.println("test1 result " + result);
        return result;
    }

    static boolean test2() {

        boolean output = isPalindromeAfterDelete("abca");
        boolean result = (output == true);
        System.out.println("test2 result " + result);
        return result;
    }

    static boolean doAllTestsPass() {

        return test1() && test2();
    }

    public static void main(String[] args) {

        if (doAllTestsPass()) {
            System.out.println("Tests pass");
        } else {
            System.out.println("Tests failed");
        }

    }
}
