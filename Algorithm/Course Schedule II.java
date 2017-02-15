public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }
        int[] result = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] num : prerequisites) {
            if (!map.containsKey(num[1])) {
                map.put(num[1], new ArrayList<>());
            }
            map.get(num[1]).add(num[0]);
        }
        Map<Integer, Integer> degree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            degree.put(i, 0);
        }
        for (int course : map.keySet()) {
            for (int key : map.get(course)) {
                degree.put(key, degree.get(key) + 1);
            }
        }
        Deque<Integer> queue = new ArrayDeque<>();
        int count = 0;
        for (int key : degree.keySet()) {
            if (degree.get(key) == 0) {
                queue.offer(key);
                //result[count++] = key;
            }
        }
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result[count++] = current;
            if (!map.containsKey(current)) {
                continue;
            }
            for (int next : map.get(current)) {
                degree.put(next, degree.get(next) - 1);
                if (degree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }
        return numCourses == count ? result : new int[0];
        
        
        
        
        
        
        
        
        
        /*
        Map<Integer, Integer> degree = new HashMap<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            degree.put(i, 0);
        }
        for (int[] prerequisite : prerequisites) {
            Set<Integer> set;
            if (map.containsKey(prerequisite[1])) {
                set = map.get(prerequisite[1]);
            } else {
                set = new HashSet<>();
            }
            degree.put(prerequisite[0], degree.get(prerequisite[0]) + 1);
            set.add(prerequisite[0]);
            map.put(prerequisite[1], set);
        }
        Deque<Integer> queue = new ArrayDeque<>();
        int count = 0;
        int[] result = new int[numCourses];
        for (int i : degree.keySet()) {
            if (degree.get(i) == 0) {
                queue.offer(i);
                result[count++] = i;
            }
        }
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (map.containsKey(current)) {
                for (int next : map.get(current)) {
                    degree.put(next, degree.get(next) - 1);
                    if (degree.get(next) == 0) {
                        queue.offer(next);
                        result[count++] = next;
                    }
                }
            }
        }
        return count == numCourses ? result : new int[0];
        */
    }
}