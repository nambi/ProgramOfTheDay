package org.nava.year21.may;

public class UniqString {

    public static void main(String[] args) {

        System.out.println(isUnique2("abc"));
        System.out.println(isUnique2("abdac"));

    }
        //Brute force  O (n^2) or O (n log n)
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
    //Map O (n)
    private static boolean isUnique2(String input) {
        char[] inputArr = input.toCharArray();
        //if ASCII, it will be 128, for extended ascii it will be 256
        boolean[] charSet = new boolean[128];
        for (int i = 0; i < inputArr.length; i++) {
            if (charSet[inputArr[i]]) {
                return false;
            }
            charSet[inputArr[i]] = true;
        }
        return true;
    }
}
