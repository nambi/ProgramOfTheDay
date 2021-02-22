package org.nava.year21.feb;

import java.util.ArrayDeque;
import java.util.Calendar;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a large array of integers and a window of size
 * w, find the current maximum value in the window as the window slides through the entire array.
 */
class MaxSlidingWindow {
    public static ArrayDeque<Integer> findMaxSlidingWindow(int[] arr, int windowSize) {
        ArrayDeque<Integer> result = new ArrayDeque<>();

        int maxIndex;

        for (int i = 0; i <= arr.length - windowSize; i++) {
            int max = arr[i];
            int j = i + 1;
            maxIndex = i + windowSize;
            while (j < maxIndex) {
                int currentValue = arr[j];
                if (currentValue > max) {
                    max = currentValue;
                }
                j++;
            }
            result.add(max);
        }

        return result;
    }

    public static ArrayDeque<Integer> findMaxSlidingWindowUsingDeque(int[] arr, int windowSize) {
        ArrayDeque<Integer> result = new ArrayDeque<>();
        Deque<Integer> list = new LinkedList<>();

        if (arr.length > 0) {
            if (arr.length < windowSize) {
                return result;
            }
            for (int i = 0; i < windowSize; i++) {
                while (!list.isEmpty() && arr[i] >= arr[list.peekLast()]) {
                    list.removeLast();
                }
                list.addLast(i);
            }

            for (int i = windowSize; i < arr.length; ++i) {
                if(!list.isEmpty())
                result.add(arr[list.peek()]);

                while (!list.isEmpty() && list.peek() <= i - windowSize) {
                    list.removeFirst();
                }

                while (!list.isEmpty() && arr[i] >= arr[list.peekLast()]) {
                    list.removeLast();
                }

                list.addLast(i);
            }
            if(!list.isEmpty())
            result.add(arr[list.peek()]);

        }
        return result;
    }


    public static void main(String[] args) {

        int[] input = {1, 2, 3, 4, 3, 2, 1, 2, 5};
        long t = Calendar.getInstance().getTimeInMillis();
        ArrayDeque<Integer> result = findMaxSlidingWindow(input, 4);

        System.out.println("Result Using Native Method:" + result + " Time : " + (Calendar.getInstance().getTimeInMillis() - t));

        t = Calendar.getInstance().getTimeInMillis();
        result = findMaxSlidingWindowUsingDeque(input, 4);
        System.out.println("Result using Deque" + result + " Time : " + (Calendar.getInstance().getTimeInMillis() - t));
    }

}
