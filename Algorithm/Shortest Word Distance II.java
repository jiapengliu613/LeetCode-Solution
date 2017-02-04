public class WordDistance {
    private Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        if (words == null || words.length <= 1) {
            return;
        }
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.computeIfAbsent(words[i], k -> new ArrayList<Integer>()).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        int distance = Integer.MAX_VALUE;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            int index1 = list1.get(i);
            int index2 = list2.get(j);
            if (index1 > index2) {
                distance = Math.min(distance, index1 - index2);
                j++;
            } else {
                distance = Math.min(distance, index2 - index1);
                i++;
            }
        }
        return distance;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */