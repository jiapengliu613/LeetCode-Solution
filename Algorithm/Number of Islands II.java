public class Solution {
    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, 1, 0, -1};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        
        if (m == 0 || n == 0 || positions == null || positions.length == 0) {
            return result;
        }
        int[][] grid = new int[m][n];
        UnionFind uf = new UnionFind(m, n);
        int count = 0;
        for (int[] position : positions) {
            int i = position[0];
            int j = position[1];
            int id = convertId(i, j, n);
            grid[i][j] = 1;
            count++;
            for (int k = 0; k < 4; k++) {
                int newX = i + dx[k];
                int newY = j + dy[k];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] == 0) {
                    continue;
                }
                int currentFather = uf.find(id);
                int neighborId = convertId(newX, newY, n);
                int neighborFather = uf.find(neighborId);
                if (currentFather != neighborFather) {
                    uf.union(currentFather, neighborFather);
                    count--;
                }
            }
            result.add(count);
        }
        return result;
        
    }
    private int convertId(int x, int y, int n) {
        return x * n + y;
    }
    class UnionFind {
        Map<Integer, Integer> father;
        public UnionFind(int m, int n) {
            father = new HashMap<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int id = convertId(i, j, n);
                    father.put(id, id);
                }
            }
        }
        
        public int find(int id) {
            while (id != father.get(id)) {
                father.put(id, father.get(father.get(id)));
                id = father.get(id);
            }
            return id;
        }
        public void union(int id1, int id2) {
            father.put(id1, father.get(id2));
        }
    }

}