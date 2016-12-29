public class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[0][0];
        }
        int[][] result = new int[n][n];
        int leftCol = 0, rightCol = n - 1, upRow = 0, downRow = n - 1;
        int count = 0, offset = 0;
        while (true) {
            if (count == n * n) {
                break;
            }
            if (count == n * n - 1) {
                result[n / 2][n / 2] = n * n;
                break;
            }
            for (int i = leftCol; i < rightCol; i++) {
                result[upRow][i] = ++count;
            }
        
            for (int i = upRow; i < downRow; i++) {
                result[i][rightCol] = ++count;
            }
            
            for (int i = rightCol; i > leftCol; i--) {
                result[downRow][i] = ++count;
            }
            
            for (int i = downRow; i > upRow; i--) {
                result[i][leftCol] = ++count;
            }
            //offset++;
            leftCol += 1;
            rightCol -= 1;
            upRow += 1;
            downRow -= 1;
        }
        return result;
    }
}