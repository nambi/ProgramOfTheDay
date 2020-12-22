package org.nava.year20.dec;

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
             
  
  Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.           
             
 */

public class DynamicProgram1_BuySellStock {

	public static void main(String[] args) {

		int[] prices = { 7, 1, 5, 3, 6, 4 };

		// int[] prices = { 7, 6, 5, 4, 3, 1 };

		DynamicProgram1_BuySellStock _instance = new DynamicProgram1_BuySellStock();
		int result = _instance.maxProfit(prices);

		System.out.println("Result :" + result);

	}

	public int maxProfit(int[] prices) {
		int profit = 0;
		for (int i = 0; i < prices.length; i++) {

			for (int j = i + 1; j < prices.length; j++) {

				int result = prices[j] - prices[i];
				if (result > profit) {
					profit = result;
				}
			}
		}

		return profit;
	}

}
