public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        if (findNums == null || findNums.length == 0 || nums == null || nums.length == 0) {
            return new int[0];
        }
        int m = findNums.length, n = nums.length;
        int[] result = new int[m];
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        for (int i = 0; i < m; i++) {
            result[i] = map.getOrDefault(findNums[i], -1);
        }
        return result;
    }
}