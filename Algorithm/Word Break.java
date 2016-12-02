public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.isEmpty()) {
            return false;
        }
        int maxLen = 0;
        for (String str : wordDict) {
            if (str.length() > maxLen) {
                maxLen = str.length();
            }
        }
        int n = s.length();
        // check whether the first i characters of s can be broken
        boolean[] dp = new boolean[n + 1];
        
        dp[0] = true;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i && j <= maxLen; j++) {
                if (dp[i - j] == false) {
                    continue;
                } 
                if (wordDict.contains(s.substring(i - j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}