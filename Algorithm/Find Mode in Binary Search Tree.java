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
    Integer prev = null;
    int max = 0, count = 1;
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    
    private void helper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return ;
        }
        helper(node.left, list);
        if (prev != null) {
            if (prev == node.val) {
                count += 1;
        
            } else {
                count = 1;
            }
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(node.val);
        } else if (count == max) {
            list.add(node.val);
        }
        prev = node.val;
        helper(node.right, list);
    }
}