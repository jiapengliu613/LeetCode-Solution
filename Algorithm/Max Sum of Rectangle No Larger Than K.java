public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int[] prefix = new int[m];
            for (int j = i; j < n; j++) {
                TreeSet<Integer> set = new TreeSet<>();
                int val = 0;
                set.add(0);
                for (int row = 0; row < m; row++) {
                    prefix[row] += matrix[row][j];
                    val += prefix[row];
                    Integer remaining = set.ceiling(val - k);
                    if (remaining != null) {
                        result = Math.max(result, val - remaining);
                    }
                    set.add(val);
                }
                
            }
        }
        return result;
    }
}