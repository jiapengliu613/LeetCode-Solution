public class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] map = new int[26];
        int max = 0;
        int start = 0, end = 0;
        int maxLength = 0;
        for (; end < s.length(); end++) {
            
            max = Math.max(max, ++map[s.charAt(end) - 'A']);
            //System.out.print(max + " ");
            if (max + k >= end - start + 1) {
                maxLength = Math.max(maxLength, end - start + 1);
                continue;
            }
            map[s.charAt(start) - 'A']--;
            start++;
            
            
        }
        return maxLength;
    }
}