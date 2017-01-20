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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        return helper(inorder, postorder, 0, inorder.length - 1, 0, inorder.length - 1);
    }
    private TreeNode helper(int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight) {
        if (inLeft > inRight) {
            return null;
        }
        if (inLeft == inRight) {
            return new TreeNode(inorder[inLeft]);
        }
        int val = postorder[postRight];
        TreeNode root = new TreeNode(val);
        int index = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }
        root.left = helper(inorder, postorder, inLeft, index - 1, postLeft, postLeft + index - inLeft - 1);
        root.right = helper(inorder, postorder, index + 1, inRight, postLeft + index - inLeft, postRight - 1);
        return root;
    }
}