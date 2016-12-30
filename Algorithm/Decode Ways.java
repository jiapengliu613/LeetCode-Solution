public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[3];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            if (c - '0' == 0) {
                if (i == 1 || (s.charAt(i - 2) - '0' > 2) || (s.charAt(i - 2) - '0' == 0)) {
                    return 0;
                }
                dp[i % 3] = dp[(i - 2) % 3];
            } else {
                dp[i % 3] = dp[(i - 1) % 3];
                if (i > 1 && s.charAt(i - 2) != '0') {
                    int val = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
                    if (val <= 26) {
                        dp[i % 3] += dp[(i - 2) % 3];
                    }
                }
            }
        }
        return dp[n % 3];
        
    }
}