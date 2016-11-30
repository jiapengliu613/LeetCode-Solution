public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return ;
        }
        int n = nums.length;
        int slow = 0, fast = 0;
        while (fast < n) {
            if (nums[fast] == 0) {
                fast++;
            } else {
                nums[slow] = nums[fast];
                fast++;
                slow++;
            }
        }
        for (int i = slow; i < n; i++) {
            nums[i] = 0;
        }
        return ;
    }
}