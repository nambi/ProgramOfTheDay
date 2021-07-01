package org.nava.year21.july;

/**
 * [flower,flow,flight] --> fl
 * [dog,racer,car] --> ""
 */

public class LongestCommonPrefix {

    static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    static String longestPrefix(String[] input) {

        /**
         * loop through all string, keep adding and break
         */
        int len = 0;
        String firstWord = "";
        for (String s : input) {
            if (len == 0) {
                len = s.length();
                firstWord = s;
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

            char prevChar = firstWord.charAt(i); //f

            for (int j = 1; j < input.length; j++) {
                if(input[j]==null || input[j].length() == 0){
                    matches = false;
                    break;
                }
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
        String output = longestCommonPrefix(input);
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
