public class Solution {
    public String countAndSay(int n) {
        if (n == 0) {
            return "";
        }
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        for (int i = 2; i <= n; i++) {
            String cur = sb.toString();
            sb = new StringBuilder();
            int pos = 0;
            while (pos < cur.length()) {
                int count = 0;
                char curPos = cur.charAt(pos);
                while (pos < cur.length() && cur.charAt(pos) == curPos) {
                    count++;
                    pos++;
                }
                sb.append(count).append(curPos);
            }
        }
        return sb.toString();
    }
}