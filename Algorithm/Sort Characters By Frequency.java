public class Solution {
    public String frequencySort(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        List<String>[] freq = new List[n + 1];
        for (char c : map.keySet()) {
            int count = map.get(c);
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= count; i++) {
                    sb.append(c);
            }
            if (freq[count] == null) {
                List<String> current = new ArrayList<>();
                current.add(sb.toString());
                freq[count] = current;
            } else {
                freq[count].add(sb.toString());
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = n; i >= 0; i--) {
            if (freq[i] != null) {
                for (String tmp : freq[i]) {
                    result.append(tmp);
                }
            }
        }
        return result.toString();
        /* PQ O(nlog(n)) Solution
        PriorityQueue<Character> pq = new PriorityQueue<>(n, new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
               return map.get(c2) - map.get(c1);
            }
        });
        for (char c : map.keySet()) {
            pq.offer(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            int count = map.get(c);
            for (int i = 1; i <= count; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
        */
    }
}