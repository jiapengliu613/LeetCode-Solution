public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        int first = 0;
        int i;
        for (i = n - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                first = i - 1;
                break;
            }
        }
        if (i == 0) {
            reverse(nums, 0, n - 1);
            return;
        }
        int second = 0;
        for (i = n - 1; i > first; i--) {
            if (nums[i] > nums[first]) {
                second = i;
                break;
            }
        }
        //System.out.println(first + " " + second);
        swap(nums, first, second);
        reverse(nums, first + 1, n - 1);
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}