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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int n = nums.length;
        
        return helper(nums, 0, n - 1);
        
    }
    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode leftChild = helper(nums, left, mid - 1);
        TreeNode rightChild = helper(nums, mid + 1, right);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }
}