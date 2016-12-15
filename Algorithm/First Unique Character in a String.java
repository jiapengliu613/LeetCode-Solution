public class Solution {
    public int firstUniqChar(String s) {
        /* dumb solution
        if (s == null || s.length() == 0) {
            return -1;
        }
        HashMap<Character, Pair> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                Pair p = new Pair(1, i);
                map.put(s.charAt(i), p);
            } else {
                Pair p = map.get(s.charAt(i));
                p.times += 1;
                map.put(s.charAt(i), p);
            }
        }
        int index = -1;
        for (Pair p : map.values()) {
            if (p.times == 1) {
                if (index == -1) {
                    index = p.pos;
                } else {
                    index = Math.min(p.pos, index);
                }
            }
        }
        return index;
    }
    class Pair {
        int times;
        int pos;
        public Pair(int times, int pos) {
            this.times = times;
            this.pos = pos;
        }
        */
        if (s == null) {
            return -1;
        }
        int freq [] = new int[26];
        for (int i = 0; i < s.length(); i ++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i ++) {
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}