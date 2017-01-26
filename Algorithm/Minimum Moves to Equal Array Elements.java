public class Solution {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int minValue = Integer.MAX_VALUE;
        for (int num : nums) {
            minValue = Math.min(minValue, num);
        }
        int moves = 0;
        for (int num : nums) {
            moves += num - minValue;
        }
        return moves;
    }
}