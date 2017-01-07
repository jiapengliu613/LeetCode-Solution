/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 1; i < m; i++) {
            prev = head;
            head = head.next;
        }
        ListNode tail = head;
        ListNode slow = null;
        ListNode next = null;
        for (int i = 1; i <= n - m + 1; i++) {
            next = head.next;
            head.next = slow;
            slow = head;
            head = next;
        }
        prev.next = slow;
        tail.next = next;
        return dummy.next;
    }
}