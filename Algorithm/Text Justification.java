public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }
        int start = 0, end = 0;
        
        //StringBuilder sb = new StringBuilder();
        //int[] pos = new int[maxWidth];
        while (end < words.length) {
            int curLen = 0;
            while (end < words.length && curLen + words[end].length() + end - start <= maxWidth) {
                curLen += words[end].length();
                end++;
            }
           // System.out.println(end + " " + curLen);
            int diff = end - 1 - start;
            StringBuilder sb = new StringBuilder();
            
            if (diff == 0 || end == words.length) {
                for (int i = start; i < end; i++) {
                    sb.append(words[i]).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                for (int i = sb.length(); i < maxWidth; i++) {
                    sb.append(" ");
                }
            } else {
                
                int spaces = (maxWidth - curLen) / diff;
                int spacesLeft = (maxWidth - curLen) % diff;
                //System.out.println(spaces + " " + spacesLeft);
                for (int i = start; i < end; i++) {
                    sb.append(words[i]);
                    if (i < end - 1) {
                        for (int j = 0; j < spaces; j++) {
                            sb.append(" ");
                        }
                        if (spacesLeft > 0) {
                            sb.append(" ");
                            spacesLeft--;
                        }
                    }
                }
                
            }
            
            result.add(sb.toString());
            start = end;
        }
        return result;
    }
}