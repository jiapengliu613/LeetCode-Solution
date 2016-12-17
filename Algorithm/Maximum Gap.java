public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null ||nums.length <= 1) {
            return 0;
        }
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        int[] minGap = new int[n - 1];
        int[] maxGap = new int[n - 1];
        Arrays.fill(minGap, Integer.MAX_VALUE);
        Arrays.fill(maxGap, Integer.MIN_VALUE);
        for (int num : nums) {
            if (num == min || num == max) {
                continue;
            }
            int idx = (num - min) / gap;
            minGap[idx] = Math.min(num, minGap[idx]);
            maxGap[idx] = Math.max(num, maxGap[idx]);
        }
        int prev = min;
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            if (minGap[i] == Integer.MAX_VALUE && maxGap[i] == Integer.MIN_VALUE) {
                continue;
            }
            result = Math.max(result, minGap[i] - prev);
            prev = maxGap[i];
        }
        result = Math.max(result, max - prev);
        return result;
    }
    
}