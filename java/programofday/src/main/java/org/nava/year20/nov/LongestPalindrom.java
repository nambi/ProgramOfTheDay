package org.nava.year20.nov;

public class LongestPalindrom {

	static int STR_MAX_LENGTH = 10;

	public static void main(String[] args) {

		String input = "";

		int len = getLongestPalindrome(input);

		System.out.println("Longest Palindrom for input " + input + " is : " + len);

	}
	/*
	 * set original long length as len=0 Loop
	 * 
	 * Count till the palindrome continues If the count > len, then set len = count
	 * If palindrome breaks reset the count continue the loop
	 * 
	 * End loop when max length reaches
	 * 
	 */

	static int getLongestPalindrome(String input) {
		int len = 0;

		System.out.println("Input " + input);

		if (input == null || input.length() < 1 || input.length() > STR_MAX_LENGTH) {
			throw new RuntimeException("Invalid input");
		}
		input = input.toLowerCase();
		char[] arr = input.toCharArray();
		char prevChar = arr[0];
		int count = 1;

		for (int i = 1; i < arr.length; i++) {
			char currentChar = arr[i];
			if (currentChar ==  prevChar+1) {
				count++;
			} else {
				count = 1;
			}
			if (count > len) {
				len = count;
			}
			prevChar = currentChar;
		}

		return len;
	}

}
