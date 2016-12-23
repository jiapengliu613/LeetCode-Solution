/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (fast != null) {
            fast = fast.next;
            head = head.next;
        }
        if (head.next != null) {
            head.next = head.next.next;
        } else {
            head.next = null;
        }
        return dummy.next;
    }
}