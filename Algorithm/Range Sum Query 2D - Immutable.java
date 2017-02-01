public class NumMatrix {
    int[][] dp;
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m + 1][n + 1];
        //dp[1][1] = matrix[0][0];
        for (int i = 1; i <= m; i++) {
            dp[i][1] = dp[i - 1][1] + matrix[i - 1][0];
        }
        for (int i = 1; i <= n; i++) {
            dp[1][i] = dp[1][i - 1] + matrix[0][i - 1];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = matrix[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 > row2 || col1 > col2) {
            return 0;
        }
        int sum = dp[row2 + 1][col2 + 1];
        sum -= dp[row1][col2 + 1];
        sum -= dp[row2 + 1][col1];
        sum += dp[row1][col1];
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */