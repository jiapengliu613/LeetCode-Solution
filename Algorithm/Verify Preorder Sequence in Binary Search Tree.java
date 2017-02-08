public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length <= 1) {
            return true;
        }
        int minVal = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : preorder) {
            
            if (num < minVal) {
                return false;
            }
            while (!stack.isEmpty() && num > stack.peek()) {
                minVal = stack.pop();
            }
            stack.push(num);
            
        }
        return true;
        
        
        
        
    /* O(nlog(n))
        return helper(preorder, 0, preorder.length - 1);
    }
    
    private boolean helper(int[] preorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        int pivot = preorder[left];
        int index = -1;
        for (int i = left + 1; i <= right; i++) {
            if (index == -1 && preorder[i] > pivot) {
                index = i;
            }
            if (index != -1 && preorder[i] < pivot) {
                return false;
            }
        }
        if (index == -1) {
            return helper(preorder, left + 1, right);
        } else {
            return helper(preorder, left + 1, index - 1) && helper(preorder, index, right);
        }
    */
    }
}