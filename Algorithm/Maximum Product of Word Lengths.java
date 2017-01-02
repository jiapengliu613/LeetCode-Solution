public class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length < 2) {
            return 0;
        }
        int n = words.length;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                array[i] |= 1 << c - 'a';
            }
        }
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((array[i] & array[j]) == 0) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }
}