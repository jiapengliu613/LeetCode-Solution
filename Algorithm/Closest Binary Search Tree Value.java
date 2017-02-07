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
    public int closestValue(TreeNode root, double target) {
        int result = 0;
        double diff = Double.MAX_VALUE;
        while (root != null) {
            if (root.val == target) {
                return root.val;
            } else if (root.val < target) {
                if (diff > target - root.val) {
                    diff = target - root.val;
                    result = root.val;
                    
                } 
                root = root.right;
            } else {
                if (diff > root.val - target) {
                    diff = root.val - target;
                    result = root.val;
                }
                root = root.left;
            }
        }
        return result;
    }
}