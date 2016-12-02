public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);
        int leftPart = nums[0];
        // from left to right, ignore res[0]
        for (int i = 1; i < n; i++) {
            result[i] *= leftPart;
            leftPart *= nums[i];
        }
        // from right to left
        int rightPart = nums[n - 1];
        for (int i = n - 2; i>= 0; i--) {
            result[i] *= rightPart;
            rightPart *= nums[i];
        }
        return result;
    }
}