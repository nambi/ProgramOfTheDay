
package org.nava.year21.mar;

import java.util.Set;
import java.util.HashSet;
import java.lang.Character;

public class RemoveStrDuplicate {


    public static void removeDupes(char[] input) {


        Set<Character> uniqChars = new HashSet<Character>();

        for (int i = 0; i < input.length; i++) {
            if(!uniqChars.add(input[i])){
                input[i]=' ';
            }
        }
        for (int i = 0; i < input.length; i++) {
            if(input[i]!= ' '){
                System.out.print(input[i]);
            }
        }

        System.out.println("");

    }

    public static String removeDupes(String input) {

        String output = "";
        char[] charArray = input.toCharArray();
        Set<Character> uniqChars = new HashSet<Character>();

        for (int i = 0; i < charArray.length; i++) {
            if(uniqChars.add(charArray[i])){
                output = output+charArray[i];
            }
        }

        removeDupes(charArray);
        return output;
    }


    public static boolean test1() {

        String input = "abbacedcdee";
        String output = removeDupes(input);
        boolean result = (output != null && output.equals("abced"));
        System.out.println("Test1 Result " + result);
        return result;

    }


    public static boolean doTestsPass() {

        return test1();
    }


    public static void main(String[] args) {

        if (doTestsPass()) {
            System.out.println("All Tests pass");
        } else {
            System.out.println("Tests failed");
        }
    }
}
