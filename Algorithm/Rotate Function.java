public class Solution {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int sum = 0, F = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            F += i * A[i];
        }
        int result = F;
        for (int i = n - 1; i > 0; i--) {
            F = F - sum + n * (A[n - 1 - i]);
            result = Math.max(result, F);
        }
        return result;
        /* TLE
        int n = A.length;
        int rotation = 0;
        int result = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            int current = findSum(i, A);
            result = Math.max(result, current);
        }
        return result;
    }
    private int findSum(int rotation, int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num * (rotation % nums.length);
            rotation++;
        }
        return sum;
        */
    }
}