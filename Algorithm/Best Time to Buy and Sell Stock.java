public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[] buyDate = new int[n];
        int[] sellDate = new int[n];
        int lowest = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (prices[i] < lowest) {
                lowest = prices[i];
            }
            buyDate[i] = lowest;
        }
        int highest = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (prices[i] > highest) {
                highest = prices[i];
            }
            sellDate[i] = highest;
        }
        int diff = 0;
        for (int i = 0; i < n; i++) {
            diff = Math.max(sellDate[i] - buyDate[i], diff);
        }
        return diff;
    }
}