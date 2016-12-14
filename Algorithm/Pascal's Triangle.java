public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        int[][] dp = new int[numRows][numRows];
        
        for (int i = 0; i < numRows; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }
        for (int i = 2; i < numRows; i++) {
            for (int j = 1; j < i;j ++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> currentLevel = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                currentLevel.add(dp[i][j]);
            }
            result.add(currentLevel);
        }
        return result;
    }
}