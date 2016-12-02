public class Solution {
    public int maxSubArray(int[] nums) {
        /* dp solution
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i - 1];
            } else {
                dp[i] = dp[i - 1] + nums[i - 1];
            }
            result = Math.max(result, dp[i]);
        }
        return result;
        */
        int result = Integer.MIN_VALUE;
        int curMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curMax < 0) {
                curMax = nums[i];
            } else {
                curMax += nums[i];
            }
            result = Math.max(curMax, result);
        }
        return result;
    }
}