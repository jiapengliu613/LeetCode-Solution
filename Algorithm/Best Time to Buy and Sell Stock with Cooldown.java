public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        int maxProfit = 0;
        buy[0] = -prices[0];
        //buy[1] = Math.max(-prices[0], -prices[1]);
        for (int i = 1; i < n; i++) {
            int delta = prices[i] - prices[i - 1];
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1] + delta);
            
                buy[i] = Math.max(i > 1 ? sell[i - 2] - prices[i] : -prices[i], buy[i - 1] - delta);
            
            maxProfit = Math.max(maxProfit, sell[i]);
            //System.out.println(maxProfit + " " + buy[i]);
        }
        return maxProfit;
    }
}