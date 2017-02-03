public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int max = 0, index = 0;
        int[] dp = new int[n];
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            parent[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
            //System.out.print(dp[i] + " ");
        }
        while (index != -1) {
            result.add(nums[index]);
            index = parent[index];
        }
        return result;
    }
}