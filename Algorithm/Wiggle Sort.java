public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return ;
        }
        int n = nums.length;
        boolean even = true;
        for (int i = 1; i < nums.length; i++) {
            if (even == true) {
                if (nums[i] < nums[i - 1]) {
                    int tmp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = tmp;
                }
            } else {
                if (nums[i] > nums[i - 1]) {
                    int tmp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = tmp;
                }
            }
            even = !even;   

        }
    }
}