package org.nava.year21.june;

public class OneAwayStringEdit {
    /**
     * find smaller one, and compare the larger one with 1 difference of characters
     *
     * @param str1
     * @param str2
     * @return
     */

    static boolean oneAway(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 == len2) {
            return oneEditReplace(str1, str2);
        } else if (len1 + 1 == len2) {
            return oneEditInsert(str1, str2);
        } else if (len1 - 1 == len2) {
            return oneEditInsert(str2, str1);
        }
        return false;
    }

    static boolean oneEditReplace(String str1, String str2) {
        boolean diffExists = false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (diffExists) {
                    return false;
                }
                diffExists = true;
            }

        }
        return false;
    }

    static boolean oneEditInsert(String str1, String str2) {

        int index1 = 0;
        int index2 = 0;
        while (index1 < str1.length() && index2 < str2.length()) {
            if (str1.charAt(index1) != str2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;

            } else {
                index1++;
                index2++;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        String input1 = "pale";
        String input2 = "ple";
        boolean result = oneAway(input1, input2);
        System.out.println("test1 result " + result);

        input1 = "apple";
        input2 = "aple";
        result = oneAway(input1, input2);
        System.out.println("test2 result " + result);

    }
}
