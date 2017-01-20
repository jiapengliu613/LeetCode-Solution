public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() == 0 && t.length() == 0) {
            return false;
        }
        int length = Math.min(s.length(), t.length());
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else if (s.length() < t.length()) {
                    return s.substring(i).equals(t.substring(i + 1));
                } else {
                    return s.substring(i + 1).equals(t.substring(i));
                }
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
        /* O(n^2) TLE
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c1 = s.charAt(i - 1);
                char c2 = t.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        System.out.println(dp[m][n]);
        return dp[m][n] == 1;
        */
    }
}