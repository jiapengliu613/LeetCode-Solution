public class Solution {
    
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) {
            return true;
        }
        int[] map = new int[10];
        map[0] = 0;
        map[1] = 1;
        map[6] = 9;
        map[8] = 8;
        map[9] = 6;
        if (num.length() > 1 && num.charAt(0) == 0) {
            return true;
        }
        int start = 0, end = num.length() - 1;
        while (start <= end) {
            int left = num.charAt(start) - '0';
            int right = num.charAt(end) - '0';
            if (map[left] != right || map[right] != left) {
                return false;
            }
            if (start == end && map[left] != map[right]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}