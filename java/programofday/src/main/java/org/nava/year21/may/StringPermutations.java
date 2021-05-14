package org.nava.year21.may;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * returns all combinations of the string characters
 * hat --> tha, tah,ath,aht,hat,hta --> 3! -> 6
 */

public class StringPermutations {

    static void permute(String input, ArrayList<String> result, boolean[] used, StringBuilder output) {

        if (output.length() == input.length()) {
            result.add(output.toString());
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            if (used[i]) {
                continue;
            }
            output.append(input.charAt(i));
            used[i] = true;
            permute(input, result, used, output);
            used[i] = false;
            output.setLength(output.length() - 1); //resetting the builder
        }
    }

    static ArrayList<String> permutations(String input) {
        ArrayList<String> result = new ArrayList<>();
        boolean[] used = new boolean[input.length()];
        StringBuilder output = new StringBuilder();
        permute(input, result, used, output);
        return result;
    }


    public static void main(String[] args) {

        String input = "hat";
        ArrayList<String> output = permutations(input);
        for (String r : output) {
            System.out.println(" " + r);
        }

    }

}
