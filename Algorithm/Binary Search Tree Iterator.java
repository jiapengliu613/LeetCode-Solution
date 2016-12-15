/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<TreeNode>();
        if (root != null) {
            stack.push(root);
        }
        while (root != null && root.left != null) {
            stack.push(root.left);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode current = stack.pop();
        int result = current.val;
        if (current.right != null) {
            current = current.right;
            stack.push(current);
            while (current.left != null) {
                stack.push(current.left);
                current = current.left;
            }
        }
        return result;
        
    }
    private Deque<TreeNode> stack;
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */