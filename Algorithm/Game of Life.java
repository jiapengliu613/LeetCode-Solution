public class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                checkNeighbor(board, i, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //marked with Integer.minvalue
                reproduction(board, i, j);
                //System.out.print("" + board[i][j] + " ");
            }
            //System.out.println();
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] >= 0 && board[i][j] < 3) {
                    board[i][j] = 0;
                } else if ((board[i][j] >= 3 && board[i][j] <= 4) || board[i][j] == Integer.MIN_VALUE) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }
    private int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    private void checkNeighbor(int[][] board, int i, int j) {
        if (board[i][j] == 0) {
            return ;
        }
        
        int count = 1;
        for (int k = 0; k < dx.length; k++) {
            int newX = i + dx[k];
            int newY = j + dy[k];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && board[newX][newY] >= 1) {
                count++;
            }
        }
        board[i][j] = count;
    }
    private void reproduction(int[][] board, int i, int j) {
        if (board[i][j] != 0) {
            return ;
        }
        int count = 0;
        for (int k = 0; k < dx.length; k++) {
            int newX = i + dx[k];
            int newY = j + dy[k];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && board[newX][newY] >= 1) {
                count++;
            }
        }
        if (count == 3) {
            board[i][j] = Integer.MIN_VALUE;;
        }
    }
}