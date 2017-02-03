public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        helper(word, sb, 0, 0, result);
        return result;
    }
    
    private void helper(String word, StringBuilder sb, int index, int count, List<String> result) {
        if (index == word.length()) {
            result.add(count > 0 ? sb.append(count).toString() : sb.toString());
            return ;
        }
        int length = sb.length();
        helper(word, sb.append((count > 0 ? count : "")).append(word.charAt(index)), index + 1, 0, result);
        sb.setLength(length);
        helper(word, sb, index + 1, count + 1, result);
        
    }
}