public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length, n = matrix[0].length;
        int[] result = new int[m * n];
        int[] dx = {-1, 1};
        int[] dy = {1, -1};
        int dir = 0;
        int x = 0, y = 0;
        for (int i = 0; i < m * n; i++) {
            //System.out.print(" " + matrix[x][y]);
            result[i] = matrix[x][y];
            x += dx[dir];
            y += dy[dir];
            if (x >= m) {
                x = m - 1;
                y += 2;
                dir = 1 - dir;
            }
            if (y >= n) {
                y = n - 1;
                x += 2;
                dir = 1 - dir;
            }
            if (x < 0) {
                x = 0;
                dir = 1 - dir;
            }
            if (y < 0) {
                y = 0;
                dir = 1 - dir;
            }
            
            
        }
        return result;
    }
}