/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        for (int i = 1; i <= k; i++) {
            if (current == null) {
                return head;
            }
            current = current.next;
        }
        ListNode newHead = reverseKGroup(current, k);
        ListNode slow = null, fast = head;
        for (int i = 1; i <= k; i++) {
            ListNode next = fast.next;
            fast.next = slow;
            slow = fast;
            fast = next;
        }
        head.next = newHead;
        return slow;
    }
}