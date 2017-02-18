public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 2) {
            return result;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '+' || s.charAt(i - 1) != '+') {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(0, i - 1)).append('-').append('-').append(s.substring(i + 1));
            result.add(sb.toString());
        }
        return result;
    }
}