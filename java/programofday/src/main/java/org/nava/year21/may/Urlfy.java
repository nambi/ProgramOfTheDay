package org.nava.year21.may;

public class Urlfy {

    public static void main(String[] args) {
        //abc sm   ===> returns abc%20sm
        //end of string has enough space for %20
        System.out.println(Urlfy("abc sm  "));
        System.out.println(Urlfy("a bd ac    "));

    }

    //Replace space with %20
    private static String Urlfy(String str1) {
        char[] strArr = str1.toCharArray();
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] == ' ') {
                System.arraycopy(strArr, i+1, strArr, i + 3, strArr.length - i - 3);
                strArr[i] = '%';
                strArr[i + 1] = '2';
                strArr[i + 2] = '0';
                i = i + 2;
            }
        }

        return new String(strArr);
    }
}
