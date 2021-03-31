package org.nava.year21.mar;


public class RegExMatch {


    public static boolean regExMatch(String input, String pattern) {

        return false;
    }


    public static boolean test1() {

        String input = "";
        String pattern = "";
        boolean result = regExMatch(input, pattern);
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
