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
    //private int count = 0;
    private int helper(TreeNode root, Map<Integer, Integer> map, int current, int target) {
        if (root == null) {
            return 0;
        }
        current += root.val;
        int result = 0;
        if (map.containsKey(current - target)) {
            result = map.get(current - target);
        }
        map.put(current, map.getOrDefault(current, 0) + 1);
        result += helper(root.left, map, current, target) + helper(root.right, map, current, target);
        map.put(current, map.get(current) - 1);
        return result;
    }
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        return helper(root, prefix, 0, sum);
        
        
    /*    
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    private int helper(TreeNode node, int remaining) {
        if (node == null) {
            return 0;
        }
        int result = 0;
        if (node.val == remaining) {
            result++;
        }
        result += helper(node.left, remaining - node.val) + helper(node.right, remaining - node.val);
        return result;
        */
    }
    
}