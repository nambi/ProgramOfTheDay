package org.nava.year21.june;

public class DivideWithoutOperator {

    static int divide(int dividend, int divisor) {
        int answer = 0;
        int posdivisor = Math.abs(divisor);
        int posdividend = Math.abs(dividend);
        while (posdividend >= posdivisor) {
            posdividend = posdividend - posdivisor;
            answer++;
        }
        int val = Math.min(answer, Integer.MAX_VALUE);

        if ((divisor < 0 || dividend < 0) && !(dividend < 0 && divisor < 0)) {
            val = val - val - val;
        }
        return val;
    }

    public static void main(String[] args) {

        int dividend = -7;
        int divisor = -3;

        System.out.println("Answer " + divide(dividend, divisor));

    }

}
