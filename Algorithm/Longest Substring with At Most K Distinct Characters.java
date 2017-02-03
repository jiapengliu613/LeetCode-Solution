public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || k == 0) {
            return 0;
        }
        if (s.length() <= k) {
            return s.length();
        }
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int fast = 0, slow = 0;
        while (fast < n) {
            char c1 = s.charAt(fast);
            if (!map.containsKey(c1)) {
                map.put(c1, 1);
            } else {
                map.put(c1, map.get(c1) + 1);
            }
            if (map.size() <= k) {
                max = Math.max(max, fast - slow + 1);
                fast++;
                continue;
            }
            while (map.size() > k) {
                char c2 = s.charAt(slow);
                map.put(c2, map.get(c2) - 1);
                if (map.get(c2) == 0) {
                    map.remove(c2);
                }
                slow++;
            }
            fast++;
        }
        return max;
        
        
        
        
        
        /*
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int slow = 0, fast = 0, result = 0;
        while (fast < n) {
            if (fast < k) {
                map.put(s.charAt(fast), map.containsKey(s.charAt(fast)) ? map.get(s.charAt(fast)) + 1 : 1);
            } else if (map.containsKey(s.charAt(fast))) {
                map.put(s.charAt(fast), map.get(s.charAt(fast)) + 1);
            } else {
                while (map.size() >= k) {
                    map.put(s.charAt(slow), map.get(s.charAt(slow)) - 1);
                    if (map.get(s.charAt(slow)) == 0) {
                        map.remove(s.charAt(slow));
                    }
                    slow++;
                }
                map.put(s.charAt(fast), 1);
            }
            result = Math.max(result, fast - slow + 1);
            fast++;
        }
        return result;
        */
    }
}