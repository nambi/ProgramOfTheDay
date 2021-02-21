package org.nava.year20.dec;

/*
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).


Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
Follow up: If this function is called many times, how would you optimize it?

Input: n = 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.


Input: n = 00000000000000000000000010000000
Output: 1
Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.

Input: n = 11111111111111111111111111111101
Output: 31
Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.


In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3 above, the input represents the signed integer. -3.


 */

public class NumberOfBits {

	public static void main(String[] args) {

		// int input = 0b00000000000000000000000000001011; //3
		// int input = 0b11111111111111111111111111111101; //31
		// int input = 0b10000000000000000000000000000000; //1
		int input = 0b11111111111111111111111111111111; // 32
		NumberOfBits _instance = new NumberOfBits();
		int weight = _instance.hammingWeight(input);

		System.out.println("\nThe weight is :" + weight);

	}

	public int hammingWeight(int n) {

		int[] b = new int[32];
		int numOfOnes = 0;

		if (n <= -2147483648) {
			numOfOnes = 1;
		} else if (n < 0) {
			n = n * -1;
			numOfOnes = 29;
		}
		
		//The following solution works for all positive integers 

		int index = 31;
		while (n > 0) {

			if ((b[index--] = n % 2) == 1) {
				numOfOnes++;
			}

			n = n / 2;
		}

		return numOfOnes;
	}

}
