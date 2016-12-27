public class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    result += countZero(grid, i, j);
                    if (i == 0 ) {
                        result++;
                    }
                    if (i == m - 1) {
                        result++;
                    }
                    if (j == 0) {
                        result++;
                    }
                    if (j == n - 1) {
                        result++;
                    }
                }
               // System.out.print("" + result + " ");
            }
            //System.out.println();
        }
        return result;
    }
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    private int countZero(int[][] grid, int i, int j) {
        int count = 0;
        for (int k = 0; k < dx.length; k++) {
            int newX = i + dx[k];
            int newY = j + dy[k];
            if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[i].length) {
                continue;
            }
            if (grid[newX][newY] == 0) {
                count++;
            }
        }
        return count;
    }
}