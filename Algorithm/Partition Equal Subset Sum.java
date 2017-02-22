public class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum / 2; j >= 1; j--) {
                if (j >= nums[i] && dp[j - nums[i]]) {
                    dp[j] = true;
                }
            }
        }
        return dp[sum / 2];
    }
}