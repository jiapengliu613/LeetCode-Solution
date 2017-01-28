public class Solution {
    public int getMoneyAmount(int n) {
        if (n <= 1) {
            return 0;
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int left = n - 1; left > 0; left--) {
            for (int right = left + 1; right <= n; right++) {
                dp[left][right] = Integer.MAX_VALUE;
                if (left + 1 == right) {
                    dp[left][right] = left;
                } else {
                    for (int i = left; i <= right; i++) {
                        if (i == left) {
                            dp[left][right] = Math.min(dp[left][right], left + dp[left + 1][right]);
                        } else if (i == right) {
                            dp[left][right] = Math.min(dp[left][right], right + dp[left][right - 1]);
                        } else {
                            dp[left][right] = Math.min(dp[left][right], i + Math.max(dp[left][i - 1], dp[i + 1][right]));
                        }
                    }
                }
            }
        }
        return dp[1][n];
    }
}