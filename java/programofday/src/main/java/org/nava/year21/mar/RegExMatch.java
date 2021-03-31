package org.nava.year21.mar;

/**
 * Given a text and a pattern, evaluate the pattern to see if it matches with the text by using regular expression matching.
 */

public class RegExMatch {


    static boolean regxMatchRec(String text, String pattern) {
        if (text.isEmpty() && pattern.isEmpty()) {
            return true;
        }

        if (!text.isEmpty() && pattern.isEmpty()) {
            return false;
        }

        if (pattern.length() > 1 && pattern.charAt(1) == '*') {

            String remainingPattern = pattern.substring(2);
            String remainingText = text;

            for (int i = 0; i < text.length() + 1; ++i) {
                if (regxMatchRec(remainingText, remainingPattern)) {
                    return true;
                }

                if (remainingText.isEmpty()) {
                    return false;
                }

                if (pattern.charAt(0) != '.' &&
                    remainingText.charAt(0) != pattern.charAt(0)) {
                    return false;
                }

                remainingText = remainingText.substring(1);
            }
        }

        if (text.isEmpty() || pattern.isEmpty()) {
            return false;
        }

        if (pattern.charAt(0) == '.' || pattern.charAt(0) == text.charAt(0)) {
            String remainingText = "";
            if (text.length() >= 2) {
                remainingText = text.substring(1);
            }

            String remainingPattern = "";
            if (pattern.length() >= 2) {
                remainingPattern = pattern.substring(1);
            }

            return regxMatchRec(remainingText, remainingPattern);
        }

        return false;
    }

    public static boolean regxMatch(String s, String p) {
        return regxMatchRec(s, p);
    }


    public static boolean test1() {

        String input = "fabbbc";
        String pattern = ".ab*c";
        boolean result = regxMatch(input, pattern);
        System.out.println("Test1 result " + result);
        return result;
    }

    public static boolean doTestsPass() {

        return test1();
    }

    public static void main(String[] args) {

        if (doTestsPass()) {
            System.out.println("Tests pass");
        } else {
            System.out.println("Tests failed");
        }

    }

}
