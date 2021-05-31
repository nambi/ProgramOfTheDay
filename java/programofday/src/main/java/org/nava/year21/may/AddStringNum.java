package org.nava.year21.may;

public class AddStringNum {

    static String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();

        int carry = 0;
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        while (p1 >= 0 || p2 >= 0) {
            int x1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int x2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            int value = (x1 + x2 + carry) % 10;
            carry = (x1 + x2 + carry) / 10;
            res.append(value);
            p1--;
            p2--;
        }

        if (carry != 0)
            res.append(carry);

        return res.reverse().toString();
    }

    static String add(String num1, String num2) {
        char[] numArr1 = num1.toCharArray();
        char[] numArr2 = num2.toCharArray();
        int i = numArr1.length - 1;
        int j = numArr2.length - 1;
        char[] sumArr = new char[numArr1.length + numArr2.length];
        int carry = 0;
        int sumIndex = sumArr.length - 1;

        while (i >= 0 && j >= 0) {
            int sum = carry + (int) numArr1[i] - 48 + (int) numArr2[j] - 48;
            if (sum > 10) {
                sum = sum % 10;
                carry = sum / 10;
            }
            sumArr[sumIndex] = (char) (sum + 48);
            sumIndex--;
            i--;
            j--;
        }

        while (i >= 0) {
            int sum = carry + (int) numArr1[i] - 48;
            if (sum > 10) {
                sum = sum % 10;
                carry = sum / 10;
            }
            sumArr[sumIndex] = (char) (sum + 48);
            sumIndex--;
            i--;
        }

        while (j >= 0) {
            int sum = carry + (int) numArr2[j] - 48;
            if (sum > 10) {
                sum = sum % 10;
                carry = sum / 10;
            }
            sumArr[sumIndex] = (char) (sum + 48);
            sumIndex--;
            j--;
        }


        if (carry > 10) {
            sumArr[sumIndex] = (char) ((carry % 10) + 48);
            sumIndex--;
            carry = carry / 10;
        }
        sumArr[sumIndex] = (char) (carry + 48);

        while (sumIndex >= 0) {
            sumArr[sumIndex] = '0';
            sumIndex--;
        }


        return String.valueOf(sumArr);
    }

    public static void main(String[] args) {

        String sum = add("11", "123");
        System.out.println("sum " + sum);

        sum = addStrings("1000", "1000");
        System.out.println("sum " + sum);
    }
}
