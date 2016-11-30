public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int slow = 0, fast = 0;
        int maxLength = 1;
        for (fast = 0; fast < s.length(); fast++) {
            if (map.containsKey(s.charAt(fast))) {
                slow = Math.max(slow, map.get(s.charAt(fast)) + 1);
            }
            map.put(s.charAt(fast), fast);
            maxLength = Math.max(maxLength, fast - slow + 1);
        }
        return maxLength;
    }
}