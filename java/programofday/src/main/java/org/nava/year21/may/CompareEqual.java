package org.nava.year21.may;

public class CompareEqual {

    /**
     * How to check two numbers are equal or not without using = operator
     * @param args
     */
    public static void main(String[] args) {
        int a = 8;
        int b = 1;
        int c = (a ^ b);
        if (c == 0)
            System.out.println("Equal " + c);
        else
            System.out.println("Not Equal " + c);

        System.out.println("~a = " + ~a);

    }
}
