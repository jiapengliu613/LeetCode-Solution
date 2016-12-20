public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(visited, board, i, j, word, 0) == true) {
                    return true;
                }
            }
        }
        return false;
    }
    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, 1, 0, -1};
    private boolean helper(boolean[][] visited, char[][] board, int i, int j, String word, int index) {
        if (visited[i][j] == true) {
            return false;
        }
        
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean result = false;
        for (int k = 0; k < dx.length; k++) {
            int newX = i + dx[k];
            int newY = j + dy[k];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                result = helper(visited, board, newX, newY, word, index + 1);
            }
            if (result == true) {
                break;
            }
        }
        visited[i][j] = false;
        return result;
    }
}