/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    private void inorder(TreeNode root, double target, Deque<TreeNode> stack) {
        if (root == null) {
            return ;
        }
        
        inorder(root.left, target, stack);
        if (root.val >= target) {
            return ;
        }
        stack.push(root);
        inorder(root.right, target, stack);
    }
    private void reverse(TreeNode root, double target, Deque<TreeNode> stack) {
        if (root == null) {
            return ;
        }
        reverse(root.right, target, stack);
        if (root.val < target) {
            return ;
        }
        stack.push(root);
        reverse(root.left, target, stack);
    }
    
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null || k == 0) {
            return result;
        }
        Deque<TreeNode> inorder = new ArrayDeque<>();
        inorder(root, target, inorder);
        Deque<TreeNode> reverse = new ArrayDeque<>();
        reverse(root, target, reverse);
        for (int i = 0; i < k; i++) {
            if (!inorder.isEmpty() && !reverse.isEmpty()) {
                if (target - inorder.peek().val< reverse.peek().val - target) {
                    result.add(inorder.pop().val);
                } else {
                    result.add(reverse.pop().val);
                }
            } else if (!inorder.isEmpty()) {
                result.add(inorder.pop().val);
            } else {
                result.add(reverse.pop().val);
            }
        }
        return result;
        
        
        
        
        
        
        
        
        
        
        
        
        /*
        TreeNode pred = getPredcessor(target, root);
        TreeNode succ = getSuccessor(target, root);
        for (int i = 0; i < k; i++) {
            System.out.println(pred.val + " " + succ.val);
            if (pred != null && succ != null && target - pred.val < succ.val - target) {
                result.add(pred.val);
                pred = getPredcessor(pred.val, root);
            } else if (pred != null && succ != null && target - pred.val > succ.val - target) {
                result.add(succ.val);
                succ = getSuccessor(succ.val, root);
            } else if (pred == null) {
                result.add(succ.val);
                succ = getSuccessor(succ.val, root);
            } else if (succ == null) {
                result.add(pred.val);
                pred = getPredcessor(pred.val, root);
            }
            
        }
        return result;
    }
    
    private TreeNode getSuccessor(double target, TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.val < target) {
            return getSuccessor(target, root.right);
        }
        return getSuccessor(target, root.left) == null ? root : getSuccessor(target, root.left);
    }
    
    private TreeNode getPredcessor(double target, TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.val >= target) {
            return getPredcessor(target, root.left);
        }
        return getPredcessor(target, root.right) == null ? root : getPredcessor(target, root.right);
        */
    }
}