package org.nava.num2word;

import java.util.Arrays;

/**
 * @author nambi<br>
 *         Project Euler Problem : 17 How many letters would be needed to write <br>
 *         all the numbers in words from 1 to 1000? <br>
 */
public class NumberToWords
{
	private boolean traceLog = false;
	private int printUpto = 1000;

	/**
	 * App Main
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		NumberToWords app = new NumberToWords();
		app.spellNumberRange(1, app.printUpto);
		System.out.println("Time Taken to compute : " + (System.currentTimeMillis() - startTime) + " milli seconds");
	}

	/**
	 * Spell Range of Number
	 * 
	 * @param start
	 * @param end
	 */
	public void spellNumberRange(int start, int end)
	{
		String allWords = new String();
		for (int i = start; i <= end; i++)
		{
			String word = spellNumber(i);
			if (word != null)
			{
				allWords += word;
			}
			if (traceLog)
				System.out.println(i + ":" + word);
		}
		System.out.println("No of Letters to print upto " + printUpto + " : " + allWords.length());
		String withoutSpace = allWords.replace(" ", "");
		System.out.println("No of Letters (without spaces) to print upto " + printUpto + " : " + withoutSpace.trim().length());
		String uniqLetters = getUniqLetters(allWords);
		System.out.println("Required Letters to print upto " + printUpto + " : " + uniqLetters);
		System.out.println("Not Required Letters to print upto " + printUpto + " : " + lettersNotRequired(uniqLetters));
	}

	/**
	 * Spell a given number
	 * 
	 * @param num
	 * @return word
	 */
	public String spellNumber(int num)
	{
		return getWord(num, 1000);
	}

	/**
	 * 
	 * @param requiredLetters
	 * @return
	 */
	public String lettersNotRequired(String requiredLetters)
	{
		String notRequired = "";

		for (int i = 97; i < 123; i++)
		{
			char ch = (char) i;

			if (requiredLetters.indexOf(ch) == -1)
			{
				notRequired += ch;
			}
		}

		return notRequired;
	}

	/**
	 * @param input
	 *            word
	 * @return unique letters in a given word
	 */
	public String getUniqLetters(String input)
	{
		String uniqLetters = new String();
		char[] inputArray = input.toCharArray();
		int i = 0;
		while (i < inputArray.length)
		{
			char ch = inputArray[i];
			if (uniqLetters.indexOf(ch) == -1)
			{
				uniqLetters += ch;
			}
			i++;
		}
		char[] outputArray = uniqLetters.toCharArray();
		Arrays.sort(outputArray);

		return String.valueOf(outputArray);
	}

	/**
	 * 
	 * @param num
	 * @param upperLimit
	 * @return word for the number
	 */
	private String getWord(int num, int upperLimit)
	{
		String word;
		if (num < 21)
		{
			word = getWordForNum(num);
		} else if (num / upperLimit > 0)
		{

			int remainder = num % upperLimit;
			int decimal = (num - remainder) / upperLimit;

			if (upperLimit > 10)
			{
				word = getWordForNum(decimal) + " " + getWordForNum(upperLimit);
				if (remainder > 0)
				{
					word += " and";
				}
			} else
			{
				word = getWordForNum((num - remainder));
			}

			if (remainder > 0)
			{
				word += " " + getWord(remainder, upperLimit / 10);
			}

		} else
		{

			word = " " + getWord(num, upperLimit / 10);
		}

		return word;
	}

	/**
	 * @deprecated
	 * @param num
	 * @return
	 */
	private String _spellNumber(int num)
	{
		String word = null;
		boolean newLogic = true;
		if (newLogic)
		{
			word = getWord(num, 1000);
		} else if (num < 100)
		{
			word = getWordLessThan100(num);
		} else if (num < 1000)
		{
			word = getWordLessThan1000GreaterThan100(num);
		} else
		{
			word = getWordGreaterThan1000(num);
		}

		return word;

	}

	/**
	 * @deprecated
	 * @param num
	 * @return
	 */

	private String getWordLessThan100(int num)
	{
		String word;
		int remainder = num % 10;
		int decimal = (num - remainder) / 1;

		if (num < 21)
		{
			word = getWordForNum(num);
		} else
		{
			word = getWordForNum(decimal);
			if (remainder > 0)
			{
				word += " " + getWordForNum(remainder);
			}
		}
		return word;
	}

	/**
	 * @deprecated
	 * @param num
	 * @return
	 */
	private String getWordLessThan1000GreaterThan100(int num)
	{
		String word;
		int remainder = num % 100;
		int decimal = (num - remainder) / 100;

		word = getWordForNum(decimal) + " " + getWordForNum(100);
		if (remainder > 0)
		{
			if (remainder < 100)
			{
				word += " " + getWordLessThan100(remainder);
			}
		}
		return word;
	}

	/**
	 * @deprecated
	 * @param num
	 * @return
	 */
	private String getWordGreaterThan1000(int num)
	{
		String word;
		int remainder = num % 1000;
		int decimal = (num - remainder) / 1000;

		word = getWordForNum(decimal) + " " + getWordForNum(1000);
		if (remainder > 0)
		{
			if (remainder < 100)
			{
				word += " " + getWordLessThan100(remainder);
			} else if (remainder < 1000)
			{
				word += " " + getWordLessThan1000GreaterThan100(remainder);
			}
		}
		return word;
	}

	/**
	 * 
	 * @param num
	 * @return
	 */
	public String getWordForNum(int num)
	{
		String word = null;

		switch (num)
		{
		case 0:
			word = "zero";
			break;
		case 1:
			word = "one";
			break;
		case 2:
			word = "two";
			break;
		case 3:
			word = "three";
			break;
		case 4:
			word = "four";
			break;
		case 5:
			word = "five";
			break;
		case 6:
			word = "six";
			break;
		case 7:
			word = "seven";
			break;
		case 8:
			word = "eight";
			break;
		case 9:
			word = "nine";
			break;
		case 10:
			word = "ten";
			break;
		case 11:
			word = "eleven";
			break;
		case 12:
			word = "twelve";
			break;
		case 13:
			word = "thirteen";
			break;
		case 14:
			word = "fourteen";
			break;
		case 15:
			word = "fifteen";
			break;
		case 16:
			word = "sixteen";
			break;
		case 17:
			word = "seventeen";
			break;
		case 18:
			word = "eighteen";
			break;
		case 19:
			word = "nineteen";
			break;
		case 20:
			word = "twenty";
			break;
		case 30:
			word = "thirty";
			break;
		case 40:
			word = "forty";
			break;
		case 50:
			word = "fifty";
			break;
		case 60:
			word = "sixty";
			break;
		case 70:
			word = "seventy";
			break;
		case 80:
			word = "eighty";
			break;
		case 90:
			word = "ninety";
			break;
		case 100:
			word = "hundred";
			break;
		case 1000:
			word = "thousand";
			break;
		default:
			word = null;

		}

		return word;
	}
}