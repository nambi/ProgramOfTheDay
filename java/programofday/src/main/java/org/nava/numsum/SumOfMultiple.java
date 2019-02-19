
package org.nava.numsum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nambi <br>
 *         If we list all the natural numbers below 10 that are multiples of 3
 *         or 5, we get 3, 5, 6 and 9. <br>
 *         The sum of these multiples is 23.<br>
 *         Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class SumOfMultiple
{
    private static int LIMIT = 1000;
    private static int[] FACTORS = { 3, 5 };

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        SumOfMultiple app = new SumOfMultiple();
        System.out.println("Sum : " + app.sumOfMultiples());
        System.out.println("Sum2 : " + app.sumOfMultiples2());

    }

    private int sumOfMultiples()
    {
        int sum = 0;
        List<Integer> multiples = getMultiples(LIMIT, FACTORS);
        for (Integer num : multiples)
        {
            sum += num;
        }
        return sum;

    }

    private List<Integer> getMultiples(int limit, int[] factors)
    {
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 1; i < limit; i++)
        {

            if (isMultiple(factors, i))
            {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isMultiple(int[] factors, int number)
    {
        for (int j = 0; j < factors.length; j++)
        {
            int factor = factors[j];
            if (factor != 0)
            {
                if (number % factor == 0)
                {
                    return true;
                }
            }
        }
        return false;
    }

    private int _sumDivisibleBy(int factor)
    {
        int p = (LIMIT - 1) / factor;
        return factor * (p * (p + 1)) / 2;
    }

    private int sumOfMultiples2()
    {
        return _sumDivisibleBy(3) + _sumDivisibleBy(5) - _sumDivisibleBy(15);
    }
}