public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return Integer.MAX_VALUE;
        }
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
        
        /* TLE DFS solution
       if (coins == null || coins.length == 0) {
           return Integer.MAX_VALUE;
       } 
       helper(coins, 0, amount, 0);
       if (result == Integer.MAX_VALUE) {
           return -1;
       }
       return result;
    }
    private int result = Integer.MAX_VALUE;
    
    private void helper(int[] coins, int count, int amount, int index) {
        if (amount < 0) {
            return;
        }
        if (index == coins.length && amount != 0) {
            return;
        }
        if (amount == 0) {
            result = Math.min(result, count);
            return ;
        }
        
        for (int i = 0; i <= amount / coins[index]; i++) {
            helper(coins, count + i, amount - i * coins[index], index + 1);
        }
        */
        
        
    }
}