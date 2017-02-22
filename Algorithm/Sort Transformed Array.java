public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n];
        
        //double axis = - b / (2 * a);
        int left = 0, right = n - 1;

        for (int i = 0; i < n; i++) {
            int leftRes = calc(nums, a, b, c, left);
            int rightRes = calc(nums, a, b, c ,right);
            if (a > 0) {
                if (leftRes >= rightRes) {
                    result[i] = leftRes;
                    left++;
                } else {
                    result[i] = rightRes;
                    right--;
                }
            } else {
                if (leftRes < rightRes) {
                    result[i] = leftRes;
                    left++;
                } else {
                    result[i] = rightRes;
                    right--;
                }
            }
        }
        if (a > 0) {
            reverse(result);
        }
        return result;
    }
    
    private int calc(int[] nums, int a, int b, int c, int i) {
        return a * nums[i] * nums[i] + b * nums[i] + c;
    }
    
    private void reverse(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}