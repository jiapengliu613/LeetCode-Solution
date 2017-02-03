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
    private int globalMax = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return globalMax;
    }
    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);
        int result = 1;
        if (node.left != null && node.val == node.left.val - 1) {
            result = left + 1;
        }
        if (node.right != null && node.val == node.right.val - 1) {
            result = Math.max(result, right + 1);
        }
        globalMax = Math.max(globalMax, result);
        return result;
    }
}