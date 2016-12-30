public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[2][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        //for (int i = 1; i < m; i++) {
          //  dp[i][0] = dp[i - 1][0] + grid[i][0];
        //}
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j] + grid[i][j];
                } else {
                    dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j], dp[i % 2][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[(m - 1) % 2][n - 1];
    }
}