package org.nava.year21.mar;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a dictionary of words and an input string tell whether the input string can be completely segmented into dictionary words.
 */
public class WordBreakProblem {

    public static boolean areWordsInDictionary(String input, List<String> dictionary) {

        //every substring, check in dictionary
        //new substring is after the word match
        //if it breaks; return false;

        int matchIndex = 0;
        int len = input.length();
        String sub = "";
        for (int i = 0; i < len; i++) {
            sub = input.substring(matchIndex, i);
            if (dictionary.contains(sub)) {
                matchIndex = i;
            }
        }
        sub = input.substring(matchIndex, len);
        if (dictionary.contains(sub)) {
            matchIndex = len;
        }
        return (matchIndex == len);
    }


    public static boolean test1() {

        List<String> dictionary = new ArrayList<String>();
        dictionary.add("apple");
        dictionary.add("pie");
        dictionary.add("pear");
        dictionary.add("banana");

        String input = "applepie";
        boolean result = areWordsInDictionary(input, dictionary);
        System.out.println("Test1 result " + result);
        return result;
    }

    public static boolean doAllTestsPass() {
        return test1();
    }


    public static void main(String[] args) {
        if (doAllTestsPass()) {
            System.out.println("All Tests pass");
        } else {
            System.out.println("Tests failed");
        }

    }
}
