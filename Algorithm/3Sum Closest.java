public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int diff = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < n; i++) {
            int newTarget = target - nums[i];
            int left = i + 1, right = n - 1;
            while (left < right) {
                if (nums[left] + nums[right] == newTarget) {
                    return target;
                } else if (nums[left] + nums[right] < newTarget) {
                    if (diff > Math.abs(nums[left] + nums[right] - newTarget)) {
                        diff = Math.abs(nums[left] + nums[right] - newTarget);
                        result = nums[i] + nums[left] + nums[right];
                    }
                    left++;
                } else {
                    if (diff > Math.abs(nums[left] + nums[right] - newTarget)) {
                        diff = Math.abs(nums[left] + nums[right] - newTarget);
                        result = nums[i] + nums[left] + nums[right];
                    }
                    right--;
                }
            }
        }
        return result;
    }
}