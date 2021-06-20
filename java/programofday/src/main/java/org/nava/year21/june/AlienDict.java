package org.nava.year21.june;

import java.util.HashMap;
import java.util.Map;

/**
 * Check in a word, each letter is in greater order than previous letter
 * <p>
 * word order defined in alphabet order randomly in alien language - worldabcefghijklmnpqstuvxyz
 */
public class AlienDict {

    static boolean isAlienSorted(String[] words) {
        /**
         * Get a map for the new alien order for each value
         *
         * loop through the words
         *
         * each letter should be greater value than of the previous letter
         */

        Map<Character, Integer> alienOrderMap = getSortMap();

        for (String word : words) {
            int prevOrder = 0;
            for (Character c : word.toCharArray()) {
                int currentOder = alienOrderMap.get(c);
                if (currentOder >= prevOrder) {
                    prevOrder = currentOder;
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    static Map<Character, Integer> getSortMap() {

        String alienOrder = "worldabcefghijklmnpqstuvxyz";

        Map<Character, Integer> alienOrderMap = new HashMap<Character, Integer>();
        int order = 0;
        for (Character c : alienOrder.toCharArray()) {
            alienOrderMap.put(c, order);
            order++;
        }
        return alienOrderMap;
    }

    static boolean test1() {

        String[] words = {"world"};
        boolean output = isAlienSorted(words);
        boolean result = (output == false);
        System.out.println("Test1 result " + result);
        return result;
    }

    static boolean doAllTestsPass() {

        return test1();
    }

    public static void main(String[] args) {

        if (doAllTestsPass()) {
            System.out.println("Tests pass");
        } else {
            System.out.println("Tests failed");
        }

    }
}
