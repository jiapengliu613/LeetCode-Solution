public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int topRow = 0, botRow = m - 1, leftCol = 0, rightCol = n - 1;
        //int offset = 0;
        while (true) {
            if (topRow == botRow) {
                for (int i = leftCol; i <= rightCol; i++) {
                    result.add(matrix[topRow][i]);
                }
                return result;
            }
            if (leftCol == rightCol) {
                for (int i = topRow; i <= botRow; i++) {
                    result.add(matrix[i][leftCol]);
                }
                return result;
            }
            for (int i = leftCol; i<= rightCol; i++) {
                result.add(matrix[topRow][i]);
            }
            if (result.size() == m * n) {
                return result;
            }
            for (int i = topRow + 1; i <= botRow; i++) {
                result.add(matrix[i][rightCol]);
            }
            if (result.size() == m * n) {
                return result;
            }
            for (int i = rightCol - 1; i >= leftCol; i--) {
                result.add(matrix[botRow][i]);
            }
            if (result.size() == m * n) {
                return result;
            }
            for (int i = botRow - 1; i > topRow; i--) {
                result.add(matrix[i][leftCol]);
            }
            if (result.size() == m * n) {
                return result;
            }
            //offset++;
            topRow += 1;
            botRow -= 1;
            leftCol += 1;
            rightCol -= 1;
        }
    }
}