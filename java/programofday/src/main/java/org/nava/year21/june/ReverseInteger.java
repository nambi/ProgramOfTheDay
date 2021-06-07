package org.nava.year21.june;

public class ReverseInteger {


    static int reverse(int input) {
        long output = 0;

        while (input > 0) {

            output = output * 10 + input % 10;
            input = input / 10;
        }
        if (output > Integer.MAX_VALUE || output < Integer.MIN_VALUE) {
            output = 0;
        }

        return (int) output;
    }

    public static void main(String[] args) {

        int input = 456;
        int output = reverse(input);
        System.out.println("Test1 pass " + (output == 654));

        input = 650;
        output = reverse(input);
        System.out.println("Test2 pass " + (output == 56));

    }
}
