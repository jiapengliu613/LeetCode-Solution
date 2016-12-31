public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        int result = 0;
        int pos = s.length() - 1;
        while (pos >= 0 && s.charAt(pos) != ' ') {
            pos--;
            result++;
        }
        return result;
    }
}