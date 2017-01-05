public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "/";
        }
        int index = path.length() - 1;
        while (index >= 0 && path.charAt(index) == '/') {
            index--;
        }
        
        path = path.substring(0, index + 1);
        if (path.length() == 0) {
            return "/";
        }
        String[] array = path.split("/");
        
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(".") || array[i].length() == 0) {
                continue;
            } else if (array[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(array[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, '/');
        }
        
        return sb.length() == 0 ? "/" : sb.toString();
    }
}