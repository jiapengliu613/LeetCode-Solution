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
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        boolean leftSub = helper(root.left, root.val);
        boolean rightSub = helper(root.right, root.val);
        if (!leftSub || !rightSub) {
            return result;
        }
        return result + 1;
    }
    private boolean helper(TreeNode node, int val) {
        if (node == null) {
            return true;
        }
        boolean leftSub = helper(node.left, node.val);
        boolean rightSub = helper(node.right, node.val);
        if (!leftSub || !rightSub) {
            return false;
        }
        result++;
        return node.val == val;
    }
    private int result = 0;
}