public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i - 1).get(0);
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i - 1).get(i - 1);
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i - 1).get(j - 1);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            min = Math.min(min, dp[m][i]);
        }
        return min;
    }
}