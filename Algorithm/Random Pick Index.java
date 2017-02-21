public class Solution {
    Random rand;
    int[] nums;
    public Solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ;
        }
        //Arrays.sort(nums);
        rand = new Random();
        this.nums = nums;
        
    }
    
    public int pick(int target) {
        int result = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                continue;
            }
            if (rand.nextInt(++count) == 0) {
                result = i;
            }
        }
        return result;
        /*TLE Solution
        int start = 0, end = nums.length - 1;
        //find most left target
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        int left = nums[start] == target ? start : end;
        // find most right target
        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        int right = nums[end] == target ? end : start;
        //System.out.println(left + " " + right);
        if (left == right) {
            return left;
        } else {
            return rand.nextInt(right - left) + left;
        }
        */
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */