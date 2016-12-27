/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        List<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        for (int i = 0; i < queue.size(); i++) {
            TreeNode current = queue.get(i);
            if (current != null) {
                queue.add(current.left);
                queue.add(current.right);
            }
        }
        while (!queue.isEmpty() && queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }
        sb.append(queue.get(0).val);
        for (int i = 1; i < queue.size(); i++) {
            TreeNode current = queue.get(i);
            sb.append(',');
            if (current == null) {
                sb.append('#');
            } else {
                sb.append(current.val);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] array = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        boolean isLeft = true;
        List<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            TreeNode current = queue.get(index);
            if (array[i].equals("#")) {
                if (isLeft) {
                    current.left = null;
                } else {
                    current.right = null;
                }
            } else {
                TreeNode newNode = new TreeNode(Integer.parseInt(array[i]));
                queue.add(newNode);
                if (isLeft) {
                    current.left = newNode;
                } else {
                    current.right = newNode;
                }
            }
            if (!isLeft) {
                index++;
            }
            isLeft = !isLeft;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));