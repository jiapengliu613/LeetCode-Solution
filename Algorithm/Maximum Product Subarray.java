public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[0], min = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // min max represent the minValue and maxValue that end up with nums[i], so it can decide whether to use the previous i - 1 number or not
            int a = min * nums[i];
            int b = max * nums[i];
            min = Math.min(nums[i], Math.min(a, b));
            max = Math.max(nums[i], Math.max(a, b));
            result = Math.max(min, max);
        }
        return result;
        
        
        
        /*
        int globalMax = nums[0];
        int localMax = nums[0], localMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = localMax;
                localMax = localMin;
                localMin = tmp;
            }
            localMax = Math.max(nums[i], localMax * nums[i]);
            localMin = Math.min(nums[i], localMin * nums[i]);
            globalMax = Math.max(globalMax, localMax);
        }
        return globalMax;
        */
        
    }
}