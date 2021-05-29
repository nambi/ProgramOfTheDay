package org.nava.year21.may;

public class UniqString {

    public static void main(String[] args) {

        System.out.println(isUnique("abc"));
        System.out.println(isUnique("abdac"));

    }

    private static boolean isUnique(String input) {
        char[] inputArr = input.toCharArray();

        for (int i = 0; i < inputArr.length; i++) {
            for (int j = i + 1; j < inputArr.length; j++) {
                if (inputArr[i] == inputArr[j]) {
                    return false;
                }

            }

        }
        return true;
    }
}
