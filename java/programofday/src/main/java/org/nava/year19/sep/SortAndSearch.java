package org.nava.year19.sep;

public class SortAndSearch {

	public static void main(String[] args) {

		int[] input = { 8, 1, 0, 0, 4, 2, 7 };

		System.out.print("Before Sort : ");
		printState(input);

		int[] output = sort(input);

		System.out.print("After Sort : ");
		printState(output);

		search(output, -1);
		search(output, 17);
		for (int k : output) {
			search(output, k);
		}

	}

	static int[] sort(int[] input) {

		for (int i = 0; i < input.length; i++) {

			for (int j = i + 1; j < input.length; j++) {

				if (input[i] > input[j]) {
					int temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}
			}
		}

		return input;
	}

	static void printState(int[] input) {

		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i]);
			if (i != input.length - 1) {
				System.out.print(",");
			}
		}

		System.out.println();
	}

	static boolean search(int[] input, int itemToFind) {
		int startIndex = 0;
		int endIndex = input.length - 1;

		if (input.length < 1) {
			System.out.println("Not valid array");
			return false;
		}
		if (input.length == 1 && (input[0] == itemToFind)) {
			System.out.println("Item found for " + itemToFind);
			return true;
		}

		if (itemToFind < input[startIndex]) {
			System.out.println("Item Not found " + itemToFind);
			return false;
		}

		if (itemToFind > input[endIndex]) {
			System.out.println("Item Not found " + itemToFind);
			return false;
		}

		return _searchInternal(input, itemToFind, startIndex, endIndex);

	}

	static boolean _searchInternal(int[] input, int itemToFind, int startIndex, int endIndex) {

		int mid = (endIndex - startIndex) / 2;
		int midVal = input[startIndex + mid];

		if (input[startIndex] == itemToFind || input[endIndex] == itemToFind || midVal == itemToFind) {
			System.out.println("Item found for " + itemToFind);
			return true;
		}

		if (itemToFind < midVal) {
			return _searchInternal(input, itemToFind, startIndex, mid);
		} else {
			return _searchInternal(input, itemToFind, mid + 1, endIndex);
		}
	}

	static void printInput(int startIndex, int endIndex) {

		System.out.println("startIndex : " + startIndex + ", endIndex :" + endIndex);
	}

}
