public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0 | wordDict == null || wordDict.size() == 0) {
            return result;
        }
        for (String str : wordDict) {
            maxLength = Math.max(maxLength, str.length());
        }
        boolean[] invalid = new boolean[s.length()];
        StringBuilder sb = new StringBuilder();
        helper(result, s, wordDict, sb, 0, invalid);
        return result;
    }
    int maxLength = 0;
    private boolean helper(List<String> result, String s, Set<String> wordDict, StringBuilder sb, int offset, boolean[] invalid) {
        if (offset == s.length()) {
            result.add(sb.toString().trim());
            return true;
        }
        boolean breakable = false;
        int sbLen = sb.length();
        for (int i = offset + 1; i <= s.length() && i - offset <= maxLength; i++) {
            if (i != s.length() && invalid[i]) {
                continue;
            }
            if (!wordDict.contains(s.substring(offset, i))) {
                continue;
            }
            sb.append(s.substring(offset, i)).append(" ");
            //System.out.println(sb.toString());
            breakable |= helper(result, s, wordDict, sb, i, invalid);
            sb.setLength(sbLen);
        }
        invalid[offset] = !breakable;
        return breakable;
    }
}