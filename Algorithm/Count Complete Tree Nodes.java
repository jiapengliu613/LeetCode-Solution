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
    public int countNodes(TreeNode root) {
        /*O(n) tle solution
        if (root == null) {
            return 0;
        }
        int result = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            result++;
            if (current.left != null) {
                queue.offer(current.left);
                
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return result;
        */
        if (root == null) {
            return 0;
        }
        int h = treeHeight(root);
        //System.out.println(h);
        if (treeHeight(root.right) == h - 1) {
            return (1 << (h - 1)) + countNodes(root.right);
        } else {
            return (1 << (h - 2)) + countNodes(root.left);
        }
    }
    private int treeHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int result = 1 + treeHeight(node.left);
        return result;
    }
}