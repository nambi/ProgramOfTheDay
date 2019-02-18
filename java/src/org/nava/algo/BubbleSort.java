package org.nava.algo;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 9,1,0, 6, 8, 4 };
		
		int[] output = sort(input);

		for (int o : output) {
			System.out.print("" + o + ",");
		}
	}

	private static int[] sort(int[] input) {
		int s = input.length;
		int temp = 0;

		for (int i = 0; i < s; i++) {
			for (int j = i + 1; j < s; j++) {
				if (input[i] > input[j]) {
					temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}
			}
		}
		return input;
	}

}
