public class Solution {
    int minDis = Integer.MAX_VALUE;
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[][] distance = new int[m][n];
        int start = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    helper(grid, i, j, distance, --start);
                }
            }
        }
        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }
    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, 1, 0, -1};
    private void helper(int[][] grid, int row, int col, int[][] distance, int empty) {
        minDis = Integer.MAX_VALUE;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        int dis = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            dis++;
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int newX = current[0] + dx[j];
                    int newY = current[1] + dy[j];
                    if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == empty) {
                        distance[newX][newY] += dis;
                        grid[newX][newY]--;
                        queue.offer(new int[]{newX, newY});
                        minDis = Math.min(minDis, distance[newX][newY]);
                    }
                }
            }
        }
    }
}