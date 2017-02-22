public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map.put(C[i] + D[j], map.getOrDefault(C[i] + D[j], 0) + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int target = 0 - A[i] - B[j];
                if (map.containsKey(target)) {
                    count += map.get(target);
                }
            }
        }
        return count;
    }
}