package org.nava.year21.may;

import java.util.HashMap;
import java.util.Map;

public class RemoveACharacter {

    static String removeCharacterWithString(String input, char removeChar) {
        if (input == null) {
            return input;
        }
        char[] inArr = input.toCharArray();
        String output = "";
        if (input != null && input.length() > 0) {
            int newLen = 0; // need to loop 2 times to get the new length of output array
            for (int i = 0; i < inArr.length; i++) {
                char c = inArr[i];
                if (c != removeChar) {
                    output = output + c;
                }
            }
        }
        return output;
    }

    static String removeCharacterWithoutSbuf(String input, char removeChar) {
        if (input == null) {
            return input;
        }
        char[] inArr = input.toCharArray();
        char[] outArr = null;
        if (input != null && input.length() > 0) {
            int newLen = 0; // need to loop 2 times to get the new length of output array
            for (int i = 0; i < inArr.length; i++) {
                char c = inArr[i];
                if (c != removeChar) {
                    newLen++;
                }
            }
            outArr = new char[newLen];
            int newIndex = 0;
            for (int i = 0; i < inArr.length; i++) {
                char c = inArr[i];
                if (c != removeChar) {
                    outArr[newIndex] = c;
                    newIndex++;
                }
            }
        }
        return String.valueOf(outArr);
    }

    static String removeCharacter(String input, char removeChar) {
        if (input == null) {
            return input;
        }
        StringBuffer sbuf = new StringBuffer();
        if (input != null && input.length() > 0) {
            char[] inArr = input.toCharArray();
            for (char c : inArr) {
                if (c != removeChar) {
                    sbuf.append(c);
                }
                System.out.println("Building.." + sbuf.toString());
            }
        }
        return sbuf.toString();
    }

    static boolean test3() {
        String input = null;
        char c = 'a';
        String result = removeCharacterWithString(input, c);
        System.out.println("Test3 Result " + result);
        return (result == null);
    }

    static boolean test2() {
        String input = "total";
        char c = 'a';
        String result = removeCharacterWithoutSbuf(input, c);
        System.out.println("Test2 Result " + result);
        return (result != null && result.equals("totl"));
    }

    static boolean test1() {
        String input = "teeter";
        char c = 'e';
        String result = removeCharacterWithString(input, c);
        System.out.println("Test1 Result " + result);
        return (result != null && result.equals("ttr"));
    }

    static boolean test0() {
        String input = "t";
        char c = 't';
        String result = removeCharacter(input, c);
        System.out.println("Test0 Result " + result);
        return (result != null && result.equals("")); // result == null
    }


    static boolean doAllTestsPass() {
        return test0() && test1() && test2() && test3();
    }

    public static void main(String[] args) {
        if (doAllTestsPass()) {
            System.out.println("Tests pass");
        } else {
            System.out.println("Tests failed");
        }
    }
}
