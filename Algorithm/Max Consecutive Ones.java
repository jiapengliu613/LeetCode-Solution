public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                current = 0;
                continue;
            }
            current += 1;
            max = Math.max(current, max);
        }
        return max;
    }
    
}