package org.nava.year21.july;

/**
 * [flower,flow,flight] --> fl
 * [dog,racer,car] --> ""
 */

public class LongestCommonPrefix {


    static String longestPrefix(String[] input) {

        /**
         * loop through all string, keep adding and break
         */
        int len = 0;
        for (String s : input) {
            if (len == 0) {
                len = s.length();
            } else {
                if (len > s.length()) {
                    len = s.length();
                }
            }
        }
        String output = "";

        int i = 0;
        while (i < len) {
            boolean matches = true;
            char prevChar = input[0].charAt(i); //f
            for (int j = 1; j < input.length; j++) {
                char c = input[j].charAt(i);
                if (prevChar != c) {
                    matches = false;
                    break;
                }
            }
            if(matches) {
                output = output + prevChar;
                i++;
            }else{
                break;
            }

        }
        return output;
    }


    static boolean test1() {
        String[] input = {"flow", "flower", "flight"};
        String output = longestPrefix(input);
        System.out.println("Output "+output);
        boolean result = (output != null && output.equalsIgnoreCase("fl"));
        System.out.println("test1 result " + result);
        return result;
    }

    static boolean doAllTestsPass() {


        return test1();
    }


    public static void main(String[] args) {

        if (doAllTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests failed");
        }

    }

}
