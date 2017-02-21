public class Solution {
    //private int[][] board = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    private int count = 0;
    public int numberOfPatterns(int m, int n) {
        if (m == 0 && n == 0) {
            return 0;
        }
        if (m == 1 && n == 1) {
            return 9;
        }
        boolean[][] visited = new boolean[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                helper(visited, 1, m, n, i, j);
            }
        }
        return count;
    }
    //private int[] dx = {-1, 0, 1, 0, -1, 1, -1, 1, 1, -1, 1, -1, 2, 2, -2, -2};
    //private int[] dy = {0, 1, 0, -1, 1, 1, -1, -1, -2, -2, 2, 2, -1, 1, 1, -1};
    private void helper(boolean[][] visited, int current, int m, int n, int x, int y) {
        if (x < 0 || x >= 3 || y < 0 || y >= 3) {
            return;
        }
        if (visited[x][y]) {
            return ;
        }
        if (current >= m) {
            count++;
        }
        if (current == n) {
            return;
        }
        visited[x][y] = true;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newX = x + i;
                int newY = y + j;
                if (newX == x && newY == y) {
                    continue;
                }
                if (newX < 0 || newX >= 3 || newY < 0 || newY >= 3) {
                    continue;
                }
                if (!visited[newX][newY]) {
                    helper(visited, current + 1, m, n, newX, newY);
                } else {
                    helper(visited, current + 1, m, n, x + 2 * i, y + 2 * j);
                }
                if (i == 0 || j == 0) {
                    continue;
                }
                helper(visited, current + 1, m, n, x + 2 * i, y + j);
                helper(visited, current + 1, m, n, x + i, y + 2 * j);
            }
        }
        visited[x][y] = false;
    }
}