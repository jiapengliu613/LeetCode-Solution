public class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows == 0 || numRows == 1) {
            return s;
        }
        
        int n = s.length();
        boolean isEvenRow = true;
        boolean isEvenCol = true;
        int pos = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            pos = i;
            isEvenCol = true;
            while (pos < n) {
                    sb.append(s.charAt(pos));
                    if (i == 0 || i == numRows - 1) {
                        pos += 2 * numRows - 2;
                    } else {
                        if (isEvenCol) {
                            pos += 2 * (numRows - (i + 1));
                        } else {
                            pos += 2 * i;
                        }
                        isEvenCol = !isEvenCol;
                    }
                    
            }
            //System.out.println(sb.toString() + pos);
        }
        
        
        
        
        return sb.toString();
    }
}