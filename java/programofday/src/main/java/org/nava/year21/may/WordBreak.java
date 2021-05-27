package org.nava.year21.may;

import java.util.*;

/**
 * Find out the word is made up of the dictionary words
 */
public class WordBreak {

    static boolean wordBreakNew(String s, List<String> wordDict) {
        return wordBreakMemo(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    static boolean wordBreakMemo(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            String sub = s.substring(start, end);
            if (wordDict.contains(sub) && wordBreakMemo(s, wordDict, end, memo)) {
                System.out.println("sub " + sub + " is in the dict");
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }

    static boolean wordBreak(String s, List<String> wordDict) {

        if (s == null || wordDict == null || wordDict.size() < 1) {
            return false;
        }

        int endIndex = 1;
        int startIndex = 0;
        while (endIndex <= s.length()) {
            String sub = s.substring(startIndex, endIndex);
            System.out.println("sub " + sub);
            if (wordDict.contains(sub)) {
                startIndex = endIndex;
                System.out.println("sub " + sub + " is in the dict");
            }
            endIndex++;
        }
        return (startIndex == s.length());
    }

    static boolean test4() {
        String s = "aaaaaaa";
        String[] wordDict = {"aaaa", "aaa"};
        ArrayList<String> list = new ArrayList<String>();
        for (String w : wordDict) {
            list.add(w);
        }
        boolean output = wordBreakNew(s, list);
        boolean result = (output == true);
        System.out.println("Test4 result " + result);
        return result;
    }


    static boolean test3() {
        String s = "applepenapple";
        String[] wordDict = {"apple", "pen"};
        ArrayList<String> list = new ArrayList<String>();
        for (String w : wordDict) {
            list.add(w);
        }
        boolean output = wordBreak(s, list);
        boolean result = (output == true);
        System.out.println("Test3 result " + result);
        return result;
    }

    static boolean test2() {
        String s = "catsandog";
        String[] wordDict = {"cats", "dog", "sand", "and", "cat"};
        ArrayList<String> list = new ArrayList<String>();
        for (String w : wordDict) {
            list.add(w);
        }
        boolean output = wordBreak(s, list);
        boolean result = (output == false);
        System.out.println("Test2 result " + result);
        return result;
    }

    static boolean test1() {

        String s = "leetcode";
        String[] wordDict = {"leet", "code"};
        ArrayList<String> list = new ArrayList<String>();
        for (String w : wordDict) {
            list.add(w);
        }
        boolean output = wordBreak(s, list);
        boolean result = (output == true);
        System.out.println("Test1 result " + result);
        return result;
    }

    static boolean doAllTestsPass() {

        return test1() && test2() && test3() && test4();
    }

    public static void main(String[] args) {

        if (doAllTestsPass()) {
            System.out.println("All Tests pass");
        } else {
            System.out.println("Tests failed");
        }

    }

}
