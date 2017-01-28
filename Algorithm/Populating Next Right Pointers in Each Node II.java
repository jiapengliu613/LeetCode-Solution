/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return ;
        }
        TreeLinkNode head = null;
        TreeLinkNode prev = null;
        TreeLinkNode current = root;
        while (current != null) {
            while (current != null) {
                if (current.left != null) {
                    if (prev == null) {
                        head = current.left;
                    } else {
                        prev.next = current.left;
                    }
                    prev = current.left;
                }
                if (current.right != null) {
                    if (prev == null) {
                        head = current.right;
                    } else {
                        prev.next = current.right;
                    }
                    prev = current.right;
                }
                current = current.next;
            }
            current = head;
            prev = null;
            head = null;
        }
        return ;
    }
}