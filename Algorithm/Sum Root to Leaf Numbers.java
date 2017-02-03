v/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, 0);
        return sum;
    }
    private void helper(TreeNode node, int current) {
        if (node.left == null && node.right == null) {
            sum += current * 10 + node.val;
            return ;
        }
        current = current * 10 + node.val;
        if (node.left != null) {
            helper(node.left, current);
        }
        if (node.right != null) {
            helper(node.right, current);
        }
    }
}