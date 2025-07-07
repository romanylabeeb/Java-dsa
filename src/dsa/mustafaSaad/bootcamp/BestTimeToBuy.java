package dsa.mustafaSaad.bootcamp;

public class BestTimeToBuy {
    /**https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int l = 0, r = 1;
        int maxProfit = 0;
        while (r < prices.length) {
            int profit = prices[r] - prices[l];
            if (profit < 0) {
                l = r;
            } else {
                maxProfit = Math.max(maxProfit, profit);
                r++;
            }
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}
