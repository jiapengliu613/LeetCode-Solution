public class Solution {
    public int countSegments(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        String[] array = s.split(" ");
        for (String current : array) {
            if (current.length() > 0) {
                result++;
            }
        }
        return result;
    }
}