public class Solution {
    private Map<Character, String> map = new HashMap<>();
    private Set<String> set = new HashSet<>();
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null || pattern.length() == 0) {
            return str == null || str.length() == 0;
        }
        if (map.containsKey(pattern.charAt(0))) {
            String current = map.get(pattern.charAt(0));
            if (current.length() > str.length() || !current.equals(str.substring(0, current.length()))) {
                return false;
            }
            return wordPatternMatch(pattern.substring(1), str.substring(current.length()));
            
        } else {
            for (int i = 1; i <= str.length(); i++) {
                String substr = str.substring(0, i);
                if (set.contains(substr)) {
                    continue;
                }
                map.put(pattern.charAt(0), substr);
                set.add(substr);
                if (wordPatternMatch(pattern.substring(1), str.substring(i))) {
                    return true;
                };
                map.remove(pattern.charAt(0));
                set.remove(substr);
            }
        }
        return false;
        
    }
}