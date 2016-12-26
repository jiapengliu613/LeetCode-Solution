public class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] array = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            array[i] = nums[i - 1];
        }
        array[0] = 1;
        array[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        return helper(array, dp, 0, n + 1);
    }
    private int helper(int[] array, int[][] dp, int left, int right) {
        if (left + 1 == right) {
            return 0;
        }
        if (dp[left][right] != 0) {
            return dp[left][right];
        }
        for (int i = left + 1;i < right; i++) {
            dp[left][right] = Math.max(dp[left][right], array[left] * array[i] * array[right] + helper(array, dp, left, i)
             + helper(array, dp, i, right));
        }
        return dp[left][right];
    }
}