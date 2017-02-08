public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length < 3) {
            return 0;
        }
        //int total = 0;
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                int dis = calcDis(points[i], points[j]);
                if (!map.containsKey(dis)) {
                    map.put(dis, 1);
                } else {
                    count += map.get(dis) * 2;
                    map.put(dis, map.get(dis) + 1);
                    
                }
                
            }
        }
        return count;
    }
    
    private int calcDis(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}