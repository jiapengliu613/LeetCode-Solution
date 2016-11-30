public class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int count = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                result = nums[i];
                count++;
            } else {
                if (nums[i] == result) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return result;
    }
}