public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (beginWord == null || endWord == null || wordList == null || beginWord.length() != endWord.length()) {
            return result;
        }
        Map<String, List<String>> neighbors = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        wordList.add(beginWord);
        wordList.add(endWord);
        bfs(wordList, neighbors, distance, beginWord);
        List<String> current = new ArrayList<>();
        dfs(result, beginWord, endWord, distance, neighbors, current);
        return result;
    }
    private void dfs(List<List<String>> result, String beginWord, String endWord, Map<String, Integer> distance, 
        Map<String, List<String>> neighbors, List<String> current) {
        current.add(beginWord);
        if (endWord.equals(beginWord)) {
            result.add(new ArrayList<>(current));
        }
        for (String neighbor : neighbors.get(beginWord)) {
            if (distance.get(neighbor) == distance.get(beginWord) + 1) {
                dfs(result, neighbor, endWord, distance, neighbors, current);
                current.remove(current.size() - 1);
            }
        }
            
    }
    
    private void bfs(Set<String> dict, Map<String, List<String>> neighbors, Map<String, Integer> distance, String beginWord) {
        for (String s : dict) {
            neighbors.put(s, new ArrayList<String>());
        }
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                List<String> next = getNeighbor(current, dict);
                for (String neighbor : next) {
                    neighbors.get(current).add(neighbor);
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, distance.get(current) + 1);
                        queue.offer(neighbor);
                    }
                }
            }
        }
    }
    
    private List<String> getNeighbor(String current, Set<String> dict) {
        List<String> result = new ArrayList<>();
        char[] array = current.toCharArray();
        for (int i = 0; i < current.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != array[i]) {
                    char old_ch = array[i];
                    array[i] = c;
                    if (dict.contains(String.valueOf(array))) {
                        result.add(String.valueOf(array));
                    }
                    array[i] = old_ch;
                }
            }
        } 
        return result;
    }
}