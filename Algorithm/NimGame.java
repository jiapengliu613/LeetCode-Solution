public class Solution {
    public boolean canWinNim(int n) {
        /* TLE solution
        if (n <= 0) {
            return false;
        }
        if (n >= 1 && n <= 3) {
            return true;
        }
        boolean[] dp = new boolean[4];
        dp[0] = false;
        dp[1] = true;
        dp[2] = true;
        dp[3] = true;
        for (int i = 4; i <= n; i++) {
            dp[i % 4] = !(dp[(i - 1) % 4] && dp[(i - 2) % 4] && dp[(i - 3) % 4]);
        }
        return dp[n % 4];
        */
        return n % 4 != 0;
    }
}