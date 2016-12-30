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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        helper(result, root, sb);
        return result;
    }
    private void helper(List<String> result, TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            sb.append(node.val);
            result.add(sb.toString());
            return;
        }
        
        sb.append(node.val).append("->");
        int n = sb.length();
        helper(result, node.left, sb);
        sb.setLength(n);
        helper(result, node.right, sb);
        sb.setLength(n);
    }
}