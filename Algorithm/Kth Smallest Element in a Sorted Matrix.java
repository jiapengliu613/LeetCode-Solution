public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || k <= 0) {
            return Integer.MAX_VALUE;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Triple> pq = new PriorityQueue<>(k, new Comparator<Triple>() {
            @Override
            public int compare(Triple a, Triple b) {
                return a.val - b.val;
            }
            });
        pq.offer(new Triple(0, 0, matrix[0][0]));
        visited[0][0] = true;
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            Triple current = pq.poll();
            result = current.val;
            int row = current.row;
            int col = current.col;
            if (row + 1 < m && visited[row + 1][col] == false) {
                visited[row + 1][col] = true;
                pq.offer(new Triple(row + 1, col, matrix[row + 1][col]));
            }
            if (col + 1 < n && visited[row][col + 1] == false) {
                visited[row][col + 1] = true;
                pq.offer(new Triple(row, col + 1, matrix[row][col + 1]));
            }
        }
        return result;
        
    }
    class Triple {
        int row;
        int col;
        int val;
        public Triple(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
}