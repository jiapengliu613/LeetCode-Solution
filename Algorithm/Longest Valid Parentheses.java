public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int n = s.length();
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
                continue;
            }
            if (stack.isEmpty()) {
                continue;
            }
            if (stack.peek() == 0) {
                dp[i] = i + 1;
                stack.pop();
            } else {
                int pos = stack.pop();
                dp[i] = 2 + dp[i - 1] + dp[pos - 1];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
        
        
        /* TLE O(n^2) SOlution
        if (s == null || s.length() < 2) {
            return 0;
        }
        int n = s.length();
        int result = 0;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) == '(') {
                dp[0][i] = dp[0][i - 1] + 1;
            } else {
                dp[0][i] = dp[0][i - 1] - 1;
            }
            if (dp[0][i] < 0) {
                break;
            } else if (dp[0][i] == 0) {
                result = Math.max(result, i);
            }
        }
        for (int i = 1; i <= n; i++) {
            dp[i][i] = s.charAt(i - 1) == '(' ? 1 : - 1;
        }
        for (int i = 1; i <= n; i++) {
            
            for (int j = i; j <= n; j++) {
                if (j == i) {
                    if (dp[i][j] < 0) {
                        break;
                    }
                }
                if (s.charAt(j - 1) == '(') {
                    dp[i][j] = dp[i][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1] - 1;
                }
                if (dp[i][j] == 0) {
                    result = Math.max(result, j - i + 1);
                } else if (dp[i][j] < 0) {
                    break;
                }
            }

        }
        return result;
        */
    }
}