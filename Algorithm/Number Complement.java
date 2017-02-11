public class Solution {
    public int findComplement(int num) {
        int result = 0;
        int move = 0;
        while (num > 0) {
            int bit = 1 - (num & 1);
            result |= bit << (move++);
            num >>= 1;
        }
        return result;
    }
}