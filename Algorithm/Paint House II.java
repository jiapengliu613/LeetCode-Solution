public class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int n = costs.length, k = costs[0].length;
        int[][] dp = new int[n + 1][k];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < k; j++) {
                //System.out.println(findMin(dp, i - 1, j));
                dp[i][j] = findMin(dp, i - 1, j) + costs[i - 1][j];
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            result = Math.min(result, dp[n][i]);
        }
        return result;
    }
    
    private int findMin(int[][] cost, int row, int index) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < cost[0].length; i++) {
            if (index == i && cost.length > 2) {
                //System.out.println("im here");
                continue;
            }
            result = Math.min(result, cost[row][i]);
        }
        return result;
    }
}