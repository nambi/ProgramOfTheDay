package org.nava.algo;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author nambi 2/16/2019 For 1M numbers, below is the metrics 
 * 		   Single Loop - 3  ms
 *         Recursion - 17ms
 *         With Sort : 2544 ms 
 *         These exactly mimic the algorithmic complexity
 */
public class SecondHighest {

	public static void main(String[] args) {

		int[] n = generateInput(100000);

		long t1 = new Date().getTime();
		int secondHighest = secondHighest(n);
		long t2 = new Date().getTime();
		System.out.println("secondHighest : " + secondHighest + " time taken : " + (t2 - t1));

		t1 = new Date().getTime();
		int secondHighRec = secondHighRec(n, 1, n[0], n[1]);
		t2 = new Date().getTime();
		System.out.println("secondHighRec : " + secondHighRec + " time taken : " + (t2 - t1));

		t1 = new Date().getTime();
		int secondHighWithSort = secondHighWithSort(n);
		t2 = new Date().getTime();
		System.out.println("secondHighWithSort : " + secondHighWithSort + " time taken : " + (t2 - t1));

	}

	static int[] generateInput(int len) {
		int[] input = new int[len];
		StringBuilder inputStr = new StringBuilder();
		Random r = new Random();
		for (int i = 0; i < len; i++) {
			int num = r.nextInt(100);
			inputStr.append(num);
			inputStr.append(",");
			input[i] = num;
		}

		System.out.println("input is " + inputStr);
		return input;
	}

	// complexity : O(n);
	static int secondHighest(int[] n) {

		int firstHigh = n[0];
		int secondHigh = n[1];

		for (int i = 1; i < n.length; i++) {

			if (n[i] > firstHigh) {
				secondHigh = firstHigh;
				firstHigh = n[i];
			} else if (n[i] > secondHigh) {
				secondHigh = n[i];
			}

		}

		return secondHigh;
	}

	// complexity : O(n); with additional memory for recursive stack
	// Recursion fails even with 10000 numbers with default stack size
	// Run with -Xss512m
	static int secondHighRec(int[] n, int i, int firstHigh, int secondHigh) {

		if (i == n.length) {
			return secondHigh;
		}

		if (n[i] > firstHigh) {
			secondHigh = firstHigh;
			firstHigh = n[i];
		} else if (n[i] > secondHigh) {
			secondHigh = n[i];
		}

		return secondHighRec(n, i + 1, firstHigh, secondHigh);
	}

	// using bubble sort to sort the array first and then just returning the 2nd
	// last item
	// complexity O(n^2) unless we use better sorting methods
	static int secondHighWithSort(int[] n) {
		int secondHigh = n[0];

		if (n.length == 1) {
			return secondHigh;
		}

		for (int i = 0; i < n.length; i++) {
			for (int j = i; j < n.length; j++) {
				if (n[i] > n[j]) {
					int temp = n[i];
					n[i] = n[j];
					n[j] = temp;
				}
			}
		}

		return n[n.length - 2];
	}

}
