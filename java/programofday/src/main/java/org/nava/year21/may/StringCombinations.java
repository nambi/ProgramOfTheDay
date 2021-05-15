package org.nava.year21.may;

/**
 * print unique combinations
 * hat --> h, a,t , ha, ht, ah, at, hat
 */
public class StringCombinations {


    static void combine(String input, StringBuilder output, int start) {

        for (int i = start; i < input.length(); i++) {
            output.append(input.charAt(i));
            System.out.println(output.toString());
            if (i < input.length()) {
                combine(input, output, i + 1);
            }
            output.setLength(output.length() - 1);

        }
    }

    static void combinations(String input) {
        //implement same as permutations, instead of used index array, use a used character array
        StringBuilder output = new StringBuilder();
        combine(input, output, 0);
    }

    public static void main(String[] args) {

        String input = "hat";
        combinations(input);

    }

}
