public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0 || k == 0) {
            return result;
        }
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new List[n + 1];
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }
        for (int i = n; i >= 0; i--) {
            if (result.size() >= k) {
                break;
            }
            if (buckets[i] == null) {
                continue;
            }
            result.addAll(buckets[i]);
        }
        return result;
        
        
        /* PQ O(nlog(n)) Solution
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0 || k == 0) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(b) - map.get(a);
            }
        });
        for (int num : map.keySet()) {
            pq.offer(num);
        }
        for (int i = 0; i < k; i++) {
            if (pq.isEmpty()) {
                break;
            }
            result.add(pq.poll());
        }
        return result;
        */
        
        
        
        
        
        
        
        
        
        /*
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
        */
    }
}