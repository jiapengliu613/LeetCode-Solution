public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        
        helper(s, result, 0, 0, new char[]{'(', ')'});
        return result;
    }
    private void helper(String s, List<String> result, int last_i, int last_j, char[] par) {
        for (int i = last_i, stack = 0; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) {
                stack++;
            }
            if (s.charAt(i) == par[1]) {
                stack--;
            }
            if (stack >= 0) {
                continue;
            }
            for (int j = last_j; j <= i; j++) {
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1])) {
                    helper(s.substring(0, j) + s.substring(j + 1), result, i, 0, par);
                }
            }
            return ;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') {
            helper(reversed, result, 0, 0, new char[]{')', '('});
        } else {
            result.add(reversed);
        }
    }
   
}