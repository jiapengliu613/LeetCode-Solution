public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if (word.length() == 0 && abbr.length() == 0) {
            return true;
        }
        int count = 0, pos = 0;
        for (int i = 0; i < abbr.length(); i++) {
            char c = abbr.charAt(i);
            if (Character.isDigit(c)) {
                if (i == 0 && c == '0') {
                    return false;
                }
                if (i > 0 && c == '0' && (abbr.charAt(i - 1) <= '0' || abbr.charAt(i - 1) > '9')) {
                    //System.out.println("im here");
                    return false;
                }
                count = count * 10 + c - '0';
            } else {
                pos += count;
                
                if (pos >= word.length() || c != word.charAt(pos)) {
                    return false;
                }
                count = 0;
                pos++;
            }
        }
        
        return pos + count == word.length();
        
    }
}