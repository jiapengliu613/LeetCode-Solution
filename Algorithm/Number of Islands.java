public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    continue;
                } else if (visited[i][j] == false) {
                    helper(visited, grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void helper(boolean[][] visited, char[][] grid, int i, int j) {
        if (visited[i][j] == true) {
            return;
        }
        visited[i][j] = true;
        if (i + 1 < visited.length && grid[i + 1][j] == '1') {
            helper(visited, grid, i + 1, j);
        }
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            helper(visited, grid, i - 1, j);
        }
        if (j + 1 < visited[0].length && grid[i][j + 1] == '1') {
            helper(visited, grid, i, j + 1);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            helper(visited, grid, i, j - 1);
        }
    }
}