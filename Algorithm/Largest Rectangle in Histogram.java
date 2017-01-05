public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        for (int i  = 0; i <= heights.length; i++) {
            int height = i == heights.length ? -1 : heights[i];
            while (!stack.isEmpty() && height <= heights[stack.peek()]) {
                int index = stack.pop();
                int h = heights[index];
                int w = stack.isEmpty() ? i: i - stack.peek() - 1;
                result = Math.max(h * w, result);
            }
            stack.push(i);
            //System.out.print(result + " ");
        }
        return result;
    }
}