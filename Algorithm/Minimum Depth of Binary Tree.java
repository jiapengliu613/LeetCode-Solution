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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root);
    }
    private int helper(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            int rightSub = helper(root.right);
            return rightSub + 1;
        }
        if (root.right == null) {
            int leftSub = helper(root.left);
            return leftSub + 1;
        }
        return Math.min(helper(root.right) ,helper(root.left)) + 1;
    }
}