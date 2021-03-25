package org.nava.year21.mar;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class DocumentMerge {

    /**
     * input is string of
     * ID, Name, start, End
     * 15, A, 6,7
     * 18, B, 8,9
     * These will come as jumbled and we need to sort it out
     *
     * @param input
     */
    public static ArrayList<String> documentMerge(ArrayList<String> input) {

        TreeMap<String, String> sortedDocs = new TreeMap<>();

        for (String str : input) {
            String key = str.substring(0, str.indexOf(","));
            sortedDocs.put(key, str);
        }
        ArrayList<String> output = new ArrayList<>();
        output.addAll(sortedDocs.values());
        return output;
    }

    public static boolean test1() {
        ArrayList<String> input = new ArrayList<>();
        input.add("18,A,8,10");
        input.add("15,B,5,7");
        ArrayList<String> output = documentMerge(input);
        boolean result = (output != null && output.size() == 2 && output.get(0).startsWith("15"));
        System.out.println("Test1 result " + result);
        return result;
    }

    public static boolean doTestsPass() {

        return test1();
    }

    public static void main(String[] args) {

        if (doTestsPass()) {
            System.out.println("Tests Pass");
        } else {
            System.out.println("Tests failed");
        }

    }
}
