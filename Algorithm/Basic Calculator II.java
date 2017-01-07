public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (Character.isDigit(current)) {
                num = num * 10 + current - '0';
            }
            if ((!Character.isDigit(current) && current != ' ') || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                sign = current;
            }
        }
        int result = 0;
        for (int i : stack) {
            result += i;
        }
        return result;
    }
}