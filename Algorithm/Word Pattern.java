public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || pattern.length() == 0 || str == null || str.length() == 0) {
            return false;
        }
        String[] array = str.split(" ");
        if (array.length != pattern.length()) {
            return false;
        }
        Map<String, Integer> strMap = new HashMap<>();
        int[] patMap = new int[26];
        Arrays.fill(patMap, Integer.MIN_VALUE);
        for (int i = 0; i < array.length; i++) {
            char curPat = pattern.charAt(i);
            String curStr = array[i];
            if (patMap[curPat - 'a'] == Integer.MIN_VALUE && !strMap.containsKey(curStr)) {
                patMap[curPat - 'a'] = i;
                strMap.put(curStr, i);
            } else {
                if (!strMap.containsKey(curStr) || patMap[curPat - 'a'] != strMap.get(curStr)) {
                    return false;
                }
            }
        }
        return true;
    }
}