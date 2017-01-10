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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        
        stack.push(root);
        result.add(root.val);
        while (!stack.isEmpty()) {
            while (root.left != null) {
                root = root.left;
                stack.push(root);
                result.add(root.val);
            }
            //result.add(stack.peek().val);
            TreeNode current = stack.pop();
            if (current.right != null) {
                result.add(current.right.val);
                stack.push(current.right);
                root = current.right;
            }
        }
        return result;
    }
}