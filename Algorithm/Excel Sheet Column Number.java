public class Solution {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            result = 26 * result + cur - 'A' + 1;
        }
        return result;
    }
}