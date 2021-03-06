public class HitCounter {
    Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public HitCounter() {
        map = new HashMap<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if (map.containsKey(timestamp)) {
            map.put(timestamp, map.get(timestamp) + 1);
        } else {
            map.put(timestamp, 1);
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int sum = 0;
        for (int i = timestamp - 300 + 1; i <= timestamp; i++) {
            if (map.containsKey(i)) {
                sum += map.get(i);
            }
        }
        return sum;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */