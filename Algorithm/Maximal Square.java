public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            result = Math.max(result, dp[i][0]);
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
            result = Math.max(result, dp[0][i]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    int length = (int)Math.sqrt(Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])));
                    dp[i][j] = (length + 1) * (length + 1);
                    result = Math.max(dp[i][j], result);
                }
                //System.out.print(dp[i][j] + " ");
            }
            //System.out.println();
        }
        return result;
    }
}