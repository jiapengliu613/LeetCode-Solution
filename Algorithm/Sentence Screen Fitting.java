public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        
        //*** start records : up to the end of current row, how many chars in is can be displayed on the screen
        int start = 0;
        int n = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            // this means that at the end of current line is a whitespace so it can be ignored
            if (s.charAt(start % n) == ' ') {
                start++;
            } else {
                // this means that at the end of current line is a char in s, so it cannot be displayed in the current line
                while (start > 0 && s.charAt((start - 1) % n) != ' ') {
                    start--;
                }
            }
        }
        return start / n;
        /* TLE solution
        for (String s : sentence) {
            if (s.length() > cols) {
                return 0;
            }
        }
        int count = 0;
        int index = 0;
        int left = cols;
        for (int i = 0; i < rows; i++) {
            while (left >= sentence[index].length()) {
                left = left - (sentence[index++].length() + 1);
                if (index == sentence.length) {
                    index = 0;
                    count++;
                }
            }
            left = cols;
        }
        return count;
        */
    }
}