public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        if (str == null || str.length() <= 1) {
            return false;
        }
        if (str.length() == 2) {
            return str.charAt(0) == str.charAt(1);
        }
        int n = str.length();
        for (int i = 1; i <= str.length() / 2; i++) {
            if (n % i == 0) {
                String pattern = str.substring(0, i);
                int j;
                for (j = i; j < n; j += i) {
                    if (!str.substring(j, j + i).equals(pattern)) {
                        break;
                    }
                }
                if (j >= n) {
                    return true;
                }
            }
        }
        return false;
    }
}