public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0 || lower > upper) {
            return 0;
        }
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        return helper(prefix, 0, n, lower, upper);
    }
    private int helper(long[] prefix, int left, int right, int lower, int upper) {
        if (left >= right) {
                return 0;

        }
        int mid = left + (right - left) / 2;
        int count = helper(prefix, left, mid, lower, upper) + helper(prefix, mid + 1, right, lower, upper);
        long[] merged = new long[right - left + 1];
        int lBound = mid + 1, rBound = mid + 1, i = left, j = mid + 1, k = 0;
        while (i <= mid) {
            while (lBound <= right && prefix[lBound] - prefix[i] < lower) {
                lBound++;
            }
            while (rBound <= right && prefix[rBound] - prefix[i] <= upper) {
                rBound++;
            }
            count += rBound - lBound;
            while (j <= right && prefix[j] < prefix[i]) {
                merged[k++] = prefix[j++];
            }
            merged[k++] = prefix[i++];
        }
        while (j <= right) {
            merged[k++] = prefix[j++];
        }
        System.arraycopy(merged, 0, prefix, left, merged.length);
        return count;
    }
}