package org.nava.year21.mar;

/**
 * aabbbaa --> a2b3a2
 */

public class StringCompression {

    public static String compress(String input) {
        String compressedInput = "";

        if (input == null || input.length() < 2) {
            compressedInput = input;
        }

        char[] inputArr = input.toCharArray();
        char prev = inputArr[0];
        int count = 1;
        for (int i = 1; i < inputArr.length; i++) {
            if (prev == inputArr[i]) {
                count++;
            } else {
                if (count == 1) {
                    compressedInput = compressedInput + prev;
                } else {
                    compressedInput = compressedInput + prev + count;
                }
                prev = inputArr[i];
                count = 1;
            }
        }
        if (count == 1) {
            compressedInput = compressedInput + prev;
        } else {
            compressedInput = compressedInput + prev + count;
        }
        return compressedInput;
    }


    public static void main(String[] args) {

        String input = "aabbbaa";
        //input = "a2b3a2";
        String output = compress(input);
        System.out.println("Input :" + input + " Compressed " + output);

    }

}
