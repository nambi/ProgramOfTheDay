package org.nava.year21.june;

public class StringToInt {


    static int stringToInt(String input) {
        int output = 0;
        //TODO : Handle all edge conditions + Negative numbers (- sign)
        int i = 0;
        while (i < input.length()) {
            char c = input.charAt(i);
            int cInt = ((int) c - 48);
            output = output * 10 + cInt;
            i++;
        }

        return output;

    }

    public static void main(String[] args) {

        String input = "456";
        int output = stringToInt(input);
        System.out.println("Test1 pass " + (output == 456));

        input = "650";
        output = stringToInt(input);
        System.out.println("Test2 pass " + (output == 650));
    }
}
