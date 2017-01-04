public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        int[] col = new int[n];
        int[] lDiag = new int[2 * n - 1];
        int[] rDiag = new int[2 * n - 1];
        List<String> current = new ArrayList<>();
        
        helper(result, current, col, lDiag, rDiag, 0);
        return result;
    }
    private void helper(List<List<String>> result, List<String> current, int[] col, int[] lDiag, int[] rDiag, int level) {
        if (current.size() == col.length) {
            result.add(new ArrayList<String>(current));
            return ;
        }
        int n = col.length;
        for (int i = 0; i < col.length; i++) {
            if (isValid(col, lDiag, rDiag, level, i)) {
                col[i] = 1;
                lDiag[n - 1 - level + i] = 1;
                rDiag[level + i] = 1;
                current.add(convertToString(n, i));
                helper(result, current, col, lDiag, rDiag, level + 1);
                current.remove(current.size() - 1);
                col[i] = 0;
                lDiag[n - 1 - level + i] = 0;
                rDiag[level + i] = 0;
            }
        }
    }
    private boolean isValid(int[] column, int[] lDiag, int[] rDiag, int level, int i) {
        int n = column.length;
        if (column[i] == 1 || lDiag[n - 1 - level + i] == 1 || rDiag[level + i] == 1) {
            return false;
        }

        return true;
    }
    
    private String convertToString(int n, int col) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == col) {
                sb.append("Q");
            } else {
                sb.append(".");
            }
        }
        return sb.toString();
    }
}