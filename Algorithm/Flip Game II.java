public class Solution {
    public boolean canWin(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        Map<String, Boolean> map = new HashMap<>();
        return helper(map, s);
    }
    
    private boolean helper(Map<String, Boolean> map, String s) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                StringBuilder sb = new StringBuilder();
                sb.append(s.substring(0, i - 1));
                sb.append('-').append('-');
                sb.append(s.substring(i + 1));
                if (isValid(sb) || !helper(map, sb.toString())) {
                    map.put(new String(s), true);
                    return true;
                }
            }
        }
        map.put(new String(s), false);
        return false;
    }
    private boolean isValid(StringBuilder sb) {
        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i) == '+' && sb.charAt(i - 1) == '+') {
                return false;
            }
        }
        return true;
    }
}