public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> degree= new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            degree.put(i, 0);

        }
        for (int[] course : prerequisites) {
            Set<Integer> set = new HashSet<>();
            if (map.containsKey(course[0])) {
                set = map.get(course[0]);
            }
            if (!set.contains(course[1])) {
                set.add(course[1]);
                degree.put(course[1], degree.get(course[1]) + 1);
                map.put(course[0], set);
            }
        }
        Deque<Integer> queue = new ArrayDeque<>();
        int count = 0;
        for (int course : degree.keySet()) {
            if (degree.get(course) == 0) {
                queue.offer(course);
                count++;
            }
        }
        //System.out.println(map.keySet());
        while (!queue.isEmpty()) {
            int current = queue.poll();
            //System.out.println(current);
            if (map.containsKey(current)) {
                for (int pre : map.get(current)) {
                    degree.put(pre, degree.get(pre) - 1);
                    if (degree.get(pre) == 0) {
                        queue.offer(pre);
                        count++;
                    }
                }
            }
        }
        //System.out.println(count);
        return count == numCourses;
    }
}