public class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    private void dfs(int[][] matrix, int row, int col, boolean[][] visited, int height) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || visited[row][col] || matrix[row][col] < height) {
            return;
        }
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            dfs(matrix, row + dx[i], col + dy[i], visited, matrix[row][col]);
        }
    }
    
    public List<int[]> pacificAtlantic(int[][] matrix) {
        // dfs
        List<int[]> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visitedPac = new boolean[m][n];
        boolean[][] visitedAtl = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, i, 0, visitedPac, Integer.MIN_VALUE);
            dfs(matrix, i, n - 1, visitedAtl, Integer.MIN_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dfs(matrix, 0, i, visitedPac, Integer.MIN_VALUE);
            dfs(matrix, m - 1, i, visitedAtl, Integer.MIN_VALUE);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visitedPac[i][j] && visitedAtl[i][j]) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
        
        /* bfs
        List<int[]> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visitedPac = new boolean[m][n];
        boolean[][] visitedAtl = new boolean[m][n];
        Deque<int[]> queuePac = new ArrayDeque<>();
        Deque<int[]> queueAtl = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            queuePac.add(new int[]{i, 0});
            visitedPac[i][0] = true;
            queueAtl.add(new int[]{i, n - 1});
            visitedAtl[i][n - 1] = true;
        }
        for (int i = 0; i < n; i++) {
            queuePac.add(new int[]{0, i});
            visitedPac[0][i] = true;
            queueAtl.add(new int[]{m - 1, i});
            visitedAtl[m - 1][i] = true;
        }
        bfs(visitedPac, queuePac, matrix);
        bfs(visitedAtl, queueAtl, matrix);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visitedPac[i][j] && visitedAtl[i][j]) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    private void bfs(boolean[][] visited, Deque<int[]> queue, int[][] matrix) {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = current[0];
                int y = current[1];
                int newX = current[0] + dx[i];
                int newY = current[1] + dy[i];
                if (newX >= 0 && newX < visited.length && newY >= 0 && newY < visited[0].length && !visited[newX][newY] && matrix[newX][newY] >= matrix[x][y]) {
                    queue.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
        */
    }
}