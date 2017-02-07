public class Solution {
    private char[][] pairs = {{'1', '1'}, {'0', '0'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    private int count = 0;
    public int strobogrammaticInRange(String low, String high) {
        if (low == null || high == null) {
            return 0;
        }
        //System.out.println("im here");
        for (int length = low.length(); length <= high.length(); length++) {
            char[] array = new char[length];
            helper(array, 0, length - 1, low, high);
            
        }
        return count;
    }
    
    private void helper(char[] array, int left, int right, String low, String high) {
        if (left > right) {
            String s = new String(array);
            //System.out.println(s);
            if ((s.length() == low.length() && s.compareTo(low) < 0)
                 || s.length() == high.length() && s.compareTo(high) > 0) {
                     return;
                     //System.out.println("im here when s is " + s);
                
            }
            count++;
            return ;
        }
        for (int i = 0; i < pairs.length; i++) {
            char[] pair = pairs[i];
            if (left == 0 && pair[0] == '0' && array.length > 1) {
                
                continue;
            }
            if (left == right && pair[0] != pair[1]) {
                
                continue;
            }
            array[left] = pair[0];
            array[right] = pair[1];
            helper(array, left + 1, right - 1, low, high);
        }
    }
}