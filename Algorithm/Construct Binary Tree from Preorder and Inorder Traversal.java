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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0) {
            return null;
        }
        int n = preorder.length;
        return helper(preorder, 0, n - 1, inorder, 0, n - 1, n);
    }
    private TreeNode helper(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight, int length) {
        if (pLeft > pRight) {
            return null;
        }
        if (pLeft == pRight || iLeft == iRight) {
            return new TreeNode(preorder[pLeft]);
        }
        TreeNode root = new TreeNode(preorder[pLeft]);
        int i = iLeft;
        for (; i <= iRight; i++) {
            if (root.val == inorder[i]) {
                break;
            }
        }
        root.left = helper(preorder, pLeft + 1, pLeft + i - iLeft, inorder, iLeft, i - 1, length);
        root.right = helper(preorder, pLeft + i - iLeft + 1, pRight, inorder, i + 1, iRight, length);
        return root;
    }
}