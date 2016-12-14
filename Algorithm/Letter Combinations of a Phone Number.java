public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        helper(digits, result, sb, 0);
        return result;
    }
    private String[] s = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private void helper(String digits, List<String> result, StringBuilder sb, int idx) {
        if (idx == digits.length()) {
            result.add(sb.toString());
            return;
        }
        int num = digits.charAt(idx) - '0';
        for (int j = 0; j < s[num - 2].length();j++) {
            sb.append(s[num - 2].charAt(j));
            helper(digits, result, sb, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        
    }
}