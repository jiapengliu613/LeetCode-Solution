public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }
        int n = num.length();
        StringBuilder sb = new StringBuilder();
        helper(result, num, sb, target, 0, 0, 0);
        return result;
    }
    private void helper(List<String> result, String num, StringBuilder sb, int target, int index, long currentVal, long prevVal) {
        if (index == num.length()) {
            if (target == currentVal) {
                result.add(sb.toString());
            }
            return ;
        }
        for (int i = index; i < num.length(); i++) {
            if (i > index && num.charAt(index) == '0') {
                break;
            }
            Long current = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                int length = sb.length();
                helper(result, num, sb.append(current), target, i + 1, current, current);
                sb.setLength(length);
            } else {
                int length = sb.length();
                helper(result, num, sb.append("+").append(current), target, i + 1, currentVal + current, current);
                sb.setLength(length);
                helper(result, num, sb.append("-").append(current), target, i + 1, currentVal - current, -current);
                sb.setLength(length);
                helper(result, num, sb.append("*").append(current), target, i + 1, currentVal - prevVal + prevVal * current, current * prevVal);
                sb.setLength(length);
            }
        }
    }
}