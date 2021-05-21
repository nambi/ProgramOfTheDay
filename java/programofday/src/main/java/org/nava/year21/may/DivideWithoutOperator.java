package org.nava.year21.may;

/**
 * divide the number 6/2 without using division/multiplication/mod operator.
 * Truncate the decimal part on the result
 * 10/3 => 3.333 -> 3
 * 7/-3 => -2.333 -> -2
 */
public class DivideWithoutOperator {


    static int divide(int dividend, int divisor) {

        int result = 0;
        boolean isNegativeNumber = isNegativeNumber(dividend, divisor);
        //convert to absolute number
        dividend = dividend < 0 ? -dividend : dividend;
        divisor = divisor < 0 ? -divisor : divisor;

        int loop = 0;
        System.out.println("Current State : Dividend " + dividend + " divisor " + divisor + " loop " + loop);

        while (dividend > divisor) {
            loop++;
            dividend = dividend - divisor;
            System.out.println("Current State : Dividend " + dividend + " divisor " + divisor + " loop " + loop);
        }
        result = loop;

        return isNegativeNumber ? -result : result;

    }

    static boolean isNegativeNumber(int dividend, int divisor) {
        boolean isNegativeNumber = dividend < 0 && divisor < 0 ? false : dividend > 0 && divisor > 0 ? false : true;
        return isNegativeNumber;
    }

    static boolean test2() {
        boolean result = false;
        int dividend = -10;
        int divisor = 3;
        int output = divide(dividend, divisor);
        result = (output == -3);
        System.out.println("Test2 result : " + result);
        return result;
    }

    static boolean test1() {
        boolean result = false;
        int dividend = -1;
        int divisor = 1;
        result = isNegativeNumber(dividend, divisor);
        result = (result == true);
        System.out.println("Test1 result : " + result);
        return result;
    }

    static boolean doAllTestsPass() {

        return test1() && test2();
    }


    //division is a continous substraction
    public static void main(String[] args) {

        if (doAllTestsPass()) {
            System.out.println("All pass");
        } else {
            System.out.println("Fail");
        }

    }
}
