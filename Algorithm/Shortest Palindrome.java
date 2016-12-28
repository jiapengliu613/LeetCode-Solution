public class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int left = 0, right = s.length() - 1, end = right;
        char[] array = s.toCharArray();
        while (left < right) {
            if (array[left] == array[right]) {
                left++;
                right--;
            } else {
                left = 0;
                end--;
                right = end;
            }
        }
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
    }
}