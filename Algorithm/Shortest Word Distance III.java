public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        boolean flag = true;
        int index1 = -1, index2 = -1;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) && words[i].equals(word2)) {
                if (flag) {
                    index1 = i;
                } else {
                    index2 = i;
                }
                flag = !flag;
            } else if (words[i].equals(word1)) {
                index1 = i;
            } else if (words[i].equals(word2)) {
                index2 = i;
            }
            if (index1 != -1 && index2 != -1) {
                result = Math.min(result, Math.abs(index1 - index2));
            }
        }
        return result;
    }
}