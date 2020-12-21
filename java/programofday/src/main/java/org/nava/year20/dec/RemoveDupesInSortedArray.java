package org.nava.year20.dec;

/*
 * Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4]
Explanation: Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively. 
It doesn't matter what values are set beyond the returned length.

 */
public class RemoveDupesInSortedArray {

	public static void main(String[] args) {
		int[] input = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

		// int[] input = {1,1,1,1,1,2};

		int newlen = removeDuplicates(input);
		System.out.println("The new len is " + newlen);
		print(input, newlen);
	}

	private static int removeDuplicates(int[] input) {

		int newlen = input.length;
		int endIndex = input.length;
		if (newlen < 1 || newlen > (3 * Math.pow(10, 4))) {
			throw new RuntimeException("Invalid input");
		}
		return dedupe(input, endIndex, newlen);

	}

	private static int dedupe(int[] input, int len, int newlen) {

		if (len == 1) {
			return newlen;
		}

		int i = len - 1;
		int currVal = input[i];
		int preVal = input[i - 1];

		if (currVal == preVal) {
			System.out.println("Removing index " + (i) + " value " + input[i]);
			for (int k = i; k < input.length - 1; k++) {
				input[k] = input[k + 1];
			}
			newlen--;
		}
		return dedupe(input, len - 1, newlen);

	}

	private static void print(int[] input, int newlen) {

		System.out.print("Array : ");

		for (int i = 0; i < newlen; i++) {

			System.out.print(input[i]);
		}
		System.out.println();
	}
}
