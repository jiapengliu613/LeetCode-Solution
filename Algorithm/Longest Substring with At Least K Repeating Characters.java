public class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() < k) {
            return 0;
        }
        return helper(s, 0, s.length() - 1, k);
        
    
    }
    private int helper(String s, int left, int right, int k) {
        if (right - left + 1 < k) {
            return 0;
        }
        int[] map = new int[26];
        for (int i = left; i <= right; i++) {
            map[s.charAt(i) - 'a']++;
        }
        int index = left;
        for (int i = left; i <= right; i++) {
            if (map[s.charAt(i) - 'a'] >= k) {
                continue;
            }
            return Math.max(helper(s, left, i - 1, k), helper(s, i + 1, right, k));
        }
        return right - left + 1;
    }
}