public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() == 0) {
            return true;
        }
        if (s1.length() == 1) {
            return s1.charAt(0) == s2.charAt(0);
        }
        //StringBuilder sb1 = new StringBuilder();
        //StringBuilder sb2 = new StringBuilder();
        int[] chars = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i) - 'a']++;
            chars[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (chars[i] != 0) {
                return false;
            }
        }
        int n = s1.length();
        boolean result = false;
        for (int i = 1; i < s1.length(); i++) {
            result |= isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i));
            result |= isScramble(s1.substring(0, i), s2.substring(n - i)) && isScramble(s1.substring(i), s2.substring(0, n - i));
            if (result == true) {
                return result;
            }
        }
        return false;
    }
}