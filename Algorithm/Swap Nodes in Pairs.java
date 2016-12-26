/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = head;
        ListNode next = head.next;
        ListNode newHead = swapPairs(next.next);
        dummy.next = next;
        next.next = current;
        current.next = newHead;
        return dummy.next;
    }
}