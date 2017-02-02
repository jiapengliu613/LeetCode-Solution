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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> current = new ArrayList<>();
        helper(root, result, current, sum);
        return result;
    }
    private void helper(TreeNode node, List<List<Integer>> result, List<Integer> current, int remaining) {
        if (node.left == null && node.right == null) {
            if (remaining == node.val) {
                current.add(node.val);
                result.add(new ArrayList<Integer>(current));
                current.remove(current.size() - 1);
            }
            return ;
        }
        current.add(node.val);
        if (node.left != null) {
            helper(node.left, result, current, remaining - node.val);
        }
        if (node.right != null) {
            helper(node.right, result, current, remaining - node.val);
        }
        current.remove(current.size() - 1);
        
    }
}