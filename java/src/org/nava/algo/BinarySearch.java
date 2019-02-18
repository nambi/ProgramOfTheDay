package org.nava.algo;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] input = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(binarySearch(input, 61));
	}

	private static int binarySearch(int[] input, int num) {
		int found = 0;
		int low = 0;
		int high = input.length - 1;

		while (low <= high) {

			int mid = ((low + high) / 2);

			if (input[low] == num | input[high] == num | input[mid] == num) {
				return num;
			}

			if (num < input[mid]) {
				low = low + 1;
				high = mid;
			} else {
				low = mid;
				high = high - 1;
			}

		}

		return found;
	}

}
