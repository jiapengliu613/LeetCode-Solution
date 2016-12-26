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
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root).maxPath;
    }
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        int singleCurrent = Math.max(0, Math.max(left.singlePath, right.singlePath) + root.val);
        int maxCurrent = Math.max(left.maxPath, right.maxPath);
        maxCurrent = Math.max(maxCurrent, left.singlePath + root.val + right.singlePath);
        return new ResultType(singleCurrent, maxCurrent);
    }
    
    
    
    class ResultType {
        int singlePath;
        int maxPath;
        public ResultType(int single, int max) {
            this.singlePath = single;
            this.maxPath = max;
        }
    }
}