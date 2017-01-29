public class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Deque<String> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int count = 0;
        while (i < s.length()) {
            //System.out.print(i + " ");
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                count = 10 * count + c - '0';
            } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                sb.append(c);
            }  else if (c == '[') {
                stack1.push(sb.toString());
                stack2.push(count);
                sb = new StringBuilder();
                count = 0;
            } else if (c == ']') {
                
                StringBuilder current = new StringBuilder(stack1.pop());
                for (int j = 0; j < stack2.peek(); j++) {
                    current.append(sb.toString());
                }
                System.out.print(current.toString());
                stack2.pop();
                sb = new StringBuilder(current.toString());
            }
            i++;
        }
        return sb.toString();
        
        
        /*
        if (s == null || s.length() == 0) {
            return s;
        }
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        helper(sb, s, 0, 0);
        return sb.toString();
    }
    private void helper(StringBuilder sb, String s, index, level) {
        if (index == s.length() || level == 0) {
            return ;
        }
        */
    }
}