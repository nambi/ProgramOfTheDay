package org.nava.year21.may;

/**
 * n! = n*(n-1)!
 * 0! = 1 //assumptions
 * 4! = 4x3x2x1 = 24
 */
public class FactorialRecursion {

    static int nonRecurFact(int n) {
        //factorial for 0!=1 and there are formula for negative and imaginary numbers.
        if (n <= 1) {  //base case
            return 1;
        }
        int result = 1;
        while (n > 1) {
            result = result * n;
            n--;
        }

        return result;
    }

    static int fact(int n) {
        //factorial for 0!=1 and there are formula for negative and imaginary numbers.
        if (n <= 1) {  //base case
            return 1;
        }
        return n * fact(n - 1); //recursive case
    }


    public static void main(String[] args) {
        int n = 4;
        int factor = nonRecurFact(n);
        System.out.println(n + " Factorial is " + factor);

        n = 0;
        factor = fact(n);
        System.out.println(n + " Factorial is " + factor);

        n = 1;
        factor = fact(n);
        System.out.println(n + " Factorial is " + factor);


    }

}
