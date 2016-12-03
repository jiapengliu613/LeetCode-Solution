/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        HashMap<Double, Integer> map = new HashMap<>();
        int max = 1;
        for (int i = 0; i < points.length; i++) {
            int dup = 0;
            map.clear();
            map.put((double)Integer.MIN_VALUE, 1);
            for (int j = i + 1; j < points.length; j++) {
                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                    dup++;
                    continue;
                }
                double k = points[j].x == points[i].x ? (double)Integer.MAX_VALUE : 
                        0.0 + (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                if (map.containsKey(k)) {
                    map.put(k, map.get(k) + 1);
                } else {
                    map.put(k, 2);
                }
             }
             for (int count : map.values()) {
                 max = Math.max(max, count + dup);
             }
        }
        return max;
    }
}