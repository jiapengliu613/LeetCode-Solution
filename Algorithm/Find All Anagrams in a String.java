public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() < p.length()) {
            return result;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        int n = p.length();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }
            if (i >= n - 1) {
                if (map.size() == 0) {
                    result.add(i - (n - 1));
                }
                //System.out.println(map.entrySet());
                map.put(s.charAt(i - (n - 1)), map.getOrDefault(s.charAt(i - (n - 1)), 0) + 1);
                if (map.get(s.charAt(i - (n - 1))) == 0) {
                    map.remove(s.charAt(i - (n - 1)));
                }
            }
            
        }
        return result;
    }
}