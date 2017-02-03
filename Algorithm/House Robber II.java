public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[1], nums[0]);
        }
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }
    
    int helper(int[] nums, int start, int end) {
        if (start + 1 == end) {
            return Math.max(nums[start], nums[end]);
        }
        int[] dp = new int[2];
        dp[start % 2] = nums[start];
        dp[(start + 1) % 2] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i % 2] = Math.max(dp[(i - 1) % 2], dp[(i - 2) % 2] + nums[i]);
        }
        return dp[end % 2];
    }
}