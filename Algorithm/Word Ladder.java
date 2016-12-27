public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0 || wordList == null || wordList.size() == 0) {
            return 0;
        }
        int step = 1, lastNum = 1, curNum = 0;
        Deque<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            for (int i = 0; i < current.length(); i++) {
                char[] array = current.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    array[i] = c;
                    String newStr = new String(array);
                    if (endWord.equals(newStr)) {
                        return step + 1;
                    }
                    if (wordList.contains(newStr) && !visited.contains(newStr)) {
                        curNum++;
                        visited.add(newStr);
                        queue.offer(newStr);
                    }
                }
            }
            lastNum--;
            if (lastNum == 0) {
                step++;
                lastNum = curNum;
                curNum = 0;
            }
        }
        return 0;
        
        
    }
}