package org.nava.year21.mar;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of n elements, find their kth permutation.
 * <p>
 * for n=2
 * the permutations are
 * 1,2,
 * 2,1
 * <p>
 * Here 1st permutation is 1,2 and 2nd permutation is 2,1
 */
public class FindKthPermutation {

    static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    static void findKthPermutation(List<Character> v, int k, StringBuilder result) {

        if (v.isEmpty()) {
            return;
        }

        int n = v.size();
        // count is number of permutations starting with first digit
        int count = factorial(n - 1);
        int selected = (k - 1) / count;

        result.append(v.get(selected));
        v.remove(selected);

        k = k - (count * selected);
        findKthPermutation(v, k, result);
    }

    static String getPermutation(int n, int k) {
        List<Character> v = new ArrayList<Character>();
        char c = '1';
        for (int i = 1; i <= n; ++i) {
            v.add(c);
            c++;
        }
        StringBuilder result = new StringBuilder();
        findKthPermutation(v, k, result);
        return result.toString();
    }

    public static boolean test1() {
        int n = 4;
        int k = 8;
        String output = getPermutation(n, k);
        boolean result = (output.equals("2143"));
        System.out.println("Test1 result " + result);
        return result;
    }

    public static boolean doAllTestsPass() {
        return test1();
    }

    public static void main(String[] args) {

        if (doAllTestsPass()) {
            System.out.println("Tests pass");
        } else {
            System.out.println("Tests failed");
        }

    }
}
