public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int n = nums.length;
        //System.out.println(n);
        int slow = 0, fast = 0, result = 1;
        while (fast < n) {
            if (nums[fast] == nums[slow]) {
                fast++;
                continue;
            } else if (nums[fast] > nums[slow]) {
                while (fast + 1 < n && nums[fast + 1] >= nums[fast]) {
                    fast++;
                }
                slow = fast;
                result++;
            } else {
                while (fast + 1< n && nums[fast + 1] <= nums[fast]) {
                    fast++;
                }
                slow = fast;
                result++;
            }
        }
        return result;
    }
}