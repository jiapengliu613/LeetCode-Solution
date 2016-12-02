public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{') {
                stack.push(cur);
                continue;
            }
            if (cur == ')' && !stack.isEmpty()) {
                if (stack.peek() == '(') {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }
            if (cur == ']' && !stack.isEmpty()) {
                if (stack.peek() == '[') {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }
            if (cur == '}' && !stack.isEmpty()) {
                if (stack.peek() == '{') {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}