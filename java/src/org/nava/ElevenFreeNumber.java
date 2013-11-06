package org.nava;

import java.io.DataInputStream;
import java.util.Scanner;

/**
 * An integer is called eleven-free if its decimal expansion does not contain
 * any substring representing a power of 11 except 1. For example, 2404 and
 * 13431 are eleven-free, while 911 and 4121331 are not.
 * Given a number, find out if its eleven-free or not
 */
public class ElevenFreeNumber {

	public static void main(String a[]) {
		Long givenNumber = 2222L;
		Scanner scan = new Scanner(new DataInputStream(System.in));
		System.out.println("Welcome to Eleven Free Calculator.");
		System.out.println("Enter new number : " + " (Press q to exit the program)");
		while (scan.hasNext()) {
			String input = scan.next();
			if ("q".equalsIgnoreCase(input)) {
				System.out.println("Thank you for using the Eleven Free Calculator");
				System.exit(0);
			} else {
				try {
					givenNumber = Long.valueOf(input);
					isElevenFreeNum(givenNumber);
					System.out.println("Enter new number : ");
				} catch (Exception e) {
					System.out.println("Entered number " + input + " is not valid. Enter new number :");
				}

			}
		}
	}

	private static void isElevenFreeNum(Long givenNumber) {
		Long power = 11L;
		double p = 1;
		boolean elevenFree = true;
		while (Double.valueOf(givenNumber) >= Double.valueOf(power)) {
			if (givenNumber.toString().indexOf(power.toString()) != -1) {
				elevenFree = false;
				break;
			} else {
				p++;
				power = Long.valueOf((long) Math.pow(11.0, p));
			}
		}

		if (elevenFree) {
			System.out.println("Given Num " + givenNumber + " is eleven free");
		} else {
			System.out.println("Given Num " + givenNumber + " is not eleven free");
		}
	}
}
