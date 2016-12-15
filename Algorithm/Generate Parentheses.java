public class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<String>();
        }
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(result, sb, n, 0, 0);
        return result;
    }
    private void helper(List<String> result, StringBuilder sb, int n, int left, int right) {
        if (left == n && right == n) {
            result.add(sb.toString());
            return;
        }
        if (left > n || right > n) {
            return;
        }
        if (left < right) {
            return;
        }
        sb.append('(');
        helper(result, sb, n, left + 1, right);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(')');
        helper(result, sb, n, left, right + 1);
        sb.deleteCharAt(sb.length() - 1);
    }
}