public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int move = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            move <<= 1;
        }
        return m * move;
    }
}