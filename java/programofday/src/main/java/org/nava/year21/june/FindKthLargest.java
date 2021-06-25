package org.nava.year21.june;

import java.util.PriorityQueue;

public class FindKthLargest {

    // O(n log n)
    static int findLargest(int[] input, int k) {

        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
            new PriorityQueue<Integer>();

        // keep k largest elements in the heap
        for (int n : input) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // output
        return heap.poll();
    }

    static boolean test1() {

        int[] input = {3, 2, 1, 5, 6, 4}; // {1,2,3,4,5,6} == > 5
        int k = 3;

        int output = findLargest(input, k);
        boolean result = (output == 4);
        System.out.println("test1 result " + result);

        return result;

    }


    static boolean doAllTestsPass() {

        return test1();

    }

    public static void main(String[] args) {


        if (doAllTestsPass()) {
            System.out.println("Tests sucess");
        } else {

            System.out.println("Tests failed");
        }


    }
}

