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
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        Map<TreeNode, Integer> map = new HashMap<>();
        return helper(root, map);
    }
    private int helper(TreeNode root, Map<TreeNode, Integer> map) {
        if (map.containsKey(root)) {
            return map.get(root);
        }
        if (root == null) {
            return 0;
        }
        int result = 0;
        if (root.left != null) {
            result += helper(root.left.left, map) + helper(root.left.right, map);
        }
        if (root.right != null) {
            result += helper(root.right.right, map) + helper(root.right.left, map);
        }
        result = Math.max(result + root.val, helper(root.left, map) + helper(root.right, map));
        map.put(root, result);
        return result;
    }
}