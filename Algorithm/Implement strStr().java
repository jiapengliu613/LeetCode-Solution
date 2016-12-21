public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || haystack == null || haystack.length() < needle.length()) {
            return -1;
        }
        
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int pos = i, j = 0;
            while (j < needle.length()) {
                if (haystack.charAt(pos) != needle.charAt(j)) {
                    break;
                }
                j++;
                pos++;
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}