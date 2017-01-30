public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length <= 1) {
            return 0;
        }
        Map<String, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.computeIfAbsent(words[i], k -> new HashSet<Integer>()).add(i);
        }
        int distance = Integer.MAX_VALUE;
        for (int dis1 : map.get(word1)) {
            for (int dis2 : map.get(word2)) {
                distance = Math.min(distance, Math.abs(dis1 - dis2));
            }
        }
        return distance;
    }
}