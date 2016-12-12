public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null) {
            return false;
        }
        if (p == null) {
            return false;
        }
        int m = s.length();
        int n = p.length();
        //System.out.println("" + m + " " + n);
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i > 1 && '*' == p.charAt(i - 1) && dp[0][i - 2];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) != '.' && p.charAt(j - 1) != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1));
                } else if (p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (j > 1) {
                    if (dp[i][j - 1] || dp[i][j - 2]) {
                        dp[i][j] = true;
                    } else {
                        if ((s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]) {
                            dp[i][j] = true;
                        }
                    }
                }
                
            }
        }
        //System.out.println(dp[2][1]);
        return dp[m][n];
    }
}