package org.nava.year21.may;

import java.util.ArrayList;

/**
 * 866-2665 --> TOOCOOL
 * print all combination of words for given 7 digit number base on telephone dial
 */
public class TelephonicWords {


    static char getCharKey(int telephoneKey, int place) {


        if (telephoneKey == 0) {
            System.out.println("No letters for this key " + telephoneKey);
            return '0';
        }

        if (telephoneKey == 1) {
            System.out.println("No letters for this key " + telephoneKey);
            return '1';
        }
        if (place < 1 || place > 3) {
            System.out.println("Invalid place " + place);
            return '1';
        }

        //map of map or 2D Array
        char[][] charkeyMap = {{'A', 'B', 'C'},
            {'D', 'E', 'F'},
            {'G', 'H', 'I'},
            {'J', 'K', 'L'},
            {'M', 'N', 'O'},
            {'P', 'R', 'S'},
            {'T', 'U', 'V'},
            {'W', 'X', 'Y'}};

        return charkeyMap[telephoneKey - 2][place - 1];
    }


    static void printWords(int[] phoneNum, char[] result, int index) {

        if (index == phoneNum.length) {
            System.out.println(new String(result));
            return;
        }

        for (int i = 1; i <= 3; i++) {
            result[index] = getCharKey(phoneNum[index], i);
            printWords(phoneNum, result, index + 1);
            if (phoneNum[index] == 0 || phoneNum[index] == 1) {
                return;
            }
        }
    }


    static boolean test3() {
        int[] phoneNum = {8, 6, 6, 2, 6, 6, 5};
        char[] result = new char[phoneNum.length];

        printWords(phoneNum, result, 0);
        return false;
    }

    static boolean test2() {
        char r = getCharKey(9, 3);
        boolean result = (r == 'Y');
        System.out.println("Test 2 " + result);
        return result;
    }

    static boolean test1() {
        char r = getCharKey(3, 2);
        boolean result = (r == 'E');
        System.out.println("Test 1 " + result);
        return result;
    }

    static boolean doAllTestsPass() {
        return test1() && test2() && test3();
    }

    public static void main(String[] args) {

        if (doAllTestsPass()) {
            System.out.println("All Tests passed");
        } else {
            System.out.println("Tests failed");
        }
    }
}
