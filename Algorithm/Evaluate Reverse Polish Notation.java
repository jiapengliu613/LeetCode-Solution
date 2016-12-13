public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int c = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                c = a + b;
                stack.push(c);
            } else if (tokens[i].equals("-"))  {
                int a = stack.pop();
                int b = stack.pop();
                c = b - a;
                stack.push(c);
            } else if (tokens[i].equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                c = a * b;
                stack.push(c);
            } else if (tokens[i].equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                c = b / a;
                stack.push(c);
            } else {
                int number = Integer.parseInt(tokens[i]);
                stack.push(number);
                
            }
        }
        return stack.peek();
    }
}