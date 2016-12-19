public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return true;
        }
        int m = board.length, n = board[0].length;
        if (m != 9 || n != 9) {
            return false;
        }
        
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> partial = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && row.contains(board[i][j])) {
                    return false;
                }
                row.add(board[i][j]);
                
                if (board[j][i] != '.' && col.contains(board[j][i])) {
                    return false;
                }
                col.add(board[j][i]);
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                if (board[rowIndex + j / 3][colIndex + j % 3] != '.' && partial.contains(board[rowIndex + j / 3][colIndex + j % 3])) {
                    return false;
                }
                partial.add(board[rowIndex + j / 3][colIndex + j % 3]);
            }
        }
        return true;
        
    }
}