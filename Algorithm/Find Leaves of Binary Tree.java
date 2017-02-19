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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        helper(result, root);
        return result;
    }
    private int helper(List<List<Integer>> result, TreeNode node) {
        if (node == null) {
            return 0;
        }
        int level = 1 + Math.max(helper(result, node.left), helper(result, node.right));
        if (level > result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(level - 1).add(node.val);
        return level;
    }
}