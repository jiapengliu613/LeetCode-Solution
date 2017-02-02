public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        int[] map = new int[256];
        for (char c : s.toCharArray()) {
            map[c]++;
        }
        int count = 0;
        for (int num : map) {
            if (num % 2 == 1) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}