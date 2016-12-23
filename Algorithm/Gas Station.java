public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length) {
            return -1;
        }
        /* TLE
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int residual = 0;
            int j = 0;
            for (; j < n; j++) {
                residual += gas[(i + j) % n] - cost[(i + j) % n];
                if (residual < 0) {
                    break;
                }
            }
            if (j == n) {
                return i;
            }
        }
        return -1;
        */
        int n = gas.length, needed = 0, residual = 0, start = 0;
        for (int i = 0; i < n; i++) {
            residual += gas[i] - cost[i];
            if (residual < 0) {
                needed += residual;
                start = i + 1;
                residual = 0;
            }
        }
        return needed + residual >= 0 ? start : -1;
    }
}