public class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n <= 1 || edges == null || edges.length == 0) {
            return n;
        }
        Set<Integer> set = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            set.add(i);
            map.put(i, new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            if (!map.containsKey(edge[0])) {
                map.put(edge[0], new ArrayList<>());
            }
            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        set.remove(0);
        int count = 1;
        while (!set.isEmpty()) {
            while (!queue.isEmpty()) {
                //System.out.println(set.toString());
                List<Integer> neighbors = map.get(queue.poll());
                for (int next : neighbors) {
                    if (set.contains(next)) {
                        set.remove(next);
                        queue.offer(next);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (set.contains(i)) {
                    queue.offer(i);
                    set.remove(i);
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}