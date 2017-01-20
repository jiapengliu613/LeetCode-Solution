public class Solution {
    public int minPatches(int[] nums, int n) {
        if (nums == null || n == 0) {
            return 0;
        }
        long bound = 1; 
        int added = 0, i = 0;
        while (bound <= n) {
            if (i < nums.length && nums[i] <= (int)bound) {
                bound += nums[i];
                i++;
            } else {
                added++;
                bound += bound;
            }
        }
        return added;
    }
}