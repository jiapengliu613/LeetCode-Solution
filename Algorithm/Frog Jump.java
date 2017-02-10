public class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length <= 1) {
            return true;
        }
        if (stones.length == 2) {
            return stones[1] - stones[0] == 1;
        }
        int n = stones.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        map.put(0, new HashSet<>());
        map.get(0).add(1);
        for (int i = 1; i < stones.length - 1; i++) {
            map.put(stones[i], new HashSet<>());
        }
        for (int i = 0; i < stones.length - 1; i++) {
            for (int step : map.get(stones[i])) {
                int nextPos = stones[i] + step;
                if (nextPos == stones[n - 1]) {
                    return true;
                }
                if (map.containsKey(nextPos)) {
                    map.get(nextPos).add(step);
                    map.get(nextPos).add(step + 1);
                    if (step - 1 > 0) {
                        map.get(nextPos).add(step - 1);
                    }
                }
            }
        }
        return false;
    }
}