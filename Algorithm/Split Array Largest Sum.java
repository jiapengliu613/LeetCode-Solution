public class Solution {
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        long max = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if (m == 1) {
            return (int)sum;
        }
        long left = max, right = sum;
        while (left + 1 < right) {
            long mid = (left + right) / 2;
            if (canDivide(mid, nums, m)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (canDivide(left, nums, m)) {
            return (int)left;
        } else {
            return (int)right;
        }
    }
    
    private boolean canDivide(long target, int[] nums, int m) {
        int count = 1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > target) {
                sum = num;
                count++;
            }
            if (count > m) {
                return false;
            }
        }
        return true;
    }
}