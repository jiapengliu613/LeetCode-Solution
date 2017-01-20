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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        Deque<Integer> valStack = new ArrayDeque<>();
        nodeStack.push(root);
        valStack.push(root.val);
        //TreeNode current = root;
        while (!nodeStack.isEmpty()) {
            while (root.right != null) {
                root = root.right;
                nodeStack.push(root);
                valStack.push(root.val);
            }
            TreeNode current = nodeStack.pop();
            if (current.left != null) {
                root = current.left;
                nodeStack.push(root);
                valStack.push(root.val);
            }
        }
        while (!valStack.isEmpty()) {
            result.add(valStack.pop());
        }
        return result;
    }
}