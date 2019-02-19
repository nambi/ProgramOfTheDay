package org.nava.numsum;

import java.math.BigInteger;

/**
 * 
 * @author nambi<br>
 *         Find the sum of digits in 100! <br>
 * 
 *         n! means n (n 1) ... 3 2 1 <br>
 *         For example, 10! = 10 9 ... 3 2 1 = 3628800,<br>
 *         and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0
 *         + 0 = 27.<br>
 * 
 *         Find the sum of the digits in the number 100!<br>
 * 
 */
public class SumDigitsInFactorial
{
	private BigInteger NUMBER = BigInteger.valueOf(100L);

	public static void main(String[] args)
	{
		SumDigitsInFactorial app = new SumDigitsInFactorial();
		BigInteger factorial = app.fact(app.NUMBER);
		System.out.println("Factorial : " + factorial);
		Long out = app.sumOfDigits(factorial);
		System.out.println("Sum of Digits of Factorial " + out);
	}

	public Long sumOfDigits(BigInteger num)
	{
		char digits[] = String.valueOf(num).toCharArray();
		long sum = 0L;
		for (char c : digits)
		{
			if (c == '-')
			{
				continue;
			}
			sum += Integer.valueOf("" + c);
		}
		return sum;
	}

	public BigInteger fact(BigInteger n)
	{
		BigInteger factorial = BigInteger.valueOf(1L);
		if (n.compareTo(factorial) > 0)
		{
			return n.multiply(fact(n.subtract(BigInteger.valueOf(1L))));
		} else
		{
			return factorial;
		}
	}
}