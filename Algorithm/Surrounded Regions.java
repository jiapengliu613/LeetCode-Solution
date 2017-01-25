public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        // left and right side
        for (int i = 0; i < m; i++) {
            helper(board, i, 0);
            helper(board, i, n - 1);
            
        }
        // up and bot
        for (int i = 0; i < n; i++) {
            helper(board, 0, i);
            helper(board, m - 1, i);
        }
        //System.out.println(board[1][1]);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '#') {
                    board[i][j] = 'X';
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
        return ;
    }
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    private void helper(char[][] board, int row, int col) {
        if (board[row][col] == '#' || board[row][col] == 'X') {
            return ;
        }
        board[row][col] = '#';
        for (int i = 0; i < 4; i++) {
            int newX = row + dx[i];
            int newY = col + dy[i];
            if (newX >= 1 && newX < board.length - 1 && newY >= 1 && newY < board[0].length - 1  && board[newX][newY] == 'O') {
                helper(board, newX, newY);
            }
        }
    }
}