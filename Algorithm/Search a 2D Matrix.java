public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        int row = 0;
        if (matrix[start][0] > target) {
            return false;
        } else if (matrix[start][0] == target) {
            return true;
        } else if (matrix[end][0] > target) {
            row = start;
        } else {
            row = end;
        }
        //System.out.println(row);
        start = 0;
        end = n - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[row][start] == target || matrix[row][end] == target) {
            return true;
        }
        return false;
    }
}