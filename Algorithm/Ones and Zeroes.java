public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0 || (m == 0 && n == 0)) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] count = findCount(str);
            for (int i = m; i >= 0; i--) {
                for (int j = n; j >= 0; j--) {
 
                    //dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1]));
                    
                    if (i >= count[0] && j >= count[1]) {
                    dp[i][j] = Math.max(dp[i - count[0]][j - count[1]] + 1, dp[i][j]);
                    }
                }
            }
        }
        return dp[m][n];
    }
    private int[] findCount(String s) {
        int[] result = new int[2];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                result[0]++;
            } else {
                result[1]++;
            }
        }
        return result;
    }
}