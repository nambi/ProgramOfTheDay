package org.nava.year20.dec;

/**
 * Write a function that reverses a string. The input string is given as an
 * array of characters char[].
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * You may assume all the characters consist of printable ascii characters.
 * 
 * Input: ["h","e","l","l","o"] Output: ["o","l","l","e","h"]
 * 
 * @author nambi
 *
 */
public class ReverseString {

	public static void main(String[] args) {

		// char[] input = { 'h', 'e', 'l', 'l', 'o' };
		char[] input = { 'H', 'a', 'n', 'n', 'a', 'h' };
		ReverseString rsInstance = new ReverseString();
		rsInstance.print(input);

		rsInstance.reverseString(input);

		System.out.println();
		rsInstance.print(input);

	}

	public void reverseString(char[] s) {

		int maxLen = s.length / 2;

		for (int i = 0; i < maxLen; i++) {
			swap(s, i, (s.length - 1) - i);
		}

	}

	private void swap(char[] input, int aIndex, int bIndex) {

		char c = input[bIndex];
		input[bIndex] = input[aIndex];
		input[aIndex] = c;

	}

	public void print(char[] s) {

		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i]);
		}
	}

}
