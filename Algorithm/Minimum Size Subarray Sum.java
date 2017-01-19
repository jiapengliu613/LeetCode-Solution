public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (s == 0 || nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int slow = 0, fast = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        while (fast < n) {
            while (fast < n && sum < s) {
                sum += nums[fast];
                fast++;
            }
            if (sum < s) {
                break;
            }
            result = Math.min(result, fast - slow);
            while (sum >= s) {
                result= Math.min(result, fast - slow);
                sum -= nums[slow++];
            }
            /*
            sum += nums[fast];
            fast++;
            while (sum >= s) {
                result = Math.min(result, fast - slow);
                sum -= nums[slow];
                slow++;
                
            }
            */
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}