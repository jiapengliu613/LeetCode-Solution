public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && nums[i] > dq.getLast()) {
                dq.removeLast();
            }
            dq.addLast(nums[i]);

            if (i >= k - 1) {
                result[i - k + 1] = dq.getFirst();
                if (dq.getFirst() == nums[i - k + 1]) {
                dq.removeFirst();
            }
            }
            
        }
        return result;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int pos = 0;
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            if (i >= k - 1) {
                result[pos++] = deque.peekFirst();
                if (deque.peekFirst() == nums[i - k + 1]) {
                    deque.removeFirst();
                }
            }
        }
        return result;
        */
     }
     
}