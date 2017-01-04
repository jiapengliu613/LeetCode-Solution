public class Solution {
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        return minDis(x) + minDis(y);
    }
    private int minDis(List<Integer> list) {
        int left = 0, right = list.size() - 1;
        Collections.sort(list);
        int result = 0;
        while (left < right) {
            result += list.get(right) - list.get(left);
            right--;
            left++;
        }
        return result;
    }
}