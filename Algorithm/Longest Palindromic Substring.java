public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (i + 1 == j) {
                    isPalindrome[i][j] = s.charAt(i) == s.charAt(j); 
                } else {
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1]);
                }
            }
        }
        //System.out.println(isPalindrome[0][3]);
        int globalMax = 0;
        String result = "";
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome[i][j] == true && j - i + 1 > globalMax) {
                    globalMax = j - i + 1;
                    result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }
}