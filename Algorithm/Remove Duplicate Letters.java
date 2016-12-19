public class Solution {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int[] map = new int[26];
        boolean[] visited = new boolean[26];
        char[] array = s.toCharArray();
        for (char c : array) {
            map[c - 'a']++;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : array) {
            map[c - 'a']--;
            if (visited[c - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && c < stack.peek() && map[stack.peek() - 'a'] > 0) {
                char peak = stack.peek();
                visited[peak - 'a'] = false;
                stack.pop();
                
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}