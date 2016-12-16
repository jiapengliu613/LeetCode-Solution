public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] histo = new int[m][n];
        for (int i = m - 1; i>= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i == m - 1) {
                    if (matrix[i][j] == '1') {
                        int count = 1;
                        int row = i - 1;
                        while (row >= 0 && matrix[row][j] == '1') {
                            count++;
                            row--;
                        }
                        histo[i][j] = count;
                    } else {
                        histo[i][j] = 0;
                    }
                } else {
                    if (matrix[i][j] == '1' && matrix[i + 1][j] == '1') {
                        histo[i][j] = histo[i + 1][j] - 1;
                    } else if (matrix[i][j] == '1') {
                        int count = 1;
                        int row = i - 1;
                        while (row >= 0 && matrix[row][j] == '1') {
                            count++;
                            row--;
                        }
                        histo[i][j] = count;
                    } else {
                        histo[i][j] = 0;
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            int[] array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = histo[i][j];
            }
            result = Math.max(result, histogram(array));
        }
        return result;
    }
    
    private int histogram(int[] array) {
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i <= array.length; i++) {
            int curHeight = i == array.length ? -1 : array[i];
            while (!stack.isEmpty() &&  curHeight < array[stack.peek()]) {
                int h = array[stack.pop()];
                int w = stack.isEmpty() ? i : i - 1 - stack.peek();
                result = Math.max(result, h * w);
            }
            stack.push(i);
        }
        return result;
    }
}