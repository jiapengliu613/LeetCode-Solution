public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k % nums.length == 0) {
            return;
        }
        k = k % nums.length;
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
        left = 0;
        right = k - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
        left = k;
        right = n - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
        return ;
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}