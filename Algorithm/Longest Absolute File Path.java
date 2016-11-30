public class Solution {
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        int n = input.length();
        String[] array = input.split("\n");
        
        String[] path = new String[array.length];
        int maxLength = 0;
        for (String s : array) {
            StringBuilder sb = new StringBuilder();
            int tabCount = s.lastIndexOf("\t") + 1;
            String currentPos = s.substring(tabCount);
            if (s.contains(".")) {
                for (int i = 0; i < tabCount; i++) {
                    sb.append(path[i]);
                }
                sb.append(currentPos);
            } else {
                path[tabCount] = currentPos + "/";
            }
            maxLength = Math.max(maxLength, sb.length());
        }
        return maxLength;
    }
}