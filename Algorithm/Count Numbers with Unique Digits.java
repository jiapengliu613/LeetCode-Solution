public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int[] dp = new int[11];
        dp[0] = 0;
        dp[1] = 10;
        dp[2] = 9 * 9;
        for (int i = 3; i <= n && i <= 10; i++) {
            dp[i] = dp[i - 1] * (9 - (i - 2));
        }
        int sum = 0;
        for (int num : dp) {
            sum += num;
        }
        return sum;
    }
}