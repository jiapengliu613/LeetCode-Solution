public class Solution {
    public void reverseWords(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }
        int start = 0, end = s.length - 1;
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
        start = 0;
        end = 0;
        while (end < s.length) {
            while (end < s.length && s[end] != ' ') {
                end++;
            }
            swap(s, start, end - 1);
            start = end + 1;
            end++;
        }
    }
    
    private void swap(char[] s, int start, int end) {
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}