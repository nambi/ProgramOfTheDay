package org.nava.year21.may;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 */
public class AddBinary {

    public String addBinaryUsingLibrary(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }

    static String convertToBinary(int a) {
        StringBuilder sbuf = new StringBuilder();
        if (a < 2) {
            sbuf.append(a);
        }
        //keep dividing by 2
        int divisor = a;
        int reminder = a;

        while (a >= 2) {
            reminder = a % 2;
            a = a / 2;
            if (reminder == 0) {
                sbuf.append("0");
            } else {
                sbuf.append("1");
            }
        }
        sbuf.append(a);
        String r = sbuf.toString();

        char[] reveseArr = r.toCharArray();
        sbuf.setLength(0);
        for (int i = reveseArr.length - 1; i >= 0; i--) {
            sbuf.append(reveseArr[i]);
        }

        return sbuf.toString();
    }

    static int power2(int times) {
        int result = 1;
        while (times > 0) {
            result = result * 2;
            times--;
        }
        return result;
    }

    static int convertBinaryToInt(String a) {

        char[] aChars = a.toCharArray();

        int result = 0;
        for (int i = aChars.length - 1; i >= 0; i--) {
            if (aChars[i] == '1') {
                result += power2(i);
            }
            System.out.println("Result " + result);
        }
        return result;

    }

    static String addBinary(String a, String b) {

        int aInt = convertBinaryToInt(a);
        int bInt = convertBinaryToInt(b);

        int sum = aInt + bInt;

        System.out.println("Sum " + sum);

        String sumBinary = convertToBinary(sum);
        System.out.println("sumBinary " + sumBinary);
        return sumBinary;
    }

    static boolean test1() {
        String a = "11";
        String b = "1";
        String sum = addBinary(a, b);
        boolean result = (sum.equals("100") ? true : false);
        System.out.println("test1 result " + result);
        return result;
    }

    static boolean doAllTestsPass() {

        return test1();
    }

    public static void main(String[] args) {
        if (doAllTestsPass()) {
            System.out.println("All good");
        }


    }
}
