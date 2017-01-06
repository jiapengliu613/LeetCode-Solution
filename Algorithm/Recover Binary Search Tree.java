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
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return ;
        }
        
        inOrder(root);
        
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    private void inOrder(TreeNode root) {
        if (root == null) {
            return ;
        }
        inOrder(root.left);
        if (prev.val > root.val) {
            if (first == null) {
                first = prev;
                second = root;
            } else {
                second = root;
            }
        }
        prev = root;
        inOrder(root.right);
    }
}