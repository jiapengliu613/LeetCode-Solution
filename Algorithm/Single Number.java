public class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int result = nums[0] ^ nums[1];
        for (int i = 2; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}