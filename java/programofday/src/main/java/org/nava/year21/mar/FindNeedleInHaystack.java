package org.nava.year21.mar;

/**
 * Its basically finding the substring exists or not
 */
public class FindNeedleInHaystack {


    public static int findNeedle(String haystack, String needle) {

        if (!haystack.isEmpty()) {

            if (needle.isEmpty()) {
                return 0;
            }

            for (int i = 0; i < haystack.length(); i++) {

                if ((haystack.length() - i) < needle.length()) {
                    break;
                }

                for (int j = 0; j < needle.length(); j++) {

                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                    if (j == needle.length() - 1) {
                        return i;
                    }

                }
            }

        }

        return -1;
    }


    public static boolean test3() {

        String input = "HaystackHaystack";

        int output = findNeedle(input, "");

        boolean result = (output == 0);

        return result;
    }

    public static boolean test2() {

        String input = "HaystackHaystack";

        int output = findNeedle(input, "needle");

        boolean result = (output == -1);

        return result;
    }

    public static boolean test1() {

        String input = "HaystackneedleHaystack";

        int output = findNeedle(input, "needle");

        boolean result = (output == 8);

        return result;
    }

    public static boolean doTestsPass() {

        return test1() && test2() && test3();
    }

    public static void main(String[] args) {

        if (doTestsPass()) {
            System.out.println("All Tests pass");
        } else {
            System.out.println("Tests failed");
        }

    }
}
