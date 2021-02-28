package org.nava.year21.feb;

/**
 * Given a list of stock prices for n days, find the maximum profit with a single buy or sell activity.
 * We need to maximize the single buy/sell profit.
 * If we can’t make any profit, we’ll try to minimize the loss.
 * <p>
 * For the below examples, buy and sell prices for making a maximum profit is buy at 5 and sell at 19
 * {d1price, d2price,d3price...}
 * <p>
 * {8,5,12,9,19,1}
 * <p>
 * You have buy the stock in lower index and sell at higher index
 */
public class BuySellForProfit {

    public static Tuple findBuySellStockPrices(int[] array) {
        Tuple t = new Tuple(-1, -1);
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int buy = array[i];
            for (int j = i + 1; j < array.length; j++) {
                int sell = array[j];
                int currentProfit = (sell - buy);
                if (currentProfit > maxProfit) {
                    t.x = buy;
                    t.y = sell;
                    maxProfit = currentProfit;
                }
            }
        }

        return t;
    }

    public static Tuple findBuySellStockPricesOptimized(int[] array) {
        Tuple t = new Tuple(-1, -1);

        int currentBuy = array[0];
        int maxSell = array[1];
        int currentProfit = maxSell - currentBuy;
        int maxProfit = currentProfit;

        for (int i = 1; i < array.length; i++) {

            int currentSell = array[i];
            currentProfit = currentSell - currentBuy;

            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
                maxSell = currentSell;
            }
            if (currentBuy > currentSell) {
                currentBuy = currentSell;
            }
        }

        t.x = Math.abs(maxProfit - maxSell);
        t.y = maxSell;

        return t;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 3, 2, 1, 2, 5};
        Tuple result = null;
        result = findBuySellStockPrices(array);
        System.out.println(String.format("Buy Price: %d, Sell Price: %d", result.x, result.y));

        int[] array2 = {8, 6, 5, 4, 3, 2, 1};
        result = findBuySellStockPricesOptimized(array2);
        System.out.println(String.format("Buy Price: %d, Sell Price: %d", result.x, result.y));

    }
}

class Tuple<X, Y> {
    public X x;
    public Y y;

    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }
}
