package org.nava.year21.mar;

public class ReverseWords {

    // Null terminating strings are not used in java
    public static void strRev(char[] str, int start, int end) {
        if (str == null || str.length < 2) {
            return;
        }

        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }

    public static void reverseWords(char[] sentence) {
        // Here sentence is a null-terminated string ending with char '\0'.
        if (sentence == null || sentence.length == 0) {
            return;
        }

        // To reverse all words in the string, we will first reverse
        // the string. Now all the words are in the desired location, but
        // in reverse order: "Hello World" -> "dlroW olleH".
        int len = sentence.length;
        strRev(sentence, 0, len - 2);

        // Now, let's iterate the sentence and reverse each word in place.
        // "dlroW olleH" -> "World Hello"
        int start = 0;
        int end;

        while (true) {
            // find the  start index of a word while skipping spaces.
            while (sentence[start] == ' ') {
                ++start;
            }

            if (start >= sentence.length - 1) {
                break;
            }

            // find the end index of the word.
            end = start + 1;
            while (end < sentence.length - 1 && sentence[end] != ' ') {
                ++end;
            }

            // let's reverse the word in-place.
            strRev(sentence, start, end - 1);
            start = end;
        }
    }

    public static String reverse(String input) {

        String output = "";
        char[] cArray = input.toCharArray();
        int endIndex = cArray.length;

        for (int i = cArray.length - 1; i > -1; i--) {
            if (i == 0) {
                output = output + input.substring(i, endIndex);
            } else if (cArray[i] == ' ') {
                output = output + input.substring(i + 1, endIndex) + ' ';
                endIndex = i;
            }
        }
        return output;
    }

    public static boolean test2() {

        String inputStr = "The quick brown fox jumped over the lazy dog.";
        char[] input = inputStr.toCharArray();
//        reverseWords(input);
//        String output = String.valueOf(input);
//
        String output = reverse(inputStr);

        boolean result = (output != null && output.startsWith("dog"));
        return result;
    }

    public static boolean test1() {

        String input = "Hello World";
        String output = reverse(input);
        boolean result = (output != null && output.startsWith("World"));
        return result;
    }

    public static boolean doAllTestsPass() {
        return test1() && test2();
    }

    public static void main(String[] args) {

        if (doAllTestsPass()) {
            System.out.println("Tests passed");
        } else {
            System.out.println("Tests failed");
        }

    }

}
