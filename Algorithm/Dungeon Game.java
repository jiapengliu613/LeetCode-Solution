public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[2][n];
        dp[(m - 1) % 2][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);
        //for (int i = m - 2; i >= 0; i--) {
          //  dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1);
        //}
        for (int i = n - 2; i >= 0; i--) {
            dp[(m - 1) % 2][i] = Math.max(dp[(m - 1) % 2][i + 1] - dungeon[m - 1][i], 1);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (j == n - 1) {
                    dp[i % 2][j] = Math.max(dp[(i + 1) % 2][j] - dungeon[i][j], 1);
                    continue;
                }
                dp[i % 2][j] = Math.min(Math.max(dp[(i + 1) % 2][j] - dungeon[i][j], 1), Math.max(dp[i % 2][j + 1] - dungeon[i][j], 1));
            }
        }
        return dp[0][0];
        /*
        int currentMax = 0;
        helper(dungeon, currentMin, 0, 0);
    }
    private void helper(int[][] dungeon, int currentMax, int i, int j) {
        int m = dungeon.length, n = dungeon[0].length;
        if (i == m || j == n) {
            return ;
        }
        currentMax += dungeon[i][j];
        if (i == m - 1 && j == n - 1) {
            if (currentMax)
        }
    }
    private globalMax = 0;
    */
    }
}