package org.nava.year21.may;

public class StringPermuations {

    public static void main(String[] args) {

        System.out.println(isPermutatedString("abc", "bca"));
        System.out.println(isPermutatedString("abdac", "aaaaaaaaaaaaa"));
        System.out.println(isPermutatedString("abdac", "sa"));

    }

    private static boolean isPermutatedString(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        //if ASCII, it will be 128, for extended ascii it will be 256
        boolean[] charSet = new boolean[128];
        for (int i = 0; i < arr1.length; i++) {
            charSet[arr1[i]] = true;
        }

        for (int i = 0; i < arr2.length; i++) {
            if (!charSet[arr2[i]]) {
                return false;
            }
        }

        return true;
    }
}
