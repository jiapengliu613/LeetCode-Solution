/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode first = sortList(head);
        ListNode second = sortList(mid);
        ListNode dummy = new ListNode(-1);
        ListNode cur = new ListNode(-1);
        dummy.next = cur;
        cur = dummy;
        while (first != null && second != null) {
            if (first.val < second.val) {
                cur.next = first;
                first = first.next;
                cur = cur.next;
            } else {
                cur.next= second;
                second = second.next;
                cur = cur.next;
            }
        }
        while (first != null) {
            cur.next = first;
            cur = cur.next;
            first = first.next;
        }
        while (second != null) {
            cur.next = second;
            cur = cur.next;
            second = second.next;
        }
        return dummy.next;
    }
}