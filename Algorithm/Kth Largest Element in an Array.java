public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || k > nums.length) {
            return Integer.MAX_VALUE;
        }
        helper(nums, k, 0, nums.length - 1);
        return nums[k - 1];
    }
    private void helper(int[] nums, int k, int left, int right) {
        if (left >= right) {
            return ;
        }
        int kthPos = quickSort(nums, left, right);
        if (kthPos == k - 1) {
            return ;
        } else if (kthPos > k - 1) {
            helper(nums, k, left, kthPos);
        } else {
            helper(nums, k , kthPos + 1, right);
        }
    }
    private int quickSort(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] <= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] >= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}