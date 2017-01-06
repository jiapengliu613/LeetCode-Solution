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
    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return ;
        }
        TreeNode current = root;
        TreeNode rightSub = current.right;
        TreeNode leftSub = current.left;
        flatten(leftSub);
        flatten(rightSub);
        current.left = null;
        current.right = leftSub;
        while (current.right != null) {
            current = current.right;
        }
        current.right = rightSub;
    }
}