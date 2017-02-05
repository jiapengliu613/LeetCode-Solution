public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int count = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int start = i + 1, end = n - 1;
            int newTarget = target - nums[i];
            count += find2Sum(nums, start, end, newTarget);
        }
        return count;
    }
    
    private int find2Sum(int[] nums, int start, int end, int target) {
        int count = 0;
        while (start < end) {
            if (nums[start] + nums[end] < target) {
                count +=end - start;
                start++;
            } else {
                end--;
            }
        }
        return count;
    }
}