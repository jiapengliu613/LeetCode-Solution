public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) {
            return;
        }
        int n = matrix.length;
        helper(matrix, n, 0);
    }
    private void helper(int[][] matrix, int n, int offset) {
        if (offset >= n / 2) {
            return;
        }
        for (int i = offset; i < n - offset - 1; i++) {
            int tmp = matrix[offset][i];
            matrix[offset][i] = matrix[n - 1 - i][offset];
            matrix[n - 1 - i][offset] = matrix[n - 1 - offset][n - 1 - i];
            matrix[n - 1 - offset][n - 1 - i] = matrix[i][n - 1 - offset];
            matrix[i][n - 1 - offset] = tmp;
        }
        helper(matrix, n, offset + 1);
    }
}