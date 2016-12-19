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
    public boolean isBalanced(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)){
            return true;
        }
        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    private int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeHeight(root.left);
        int right = treeHeight(root.right);
        return Math.max(left, right) + 1;
    }
}