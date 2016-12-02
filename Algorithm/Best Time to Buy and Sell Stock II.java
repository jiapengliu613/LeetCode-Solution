public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int[] diff = new int[n - 1];
        for (int i = 1; i < n; i++) {
            diff[i - 1] = prices[i] - prices[i - 1];
        }
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            if (diff[i] > 0) {
                result += diff[i];
            }
        }
        return result;
    }
    
}