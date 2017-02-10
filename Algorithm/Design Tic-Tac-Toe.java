public class TicTacToe {
    private int n;
    private int count = 0;
    private int[] row1;
    private int[] row2;
    private int[] col1;
    private int[] col2;
    private int diag1 = 0, anti_diag1 = 0, diag2 = 0, anti_diag2 = 0;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        if (n == 0) {
            return ;
        }
        this.n = n;
        row1 = new int[n];
        row2 = new int[n];
        col1 = new int[n];
        col2 = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if (player == 1) {
            row1[row]++;
            if (row1[row] == n) {
                return player;
            }
            col1[col]++;
            if (col1[col] == n) {
                return player;
            }
            if (row == col) {
                diag1++;
                if (diag1 == n) {
                    return player;
                }
            }
            if (row + col == n - 1) {
                anti_diag1++;
                if (anti_diag1 == n) {
                    return player;
                }
            }
        } else {
            row2[row]++;
            if (row2[row] == n) {
                return player;
            }
            col2[col]++;
            if (col2[col] == n) {
                return player;
            }
            if (row == col) {
                diag2++;
                if (diag2 == n) {
                    return player;
                }
            }
            if (row + col == n - 1) {
                anti_diag2++;
                if (anti_diag2 == n) {
                    return player;
                }
            }
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */