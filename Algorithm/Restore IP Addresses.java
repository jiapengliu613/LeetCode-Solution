public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        helper(s, result, sb, 0, 0);
        return result;
    }
    
    private void helper(String s, List<String> result, StringBuilder sb, int index, int level) {
        int n = s.length();
        if (level == 3) {
            if (isValid(s.substring(index))) {
                sb.append(s.substring(index));
                result.add(sb.toString());
            }
            return ;
        }
        for (int i = 1; i <= 3; i++) {
            if (index + i > s.length()) {
                break;
            }
            if (!isValid(s.substring(index, index + i))) {
                break;
            }
            int length = sb.length();
            sb.append(s.substring(index, index + i)).append(".");
            helper(s, result, sb, index + i, level + 1);
            sb.setLength(length);
        }
        
    }
    private boolean isValid(String s) {
        if (s.length() > 3 || s.length() == 0) {
            return false;
        }
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        int val = Integer.parseInt(s);
        return val >= 0 && val <= 255;
    }
}