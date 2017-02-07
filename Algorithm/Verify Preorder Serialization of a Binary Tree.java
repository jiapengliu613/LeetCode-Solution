public class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return true;
        }
        if (preorder.charAt(0) == '#' && preorder.length() > 1) {
            return false;
        }
        String[] array = preorder.split(",");
        int diff = 1;
        for (String s : array) {
            diff -= 1;
            if (diff < 0) {
                return false;
            }
            if (!s.equals("#")) {
                diff += 2;
            }
            
        }
        return diff == 0;
    }
}