public class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //System.out.println(s.length());
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        boolean hasOdd = false;
        int total = 0;
        for (char c : map.keySet()) {
            if (map.get(c) % 2 == 0) {
                total += map.get(c);
            } else {
                total += map.get(c) - 1;
                hasOdd = true;
            }
        }
        return total + (hasOdd ? 1 : 0);
    }
}