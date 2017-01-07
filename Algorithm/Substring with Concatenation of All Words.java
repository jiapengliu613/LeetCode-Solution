public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || s.length() < words.length || s.length() < words.length * words[0].length()) {
            return result;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (String  word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        int m = words[0].length();
        for (int i = 0; i < m; i++) {
            int count = 0;
            HashMap<String, Integer> copy = new HashMap<>();
            int left = i;
            for (int right = i; right <= s.length() - words[0].length(); right += words[0].length()) {
                String current = s.substring(right, right + words[0].length());
                if (!map.containsKey(current)) {
                    left = right + words[0].length();
                    count = 0;
                    copy.clear();
                    continue;
                }
                copy.put(current, copy.containsKey(current) ? copy.get(current) + 1 : 1);
                if (copy.get(current) <= map.get(current)) {
                    count++;
                } else {
                    while (copy.get(current) > map.get(current)) {
                        String tmp = s.substring(left, left + words[0].length());
                        copy.put(tmp, copy.get(tmp) - 1);
                        if (copy.get(tmp) < map.get(tmp)) {
                            count--;
                        }
                        if (copy.get(tmp) == 0) {
                            copy.remove(tmp);
                        }
                        left += words[0].length();
                         
                        
                    }
                }
                if (count == words.length) {
                    result.add(left);
                    String tmp = s.substring(left, left + words[0].length());
                    copy.put(tmp, copy.get(tmp) - 1);
                    if (copy.get(tmp) == 0) {
                        copy.remove(tmp);
                    }
                    left += words[0].length();
                    count--;
                }
                
            }
        }
        return result;
    }
}