public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || A[0].length == 0 || B == null || B.length == 0 || B[0].length == 0) {
            return new int[0][0];
        }
        int m = A.length, n = A[0].length, p = B[0].length;
        Map<Integer, Map<Integer, Integer>> bTable = new HashMap<>();
        for (int i = 0; i < n; i++) {
            bTable.put(i, new HashMap<Integer, Integer>());
            for (int j = 0; j < p; j++) {
                if (B[i][j] != 0) {
                    bTable.get(i).put(j, B[i][j]);
                }
            }
        }
        int[][] result = new int[m][p];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 0) {
                    continue;
                }
                for (Integer k : bTable.get(j).keySet()) {
                    result[i][k] += bTable.get(j).get(k) * A[i][j];
                }
            }
        }
        return result;
    }
}