public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 2) {
            return nums.length;
        }
        int slow = 1, fast = 2;
        while (fast < nums.length) {
            if (nums[fast] == nums[slow] && nums[fast] == nums[slow - 1]) {
                fast++;
            } else {
                slow++;
                nums[slow] = nums[fast];
                fast++;
            }
        }
        return slow + 1;
    }
}