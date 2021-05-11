package org.nava.year21.may;

import java.util.HashMap;
import java.util.Map;

/**
 * total -- > o
 * teeter -- > r
 */
public class FirstNonRepeatedCharacter {


    static char findFirstNonRepeated(String input) {

        if (input != null && input.length() > 0) {
            char[] inArr = input.toCharArray();
            if (inArr.length == 1) {
                return inArr[0];
            }
            Map<Character, Integer> countMap = new HashMap<Character, Integer>();
            for (char c : inArr) {
                int count = 0;
                if (countMap.containsKey(c)) {
                    count = countMap.get(c);
                }
                countMap.put(c, ++count);
                System.out.println(c + "-" + count);
            }
            for (char c : inArr) {
                System.out.println(c + "-" + countMap.get(c));
                //first character that has count 1 should be the non repeating character
                if (countMap.get(c) == 1) {
                    return c;
                }
            }
        }
        return 0;
    }

    static boolean test3() {
        String input = null;
        char c = findFirstNonRepeated(input);
        System.out.println("Test3 Result " + c);
        return (c == 0);
    }

    static boolean test2() {
        String input = "total";
        char c = findFirstNonRepeated(input);
        System.out.println("Test2 Result " + c);
        return (c == 'o');
    }

    static boolean test1() {
        String input = "teeter";
        char c = findFirstNonRepeated(input);
        System.out.println("Test1 Result " + c);
        return (c == 'r');
    }

    static boolean test0() {
        String input = "t";
        char c = findFirstNonRepeated(input);
        System.out.println("Test0 Result " + c);
        return (c == 't');
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
