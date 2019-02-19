package org.nava.prime;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author nambi <br>
 *         By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13,<br>
 *         we can see that the 6th prime is 13. <br>
 *         What is the 10001st prime number?
 */
public class NthPrimeNumber
{
	private List<Integer> primes = new ArrayList<Integer>();
	private int loops = 0;
	private static boolean USE_ALGO = true;
	private static Integer TOTAL_PRIME_NUMBERS = 10001;

	public static void main(String[] args)
	{
		TimeTracker tracker = new TimeTracker();
		NthPrimeNumber app = new NthPrimeNumber();
		tracker.start();
		if (USE_ALGO)
		{
			app.printPrimesWithAlgo(TOTAL_PRIME_NUMBERS);
		} else
		{
			app.collectPrimeNumbers(2, TOTAL_PRIME_NUMBERS);
			app.printPrimeNumbers(TOTAL_PRIME_NUMBERS);
		}
		tracker.stop();
		tracker.measure();
	}

	public void collectPrimeNumbers(int start, int end)
	{
		loops++;
		for (int i = start; i < end; i++)
		{
			if (isPrime(i))
			{
				primes.add(i);
			}
		}
		while (primes.size() < TOTAL_PRIME_NUMBERS)
		{
			collectPrimeNumbers(end, end + TOTAL_PRIME_NUMBERS);
		}
	}

	private void printPrimeNumbers(int max)
	{
		System.out.println("Primes upto " + max + " and it took " + loops + " loops");
		System.out.println("No of primes : " + primes.size());
		System.out.println("Nth (" + TOTAL_PRIME_NUMBERS + ") prime " + primes.get(TOTAL_PRIME_NUMBERS - 1));
		for (int j : primes)
		{
			System.out.println(j);
		}
	}

	private boolean isPrime(int num)
	{
		int i = 2;
		while (i < num)
		{
			if (num % i == 0)
			{
				return false;
			}
			i++;
		}
		return true;
	}

	private boolean isPrimeWithAlgo(int n)
	{
		if (n == 1)
		{
			return false;
		} else if (n < 4)
		{
			// 2 and 3 are prime
			return true;
		} else if (n % 2 == 0)
		{
			return false;
		} else if (n < 9)
		{
			// we have already excluded 4,6 and 8.
			return true;
		} else if (n % 3 == 0)
		{
			return false;
		} else
		{
			// n rounded to the greatest integer r so that r*r<=n
			double r = Math.floor(Math.sqrt(n));
			int f = 5;
			while (f <= r)
			{
				if (n % f == 0)
				{
					return false;
				}
				if (n % (f + 2) == 0)
				{
					return false;
				}
				f = f + 6;
			}
		}
		return true;
	}

	public void printPrimesWithAlgo(int max)
	{
		// we know that 2 is prime and hence any even number is a prime; so we
		// need to check only odd numbers
		int count = 1;
		int candidate = 1;
		do
		{
			candidate = candidate + 2;
			if (isPrimeWithAlgo(candidate))
			{
				count++;
			}
		} while (count < max);

		System.out.println("Nth " + max + " prime using algo is " + candidate);
	}

	static class TimeTracker
	{
		private long startTime;
		private long endTime;

		public void start()
		{
			startTime = System.currentTimeMillis();
		}

		public void stop()
		{
			endTime = System.currentTimeMillis();
		}

		public void measure()
		{
			System.out.println("The Process took " + (endTime - startTime) + " milli seconds");
		}

		public void clear()
		{
			startTime = 0;
			endTime = 0;
		}
	}
}