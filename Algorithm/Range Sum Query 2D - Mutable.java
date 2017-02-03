public class NumMatrix {
    //Binary indexed Tree 
    private int[][] tree;
    private int[][] nums;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ;
        }
        int m = matrix.length, n = matrix[0].length;
        tree = new int[m + 1][n + 1];
        nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(i, j, matrix[i][j]);
            }
        }
        //System.out.println("im here");
    }
    
    public void update(int row, int col, int val) {
        int dif = val - nums[row][col];
        nums[row][col] = val;
        for (int i = row + 1; i < tree.length; i += i & (-i)) {
            for (int j = col + 1; j < tree[0].length; j += j & (-j)) {
                tree[i][j] += dif;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = getSum(row2 + 1, col2 + 1) + getSum(row1, col1) - getSum(row1, col2 + 1) - getSum(row2 + 1, col1);
        return sum;
    }
    
    private int getSum(int row, int col) {
        int sum = 0;
        for (int i = row; i > 0; i -= i & (-i)) {
            for (int j = col; j > 0; j -= j & (-j)) {
                sum += tree[i][j];
            }
        }
        //System.out.println("im here");
        return sum;
    }
}



/*
public class NumMatrix {
    private int[][] matrix;
    private int[][] colSum;
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ;
        }
        this.matrix = matrix;
        int m = matrix.length, n = matrix[0].length;
        colSum = new int[m + 1][n];
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                colSum[i][j] = colSum[i - 1][j] + matrix[i - 1][j];
                //System.out.print(colSum[i][j] + " ");
            }
            //System.out.println();
        }
    }
    
    public void update(int row, int col, int val) {
        for (int i = row + 1; i < colSum.length; i++) {
            colSum[i][col] = colSum[i][col] + val - matrix[row][col];
        }
        matrix[row][col] = val;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = col1; i <= col2; i++) {
            sum += colSum[row2 + 1][i] - colSum[row1][i];
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */