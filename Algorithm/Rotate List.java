/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int n = listLength(head);
        if (k % n == 0) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //head = dummy;
        ListNode fast = dummy, slow = dummy;
        for (int i = 1; i <= k % n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        dummy.next = slow.next;
        slow.next = null;
        fast.next = head;
        return dummy.next;
    }
    private int listLength(ListNode node) {
        int result = 0;
        while (node != null) {
            node = node.next;
            result++;
        }
        return  result;
    }
}