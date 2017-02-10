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
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        for (int i = 0; i < queue.size(); i++) {
            TreeNode current = queue.get(i);
            if (current!= null) {
                queue.add(current.left);
                queue.add(current.right);
            }
        }
        while (queue.size() >= 0 && queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }
        sb.append(queue.get(0).val);
        for (int i = 1; i < queue.size(); i++) {
            sb.append(",");
            TreeNode current = queue.get(i);
            if (current != null) {
                sb.append(current.val);
            } else {
                sb.append('#');
            }
        }
        //System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] array = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        int index = 0;
        boolean isLeft = true;
        for (int i = 1; i < array.length; i++) {
            if (array[i].equals("#")) {
                if (isLeft) {
                    queue.get(index).left = null;
                } else {
                    queue.get(index).right = null;
                }
                //TreeNode child = null;
            } else {
                TreeNode child = new TreeNode(Integer.parseInt(array[i]));
                if (isLeft) {
                    queue.get(index).left = child;
                } else {
                    queue.get(index).right = child;
                }
                queue.add(child);
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