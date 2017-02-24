public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length + 1];
        if (length == 0) {
            return new int[0];
        }
        for (int[] update : updates) {
            result[update[0]] += update[2];
            result[update[1] + 1] -= update[2];
        }
        for (int i = 1; i <= length; i++) {
            result[i] += result[i - 1];
        }
        return Arrays.copyOfRange(result, 0, length);
    }
}