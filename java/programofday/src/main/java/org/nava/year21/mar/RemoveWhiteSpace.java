
package org.nava.year21.mar;

public class RemoveWhiteSpace {


    public static void removeWhiteSpace(char[] input) {

        String output = "";
        char[] inputArr = input;
        int spaceIndex = 0;
        int j = 0;
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] != ' ') {
                inputArr[j] = inputArr[i];
                j++;
            }else{
                spaceIndex++;
            }
        }
        output = String.valueOf(inputArr);
        output = output.substring(0, j);
        input = output.toCharArray();
    }

    public static String removeWhiteSpace(String input) {

        String output = "";
        char[] inputArr = input.toCharArray();
        char[] outputArr = new char[inputArr.length];
        int spaceIndex = 0;
        int j = 0;
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] == ' ') {
                spaceIndex++;
            } else {
                outputArr[j] = inputArr[i];
                j++;
            }
        }
        output = String.valueOf(outputArr);
        return output.substring(0, (inputArr.length - spaceIndex));
    }

    public static boolean test2() {

        String input = "We love Java";
        char[] inputArr = input.toCharArray();
        removeWhiteSpace(inputArr);
        boolean result = (inputArr != null && String.valueOf(inputArr).indexOf(" ") == -1);
        System.out.println("Test2 result " + result);
        return result;
    }

    public static boolean test1() {

        String input = "Hello World";
        input = "All greek to me.";
        String output = removeWhiteSpace(input);
        boolean result = (output != null && output.indexOf(" ") == -1);
        System.out.println("Test1 result " + result);
        return result;
    }

    public static boolean doTestsPass() {

        return test1() && test2();
    }


    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All Tests pass");
        } else {
            System.out.println("Tests failed");
        }


    }

}
