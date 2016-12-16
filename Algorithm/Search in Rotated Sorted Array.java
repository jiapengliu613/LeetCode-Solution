public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int start = 0, end = n - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[end]) {
                if (nums[mid] < nums[end] || nums[mid] > target) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (nums[mid] > target && nums[mid] < nums[end]) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}