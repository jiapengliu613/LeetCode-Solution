public class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                degree.put(s.charAt(i), 0);
            }
        }
        for (int j = 0; j < words.length - 1; j++) {
            String cur = words[j];
            String next = words[j + 1];
            int length = Math.min(cur.length(), next.length());
            int i;
            for (i = 0; i < length; i++) {
                if (cur.charAt(i) == next.charAt(i)) {
                    continue;
                }
                Set<Character> set = new HashSet<>();
                if (map.containsKey(cur.charAt(i))) {
                    set = map.get(cur.charAt(i));
                }
                if (!set.contains(next.charAt(i))) {
                    set.add(next.charAt(i));
                    map.put(cur.charAt(i), set);
                    degree.put(next.charAt(i), degree.get(next.charAt(i)) + 1);
                    
                }
                break;
            }
            if (i == length && cur.length() > next.length()) {
                return "";
            }
        }
        StringBuilder sb = new StringBuilder();
        Deque<Character> queue = new ArrayDeque<>();
        //
        for (char c : degree.keySet()) {
            if (degree.get(c) == 0) {
                queue.offer(c);
            }
        }
        System.out.println(queue.size());
        while (!queue.isEmpty()) {
            
            char c = queue.poll();
            sb.append(c);
            if (map.containsKey(c)) {
                
                for (char tmp : map.get(c)) {
                    degree.put(tmp, degree.get(tmp) - 1);
                    if (degree.get(tmp) == 0){
                        queue.offer(tmp);    
                    }
                    
                }
            }
        }
        
        return sb.length() == degree.size() ? sb.toString() : "";
    }
}