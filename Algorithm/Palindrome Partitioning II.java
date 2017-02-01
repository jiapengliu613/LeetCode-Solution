public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int n = s.length();
        boolean[][] isPalin = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPalin[i][i] = true;
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (j == i + 1) {
                    isPalin[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    isPalin[i][j] = ((s.charAt(i) == s.charAt(j)) && isPalin[i + 1][j - 1]);
                }
            }
        }
        //System.out.println(isPalin[0][3]);
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (isPalin[0][i - 1]) {
                dp[i] = 0;
                continue;
            }
            dp[i] = i - 1;
            for (int j = i; j >= 1; j--) {
                if (isPalin[j - 1][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[n];
    }
}