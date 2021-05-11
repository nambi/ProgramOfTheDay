package org.nava.year21.may;

public class ReverseWords {
    static String reverseWords(String input) {
        if (input == null) {
            return input;
        }
        StringBuffer sbuf = new StringBuffer();
        if (input != null && input.length() > 0) {
            String[] inputArr = input.split(" ");
            char[] inArr = input.toCharArray();
            for (int i = inputArr.length - 1; i >= 0; i--) {
                String c = inputArr[i];
                sbuf.append(c);
                if (i != 0) {
                    sbuf.append(" ");
                }
                System.out.println("Building.." + sbuf.toString());
            }
        }
        return sbuf.toString();
    }


    static boolean test1() {
        String input = "Do not, try.";

        String result = reverseWords(input);
        System.out.println("Test1 Result " + result);
        return (result != null && result.equals("try. not, Do"));
    }

    static boolean test0() {
        String input = "tamil nadu";
        char c = 't';
        String result = reverseWords(input);
        System.out.println("Test0 Result " + result);
        return (result != null && result.equals("nadu tamil")); // result == null
    }


    static boolean doAllTestsPass() {
        return test0() && test1();
    }

    public static void main(String[] args) {
        if (doAllTestsPass()) {
            System.out.println("Tests pass");
        } else {
            System.out.println("Tests failed");
        }
    }
}
