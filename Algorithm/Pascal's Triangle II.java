public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if (rowIndex < 0) {
            return result;
        }
        int[] dp = new int[rowIndex + 1];
        dp[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            int index = i;
            dp[index] = 1;
            index--;
            while (index > 0) {
                dp[index] = dp[index] + dp[index - 1];
                index--;
            }
        }
        for (int i : dp) {
            result.add(i);
        }
        return result;
    }
}