/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if (n <= 0) {
            return 1;
        }
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (candidate == i) {
                continue;
            }
            if (knows(candidate, i) || !knows(i, candidate)) {
                return -1;
            }
        }
        return candidate;
        
        /* O(n^2) TLE 
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= n - 1; i++) {
            map.put(i, 1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (knows(i, j) || !knows(j, i)) {
                    map.put(i, 0);
                }
                if (knows(j, i) || !knows(i, j)) {
                    map.put(j, 0);
                }
            }
        }
        //int result = -1;
        for (int i : map.keySet()) {
            if (map.get(i) == 1) {
                return i;
            }
        }
        return -1;
        */
    }
}