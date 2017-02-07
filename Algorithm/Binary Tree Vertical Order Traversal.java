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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        int min = 0, max = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Deque<TreeNode> nodeQueue = new ArrayDeque<>();
        Deque<Integer> colQueue = new ArrayDeque<>();
        nodeQueue.offer(root);
        colQueue.offer(0);
        while (!nodeQueue.isEmpty()) {
            TreeNode current = nodeQueue.poll();
            int col = colQueue.poll();
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(current.val);
            if (current.left != null) {
                nodeQueue.offer(current.left);
                colQueue.offer(col - 1);
                min = Math.min(min, col - 1);
            }
            if (current.right != null) {
                nodeQueue.offer(current.right);
                colQueue.offer(col + 1);
                max = Math.max(max, col + 1);
            }
        }
        for (int i = min; i <= max; i++) {
            result.add(map.get(i));
        }
        return result;
    }
}