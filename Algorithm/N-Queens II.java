public class Solution {
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] columns = new int[n];
        int[] leftDiag = new int[2 * n - 1];
        int[] rightDiag = new int[2 * n - 1];
        helper(n, columns, leftDiag, rightDiag, 0);
        return count;
    }
    private int count = 0;
    private void helper(int n, int[] columns, int[] leftDiag, int[] rightDiag, int level) {
        if (level == n) {
            count++;
            return ;
        }    
        for (int i = 0; i < n; i++) {
            if (isValid(columns, leftDiag, rightDiag, level, i)) {
                columns[i] = 1;
                leftDiag[n - 1 - i + level] = 1;
                rightDiag[i + level] = 1;
                helper(n, columns, leftDiag, rightDiag, level + 1);
                columns[i] = 0;
                leftDiag[n - 1 - i + level] = 0;
                rightDiag[i + level] = 0;
            }
        }
    }
    private boolean isValid(int[] columns, int[] leftDiag, int[] rightDiag, int row, int col) {
        if (columns[col] == 1 || leftDiag[columns.length - 1 - col + row] == 1 || rightDiag[row + col] == 1) {
            return false;
        }
        return true;
    }
}