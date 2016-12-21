public class Solution {
    public String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            char current = (char)('A' + n % 26);
            sb.insert(0, current);
            n = n / 26;
        }
        return sb.toString();
    }
}