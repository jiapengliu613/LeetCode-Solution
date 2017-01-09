public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int m = s1.length(), n = s2.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        //dp[0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1);
                } else {
                    if(s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                    if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                        dp[i][j] |= dp[i][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }
}