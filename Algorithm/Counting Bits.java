public class Solution {
    public int[] countBits(int num) {
        if (num == 0) {
            
            return new int[]{0};
        }
        if (num == 1) {
            return new int[]{0, 1};
        }
        int[] result = new int[num + 1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 1;
        int section = 2;
        for (int i = 3; i <= num; i++) {
            int upBound = section * 2;
            if (i < upBound) {
                result[i] = 1 + result[i - section];
            } else if (i == upBound) {
                section *= 2;
                result[i] = 1;
            }
        }
        return result;
    }
}