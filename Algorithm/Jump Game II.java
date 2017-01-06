public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxDisInCurrentStep = 0, maxDisInOneMoreStep = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxDisInCurrentStep) {
                count++;
                maxDisInCurrentStep = maxDisInOneMoreStep;
            }
            maxDisInOneMoreStep = Math.max(maxDisInOneMoreStep, nums[i] + i);
        }
        return count;
        
        
        
        
        
        /* O(n^2) TLE solution
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        if (nums.length == 2) {
            return 1;
        }
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (nums[j - 1] >= i - j) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n];
        */
        
    }
}