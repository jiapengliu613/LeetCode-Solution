public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() > t.length()) {
            return false;
        }
        int m = s.length(), n = t.length();
        /*
        boolean[][] dp = new boolean[2][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = true;
            //System.out.print(dp[0][i] + " ");
        }
        //System.out.println();
        for (int i = 1; i <= m; i++) {
            dp[i % 2][0] = false;
            //System.out.print(dp[i % 2][0] + " ");
            for (int j = 1; j <= n; j++) {
                if (dp[i % 2][j - 1] == true) {
                    dp[i % 2][j] = true;
                } else if (dp[(i - 1) % 2][j - 1] && s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i % 2][j] = true;
                } else {
                    dp[i % 2][j] = false;
                }
                //System.out.print(dp[i % 2][j] + " ");
            }
            //System.out.println();
        }
        return dp[m % 2][n];
        */
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            int tmp = t.indexOf(s.charAt(i), index);
            if (tmp == -1) {
                return false;
            }
            index = tmp + 1;
            //System.out.print(index + " ");
        }
        return true;
    }
}