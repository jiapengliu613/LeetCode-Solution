public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int result = 0;
        if (k >= n / 2) {
            for (int i = 0; i < n - 1; i++) {
                if (prices[i + 1] > prices[i]) {
                    result += prices[i + 1] - prices[i];
                }
            }
            return result;
        }
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 1; i <= k; i++) {
            // currentMax is the max profit we can have when buying a stock at day j
            int currentMax = -prices[0];
            for (int j = 1; j <= n; j++) {
                // dp[i][j] is the max profit we can have 
                dp[i][j] = Math.max(dp[i][j - 1], prices[j - 1] + currentMax);
                currentMax = Math.max(currentMax, dp[i - 1][j - 1] - prices[j - 1]);
            }
        }
        return dp[k][n];
    }
}