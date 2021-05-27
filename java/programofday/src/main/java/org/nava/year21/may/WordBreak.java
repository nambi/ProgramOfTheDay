package org.nava.year21.may;

import java.util.Arrays;
import java.util.List;

/**
 * Find out the word is made up of the dictionary words
 */
public class WordBreak {

    static boolean wordBreak(String s, List<String> wordDict) {

        if (s == null || wordDict == null || wordDict.size() < 1) {
            return false;
        }

        int endIndex = 1;
        int startIndex = 0;
        while (endIndex <= s.length()) {
            String sub = s.substring(startIndex, endIndex);
            System.out.println("sub "+sub);
            if (wordDict.contains(sub)) {
                startIndex = endIndex;
                System.out.println("sub "+sub+" is in the dict");
            }
            endIndex++;
        }
        return (startIndex == s.length());
    }

    static boolean test3() {
        String s = "applepenapple";
        String[] wordDict = {"apple","pen"};
        boolean output = wordBreak(s, Arrays.asList(wordDict));
        boolean result = (output == true);
        System.out.println("Test3 result " + result);
        return result;
    }

    static boolean test2() {
        String s = "catsandog";
        String[] wordDict = {"cats","dog","sand","and","cat"};
        boolean output = wordBreak(s, Arrays.asList(wordDict));
        boolean result = (output == false);
        System.out.println("Test2 result " + result);
        return result;
    }

    static boolean test1() {

        String s = "leetcode";
        String[] wordDict = {"leet", "code"};
        boolean output = wordBreak(s, Arrays.asList(wordDict));
        boolean result = (output == true);
        System.out.println("Test1 result " + result);
        return result;
    }

    static boolean doAllTestsPass() {

        return test1() && test2() && test3();
    }

    public static void main(String[] args) {

        if (doAllTestsPass()) {
            System.out.println("All Tests pass");
        } else {
            System.out.println("Tests failed");
        }

    }

}
