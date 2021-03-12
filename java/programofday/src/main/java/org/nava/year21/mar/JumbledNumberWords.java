package org.nava.year21.mar;


import java.util.*;

/**
 * Convert the jumbled words into ascending order of numbers
 * example
 * xsi --> six -- > 6
 * uneorfo -> one four -> 14
 */
public class JumbledNumberWords {

    public static final String[] NUMBERS = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static ArrayList convertToNumbers(String word) {
        ArrayList<Integer> output = new ArrayList<>();
        char[] wordArr = word.toCharArray();
        int numPosition = 0;

        Map<String, String> numberWordMap = new HashMap<String, String>();
        Map<Integer, String> integerToKeyMap = new HashMap<Integer, String>();
        int increment = 0;
        for (int i = 0; i < 10; i++) {
            numberWordMap.put(NUMBERS[i], "");
            integerToKeyMap.put(i, NUMBERS[i]);
            increment++;
        }

        ArrayList<Integer> countedIndex = new ArrayList<>();

        for (int i = 0; i < wordArr.length; i++) {
            char letter = wordArr[i];
            for (String key : numberWordMap.keySet()) {
                if (key.indexOf(letter) != -1) {
                    String count = numberWordMap.get(key);
                    numberWordMap.put(key, count + letter);
                }
            }
        }
        int number = 0;
        while (number < 10) {
            String key = integerToKeyMap.get(number);
            boolean exists = true;
            String matches = numberWordMap.get(key);
            System.out.println("key : " + key + " occurence: " + matches);
            char[] arr = matches.toCharArray();
            Map<Character, Integer> charMap = new HashMap<>();

            //matches, split each charcter, find occurence of each character, min match is the number
            for (char c : arr) {
                int count = 0;
                if (key.indexOf(c) > -1) {
                    if (charMap.containsKey(c)) {
                        count = charMap.get(c);
                    }
                    charMap.put(c, count + 1);
                } else {

                    break;
                }
            }
            if (charMap.size() == key.length()) {
                Set<Integer> set = new HashSet<>();
                set.addAll(charMap.values());
                if (set.iterator().hasNext()) {
                    int times = set.iterator().next();
                    for (int i = 0; i < times; i++) {
                        output.add(number);
                    }
                }
            }
            number++;
        }

        return output;
    }

    public static void main(String[] args) {

        String input = "xsi"; //output 6
        input = "uneorfo"; //output 14
        //input = "uneorfootw"; //output 124
       input = "uneorfootwneo"; //output 1124
        //input = "xsi";
        ArrayList<Integer> output = convertToNumbers(input);

        System.out.println("Converted Numbers for input " + input + " is " + Arrays.asList(output));
    }
}
