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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        boolean level = true;
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> current = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (level) {
                    TreeNode node = deque.removeLast();
                    current.add(node.val);
                    if (node.left != null) {
                        deque.addFirst(node.left);
                    }
                    if (node.right != null) {
                        deque.addFirst(node.right);
                    }
                } else {
                    TreeNode node = deque.removeFirst();
                    current.add(node.val);
                    if (node.right != null) {
                        deque.addLast(node.right);
                    }
                    if (node.left != null) {
                        deque.addLast(node.left);
                    }
                }
            }
            result.add(current);
            level = !level;
        }
        return result;
    }
}