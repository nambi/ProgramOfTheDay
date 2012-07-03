package org.nava.num2word;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author nambi
 * These junit tests require JUnit 4.0 libraries
 *
 */
public class NumberToWordsTest
{
	private NumberToWords instance = null;

	@Before
	public void setUp()
	{
		instance = new NumberToWords();
	}

	@After
	public void die()
	{
		instance = null;
	}

	public void testMain()
	{
		int a = 2;
		assertTrue(a == 1);
	}

	@Test
	public void getWordForNum()
	{
		int num = 11;
		String word = instance.getWordForNum(num);
		System.out.println("Num : " + num + " and Word  " + word);
	}

	@Test
	public void spellNumber()
	{
		int num = 0;
		while (num < 33)
		{
			String word = instance.spellNumber(num);
			System.out.println("Num : " + num + " and Word :" + word);
			assertNotNull(word);
			num++;
		}
	}

	@Test
	public void lettersNotRequired()
	{
		String test = "nambi";
		String notRequired = instance.lettersNotRequired(test);
		assertNotNull(notRequired);
		assertTrue(notRequired.length() + test.length() == 26);
	}

	@Test
	public void getUniqLetters()
	{
		String test = "nambi";
		String uniq = instance.getUniqLetters(test);
		assertTrue(test.length() == uniq.length());
	}
}