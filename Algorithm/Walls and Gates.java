public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return ;
        }
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            if (row - 1 >= 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                queue.offer(new int[]{row - 1, col});
                rooms[row - 1][col] = rooms[row][col] + 1;
            }
            if (row + 1 < rooms.length && rooms[row + 1][col] == Integer.MAX_VALUE) {
                queue.offer(new int[]{row + 1, col});
                rooms[row + 1][col] = rooms[row][col] + 1;
            }
            if (col - 1 >= 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                queue.offer(new int[]{row, col - 1});
                rooms[row][col - 1] = rooms[row][col] + 1;
            }
            if (col + 1 < rooms[0].length && rooms[row][col + 1] == Integer.MAX_VALUE) {
                queue.offer(new int[]{row, col + 1});
                rooms[row][col + 1] = rooms[row][col] + 1;
            }
        }
    }
}