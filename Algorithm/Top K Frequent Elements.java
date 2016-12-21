public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0 || k == 0) {
            return result;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(k + 1, new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry a, Map.Entry b) {
                int diff = (Integer)a.getValue() - (Integer)b.getValue();
                return diff;
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            } 
        }
        while (!pq.isEmpty()) {
            result.add((Integer)pq.poll().getKey());
        }
        return result;
    }
}