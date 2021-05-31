package org.nava.year21.may;

/**
 * given a string, find out if palindrome can be formed. It need not be in dictionary
 * <p>
 * malayalam -->
 */
public class PalindromePossibility {


    static boolean palindromeExists(String input) {

        int[] charCount = new int[128];

        int len = input.length();
        for (int i = 0; i < len; i++) {
            charCount[input.charAt(i)]++;
        }

        //if input len is odd, we need 1 character occurrence to be 1, other characters should be divisible by 2;
        int k = 0;
        int oddCount = 0;
        while (k < 128) {
            int reminder = charCount[k] % 2;
            if (reminder > 0) {
                oddCount++;
            }
            k++;
        }
        if (len % 2 == 1 && oddCount == 1) {
            return true;
        } else if (len % 2 == 0 && oddCount == 0) {
            return true;
        }
        return false;
    }

    static boolean test3() {
        //tactcoa == > atcocta
        boolean output = palindromeExists("tactcoa");
        boolean result = (output == true);
        System.out.println("test3 result : " + result);
        return result;
    }

    static boolean test2() {

        boolean output = palindromeExists("nambi");
        boolean result = (output == false);
        System.out.println("test2 result : " + result);
        return result;
    }

    static boolean test1() {

        boolean output = palindromeExists("malayalam");
        boolean result = (output == true);
        System.out.println("test1 result : " + result);
        return result;
    }

    public static void main(String[] args) {

        test1();
        test2();
        test3();
    }

}
