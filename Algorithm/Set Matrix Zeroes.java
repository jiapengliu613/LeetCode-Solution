public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ;
        }
        int m = matrix.length, n = matrix[0].length;
        int flag = 1;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flag = 0;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (flag == 0) {
                matrix[i][0] = 0;
            }
        }
        
        
        
        
        
        
        /* kind of cheated solution
        for (int i = 0; i < m; i++) {
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    firstTransform(matrix, i);
                    flag = true;
                }
                if (flag == true) {
                    break;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            boolean flag = false;
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] == Integer.MAX_VALUE / 2) {
                    secondTransform(matrix, j);
                    flag = true;
                }
                if (flag == true) {
                    break;
                }
            }
        }
    }
    private void firstTransform(int[][] matrix, int row) {
        for (int i = 0; i < matrix[row].length; i++) {
            if (matrix[row][i] == 0) {
                matrix[row][i] = Integer.MAX_VALUE / 2;
            } else {
                matrix[row][i] = 0;
            }
        }
    }
    private void secondTransform(int[][] matrix, int col) {
        boolean flag = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] == Integer.MAX_VALUE / 2) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][col] = 0;
                }
                flag = true;
            }
            if (flag == true) {
                break;
            }
        }
        */
    }
}